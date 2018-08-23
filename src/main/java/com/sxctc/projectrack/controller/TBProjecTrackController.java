package com.sxctc.projectrack.controller;

import com.alibaba.fastjson.JSONArray;
import com.sxctc.business.entity.TBBusiCatalogEntity;
import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.business.service.TBBusiCatalogServiceI;
import com.sxctc.business.service.TBBusinessServiceI;
import com.sxctc.workreport.entity.TBBusiWorkreportEntity;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.service.TBBusiWorkreportServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.*;

/**   
 * @Title: Controller  
 * @Description: 项目跟踪管理
 * @author liuzc
 * @date 2018-08-02 15:29:29
 * @version V1.0   
 *
 */
@Api(value="TBBusiness",description="营销数据业务列表",tags="tBProjecTrackController")
@Controller
@RequestMapping("/tBProjecTrackController")
public class TBProjecTrackController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBProjecTrackController.class);
	


	/**
	 * 营销数据业务列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tablist")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/projectrack/tBProjecTrackTab");
	}

}
