package com.sxctc.workreport.controller;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.util.DateUtil;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
import com.sxctc.workreport.service.TBWorkreportdayWeekServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
import org.jeecgframework.web.system.pojo.base.TSUser;
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
 * @Description: 周报
 * @author onlineGenerator
 * @date 2018-08-13 10:00:26
 * @version V1.0   
 *
 */
@Api(value="TBWorkreportdayWeek",description="周报",tags="tBWorkreportdayWeekController")
@Controller
@RequestMapping("/tBWorkreportdayWeekController")
public class TBWorkreportdayWeekController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBWorkreportdayWeekController.class);

	@Autowired
	private TBWorkreportdayWeekServiceI tBWorkreportdayWeekService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 周报列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request, String toolFlag) {
		request.setAttribute("toolFlag", toolFlag);
		return new ModelAndView("com/sxctc/workreport/tBWorkreportdayWeekList");
	}

	@RequestMapping(params = "mainlist")
	public ModelAndView mainlist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/workreport/tBBusiWorkreportWeekMainList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBWorkreportdayWeekEntity tBWorkreportdayWeek,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String reportOpt) {
		CriteriaQuery cq = new CriteriaQuery(TBWorkreportdayWeekEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBWorkreportdayWeek, request.getParameterMap());
		try{
			//自定义追加查询条件
			if (StringUtils.isNotBlank(reportOpt)){
				if ("0".equals(reportOpt)){
					cq.eq("reportType",0);
					/*// 只查询未结束的系统
					List<String> busiList = getVaildBusinessIdList();
					if (busiList != null && busiList.size()>0) {
						cq.in("businessId",busiList.toArray());
					}*/
				}else {
					cq.notEq("reportType",0);
					cq.notEq("reportType",9);
				}
			}

			//起始时间
			String start = request.getParameter("searchDate_begin");
			String end = request.getParameter("searchDate_end");
			if(StringUtil.isNotEmpty(start)&&StringUtil.isNotEmpty(end)&&start.equals(end)){
				start=start+" 00:00:00";
				end=end+" 23:59:59";
			}
			if(StringUtil.isNotEmpty(start)){
				cq.ge("reportStartDate",DateUtils.parseDate(start,"yyyy-MM-dd"));
			}
			if(StringUtil.isNotEmpty(end)){
				cq.le("reportEndDate",DateUtils.parseDate(end,"yyyy-MM-dd"));
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBWorkreportdayWeekService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除周报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBWorkreportdayWeekEntity tBWorkreportdayWeek, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBWorkreportdayWeek = systemService.getEntity(TBWorkreportdayWeekEntity.class, tBWorkreportdayWeek.getId());
		message = "周报删除成功";
		try{
			tBWorkreportdayWeekService.delete(tBWorkreportdayWeek);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "周报删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除周报
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "周报删除成功";
		try{
			for(String id:ids.split(",")){
				TBWorkreportdayWeekEntity tBWorkreportdayWeek = systemService.getEntity(TBWorkreportdayWeekEntity.class, 
				id
				);
				tBWorkreportdayWeekService.delete(tBWorkreportdayWeek);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "周报删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加周报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBWorkreportdayWeekEntity tBWorkreportdayWeek, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "周报添加成功";
		try{
			tBWorkreportdayWeekService.save(tBWorkreportdayWeek);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "周报添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新周报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBWorkreportdayWeekEntity tBWorkreportdayWeek, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "周报更新成功";
		TBWorkreportdayWeekEntity t = tBWorkreportdayWeekService.get(TBWorkreportdayWeekEntity.class, tBWorkreportdayWeek.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBWorkreportdayWeek, t);
			tBWorkreportdayWeekService.saveOrUpdateWeek(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "周报更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 周报新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBWorkreportdayWeekEntity tBWorkreportdayWeek, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBWorkreportdayWeek.getId())) {
			tBWorkreportdayWeek = tBWorkreportdayWeekService.getEntity(TBWorkreportdayWeekEntity.class, tBWorkreportdayWeek.getId());
			req.setAttribute("tBWorkreportdayWeekPage", tBWorkreportdayWeek);
		}
		return new ModelAndView("com/sxctc/workreport/tBWorkreportdayWeek-add");
	}
	/**
	 * 周报编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBWorkreportdayWeekEntity tBWorkreportdayWeek, HttpServletRequest req, String toolFlag, String isCheck) {
		TSUser tsUser = ResourceUtil.getSessionUser();
		try {
			if (StringUtil.isNotEmpty(tBWorkreportdayWeek.getId())) {
				tBWorkreportdayWeek = tBWorkreportdayWeekService.getEntity(TBWorkreportdayWeekEntity.class, tBWorkreportdayWeek.getId());
				JSONObject weekDays = DateUtil.getWeekDays(0);
				String beginDate = weekDays.getString("beginDate");
				String endDate = weekDays.getString("endDate");
				tBWorkreportdayWeek.setReportStartDate(DateUtils.parseDate(beginDate,"yyyy-MM-dd"));
				tBWorkreportdayWeek.setReportEndDate(DateUtils.parseDate(endDate,"yyyy-MM-dd"));

				String doneToday = tBWorkreportdayWeek.getDoneDay();
				if (StringUtils.isBlank(doneToday) && StringUtils.isBlank(isCheck)) {
					// 拼装工作内容
					String doneWork = "";
					List<TBWorkreportdayEntity> byQueryString = new ArrayList<TBWorkreportdayEntity>();
					String hql = "from TBWorkreportdayEntity where createBy=? and reportType=? and reportDate>=? and reportDate<=?";
					if (tBWorkreportdayWeek.getReportType() != 0) {
						byQueryString = tBWorkreportdayWeekService.findHql(hql, tsUser.getUserName(), tBWorkreportdayWeek.getReportType(), DateUtils.parseDate(beginDate,"yyyy-MM-dd"), DateUtils.parseDate(endDate,"yyyy-MM-dd"));
					}else {
						hql += " and businessId=?";
						byQueryString = tBWorkreportdayWeekService.findHql(hql, tsUser.getUserName(), tBWorkreportdayWeek.getReportType(), DateUtils.parseDate(beginDate,"yyyy-MM-dd"), DateUtils.parseDate(endDate,"yyyy-MM-dd"), tBWorkreportdayWeek.getBusinessId());
					}
					if (byQueryString.size() > 0) {
						for (TBWorkreportdayEntity tbWorkreportdayEntity : byQueryString) {
							String doneDay = tbWorkreportdayEntity.getDoneDay();
							if (StringUtils.isNotBlank(doneDay)) {
								doneWork += (doneDay + "\r\n");
							}
						}
					}
					if (StringUtils.isNotBlank(doneWork)) {
						tBWorkreportdayWeek.setDoneDay(doneWork);
					}
				}
				req.setAttribute("tBWorkreportdayWeekPage", tBWorkreportdayWeek);
				req.setAttribute("toolFlag", toolFlag);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return new ModelAndView("com/sxctc/workreport/tBWorkreportdayWeek-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBWorkreportdayWeekController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBWorkreportdayWeekEntity tBWorkreportdayWeek,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBWorkreportdayWeekEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBWorkreportdayWeek, request.getParameterMap());
		List<TBWorkreportdayWeekEntity> tBWorkreportdayWeeks = this.tBWorkreportdayWeekService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"周报");
		modelMap.put(NormalExcelConstants.CLASS,TBWorkreportdayWeekEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("周报列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBWorkreportdayWeeks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBWorkreportdayWeekEntity tBWorkreportdayWeek,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"周报");
    	modelMap.put(NormalExcelConstants.CLASS,TBWorkreportdayWeekEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("周报列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBWorkreportdayWeekEntity> listTBWorkreportdayWeekEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBWorkreportdayWeekEntity.class,params);
				for (TBWorkreportdayWeekEntity tBWorkreportdayWeek : listTBWorkreportdayWeekEntitys) {
					tBWorkreportdayWeekService.save(tBWorkreportdayWeek);
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
	@ApiOperation(value="周报列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBWorkreportdayWeekEntity>> list() {
		List<TBWorkreportdayWeekEntity> listTBWorkreportdayWeeks=tBWorkreportdayWeekService.getList(TBWorkreportdayWeekEntity.class);
		return Result.success(listTBWorkreportdayWeeks);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取周报信息",notes="根据ID获取周报信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBWorkreportdayWeekEntity task = tBWorkreportdayWeekService.get(TBWorkreportdayWeekEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取周报信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建周报")
	public ResponseMessage<?> create(@ApiParam(name="周报对象")@RequestBody TBWorkreportdayWeekEntity tBWorkreportdayWeek, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBWorkreportdayWeekEntity>> failures = validator.validate(tBWorkreportdayWeek);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBWorkreportdayWeekService.save(tBWorkreportdayWeek);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("周报信息保存失败");
		}
		return Result.success(tBWorkreportdayWeek);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新周报",notes="更新周报")
	public ResponseMessage<?> update(@ApiParam(name="周报对象")@RequestBody TBWorkreportdayWeekEntity tBWorkreportdayWeek) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBWorkreportdayWeekEntity>> failures = validator.validate(tBWorkreportdayWeek);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBWorkreportdayWeekService.saveOrUpdate(tBWorkreportdayWeek);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新周报信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新周报信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除周报")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBWorkreportdayWeekService.deleteEntityById(TBWorkreportdayWeekEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("周报删除失败");
		}

		return Result.success();
	}
}
