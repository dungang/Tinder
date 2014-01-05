package cn.tinder.das.junit.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tinder.das.domain.dependency.ArrangeModeInfo;
import cn.tinder.das.domain.dependency.GasArrangeIndex;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.dependency.GasSaleInfo;
import cn.tinder.das.domain.dependency.GasStaffInfo;
import cn.tinder.das.domain.dependency.ModeInfo;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.service.ExportService;
import cn.tinder.das.service.Impl.ExportServiceImpl;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.ExportExcelImpl;
import cn.tinder.das.util.constant.PropertyName;


public class ExportExcelImplTest {
	ExportExcelImpl t= new ExportExcelImpl();
	

	@Test
	public void test(){
		//四个输入参数
		SystemUser user=new SystemUser();
		GasInformation gasInfo = new GasInformation();
		CompanySumInfo sumInfo = new CompanySumInfo();
		List<GasArrangeData> gasArgData = new ArrayList<GasArrangeData>();
		
		

	
		user.setUserName("测试加油站");
		user.setRole("gas_station");
		user.setDepartment("测试经营管理部");
		user.setGasNum("测试编号0000");
		user.setPassword("1234");
		
		
		//gasInfo
			//index
			GasDataIndex gasIndex = new GasDataIndex();
			gasIndex.setGasName("测试加油站");
			gasIndex.setYearMonth("201301");
	
		gasInfo.setIndex(gasIndex);
			//saleInfo
			GasSaleInfo saleInfo=new  GasSaleInfo();
			saleInfo.setSaleNum(15);
			saleInfo.setBusinessHours(10);
			saleInfo.setBusinessTime("15:10~16:30");
			saleInfo.setCardScale(50);
			saleInfo.setSaleMoney(500);
		gasInfo.setSaleInfo(saleInfo);
			//staffInfo
			GasStaffInfo staffInfo=new GasStaffInfo();
			staffInfo.setAvgRestDay((float)2.5);
			staffInfo.setAvgRestStaff((float)2.5);
			staffInfo.setStaffNum((float)2.3);
		gasInfo.setStaffInfo(staffInfo);
			//modinfo
			ArrangeModeInfo argModInfo = new ArrangeModeInfo();
			argModInfo.setArrangeName("五班三倒");
				//
				ModeInfo mode= new ModeInfo();
					mode.setModeAvgNum(5);
					mode.setModeHours(6);
					mode.setModeName("A");
					mode.setModeTime("10:00~10:00;12:00~14:13");
					
				argModInfo.setaMode(mode);
				argModInfo.setbMode(mode);
				argModInfo.setcMode(mode);
				argModInfo.setdMode(mode);
				argModInfo.seteMode(mode);
				argModInfo.setfMode(mode);
				argModInfo.setgMode(mode);
				argModInfo.setzMode(mode);
				argModInfo.sethMode(mode);
			gasInfo.setGasArrange(argModInfo);
		//suminfo
		sumInfo.setRestInfo("1,2,3,4");
		sumInfo.setIndex(gasIndex);
		
		//gasArgData
			//a
			GasArrangeData gasArgDat1=new GasArrangeData();
			gasArgDat1.setHolidays((float) 3.5);
			gasArgDat1.setJob("站长");
			gasArgDat1.setOverHours((float) 0.24);
			gasArgDat1.setRestDays((float)4.2);
			gasArgDat1.setSumDays((float)3.24);
			gasArgDat1.setSumHours(4);
			gasArgDat1.setWorkDays("---AAAAAAA////////AAAAAAAAAAAAA");
				//Index
				GasArrangeIndex gasArgIndex=new GasArrangeIndex();
				gasArgIndex.setStaffName("员工1");
			gasArgDat1.setIndex(gasArgIndex);
		gasArgData.add(gasArgDat1);
			//b
			GasArrangeData gasArgDat2=new GasArrangeData();
			gasArgDat2.setHolidays((float) 3.5);
			gasArgDat2.setJob("站长");
			gasArgDat2.setOverHours((float) 0.24);
			gasArgDat2.setRestDays((float)4.2);
			gasArgDat2.setSumDays((float)3.24);
			gasArgDat2.setSumHours(4);
			gasArgDat2.setWorkDays("---CCCCAAA////DDDDAAAAEEEEAAAAA");
				//2
				GasArrangeIndex gasArgIndex2=new GasArrangeIndex();
				gasArgIndex2.setStaffName("员工2");
			gasArgDat2.setIndex(gasArgIndex2);
		gasArgData.add(gasArgDat2);
		
		System.out.println("Test Start...");
		t.exoprtGasSheet(gasInfo,sumInfo, gasArgData,user,ConfigInformation
                .getPropertyByName(PropertyName.MOD_PATH_GASSTATION));

	}
	

	public void test2(){
		//四个输入参数
		SystemUser user=new SystemUser();
		GasInformation gasInfo = new GasInformation();
		CompanySumInfo sumInfo = new CompanySumInfo();
		List<GasArrangeData> gasArgData = new ArrayList<GasArrangeData>();
		
		

//		//User
//		user.setUserName("测试加油站");
//		user.setRole("gas_station");
//		user.setDepartment("测试经营管理部");
//		user.setGasNum("测试编号0000");
//		user.setPassword("1234");
//		
//		
		//gasInfo
			//index
			GasDataIndex gasIndex = new GasDataIndex();
			gasIndex.setGasName("测试加油站1");
			gasIndex.setYearMonth("201301");
	
		gasInfo.setIndex(gasIndex);
			//saleInfo
			GasSaleInfo saleInfo=new  GasSaleInfo();
			saleInfo.setSaleNum(15);
			saleInfo.setBusinessHours(10);
			saleInfo.setBusinessTime("15:10~16:30");
			saleInfo.setCardScale(50);
			saleInfo.setSaleMoney(500);
		gasInfo.setSaleInfo(saleInfo);
			//staffInfo
			GasStaffInfo staffInfo=new GasStaffInfo();
			staffInfo.setAvgRestDay((float)2.5);
			staffInfo.setAvgRestStaff((float)2.5);
			staffInfo.setStaffNum((float)2.3);
		gasInfo.setStaffInfo(staffInfo);
			//modinfo
			ArrangeModeInfo argModInfo = new ArrangeModeInfo();
			argModInfo.setArrangeName("五班三倒");
				//
				ModeInfo mode= new ModeInfo();
					mode.setModeAvgNum(5);
					mode.setModeHours(6);
					mode.setModeName("A");
					mode.setModeTime("10:00~10:00;12:00~14:13");
					
				argModInfo.setaMode(mode);
				argModInfo.setbMode(mode);
				argModInfo.setcMode(mode);
				argModInfo.setdMode(mode);
				argModInfo.seteMode(mode);
				argModInfo.setfMode(mode);
				argModInfo.setgMode(mode);
				argModInfo.setzMode(mode);
				argModInfo.sethMode(mode);
			gasInfo.setGasArrange(argModInfo);
		//suminf
		sumInfo.setRestInfo("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31");
		sumInfo.setIndex(gasIndex);
	
		GasDataIndex gasIndex2 = new GasDataIndex();
		gasIndex2.setGasName("测试加油站2");
		
		List<CompanySumInfo> allCmpInfo=new ArrayList<CompanySumInfo>();
		List<GasInformation> allGasInfo = new ArrayList<GasInformation>();
		allCmpInfo.add(sumInfo);
		
		
		//allGasInfo  
		allGasInfo.add(gasInfo);
		
		
		Map<String, String> gsNumMap = new HashMap<String,String>();
		gsNumMap.put("测试加油站2","1234" );
		gsNumMap.put("测试加油站1","234" );
		
		Map<String, String> gsDepMap = new HashMap<String,String>();
		gsNumMap.put("测试加油站2","东城" );
		gsNumMap.put("测试加油站1","常平" );
		System.out.println(allGasInfo.get(0).getIndex().getYearMonth());

		t.exoprtSumSheet(allGasInfo, allCmpInfo, gsNumMap,gsDepMap,"");

	}
	@Test
	public void sumtest(){
		ExportService exportService =new ExportServiceImpl();
		ArrangeIndexForm index = new ArrangeIndexForm();
		index.setMonth("02");
		index.setYear("2013");
		exportService.exportSumInfoFile(index);
		
	}
}
