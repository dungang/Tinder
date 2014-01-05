/**
 * TODO
 * 上午02:51:07
 */
package cn.tinder.das.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.tinder.das.dao.CompanySumInfoDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;

/**
 * @author Administrator
 *
 */
public class CompanySumInfoDaoImpl implements CompanySumInfoDao
{

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.CompanySumInfoDao#addCompanySunInfo(cn.tinder.das.domain.po.CompanySumInfo)
     */
    public void addCompanySumInfo(CompanySumInfo sumInfo)
    {
        try
        {
            HibernateUtil.add(sumInfo);
        } catch (RuntimeException re)
        {
            throw re;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.CompanySumInfoDao#deleteCompanySumInfo(cn.tinder.das.domain.po.CompanySumInfo)
     */
    public void deleteCompanySumInfo(CompanySumInfo sumInfo)
    {
        Session session = null;
        Transaction tx = null;
        String hql = null;
        SystemUser user = null;
        try
        {
            session = HibernateUtil.getSession();
            /*��������*/
            tx = session.beginTransaction(); 
            
     
            /*ͨ���û����ѯ�û�*/
            hql = "delete from CompanySumInfo where c_year_month = ? and gas_name = ?"; 
            Query query = session.createQuery(hql);
            query.setString(0, sumInfo.getIndex().getYearMonth());
            query.setString(1, sumInfo.getIndex().getGasName());
            query.executeUpdate();
             
            tx.commit();
        }catch(RuntimeException re)
        {
            throw re;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.CompanySumInfoDao#updateCompanySumInfo(cn.tinder.das.domain.po.CompanySumInfo)
     */
    public void updateCompanySumInfo(CompanySumInfo sumInfo)
    {
        try
        {
            HibernateUtil.update(sumInfo);
        } catch (RuntimeException re)
        {
            throw re;
        } finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.CompanySumInfoDao#getCompanyInfoByIndex(cn.tinder.das.domain.dependency.GasDataIndex)
     */
    public CompanySumInfo getCompanyInfoByIndex(GasDataIndex index)
    {
        CompanySumInfo sumInfo;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c = s.createCriteria(CompanySumInfo.class);
         c.add(Restrictions.eq("index.yearMonth",index.getYearMonth()));//eq是等于，gt是大于，lt是小于,or是或
         c.add(Restrictions.eq("index.gasName",index.getGasName()));
         sumInfo = (CompanySumInfo) c.uniqueResult();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return sumInfo;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.CompanySumInfoDao#getSumInfoByMonth(java.lang.String)
     */
    public List<CompanySumInfo> getSumInfoByMonth(String yearMonth)
    {
        List<CompanySumInfo> sumInfos;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c = s.createCriteria(CompanySumInfo.class);
         c.add(Restrictions.eq("index.yearMonth",yearMonth));

         sumInfos = c.list();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return sumInfos;
    }

}
