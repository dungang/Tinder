package cn.tinder.das.service;

import java.util.List;

import cn.tinder.das.struts.form.RoleForm;
import cn.tinder.das.struts.form.UserForm;

public interface LoginService extends BasicService
{
	public RoleForm login(UserForm user);
    
    public List<List<UserForm>> selectRole(RoleForm role);
    
    public List<List<UserForm>>  selectDepartment(String department);//�ı侭Ӫ���?���г���վ�б�

}
