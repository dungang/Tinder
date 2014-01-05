package cn.tinder.das.service;

import java.util.List;

import cn.tinder.das.service.data.BasicArrangeInfo;
import cn.tinder.das.struts.form.GasArrangeInfoForm;

public interface ArrangeService extends BasicService
{
   
    public GasArrangeInfoForm getHistoryArrangeInfo(String yearMonth,String gasName);
    public void saveArrangeInfomation(GasArrangeInfoForm arrnageInfo);
    public GasArrangeInfoForm getArrangeInfo(String yearMonth,String gasName);
    public String getHolidaysByYearMonth(String year,String month);
}
