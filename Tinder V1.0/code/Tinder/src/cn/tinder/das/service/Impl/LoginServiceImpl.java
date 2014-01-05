package cn.tinder.das.service.Impl;

import java.util.ArrayList;
import java.util.List;

import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.exception.LoginException;
import cn.tinder.das.exception.message.DaoExceptionMessage;
import cn.tinder.das.exception.message.LoginMessage;
import cn.tinder.das.service.LoginService;
import cn.tinder.das.struts.form.RoleForm;
import cn.tinder.das.struts.form.UserForm;
import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.LoginRole;
import cn.tinder.das.util.constant.PropertyName;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class LoginServiceImpl extends BasicServiceImpl implements LoginService
{
    //private final Log log = LogFactory.getLog(LoginServiceImpl.class);

    SystemUserDao userDao = new SystemUserDaoImpl();

    public RoleForm login(UserForm user)
    {
        try
        {
            SystemUser systemUser = userDao.getSystemUserByName(user
                    .getUserName());
            RoleForm loginRoleForm = null;

            if (systemUser == null)
            {
//                log.error("systemUser is null. [Function: userDao.getSystemUserByName(user.getUserName())]"
//                        + "  [user" + user + "]");
                throw new LoginException(LoginMessage.USER_NAME_NONEXIST);

            } else if (systemUser.getPassword().equals(user.getPassword()))
            {
              //  log.info("Login Success." + "[LoginUser:" + user + "]");
                loginRoleForm = new RoleForm(systemUser.getRole());

            } else
            {
             //   log.info("Password Wrong." + "[LoginUser:" + user
              //          + "]-[SystemUser:" + systemUser + "]");
                throw new LoginException(LoginMessage.USER_PASSWORD_WRONG);
            }

            return loginRoleForm;
        } catch (RuntimeException ex)
        {
//            log.error("Exception Stack："
//                    + ExceptionStackPrint.getErrorStack(ex, 0));
            throw new LoginException(ex);
        }

    }

    public List<List<UserForm>> selectRole(RoleForm role)
    {

        List<List<UserForm>> UserFormList = null;
        List<UserForm> gasStationList = new ArrayList<UserForm>();
        List<UserForm> departmentList = new ArrayList<UserForm>();

        List<SystemUser> systemUser = null;
        try
        {

            if (role.getRole().equals(
                    ConfigInformation
                            .getPropertyByName(PropertyName.MANAGER_USER)))
            {
               // log.info("Select Role:System_User(Admin).");

                systemUser = userDao.getUserByRole(ConfigInformation
                        .getPropertyByName(PropertyName.MANAGER_USER));
                if (systemUser == null)
                {
                  //  log.error("systemUserList is null. [Function:systemUser=userDao.getUserByRole(ConfigInformation.getPropertyByName(PropertyName.SYSTEM_USER));]");
                    throw new LoginException(LoginMessage.USER_ROLE_NONEXIST);
                } else
                {
                    for (int i = 0; i < systemUser.size(); i++)
                    {

                        departmentList.add(new UserForm(systemUser.get(i)
                                .getUserName(), null));

                    }
                    UserFormList = new ArrayList<List<UserForm>>();
                    UserFormList.add(departmentList);
                    UserFormList.add(gasStationList);
                   // log.info("Load UserFormList:Success.");
                }
            } else if ((role.getRole().equals(ConfigInformation
                    .getPropertyByName(PropertyName.DEPART_USER)))
                    || (role.getRole().equals(ConfigInformation
                            .getPropertyByName(PropertyName.GAS_USER))))
            {

                systemUser = userDao.getUserByRole(ConfigInformation
                        .getPropertyByName(PropertyName.DEPART_USER));
              //  log.info("Select Role:" + role);
                if (systemUser == null)
                {
                  //  log.error("systemUser is null. [Function:systemUser=userDao.getUserByRole(ConfigInformation.getPropertyByName(PropertyName.MANAGER_USER));]");
                    throw new LoginException(LoginMessage.USER_ROLE_NONEXIST);
                } else
                {

                    UserFormList = selectDepartment(systemUser.get(0)
                            .getDepartment());
                  //  log.info("Load UserFormList:Success.");
                }
            } else
            {
              //  log.error("User Role not Excist.[Role:" + role + "]");
                throw new LoginException(LoginMessage.USER_ROLE_NONEXIST);
            }

            // userDao.searchDepartmentGasStation(
            // dGSList.getDepartmentList().get(0)

            return UserFormList;
        } catch (RuntimeException ex)
        {
           // log.error("Exception Stack："
           //         + ExceptionStackPrint.getErrorStack(ex, 0));
            throw new LoginException(ex);
        }

    }

    public List<List<UserForm>> selectDepartment(String department)
    {

        List<UserForm> gasStationList = new ArrayList<UserForm>();
        List<UserForm> departmentList = new ArrayList<UserForm>();
        List<List<UserForm>> selectedDepartmentGSList = null;
        List<SystemUser> systemGSUser = null;
        List<SystemUser> systemDepartmentUser = null;

        try
        {

            systemGSUser = userDao.getGasUserByDepart(department);
            systemDepartmentUser = userDao.getUserByRole(LoginRole.DEPART);

            if (systemGSUser == null)
            {
                throw new LoginException(
                        DaoExceptionMessage.SYSTEM_GASSTATION_SEARCH);
            } else if (systemDepartmentUser == null)
            {
                throw new LoginException(
                        DaoExceptionMessage.SYSTEM_DEPARTMENT_SEARCH);
            } else
            {
                // ȡ����ݽ��д���
                for (int i = 0; i < systemGSUser.size(); i++)
                {
                    // ����վ��Ʋ���
                    gasStationList.add(new UserForm(systemGSUser.get(i)
                            .getUserName(), null));
                }
                for (int i = 0; i < systemDepartmentUser.size(); i++)
                {
                    departmentList.add(new UserForm(systemDepartmentUser.get(i)
                            .getUserName(), null));
                }

                selectedDepartmentGSList = new ArrayList<List<UserForm>>();
                selectedDepartmentGSList.add(departmentList);
                selectedDepartmentGSList.add(gasStationList);
            }
            return selectedDepartmentGSList;
        } catch (RuntimeException ex)
        {
//            log.error("Exception Stack："
//                    + ExceptionStackPrint.getErrorStack(ex, 0));
            throw new LoginException(ex);
        }
    }

}
