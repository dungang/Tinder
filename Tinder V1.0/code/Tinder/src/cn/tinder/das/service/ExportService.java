package cn.tinder.das.service;

import java.util.List;

import cn.tinder.das.service.data.GasStatus;
import cn.tinder.das.struts.form.ArrangeIndexForm;

public interface ExportService extends BasicService
{
    public String exportDataFile(ArrangeIndexForm arrangeIndex);
    public String exportSumInfoFile(ArrangeIndexForm arrangeIndex);
    public String exportByIndex(ArrangeIndexForm arrangeIndex);
    public String exportAllGasInfoByIndex(ArrangeIndexForm arrangeIndex);
    public List<GasStatus> getAllGasStatus(ArrangeIndexForm arrangeIndex);
}
