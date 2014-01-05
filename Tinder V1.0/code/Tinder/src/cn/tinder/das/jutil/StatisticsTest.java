package cn.tinder.das.jutil;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.tinder.das.domain.dependency.ArrangeModeInfo;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.dependency.GasSaleInfo;
import cn.tinder.das.domain.dependency.GasStaffInfo;
import cn.tinder.das.domain.dependency.ModeInfo;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.util.Statistics;

public class StatisticsTest {
	Statistics t=new Statistics();
	
	@Test
	public void testGetHoursByTime() {
		float result=t.getHoursByTime("20:35~21:05");
		System.out.println("testGetHoursByTime:"+result);
		if(result==0.5){
			assertTrue(true);
		}
		else{
			assertTrue(false);
		}
	}

	@Test
	public void testComputeAllData() {
		GasInformation gasInfo= new	GasInformation();
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

	gasInfo.setStaffInfo(staffInfo);
		//modinfo
		ArrangeModeInfo argModInfo = new ArrangeModeInfo();
		argModInfo.setArrangeName("五班三倒");
			//
			ModeInfo mode= new ModeInfo();
				mode.setModeAvgNum(5);
				mode.setModeHours(6);
				mode.setModeName("A");
				mode.setModeTime("10:00~12:00;12:00~14:13");
				ModeInfo mode2= new ModeInfo();
				mode2.setModeAvgNum(5);
				mode2.setModeHours(6);
				mode2.setModeName("B");
				mode2.setModeTime("10:00~11:00;12:00~14:13");	
			argModInfo.setaMode(mode);
			argModInfo.setbMode(mode2);
			argModInfo.setcMode(mode);
			argModInfo.setdMode(mode);
			argModInfo.seteMode(mode);
			argModInfo.setfMode(mode);
			argModInfo.setgMode(mode);
			argModInfo.setzMode(mode);
			argModInfo.sethMode(mode);
		gasInfo.setGasArrange(argModInfo);

		CompanySumInfo sumInfo = null;
		List<GasArrangeData> gasArgData = null;
		
		t.computeAllData(gasInfo,sumInfo,gasArgData);
	}

	@Test
	public void testGetHolidayList() {
	GasInformation gasInfo= new	GasInformation();
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

	gasInfo.setStaffInfo(staffInfo);
		//modinfo
		ArrangeModeInfo argModInfo = new ArrangeModeInfo();
		argModInfo.setArrangeName("五班三倒");
			//
			ModeInfo mode= new ModeInfo();
				mode.setModeAvgNum(5);
				mode.setModeHours(6);
				mode.setModeName("A");
				mode.setModeTime("10:00~12:00;12:00~14:13");
				ModeInfo mode2= new ModeInfo();
				mode2.setModeAvgNum(5);
				mode2.setModeHours(6);
				mode2.setModeName("B");
				mode2.setModeTime("10:00~11:00;12:00~14:13");	
			argModInfo.setaMode(mode);
			argModInfo.setbMode(mode2);
			argModInfo.setcMode(mode);
			argModInfo.setdMode(mode);
			argModInfo.seteMode(mode);
			argModInfo.setfMode(mode);
			argModInfo.setgMode(mode);
			argModInfo.setzMode(mode);
			argModInfo.sethMode(mode);
		gasInfo.setGasArrange(argModInfo);

	System.out.println(t.getHolidayList(gasInfo));
		assertTrue(true);
	}

	@Test
	public void testGetDaysNumInMonth() {
		System.out.println(t.getDaysNumInMonth("201206"));
		if(t.getDaysNumInMonth("201206")!=30){
			
			assertTrue(false);
		}
	
	}

	@Test
	public void testComputeModeHour() {
		ModeInfo modInfo = new ModeInfo();
		modInfo.setModeTime("14:30~16:00");
		if(t.computeModeHour(modInfo)!=1.5){
			assertTrue(false);
		}
	}

	

}
