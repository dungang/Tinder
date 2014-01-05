/**
 * TODO
 * 上午03:15:54
 */
package cn.tinder.das.struts.data;

/**
 * @author Administrator
 *
 */
public class ArrangeStaffForm
{
    private float staffNum; //�ù�����
    private float avgRestStaff;  //ƽ��ÿ����Ϣ������
    private float avgRestDay;   //ƽ��ÿ����Ϣ������
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
        return "ArrangeStaffForm [staffNum=" + staffNum + ", avgRestStaff="
                + avgRestStaff + ", avgRestDay=" + avgRestDay + "]";
    }
    

}
