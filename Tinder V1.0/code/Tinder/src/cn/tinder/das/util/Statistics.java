package cn.tinder.das.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tinder.das.dao.HolidayInfoDao;
import cn.tinder.das.dao.impl.HolidayInfoDaoImpl;
import cn.tinder.das.domain.dependency.ModeInfo;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.HolidayInfo;
import cn.tinder.das.exception.ArrangeServiceException;
import cn.tinder.das.util.constant.DaysInMonth;

public class Statistics
{

    public float getHoursByTime(String time)
    {
        // 计算时间
        // 格式为 10:00~20:00
        float result = 0;
        // -----------------------
        // 去空格
        String t = time.replace(" ", "");
        // 取两个时间
        String t1 = t.split("~")[0];
        String t2 = t.split("~")[1];
        int h1 = Integer.valueOf(t1.split(":")[0]);
        int m1 = Integer.valueOf(t1.split(":")[1]);
        int h2 = Integer.valueOf(t2.split(":")[0]);
        int m2 = Integer.valueOf(t2.split(":")[1]);

        int h, m;
        // 分钟操作
        if (m2 - m1 < 0)
        {
            // 借位
            m = 60 + m2 - m1;
            h2 = h2 - 1;
            h = h2 - h1;
        } else
        {
            m = m2 - m1;
            h = h2 - h1;
        }
        if (h < 0)
        {
            h = h + 24;
        }
        if (h1 == h2 && m1 == m2)
        {
            if (h1 != 0)
            {
                result = 24;
            }
        } else if ((h1 == 0) && (m1 == 0) && (h1 == h2 && m1 == m2))
        {
            result = 0;
        } else
        {
            result = (float) h + (float) m / 60;
        }

        return result;

    }

    public void computeAllData(GasInformation gasInfo, CompanySumInfo sumInfo,
            List<GasArrangeData> gasArgData)
    {

        // 获得假期天数，表
        List<Integer> holidayList = getHolidayList(gasInfo);

        // 各班的时间计算 建立键值对
        Map<String, Float> modMap = getModMap(gasInfo);

        // 计算每行员工统计
        computeArgData(gasArgData, modMap, holidayList);

        computeGasInfo(gasInfo, gasArgData);

        computeCmpInfo(gasInfo, sumInfo, gasArgData, modMap);

    }

    private void computeCmpInfo(GasInformation gasInfo, CompanySumInfo sumInfo,
            List<GasArrangeData> gasArgData, Map<String, Float> modMap)
    {
        // 计算统计信息
        sumInfo.setIndex(gasInfo.getIndex());
        String restInfo = "";
        for (int i = 0; i < 31; i++)
        {
            int num = 0;
            for (int j = 0; j < gasArgData.size(); j++)
            {
                if (modMap.containsKey(gasArgData.get(j).getWorkDays()
                        .substring(i, i + 1)))
                {
                    ;
                } else
                {
                    num = num + 1;
                }
            }
            if (restInfo.isEmpty())
            {
                restInfo = String.valueOf(num);
            } else
            {
                restInfo = restInfo + "," + String.valueOf(num);
            }
        }

        sumInfo.setRestInfo(restInfo);

    }

    private void computeArgData(List<GasArrangeData> gasArgData,
            Map<String, Float> modMap, List<Integer> holidayList)
    {
        // 完成员工行统计
        for (int i = 0; i < gasArgData.size(); i++)
        {
            // 总天数统计
            String workDays = gasArgData.get(i).getWorkDays();

            float sumHour = 0;
            float holidayWorkHour = 0;

            for (int j = 0; j < workDays.length(); j++)
            {

                // 取某一天的排版安排
                String c = workDays.substring(j, j + 1);
                // 获取工作小时数

                if (modMap.containsKey(c))
                {
                    // 工作日

                    sumHour = sumHour + modMap.get(c); // 计算总工时

                    if (holidayList.contains(i + 1))
                    {
                        // 假期上班

                        holidayWorkHour = holidayWorkHour + modMap.get(c);// 计算假期工时

                    }
                } else
                {

                }

            }
            // 存入累计工作小时

            gasArgData.get(i).setSumHours((int) sumHour);

            // 计算工作天数

            gasArgData.get(i).setSumDays(FloatChange.meg(sumHour / 8));

            // 获得休息时间

            gasArgData.get(i).setRestDays(
                    FloatChange.meg(getDaysNumInMonth(gasArgData.get(i)
                            .getIndex().getYearMonth()))
                            - gasArgData.get(i).getSumDays());

            // 计算平均超时

            if (gasArgData.get(i).getRestDays() >= 8)
            {
                gasArgData.get(i).setOverHours(FloatChange.meg(0));
            } else
            {
                gasArgData.get(i)
                        .setOverHours(
                                FloatChange.meg((8 - gasArgData.get(i)
                                        .getRestDays()) * 8));
            }

            // 计算假期工作时间

            // 需要用到假期时间
            gasArgData.get(i).setHolidays(FloatChange.meg(holidayWorkHour));

        }

    }

    private void computeGasInfo(GasInformation gasInfo,
            List<GasArrangeData> gasArgData)
    {
        // 员工人数

        gasInfo.getStaffInfo().setStaffNum(gasArgData.size());// 员工数

        float sumRestStuff = 0;

        // 计算每班月均人数

        gasInfo.getGasArrange()
                .getaMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getaMode().getModeName()));
        gasInfo.getGasArrange()
                .getbMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getbMode().getModeName()));
        gasInfo.getGasArrange()
                .getcMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getcMode().getModeName()));
        gasInfo.getGasArrange()
                .getdMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getdMode().getModeName()));
        gasInfo.getGasArrange()
                .geteMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .geteMode().getModeName()));
        gasInfo.getGasArrange()
                .getfMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getfMode().getModeName()));
        gasInfo.getGasArrange()
                .getgMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getgMode().getModeName()));
        gasInfo.getGasArrange()
                .gethMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .gethMode().getModeName()));
        gasInfo.getGasArrange()
                .getzMode()
                .setModeAvgNum(
                        computeAvrMode(gasArgData, gasInfo.getGasArrange()
                                .getzMode().getModeName()));
        for (int i = 0; i < gasArgData.size(); i++)
        {

            sumRestStuff = sumRestStuff + gasArgData.get(i).getRestDays(); // 求总休息天数

        }

        // 计算班次时间

        gasInfo.getGasArrange()
                .getaMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getaMode()));
        gasInfo.getGasArrange()
                .getbMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getbMode()));
        gasInfo.getGasArrange()
                .getcMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getcMode()));
        gasInfo.getGasArrange()
                .getdMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getdMode()));
        gasInfo.getGasArrange()
                .geteMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().geteMode()));
        gasInfo.getGasArrange()
                .getfMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getfMode()));
        gasInfo.getGasArrange()
                .getgMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getgMode()));
        gasInfo.getGasArrange()
                .gethMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().gethMode()));
        gasInfo.getGasArrange()
                .getzMode()
                .setModeHours(
                        computeModeHour(gasInfo.getGasArrange().getzMode()));

        gasInfo.getStaffInfo().setAvgRestDay(
                FloatChange.meg(sumRestStuff / gasArgData.size())); // 月休息
                                                                    // 员工休息天数平均值

        gasInfo.getStaffInfo().setAvgRestStaff(
                FloatChange.meg(sumRestStuff
                        / (float) getDaysNumInMonth(gasArgData.get(0)
                                .getIndex().getYearMonth())));// 每天休息 按列计算求平均数

        gasInfo.getSaleInfo().setBusinessHours(
                (int) getHoursByTime(gasInfo.getSaleInfo().getBusinessTime()));

    }

    private float computeAvrMode(List<GasArrangeData> gasArgData, String name)
    {
        // 计算某一个班次的平均人数
        float sumday = 0;
        for (int i = 0; i < gasArgData.size(); i++)
        {
            String workdays = gasArgData.get(i).getWorkDays();

            for (int j = 0; j < workdays.length(); j++)
            {
                String c = workdays.substring(j, j + 1);

                if (c.equals(name))
                {

                    sumday = sumday + 1;
                } else
                {

                }
            }
        }

        return sumday / 31;
    }

    private Map<String, Float> getModMap(GasInformation gasInfo)
    {

        Map<String, Float> modMap = new HashMap<String, Float>();

        modMap.put(gasInfo.getGasArrange().getaMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getaMode()));

        modMap.put(gasInfo.getGasArrange().getbMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getbMode()));

        modMap.put(gasInfo.getGasArrange().getcMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getcMode()));

        modMap.put(gasInfo.getGasArrange().getdMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getdMode()));

        modMap.put(gasInfo.getGasArrange().geteMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().geteMode()));

        modMap.put(gasInfo.getGasArrange().getfMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getfMode()));

        modMap.put(gasInfo.getGasArrange().getgMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getgMode()));

        modMap.put(gasInfo.getGasArrange().gethMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().gethMode()));

        modMap.put(gasInfo.getGasArrange().getzMode().getModeName(),
                computeModeHour(gasInfo.getGasArrange().getzMode()));

        return modMap;
    }

    public List<Integer> getHolidayList(GasInformation gasInfo)
    {

        List<Integer> holidayList = new ArrayList<Integer>();
        // 需要的DAO
        HolidayInfoDao hldDao = new HolidayInfoDaoImpl();
        // 获取假期信息
        HolidayInfo holidayInfo = hldDao.getHolidayByYearMonth(gasInfo
                .getIndex().getYearMonth());// 格式：“1,13,12”

        if (holidayInfo == null)
        {
            // throw new
            // ArrangeServiceException(DaoExceptionMessage.SYSTEM_HOLIDAY_NOEXIST);
        } else
        {
            String holiday = holidayInfo.getHolidays();

            for (int j = 0; j < holiday.split(",").length; j++)
            {

                if (!holiday.split(",")[j].isEmpty())
                {
                    if (holiday.split(",")[j] != "-"
                            && holiday.split(",")[j] != "null")
                    {
                        try
                        {
                            holidayList
                                    .add(Integer.valueOf(holiday.split(",")[j]));
                        } catch (NumberFormatException ex)
                        {
                            ;
                        }
                    }
                }

            }
        }

        return holidayList;

    }

    public int getDaysNumInMonth(String string)
    {
        // 获取每月的天数
        return DaysInMonth.getDays(string);

    }

    public float computeModeHour(ModeInfo modInfo)
    {

        // 根据班类时段计算时间

        float hour = 0;
        for (int i = 0; i < 3; i++)
        {
            if (modInfo.getModeTime(i).isEmpty())
            {
                hour = 0 + hour;
            } else
            {
                hour = hour + getHoursByTime(modInfo.getModeTime(i));
            }
        }
        return FloatChange.meg(hour);
    }
}
