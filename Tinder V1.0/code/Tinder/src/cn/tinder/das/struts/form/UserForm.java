package cn.tinder.das.struts.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String role;
    private String password;
    
    public UserForm()
    {
        
    }
    public UserForm(String userName , String password){
    	this.userName = userName;
    	this.userName = password;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    @Override
    public String toString()
    {
        return "UserForm [userName=" + userName + ", role=" + role
                + ", password=" + password + "]";
    }
     


}
