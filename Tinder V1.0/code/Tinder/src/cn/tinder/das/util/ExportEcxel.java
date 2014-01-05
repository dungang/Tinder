package cn.tinder.das.util;

import java.util.List;
import java.util.Map;

import cn.tinder.das.domain.po.CompanySumInfo;
import cn.tinder.das.domain.po.GasArrangeData;
import cn.tinder.das.domain.po.GasInformation;
import cn.tinder.das.domain.po.SystemUser;

public interface ExportEcxel
{

    public String exoprtGasSheet(GasInformation gasInfo,
            CompanySumInfo cpSumInfo, List<GasArrangeData> gasArgData,
            SystemUser systemUser,String exportPath);

    public String exoprtSumSheet(List<GasInformation> allGasInfo,
            List<CompanySumInfo> allCmpInfo, Map<String, String> gsNumMap,
            Map<String, String> gsDepMap, String yearMonth);

}
