/**
 * TODO
 * 上午03:12:55
 */
package cn.tinder.das.struts.data;

/**
 * @author Administrator
 *
 */
public class TimeForm
{
    private int startHours;
    private int startMin;
    private int endHours;
    private int endMin;
    public int getStartHours()
    {
        return startHours;
    }
    public void setStartHours(int startHours)
    {
        this.startHours = startHours;
    }
    public int getStartMin()
    {
        return startMin;
    }
    public void setStartMin(int startMin)
    {
        this.startMin = startMin;
    }
    public int getEndHours()
    {
        return endHours;
    }
    public void setEndHours(int endHours)
    {
        this.endHours = endHours;
    }
    public int getEndMin()
    {
        return endMin;
    }
    public void setEndMin(int endMin)
    {
        this.endMin = endMin;
    }
    @Override
    public String toString()
    {
        return "TimeForm [startHours=" + startHours + ", startMin=" + startMin
                + ", endHours=" + endHours + ", endMin=" + endMin + "]";
    }
    
}
