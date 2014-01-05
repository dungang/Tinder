/**
 * TODO
 * 下午09:56:52
 */
package cn.tinder.das.junit.dao;

import java.util.List;

import org.junit.Test;

import cn.tinder.das.dao.GasArrangeDataDao;
import cn.tinder.das.dao.impl.GasArrangeDataDaoImpl;
import cn.tinder.das.domain.dependency.GasArrangeIndex;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;

/**
 * @author Administrator
 *
 */
public class GasArrangeDataDaoImplTest
{

    GasArrangeDataDao sumDao = new GasArrangeDataDaoImpl();
    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasArrangeDataDaoImpl#addGasArrangeData(cn.tinder.das.domain.po.GasArrangeData)}.
     */
    @Test
    public void testAddGasArrangeData()
    {
        GasArrangeData arrangeData = new GasArrangeData();
        arrangeData.setIndex(new GasArrangeIndex());
        arrangeData.getIndex().setGasName("东莞");
        arrangeData.getIndex().setYearMonth("20130102");
        arrangeData.getIndex().setStaffName("aa");
        arrangeData.setHolidays(4);
        arrangeData.setJob("");
        arrangeData.setOverHours(25);
        arrangeData.setRestDays(3);
        arrangeData.setSumHours(5);
        arrangeData.setSumDays(2);
        arrangeData.setWorkDays("FDADDFAFA");
         
        try
        {
            sumDao.addGasArrangeData(arrangeData);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
            return;
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasArrangeDataDaoImpl#deleteGasArrangeData(cn.tinder.das.domain.po.GasArrangeData)}.
     */
    @Test
    public void testDeleteGasArrangeData()
    {
        GasArrangeData arrangeData = new GasArrangeData();
        arrangeData.setIndex(new GasArrangeIndex());
        arrangeData.getIndex().setGasName("东莞");
        arrangeData.getIndex().setYearMonth("20130102");
        arrangeData.getIndex().setStaffName("bb");
        try
        {
            assert(false);
            sumDao.deleteGasArrangeData(arrangeData);
        }catch(Exception e)
        {
           
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
        }
    }
    @Test
    public void testDeleteGasArrangeDatabyGas()
    {
        GasInformation gasInfo = new GasInformation();
        gasInfo.setIndex(new GasDataIndex());
        gasInfo.getIndex().setGasName("下桥加油站");
        gasInfo.getIndex().setYearMonth("201301");
        try
        {
            sumDao.deleteGasArrangeDataByGas(gasInfo);
        }catch(Exception e)
        {
           
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
        }
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasArrangeDataDaoImpl#updateGasArrangeData(cn.tinder.das.domain.po.GasArrangeData)}.
     */
    @Test
    public void testUpdateGasArrangeData()
    {
        GasArrangeData arrangeData = new GasArrangeData();
        arrangeData.setIndex(new GasArrangeIndex());
        arrangeData.getIndex().setGasName("东莞");
        arrangeData.getIndex().setYearMonth("20130102");
        arrangeData.getIndex().setStaffName("bb");
        arrangeData.setHolidays(4);
        arrangeData.setJob("");
        arrangeData.setOverHours(25);
        arrangeData.setRestDays(3);
        arrangeData.setSumHours(5);
        arrangeData.setSumDays(2);
        arrangeData.setWorkDays("afafafaf");
        try
        {
            sumDao.updateGasArrangeData(arrangeData);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasArrangeDataDaoImpl#getArrangeByArrangeIndex(cn.tinder.das.domain.dependency.GasArrangeIndex)}.
     */
    @Test
    public void testGetArrangeByArrangeIndex()
    {
        GasArrangeData arrangeData;
        GasArrangeIndex index = new GasArrangeIndex();
        index.setGasName("东莞");
        index.setYearMonth("20130102");
        try
        {
            arrangeData = sumDao.getArrangeByArrangeIndex(index);
            System.out.println("1");
        }catch(Exception e)
        {
            System.out.println(e.getMessage()+e.getCause());
            System.out.println("2");
            assert(false);
            return;
            
        }
        if(arrangeData == null)
        {
            System.out.println("failed");
            assert(false); 
        }
        else
        {
            System.out.println(arrangeData);
            assert(true);
        }
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasArrangeDataDaoImpl#getArrangeListByGasDataIndex(cn.tinder.das.domain.dependency.GasDataIndex)}.
     */
    @Test
    public void testGetArrangeListByGasDataIndex()
    {
        GasArrangeData arrangeData = new GasArrangeData();
        arrangeData.setIndex(new GasArrangeIndex());
        arrangeData.getIndex().setGasName("东莞");
        arrangeData.getIndex().setYearMonth("20130102");
        arrangeData.getIndex().setStaffName("dd");
        arrangeData.setHolidays(4);
        arrangeData.setJob("");
        arrangeData.setOverHours(25);
        arrangeData.setRestDays(3);
        arrangeData.setSumHours(5);
        arrangeData.setSumDays(2);
        arrangeData.setWorkDays("FDADDFAFA");
        sumDao.addGasArrangeData(arrangeData);

        arrangeData = new GasArrangeData();
        arrangeData.setIndex(new GasArrangeIndex());
        arrangeData.getIndex().setGasName("东莞");
        arrangeData.getIndex().setYearMonth("20130102");
        arrangeData.getIndex().setStaffName("ff");
        arrangeData.setHolidays(4);
        arrangeData.setJob("");
        arrangeData.setOverHours(25);
        arrangeData.setRestDays(3);
        arrangeData.setSumHours(5);
        arrangeData.setSumDays(2);
        arrangeData.setWorkDays("FDADDFAFA");
        sumDao.addGasArrangeData(arrangeData);
        GasDataIndex index = new GasDataIndex();
        index.setGasName("东莞");
        index.setYearMonth("20130102");
        List<GasArrangeData> arrangeDatas; 
        arrangeDatas = sumDao.getArrangeListByGasDataIndex(index);
        System.out.println(arrangeDatas);

    }

}
