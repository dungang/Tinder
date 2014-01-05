/**
 * TODO
 * 上午01:53:15
 */
package cn.tinder.das.service.data;

/**
 * @author Administrator
 *
 */
public class GasStatus
{
    String status;
    String department;
    String gasName;
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
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
        return "GasStatus [status=" + status + ", department=" + department
                + ", gasName=" + gasName + "]";
    }
    

}
