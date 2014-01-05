package cn.tinder.das.jutil;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.tinder.das.service.data.GasStatus;
import cn.tinder.das.service.util.impl.ExcelOutPutServiceImpl;

public class ExcelOutPutServiceImplTest {

	@Test
	public void testOuypuyGasStatusList() {
		List<GasStatus> l = new ArrayList<GasStatus>();
		GasStatus g = new GasStatus();
		g.setGasName("加油站1");
		g.setDepartment("东城");
		g.setStatus("没有排版");
		
		l.add(g);
		GasStatus h = new GasStatus();
	h.setGasName("加油站2");
		h.setDepartment("东城");
		h.setStatus("排版");
		l.add(h);
		
		ExcelOutPutServiceImpl e = new ExcelOutPutServiceImpl();
		e.ouypuyGasStatusList(l);
		
		
		
	}

}
