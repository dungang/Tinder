/**
 * TODO
 * 上午02:34:32
 */
package cn.tinder.das.junit.dao;

import java.util.List;

import org.junit.Test;

import cn.tinder.das.dao.JobInfoDao;
import cn.tinder.das.dao.impl.JobInfoDaoImpl;
import cn.tinder.das.domain.po.JobInfo;

/**
 * @author Administrator
 *
 */
public class JobInfoDaoImplTest
{
   JobInfoDao jobDao = new JobInfoDaoImpl();
    /**
     * Test method for {@link cn.tinder.das.dao.impl.JobInfoDaoImpl#addJobInfo(cn.tinder.das.domain.po.JobInfo)}.
     */
    @Test
    public void testAddJobInfo()
    {
        JobInfo job = new JobInfo();
        job.setName("营业员");
        try
        {
            jobDao.addJobInfo(job);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.JobInfoDaoImpl#deleteJobInfo(cn.tinder.das.domain.po.JobInfo)}.
     */
    @Test
    public void testDeleteJobInfo()
    {
        JobInfo job = new JobInfo();

        job.setName("营业员");
 
   
        try
        {
            jobDao.deleteJobInfo(job);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.JobInfoDaoImpl#getAllJobInfo()}.
     */
    @Test
    public void testGetAllJobInfo()
    {
        JobInfo job = new JobInfo();

        job.setName("营业员");
        jobDao.addJobInfo(job);
        job = new JobInfo();
        job.setName("站长");
        jobDao.addJobInfo(job);
         
        List<JobInfo> jobs;
        try
        {
            jobs = jobDao.getAllJobInfo();
        }catch(Exception e)
        {
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
            return;
           
        }
        if(jobs == null)
        {
            assert(false);
        }
        System.out.println(jobs);
        assert(true);
    }

}
