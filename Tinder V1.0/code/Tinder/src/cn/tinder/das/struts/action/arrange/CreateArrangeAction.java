/**
 * TODO
 * 上午01:49:20
 */
package cn.tinder.das.struts.action.arrange;

import java.util.List;

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
import cn.tinder.das.struts.data.ArrangeModeForm;
import cn.tinder.das.struts.data.ModeForm;
import cn.tinder.das.struts.data.TimeForm;
import cn.tinder.das.struts.form.ArrangeIndexForm;
import cn.tinder.das.struts.form.GasArrangeInfoForm;
import cn.tinder.das.util.ExceptionStackPrint;
import cn.tinder.das.util.constant.OperationConstant;

/**
 * @author Administrator
 *
 */
public class CreateArrangeAction extends Action
{
    private static final Log log = LogFactory.getLog(CreateArrangeAction.class);
    ArrangeService arrangeService = new ArrangeServiceImpl();
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        log.info(form);
        ArrangeIndexForm arrangeIndex = (ArrangeIndexForm)form;
        String operate  = request.getParameter("operate");
        String submitValue = request.getParameter("submit");
        
        GasArrangeInfoForm oldGasInfo = (GasArrangeInfoForm) request.getAttribute("oldGasInfo");
        if(null != oldGasInfo)
        {
            arrangeIndex = oldGasInfo.getIndex();
            log.info("show the old index" + arrangeIndex);
        }
        
        log.info("operation is : "+operate);
        log.info(submitValue);
        if(submitValue == null || operate == null)
        {
            log.error(submitValue);
            log.error(operate);
            return mapping.findForward("SystemError");
        }
        if(submitValue.equals(OperationConstant.BUTTON_CANCEL))
        {
            log.info(OperationConstant.BUTTON_CANCEL);
            return mapping.findForward("Init");
        }
 
        String pageName = "QueryArrange";

        String holidays ;
        List<String> arrangeNames;
        List<String> jobs;
        try
        {
            arrangeNames = arrangeService.getAllArrangeMode();
            jobs = arrangeService.getAllJob();
            holidays = arrangeService.getMonthDays(arrangeIndex.getYear(), arrangeIndex.getMonth());

        }catch(ArrangeServiceException ex)
        {
            pageName = "fail";
            request.setAttribute("OperationMessage", ex.toString());
            log.error(ex.getMessage());
            log.error(ExceptionStackPrint.getAllStack(ex));
            return mapping.findForward(pageName);
        }
        catch(Exception ex)
        {
            
            pageName = "SystemError";
            log.error(ex.getMessage());
            log.error(ExceptionStackPrint.getAllStack(ex));
            return mapping.findForward(pageName);
        }

        GasArrangeInfoForm gasInfo = getInitData();
        if(operate.equals(OperationConstant.QEURY_ARRANGE))
        {
            
            try
            {
                if(null != oldGasInfo)
                {
                    gasInfo = oldGasInfo;
                }
                else
                {
                    if(arrangeIndex.getMonth().length()==1){
                 
                		gasInfo = arrangeService.getArrangeInfo(arrangeIndex.getYear()+"0"+arrangeIndex.getMonth(), arrangeIndex.getGasName());
                	}else{
                		gasInfo = arrangeService.getArrangeInfo(arrangeIndex.getYear()+arrangeIndex.getMonth(), arrangeIndex.getGasName());
                	}
                }
            	arrangeNames.remove(gasInfo.getArrangeInfo().getArrangeName());
            	arrangeNames.add(0, gasInfo.getArrangeInfo().getArrangeName());
 
                
            }catch(ArrangeServiceException ex)
            {
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));
            }catch(Exception ex)
            {
                
                pageName="SystemError";
                log.error(ex.getMessage());
                log.error(ExceptionStackPrint.getAllStack(ex));
                return mapping.findForward(pageName);
            }
            pageName="QueryArrange";
        }

        request.setAttribute("gasInfo", gasInfo);
        request.setAttribute("arrangeIndex", arrangeIndex);
        request.setAttribute("arrangeNames", arrangeNames);
        request.setAttribute("jobs", jobs);
        request.setAttribute("holidays", holidays);

        List<ArrangeDataForm> workArrangeDatas = gasInfo.getArrangeDatas();
        request.setAttribute("workArrangeDatas", workArrangeDatas);
        request.setAttribute("arrangeSize", workArrangeDatas.size());
        
        String jobsJson = "";
        for(int i=0;i<jobs.size();i++)
        {
            
            if(i == (jobs.size()-1))
            {
                jobsJson += jobs.get(i); 
            }else
            {
                jobsJson += jobs.get(i)+',';
            }
        }
        request.setAttribute("jobsJson", jobsJson);
        request.setAttribute("OperationMessage", request.getAttribute("OperationMessage"));

 
        log.info(holidays);
        log.info(workArrangeDatas);
        log.info(jobsJson);
        log.info(gasInfo);
        
        log.info("next page is : " + pageName);

        return mapping.findForward(pageName);
    }
    
    private GasArrangeInfoForm getInitData()
    {
        GasArrangeInfoForm gasInfo = new GasArrangeInfoForm();
        ArrangeModeForm arrangeInfo = new ArrangeModeForm();
        ModeForm aMode = new ModeForm();
        ModeForm cMode = new ModeForm();
        ModeForm bMode = new ModeForm();
        TimeForm modeTime1 = new TimeForm();
        TimeForm modeTime2 = new TimeForm();
        TimeForm modeTime3 = new TimeForm();
         

        modeTime1.setStartHours(7);
        modeTime1.setStartMin(0);
        modeTime1.setEndHours(15);
        modeTime1.setEndMin(0);
        
        modeTime2.setStartHours(15);
        modeTime2.setStartMin(0);
        modeTime2.setEndHours(23);
        modeTime2.setEndMin(0);
        
        modeTime3.setStartHours(23);
        modeTime3.setStartMin(0);
        modeTime3.setEndHours(7);
        modeTime3.setEndMin(0);
        
        aMode.setModeTime1(modeTime1);
        bMode.setModeTime1(modeTime2);
        cMode.setModeTime1(modeTime3);
        
        arrangeInfo.setaMode(aMode);
        arrangeInfo.setbMode(bMode);
        arrangeInfo.setcMode(cMode);
        
        gasInfo.setArrangeInfo(arrangeInfo);
        return gasInfo;
    }

}
