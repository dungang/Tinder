/**
 * TODO
 * ����12:13:00
 */
package cn.tinder.das.struts.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.tinder.das.exception.LoginException;
import cn.tinder.das.service.LoginService;
import cn.tinder.das.service.Impl.LoginServiceImpl;
import cn.tinder.das.struts.form.UserForm;
import cn.tinder.das.util.LoginRole;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.constant.OperationConstant;

/**
 * @author Administrator
 *
 */
public class LoginAction extends Action
{
    private static final Log log = LogFactory.getLog(LoginAction.class);

 
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        log.info(form);
        UserForm user = (UserForm)form;
        
        String pageName = "";
        String submitPara = request.getParameter("submit");
     
        if(submitPara == null)
        {
            log.error("submit is null");
            return mapping.findForward("SystemError");
        }
        
        LoginService loginService = new LoginServiceImpl();
        if(submitPara.equals(OperationConstant.BUTTON_LOGIN)||submitPara.equals(OperationConstant.OPERATE_ENTER))
        {
            try
            {
                loginService.login(user);
                
            }catch(LoginException ex)
            {
                log.warn(user + ": login failed ");
                request.setAttribute("loginExceptonMessage",ex.toString());             
                if(user.getRole().equals(LoginRole.GAS))
                {
                    pageName = "UserLogin";
                }
                else
                {
                    pageName = "GasLogin";
                }
                pageName = "Login";
                request.setAttribute("role",user.getRole());
                return mapping.findForward(pageName);
            }catch(Exception ex)
            {
                log.error(ex.toString());
                log.error(ExceptionStackPrint.getAllStack(ex));
                return mapping.findForward("SystemError");
            }
        }
        else if(submitPara.equals(OperationConstant.BUTTON_RETURN))
        {
            pageName="Welcome";
            log.info("user cancel login");
            return mapping.findForward(pageName);
        }


        pageName = "Work";
        request.getSession().setAttribute("userName", user.getUserName());
        request.getSession().setAttribute("role", user.getRole());
        
        System.out.println(user+"login in");
        log.info(user + ":login success");
        
        log.info("next page is : " + pageName);

        return mapping.findForward(pageName);
    }

}
