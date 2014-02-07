package cn.tinder.das.junit.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.tinder.das.exception.BasicException;
import cn.tinder.das.service.BasicService;
import cn.tinder.das.service.Impl.BasicServiceImpl;


public class BasicServiceTest {
	BasicService b= new BasicServiceImpl();
	List<String>  a =new ArrayList<String>();
	
   

	//Tested
	public void testgetAllManager(){
		try{
		a=b.getAllDepart();
		System.out.println(b.getAllDepart());
		
		}catch(BasicException ex){
			ex.printStackTrace();
		}
	}
	
	//通过

	public void testgetAllGasNameByManagerName(){
		try{
		a=b.getAllGasNameByDepartName("城");
		System.out.println(a);
		}catch(BasicException ex){
			ex.printStackTrace();
		}
	}
	//通过

	public void testgetRoleByName(){
		try{
		String s=b.getRoleByName("南加油站");

			System.out.println(s);
		}catch(BasicException ex){
			ex.printStackTrace();
		}
	}
	//通过

	public void testgetAllUserNameByRole(){
		try{
		a=b.getAllUserNameByRole("gs_station");

			System.out.println(a);

		}catch(BasicException ex){
			ex.printStackTrace();
		}
	}
	

	public void testgetAllYear(){
		System.out.println(b.getAllYear());
		
	}
	@Test
	public void testgetAllmonth(){
		System.out.println(b.getAllMonth());
		
	}
}
