/**
 * TODO
 * 上午12:01:24
 */
package cn.tinder.das.struts.action.manager;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.tinder.das.exception.ManageUserException;
import cn.tinder.das.service.ManageUserService;
import cn.tinder.das.service.Impl.ManageUserServiceImpl;
import cn.tinder.das.struts.action.login.LoginAction;
import cn.tinder.das.struts.form.AlterPasswordForm;
import cn.tinder.das.util.constant.OperationConstant;


/**
 * @author Administrator
 *
 */
public class AlterPasswordAction extends Action
{
    private static final Log log = LogFactory.getLog(AlterPasswordAction.class);

    ManageUserService userService = new ManageUserServiceImpl();
 
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        log.info(form);
        String userName = (String)request.getSession().getAttribute("userName");
        
        log.info(userName);
         
        if(request.getParameter("submit").equals(OperationConstant.BUTTON_CANCEL))
        {
            log.info(OperationConstant.BUTTON_CANCEL);
            return mapping.findForward("Init");
        }
        String OperationMessage;
        
        AlterPasswordForm alterPwdForm= (AlterPasswordForm)form;

       try
       {
           userService.isNewPasswordRight(alterPwdForm.getNewFirstPassword(), alterPwdForm.getNewSecondPassword());
           userService.alterPassword(userName,alterPwdForm.getOldPassword(), alterPwdForm.getNewFirstPassword());
       }catch(ManageUserException ex)
       {
           OperationMessage = ex.toString();
           request.getSession().setAttribute("OperationMessage", OperationMessage);
           
           log.error(ex.getMessage());
           log.error(ex.getStackTrace());
           return mapping.findForward("fail");
       }catch(Exception ex)
       {
           log.error(ex.getMessage());
           log.error(ex.getStackTrace());
           return mapping.findForward("SystemError");
           
       }
        
        return mapping.findForward("Success");

    }
}
