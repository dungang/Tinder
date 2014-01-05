/**
 * TODO
 * ����02:43:56
 */
package cn.tinder.das.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.tinder.das.dao.GasInformationDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;

/**
 * @author Administrator
 *
 */
public class GasInformationDaoImpl implements GasInformationDao
{

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasInformationDao#addGasInformation(cn.tinder.das.domain.po.GasInformation)
     */
    public void addGasInformation(GasInformation gasInfo)
    {
        try
        {
            HibernateUtil.add(gasInfo);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasInformationDao#deleteGasInformation(cn.tinder.das.domain.po.GasInformation)
     */
    public void deleteGasInformation(GasInformation gasInfo)
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
            hql = "delete from GasInformation where c_year_month = ? and gas_name = ?"; 
            Query query = session.createQuery(hql);
            query.setString(0, gasInfo.getIndex().getYearMonth());
            query.setString(1, gasInfo.getIndex().getGasName());
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
     * @see cn.tinder.das.dao.GasInformationDao#updateGasInformation(cn.tinder.das.domain.po.GasInformation)
     */
    public void updateGasInformation(GasInformation gasInfo)
    {
        try
        {
            HibernateUtil.update(gasInfo);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasInformationDao#getGasInfoByIndex(cn.tinder.das.domain.dependency.GasDataIndex)
     */
    public GasInformation getGasInfoByIndex(GasDataIndex index)
    {
        GasInformation gasInfo = null;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c = s.createCriteria(GasInformation.class);
         c.add(Restrictions.eq("index.yearMonth",index.getYearMonth()));//eq是等于，gt是大于，lt是小于,or是或
         c.add(Restrictions.eq("index.gasName",index.getGasName()));
         gasInfo = (GasInformation) c.uniqueResult();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return gasInfo;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasInformationDao#getGasInfoListByMonth(java.lang.String)
     */
    public List<GasInformation> getGasInfoListByMonth(String yearMonth)
    {
        List<GasInformation> gases;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c=s.createCriteria(GasInformation.class);
         c.add(Restrictions.eq("index.yearMonth",yearMonth));//eq�ǵ��ڣ�gt�Ǵ��ڣ�lt��С��,or�ǻ�
         gases=c.list();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return gases;
    }

}
