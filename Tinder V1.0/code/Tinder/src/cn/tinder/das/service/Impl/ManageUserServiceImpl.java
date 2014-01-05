/**
 * TODO
 * 下午11:47:25
 */
package cn.tinder.das.service.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.exception.ManageUserException;
import cn.tinder.das.exception.message.ManageUserMessage;
import cn.tinder.das.service.ManageUserService;
import cn.tinder.das.struts.action.arrange.SaveArrangeAction;
import cn.tinder.das.struts.form.GasForm;
import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.constant.PropertyName;

/**
 * @author Administrator
 * 
 */
public class ManageUserServiceImpl implements ManageUserService
{
    private static final Log log = LogFactory.getLog(ManageUserServiceImpl.class);

    SystemUserDao userDao = new SystemUserDaoImpl();

    public void alterPassword(String userName, String oldPassword,
            String newPassword)
    {
        SystemUser user;
        /* ��DAO�л�ȡ����Ա���� */
        user = userDao.getSystemUserByName(userName);

        /* �жϸù���Ա�Ƿ���� */
        if (user == null)
        {
            throw new ManageUserException(ManageUserMessage.USER_NONEXIST);
        }
        /* �ж�ԭʼ���������Ƿ���ȷ */
        if (!(user.getPassword().equals(oldPassword)))
        {
            throw new ManageUserException(ManageUserMessage.OLD_PASSWORD_WRONG);
        }

        /* �������� */
        user.setPassword(newPassword);
        userDao.updateSystemUser(user);
    }

    public SystemUser queryUserInfo(String userName)
    {

        SystemUser user = userDao.getSystemUserByName(userName);

        if (user == null)
        {
            throw new ManageUserException(ManageUserMessage.USER_NONEXIST);
        }
        return user;
    }

    public boolean isOldPasswordRight(String userName, String oldPassword)
    {
        SystemUser user;
        /* ��DAO�л�ȡ����Ա���� */

        user = userDao.getSystemUserByName(userName);
        if (user.getPassword().equals(oldPassword))
        {
            return true;
        }
        return false;
    }

    public void isNewPasswordRight(String firstPassword, String secondPassword)
    {
        if (!(firstPassword.equals(secondPassword)))
        {
            throw new ManageUserException(ManageUserMessage.TWO_PASSWORD_UNSAME);
        }
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.service.ManageUserService#resetPassword(java.lang.String)
     */
    public void resetPassword(String userName)
    {
        SystemUser user;
        /* ��DAO�л�ȡ����Ա���� */
        user = userDao.getSystemUserByName(userName);
        if(null == user)
        {
            throw new ManageUserException("该油站不存在");
        }
        /* �������� */
        user.setPassword(ConfigInformation.getPropertyByName(PropertyName.DEFAULT_PWD));
        userDao.updateSystemUser(user);
        
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.service.ManageUserService#deleteGas(java.lang.String)
     */
    public void deleteGas(String userName)
    {
        SystemUser gas = userDao.getSystemUserByName(userName);
        if(null == gas)
        {
            throw new ManageUserException("该油站不存在");
        }
        userDao.deleteSystemUser(gas);
    }

    /* (non-Javadoc)
     * @see cn.tinder.das.service.ManageUserService#addGas(java.lang.String, java.lang.String)
     */
    public void addGas(GasForm gasUser)
    {
        
        if(null != userDao.getSystemUserByName(gasUser.getNewGasName()))
        {
            throw new ManageUserException("该油站已经存在");
        }
        SystemUser user = new SystemUser();
        user.setUserName(gasUser.getNewGasName());
        user.setRole(ConfigInformation.getPropertyByName(PropertyName.GAS_USER));
        user.setGasNum(gasUser.getNewGasNum());
        user.setDepartment(gasUser.getNewDepartment());
        user.setPassword(ConfigInformation.getPropertyByName(PropertyName.DEFAULT_PWD));
        
        log.info("add gas "+ user);
        userDao.addSystemUser(user);
        
    }
}
