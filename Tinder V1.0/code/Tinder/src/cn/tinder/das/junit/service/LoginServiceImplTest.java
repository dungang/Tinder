package cn.tinder.das.junit.service;

import org.junit.Test;

import cn.tinder.das.service.LoginService;
import cn.tinder.das.service.Impl.LoginServiceImpl;
import cn.tinder.das.struts.form.UserForm;


public class LoginServiceImplTest {

	
	
	LoginService testLS=new LoginServiceImpl();
	UserForm user1 =new UserForm("�����û���","123456");
	
	
	//��¼����
	
	public void Logintest(){
		System.out.println(testLS.login(user1).getRole()); 

	}
	//��Ӫ�����䶯ˢ��
	public void DPfrashtest(){

		//System.out.println(testLS.selectDepartment("test").DepartmentList);
		//System.out.println(testLS.selectDepartment("test").GasStationList);
	}

	//��ɫѡ��
	@Test
	public void Rolechoose(){
		
		//System.out.println(testLS.selectRole(new RoleForm("gas_station")).DepartmentList);
		//System.out.println(testLS.selectRole(new RoleForm("gas_station")).GasStationList);
	}
	

	}
	
