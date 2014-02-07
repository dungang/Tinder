/**
 * TODO
 * 下午09:57:20
 */
package cn.tinder.das.junit.dao;

import java.util.List;

import org.junit.Test;

import cn.tinder.das.dao.GasInformationDao;
import cn.tinder.das.dao.impl.GasInformationDaoImpl;
import cn.tinder.das.domain.dependency.ArrangeModeInfo;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.dependency.GasSaleInfo;
import cn.tinder.das.domain.dependency.GasStaffInfo;
import cn.tinder.das.domain.po.GasInformation;

/**
 * @author Administrator
 *
 */
public class GasInformationDaoImplTest
{

    GasInformationDao sumDao = new GasInformationDaoImpl();
    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasInformationDaoImpl#addGasInformation(cn.tinder.das.domain.po.GasInformation)}.
     */
    @Test
    public void testAddGasInformation()
    {
        GasInformation gasInfo = new GasInformation();
        gasInfo.setIndex(new GasDataIndex());
        gasInfo.getIndex().setGasName("东莞");
        gasInfo.getIndex().setYearMonth("20130102");
        gasInfo.setSaleInfo(new GasSaleInfo());
        gasInfo.getSaleInfo().setBusinessHours(23);
        gasInfo.getSaleInfo().setBusinessTime("23:30");
        gasInfo.getSaleInfo().setCardScale(50);
        gasInfo.getSaleInfo().setSaleMoney(30000);
        gasInfo.getSaleInfo().setSaleNum(30);
        gasInfo.setStaffInfo(new GasStaffInfo());
        gasInfo.getStaffInfo().setAllDayRest(3);
        gasInfo.getStaffInfo().setAvgRestDay(4);
        gasInfo.getStaffInfo().setAvgRestStaff(6);
        gasInfo.getStaffInfo().setStaffNum(9);
        gasInfo.setGasArrange(new ArrangeModeInfo());
        gasInfo.getGasArrange().setArrangeName("三班");
         
         
        
        try
        {
            sumDao.addGasInformation(gasInfo);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
            return;
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasInformationDaoImpl#deleteGasInformation(cn.tinder.das.domain.po.GasInformation)}.
     */
    @Test
    public void testDeleteGasInformation()
    {
        GasInformation gasInfo = new GasInformation();
        gasInfo.setIndex(new GasDataIndex());
        gasInfo.getIndex().setGasName("东莞");
        gasInfo.getIndex().setYearMonth("20130102");
         
        try
        {
            
            sumDao.deleteGasInformation(gasInfo);
            assert(false);
        }catch(Exception e)
        {
           
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
        }
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasInformationDaoImpl#updateGasInformation(cn.tinder.das.domain.po.GasInformation)}.
     */
    @Test
    public void testUpdateGasInformation()
    {
        GasInformation gasInfo = new GasInformation();
        gasInfo.setIndex(new GasDataIndex());
        gasInfo.getIndex().setGasName("东莞");
        gasInfo.getIndex().setYearMonth("20130102");
        gasInfo.setSaleInfo(new GasSaleInfo());
        gasInfo.getSaleInfo().setBusinessHours(2);
        gasInfo.getSaleInfo().setBusinessTime("23:30");
        gasInfo.getSaleInfo().setCardScale(50);
        gasInfo.getSaleInfo().setSaleMoney(30000);
        gasInfo.getSaleInfo().setSaleNum(30);
        gasInfo.setStaffInfo(new GasStaffInfo());
        gasInfo.getStaffInfo().setAllDayRest(3);
        gasInfo.getStaffInfo().setAvgRestDay(4);
        gasInfo.getStaffInfo().setAvgRestStaff(6);
        gasInfo.getStaffInfo().setStaffNum(9);
        gasInfo.setGasArrange(new ArrangeModeInfo());
        gasInfo.getGasArrange().setArrangeName("三班");
        
        try
        {
            sumDao.updateGasInformation(gasInfo);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasInformationDaoImpl#getGasInfoByIndex(cn.tinder.das.domain.dependency.GasDataIndex)}.
     */
    @Test
    public void testGetGasInfoByIndex()
    {
        GasInformation sumInfo;
        GasDataIndex index = new GasDataIndex();
        index.setGasName("东莞");
        index.setYearMonth("20130102");
        try
        {
            sumInfo = sumDao.getGasInfoByIndex(index);
            System.out.println("1");
        }catch(Exception e)
        {
            System.out.println(e.getMessage()+e.getCause());
            System.out.println("2");
            assert(false);
            return;
            
        }
        if(sumInfo == null)
        {
            System.out.println("failed");
            assert(false); 
        }
        else
        {
            System.out.println(sumInfo);
            assert(true);
        }
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.GasInformationDaoImpl#getGasInfoListByMonth(java.lang.String)}.
     */
    @Test
    public void testGetGasInfoListByMonth()
    {
        GasInformation gasInfo = new GasInformation();
        gasInfo.setIndex(new GasDataIndex());
        gasInfo.getIndex().setGasName("东莞");
        gasInfo.getIndex().setYearMonth("20130102");
        gasInfo.setSaleInfo(new GasSaleInfo());
        gasInfo.getSaleInfo().setBusinessHours(2);
        gasInfo.getSaleInfo().setBusinessTime("23:30");
        gasInfo.getSaleInfo().setCardScale(50);
        gasInfo.getSaleInfo().setSaleMoney(30000);
        gasInfo.getSaleInfo().setSaleNum(30);
        gasInfo.setStaffInfo(new GasStaffInfo());
        gasInfo.getStaffInfo().setAllDayRest(3);
        gasInfo.getStaffInfo().setAvgRestDay(4);
        gasInfo.getStaffInfo().setAvgRestStaff(6);
        gasInfo.getStaffInfo().setStaffNum(9);
        gasInfo.setGasArrange(new ArrangeModeInfo());
        gasInfo.getGasArrange().setArrangeName("三班");
        sumDao.addGasInformation(gasInfo);
        gasInfo = new GasInformation();
        gasInfo.setIndex(new GasDataIndex());
        gasInfo.getIndex().setGasName("莞");
        gasInfo.getIndex().setYearMonth("20130102");
        gasInfo.setSaleInfo(new GasSaleInfo());
        gasInfo.getSaleInfo().setBusinessHours(2);
        gasInfo.getSaleInfo().setBusinessTime("23:30");
        gasInfo.getSaleInfo().setCardScale(50);
        gasInfo.getSaleInfo().setSaleMoney(30000);
        gasInfo.getSaleInfo().setSaleNum(30);
        gasInfo.setStaffInfo(new GasStaffInfo());
        gasInfo.getStaffInfo().setAllDayRest(3);
        gasInfo.getStaffInfo().setAvgRestDay(4);
        gasInfo.getStaffInfo().setAvgRestStaff(6);
        gasInfo.getStaffInfo().setStaffNum(9);
        gasInfo.setGasArrange(new ArrangeModeInfo());
        gasInfo.getGasArrange().setArrangeName("三班");
        sumDao.addGasInformation(gasInfo);
        List<GasInformation> gasInfos;
        try
        {
            gasInfos = sumDao.getGasInfoListByMonth("20130102");
        }catch(Exception e)
        {
            assert(false);
            return;
            
        }
        assert(true);        
        System.out.println(gasInfos);
        
    }

}
