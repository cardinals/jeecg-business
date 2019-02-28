package com.sxctc.statistics.controller;

import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.statistics.service.UserProgramService;
import com.sxctc.statistics.vo.Histogram;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/userProgramController")
public class UserProgramController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(UserProgramController.class);

    @Autowired
    private UserProgramService userProgramService;

    /**
     * 营销人员售前费用页面 页面跳转
     *
     */
    @RequestMapping(params = "userProgramList")
    public ModelAndView userProjectList(HttpServletRequest request) {
        return new ModelAndView("com/sxctc/projectrack/userProgramList");
    }
    /**
     * 营销人员销售费用页面 页面跳转
     *
     *
     */
    @RequestMapping(params = "saleProgramList")
    public ModelAndView saleProjectList(HttpServletRequest request) {
        return new ModelAndView("com/sxctc/projectrack/saleProgramList");
    }
    /**
     * 上云时序页面 页面跳转
     */
    @RequestMapping(params = "programSequence")
    public ModelAndView programSequence(HttpServletRequest request, HttpServletResponse response) {
        String businessId = request.getParameter("businessId");
        String allCount= userProgramService.getSequenceDiagram(businessId);
         ModelAndView mav = new ModelAndView("com/sxctc/projectrack/programSequence");
         mav.addObject("allCount",allCount);
        return mav;
    }

    /**
     *获取销售/售前人员列表
     * 
     */
    @RequestMapping(params = "getManagerList")
    @ResponseBody
    public AjaxJson getManagerList(HttpServletRequest request, int optFlag) {
        AjaxJson json=new AjaxJson();
        try{
            String manageType = null;
            if (optFlag == 1) { manageType = "manager"; }
            if (optFlag == 2) { manageType = "salesman"; }
            List<Histogram> allCount= userProgramService.getManagerList(manageType);
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }


    @RequestMapping(params = "getSequenceStatistics")
    @ResponseBody
    public AjaxJson getSequenceStatistics(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        String userCode = request.getParameter("userCode");
        try{
            String[] allCount= userProgramService.getSequenceStatistics(userCode).split(",");
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }

    /**
     *获取各层费用
     * 
     */
    @RequestMapping(params = "getGradeTotal")
    @ResponseBody
    public AjaxJson getGradeTotal(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        String userCode = request.getParameter("userCode");
        try{
            List<Histogram> allCount = userProgramService.getGradeTotal(userCode);
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * 获取厅局费用排名
     *
     * 
     */
    @RequestMapping(params = "getRankOfUnit")
    @ResponseBody
    public AjaxJson getRankOfUnit(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        String userCode = request.getParameter("userCode");
        try{
            List<Histogram> allCount = userProgramService.getRankOfUnit(userCode);
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * 获取项目列表
     *
     * 
     */
    @RequestMapping(params = "getProgramList")
    @ResponseBody
    public AjaxJson getProgramList(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        String userCode = request.getParameter("userCode");
        try{
            if(StringUtil.isNotEmpty(userCode)){
                List<TBBusinessEntity> allCount = userProgramService.getProgramList(userCode);
                json.setObj(allCount);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * 获取机会池项目列表
     *
     * 
     */
    @RequestMapping(params = "getChanceProgramList")
    @ResponseBody
    public AjaxJson getChanceProgramList(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        String userCode = request.getParameter("userCode");
        try{
            if(StringUtil.isNotEmpty(userCode)){
                List<TBChancePoolEntity> allCount = userProgramService.getChanceProgramList(userCode);
                json.setObj(allCount);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }
}
