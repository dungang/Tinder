package cn.tinder.das.junit.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.tinder.das.domain.dependency.ArrangeModeInfo;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.dependency.GasSaleInfo;
import cn.tinder.das.domain.dependency.GasStaffInfo;
import cn.tinder.das.domain.dependency.ModeInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.service.ArrangeService;
import cn.tinder.das.service.Impl.ArrangeServiceImpl;
import cn.tinder.das.struts.data.ArrangeDataForm;
import cn.tinder.das.struts.data.ArrangeModeForm;
import cn.tinder.das.struts.data.ArrangeSaleForm;
import cn.tinder.das.struts.data.ArrangeStaffForm;
import cn.tinder.das.struts.data.ModeForm;
import cn.tinder.das.struts.data.TimeForm;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.struts.form.GasArrangeInfoForm;

public class ArrangeTest {
	ArrangeService arrangeService=new ArrangeServiceImpl();

//	@Test

	public void saveArrangeInfomationtest(){
		
		arrangeService.saveArrangeInfomation(createFormForTest());
			
	}
	
	@Test
	public void getHistoryArrangeInfotest(){
		System.out.println(arrangeService.getHistoryArrangeInfo("201303","田头角加油站"));
	}
	
public GasArrangeInfoForm createFormForTest(){
		GasArrangeInfoForm arrangeInfo=new GasArrangeInfoForm();
		List arraneDatas = new ArrayList<ArrangeDataForm>();
		ArrangeDataForm b=new ArrangeDataForm();
				b.setD1("A");
				b.setD2("A");
				b.setD3("B");
				b.setD4("\\");
				b.setD5("\\");
				b.setD6("\\");
				b.setD7("D");
				b.setD8("B");
				b.setD9("A");
				b.setD10("A");
				b.setD11("A");
				b.setD12("E");
				b.setD13("\\");
				b.setD14("\\");
				b.setD15("A");
				b.setD16("A");
				b.setD17("A");
				b.setD18("E");
				b.setD19("\\");
				b.setD20("D");
				b.setD21("A");
				b.setD22("A");
				b.setD23("A");
				b.setD24("A");
				b.setD25("A");
				b.setD26("\\");
				b.setD27("A");
				b.setD28("\\");
				b.setD29("B");
				b.setD30("B");
				b.setD31("B");
				b.setName("某某员工");
				b.setJob("营业员");
				arraneDatas.add(b);
				
	arrangeInfo.setArrangeDatas(arraneDatas);
	
	
			//1
			ArrangeIndexForm gasDataIndex = new ArrangeIndexForm();
				gasDataIndex.setGasName("田头角加油站");
				gasDataIndex.setYear("2013");
				gasDataIndex.setMonth("02");
	arrangeInfo.setIndex(gasDataIndex );
	
			//2
		ArrangeSaleForm gasSaleInfo = new ArrangeSaleForm();
				gasSaleInfo.setBusinessTime(new TimeForm());
				gasSaleInfo.getBusinessTime().setStartHours(07);
				gasSaleInfo.getBusinessTime().setStartMin(30);
				gasSaleInfo.getBusinessTime().setEndHours(07);
				gasSaleInfo.getBusinessTime().setEndMin(30);
				
				gasSaleInfo.setCardScale(50);
				gasSaleInfo.setSaleMoney(1245);
				gasSaleInfo.setSaleNum(3000);
	arrangeInfo.setSaleInfo(gasSaleInfo);
			//3
		
				arrangeInfo.setStaffInfo(new ArrangeStaffForm());
				//全部为计算信息
	
			ArrangeModeForm arrangeModeInfo = new ArrangeModeForm();
				arrangeModeInfo.setArrangeName("五班三运转");
				ModeForm modinfA = new ModeForm();
			
				modinfA.setModeName("A");
				modinfA.setModeTime1(new TimeForm());
					modinfA.getModeTime1().setStartHours(07);
					modinfA.getModeTime1().setStartMin(00);
					modinfA.getModeTime1().setEndHours(15);
					modinfA.getModeTime1().setEndMin(00);
					
					ModeForm modinfB = new ModeForm();
					modinfB.setModeName("B");
					modinfB.setModeTime1(new TimeForm());
						modinfB.getModeTime1().setStartHours(15);
						modinfB.getModeTime1().setStartMin(00);
						modinfB.getModeTime1().setEndHours(23);
						modinfB.getModeTime1().setEndMin(00);

						ModeForm modinfC = new ModeForm();
						modinfB.setModeName("C");
						modinfB.setModeTime1(new TimeForm());
							modinfB.getModeTime1().setStartHours(15);
							modinfB.getModeTime1().setStartMin(00);
							modinfB.getModeTime1().setEndHours(23);
							modinfB.getModeTime1().setEndMin(00);
							
							ModeForm modinfD = new ModeForm();
							modinfB.setModeName("D");
							modinfB.setModeTime1(new TimeForm());
								modinfB.getModeTime1().setStartHours(15);
								modinfB.getModeTime1().setStartMin(00);
								modinfB.getModeTime1().setEndHours(23);
								modinfB.getModeTime1().setEndMin(00);
						
						
				arrangeModeInfo.setaMode(modinfA);
				arrangeModeInfo.setbMode(modinfB);
				arrangeModeInfo.setcMode(modinfC);
				arrangeModeInfo.setdMode(modinfD);
				arrangeModeInfo.seteMode(modinfA);
				arrangeModeInfo.setfMode(modinfB);
				arrangeModeInfo.setgMode(modinfC);
				arrangeModeInfo.sethMode(modinfD);
				arrangeModeInfo.setzMode(modinfA);
				
		
			
					

		arrangeInfo.setArrangeInfo(arrangeModeInfo);	
		
		return arrangeInfo;
		
	}
}
