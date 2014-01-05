package cn.tinder.das.service;

import cn.tinder.das.struts.form.GasForm;

public interface ManageUserService
{
    public void resetPassword(String userName);
    public void deleteGas(String userName);
    public void addGas(GasForm gasUser);
    public void alterPassword(String userName,String oldPassword,String newPassword);
    public boolean isOldPasswordRight(String userName,String oldPassword);
    public void isNewPasswordRight(String firstPassword,String secondPassword);

}
