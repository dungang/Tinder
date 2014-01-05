package cn.tinder.das.junit.service;

import org.junit.Test;

import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;


public class SystemUserDaoImplTest {
	
	SystemUserDao test= new SystemUserDaoImpl();
	
	@Test
	public void test(){
		//System.out.println(test.searchDepartmentGasStation("a"));
	}


}
