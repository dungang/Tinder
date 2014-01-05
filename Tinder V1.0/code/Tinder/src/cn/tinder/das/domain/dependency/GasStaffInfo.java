package cn.tinder.das.domain.dependency;

/**
 * 
 * @author Administrator
 * ����վ���ù���Ϣ��
 */
public class GasStaffInfo
{
    private float staffNum; //�ù�����
    private float avgRestStaff;  //ƽ��ÿ����Ϣ������
    private float avgRestDay;   //ƽ��ÿ����Ϣ������
    private float allDayRest;
    public float getStaffNum()
    {
        return staffNum;
    }
    public void setStaffNum(float staffNum)
    {
        this.staffNum = staffNum;
    }
    public float getAvgRestStaff()
    {
        return avgRestStaff;
    }
    public void setAvgRestStaff(float avgRestStaff)
    {
        this.avgRestStaff = avgRestStaff;
    }
    public float getAvgRestDay()
    {
        return avgRestDay;
    }
    public void setAvgRestDay(float avgRestDay)
    {
        this.avgRestDay = avgRestDay;
    }
    @Override
    public String toString()
    {
        return "GasStaffInfo [staffNum=" + staffNum + ", AvgRestStaff="
                + avgRestStaff + ", AvgRestDay=" + avgRestDay + "]";
    }
	public void setAllDayRest(float allDayRest) {
		this.allDayRest = allDayRest;
	}
	public float getAllDayRest() {
		return allDayRest;
	}

}
