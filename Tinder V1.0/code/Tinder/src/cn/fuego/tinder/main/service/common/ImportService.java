package cn.fuego.tinder.main.service.common;
/**
 * 
* @ClassName: ImportService 
* @Description: 提供数据导入服务
* @author Nan Bowen
* @date 2014-2-8 上午12:54:00 
*
 */


public interface ImportService {
	/**
	 * 导入员工排班表
	 * @param path
	 */
	public void importShiftList(String path);	
}
