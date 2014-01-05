/**
 * TODO
 * 上午02:13:27
 */
package cn.tinder.das.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tinder.das.dao.ArrangeModeDao;
import cn.tinder.das.dao.JobInfoDao;
import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.ArrangeModeDaoImpl;
import cn.tinder.das.dao.impl.JobInfoDaoImpl;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.po.ArrangeMode;
import cn.tinder.das.domain.po.JobInfo;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.exception.BasicException;
import cn.tinder.das.exception.message.BasicExceptionMessage;
import cn.tinder.das.exception.message.BasicExceptionMsg;
import cn.tinder.das.exception.message.DaoExceptionMessage;
import cn.tinder.das.service.BasicService;
import cn.tinder.das.service.data.GasAllInfo;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.constant.DaysInMonth;
import cn.tinder.das.util.constant.OperationConstant;
import cn.tinder.das.util.constant.PropertyName;

/**
 * @author Administrator
 * 
 */
public class BasicServiceImpl implements BasicService
{

    SystemUserDao systemUserDao = new SystemUserDaoImpl();

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getAllYear()
     */
    public List<String> getAllYear()
    {
        List<String> allYear = new ArrayList<String>();

        for (int i = Integer.valueOf(ConfigInformation
                .getPropertyByName(PropertyName.YEAR_START)); i < Integer
                .valueOf(ConfigInformation
                        .getPropertyByName(PropertyName.YEAR_END)); i++)
        {
            allYear.add(String.valueOf(i));
        }

        return allYear;
    }

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getAllMonth()
     */
    public List<String> getAllMonth()
    {
        // TODO Auto-generated method stub
        List<String> allMonth = new ArrayList<String>();
        for (int i = 0; i < Integer.valueOf(ConfigInformation
                .getPropertyByName(PropertyName.MONTH_NUM)); i++)
        {
            allMonth.add(String.valueOf(i + 1));
        }
        return allMonth;
    }

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getAllJob()
     */
    public List<String> getAllJob()
    // TODO 未测试
    {
        JobInfoDao jobInfoDao = new JobInfoDaoImpl();
        // 获取所有岗位名称
        List<String> allJobName = null;
        List<JobInfo> allJobInfo = null;
        try
        {
            allJobInfo = jobInfoDao.getAllJobInfo();

            if (allJobInfo == null)
            {
                // 探空处理
                throw new RuntimeException(
                        DaoExceptionMessage.SYSTEM_JOB_SEARCH);
            } else
            {
                allJobName = new ArrayList<String>();
                for (int i = 0; i < allJobInfo.size(); i++)
                {
                    allJobName.add(allJobInfo.get(i).getName());
                }
            }
            return allJobName;
        } catch (RuntimeException ex)
        {
            throw new RuntimeException(ex);
        }

    }

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getAllArrangeMode()
     */
    public List<String> getAllArrangeMode()
    {
        // TODO :TEST
        ArrangeModeDao arrangeModeDao = new ArrangeModeDaoImpl();

        // 获取全部排班方式
        List<String> allArrangeMode = null;
        List<ArrangeMode> arrangeMode = null;

        try
        {
            arrangeMode = arrangeModeDao.getAllMode();
            if (arrangeMode == null)
            {
                // 探空
                throw new RuntimeException(
                        DaoExceptionMessage.SYSTEM_ARRANGEMODE_SEARCH);
            } else
            {
                // 获取排版方式
                allArrangeMode = new ArrayList<String>();
                for (int i = 0; i < arrangeMode.size(); i++)
                {
                    allArrangeMode.add(arrangeMode.get(i).getName());
                }
            }
            return allArrangeMode;
        } catch (RuntimeException ex)
        {
            throw new RuntimeException(ex);
        }

    }

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getAllManger()
     */
    public List<String> getAllDepart()
    // Tested
    {
        // 获取所有经理
        List<SystemUser> managerList = null;
        List<String> allManager = null;
        try
        {

            managerList = systemUserDao.getUserByRole(ConfigInformation
                    .getPropertyByName(PropertyName.DEPART_USER));
            if (managerList == null)
            {
                // 探空处理
                throw new BasicException(
                        BasicExceptionMessage.EXCEPTION_MANAGERLIST_NULL);
            } else
            {
                // 转化数据格式
                allManager = new ArrayList<String>();
                for (int i = 0; i < managerList.size(); i++)
                {
                    allManager.add(managerList.get(i).getUserName());
                }
            }
            return allManager;
        } catch (RuntimeException ex)
        {
            throw new BasicException(ex);
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * cn.tinder.das.service.BasicService#getAllGasNameByManagerName(java.lang
     * .String)
     */
    public List<String> getAllGasNameByDepartName(String name)
    {
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        // 通过经管部获取全部的加油站
        List<String> allGasName = null;
        List<SystemUser> systemUser = null;

        try
        {
            systemUser = systemUserDao.getGasUserByDepart(name);
            if (systemUser.isEmpty())
            {

                throw new BasicException(
                        BasicExceptionMessage.EXCEPTION_SYSTEMUSER_NULL);
            } else
            {
                allGasName = new ArrayList<String>();
                for (int i = 0; i < systemUser.size(); i++)
                {
                    allGasName.add(systemUser.get(i).getUserName());
                }
            }
            return allGasName;
        } catch (RuntimeException ex)
        {
            throw new BasicException(ex);
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * cn.tinder.das.service.BasicService#getAllUserNameByRole(java.lang.String)
     */
    public List<String> getAllUserNameByRole(String role)
    {
        // TODO 未测试
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        // 通过经管部获取全部的用户
        List<String> allUserName = null;
        List<SystemUser> systemUser = null;
        try
        {

            systemUser = systemUserDao.getUserByRole(role);
            if (systemUser.isEmpty())
            {
                throw new BasicException(
                        BasicExceptionMessage.EXCEPTION_SYSTEMUSER_NULL);
            } else
            {
                allUserName = new ArrayList<String>();
                for (int i = 0; i < systemUser.size(); i++)
                {
                    allUserName.add(systemUser.get(i).getUserName());
                }
            }
            return allUserName;
        } catch (RuntimeException ex)
        {
            throw new BasicException(ex);
        }
    }

    public String getRoleByName(String name)
    {
        // TODO Auto-generated method stub
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        SystemUser systemUser = null;
        String role = null;

        try
        {
            systemUser = systemUserDao.getSystemUserByName(name);
            if (systemUser == null)
            {
                throw new BasicException(
                        BasicExceptionMessage.EXCEPTION_SYSTEMUSER_NULL);
            } else
            {
                role = systemUser.getRole();
            }
            return role;
        } catch (RuntimeException ex)
        {
            throw new BasicException(ex);
        }
    }

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getDepartByName(java.lang.String)
     */
    public String getDepartByName(String name)
    {
        // TODO Auto-generated method stub
        SystemUserDao systemUserDao = new SystemUserDaoImpl();
        SystemUser systemUser = systemUserDao.getSystemUserByName(name);
        if (systemUser == null)
        {
            throw new BasicException(
                    BasicExceptionMessage.EXCEPTION_SYSTEMUSER_NULL);
        } else
        {
            return systemUser.getDepartment();
        }

    }

    /*
     * (non-Javadoc)
     * @see cn.tinder.das.service.BasicService#getDepartMapGas()
     */
    public Map<String, List<String>> getDepartMapGas(List<String> departments)
    {
        Map<String, List<String>> departMapGas = new HashMap<String, List<String>>();
        SystemUserDao systemUserDao = new SystemUserDaoImpl();

        for (int i = 0; i < departments.size(); i++)
        {

            List<SystemUser> gasUser = null;

            gasUser = systemUserDao.getGasUserByDepart(departments.get(i));

            if (gasUser == null || gasUser.isEmpty())
            {

                throw new BasicException(
                        BasicExceptionMessage.EXCEPTION_SYSTEMUSER_NULL);

            } else
            {

                List<String> gasUsername = new ArrayList<String>();
                for (int j = 0; j < gasUser.size(); j++)
                {
                    gasUsername.add(gasUser.get(j).getUserName());
                }

                departMapGas.put(gasUser.get(i).getDepartment(), gasUsername);

            }

        }

        return departMapGas;
    }

    public String getMonthDays(String year, String month)
    {

        String yearMonth;
        if (month.length() == 1)
        {
            yearMonth = year + "0" + month;
        } else
        {
            yearMonth = year + month;
        }
        int n = DaysInMonth.getDays(yearMonth);
        String daysString = "";

        for (int i = 1; i < 32; i++)
        {
            if (i != 31)
            {
                if (i <= n)
                {
                    daysString = daysString + ",";
                } else
                {
                    daysString = daysString + "-,";
                }
            } else
            {
                if (i <= n)
                {
                    daysString = daysString + "";
                } else
                {
                    daysString = daysString + "-";
                }
            }
        }
        return daysString;
    }


}
