package cn.tinder.das.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.tinder.das.dao.CompanySumInfoDao;
import cn.tinder.das.dao.GasArrangeDataDao;
import cn.tinder.das.dao.GasInformationDao;
import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.CompanySumInfoDaoImpl;
import cn.tinder.das.dao.impl.GasArrangeDataDaoImpl;
import cn.tinder.das.dao.impl.GasInformationDaoImpl;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.exception.ExportException;
import cn.tinder.das.exception.message.DaoExceptionMessage;
import cn.tinder.das.exception.message.ExportExceptionMessage;
import cn.tinder.das.service.ExportService;
import cn.tinder.das.service.data.GasAllInfo;
import cn.tinder.das.service.data.GasStatus;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.ExportEcxel;
import cn.tinder.das.util.ExportExcelImpl;
import cn.tinder.das.util.LoginRole;
import cn.tinder.das.util.constant.PropertyName;

public class ExportServiceImpl extends BasicServiceImpl implements ExportService 
{

    private static final Log log = LogFactory.getLog(ExportServiceImpl.class);
    SystemUserDao userDao = new SystemUserDaoImpl();

    public String exportDataFile(ArrangeIndexForm arrangeIndex)
    {
        // 返回值：URL
        String url = null;

        // 配置index
        GasDataIndex index = new GasDataIndex();

        String yearMonth;
        String gasName;

        gasName = arrangeIndex.getGasName();
        yearMonth = getYearMonth(arrangeIndex.getYear(),arrangeIndex.getMonth());

        index.setYearMonth(yearMonth);
        index.setGasName(gasName);

        // DAO
        GasInformationDao gasInfoDao = new GasInformationDaoImpl();
        CompanySumInfoDao cpSumInfoDao = new CompanySumInfoDaoImpl();
        GasArrangeDataDao gasArgDataDao = new GasArrangeDataDaoImpl();
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        GasInformation gasInfo = null;
        CompanySumInfo cpSumInfo = null;
        List<GasArrangeData> gasArgData = null;
        SystemUser systemUser = null;
        List<CompanySumInfo> allCmpInfo = null;
        List<GasInformation> allGasInfo = null;

        // ExportExcel
        ExportEcxel exportExcel = new ExportExcelImpl();

        try
        {

            systemUser = systemUserDao.getSystemUserByName(gasName);
            log.info(systemUser);

            if (systemUser == null)
            {
                // 探空处理
                throw new ExportException(
                        DaoExceptionMessage.SYSTEM_SYSTEMUSER_SEARCH);
            } else
            {
                // 根据用户判断输出内容
                if (systemUser.getRole().equals(
                        ConfigInformation
                                .getPropertyByName(PropertyName.GAS_USER)))
                {
                    // 查询相关信息
                    gasInfo = gasInfoDao.getGasInfoByIndex(index);
                    cpSumInfo = cpSumInfoDao.getCompanyInfoByIndex(index);
                    gasArgData = gasArgDataDao
                            .getArrangeListByGasDataIndex(index);
                    // 探空验证
                    if ((cpSumInfo == null) || (gasArgData == null)
                            || (gasInfo == null))
                    {
                        // 探空处理
                        throw new ExportException(
                                DaoExceptionMessage.HAVE_NOT_CREATE_ARRANGE);

                    } else
                    {
                        // 打印加油站排班表
                        url = exportExcel.exoprtGasSheet(gasInfo, cpSumInfo,
                                gasArgData, systemUser,ConfigInformation
                                .getPropertyByName(PropertyName.MOD_PATH_GASSTATION));

                    }
                } else if (systemUser.getRole().equals(
                        ConfigInformation
                                .getPropertyByName(PropertyName.DEPART_USER))
                        || systemUser
                                .getRole()
                                .equals(ConfigInformation
                                        .getPropertyByName(PropertyName.MANAGER_USER)))
                {
                    // 查询相关信息
                    // 查询所有油站Index列表
                    allGasInfo = new ArrayList<GasInformation>();
                    allCmpInfo = new ArrayList<CompanySumInfo>();

                    allGasInfo = gasInfoDao.getGasInfoListByMonth(yearMonth);
                    allCmpInfo = cpSumInfoDao.getSumInfoByMonth(yearMonth);

                    List<SystemUser> userList = new ArrayList<SystemUser>();
                    userList = systemUserDao.getUserByRole(ConfigInformation
                            .getPropertyByName(PropertyName.GAS_USER));

                    if (allGasInfo.isEmpty())
                    {// 探空
                        throw new ExportException(
                                DaoExceptionMessage.SYSTEM_GASINFO_SEARCH);
                    } else if (allCmpInfo.isEmpty())
                    {
                        throw new ExportException(
                                DaoExceptionMessage.SYSTEM_COMPANYSUMINFO_SEARCH);
                    } else if (userList.isEmpty())
                    {
                        throw new ExportException(
                                DaoExceptionMessage.SYSTEM_SYSTEMUSER_SEARCH);
                    } else
                    {
                        // 导出一个含有油站编码的MAP
                        Map<String, String> gsNumMap = new HashMap<String, String>();
                        // 导出一个含有油站经管部的MAO
                        Map<String, String> gsDepMap = new HashMap<String, String>();
                        for (int i = 0; i < userList.size(); i++)
                        {
                            gsDepMap.put(userList.get(i).getUserName(),
                                    userList.get(i).getGasNum());
                        }

                        // 打印汇总数据
                        url = exportExcel.exoprtGasSheet(gasInfo, cpSumInfo,
                                gasArgData, systemUser,ConfigInformation
                                .getPropertyByName(PropertyName.MOD_PATH_GASSTATION));
                        return url;
                    }

                } else
                {
                    throw new ExportException(
                            DaoExceptionMessage.SYSTEM_ROLE_NOTEXIST);
                }
            }

        } catch (RuntimeException ex)
        {
            throw new ExportException(ex);

        }

        return url;
    }

    /*
     * (non-Javadoc)
     * @see
     * cn.tinder.das.service.ExportService#exportSumInfoFile(cn.tinder.das.struts
     * .form.ArrangeIndexForm)
     */
    public String exportSumInfoFile(ArrangeIndexForm arrangeIndex)
    {
        // TODO Auto-generated method stub
        // 处理字符串
        String year = arrangeIndex.getYear();
        String month = arrangeIndex.getMonth();
        if (month.length() == 1)
        {
            month = "0" + month;
        }
        String yearMonth = year + month;
        // 准备参数
        List<GasInformation> allGasInfo = new ArrayList<GasInformation>();
        List<CompanySumInfo> allCmpInfo = new ArrayList<CompanySumInfo>();
        Map<String, String> gsNumMap = new HashMap<String, String>();
        Map<String, String> gsDepMap = new HashMap<String, String>();

        GasInformationDao gasInfoDao = new GasInformationDaoImpl();
        CompanySumInfoDao cpSumInfoDao = new CompanySumInfoDaoImpl();
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        // 探空处理

        try
        {

            allGasInfo = gasInfoDao.getGasInfoListByMonth(yearMonth);// 此处已经处理了0的问题

            allCmpInfo = cpSumInfoDao.getSumInfoByMonth(yearMonth);

            List<SystemUser> user = systemUserDao
                    .getUserByRole(ConfigInformation
                            .getPropertyByName(PropertyName.GAS_USER));

            if (allCmpInfo == null)
            {
                // 探空处理
                throw new ExportException(
                        DaoExceptionMessage.SYSTEM_COMPANYSUMINFO_SEARCH);
            } else if (allGasInfo == null)
            {
                // 探空处理
                throw new ExportException(
                        DaoExceptionMessage.SYSTEM_GASINFO_SEARCH);
            } else if (user == null)
            {
                throw new ExportException(
                        DaoExceptionMessage.SYSTEM_GASSTATION_SEARCH);
            } else
            {

                // Map 生成
                for (int i = 0; i < user.size(); i++)
                {
                    gsNumMap.put(user.get(i).getUserName(), user.get(i)
                            .getGasNum());
                    gsDepMap.put(user.get(i).getUserName(), user.get(i)
                            .getDepartment());
                }

                ExportEcxel exportExcel = new ExportExcelImpl();
                String url = exportExcel.exoprtSumSheet(allGasInfo, allCmpInfo,
                        gsNumMap, gsDepMap, yearMonth);

                return url;
            }
        } catch (RuntimeException ex)
        {
            throw new ExportException(ex);
        }

    }

    public String exportByIndex(ArrangeIndexForm arrangeIndex)
    {
        // TODO Auto-generated method stub
        String User = arrangeIndex.getGasName();
        String url = "";
        SystemUserDao systemUserDao = new SystemUserDaoImpl();

        SystemUser systemUser = systemUserDao.getSystemUserByName(User);
        if (systemUser == null)
        {
            throw new ExportException(ExportExceptionMessage.EXPORT_ERR_NOSHEET);
        } else if (systemUser.getRole().equals(
                ConfigInformation.getPropertyByName(PropertyName.GAS_USER)))
        {
            url = exportDataFile(arrangeIndex);
        } else
        {
            url = exportSumInfoFile(arrangeIndex);
        }

        return url;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.service.ExportService#exportAllGasInfoByIndex(cn.tinder.das.struts.form.ArrangeIndexForm)
     */
    public String exportAllGasInfoByIndex(ArrangeIndexForm arrangeIndex)
    {
        List<String> gasNameList = this.getAllUserNameByRole(ConfigInformation.getPropertyByName(PropertyName.GAS_USER));
        
        List<GasAllInfo> gasAllInfoList = new ArrayList<GasAllInfo>();
        
        for(String gasName : gasNameList)
        {
            ArrangeIndexForm gasIndex = new ArrangeIndexForm();
            gasIndex.setYear(arrangeIndex.getYear());
            gasIndex.setMonth(arrangeIndex.getMonth());
            gasIndex.setDepartName(this.getDepartByName(gasName));
            gasIndex.setGasName(gasName);
            GasAllInfo gasAllInfo = this.getGasAllInfo(gasIndex);
            if(null != gasAllInfo)
            {
                gasAllInfoList.add(gasAllInfo);
            }
            else
            {
                log.warn("the data of gas index is null " + gasIndex);
            }
        }
        log.info(gasAllInfoList);
        
        ExportExcelImpl excelUtil = new ExportExcelImpl();
        String url = "";
        try
        {
            url = excelUtil.exoprtAllGasSheet(gasAllInfoList);
        }catch(Exception e)
        {
            log.error("export failed",e);
            log.info(url);
            throw new ExportException(ExportExceptionMessage.EXPORT_NONE_FILE);
        }
       
        log.info("export file is"+url);
        return url; 
    }
    

    /* (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getGasAllInfo(cn.tinder.das.struts.form.ArrangeIndexForm)
     */
    public GasAllInfo getGasAllInfo(ArrangeIndexForm arrangeIndex)
    {
        String url = null;

        // 配置index
        GasDataIndex index = new GasDataIndex();

        String yearMonth;
        String gasName;

        gasName = arrangeIndex.getGasName();
        yearMonth = getYearMonth(arrangeIndex.getYear(),arrangeIndex.getMonth());

        index.setYearMonth(yearMonth);
        index.setGasName(gasName);

        // DAO
        GasInformationDao gasInfoDao = new GasInformationDaoImpl();
        CompanySumInfoDao cpSumInfoDao = new CompanySumInfoDaoImpl();
        GasArrangeDataDao gasArgDataDao = new GasArrangeDataDaoImpl();
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        GasInformation gasInfo = null;
        CompanySumInfo sumInfo = null;
        List<GasArrangeData> gasArgData = null;
        SystemUser systemUser = null;
 
        
        systemUser = systemUserDao.getSystemUserByName(gasName);
        gasInfo = gasInfoDao.getGasInfoByIndex(index);
        sumInfo = cpSumInfoDao.getCompanyInfoByIndex(index);
        gasArgData = gasArgDataDao.getArrangeListByGasDataIndex(index);
        if((null == systemUser) || (null == gasInfo)
           ||(null == sumInfo) || (null == gasArgData))
        {
            return null;
        }
        
        GasAllInfo gasAllInfo = new GasAllInfo();
        gasAllInfo.setSystemUser(systemUser);
        gasAllInfo.setGasInfo(gasInfo);
        gasAllInfo.setGasArgData(gasArgData);
        gasAllInfo.setSumInfo(sumInfo);
        
        return gasAllInfo;
    }

    /**
     * @function
     * @param arrangeIndex
     * @return
     */
    private String getYearMonth(String year,String month)
    {
        String yearMonth;
        if (month.length() == 1)
        {
            yearMonth = year + "0" + month;
        } else
        {
            yearMonth = year + month;
        }
        return yearMonth;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.service.ExportService#getAllGasStatus(cn.tinder.das.struts.form.ArrangeIndexForm)
     */
    public List<GasStatus> getAllGasStatus(ArrangeIndexForm arrangeIndex)
    {
        List<GasStatus> gasStatusList = new ArrayList<GasStatus>();
        List<String> gasNames = getAllUserNameByRole(LoginRole.GAS);
        GasInformationDao gasInfoDao = new GasInformationDaoImpl();

        for(String gasName : gasNames)
        {
            GasStatus status = new GasStatus();
            GasDataIndex index = new GasDataIndex();
            index.setGasName(gasName);
            
            index.setYearMonth(getYearMonth(arrangeIndex.getYear(),arrangeIndex.getMonth()));
            if(null == gasInfoDao.getGasInfoByIndex(index))
            {
                status.setStatus("未排班");
            }else
            {
                status.setStatus("已排班");
            }
            status.setGasName(gasName);
            status.setDepartment(getDepartByName(gasName));
            gasStatusList.add(status);
            
        }
        return gasStatusList;
    }

   

}
