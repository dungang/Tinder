/**
 * 
 */
package cn.tinder.das.dao;

import java.util.List;

import cn.tinder.das.domain.dependency.GasArrangeIndex;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;

/**
 * @author Administrator
 *
 */
public interface GasArrangeDataDao
{
    public void addGasArrangeData(GasArrangeData arrangeData);
    public void deleteGasArrangeData(GasArrangeData arrangeData);
    public void deleteGasArrangeDataByGas(GasInformation gasInfo);

    public void updateGasArrangeData(GasArrangeData arrangeData);
    public GasArrangeData getArrangeByArrangeIndex(GasArrangeIndex index);
    public List<GasArrangeData> getArrangeListByGasDataIndex(GasDataIndex index);
}
