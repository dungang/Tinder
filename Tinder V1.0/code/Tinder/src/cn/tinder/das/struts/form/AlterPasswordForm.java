package cn.tinder.das.struts.form;

import org.apache.struts.action.ActionForm;

public class AlterPasswordForm extends ActionForm
{
	private static final long serialVersionUID = 1L;
	private String oldPassword;
	private String newFirstPassword;
	private String newSecondPassword;
	public String getOldPassword()
	{
		return oldPassword;
	}
	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}
	public String getNewFirstPassword()
	{
		return newFirstPassword;
	}
	public void setNewFirstPassword(String newFirstPassword)
	{
		this.newFirstPassword = newFirstPassword;
	}
	public String getNewSecondPassword()
	{
		return newSecondPassword;
	}
	public void setNewSecondPassword(String newSecondPassword)
	{
		this.newSecondPassword = newSecondPassword;
	}
	
}
