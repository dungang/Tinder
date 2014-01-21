package cn.tinder.das.domain.po;

/**
 * 
 * @author Administrator
 * 用户信息
 */
public class SystemUser 
{
    private String userName;
    private String password;
    private String department;
    private String role;
    private String gasNum;
    private String description;
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public String getGasNum()
    {
        return gasNum;
    }
    public void setGasNum(String gasNum)
    {
        this.gasNum = gasNum;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    @Override
    public String toString()
    {
        return "SystemUser [userName=" + userName + ", password=" + password
                + ", department=" + department + ", role=" + role + ", gasNum="
                + gasNum + ", description=" + description + "]";
    }
    
}

