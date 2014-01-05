/**
 * TODO
 * 上午02:42:22
 */
package cn.tinder.das.dao;

import cn.tinder.das.domain.po.HolidayInfo;

/**
 * @author Administrator
 *
 */
public interface HolidayInfoDao
{

    public void addHolidayInfo(HolidayInfo holidayInfo);
    public void deleteHolidayInfo(HolidayInfo holidayInfo);
    //
    //获取某月的HolidayInfo
    public HolidayInfo getHolidayByYearMonth(String yearMonth);

   
}
