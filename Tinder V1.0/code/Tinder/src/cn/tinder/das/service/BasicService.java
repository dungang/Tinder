/**
 * TODO
 * 上午02:04:24
 */
package cn.tinder.das.service;

import java.util.List;
import java.util.Map;

import cn.tinder.das.service.data.GasAllInfo;
import cn.tinder.das.struts.form.ArrangeIndexForm;

/**
 * @author Administrator
 *
 */
public interface BasicService
{
    public List<String> getAllYear();
    public List<String> getAllMonth();
    public List<String> getAllJob();
    public List<String> getAllArrangeMode();
    public List<String> getAllDepart();
    public List<String> getAllGasNameByDepartName(String name);
    public List<String> getAllUserNameByRole(String role);
    public String getRoleByName(String name);
    public String getDepartByName(String name);
    public Map<String,List<String>> getDepartMapGas(List<String> departments);
    public String getMonthDays(String year,String month);
 

}
