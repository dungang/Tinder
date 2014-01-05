package cn.tinder.das.dao;

import java.util.List;

import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.CompanySumInfo;


public interface CompanySumInfoDao
{
    public void addCompanySumInfo(CompanySumInfo sumInfo);
    public void deleteCompanySumInfo(CompanySumInfo sumInfo);

    public void updateCompanySumInfo(CompanySumInfo sumInfo);
    
    public CompanySumInfo getCompanyInfoByIndex(GasDataIndex index);
    
    public List<CompanySumInfo> getSumInfoByMonth(String yearMonth);

}
