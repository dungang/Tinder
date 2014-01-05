/**
 * TODO
 * 下午11:50:02
 */
package cn.tinder.das.struts.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import cn.tinder.das.struts.data.ArrangeDataForm;
import cn.tinder.das.struts.data.ArrangeModeForm;
import cn.tinder.das.struts.data.ArrangeSaleForm;
import cn.tinder.das.struts.data.ArrangeStaffForm;
import cn.tinder.das.struts.data.MyArrayList;

/**
 * @author Administrator
 *
 */
public class GasArrangeInfoForm extends ActionForm
{
     
    private ArrangeIndexForm index = new ArrangeIndexForm();
    private ArrangeSaleForm saleInfo = new ArrangeSaleForm();
    private ArrangeStaffForm staffInfo = new ArrangeStaffForm();
    private ArrangeModeForm arrangeInfo = new ArrangeModeForm();
    private FormFile uploadFile;
    private String others="";

    private List arrangeDatas = new MyArrayList(ArrangeDataForm.class);
    
    private String deleleNames="";

    public ArrangeIndexForm getIndex()
    {
        return index;
    }

    public void setIndex(ArrangeIndexForm index)
    {
        this.index = index;
    }

    public ArrangeSaleForm getSaleInfo()
    {
        return saleInfo;
    }

    public void setSaleInfo(ArrangeSaleForm saleInfo)
    {
        this.saleInfo = saleInfo;
    }

    public ArrangeStaffForm getStaffInfo()
    {
        return staffInfo;
    }

    public void setStaffInfo(ArrangeStaffForm staffInfo)
    {
        this.staffInfo = staffInfo;
    }

    public ArrangeModeForm getArrangeInfo()
    {
        return arrangeInfo;
    }

    public void setArrangeInfo(ArrangeModeForm arrangeInfo)
    {
        this.arrangeInfo = arrangeInfo;
    }

    public String getOthers()
    {
        return others;
    }

    public void setOthers(String others)
    {
        this.others = others;
    }

    public List getArrangeDatas()
    {
        return arrangeDatas;
    }

    public void setArrangeDatas(List arrangeDatas)
    {
        this.arrangeDatas = arrangeDatas;
    }

    public String getDeleleNames()
    {
        return deleleNames;
    }

    public void setDeleleNames(String deleleNames)
    {
        this.deleleNames = deleleNames;
    }

    @Override
    public String toString()
    {
        return "GasArrangeInfoForm [index=" + index + ", saleInfo=" + saleInfo
                + ", staffInfo=" + staffInfo + ", arrangeInfo=" + arrangeInfo
                + ", others=" + others + ", arrangeDatas=" + arrangeDatas
                + ", deleleNames=" + deleleNames + "]";
    }

	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public FormFile getUploadFile() {
		return uploadFile;
	}

     
    
}
