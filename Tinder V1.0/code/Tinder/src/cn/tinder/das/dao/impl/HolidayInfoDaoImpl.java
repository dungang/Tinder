/**
 * TODO
 * 上午02:50:02
 */
package cn.tinder.das.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.tinder.das.dao.HolidayInfoDao;
import cn.tinder.das.dao.util.HibernateUtil;
import cn.tinder.das.domain.po.HolidayInfo;
import cn.tinder.das.exception.ArrangeServiceException;
import cn.tinder.das.util.DaoExceptionMessage;
import cn.tinder.das.util.constant.DaysInMonth;

/**
 * @author Administrator
 *
 */
public class HolidayInfoDaoImpl implements HolidayInfoDao
{

	public void addHolidayInfo(HolidayInfo holidayInfo)
	{
        try
        {
            HibernateUtil.add(holidayInfo);
        } catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }

	}

	public void deleteHolidayInfo(HolidayInfo holidayInfo) 
	{
	    Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            
            Object classObj = session.load(HolidayInfo.class, holidayInfo.getYearMonth());
            
            session.delete(classObj);
            
            tx.commit();
        }  catch (RuntimeException re)
        {
            throw re;
        }finally {
            HibernateUtil.closeSession();
        }
		
	}

	public HolidayInfo getHolidayByYearMonth(String yearMonth) {
	    HolidayInfo hols;
        Session s=null;
        try{
         s=HibernateUtil.getSession();
         
         Criteria c=s.createCriteria(HolidayInfo.class);
         c.add(Restrictions.eq("yearMonth",yearMonth));
         hols = (HolidayInfo)c.uniqueResult();

        } catch (RuntimeException re)
        {
            throw re;
        }finally{
         if(s!=null)
         s.close();
        }
        return hols;
	}

   
}
