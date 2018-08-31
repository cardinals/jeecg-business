package com.sxctc.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.statistics.service.EchartServiceI;
import com.sxctc.statistics.vo.Histogram;
import com.sxctc.statistics.vo.StatisticsVo;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EchartsController
 * @Description: 图表分析
 * @author liuzc
 * @date 2018/8/15 下午2:39
 * @version V1.0
 */
@Api(value="EchartsData",description="图表分析",tags="echartsController")
@Controller
@RequestMapping("/echartsController")
public class EchartsController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(EchartsController.class);

    @Autowired
    private EchartServiceI echartService;
    @Autowired
    private SystemService systemService;

//    /**
//     * @Title getPieChartData1
//     * @Description 获取已对接系统数占总系统比例
//     * @Param [request]
//     * @Return org.jeecgframework.core.common.model.json.AjaxJson
//     * @Author liuzc
//     * @Date 2018/8/15 下午3:02
//     **/
//    @RequestMapping(params = "getPieChartData1")
//    @ResponseBody
//    public AjaxJson getPieChartData1(HttpServletRequest request) {
//        AjaxJson json=new AjaxJson();
//        Map<String,Object> result = new HashMap<String,Object>();
//        TSUser user = ResourceUtil.getSessionUser();
//        try{
//            String id = null;
//            String userName = user.getUserName();
//            String orgCode = user.getCurrentDepart().getOrgCode();
//            if ("A04A01A01A01".equals(orgCode)) {
//                id = userName;
//            }
//            int allCount = echartService.getProjectCountByUserid(id, null);
//            int joinCount = echartService.getProjectCountByUserid(id, "1");
//            result.put("allCount",allCount);
//            result.put("joinCount",joinCount);
//            result.put("unjoinCount",allCount - joinCount);
//
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new BusinessException(e.getMessage());
//        }
//
//        json.setAttributes(result);
//        json.setMsg("查询成功！");
//        return json;
//    }
//
//    /**
//     * @Title getBarGraphData1
//     * @Description 获取每个月新增的对接系统
//     * @Param [request]
//     * @Return org.jeecgframework.core.common.model.json.AjaxJson
//     * @Author liuzc
//     * @Date 2018/8/15 下午4:56
//     **/
//    @RequestMapping(params = "getBarGraphData1")
//    @ResponseBody
//    public AjaxJson getBarGraphData1(HttpServletRequest request) {
//        AjaxJson json=new AjaxJson();
//        Map<String,Object> result = new HashMap<String,Object>();
//        TSUser user = ResourceUtil.getSessionUser();
//        try{
//            String id = null;
//            String userName = user.getUserName();
//            String orgCode = user.getCurrentDepart().getOrgCode();
//            if ("A04A01A01A01".equals(orgCode)) {
//                id = userName;
//            }
//            for (int i = 1; i <=12; i++) {
//                String month = DateUtils.getYear() + "-" + i;
//                if (i < 10) {
//                    month = DateUtils.getYear() + "-0" + i;
//                }
//                int projectCount = echartService.getProjectCountByMonth(id, month);
//                result.put(i+"",projectCount);
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new BusinessException(e.getMessage());
//        }
//
//        json.setAttributes(result);
//        json.setMsg("查询成功！");
//        return json;
//    }
//
//
//    /**
//     * @Title getBarGraphData2
//     * @Description 获取每个用户负责的系统数
//     * @Param [request]
//     * @Return org.jeecgframework.core.common.model.json.AjaxJson
//     * @Author liuzc
//     * @Date 2018/8/15 下午4:58
//     **/
//    @RequestMapping(params = "getBarGraphData2")
//    @ResponseBody
//    public AjaxJson getBarGraphData2(HttpServletRequest request) {
//        AjaxJson json=new AjaxJson();
//        try{
//            List<StatisticsVo> allCount = echartService.getEveryProjectCount();
//            json.setObj(allCount);
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new BusinessException(e.getMessage());
//        }
//        json.setMsg("查询成功！");
//        return json;
//    }
    /**
     * @Title getPieChartData2
     * @Description 获取上云完成和迁移完成金额
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     **/
    @RequestMapping(params = "getPieChartData2")
    @ResponseBody
    public AjaxJson getPieChartData2(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();


        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }
    /**
     * @Title getPieChartData3
     * @Description 获取已中标项目数量
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     **/
    @RequestMapping(params = "getPieChartData3")
    @ResponseBody
    public AjaxJson getPieChartData3(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();
        TSUser user = ResourceUtil.getSessionUser();

        try {
            int winTheBidProjectNum = echartService.getWinTheBidProjectNum();
            int targetConstructProjectNum = echartService.getTargetConstructProjectNum();
            result.put("winTheBidProjectNum",winTheBidProjectNum);
            result.put("targetConstructProjectNum",targetConstructProjectNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * @Title getPieChartData4
     * @Description 获取上云各阶段进展数量对比
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     **/
    @RequestMapping(params = "getPieChartData4")
    @ResponseBody
    public AjaxJson getPieChartData4(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();
        TSUser user = ResourceUtil.getSessionUser();

        try {
            int notDockSystemNum = echartService.getNotDockSystemNum();
            int cloudDockSystemNum = echartService.getCloudDockSystemNum();
            int researchFormSystemNum = echartService.getResearchFormSystemNum();
            int allocatingResourcesSystemNum = echartService.getAllocatingResourcesSystemNum();
            int signPlanSystemNum = echartService.getSignPlanSystemNum();
            int cloudTestSystemNum = echartService.getCloudTestSystemNum();
            int recoveryAgreementSystemNum = echartService.getRecoveryAgreementSystemNum();
            int cloudCompleteNum = echartService.getCloudCompleteNum();

            result.put("notDockSystemNum",notDockSystemNum);
            result.put("cloudDockSystemNum",cloudDockSystemNum);
            result.put("researchFormSystemNum",researchFormSystemNum);
            result.put("signPlanSystemNum",signPlanSystemNum);
            result.put("allocatingResourcesSystemNum",allocatingResourcesSystemNum);
            result.put("cloudTestSystemNum",cloudTestSystemNum);
            result.put("recoveryAgreementSystemNum",recoveryAgreementSystemNum);
            result.put("cloudCompleteNum",cloudCompleteNum);
        } catch (Exception e) {
            e.printStackTrace();
        }


        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * @Title getPieChartData5
     * @Description 获取2018上云系统数量
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     **/
    @RequestMapping(params = "getPieChartData5")
    @ResponseBody
    public AjaxJson getPieChartData5(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();
        TSUser user = ResourceUtil.getSessionUser();

        try {
            int targetCloudSystemNum = echartService.getTargetCloudSystemNum();
            int cloudCompleteNum = echartService.getCloudCompleteNum();
            result.put("targetCloudSystemNum",targetCloudSystemNum);
            result.put("cloudCompleteNum",cloudCompleteNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * 获取厅局费用排名
     *
     * @return
     */
    @RequestMapping(params = "getRankOfUnit")
    @ResponseBody
    public AjaxJson getRankOfUnit(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        try{
            List<Histogram> allCount = echartService.getRankOfUnit();
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }

    /**
     *获取销售总额排名
     * @return
     */
    @RequestMapping(params = "getRankOfSale")
    @ResponseBody
    public AjaxJson getRankOfSale(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        try{
            List<Histogram> allCount = echartService.getRankOfSale();
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
     * @return
     */
    @RequestMapping(params = "getGradeTotal")
    @ResponseBody
    public AjaxJson getGradeTotal(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        try{
            List<Histogram> allCount = echartService.getGradeTotal();
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }
    /**
     *获取时间差统计
     * @return
     */
    @RequestMapping(params = "getSequenceStatistics")
    @ResponseBody
    public AjaxJson getSequenceStatistics(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        try{
            String[] allCount= echartService.getSequenceStatistics().split(",");
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }
}
