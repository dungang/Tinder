/**
 * TODO
 * 上午12:40:10
 */
package cn.tinder.das.service.data;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class BasicArrangeInfo
{
    private List<String> holidays;
    private List<String> jobs;
    private List<String> modes;
    public List<String> getHolidays()
    {
        return holidays;
    }
    public void setHolidays(List<String> holidays)
    {
        this.holidays = holidays;
    }
    public List<String> getJobs()
    {
        return jobs;
    }
    public void setJobs(List<String> jobs)
    {
        this.jobs = jobs;
    }
    public List<String> getModes()
    {
        return modes;
    }
    public void setModes(List<String> modes)
    {
        this.modes = modes;
    }
    @Override
    public String toString()
    {
        return "BasicArrangeInfo [holidays=" + holidays + ", jobs=" + jobs
                + ", modes=" + modes + "]";
    }
    

}
