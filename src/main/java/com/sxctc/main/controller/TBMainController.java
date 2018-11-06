package com.sxctc.main.controller;

import com.sxctc.main.service.TBMainServicel;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tbMainController")
public class TBMainController {
    @Autowired
    private TBMainServicel tbMainService;

    @RequestMapping(params = "getMainSystemNum")
    @ResponseBody
    public AjaxJson getMainSystemNum(){

        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();
        TSUser user = ResourceUtil.getSessionUser();
        String userName = user.getUserName();
//      String userName = null;
        try {
            int projectTotalNum = tbMainService.getProjectTotalNum(userName);
            int notDockSystemNum = tbMainService.getNotDockSystemNum(userName);
            int cloudDockSystemNum = tbMainService.getCloudDockSystemNum(userName);
            int researchFormSystemNum = tbMainService.getResearchFormSystemNum(userName);
            int allocatingResourcesSystemNum = tbMainService.getAllocatingResourcesSystemNum(userName);
            int signPlanSystemNum = tbMainService.getSignPlanSystemNum(userName);
            int cloudTestSystemNum = tbMainService.getCloudTestSystemNum(userName);
            int recoveryAgreementSystemNum = tbMainService.getRecoveryAgreementSystemNum(userName);
            int cloudCompleteNum = tbMainService.getCloudCompleteNum(userName);
            result.put("projectTotalNum",projectTotalNum);
            result.put("notDockSystemNum",notDockSystemNum);
            result.put("cloudDockSystemNum",cloudDockSystemNum);
            result.put("researchFormSystemNum",researchFormSystemNum);
            result.put("signPlanSystemNum",signPlanSystemNum);
            result.put("allocatingResourcesSystemNum",allocatingResourcesSystemNum);
            result.put("cloudTestSystemNum",cloudTestSystemNum);
            result.put("recoveryAgreementSystemNum",recoveryAgreementSystemNum);
            result.put("cloudCompleteNum", cloudCompleteNum);
        }catch (Exception e){
            e.printStackTrace();
        }
        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }
}
