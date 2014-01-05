package cn.tinder.das.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RoleForm extends ActionForm
{

    private String role;
    
    public RoleForm()
    {
        
    }
    
    public RoleForm(String role) {
		// TODO Auto-generated constructor stub
	   this.setRole(role);
	}
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }

    

}
