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
	 * @function ����һ���û�
	 * @param user
	 */
    public void addSystemUser(SystemUser user);
    
    /**
     * @function ɾ��һ���û�
     * @param user
     */
    public void deleteSystemUser(SystemUser user);

    /**
     * @function ����һ���û�
     * @param user
     */
    public void updateSystemUser(SystemUser user);
    
    /**
     * @function ͨ���û��������û�
     * @param username
     * @return SystemUser
     */
    public SystemUser getSystemUserByName(String username);

    /**
     * 
     * @function ͨ����Ӫ��������վ���
     * @param department
     * @return
     */
    public List<SystemUser> getGasUserByDepart(String department);
    
    /**
     * 
     * @function ͨ����ɫ���û��б�
     * @param role
     * @return
     */
    public List<SystemUser> getUserByRole(String role);
    
    
}
