package cn.tinder.das.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import cn.tinder.das.dao.SystemUserDao;
import cn.tinder.das.dao.impl.SystemUserDaoImpl;
import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;
import cn.tinder.das.exception.ExportException;
import cn.tinder.das.exception.message.ExportExceptionMessage;
import cn.tinder.das.service.Impl.ExportServiceImpl;
import cn.tinder.das.service.data.GasAllInfo;
import cn.tinder.das.util.constant.PropertyName;
import cn.tinder.das.util.file.ZipUtil;

public class ExportExcelImpl implements ExportEcxel
{
    private static final Log log = LogFactory.getLog(ExportExcelImpl.class);

    DecimalFormat df = new DecimalFormat("0.0");

    public String exoprtSumSheet(List<GasInformation> allGasInfo,
            List<CompanySumInfo> allCmpInfo, Map<String, String> gsNumMap,
            Map<String, String> gsDepMap, String yearMonth)
    {
        // TODO Auto-generated method stub
        String sumSheetName = yearMonth + "加油站排版汇总表";

        try
        {

            // 获取模板表格

            // TODO 这里需要调整为从配置文件读取目录。
            File sumMod = new File(
                    ConfigInformation
                            .getPropertyByName(PropertyName.MOD_PATH_SUM));
            File sumSheet = new File(
                    ConfigInformation
                            .getPropertyByName(PropertyName.EXPORT_PATH)
                            + sumSheetName + ".xls");

            // 写入模版
            Workbook workBook = null;
            WritableWorkbook book = null;
            try
            {
                workBook = Workbook.getWorkbook(sumMod);
                book = Workbook.createWorkbook(sumSheet, workBook);

                if (workBook == null)
                {
                    throw new ExportException(
                            ExportExceptionMessage.EXPORT_ERR_GASMOD);
                } else if (book == null)
                {
                    throw new ExportException(
                            ExportExceptionMessage.EXPORT_ERR_GASSHEET);
                } else
                {
                    // jxl.Workbook
                    // 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new
                    // File(excelpath)）

                    WritableSheet sheet = null;
                    if (book.getNumberOfSheets() > 0)
                    {
                        sheet = book.getSheet(0); // 获取第一个sheet
                    } else
                    {
                        throw new ExportException(
                                ExportExceptionMessage.EXPORT_ERR_NOSHEET);
                    }

                    // jxl.Workbook
                    // 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new
                    // File(excelpath)）

                    int row = 8;
                    for (int i = 0; i < allGasInfo.size(); i++)
                    {
                        int j = 0; // 查询对应Index
                        System.out.println(sumSheetName);
                        while (!allCmpInfo
                                .get(j)
                                .getIndex()
                                .getGasName()
                                .equals(allGasInfo.get(i).getIndex()
                                        .getGasName()))
                        {
                            j++;
                        }

                        // 开始数据写入
                        writeLabel(sheet, row + i, 1, i + 1);// 标题
                        writeLabel(
                                sheet,
                                row + i,
                                2,
                                gsNumMap.get(allGasInfo.get(i).getIndex()
                                        .getGasName()));// 油站编码
                        // DAO
                        SystemUserDao systemUserDao = new SystemUserDaoImpl();
                        try
                        {
                            writeLabel(
                                    sheet,
                                    row + i,
                                    2,
                                    systemUserDao.getSystemUserByName(
                                            allGasInfo.get(i).getIndex()
                                                    .getGasName())
                                            .getDepartment());// 油站编码
                        } catch (RuntimeException ex)
                        {
                            ;
                        }
                        writeLabel(sheet, row + i, 4, allGasInfo.get(i)
                                .getIndex().getGasName());// 加油站
                        writeLabel(sheet, row + i, 5, allGasInfo.get(i)
                                .getSaleInfo().getSaleNum());// 油品销量
                        writeLabel(sheet, row + i, 6, allGasInfo.get(i)
                                .getSaleInfo().getSaleMoney());// 非油
                        writeLabel(sheet, row + i, 7, allGasInfo.get(i)
                                .getSaleInfo().getCardScale());// 持卡比例
                        writeLabel(
                                sheet,
                                row + i,
                                8,
                                df.format(allGasInfo.get(i).getSaleInfo()
                                        .getBusinessHours()));// 营业时间
                        writeLabel(sheet, row + i, 9, allGasInfo.get(i)
                                .getSaleInfo().getBusinessTime());// 营业时段
                        writeLabel(
                                sheet,
                                row + i,
                                10,
                                df.format(allGasInfo.get(i).getStaffInfo()
                                        .getStaffNum()));// 用工人数
                        writeLabel(
                                sheet,
                                row + i,
                                11,
                                df.format(allGasInfo.get(i).getStaffInfo()
                                        .getAvgRestDay()));// 月安排休息
                        writeLabel(
                                sheet,
                                row + i,
                                12,
                                df.format(allGasInfo.get(i).getStaffInfo()
                                        .getAllDayRest()));// 整天休息人数

                        /* 这里限制死了格式 */
                        for (int k = 0; k < 31; k++)
                        {
                            // 休息详情
                            writeLabel(sheet, row + i, 13 + k, allCmpInfo
                                    .get(j).getRestInfo().split(",")[k]);
                        }
                        writeLabel(sheet, row + i, 44, allGasInfo.get(i)
                                .getGasArrange().getArrangeName());// 排班方式

                        writeLabel(sheet, row + i, 45, allGasInfo.get(i)
                                .getGasArrange().getaMode().getModeTime());// A时间
                        writeLabel(
                                sheet,
                                row + i,
                                46,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getaMode().getModeAvgNum()));// A人数
                        writeLabel(sheet, row + i, 47, allGasInfo.get(i)
                                .getGasArrange().getbMode().getModeTime());// B时间
                        writeLabel(
                                sheet,
                                row + i,
                                48,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getbMode().getModeAvgNum()));// b人数
                        writeLabel(sheet, row + i, 49, allGasInfo.get(i)
                                .getGasArrange().getcMode().getModeTime());// c时间
                        writeLabel(
                                sheet,
                                row + i,
                                50,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getcMode().getModeAvgNum()));// c人数

                        writeLabel(sheet, row + i, 51, allGasInfo.get(i)
                                .getGasArrange().getdMode().getModeTime());// d时间
                        writeLabel(
                                sheet,
                                row + i,
                                52,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getdMode().getModeAvgNum()));// d人数
                        writeLabel(sheet, row + i, 53, allGasInfo.get(i)
                                .getGasArrange().geteMode().getModeTime());// e时间
                        writeLabel(
                                sheet,
                                row + i,
                                54,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .geteMode().getModeAvgNum()));// e人数
                        writeLabel(sheet, row + i, 55, allGasInfo.get(i)
                                .getGasArrange().getfMode().getModeTime());// f时间
                        writeLabel(
                                sheet,
                                row + i,
                                56,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getfMode().getModeAvgNum()));// f人数

                        writeLabel(sheet, row + i, 57, allGasInfo.get(i)
                                .getGasArrange().getgMode().getModeTime());// g时间
                        writeLabel(
                                sheet,
                                row + i,
                                58,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getgMode().getModeAvgNum()));// g人数
                        writeLabel(sheet, row + i, 59, allGasInfo.get(i)
                                .getGasArrange().gethMode().getModeTime());// h时间
                        writeLabel(
                                sheet,
                                row + i,
                                60,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .gethMode().getModeAvgNum()));// h人数
                        writeLabel(sheet, row + i, 61, allGasInfo.get(i)
                                .getGasArrange().getzMode().getModeTime());// z时间
                        writeLabel(
                                sheet,
                                row + i,
                                62,
                                df.format(allGasInfo.get(i).getGasArrange()
                                        .getzMode().getModeAvgNum()));// z人数

                    }
                }

                book.write();// 将修改保存到workbook --》一定要保存
                book.close();// 关闭workbook，释放内存 ---》一定要释放内存
                workBook.close();

            } catch (BiffException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            catch (RowsExceededException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (WriteException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return ConfigInformation
                    .getPropertyByName(PropertyName.EXPORT_PATH)
                    + sumSheetName
                    + ".xls";

        } catch (ExportException ex)
        {
            throw new RuntimeException(ex);
        }

    }

    // /////////////////////////////////////////////////////////////////////////////////

    public String exoprtGasSheet(GasInformation gasInfo,
            CompanySumInfo sumInfo, List<GasArrangeData> gasArgData,
            SystemUser systemUser,String exportPath)
    {
        // 输出路径

        String gasSheetName = systemUser.getUserName()
                + gasInfo.getIndex().getYearMonth();

        try
        {

            // 获取模板表格

            // TODO 这里需要调整为从配置文件读取目录。
            File gasStationMod = new File(
                    ConfigInformation
                            .getPropertyByName(PropertyName.MOD_PATH_GASSTATION));
//            File gasSheet = new File(
//                    ConfigInformation
//                            .getPropertyByName(PropertyName.EXPORT_PATH)
//                            + gasSheetName + ".xls");
            File gasSheet = new File(exportPath+gasSheetName + ".xls");

            // 写入模版
            Workbook workBook = null;
            WritableWorkbook book = null;
            try
            {
                workBook = Workbook.getWorkbook(gasStationMod);
                book = Workbook.createWorkbook(gasSheet, workBook);

                // 探空
                if (workBook == null)
                {
                    throw new ExportException(
                            ExportExceptionMessage.EXPORT_ERR_GASMOD);
                } else if (book == null)
                {
                    throw new ExportException(
                            ExportExceptionMessage.EXPORT_ERR_GASSHEET);
                } else
                {
                    // jxl.Workbook
                    // 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new
                    // File(excelpath)）

                    WritableSheet sheet = null;
                    if (book.getNumberOfSheets() > 0)
                    {
                        sheet = book.getSheet(0); // 获取第一个sheet
                    } else
                    {
                        throw new ExportException(
                                ExportExceptionMessage.EXPORT_ERR_NOSHEET);
                    }

                    // 开始数据写入
                    writeLabel(sheet, 1, 1, gasSheetName + "加油站排班表");
                    writeLabel(sheet, 3, 5, systemUser.getDepartment());// 经管部
                    writeLabel(sheet, 3, 11, gasInfo.getSaleInfo()
                            .getBusinessHours()); // 营业小时数
                    writeLabel(sheet, 4, 11, gasInfo.getSaleInfo()
                            .getBusinessTime()); // 营业时间
                    writeLabel(sheet, 4, 7, gasInfo.getSaleInfo()
                            .getCardScale()); // 持卡比例
                    writeLabel(sheet, 5, 5, gasInfo.getSaleInfo()
                            .getSaleMoney()); // 非油销售额
                    writeLabel(sheet, 4, 3, gasInfo.getSaleInfo().getSaleNum()); // 销量

                    writeLabel(sheet, 5, 16,
                            df.format(gasInfo.getStaffInfo().getAvgRestDay())); // 休息天数
                    writeLabel(sheet, 4, 16,
                            df.format(gasInfo.getStaffInfo().getAvgRestStaff())); // 平均人数
                    writeLabel(sheet, 3, 16,
                            df.format(gasInfo.getStaffInfo().getStaffNum())); // 员工人数

                    writeLabel(sheet, 5, 11, gasInfo.getGasArrange()
                            .getArrangeName()); // 获得排班
                    String mod;
                    // a
                    mod = gasInfo.getGasArrange().getaMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getaMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 6, 2, mod);
                    // B
                    mod = gasInfo.getGasArrange().getbMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getbMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 6, 11, mod);
                    // C
                    mod = gasInfo.getGasArrange().getcMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getcMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 6, 20, mod);
                    // D
                    mod = gasInfo.getGasArrange().getdMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getdMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 7, 2, mod);
                    // E
                    mod = gasInfo.getGasArrange().geteMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().geteMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 7, 11, mod);
                    // F
                    mod = gasInfo.getGasArrange().getfMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getfMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 7, 20, mod);
                    // G
                    mod = gasInfo.getGasArrange().getgMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getgMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 10, 2, mod);
                    // H
                    mod = gasInfo.getGasArrange().gethMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().gethMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 10, 11, mod);
                    // Z
                    mod = gasInfo.getGasArrange().getzMode().getModeName()
                            + "班（"
                            + gasInfo.getGasArrange().getzMode().getModeHours()
                            + "小时）";
                    writeLabel(sheet, 10, 20, mod);
                    // 平均人数
                    writeLabel(
                            sheet,
                            3,
                            22,
                            df.format(gasInfo.getGasArrange().getaMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            4,
                            22,
                            df.format(gasInfo.getGasArrange().getbMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            5,
                            22,
                            df.format(gasInfo.getGasArrange().getcMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            3,
                            27,
                            df.format(gasInfo.getGasArrange().getdMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            4,
                            27,
                            df.format(gasInfo.getGasArrange().geteMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            5,
                            27,
                            df.format(gasInfo.getGasArrange().getfMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            3,
                            32,
                            df.format(gasInfo.getGasArrange().getgMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            4,
                            32,
                            df.format(gasInfo.getGasArrange().gethMode()
                                    .getModeAvgNum()));
                    writeLabel(
                            sheet,
                            5,
                            32,
                            df.format(gasInfo.getGasArrange().getzMode()
                                    .getModeAvgNum()));

                    // 时间
                    writeLabel(sheet, 6, 6, gasInfo.getGasArrange().getaMode()
                            .getModeTime(0));// a
                    writeLabel(sheet, 6, 15, gasInfo.getGasArrange().getbMode()
                            .getModeTime(0));// b
                    writeLabel(sheet, 6, 24, gasInfo.getGasArrange().getcMode()
                            .getModeTime(0));// c

                    writeLabel(sheet, 7, 6, gasInfo.getGasArrange().getdMode()
                            .getModeTime(0));// d1
                    writeLabel(sheet, 8, 6, gasInfo.getGasArrange().getdMode()
                            .getModeTime(1));// d2
                    writeLabel(sheet, 9, 6, gasInfo.getGasArrange().getdMode()
                            .getModeTime(2));// d3

                    writeLabel(sheet, 7, 15, gasInfo.getGasArrange().geteMode()
                            .getModeTime(0));// e1
                    writeLabel(sheet, 8, 15, gasInfo.getGasArrange().geteMode()
                            .getModeTime(1));// e2
                    writeLabel(sheet, 9, 15, gasInfo.getGasArrange().geteMode()
                            .getModeTime(2));// e3
                    //
                    writeLabel(sheet, 7, 24, gasInfo.getGasArrange().getfMode()
                            .getModeTime(0));// f1
                    writeLabel(sheet, 8, 24, gasInfo.getGasArrange().getfMode()
                            .getModeTime(1));// f2
                    writeLabel(sheet, 9, 24, gasInfo.getGasArrange().getfMode()
                            .getModeTime(2));// f3

                    writeLabel(sheet, 10, 6, gasInfo.getGasArrange().getgMode()
                            .getModeTime(0));// g1
                    writeLabel(sheet, 11, 6, gasInfo.getGasArrange().getgMode()
                            .getModeTime(1));// g2
                    writeLabel(sheet, 12, 6, gasInfo.getGasArrange().getgMode()
                            .getModeTime(2));// g3

                    writeLabel(sheet, 10, 15, gasInfo.getGasArrange()
                            .gethMode().getModeTime(0));// h1
                    writeLabel(sheet, 11, 15, gasInfo.getGasArrange()
                            .gethMode().getModeTime(1));// h2
                    writeLabel(sheet, 12, 15, gasInfo.getGasArrange()
                            .gethMode().getModeTime(2));// h3

                    writeLabel(sheet, 10, 24, gasInfo.getGasArrange()
                            .getzMode().getModeTime(0));// z1
                    writeLabel(sheet, 11, 24, gasInfo.getGasArrange()
                            .getzMode().getModeTime(1));// z2
                    writeLabel(sheet, 12, 24, gasInfo.getGasArrange()
                            .getzMode().getModeTime(2));// z3

                    // 排班表

                    for (int i = 0; i < gasArgData.size(); i++)
                    {

                        // Name
                        writeLabel(sheet, 16 + i * 2, 2, gasArgData.get(i)
                                .getIndex().getStaffName());
                        // Job
                        writeLabel(sheet, 16 + i * 2, 3, gasArgData.get(i)
                                .getJob());
                        // Arr
                        String arr = gasArgData.get(i).getWorkDays();
                        for (int j = 0; j < 31; j++)
                        {

                            String c = arr.substring(j, j + 1);
                            writeLabel(sheet, 16 + i * 2, 5 + j, c);
                        }
                        // SUMHour
                        writeLabel(sheet, 16 + i * 2, 36, gasArgData.get(i)
                                .getSumHours());
                        // holidays
                        writeLabel(sheet, 16 + i * 2, 37, gasArgData.get(i)
                                .getHolidays());
                        // OverHours
                        writeLabel(sheet, 16 + i * 2, 38, gasArgData.get(i)
                                .getOverHours());
                        //
                        writeLabel(sheet, 16 + i * 2, 40, gasArgData.get(i)
                                .getRestDays());
                        //
                        writeLabel(sheet, 16 + i * 2, 39, gasArgData.get(i)
                                .getSumDays());

                    }
                }

                book.write();// 将修改保存到workbook --》一定要保存
                book.close();// 关闭workbook，释放内存 ---》一定要释放内存
                workBook.close();
            } catch (BiffException e)
            {
                throw new ExportException(e.getMessage());
            } catch (RowsExceededException e)
            {
                throw new ExportException(e.getMessage());
            } catch (WriteException e)
            {
                throw new ExportException(e.getMessage());
            } catch (IOException e)
            {
                // 文件异常
                throw new ExportException(e.getMessage());
            }
            return gasSheet.getAbsolutePath();

        } catch (ExportException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static void writeLabel(WritableSheet sheet, int x, int y, String str)
    {

        WritableCell cell = sheet.getWritableCell(y - 1, x - 1);// 获取第一个单元格\
        jxl.format.CellFormat cf = cell.getCellFormat();// 获取第一个单元格的格式
        jxl.write.Label lbl = new jxl.write.Label(y - 1, x - 1, str);// 将第一个单元格的值改
        if(null != cf)
        {
            lbl.setCellFormat(cf);// 将修改后的单元格的格式设定成跟原来一样
        }
        try
        {
            sheet.addCell(lbl);
        } catch (RowsExceededException e)
        {
            throw new ExportException(e.getMessage());
        } catch (WriteException e)
        {
            throw new ExportException(e.getMessage());
        }
    }

    public String exoprtAllGasSheet(List<GasAllInfo> gasAllInfoList) {
        //TODO :文件名
        //String SheetName = systemUser.getUserName()+gasInfo.getIndex().getYearMonth();
        String filePath = ConfigInformation.getPropertyByName(PropertyName.EXPORT_ALL_PATH);
        String exportFileName = ConfigInformation.getPropertyByName(PropertyName.EXPORT_PATH) + "all.zip";
        File allGasPath = new File(filePath);
        File exportFile = new File(exportFileName);
        if(exportFile.exists())
        {
            exportFile.delete();
        }
        //如果目录存在则删除
        if(allGasPath.exists())
        {
            log.info("the old file number is :" + allGasPath.listFiles().length);
            while(0!=allGasPath.listFiles().length)
            {
                log.info("delele old file : " + allGasPath.listFiles()[0].getName());
                allGasPath.listFiles()[0].delete();
            }
            log.info("the old file number is :" + allGasPath.listFiles().length);
            allGasPath.delete();
            log.info("delete the old path");
        } 
        //创建目录
        allGasPath.mkdir();
        ExportExcelImpl excelUtil = new ExportExcelImpl();
        for(GasAllInfo gasAllInfo : gasAllInfoList)
        {
            log.info("now gas info is"+gasAllInfo);
       
            excelUtil.exoprtGasSheet(gasAllInfo.getGasInfo(), gasAllInfo.getSumInfo(), gasAllInfo.getGasArgData(), gasAllInfo.getSystemUser(), filePath);
            for(int i = 0;i<allGasPath.listFiles().length;i++)
            {
                log.info(allGasPath.listFiles()[i].getName());
            }
        }
        try
        {
            ZipUtil.zip(allGasPath, exportFile);
        } catch (Exception e)
        {
            log.error("zip file wrong");
            throw new ExportException("导出失败");
        }
        return exportFileName;
        
    }

    private void writeLabel(WritableSheet sheet, int x, int y, float f)
    {
        writeLabel(sheet, x, y, String.valueOf(f));
    }

    private void writeLabel(WritableSheet sheet, int x, int y, int i)
    {
        writeLabel(sheet, x, y, String.valueOf(i));
    }

}
