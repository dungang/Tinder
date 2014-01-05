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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.tinder.das.exception.ExportException;
import cn.tinder.das.service.ExportService;
import cn.tinder.das.service.Impl.ExportServiceImpl;
import cn.tinder.das.service.data.GasStatus;
import cn.tinder.das.service.util.ExcelOutPutService;
import cn.tinder.das.service.util.impl.ExcelOutPutServiceImpl;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.constant.OperationConstant;

/**
 * @author Administrator
 * 
 */
public class ExportSumInfoAction extends Action
{
    private static final Log log = LogFactory.getLog(ExportSumInfoAction.class);

    ExportService exportService = new ExportServiceImpl();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        log.info(form);

        String submitValue = request.getParameter("submit");
        ArrangeIndexForm arrangeIndex = (ArrangeIndexForm) form;
        String path = "";

        if (submitValue == null)
        {
            log.error("submit is null ! " + submitValue);
            return mapping.findForward("SystemError");
        }
        // 用户取消操作
        try
        {
        if (submitValue.equals(OperationConstant.BUTTON_CANCEL))
        {
            log.info("user cancel the operation ! " + submitValue);
            return mapping.findForward("Init");
        }else if(submitValue.equals(OperationConstant.BUTTON_EXPORT_GAS_STATUS))
        {
            List<GasStatus> gasStatusList = new ArrayList<GasStatus>();
            gasStatusList = exportService.getAllGasStatus(arrangeIndex);
            ExcelOutPutService exceloutput=new ExcelOutPutServiceImpl();
            path= exceloutput.ouypuyGasStatusList(gasStatusList);
        }
        
        

    
            if (submitValue.equals(OperationConstant.BUTTON_EXPORT_SUM))
            {

                path = exportService.exportSumInfoFile(arrangeIndex);

            } else
            {

                path = exportService.exportAllGasInfoByIndex(arrangeIndex);

            }
        }

        catch (RuntimeException e)
        {
            log.warn("get file failed");
            log.warn(e.getMessage());
            log.warn(ExceptionStackPrint.getAllStack(e));
            request.setAttribute("OperationMessage", e.getMessage());
            return mapping.findForward("fail");
        } catch (Exception e)
        {
            log.error(e.getMessage());
            log.error(ExceptionStackPrint.getAllStack(e));
            return mapping.findForward("SystemError");
        }

        try
        {
            exportFile(response, path);
            
        }catch(ExportException e)
        {
            return mapping.findForward("error");
        }
        return null;

    }

    /**
     * @function
     * @param mapping
     * @param response
     * @param path
     * @return
     */
    private void exportFile(HttpServletResponse response, String path)
    {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        InputStream fis = null;
        OutputStream fos = null;

        try
        {

            File uploadFile = new File(path);

            fis = new FileInputStream(uploadFile);
            bis = new BufferedInputStream(fis);
            fos = response.getOutputStream();
            bos = new BufferedOutputStream(fos);
            response.reset();
            response.setHeader(
                    "Content-disposition",
                    "attachment;filename ="
                            + URLEncoder.encode(
                                    path.substring(path.lastIndexOf("/") + 1),
                                    "utf-8"));

            int bytesRead = 0;
            byte[] buffer = new byte[4096];
            while ((bytesRead = bis.read(buffer, 0, 4096)) != -1)
            {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();
            fis.close();
            bis.close();
            fos.close();
            bos.close();

            log.info("file path is :" + path + " export file success ! ");
           
        } catch (FileNotFoundException ex)
        {
            log.error(ex.getMessage(),ex);

            throw new ExportException(ex);
        } catch (Exception ex)
        {
            log.error(ex.getMessage());
            log.error(ExceptionStackPrint.getAllStack(ex));
            
        }
    }
}
