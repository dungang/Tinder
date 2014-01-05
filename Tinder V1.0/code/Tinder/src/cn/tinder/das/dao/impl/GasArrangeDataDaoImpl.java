/**
 * TODO
 * ����02:49:21
 */
package cn.tinder.das.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.tinder.das.dao.GasArrangeDataDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.dependency.GasArrangeIndex;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;

/**
 * @author Administrator
 *
 */
public class GasArrangeDataDaoImpl implements GasArrangeDataDao
{

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasArrangeDataDao#addGasArrangeData(cn.tinder.das.domain.po.GasArrangeData)
     */
    public void addGasArrangeData(GasArrangeData arrangeData)
    {
        try
        {
            HibernateUtil.add(arrangeData);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasArrangeDataDao#deleteGasArrangeData(cn.tinder.das.domain.po.GasArrangeData)
     */
    public void deleteGasArrangeData(GasArrangeData arrangeData)
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
            hql = "delete from GasArrangeData where c_year_month = ? and gas_name = ? and staff_name = ?"; 
            Query query = session.createQuery(hql);
            query.setString(0, arrangeData.getIndex().getYearMonth());
            query.setString(1, arrangeData.getIndex().getGasName());
            query.setString(2, arrangeData.getIndex().getStaffName());
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
    
    public void deleteGasArrangeDataByGas(GasInformation gasInfo)
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
            hql = "delete from GasArrangeData where c_year_month = ? and gas_name = ?"; 
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
     * @see cn.tinder.das.dao.GasArrangeDataDao#updateGasArrangeData(cn.tinder.das.domain.po.GasArrangeData)
     */
    public void updateGasArrangeData(GasArrangeData arrangeData)
    {
        try
        {
            HibernateUtil.update(arrangeData);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }

    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasArrangeDataDao#getArrangeByArrangeIndex(cn.tinder.das.domain.dependency.GasArrangeIndex)
     */
    public GasArrangeData getArrangeByArrangeIndex(GasArrangeIndex index)
    {
        GasArrangeData gasData;
        Session s=null;
        try{
         s=HibernateUtil.getSession();

         Criteria c=s.createCriteria(GasArrangeData.class);
         c.add(Restrictions.eq("index.yearMonth",index.getYearMonth()));//eq�ǵ��ڣ�gt�Ǵ��ڣ�lt��С��,or�ǻ�
         c.add(Restrictions.eq("index.gasName",index.getGasName()));
         c.add(Restrictions.eq("index.staffName", index.getStaffName()));
         gasData=(GasArrangeData) c.uniqueResult();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return gasData;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.GasArrangeDataDao#getArrangeListByGasDataIndex(cn.tinder.das.domain.dependency.GasDataIndex)
     */
    public List<GasArrangeData> getArrangeListByGasDataIndex(GasDataIndex index)
    {
        List<GasArrangeData> gasDatas;
        Session s=null;
        try{
         s=HibernateUtil.getSession();

         Criteria c=s.createCriteria(GasArrangeData.class);
         c.add(Restrictions.eq("index.yearMonth",index.getYearMonth()));//eq�ǵ��ڣ�gt�Ǵ��ڣ�lt��С��,or�ǻ�
         c.add(Restrictions.eq("index.gasName",index.getGasName()));
         gasDatas=c.list();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return gasDatas;
    }

}
