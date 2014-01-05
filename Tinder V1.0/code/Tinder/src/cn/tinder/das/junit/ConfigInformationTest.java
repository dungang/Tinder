package cn.tinder.das.junit;

import org.junit.Test;

import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.constant.PropertyName;


public class ConfigInformationTest {
	@Test
	public void test(){
		System.out.println(ConfigInformation.getPropertyByName(PropertyName.GAS_USER));
		
	}
}
