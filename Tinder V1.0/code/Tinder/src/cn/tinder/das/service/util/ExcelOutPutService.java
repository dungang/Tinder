package cn.tinder.das.service.util;

import java.util.List;

import cn.tinder.das.service.data.GasStatus;

public interface ExcelOutPutService {
	
	
	/**
	 * @author Nan 
	 * 
	 * Output the list to a Excel
	 * 
	 * @param list
	 * @return
	 */
	public String ouypuyGasStatusList(List<GasStatus> list);
}
