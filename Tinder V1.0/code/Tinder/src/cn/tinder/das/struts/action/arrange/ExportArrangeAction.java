/**
 * TODO
 * 上午02:59:50
 */
package cn.tinder.das.struts.action.arrange;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.tinder.das.service.ExportService;
import cn.tinder.das.service.Impl.ExportServiceImpl;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.constant.OperationConstant;

/**
 * @author Administrator
 *
 */
public class ExportArrangeAction extends Action
{
    private static final Log log = LogFactory.getLog(ExportArrangeAction.class);

    ExportService exportService = new ExportServiceImpl();
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)  
    {
        log.info(form);
        String submitValue = request.getParameter("submit");
        ArrangeIndexForm arrangeIndex = (ArrangeIndexForm)form ;
        if(submitValue == null)
        {
            log.error("sytem error ! submit value is null ");
            log.info("next page is : Init.jsp");
            return mapping.findForward("SystemError");
        }
        //用户取消操作
        if(submitValue.equals(OperationConstant.BUTTON_CANCEL))
        {
            log.info("next page is : Init.jsp");
            return mapping.findForward("Init");
        }else if(submitValue.equals(OperationConstant.BUTTON_EXPORT)){
        	String path = "";
            try
            {
                path = exportService.exportDataFile(arrangeIndex);
                log.info(path);
            }catch(RuntimeException ex)
            {
                log.warn(ex.getMessage());
                log.warn(ExceptionStackPrint.getAllStack(ex));
                log.info("next page is : fail.jsp");
                request.setAttribute("OperationMessage", ex.getMessage());
                return mapping.findForward("fail");
            }catch(Exception ex)
            {
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));
                log.info("next page is : SystemError");
                return mapping.findForward("SystemError");
            }
            
            BufferedInputStream   bis = null;
            BufferedOutputStream  bos = null;
            InputStream fis = null;
            OutputStream fos = null;
            
            try{

                File uploadFile = new File(path);

        
                fis = new FileInputStream(uploadFile);
                bis = new BufferedInputStream(fis);
                fos = response.getOutputStream();
                bos = new BufferedOutputStream(fos);
                


                response.reset();
                response.setHeader("Content-disposition", "attachment;filename =" + URLEncoder.encode(path.substring(path.lastIndexOf("/")+1), "utf-8"));


                int bytesRead = 0;
                byte[] buffer = new byte[4096];
                while((bytesRead = bis.read(buffer,0,4096)) != -1){
                    bos.write(buffer, 0, bytesRead);
                }
                bos.flush();
                fis.close();
                bis.close();
                fos.close();
                bos.close();
                //return mapping.findForward("success");
                
                return null;
            }catch(FileNotFoundException ex){
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));      
                return mapping.findForward("fail");
            }catch(Exception ex){
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));
                log.info("next page is : SystemError");
                return mapping.findForward("SystemError");
            }
        }
        else if(submitValue.equals(OperationConstant.BUTTON_INPORT)){
        	log.info("开始进行导入流程...");
        }
        return mapping.findForward("SystemError");
        
    }
}
