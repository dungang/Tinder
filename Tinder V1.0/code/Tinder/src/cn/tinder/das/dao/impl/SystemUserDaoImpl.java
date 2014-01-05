package cn.tinder.das.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.service.Impl.ArrangeServiceImpl;

public class SystemUserDaoImpl implements SystemUserDao 
{
	Log log = LogFactory.getLog(SystemUserDaoImpl.class);
    /* (non-Javadoc)
     * @see cn.tinder.das.dao.SystemUserDao#addSystemUser(cn.tinder.das.domain.po.SystemUser)
     */
    public void addSystemUser(SystemUser user)
    {
        try
        {
            HibernateUtil.add(user);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }
        
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.SystemUserDao#deleteSystemUser(cn.tinder.das.domain.po.SystemUser)
     */
    public void deleteSystemUser(SystemUser user)
    {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            
            Object classObj = session.load(SystemUser.class, user.getUserName());
            
            session.delete(classObj);
            
            tx.commit();
        } catch (RuntimeException re)
        {
            throw re;
        } finally {
            if(session!=null)
            {
                session.close();
            }
        }
        
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.SystemUserDao#updateSystemUser(cn.tinder.das.domain.po.SystemUser)
     */
    public void updateSystemUser(SystemUser user)
    {
        try
        {
            HibernateUtil.update(user);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }
        
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.SystemUserDao#getSystemUserByName(java.lang.String)
     */
    public SystemUser getSystemUserByName(String name)
    {
        Session s = null;
        Transaction tx = null;
        String hql = null;
        SystemUser user = null;
        try
        {
//            session = HibernateUtil.getSession();
//            /*��������*/
//            tx = session.beginTransaction(); 
//            
//     
//            /*ͨ���û����ѯ�û�*/
//            hql = "from SystemUser as user where user.userName = ? "; 
//            Query query = session.createQuery(hql);
//            
//            /*���ò�ѯ����*/
//            query.setString(0, name);
//            
//            user = (SystemUser)query.uniqueResult();
//            
//            /*��ʼ��������󣬱���������*/
//            Hibernate.initialize(user);
//            /*�ύ����*/
//            tx.commit();
            s=HibernateUtil.getSession();
            
            Criteria c=s.createCriteria(SystemUser.class);
            c.add(Restrictions.eq("userName",name));// 
            user= (SystemUser)c.uniqueResult();
        }catch(RuntimeException re)
        {
            throw re;
        }
        finally
        {
           // HibernateUtil.closeSession();
            if(s!=null)
            {
                s.close();
            }
        }
        return user;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.SystemUserDao#getGasUserByDepart(java.lang.String)
     */
    public List<SystemUser> getGasUserByDepart(String department)
    {
        
            List<SystemUser> users;
            Session s=null;
            try{
             s=HibernateUtil.getSession();
             
             Criteria c=s.createCriteria(SystemUser.class);
             c.add(Restrictions.eq("department",department));//eq�ǵ��ڣ�gt�Ǵ��ڣ�lt��С��,or�ǻ�
             users=c.list();

            } catch (RuntimeException re)
            {
                throw re;
            }finally{
                if(s!=null)
                {
                    s.close();
                }
            }

        return users;
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.dao.SystemUserDao#getUserByRole(java.lang.String)
     */
    public List<SystemUser> getUserByRole(String role)
    {
        List<SystemUser> users;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c=s.createCriteria(SystemUser.class);
         c.add(Restrictions.eq("role",role));//eq�ǵ��ڣ�gt�Ǵ��ڣ�lt��С��,or�ǻ�
         users=c.list();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
            if(s!=null)
            {
                s.close();
            }
        }
    return users;
    }

}
