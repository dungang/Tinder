package cn.fuego.tinder.main.service.common.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.fuego.tinder.main.service.common.ImportService;

/**
 * 
* @ClassName: ImportServiceImplTest 
* @Description: 测试导入服务程序
* @author Nan Bowen
* @date 2014-2-8 上午12:56:58 
*
 */
public class ImportServiceImplTest {
	ImportService service= new ImportServiceImpl();
	
	
	@Test
	/**
	 * 排班表导入测试
	 */
	public void testImportShiftList() {
		String path = "";
		
		service.importShiftList(path);
		assertEquals();
		
	}

}
