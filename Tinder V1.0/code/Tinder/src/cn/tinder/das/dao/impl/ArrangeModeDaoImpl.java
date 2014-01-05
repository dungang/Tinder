/**
 * TODO
 * 上午02:48:34
 */
package cn.tinder.das.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.tinder.das.dao.ArrangeModeDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.po.ArrangeMode;
import cn.tinder.das.domain.po.SystemUser;

/**
 * @author Administrator
 *
 */
public class ArrangeModeDaoImpl implements ArrangeModeDao
{

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.ArrangeModeDao#addArrangeMode(cn.tinder.das.domain.po.ArrangeMode)
     */
    public void addArrangeMode(ArrangeMode mode)
    {
        try
        {
            HibernateUtil.add(mode);
        } catch (RuntimeException re)
        {
            throw re;
        } finally {
            HibernateUtil.closeSession();
        }
        
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.ArrangeModeDao#deleteArrangeMode(cn.tinder.das.domain.po.ArrangeMode)
     */
    public void deleteArrangeMode(ArrangeMode mode)
    {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            
            Object classObj = session.load(ArrangeMode.class, mode.getName());
            
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
     * @see cn.tinder.das.dao.ArrangeModeDao#getAllMode()
     */
    public List<ArrangeMode> getAllMode()
    {
        List<ArrangeMode> modes;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c=s.createCriteria(ArrangeMode.class);
         modes = c.list();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return modes;
    }

}
