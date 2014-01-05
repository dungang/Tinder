package cn.tinder.das.domain.po;

import cn.tinder.das.domain.dependency.GasDataIndex;

/**
 * 
 * @author Administrator
 * 公司汇总信息，主要是存每天休假的人数。
 */
public class CompanySumInfo
{
    private GasDataIndex index;   
    private String restInfo;
    public GasDataIndex getIndex()
    {
        return index;
    }
    public void setIndex(GasDataIndex index)
    {
        this.index = index;
    }
    public String getRestInfo()
    {
        return restInfo;
    }
    public void setRestInfo(String restInfo)
    {
        this.restInfo = restInfo;
    }
    @Override
    public String toString()
    {
        return "CompanySumInfo [index=" + index + ", restInfo=" + restInfo
                + "]";
    }
    

}
