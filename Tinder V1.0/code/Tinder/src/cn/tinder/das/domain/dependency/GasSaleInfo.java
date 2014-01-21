package cn.tinder.das.domain.dependency;

/**
 * 
 * @author Administrator
 * 加油站的营业情况
 */
public class GasSaleInfo
{
    private int businessHours;  //营业时间
    private String businessTime; //营业时段
    
    private int saleNum;    //销售量
    private int saleMoney;  //销售额
    private int cardScale;  //持卡比例
    public int getBusinessHours()
    {
        return businessHours;
    }
    public void setBusinessHours(int businessHours)
    {
        this.businessHours = businessHours;
    }
    public String getBusinessTime()
    {
        return businessTime;
    }
    public void setBusinessTime(String businessTime)
    {
        this.businessTime = businessTime;
    }
    public int getSaleNum()
    {
        return saleNum;
    }
    public void setSaleNum(int saleNum)
    {
        this.saleNum = saleNum;
    }
    public int getSaleMoney()
    {
        return saleMoney;
    }
    public void setSaleMoney(int saleMoney)
    {
        this.saleMoney = saleMoney;
    }
    public int getCardScale()
    {
        return cardScale;
    }
    public void setCardScale(int cardScale)
    {
        this.cardScale = cardScale;
    }
    @Override
    public String toString()
    {
        return "GasSaleInfo [businessHours=" + businessHours
                + ", businessTime=" + businessTime + ", saleNum=" + saleNum
                + ", saleMoney=" + saleMoney + ", cardScale=" + cardScale + "]";
    }

}
