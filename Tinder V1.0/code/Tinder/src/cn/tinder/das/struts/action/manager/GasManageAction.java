/**
 * TODO
 * 下午11:48:22
 */
package cn.tinder.das.struts.action.manager;

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
import cn.tinder.das.struts.form.GasForm;
import cn.tinder.das.util.constant.OperationConstant;

/**
 * @author Administrator
 *
 */
public class GasManageAction extends Action
{
    private static final Log log = LogFactory.getLog(AlterPasswordAction.class);
 
    ManageUserService userService = new ManageUserServiceImpl();
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    { 
        //GasForm alterPwdForm= (GasForm)form;

        GasForm gasForm = (GasForm)(form);

        String submitValue = request.getParameter("submit");

        log.info(submitValue);
        if(null == submitValue)
        {
            log.error(submitValue);
            return mapping.findForward("SystemError");
        }
        if(submitValue.equals(OperationConstant.BUTTON_CANCEL))
        {
            log.info(OperationConstant.BUTTON_CANCEL);
            return mapping.findForward("Init");
        }
        try
        {
            if(submitValue.equals(OperationConstant.BUTTON_DELETE_GAS))
            {
                userService.deleteGas(gasForm.getGasName());
    
            }else if(submitValue.equals(OperationConstant.BUTTON_RESET_PWD))
            {
                userService.resetPassword(gasForm.getGasName());
            }
            else if(submitValue.equals(OperationConstant.BUTTON_ADD_GAS))
            {
                userService.addGas(gasForm);
            }
            }
        catch(ManageUserException ex)
        {
            request.setAttribute("OperationMessage", ex.getMessage());
            log.warn(ex.getMessage(),ex);
            return mapping.findForward("fail");
        }
 
        
        return mapping.findForward("Success");

    }
}
