/**
 * TODO
 * 上午01:31:37
 */
package cn.tinder.das.junit.dao;

import java.util.List;

import org.junit.Test;

import cn.tinder.das.dao.CompanySumInfoDao;
import cn.tinder.das.dao.impl.CompanySumInfoDaoImpl;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.CompanySumInfo;

/**
 * @author Administrator
 *
 */
public class CompanySumInfoDaoImplTest
{

    CompanySumInfoDao sumDao = new CompanySumInfoDaoImpl();
    /**
     * Test method for {@link cn.tinder.das.dao.impl.CompanySumInfoDaoImpl#addCompanySunInfo(cn.tinder.das.domain.po.CompanySumInfo)}.
     */
    @Test
    public void testAddCompanySumInfo()
    {
        CompanySumInfo sumInfo = new CompanySumInfo();
        sumInfo.setIndex(new GasDataIndex());
        sumInfo.getIndex().setGasName("东莞");
        sumInfo.getIndex().setYearMonth("20130102");
        sumInfo.setRestInfo("12,2,2,2,2,22,2,");
        try
        {
            sumDao.addCompanySumInfo(sumInfo);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
            return;
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.CompanySumInfoDaoImpl#deleteCompanySumInfo(cn.tinder.das.domain.po.CompanySumInfo)}.
     */
    @Test
    public void testDeleteCompanySumInfo()
    {
        CompanySumInfo sumInfo = new CompanySumInfo();
        sumInfo.setIndex(new GasDataIndex());
        sumInfo.getIndex().setGasName("东莞");
        sumInfo.getIndex().setYearMonth("20130102");
        sumInfo.setRestInfo("12,2,2,2,2,22,2,");
        try
        {
            assert(false);
            sumDao.deleteCompanySumInfo(sumInfo);
        }catch(Exception e)
        {
           
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
        }
        
        
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.CompanySumInfoDaoImpl#updateCompanySumInfo(cn.tinder.das.domain.po.CompanySumInfo)}.
     */
    @Test
    public void testUpdateCompanySumInfo()
    {
        CompanySumInfo sumInfo = new CompanySumInfo();
        sumInfo.setIndex(new GasDataIndex());
        sumInfo.getIndex().setGasName("aaaaaaa");
        sumInfo.getIndex().setYearMonth("20130102");
        sumInfo.setRestInfo("1,1,1,,1,1,1,2");
        try
        {
            sumDao.updateCompanySumInfo(sumInfo);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.CompanySumInfoDaoImpl#getCompanyInfoByIndex(cn.tinder.das.domain.dependency.GasDataIndex)}.
     */
    @Test
    public void testGetCompanyInfoByIndex()
    {
        CompanySumInfo sumInfo;
        GasDataIndex index = new GasDataIndex();
        index.setGasName("东莞");
        index.setYearMonth("20130102");
        try
        {
            sumInfo = sumDao.getCompanyInfoByIndex(index);
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
     * Test method for {@link cn.tinder.das.dao.impl.CompanySumInfoDaoImpl#getSumInfoByMonth(java.lang.String)}.
     */
    @Test
    public void testGetSumInfoByMonth()
    {
        List<CompanySumInfo> sumInfos;
//        CompanySumInfo sumInfo = new CompanySumInfo();
//        sumInfo.setIndex(new GasDataIndex());
//        sumInfo.getIndex().setGasName("深圳");
//        sumInfo.getIndex().setYearMonth("20130102");
//        sumInfo.setRestInfo("1,2,2,,2,2,2,1");
//        sumDao.addCompanySumInfo(sumInfo);
//        
//        sumInfo = new CompanySumInfo();
//        sumInfo.setIndex(new GasDataIndex());
//        sumInfo.getIndex().setGasName("广州");
//        sumInfo.getIndex().setYearMonth("20130102");
//        sumInfo.setRestInfo("1,2,2,,2,2,2,1");
//        sumDao.addCompanySumInfo(sumInfo);
        try
        {
            sumInfos = sumDao.getSumInfoByMonth("20130102");
        }catch(Exception e)
        {
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
            return;
            
        }
        if(sumInfos == null)
        {
            assert(false); 
        }
        System.out.println(sumInfos);
        assert(true);
    }

}
