/**
 * TODO
 * 上午01:49:20
 */
package cn.tinder.das.struts.action.arrange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.tinder.das.exception.message.BasicExceptionMessage;
import cn.tinder.das.service.BasicService;
import cn.tinder.das.service.Impl.BasicServiceImpl;
import cn.tinder.das.struts.form.UserForm;
import cn.tinder.das.util.LoginRole;
import cn.tinder.das.util.constant.OperationConstant;

/**
 * @author Administrator
 *
 */
public class SelectConditionAction extends Action
{
    private static final Log log = LogFactory.getLog(SelectConditionAction.class);

    BasicService basicService = new BasicServiceImpl();
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
       
        UserForm user = new UserForm();
        String userName = (String)request.getSession().getAttribute("userName");
        String role = (String)request.getSession().getAttribute("role");
        user.setUserName(userName);
        user.setRole(role);
        log.info(user);
        if(null == user.getUserName() || null == user.getRole())
        {
            log.error("system error! user info is null");
            return mapping.findForward("SystemError"); 
        }

        String operate  = request.getParameter("operate");
        String pageName = "";

        List<String> years = basicService.getAllYear();
        List<String> months = basicService.getAllMonth();
        List<String> departs = new ArrayList<String>();
        String departMapGas = "";
        String operateTile ="";
       
        
        if(operate.equals(OperationConstant.QEURY_ARRANGE))
        {
            departs = basicService.getAllDepart();
            
            departMapGas = getDepartGasJsonByDeparts(departs);
            pageName = "SelectCondition";
 
        }
        else if(operate.equals(OperationConstant.CREATE_ARRANGE)||
                operate.equals(OperationConstant.MODIFY_ARRANGE))
        {

            departs = new ArrayList<String>();
            if(user.getRole().equals(LoginRole.ADMIN))
            {
                departs = basicService.getAllDepart();
                departMapGas = getDepartGasJsonByDeparts(departs);
                
            }else if(user.getRole().equals(LoginRole.DEPART)) 
            {
                departs.add(user.getUserName());
                departMapGas = getDepartGasJsonByDeparts(departs); //temp
            }
            else
            {
                String depart;
                depart = basicService.getDepartByName(user.getUserName());
                departs.add(depart);
                departMapGas = getDepartGasJsonByDepartsAndGas(depart,user.getUserName());
            }

            pageName = "SelectCondition";
            operateTile = "加油站排班管理";
        }
        else if(operate.equals(OperationConstant.QEURY_SUM))
        {
            if(user.getRole().equals(LoginRole.GAS))
            {
                request.setAttribute("OperationMessage",BasicExceptionMessage.NO_RIGHT_OPERATE);
                
                pageName = "fail";
            }
            else
            {
                pageName = "StaticCondition";
                request.setAttribute("years", years);
                request.setAttribute("months", months);
            }   
            operateTile = "排版汇总信息";
        }
        else
        {
            if(user.getRole().equals(LoginRole.ADMIN))
            {
                departs = basicService.getAllDepart();
                
                departMapGas = getDepartGasJsonByDeparts(departs);
                pageName = "GasManage";
            }
            else
            {
                request.setAttribute("OperationMessage", BasicExceptionMessage.NO_RIGHT_OPERATE);
                pageName = "fail";
                 
            }
             
        }
        
        
        request.setAttribute("years", years);
        request.setAttribute("months", months);
        request.setAttribute("departs", departs);
        request.setAttribute("departMapGas", departMapGas);
        
        log.info(user);    
        log.info(departs);
        log.info(departMapGas);
        request.setAttribute("operate", operate);
        request.setAttribute("opeateTitle", operateTile);

        log.info("next page is : " + pageName);
        return mapping.findForward(pageName);
    }
    private String getDepartGasJsonByDepartsAndGas(String depart,String gas)
    {
        Map<String,List<String>> departAndGas = new HashMap<String,List<String>>();
        
        List<String> gases = new ArrayList<String>();
        gases.add(gas);
        departAndGas.put(depart, gases);
 
        String departMapGas;
        departMapGas = mapToJsonStr(departAndGas);
        
        return departMapGas;
    }
    /**
     * @function
     * @return
     */
    private String getDepartGasJsonByDeparts(List<String> departs)
    {
        Map<String,List<String>> departAndGas;
        
        
        departAndGas = basicService.getDepartMapGas(departs);
 
        String departMapGas;
        departMapGas = mapToJsonStr(departAndGas);
        
        return departMapGas;
    }
    
    
     public String mapToJsonStr( Map<String,List<String>> map)
     { 
            if(map==null||map.isEmpty())
            {  
                return "null";  
            }  
            String jsonMap = "{";
            Set<String> keySet = map.keySet(); 
            for (String key : keySet)
            {   
                List<String> list = map.get(key);
                if(list==null||list.size()==0){  
                    return "";  
                   }  
                String jsonList = "";  
                for(String str : list)
                {
                    jsonList += str + ",";
                }
                jsonList = jsonList.substring(0,jsonList.length()-1);  
                
                jsonMap += "\""+key+"\":\""+jsonList+"\",";           
            }      
            jsonMap = jsonMap.substring(0,jsonMap.length()-1);     
            jsonMap += "}";  
            return jsonMap;  
        }
}
