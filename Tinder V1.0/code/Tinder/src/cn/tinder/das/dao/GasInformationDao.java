package cn.tinder.das.dao;

import java.util.List;

import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.GasInformation;

public interface GasInformationDao
{

    public void addGasInformation(GasInformation gasInfo);
    public void deleteGasInformation(GasInformation gasInfo);
    public void updateGasInformation(GasInformation gasInfo);
    public GasInformation getGasInfoByIndex(GasDataIndex index);
    public List<GasInformation> getGasInfoListByMonth(String yearMonth);
 
}
