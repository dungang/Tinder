/**
 * TODO
 * 上午12:03:54
 */
package cn.tinder.das.struts.form;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 *
 */
public class GasForm extends ActionForm
{
    private String gasName;
 
    private String department;
    
    private String newGasName;
    
    private String newDepartment;
 
    private String newGasNum;

    public String getGasName()
    {
        return gasName;
    }

    public void setGasName(String gasName)
    {
        this.gasName = gasName;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getNewGasName()
    {
        return newGasName;
    }

    public void setNewGasName(String newGasName)
    {
        this.newGasName = newGasName;
    }

    public String getNewDepartment()
    {
        return newDepartment;
    }

    public void setNewDepartment(String newDepartment)
    {
        this.newDepartment = newDepartment;
    }

    public String getNewGasNum()
    {
        return newGasNum;
    }

    public void setNewGasNum(String newGasNum)
    {
        this.newGasNum = newGasNum;
    }

   
 
}
