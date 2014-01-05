/**
 * TODO
 * 上午01:37:23
 */
package cn.tinder.das.service.data;

import java.util.List;

import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;

/**
 * @author Administrator
 *
 */
public class GasAllInfo
{
    GasInformation gasInfo;
    CompanySumInfo sumInfo; 
    List<GasArrangeData> gasArgData;
    SystemUser systemUser;
    public GasInformation getGasInfo()
    {
        return gasInfo;
    }
    public void setGasInfo(GasInformation gasInfo)
    {
        this.gasInfo = gasInfo;
    }
    public CompanySumInfo getSumInfo()
    {
        return sumInfo;
    }
    public void setSumInfo(CompanySumInfo sumInfo)
    {
        this.sumInfo = sumInfo;
    }
    public List<GasArrangeData> getGasArgData()
    {
        return gasArgData;
    }
    public void setGasArgData(List<GasArrangeData> gasArgData)
    {
        this.gasArgData = gasArgData;
    }
    public SystemUser getSystemUser()
    {
        return systemUser;
    }
    public void setSystemUser(SystemUser systemUser)
    {
        this.systemUser = systemUser;
    }
    @Override
    public String toString()
    {
        return "GasAllInfo [gasInfo=" + gasInfo + ", sumInfo=" + sumInfo
                + ", gasArgData=" + gasArgData + ", systemUser=" + systemUser
                + "]";
    }
    
    
}
