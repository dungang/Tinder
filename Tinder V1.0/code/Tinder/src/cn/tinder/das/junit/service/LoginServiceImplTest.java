package cn.tinder.das.junit.service;

import org.junit.Test;

import cn.tinder.das.service.LoginService;
import cn.tinder.das.service.Impl.LoginServiceImpl;
import cn.tinder.das.struts.form.UserForm;


public class LoginServiceImplTest {

	
	
	LoginService testLS=new LoginServiceImpl();
	UserForm user1 =new UserForm("测试用户名","123456");
	
	
	//登录测试
	
	public void Logintest(){
		System.out.println(testLS.login(user1).getRole()); 

	}
	//经营管理部变动刷新
	public void DPfrashtest(){

		//System.out.println(testLS.selectDepartment("test").DepartmentList);
		//System.out.println(testLS.selectDepartment("test").GasStationList);
	}

	//角色选择
	@Test
	public void Rolechoose(){
		
		//System.out.println(testLS.selectRole(new RoleForm("gas_station")).DepartmentList);
		//System.out.println(testLS.selectRole(new RoleForm("gas_station")).GasStationList);
	}
	

	}
	
