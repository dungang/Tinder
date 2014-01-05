/**
 * 
 */
package cn.tinder.das.dao;

import java.util.List;

import cn.tinder.das.domain.po.SystemUser;

/**
 * 
 * @author Administrator
 *
 */
public interface SystemUserDao
{
	/**
	 * @function 增加一个用户
	 * @param user
	 */
    public void addSystemUser(SystemUser user);
    
    /**
     * @function 删除一个用户
     * @param user
     */
    public void deleteSystemUser(SystemUser user);

    /**
     * @function 更新一个用户
     * @param user
     */
    public void updateSystemUser(SystemUser user);
    
    /**
     * @function 通过用户名查找用户
     * @param username
     * @return SystemUser
     */
    public SystemUser getSystemUserByName(String username);

    /**
     * 
     * @function 通过经营管理部找油站类表
     * @param department
     * @return
     */
    public List<SystemUser> getGasUserByDepart(String department);
    
    /**
     * 
     * @function 通过角色找用户列表
     * @param role
     * @return
     */
    public List<SystemUser> getUserByRole(String role);
    
    
}
