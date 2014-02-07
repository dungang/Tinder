/**
 * TODO
 * 上午01:12:08
 */
package cn.tinder.das.junit.dao;

import java.util.List;

import org.junit.Test;

import cn.tinder.das.dao.ArrangeModeDao;
import cn.tinder.das.dao.impl.ArrangeModeDaoImpl;
import cn.tinder.das.domain.po.ArrangeMode;

/**
 * @author Administrator
 *
 */
public class ArrangeModeDaoImplTest
{

    /**
     * Test method for {@link cn.tinder.das.dao.impl.ArrangeModeDaoImpl#addArrangeMode(cn.tinder.das.domain.po.ArrangeMode)}.
     */
    ArrangeModeDao modeDao = new ArrangeModeDaoImpl();
    @Test
    public void testAddArrangeMode()
    {
        ArrangeMode mode = new ArrangeMode();
        mode.setName("四班三运转");
        try
        {
            modeDao.addArrangeMode(mode);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
  
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.ArrangeModeDaoImpl#deleteArrangeMode(cn.tinder.das.domain.po.ArrangeMode)}.
     */
    @Test
    public void testDeleteArrangeMode()
    {
        ArrangeMode mode = new ArrangeMode();
        mode.setName("四班三运转");
        try
        {
            modeDao.deleteArrangeMode(mode);
        }catch(Exception e)
        {
            assert(false);
            System.out.println(e.getMessage()+e.getCause());
        }
        
        assert(true);
    }

    /**
     * Test method for {@link cn.tinder.das.dao.impl.ArrangeModeDaoImpl#getAllMode()}.
     */
    @Test
    public void testGetAllMode()
    {
        testAddArrangeMode();
        List<ArrangeMode> modes;
        try
        {
            modes = modeDao.getAllMode();
        }catch(Exception e)
        {
            System.out.println(e.getMessage()+e.getCause());
            assert(false);
            return;
           
        }
        if(modes == null)
        {
            assert(false);
        }
        System.out.println(modes);
        assert(true);
    }

}
