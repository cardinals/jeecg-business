package com.sxctc.workreport.controller;
import com.sxctc.todolist.entity.TBTodoListEntity;
import com.sxctc.todolist.service.TBTodoListServiceI;
import com.sxctc.util.DateUtil;
import com.sxctc.workreport.entity.TBBusiWorkreportEntity;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.service.TBBusiWorkreportServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;

import java.io.OutputStream;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 今日日报列表
 * @author onlineGenerator
 * @date 2018-08-08 11:29:17
 * @version V1.0   
 *
 */
@Api(value="TBBusiWorkreport",description="今日日报列表",tags="tBBusiWorkreportController")
@Controller
@RequestMapping("/tBBusiWorkreportController")
public class TBBusiWorkreportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBBusiWorkreportController.class);

	@Autowired
	private TBBusiWorkreportServiceI tBBusiWorkreportService;
	@Autowired
	private TBTodoListServiceI tBTodoListService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 今日日报列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request, String toolFlag) {
		request.setAttribute("toolFlag", toolFlag);
		return new ModelAndView("com/sxctc/workreport/tBBusiWorkreportList");
	}

	@RequestMapping(params = "mainlist")
	public ModelAndView mainlist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/workreport/tBBusiWorkreportMainList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBBusiWorkreportEntity tBBusiWorkreport,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String reportOpt) {
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
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBBusiWorkreportService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除今日日报列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBBusiWorkreportEntity tBBusiWorkreport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBBusiWorkreport = systemService.getEntity(TBBusiWorkreportEntity.class, tBBusiWorkreport.getId());
		message = "今日日报列表删除成功";
		try{
			tBBusiWorkreportService.delete(tBBusiWorkreport);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "今日日报列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除今日日报列表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "今日日报列表删除成功";
		try{
			for(String id:ids.split(",")){
				TBBusiWorkreportEntity tBBusiWorkreport = systemService.getEntity(TBBusiWorkreportEntity.class, 
				id
				);
				tBBusiWorkreportService.delete(tBBusiWorkreport);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "今日日报列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加今日日报列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBBusiWorkreportEntity tBBusiWorkreport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "今日日报列表添加成功";
		try{
			tBBusiWorkreportService.save(tBBusiWorkreport);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "今日日报列表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新今日日报列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBBusiWorkreportEntity tBBusiWorkreport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "日报管理更新成功";
		try {
			String busiReportId = tBBusiWorkreport.getId();

			// 获取日报的内容
			String doneDay = tBBusiWorkreport.getDoneToday();
			String unDoneDay = tBBusiWorkreport.getUnDoneToday();
			String coordinateWork = tBBusiWorkreport.getCoordinateWork();
			String remark = tBBusiWorkreport.getRemark();
			Date reportDate = tBBusiWorkreport.getReportDate();
			String s = DateUtils.formatDate(reportDate, "yyy-MM-dd");
			// 获取主表实体，进行保存更新
			TBBusiWorkreportEntity tBBusiWorkreportEntity = tBBusiWorkreportService.getEntity(TBBusiWorkreportEntity.class, busiReportId);

			// 更新内容
			tBBusiWorkreportEntity.setDoneToday(doneDay);
			tBBusiWorkreportEntity.setUnDoneToday(unDoneDay);
			tBBusiWorkreportEntity.setCoordinateWork(coordinateWork);
			tBBusiWorkreportEntity.setRemark(remark);
			tBBusiWorkreportEntity.setReportDate(DateUtils.parseDate(s,"yyyy-MM-dd"));
			// 保存更新
			tBBusiWorkreportService.saveOrUpdate(tBBusiWorkreportEntity);

			// 2、保存 t_b_workreportday 表
			TBWorkreportdayEntity tBWorkreportday = new TBWorkreportdayEntity();
			tBWorkreportday.setDoneDay(doneDay);
			tBWorkreportday.setUnDoneDay(unDoneDay);
			tBWorkreportday.setCoordinateWork(coordinateWork);
			tBWorkreportday.setRemark(remark);
			tBWorkreportday.setReportDate(DateUtils.parseDate(s,"yyyy-MM-dd"));
			tBWorkreportday.setUnitCode(tBBusiWorkreportEntity.getUnitCode());
			tBWorkreportday.setProjectName(tBBusiWorkreportEntity.getReportTitle());
			tBWorkreportday.setReportType(tBBusiWorkreportEntity.getReportType());
			tBWorkreportday.setBusinessId(tBBusiWorkreportEntity.getBusinessId());
			List<TBWorkreportdayEntity> byQueryString = tBBusiWorkreportService.findByQueryString("from TBWorkreportdayEntity t where t.busiReportId=" + "'" + busiReportId + "'" + " and t.reportDate=" + "'" + s + "'");
			if (byQueryString.size() > 0) {
				tBWorkreportday.setId(byQueryString.get(0).getId());
				tBWorkreportday.setBusiReportId(busiReportId);
				tBWorkreportday.setCreateName(byQueryString.get(0).getCreateName());
				tBWorkreportday.setCreateBy(byQueryString.get(0).getCreateBy());
				tBWorkreportday.setCreateDate(byQueryString.get(0).getCreateDate());
				tBWorkreportday.setSysCompanyCode(byQueryString.get(0).getSysCompanyCode());
				tBWorkreportday.setSysOrgCode(byQueryString.get(0).getSysOrgCode());
				tBBusiWorkreportService.getSession().merge(tBWorkreportday);
			}else {
				tBWorkreportday.setId(null);
				tBWorkreportday.setBusiReportId(busiReportId);
				tBBusiWorkreportService.save(tBWorkreportday);
			}

			// 3、保存到待办事项表
			if (StringUtils.isNotBlank(unDoneDay)) {
				TBTodoListEntity tbTodoList = new TBTodoListEntity();
				tbTodoList.setTodoContent(unDoneDay);
				tbTodoList.setTodoStatus(0);
				tBTodoListService.save(tbTodoList);

			}

			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "日报管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 今日日报列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBBusiWorkreportEntity tBBusiWorkreport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusiWorkreport.getId())) {
			tBBusiWorkreport = tBBusiWorkreportService.getEntity(TBBusiWorkreportEntity.class, tBBusiWorkreport.getId());
			req.setAttribute("tBBusiWorkreportPage", tBBusiWorkreport);
		}
		return new ModelAndView("com/sxctc/workreport/tBBusiWorkreport-add");
	}
	/**
	 * 今日日报列表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBBusiWorkreportEntity tBBusiWorkreport, HttpServletRequest req, String toolFlag) {
		if (StringUtil.isNotEmpty(tBBusiWorkreport.getId())) {
			String id = tBBusiWorkreport.getId();
			// 去t_b_busi_workreport表查询回填信息
			TBBusiWorkreportEntity tBBusiWorkreportEntity = tBBusiWorkreportService.getEntity(TBBusiWorkreportEntity.class, id);
			tBBusiWorkreportEntity.setReportDate(DateUtils.getDate());

			req.setAttribute("tBBusiWorkreportPage", tBBusiWorkreportEntity);
			req.setAttribute("toolFlag", toolFlag);
		}

		return new ModelAndView("com/sxctc/workreport/tBBusiWorkreport-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBBusiWorkreportController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBBusiWorkreportEntity tBBusiWorkreport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap, String reportDate_begin, String reportDate_end) {
		CriteriaQuery cq = new CriteriaQuery(TBBusiWorkreportEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiWorkreport, request.getParameterMap());
		List<TBBusiWorkreportEntity> tBBusiWorkreports = this.tBBusiWorkreportService.getListByCriteriaQuery(cq,false);
		String fileName = "日报列表";
		if (StringUtils.isNotBlank(reportDate_begin) && StringUtils.isNotBlank(reportDate_end)) {
			if (reportDate_begin.equals(reportDate_end)) {
				fileName = reportDate_begin + "日报列表";
			}else {
				fileName = reportDate_begin + "~" + reportDate_end + "日报列表";
			}
		}
		modelMap.put(NormalExcelConstants.FILE_NAME,fileName);
		modelMap.put(NormalExcelConstants.CLASS,TBBusiWorkreportEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("今日日报列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBBusiWorkreports);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	/**
	 * 导出今日excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportTodayXls")
	public String exportTodayXls(TBBusiWorkreportEntity tBBusiWorkreport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBBusiWorkreportEntity.class, dataGrid);
		cq.ge("reportDate", java.sql.Date.valueOf(DateUtils.formatDate(new Date(),"yyyy-MM-dd")));
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiWorkreport, request.getParameterMap());
		List<TBBusiWorkreportEntity> tBBusiWorkreports = this.tBBusiWorkreportService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"今日日报列表");
		modelMap.put(NormalExcelConstants.CLASS,TBBusiWorkreportEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("今日日报列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBBusiWorkreports);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBBusiWorkreportEntity tBBusiWorkreport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"今日日报列表");
    	modelMap.put(NormalExcelConstants.CLASS,TBBusiWorkreportEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("今日日报列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TBBusiWorkreportEntity> listTBBusiWorkreportEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBBusiWorkreportEntity.class,params);
				for (TBBusiWorkreportEntity tBBusiWorkreport : listTBBusiWorkreportEntitys) {
					tBBusiWorkreportService.save(tBBusiWorkreport);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="今日日报列表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBBusiWorkreportEntity>> list() {
		List<TBBusiWorkreportEntity> listTBBusiWorkreports=tBBusiWorkreportService.getList(TBBusiWorkreportEntity.class);
		return Result.success(listTBBusiWorkreports);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取今日日报列表信息",notes="根据ID获取今日日报列表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBBusiWorkreportEntity task = tBBusiWorkreportService.get(TBBusiWorkreportEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取今日日报列表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建今日日报列表")
	public ResponseMessage<?> create(@ApiParam(name="今日日报列表对象")@RequestBody TBBusiWorkreportEntity tBBusiWorkreport, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusiWorkreportEntity>> failures = validator.validate(tBBusiWorkreport);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusiWorkreportService.save(tBBusiWorkreport);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("今日日报列表信息保存失败");
		}
		return Result.success(tBBusiWorkreport);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新今日日报列表",notes="更新今日日报列表")
	public ResponseMessage<?> update(@ApiParam(name="今日日报列表对象")@RequestBody TBBusiWorkreportEntity tBBusiWorkreport) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusiWorkreportEntity>> failures = validator.validate(tBBusiWorkreport);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusiWorkreportService.saveOrUpdate(tBBusiWorkreport);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新今日日报列表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新今日日报列表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除今日日报列表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBBusiWorkreportService.deleteEntityById(TBBusiWorkreportEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("今日日报列表删除失败");
		}

		return Result.success();
	}
}
