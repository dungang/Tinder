/**
 * TODO
 * 上午02:49:32
 */
package cn.tinder.das.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.tinder.das.dao.JobInfoDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.po.ArrangeMode;
import cn.tinder.das.domain.po.JobInfo;

/**
 * @author Administrator
 *
 */
public class JobInfoDaoImpl implements JobInfoDao
{

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.JobInfoDao#addJobInfoo(cn.tinder.das.domain.po.JobInfo)
     */
    public void addJobInfo(JobInfo job)
    {
        try
        {
            HibernateUtil.add(job);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.JobInfoDao#deleteJobInfo(cn.tinder.das.domain.po.JobInfo)
     */
    public void deleteJobInfo(JobInfo job)
    {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            
            Object classObj = session.load(JobInfo.class, job.getName());
            
            session.delete(classObj);
            
            tx.commit();
        } catch (RuntimeException re)
        {
            throw re;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.JobInfoDao#getAllMode()
     */
    public List<JobInfo> getAllJobInfo()
    {
        List<JobInfo> jobs;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c=s.createCriteria(JobInfo.class);
         jobs = c.list();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return jobs;
    }

}
