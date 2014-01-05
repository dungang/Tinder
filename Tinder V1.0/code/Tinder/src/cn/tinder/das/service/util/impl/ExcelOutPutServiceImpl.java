package cn.tinder.das.service.util.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import cn.tinder.das.exception.ExportException;
import cn.tinder.das.exception.message.ExportExceptionMessage;
import cn.tinder.das.service.data.GasStatus;
import cn.tinder.das.service.util.ExcelOutPutService;
import cn.tinder.das.util.ConfigInformation;
import cn.tinder.das.util.ExportExcelImpl;
import cn.tinder.das.util.constant.PropertyName;

public class ExcelOutPutServiceImpl implements ExcelOutPutService{

	public String ouypuyGasStatusList(List<GasStatus> list) {
		//test list 
		if(list==null||list.size()==0){
			return null;
		}
		
		String gasStatusFilePath=ConfigInformation.getPropertyByName(PropertyName.EXPORT_PATH_STATUS);
		File gasStatusFile=new File(gasStatusFilePath);
		//Update the File
		if(gasStatusFile.exists()){
			gasStatusFile.delete();
		}
		
		//Excel Op
	   
        WritableWorkbook book = null;
   
       try {
				book = Workbook.createWorkbook(gasStatusFile);
		
         
            if (book == null)
            {
                throw new ExportException(
                        ExportExceptionMessage.EXPORT_ERR_GASSTATUS);
            }else{  
            	WritableSheet sheet = null;
            	sheet=book.createSheet("排班状态", 1);
            	
            	ExportExcelImpl.writeLabel(sheet, 2, 1, "加油站名称");
            	ExportExcelImpl.writeLabel(sheet, 2, 2, "状态");
            	ExportExcelImpl.writeLabel(sheet, 2, 3, "经管部");
            	for(int i=0;i<list.size();i++){
            		ExportExcelImpl.writeLabel(sheet, 3+i, 1, list.get(i).getGasName());
            		ExportExcelImpl.writeLabel(sheet, 3+i, 2, list.get(i).getStatus());
            		ExportExcelImpl.writeLabel(sheet, 3+i, 3, list.get(i).getDepartment());
            		
            	}
            	 book.write();// 将修改保存到workbook --》一定要保存
                 book.close();// 关闭workbook，释放内存 ---》一定要释放内存

            }
        	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
		return gasStatusFile.getAbsolutePath();
	}

}
