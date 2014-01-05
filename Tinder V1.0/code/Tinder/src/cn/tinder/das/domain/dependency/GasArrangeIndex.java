/**
 * TODO
 * ����02:28:26
 */
package cn.tinder.das.domain.dependency;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class GasArrangeIndex implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String yearMonth;
    private String gasName;
    private String staffName;
    public String getYearMonth()
    {
        return yearMonth;
    }
    public void setYearMonth(String yearMonth)
    {
        this.yearMonth = yearMonth;
    }
    public String getGasName()
    {
        return gasName;
    }
    public void setGasName(String gasName)
    {
        this.gasName = gasName;
    }
    public String getStaffName()
    {
        return staffName;
    }
    public void setStaffName(String staffName)
    {
        this.staffName = staffName;
    }
    @Override
    public String toString()
    {
        return "GasArrangeIndex [yearMonth=" + yearMonth + ", gasName="
                + gasName + ", staffName=" + staffName + "]";
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gasName == null) ? 0 : gasName.hashCode());
        result = prime * result
                + ((staffName == null) ? 0 : staffName.hashCode());
        result = prime * result
                + ((yearMonth == null) ? 0 : yearMonth.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GasArrangeIndex other = (GasArrangeIndex) obj;
        if (gasName == null)
        {
            if (other.gasName != null)
                return false;
        } else if (!gasName.equals(other.gasName))
            return false;
        if (staffName == null)
        {
            if (other.staffName != null)
                return false;
        } else if (!staffName.equals(other.staffName))
            return false;
        if (yearMonth == null)
        {
            if (other.yearMonth != null)
                return false;
        } else if (!yearMonth.equals(other.yearMonth))
            return false;
        return true;
    }

}
