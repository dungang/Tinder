package cn.tinder.das.domain.dependency;

/**
 * 
 * @author Administrator
 * ����վ��Ӫҵ���
 */
public class GasSaleInfo
{
    private int businessHours;  //Ӫҵʱ��
    private String businessTime; //Ӫҵʱ��
    
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
