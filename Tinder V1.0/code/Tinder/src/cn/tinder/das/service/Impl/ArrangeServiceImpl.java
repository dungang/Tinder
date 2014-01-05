/**
 * TODO
 * 上午02:39:13
 */
package cn.tinder.das.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

import cn.tinder.das.dao.CompanySumInfoDao;
import cn.tinder.das.dao.GasArrangeDataDao;
import cn.tinder.das.dao.GasInformationDao;
import cn.tinder.das.dao.HolidayInfoDao;
import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.CompanySumInfoDaoImpl;
import cn.tinder.das.dao.impl.GasArrangeDataDaoImpl;
import cn.tinder.das.dao.impl.GasInformationDaoImpl;
import cn.tinder.das.dao.impl.HolidayInfoDaoImpl;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.dependency.ArrangeModeInfo;
import cn.tinder.das.domain.dependency.GasArrangeIndex;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.dependency.GasSaleInfo;
import cn.tinder.das.domain.dependency.GasStaffInfo;
import cn.tinder.das.domain.dependency.ModeInfo;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.HolidayInfo;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.exception.ArrangeServiceException;
import cn.tinder.das.exception.BasicException;
import cn.tinder.das.exception.checkOutException;
import cn.tinder.das.exception.message.ArrangeExceptionMsg;
import cn.tinder.das.exception.message.checkOutExceptionMsg;
import cn.tinder.das.service.ArrangeService;
import cn.tinder.das.struts.data.ArrangeDataForm;
import cn.tinder.das.struts.data.ArrangeModeForm;
import cn.tinder.das.struts.data.ArrangeSaleForm;
import cn.tinder.das.struts.data.ArrangeStaffForm;
import cn.tinder.das.struts.data.ModeForm;
import cn.tinder.das.struts.data.TimeForm;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.struts.form.GasArrangeInfoForm;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.Statistics;

/**
 * @author Administrator
 * 
 */
public class ArrangeServiceImpl extends BasicServiceImpl implements
        ArrangeService
{
    // private static final Log log =
    // LogFactory.getLog(ArrangeServiceImpl.class);

    private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
            .getLog(ArrangeServiceImpl.class);

    public GasArrangeInfoForm getHistoryArrangeInfo(String yearMonth,
            String gasName)
    {

        String year = yearMonth.substring(0, 4);

        String Month = yearMonth.substring(5, 6);

        int m = Integer.valueOf(Month);
        int y = Integer.valueOf(year);
        if (m - 1 == 0)
        {
            m = 12;
            y = y - 1;
        } else
        {
            m = m - 1;

        }

        year = String.valueOf(y);
        if (m > 9)
        {
            Month = String.valueOf(m);
        } else
        {
            Month = "0" + String.valueOf(m);
        }

        return getArrangeInfo(year + Month, gasName);

    }

    private ModeForm ModeChange(ModeInfo mode)
    {
        // TODO Auto-generated method stub
        ModeForm modeForm = new ModeForm();

        modeForm.setModeAvgNum(mode.getModeAvgNum());
        modeForm.setModeHours(mode.getModeHours());
        modeForm.setModeName(mode.getModeName());

        modeForm.setModeTime1(spltTime(mode.getModeTime(0)));
        modeForm.setModeTime2(spltTime(mode.getModeTime(1)));
        modeForm.setModeTime3(spltTime(mode.getModeTime(2)));

        return modeForm;
    }

    private TimeForm spltTime(String modeTime)
    {
        // Time -> Form
        log.info(modeTime);
        TimeForm tf = new TimeForm();
        try
        {
            tf.setStartHours(Integer.valueOf(modeTime.split("~")[0].split(":")[0]));
            tf.setStartMin(Integer.valueOf(modeTime.split("~")[0].split(":")[1]));
            tf.setEndHours(Integer.valueOf(modeTime.split("~")[1].split(":")[0]));
            tf.setEndMin(Integer.valueOf(modeTime.split("~")[1].split(":")[1]));
        } catch (Exception e)
        {
            log.warn("time format is wrong");
        }

        return tf;
    }

    public void saveArrangeInfomation(GasArrangeInfoForm arrangeInfo)
    {

        // log.info("Start Save ArrangeInfornamtion: " + arrangeInfo);
        // DAO
        CompanySumInfoDao sumInfoDao = new CompanySumInfoDaoImpl();
        GasArrangeDataDao gasArgDataDao = new GasArrangeDataDaoImpl();
        GasInformationDao gasInfoDao = new GasInformationDaoImpl();
        // 创建标准格式数据
        GasInformation gasInfo = new GasInformation();
        CompanySumInfo sumInfo = new CompanySumInfo();
        List<GasArrangeData> gasArgDataList = new ArrayList<GasArrangeData>();
        // 创建标准GasInfo
        // 创建索引

        ArrangeIndexForm dataIndex = arrangeInfo.getIndex();
        ArrangeSaleForm saleInfo = arrangeInfo.getSaleInfo();
        ArrangeStaffForm staffInfo = arrangeInfo.getStaffInfo();
        ArrangeModeForm arrangemodInfo = arrangeInfo.getArrangeInfo();
        List<ArrangeDataForm> arrlist = arrangeInfo.getArrangeDatas();

        // 探空
        if (dataIndex == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.INDEX_ERR);
        } else if (saleInfo == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.SALEINFO_ERR);
        } else if (arrangemodInfo == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.ARRINFO_ERR);
        } else
        {

            // gasInfo

            gasInfo.setIndex(new GasDataIndex());
            gasInfo.getIndex().setGasName(dataIndex.getGasName());

            /* 为时间加0 */
            String yearMonth = "";
            if (dataIndex.getMonth().length() == 1)
            {
                yearMonth = dataIndex.getYear() + "0" + dataIndex.getMonth();
            } else
            {
                yearMonth = dataIndex.getYear() + dataIndex.getMonth();
            }
            gasInfo.getIndex().setYearMonth(yearMonth);

            gasInfo.setSaleInfo(new GasSaleInfo());
            gasInfo.getSaleInfo().setBusinessHours(
                    (int) new Statistics().getHoursByTime(TimeString(saleInfo
                            .getBusinessTime())));
            gasInfo.getSaleInfo().setBusinessTime(
                    TimeString(saleInfo.getBusinessTime()));

            gasInfo.getSaleInfo().setCardScale(saleInfo.getCardScale());
            gasInfo.getSaleInfo().setSaleMoney(saleInfo.getSaleMoney());
            gasInfo.getSaleInfo().setSaleNum(saleInfo.getSaleNum());

            gasInfo.setStaffInfo(new GasStaffInfo());

            // SumInfo
            sumInfo.setIndex(gasInfo.getIndex());

            // GasArrange

            gasInfo.setGasArrange(new ArrangeModeInfo());
            gasInfo.getGasArrange().setArrangeName(
                    arrangemodInfo.getArrangeName());
            // a
            gasInfo.getGasArrange().setaMode(new ModeInfo());
            gasInfo.getGasArrange().getaMode().setModeName("A");
            gasInfo.getGasArrange().getaMode()
                    .setModeTime(mergeTime(arrangemodInfo.getaMode()));

            // b
            gasInfo.getGasArrange().setbMode(new ModeInfo());
            gasInfo.getGasArrange().getbMode().setModeName("B");
            gasInfo.getGasArrange().getbMode()
                    .setModeTime(mergeTime(arrangemodInfo.getbMode()));
            // c
            gasInfo.getGasArrange().setcMode(new ModeInfo());
            gasInfo.getGasArrange().getcMode().setModeName("C");
            gasInfo.getGasArrange().getcMode()
                    .setModeTime(mergeTime(arrangemodInfo.getcMode()));
            // d
            gasInfo.getGasArrange().setdMode(new ModeInfo());
            gasInfo.getGasArrange().getdMode().setModeName("D");
            gasInfo.getGasArrange().getdMode()
                    .setModeTime(mergeTime(arrangemodInfo.getdMode()));
            // e
            gasInfo.getGasArrange().seteMode(new ModeInfo());
            gasInfo.getGasArrange().geteMode().setModeName("E");
            gasInfo.getGasArrange().geteMode()
                    .setModeTime(mergeTime(arrangemodInfo.geteMode()));
            // f
            gasInfo.getGasArrange().setfMode(new ModeInfo());
            gasInfo.getGasArrange().getfMode().setModeName("F");
            gasInfo.getGasArrange().getfMode()
                    .setModeTime(mergeTime(arrangemodInfo.getfMode()));
            // g
            gasInfo.getGasArrange().setgMode(new ModeInfo());
            gasInfo.getGasArrange().getgMode().setModeName("G");
            gasInfo.getGasArrange().getgMode()
                    .setModeTime(mergeTime(arrangemodInfo.getgMode()));
            // h
            gasInfo.getGasArrange().sethMode(new ModeInfo());
            gasInfo.getGasArrange().gethMode().setModeName("H");
            gasInfo.getGasArrange().gethMode()
                    .setModeTime(mergeTime(arrangemodInfo.gethMode()));
            // z
            gasInfo.getGasArrange().setzMode(new ModeInfo());
            gasInfo.getGasArrange().getzMode().setModeName("Z");
            gasInfo.getGasArrange().getzMode()
                    .setModeTime(mergeTime(arrangemodInfo.getzMode()));

            for (int i = 0; i < arrlist.size(); i++)
            {
                GasArrangeData gasArrData = new GasArrangeData();

                GasArrangeIndex gasArrIndex = new GasArrangeIndex();
                gasArrIndex.setGasName(gasInfo.getIndex().getGasName());
                gasArrIndex.setStaffName(arrlist.get(i).getName());
                gasArrIndex.setYearMonth(gasInfo.getIndex().getYearMonth());

                gasArrData.setIndex(gasArrIndex);
                gasArrData.setJob(arrlist.get(i).getJob());
                // WorkDaysnull;

                String workDays[] = new String[32];

                workDays[0] = arrlist.get(i).getD1();
                workDays[1] = arrlist.get(i).getD2();
                workDays[2] = arrlist.get(i).getD3();
                workDays[3] = arrlist.get(i).getD4();
                workDays[4] = arrlist.get(i).getD5();
                workDays[5] = arrlist.get(i).getD6();
                workDays[6] = arrlist.get(i).getD7();
                workDays[7] = arrlist.get(i).getD8();
                workDays[8] = arrlist.get(i).getD9();
                workDays[9] = arrlist.get(i).getD10();
                workDays[10] = arrlist.get(i).getD11();
                workDays[11] = arrlist.get(i).getD12();
                workDays[12] = arrlist.get(i).getD13();
                workDays[13] = arrlist.get(i).getD14();
                workDays[14] = arrlist.get(i).getD15();
                workDays[15] = arrlist.get(i).getD16();
                workDays[16] = arrlist.get(i).getD17();
                workDays[17] = arrlist.get(i).getD18();
                workDays[18] = arrlist.get(i).getD19();
                workDays[19] = arrlist.get(i).getD20();
                workDays[20] = arrlist.get(i).getD21();
                workDays[21] = arrlist.get(i).getD22();
                workDays[22] = arrlist.get(i).getD23();
                workDays[23] = arrlist.get(i).getD24();
                workDays[24] = arrlist.get(i).getD25();
                workDays[25] = arrlist.get(i).getD26();
                workDays[26] = arrlist.get(i).getD27();
                workDays[27] = arrlist.get(i).getD28();
                workDays[28] = arrlist.get(i).getD29();
                workDays[29] = arrlist.get(i).getD30();
                workDays[30] = arrlist.get(i).getD31();
                String allworkDay = "";

                int restDay = 0;
                for (int j = 0; j < 31; j++)
                {
                    log.info("work day is " + workDays[j]);
                    if (workDays[j] == null || workDays[j].equals(""))
                    {
                        allworkDay = allworkDay + "\\";
                    } else
                    {
                        allworkDay = allworkDay + workDays[j];
                    }
                    if(!workDays[j].isEmpty())
                    {
                        if(!isWorkDay(workDays[j].charAt(0)))
                        {
                            restDay++;
                        }
                    }

                }
                if(restDay<4)
                {
                    throw new ArrangeServiceException(ArrangeExceptionMsg.REST_DAY_WRONG);
                }

                gasArrData.setWorkDays(allworkDay);
                gasArgDataList.add(gasArrData);

            }
        }

        // log.info("Start Statistics: ");

        // 统计
        Statistics statistics = new Statistics();
        statistics.computeAllData(gasInfo, sumInfo, gasArgDataList);
        // log.info("Statistics finished: " + gasInfo + " " + gasArgDataList);
 

        gasInfoDao.updateGasInformation(gasInfo);
        sumInfoDao.updateCompanySumInfo(sumInfo);
        gasArgDataDao.deleteGasArrangeDataByGas(gasInfo);
        
        for (int i = 0; i < gasArgDataList.size(); i++)
        {
            gasArgDataDao.updateGasArrangeData(gasArgDataList.get(i));
        }
         log.info("Save finished: " + gasInfo + " " + gasArgDataList);
    }

    private void checkout(GasArrangeInfoForm gsForm)
    {
        // TODO Auto-generated method stub
        // log.info("Start checkout.");
        // gasInfo-Index

        if (gsForm == null)
        {
            throw new checkOutException(checkOutExceptionMsg.FORM_NULL);
        } else
        {
            if (gsForm.getIndex() == null)
            {
                throw new checkOutException(checkOutExceptionMsg.FORM_NULL);
            } else
            {
                if (gsForm.getIndex().getGasName().isEmpty())
                {
                    throw new checkOutException(
                            checkOutExceptionMsg.INDEX_NAME_NULL);
                } else if (gsForm.getIndex().getMonth() == null
                        || gsForm.getIndex().getMonth().isEmpty())
                {
                    throw new checkOutException(
                            checkOutExceptionMsg.INDEX_MONTH_NULL);
                }

                if (gsForm.getIndex().getMonth() == null
                        || gsForm.getIndex().getMonth().isEmpty())
                {
                    throw new checkOutException(
                            checkOutExceptionMsg.INDEX_MONTH_NULL);
                }
            }
            if (gsForm.getArrangeDatas() == null
                    || gsForm.getArrangeDatas().size() == 0)
            {
                throw new checkOutException(checkOutExceptionMsg.FORM_NULL);
            } else
            {

            }
            if (gsForm.getArrangeInfo() == null)
            {
                throw new checkOutException(checkOutExceptionMsg.FORM_NULL);
            } else
            {
                // a
                checkOutTimeForm(gsForm.getArrangeInfo().getaMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getaMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getaMode()
                        .getModeTime3());
                // b
                checkOutTimeForm(gsForm.getArrangeInfo().getbMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getbMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getbMode()
                        .getModeTime3());
                // c
                checkOutTimeForm(gsForm.getArrangeInfo().getcMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getcMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getcMode()
                        .getModeTime3());
                // d
                checkOutTimeForm(gsForm.getArrangeInfo().getdMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getdMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getdMode()
                        .getModeTime3());
                // e
                checkOutTimeForm(gsForm.getArrangeInfo().geteMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().geteMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().geteMode()
                        .getModeTime3());
                // f
                checkOutTimeForm(gsForm.getArrangeInfo().getfMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getfMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getfMode()
                        .getModeTime3());
                // g
                checkOutTimeForm(gsForm.getArrangeInfo().getgMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getgMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getgMode()
                        .getModeTime3());
                // h
                checkOutTimeForm(gsForm.getArrangeInfo().gethMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().gethMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().gethMode()
                        .getModeTime3());

                checkOutTimeForm(gsForm.getArrangeInfo().getzMode()
                        .getModeTime1());
                checkOutTimeForm(gsForm.getArrangeInfo().getzMode()
                        .getModeTime2());
                checkOutTimeForm(gsForm.getArrangeInfo().getzMode()
                        .getModeTime3());

            }
            if (gsForm.getSaleInfo() == null)
            {
                throw new checkOutException(checkOutExceptionMsg.FORM_NULL);
            } else
            {
                if (gsForm.getSaleInfo().getBusinessTime() == null)
                {
                    throw new checkOutException(
                            checkOutExceptionMsg.BUSINESSTIME_ERR);

                } else
                {
                    checkOutTimeForm(gsForm.getSaleInfo().getBusinessTime());

                }

                if (gsForm.getStaffInfo() == null)
                {
                    throw new checkOutException(checkOutExceptionMsg.FORM_NULL);
                }
            }

        }
    }

    private void checkOutTimeForm(TimeForm t)
    {
        // TODO Auto-generated method stub
        if (t.getEndHours() < 0 || t.getEndHours() > 24
                || t.getStartHours() < 0 || t.getStartHours() > 24
                || t.getStartMin() < 0 || t.getStartMin() > 60
                || t.getEndMin() < 0 || t.getEndMin() > 60)
        {
            throw new checkOutException(checkOutExceptionMsg.TIME_NULL);
        }
    }

    private String mergeTime(ModeForm getaMode)
    {
        // TODO Auto-generated method stub

        if (getaMode.getModeTime2().getStartHours() == 00
                && getaMode.getModeTime2().getEndHours() == 00
                && getaMode.getModeTime2().getEndMin() == 00
                && getaMode.getModeTime2().getStartMin() == 00)
        {
            return TimeString(getaMode.getModeTime1());
        } else if (getaMode.getModeTime3().getStartHours() == 00
                && getaMode.getModeTime3().getEndHours() == 00
                && getaMode.getModeTime3().getEndMin() == 00
                && getaMode.getModeTime3().getStartMin() == 00)
        {
            return TimeString(getaMode.getModeTime1()) + ";"
                    + TimeString(getaMode.getModeTime2());
        } else
        {
            return TimeString(getaMode.getModeTime1()) + ";"
                    + TimeString(getaMode.getModeTime2()) + ";"
                    + TimeString(getaMode.getModeTime3());

        }
    }

    private String TimeString(TimeForm time)
    {
        // TODO Auto-generated method stub
        String stime = "";
        if (time.getStartHours() <= 9)
        {
            stime = "0" + time.getStartHours() + ":";
        } else
        {
            stime = time.getStartHours() + ":";
        }
        if (time.getStartMin() <= 9)
        {
            stime = stime + "0" + time.getStartMin() + "~";
        } else
        {
            stime = stime + time.getStartMin() + "~";
        }
        if (time.getEndHours() <= 9)
        {
            stime = stime + "0" + time.getEndHours() + ":";
        } else
        {
            stime = stime + time.getEndHours() + ":";
        }
        if (time.getEndMin() <= 9)
        {
            stime = stime + "0" + time.getEndMin();
        } else
        {
            stime = stime + time.getEndMin();
        }
        return stime;
    }

    public GasArrangeInfoForm getArrangeInfo(String yearMonth, String gasName)
    {
        // log.info("Start  save ArrangeInfo.");
        CompanySumInfoDao sumInfoDao = new CompanySumInfoDaoImpl();
        GasArrangeDataDao gasArgDataDao = new GasArrangeDataDaoImpl();
        GasInformationDao gasInfoDao = new GasInformationDaoImpl();
        SystemUserDao systemUserDao = new SystemUserDaoImpl();

        GasDataIndex gasDataIndex = new GasDataIndex();
        gasDataIndex.setGasName(gasName);
        gasDataIndex.setYearMonth(yearMonth);

        GasInformation gasInfo = gasInfoDao.getGasInfoByIndex(gasDataIndex);
        CompanySumInfo sumInfo = sumInfoDao.getCompanyInfoByIndex(gasDataIndex);
        List<GasArrangeData> gasArgDataList = gasArgDataDao
                .getArrangeListByGasDataIndex(gasDataIndex);
        SystemUser user = systemUserDao.getSystemUserByName(gasName);

        // 探空
        if (gasInfo == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.INDEX_ERR);
        } else if (sumInfo == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.SALEINFO_ERR);
        } else if (gasArgDataList == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.ARRINFO_ERR);
        } else if (user == null)
        {
            throw new ArrangeServiceException(ArrangeExceptionMsg.USER_ERR);
        } else
        {

            // 要写入的文件
            GasArrangeInfoForm gasArrInfoForm = new GasArrangeInfoForm();

            gasArrInfoForm.setArrangeInfo(new ArrangeModeForm());
            gasArrInfoForm.getArrangeInfo().setaMode(
                    ModeChange(gasInfo.getGasArrange().getaMode()));
            gasArrInfoForm.getArrangeInfo().setbMode(
                    ModeChange(gasInfo.getGasArrange().getbMode()));
            gasArrInfoForm.getArrangeInfo().setcMode(
                    ModeChange(gasInfo.getGasArrange().getcMode()));
            gasArrInfoForm.getArrangeInfo().setdMode(
                    ModeChange(gasInfo.getGasArrange().getdMode()));
            gasArrInfoForm.getArrangeInfo().seteMode(
                    ModeChange(gasInfo.getGasArrange().geteMode()));
            gasArrInfoForm.getArrangeInfo().setfMode(
                    ModeChange(gasInfo.getGasArrange().getfMode()));
            gasArrInfoForm.getArrangeInfo().setgMode(
                    ModeChange(gasInfo.getGasArrange().getgMode()));
            gasArrInfoForm.getArrangeInfo().sethMode(
                    ModeChange(gasInfo.getGasArrange().gethMode()));
            gasArrInfoForm.getArrangeInfo().setzMode(
                    ModeChange(gasInfo.getGasArrange().getzMode()));
            gasArrInfoForm.getArrangeInfo().setArrangeName(
                    gasInfo.getGasArrange().getArrangeName());

            gasArrInfoForm.setIndex(new ArrangeIndexForm());
            gasArrInfoForm.getIndex().setDepartName(user.getDepartment());
            gasArrInfoForm.getIndex().setGasName(gasName);
            gasArrInfoForm.getIndex().setYear(yearMonth.substring(0, 4));
            gasArrInfoForm.getIndex().setMonth(yearMonth.substring(4, 6));
            gasArrInfoForm.setSaleInfo(new ArrangeSaleForm());
            gasArrInfoForm.getSaleInfo().setBusinessHours(
                    gasInfo.getSaleInfo().getBusinessHours());
            gasArrInfoForm.getSaleInfo().setCardScale(
                    gasInfo.getSaleInfo().getCardScale());
            gasArrInfoForm.getSaleInfo().setSaleMoney(
                    gasInfo.getSaleInfo().getSaleMoney());
            gasArrInfoForm.getSaleInfo().setSaleNum(
                    gasInfo.getSaleInfo().getSaleNum());
            gasArrInfoForm.getSaleInfo().setBusinessTime(
                    spltTime(gasInfo.getSaleInfo().getBusinessTime()));
            gasArrInfoForm.getSaleInfo().setBusinessHours(
                    gasInfo.getSaleInfo().getBusinessHours());
            gasArrInfoForm.setStaffInfo(new ArrangeStaffForm());
            gasArrInfoForm.getStaffInfo().setAvgRestDay(
                    gasInfo.getStaffInfo().getAvgRestDay());
            gasArrInfoForm.getStaffInfo().setAvgRestStaff(
                    gasInfo.getStaffInfo().getAvgRestStaff());
            gasArrInfoForm.getStaffInfo().setStaffNum(
                    gasInfo.getStaffInfo().getStaffNum());
            gasArrInfoForm.setArrangeDatas(new ArrayList<ArrangeDataForm>());
            for (int i = 0; i < gasArgDataList.size(); i++)
            {
                ArrangeDataForm arrDataFrom = new ArrangeDataForm();
                String workDays = gasArgDataList.get(i).getWorkDays();

                arrDataFrom.setD1(workDays.substring(0, 1));
                arrDataFrom.setD2(workDays.substring(1, 2));
                arrDataFrom.setD3(workDays.substring(2, 3));
                arrDataFrom.setD4(workDays.substring(3, 4));
                arrDataFrom.setD5(workDays.substring(4, 5));
                arrDataFrom.setD6(workDays.substring(5, 6));
                arrDataFrom.setD7(workDays.substring(6, 7));
                arrDataFrom.setD8(workDays.substring(7, 8));
                arrDataFrom.setD9(workDays.substring(8, 9));
                arrDataFrom.setD10(workDays.substring(9, 10));
                arrDataFrom.setD11(workDays.substring(10, 11));
                arrDataFrom.setD12(workDays.substring(11, 12));
                arrDataFrom.setD13(workDays.substring(12, 13));
                arrDataFrom.setD14(workDays.substring(13, 14));
                arrDataFrom.setD15(workDays.substring(14, 15));
                arrDataFrom.setD16(workDays.substring(15, 16));
                arrDataFrom.setD17(workDays.substring(16, 17));
                arrDataFrom.setD18(workDays.substring(17, 18));
                arrDataFrom.setD19(workDays.substring(18, 19));
                arrDataFrom.setD20(workDays.substring(19, 20));
                arrDataFrom.setD21(workDays.substring(20, 21));
                arrDataFrom.setD22(workDays.substring(21, 22));
                arrDataFrom.setD23(workDays.substring(22, 23));
                arrDataFrom.setD24(workDays.substring(23, 24));
                arrDataFrom.setD25(workDays.substring(24, 25));
                arrDataFrom.setD26(workDays.substring(25, 26));
                arrDataFrom.setD27(workDays.substring(26, 27));
                arrDataFrom.setD28(workDays.substring(27, 28));
                arrDataFrom.setD29(workDays.substring(28, 29));
                arrDataFrom.setD30(workDays.substring(29, 30));
                arrDataFrom.setD31(workDays.substring(30, 31));
                arrDataFrom.setHolidays(gasArgDataList.get(i).getHolidays());
                arrDataFrom.setJob(gasArgDataList.get(i).getJob());
                arrDataFrom.setName(gasArgDataList.get(i).getIndex()
                        .getStaffName());
                arrDataFrom.setHolidays(gasArgDataList.get(i).getHolidays());
                arrDataFrom.setRestDays(gasArgDataList.get(i).getRestDays());
                arrDataFrom.setSumDays(gasArgDataList.get(i).getSumDays());
                arrDataFrom.setSumHours(gasArgDataList.get(i).getSumHours());
                arrDataFrom.setSerialNum(i);
                gasArrInfoForm.getArrangeDatas().add(arrDataFrom);
            }
            log.info("Finished save ArrangeInfo." + gasArrInfoForm);
            return gasArrInfoForm;
        }
    }

    public String getHolidaysByYearMonth(String year, String month)
    {
        // TODO Auto-generated method stub

        HolidayInfoDao hldInfoDao = new HolidayInfoDaoImpl();
        HolidayInfo hldInfo = null;

        String yearMonth = null;
        if (month.length() == 1)
        {
            yearMonth = year + "0" + month;
        } else
        {
            yearMonth = year + month;
        }
        try
        {
            hldInfo = hldInfoDao.getHolidayByYearMonth(yearMonth);
        } catch (RuntimeException ex)
        {
            throw new BasicException(ex);
        }
        if (hldInfo == null || hldInfo.equals(""))
        {
            return ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";
        } else
        {
            return hldInfo.getHolidays();
        }

    }
    
    boolean isWorkDay(char day)
    {
        if(('a'<=day && day <= 'h') || ('A'<=day && day <= 'H'))
        {
            return true;
        }
        log.info("the day is not a work day");
        return false;
    }

}
