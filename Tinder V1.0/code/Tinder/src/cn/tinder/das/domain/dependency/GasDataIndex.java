package cn.tinder.das.domain.dependency;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 * ��ݱ�����������ºͼ���վȷ����
 */
public class GasDataIndex implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String yearMonth;
    private String gasName;

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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gasName == null) ? 0 : gasName.hashCode());
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
        GasDataIndex other = (GasDataIndex) obj;
        if (gasName == null)
        {
            if (other.gasName != null)
                return false;
        } else if (!gasName.equals(other.gasName))
            return false;
        if (yearMonth == null)
        {
            if (other.yearMonth != null)
                return false;
        } else if (!yearMonth.equals(other.yearMonth))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "GasDataIndex [yearMonth=" + yearMonth + ", gasName=" + gasName
                + "]";
    }
    


}
