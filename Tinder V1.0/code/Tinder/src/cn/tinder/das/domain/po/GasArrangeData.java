package cn.tinder.das.domain.po;

import cn.tinder.das.domain.dependency.GasArrangeIndex;

public class GasArrangeData
{
    private GasArrangeIndex index;

    
    private String job;
    private String workDays;
    
    private int sumHours;
    private float sumDays;
    private float holidays;
    private float overHours;
    private float restDays;
    
    public GasArrangeIndex getIndex()
    {
        return index;
    }
    public void setIndex(GasArrangeIndex index)
    {
        this.index = index;
    }
    public String getJob()
    {
        return job;
    }
    public void setJob(String job)
    {
        this.job = job;
    }
    public String getWorkDays()
    {
        return workDays;
    }
    public void setWorkDays(String workDays)
    {
        this.workDays = workDays;
    }
    public int getSumHours()
    {
        return sumHours;
    }
    public void setSumHours(int sumHours)
    {
        this.sumHours = sumHours;
    }
    public float getSumDays()
    {
        return sumDays;
    }
    public void setSumDays(float sumDays)
    {
        this.sumDays = sumDays;
    }
    public float getHolidays()
    {
        return holidays;
    }
    public void setHolidays(float holidays)
    {
        this.holidays = holidays;
    }
    public float getOverHours()
    {
        return overHours;
    }
    public void setOverHours(float overHours)
    {
        this.overHours = overHours;
    }
    public float getRestDays()
    {
        return restDays;
    }
    public void setRestDays(float restDays)
    {
        this.restDays = restDays;
    }
    @Override
    public String toString()
    {
        return "GasArrangeData [index=" + index + ", job=" + job
                + ", workDays=" + workDays + ", sumHours=" + sumHours
                + ", sumDays=" + sumDays + ", holidays=" + holidays
                + ", overHours=" + overHours + ", restDays=" + restDays + "]";
    }

    
}
