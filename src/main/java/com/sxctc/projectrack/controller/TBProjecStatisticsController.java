package com.sxctc.projectrack.controller;

import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**   
 * @Title: Controller  
 * @Description: 项目跟踪管理
 * @author liuzc
 * @date 2018-08-02 15:29:29
 * @version V1.0   
 *
 */
@Api(value="TBBusiness",description="营销数据业务列表",tags="tBProjecStatisticsController")
@Controller
@RequestMapping("/tBProjecStatisticsController")
public class TBProjecStatisticsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBProjecStatisticsController.class);



	/**
	 * 营销数据业务列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "salesReport")
	public ModelAndView salesReport(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/projectrack/salesReport");
	}

}
