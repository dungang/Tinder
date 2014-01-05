/**
 * TODO
 * 上午03:18:18
 */
package cn.tinder.das.struts.data;

/**
 * @author Administrator
 *
 */
public class ModeForm
{
    private String modeName;  //������
    private TimeForm modeTime1 = new TimeForm();  //���ʱ��
    private TimeForm modeTime2 = new TimeForm();  //���ʱ��
    private TimeForm modeTime3 = new TimeForm();  //���ʱ��
    private float modeHours;    //���ʱ��
    private float modeAvgNum; //���ƽ������
    public String getModeName()
    {
        return modeName;
    }
    public void setModeName(String modeName)
    {
        this.modeName = modeName;
    }
    public TimeForm getModeTime1()
    {
        return modeTime1;
    }
    public void setModeTime1(TimeForm modeTime1)
    {
        this.modeTime1 = modeTime1;
    }
    public TimeForm getModeTime2()
    {
        return modeTime2;
    }
    public void setModeTime2(TimeForm modeTime2)
    {
        this.modeTime2 = modeTime2;
    }
    public TimeForm getModeTime3()
    {
        return modeTime3;
    }
    public void setModeTime3(TimeForm modeTime3)
    {
        this.modeTime3 = modeTime3;
    }
    public float getModeHours()
    {
        return modeHours;
    }
    public void setModeHours(float modeHours)
    {
        this.modeHours = modeHours;
    }
    public float getModeAvgNum()
    {
        return modeAvgNum;
    }
    public void setModeAvgNum(float modeAvgNum)
    {
        this.modeAvgNum = modeAvgNum;
    }
    @Override
    public String toString()
    {
        return "ModeForm [modeName=" + modeName + ", modeTime1=" + modeTime1
                + ", modeTime2=" + modeTime2 + ", modeTime3=" + modeTime3
                + ", modeHours=" + modeHours + ", modeAvgNum=" + modeAvgNum
                + "]";
    }
    

}
