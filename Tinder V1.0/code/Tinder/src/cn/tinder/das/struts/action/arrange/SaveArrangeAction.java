/**
 * TODO
 * 上午02:59:50
 */
package cn.tinder.das.struts.action.arrange;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.tinder.das.exception.ArrangeServiceException;
import cn.tinder.das.service.ArrangeService;
import cn.tinder.das.service.Impl.ArrangeServiceImpl;
import cn.tinder.das.struts.data.ArrangeDataForm;
import cn.tinder.das.struts.form.GasArrangeInfoForm;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.constant.OperationConstant;


/**
 * @author Administrator
 *
 */
public class SaveArrangeAction extends Action
{
    private static final Log log = LogFactory.getLog(SaveArrangeAction.class);

    ArrangeService arrangeService = new ArrangeServiceImpl();
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        
        ArrangeService arrangeService = new ArrangeServiceImpl();
        
        GasArrangeInfoForm gasInfo = (GasArrangeInfoForm)form;
        log.info(gasInfo);
 
        
        //由于js删除一行的数据还会提交，于是采用特殊标记的方式进行过滤，
        removeDeleteName(gasInfo);

        
 
        String pageName = "Success";
        String OperationMessage = "";
        
        String submitValue = request.getParameter("submit");
        if(submitValue == null)
        {
            return mapping.findForward("SystemError");
        }
        if(submitValue.equals(OperationConstant.BUTTON_CANCEL))
        {
            return mapping.findForward("Init");
        } else if(submitValue.equals(OperationConstant.BUTTON_INPORT)){
        	log.info("开始进行导入流程...");
        	request.setAttribute(OperationConstant.DOWNLOAD_FILE, OperationConstant.MODEL_PATH);
        	//跳转到下一个页面
        	return mapping.findForward(pageName);
        } else if(submitValue.equals(OperationConstant.BUTTON_DOWNLOAD)){
        	log.info("开始进行模版下载流程...");
        }else if(submitValue.equals(OperationConstant.BUTTON_SUBMIT)){
        	
	     
	        try
	        {
	            arrangeService.saveArrangeInfomation(gasInfo);
	        }catch(ArrangeServiceException ex)
	        {
	            removeDeleteName(gasInfo);
	        	OperationMessage = ex.getMessage();
	        	pageName = "Arrange";
	        	request.setAttribute("OperationMessage", OperationMessage);
	        	request.setAttribute("oldGasInfo", gasInfo);
	            log.info(gasInfo);
	        	log.warn(ex.getMessage());
	        	log.warn(ExceptionStackPrint.getAllStack(ex));
	            return mapping.findForward(pageName);
	       }catch(Exception ex)
	       {
	            
	           pageName="SystemError";
	           log.error(ex.getMessage());
	           log.error(ExceptionStackPrint.getAllStack(ex));
	           return mapping.findForward(pageName);
	       }
       
        }
        System.out.println(pageName);
        log.info("next page is : " + pageName);

        
        return mapping.findForward(pageName);
        
    }
    /**
     * @function
     * @param gasInfo
     */
    private void removeDeleteName(GasArrangeInfoForm gasInfo)
    {
        Iterator<ArrangeDataForm> iterator = gasInfo.getArrangeDatas().iterator();
        while(iterator.hasNext())
        {
            ArrangeDataForm data = iterator.next();
            String[] temps = gasInfo.getDeleleNames().split(",");
            for(int i=0;i<temps.length;++i)
            {
                if(data.getName().equals(temps[i])||data.getName().isEmpty())
                {
                    iterator.remove();
                }
            }
        }
    }
}
