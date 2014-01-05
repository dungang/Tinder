package cn.tinder.das.domain.po;

import cn.tinder.das.domain.dependency.ArrangeModeInfo;
import cn.tinder.das.domain.dependency.GasDataIndex;
import cn.tinder.das.domain.dependency.GasSaleInfo;
import cn.tinder.das.domain.dependency.GasStaffInfo;

public class GasInformation
{
    private GasDataIndex index;
    

    private GasSaleInfo saleInfo;
    private GasStaffInfo staffInfo;
    private ArrangeModeInfo gasArrange; //
    private String others;
    public GasDataIndex getIndex()
    {
        return index;
    }
    public void setIndex(GasDataIndex index)
    {
        this.index = index;
    }
    public GasSaleInfo getSaleInfo()
    {
        return saleInfo;
    }
    public void setSaleInfo(GasSaleInfo saleInfo)
    {
        this.saleInfo = saleInfo;
    }
    public GasStaffInfo getStaffInfo()
    {
        return staffInfo;
    }
    public void setStaffInfo(GasStaffInfo staffInfo)
    {
        this.staffInfo = staffInfo;
    }
    public ArrangeModeInfo getGasArrange()
    {
        return gasArrange;
    }
    public void setGasArrange(ArrangeModeInfo gasArrange)
    {
        this.gasArrange = gasArrange;
    }
    public String getOthers()
    {
        return others;
    }
    public void setOthers(String others)
    {
        this.others = others;
    }
    @Override
    public String toString()
    {
        return "GasInformation [index=" + index + ", saleInfo=" + saleInfo
                + ", staffInfo=" + staffInfo + ", gasArrange=" + gasArrange
                + ", others=" + others + "]";
    }
    
 
    


}
