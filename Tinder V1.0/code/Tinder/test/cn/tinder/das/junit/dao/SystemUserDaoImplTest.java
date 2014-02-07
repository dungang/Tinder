package cn.tinder.das.junit.dao;

import static org.junit.Assert.fail;

import org.junit.Test;

import cn.fuego.tinder.dao.SystemUserDao;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.po.SystemUser;

public class SystemUserDaoImplTest
{

    SystemUserDao userDao = new SystemUserDaoImpl();
    @Test
    public void testSystemUserDaoImpl()
    {

       // testAddSystemUser();
        //testgetSystemUserByName();
        
        for(int i=0;i<50;i++)
        {
            testgetSystemUserByName();
        }
        
    }

    @Test
    public void testAddSystemUser()
    {
//        SystemUser user = new SystemUser();
//        user.setUserName("admin");
//        user.setPassword("1234");
//        user.setRole("管理员");
//        user.setGasNum("1");
//        user.setDescription("d");
//      
//        try
//        {
//            userDao.addSystemUser(user);
//        }catch(Exception e)
//        {
//            System.out.println(e.getMessage()+e.getCause());
//        }
//        
        assert(true);
    }

    @Test
    public void testDeleteSystemUser()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateSystemUser()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testgetSystemUserByName()
    {
        SystemUser user = new SystemUser();
        user = ((SystemUserDaoImpl) userDao).getSystemUserByName("admin");
        System.out.println(user.getRole());
        if(user.getPassword().equals("1234"))
        {
            assert(true);
        }
        else
        {
            assert(false);
        }
    }

    @Test
    public void testgetGasUserByDepart()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testgetUserByRole()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testSearchPassword()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testSearchRole()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testSearchUserForm()
    {
        fail("Not yet implemented");
    }

}
