package cn.tinder.das.domain.po;

import cn.tinder.das.domain.dependency.GasDataIndex;

/**
 * 
 * @author Administrator
 * ��˾������Ϣ����Ҫ�Ǵ�ÿ���ݼٵ�������
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
