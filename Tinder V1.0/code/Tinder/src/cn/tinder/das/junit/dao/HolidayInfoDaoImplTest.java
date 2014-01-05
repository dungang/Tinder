/**
 * TODO
 * 上午02:39:32
 */
package cn.tinder.das.junit.dao;

import org.junit.Test;

import cn.tinder.das.dao.HolidayInfoDao;
import cn.tinder.das.dao.impl.HolidayInfoDaoImpl;
import cn.tinder.das.domain.po.HolidayInfo;

/**
 * @author Administrator
 *
 */
public class HolidayInfoDaoImplTest
{

    HolidayInfoDao holidayDao = new HolidayInfoDaoImpl();
    /**
     * Test method for {@link cn.tinder.das.dao.impl.HolidayInfoDaoImpl#addHolidayInfo(cn.tinder.das.domain.po.HolidayInfo)}.
     */
    @Test
    public void testAddHolidayInfo()
    {
        HolidayInfo holidayInfo = new HolidayInfo();
        holidayInfo.setHolidays("1111111111");
        holidayInfo.setYearMonth("201301");
        try
        {
            holidayDao.addHolidayInfo(holidayInfo);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.HolidayInfoDaoImpl#deleteHolidayInfo(cn.tinder.das.domain.po.HolidayInfo)}.
     */
    @Test
    public void testDeleteHolidayInfo()
    {
        HolidayInfo holidayInfo = new HolidayInfo();
        holidayInfo.setHolidays("1111111111");
        holidayInfo.setYearMonth("201301");
         
        try
        {
            holidayDao.deleteHolidayInfo(holidayInfo);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.HolidayInfoDaoImpl#getHolidayByYearMonth(java.lang.String)}.
     */
    @Test
    public void testGetHolidayByYearMonth()
    {
        HolidayInfo holidayInfo = new HolidayInfo();
        holidayInfo.setHolidays("22222222222");
        holidayInfo.setYearMonth("201301");
         
        try
        {
            holidayInfo = holidayDao.getHolidayByYearMonth("201301");
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        System.out.println(holidayInfo);
        assert(true);
    }

}
