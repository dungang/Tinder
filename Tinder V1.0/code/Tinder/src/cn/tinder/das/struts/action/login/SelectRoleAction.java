package cn.tinder.das.struts.action.login;

import java.util.ArrayList;
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

import cn.tinder.das.exception.BasicException;
import cn.tinder.das.exception.LoginException;
import cn.tinder.das.service.LoginService;
import cn.tinder.das.service.Impl.ArrangeServiceImpl;
import cn.tinder.das.service.Impl.BasicServiceImpl;
import cn.tinder.das.service.Impl.LoginServiceImpl;
import cn.tinder.das.struts.form.RoleForm;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.LoginRole;

public class SelectRoleAction extends Action
{
    private static final Log log = LogFactory.getLog(SelectRoleAction.class);

    LoginService loginService;
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        log.info(form);
        RoleForm role = (RoleForm)form;
        
        String pageName ="";
        
        if(role==null)
        {
            log.error("role is null");
            return mapping.findForward("SystemError");
        }
        
        request.setAttribute("role", role.getRole());
        
        ArrangeServiceImpl b= new ArrangeServiceImpl();
        BasicServiceImpl a = new BasicServiceImpl();
        loginService = new LoginServiceImpl();
        a.getAllArrangeMode();
        
        //处理油站角色登陆界面
        if(role.getRole().equals(LoginRole.GAS))
        {   
            String  deaprtMapGas;
            List<String> departs;
            try
            {
                departs = loginService.getAllUserNameByRole(LoginRole.DEPART);    
            }catch(BasicException ex)
            {
                log.error("get user name by role failed " + role);
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));
                return mapping.findForward("Welcome");
            } 
            deaprtMapGas = getDepartGasJsonByDeparts(departs);
            request.setAttribute("departs", departs);
            request.setAttribute("departMapGas", deaprtMapGas);
            pageName = "GasLogin";
            log.info("get user by role" + role + departs);
            log.info(departs);
            log.info(deaprtMapGas);
        }
        else
        {
            try
            {
                List<String> userOptions;
                userOptions = loginService.getAllUserNameByRole(role.getRole());
                if(userOptions == null)
                {
                   log.warn("userOptions is null");
                   userOptions = new ArrayList<String>();
                }
                log.info("get user name by role" + userOptions);
                request.setAttribute("userOptions", userOptions);
                pageName = "UserLogin";
            }catch(LoginException ex)
            {
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));
                return mapping.findForward("Welcome");
            }          
            
        }
        log.info("next page is : " + pageName);
  

        return mapping.findForward(pageName);
    }
    private String getDepartGasJsonByDeparts(List<String> departs)
    {
        Map<String,List<String>> departAndGas;
        
        departAndGas = loginService.getDepartMapGas(departs);
        List<String> a = new ArrayList<String>();
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
