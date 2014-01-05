/**
 * TODO
 * 下午01:29:58
 */
package cn.tinder.das.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * @author Administrator
 *
 */
public class ArrangeIndexForm extends ActionForm
{
    private String year="";
    private String month="";
    private String departName="";
    private String gasName="";

    
    public String getYear()
    {
        return year;
    }
    public void setYear(String year)
    {
        this.year = year;
    }
    public String getMonth()
    {
        return month;
    }
    public void setMonth(String month)
    {
        this.month = month;
    }
    public String getDepartName()
    {
        return departName;
    }
    public void setDepartName(String departName)
    {
        this.departName = departName;
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
    public String toString()
    {
        return "ArrangeIndexForm [year=" + year + ", month=" + month
                + ", departName=" + departName + ", gasName=" + gasName + "]";
    }



}