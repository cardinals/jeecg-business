package com.sxctc.statistics.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.statistics.service.EchartServiceI;
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

    /**
     * @Title getPieChartData1
     * @Description 获取已对接系统数占总系统比例
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     * @Author liuzc
     * @Date 2018/8/15 下午3:02
     **/
    @RequestMapping(params = "getPieChartData1")
    @ResponseBody
    public AjaxJson getPieChartData1(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();
        TSUser user = ResourceUtil.getSessionUser();
        try{
            String id = null;
            String userName = user.getUserName();
            String orgCode = user.getCurrentDepart().getOrgCode();
            if ("A04A01A01A01".equals(orgCode)) {
                id = userName;
            }
            int allCount = echartService.getProjectCountByUserid(id, null);
            int joinCount = echartService.getProjectCountByUserid(id, "1");
            result.put("allCount",allCount);
            result.put("joinCount",joinCount);
            result.put("unjoinCount",allCount - joinCount);

        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }

    /**
     * @Title getBarGraphData1
     * @Description 获取每个月新增的对接系统
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     * @Author liuzc
     * @Date 2018/8/15 下午4:56
     **/
    @RequestMapping(params = "getBarGraphData1")
    @ResponseBody
    public AjaxJson getBarGraphData1(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        Map<String,Object> result = new HashMap<String,Object>();
        TSUser user = ResourceUtil.getSessionUser();
        try{
            String id = null;
            String userName = user.getUserName();
            String orgCode = user.getCurrentDepart().getOrgCode();
            if ("A04A01A01A01".equals(orgCode)) {
                id = userName;
            }
            for (int i = 1; i <=12; i++) {
                String month = DateUtils.getYear() + "-" + i;
                if (i < 10) {
                    month = DateUtils.getYear() + "-0" + i;
                }
                int projectCount = echartService.getProjectCountByMonth(id, month);
                result.put(i+"",projectCount);
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

        json.setAttributes(result);
        json.setMsg("查询成功！");
        return json;
    }


    /**
     * @Title getBarGraphData2
     * @Description 获取每个用户负责的系统数
     * @Param [request]
     * @Return org.jeecgframework.core.common.model.json.AjaxJson
     * @Author liuzc
     * @Date 2018/8/15 下午4:58
     **/
    @RequestMapping(params = "getBarGraphData2")
    @ResponseBody
    public AjaxJson getBarGraphData2(HttpServletRequest request) {
        AjaxJson json=new AjaxJson();
        try{
            List<StatisticsVo> allCount = echartService.getEveryProjectCount();
            json.setObj(allCount);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        json.setMsg("查询成功！");
        return json;
    }

}
