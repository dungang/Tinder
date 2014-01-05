/**
 * TODO
 * 上午03:09:53
 */
package cn.tinder.das.struts.data;

/**
 * @author Administrator
 *
 */
public class ArrangeSaleForm
{
    private int businessHours;  //Ӫҵʱ��
    private TimeForm businessTime = new TimeForm(); //Ӫҵʱ��
    
    private int saleNum;    //������
    private int saleMoney;  //���۶�
    private int cardScale;  //�ֿ�����
    public int getBusinessHours()
    {
        return businessHours;
    }
    public void setBusinessHours(int businessHours)
    {
        this.businessHours = businessHours;
    }
    public TimeForm getBusinessTime()
    {
        return businessTime;
    }
    public void setBusinessTime(TimeForm businessTime)
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
        return "ArrangeSaleForm [businessHours=" + businessHours
                + ", businessTime=" + businessTime + ", saleNum=" + saleNum
                + ", saleMoney=" + saleMoney + ", cardScale=" + cardScale + "]";
    }
    

}
