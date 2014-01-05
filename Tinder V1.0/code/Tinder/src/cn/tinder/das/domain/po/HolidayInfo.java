/**
 * TODO
 * 上午02:22:15
 */
package cn.tinder.das.domain.po;

/**
 * @author Administrator
 *
 */
public class HolidayInfo
{
    private String yearMonth;
    private String holidays;
    public String getYearMonth()
    {
        return yearMonth;
    }
    public void setYearMonth(String yearMonth)
    {
        this.yearMonth = yearMonth;
    }
    public String getHolidays()
    {
        return holidays;
    }
    public void setHolidays(String holidays)
    {
        this.holidays = holidays;
    }
    @Override
    public String toString()
    {
        return "HolidayInfo [yearMonth=" + yearMonth + ", holidays=" + holidays
                + ", getYearMonth()=" + getYearMonth() + ", getHolidays()="
                + getHolidays() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
    
}
