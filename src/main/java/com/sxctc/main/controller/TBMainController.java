package com.sxctc.main.controller;

import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.main.service.TBMainServicel;
import com.sxctc.util.DateUtil;
import com.sxctc.workreport.entity.TBBusiWorkreportEntity;
import com.sxctc.workreport.service.TBBusiWorkreportServiceI;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/tbMainController")
public class TBMainController extends BaseController {
    @Autowired
    private TBMainServicel tbMainService;
    @Autowired
    private TBBusiWorkreportServiceI tBBusiWorkreportService;

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

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "reportDatagrid")
    public void reportDatagrid(TBBusiWorkreportEntity tBBusiWorkreport, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String reportOpt) {
        TSUser tsUser = ResourceUtil.getSessionUser();
        CriteriaQuery cq = new CriteriaQuery(TBBusiWorkreportEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiWorkreport, request.getParameterMap());
        try{
            //自定义追加查询条件
            if (StringUtils.isNotBlank(reportOpt)){
                if ("0".equals(reportOpt)){
                    cq.eq("reportType",0);
                }else {
                    cq.notEq("reportType",0);
                }
            }
            cq.eq("createBy", tsUser.getUserName());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 7);
            Date today = calendar.getTime();
            cq.le("reportDate", today);

            // 只查询未结束的系统
            List<String> busiList = getVaildBusinessIdList();
            if (busiList != null && busiList.size()>0) {
                cq.in("businessId",busiList.toArray());
            }
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.tBBusiWorkreportService.getDataGridReturn(cq, true);

        /**遍历拼装数据*/
        int intervalDays = 0;
        List<TBBusiWorkreportEntity> results = dataGrid.getResults();
        for (TBBusiWorkreportEntity result : results) {
            Date reportDate = result.getReportDate();
            Date createDate = result.getCreateDate();
            Date currentDate = new Date();
            if (reportDate != null) {
                intervalDays = DateUtil.getIntervalDays(currentDate, reportDate);
            }else {
                intervalDays = DateUtil.getIntervalDays(currentDate, createDate);
            }
            result.setUnFollowDay(intervalDays);
        }

        TagUtil.datagrid(response, dataGrid);
    }
}
