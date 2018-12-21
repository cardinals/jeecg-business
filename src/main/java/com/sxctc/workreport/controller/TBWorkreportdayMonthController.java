package com.sxctc.workreport.controller;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.util.DateUtil;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.entity.TBWorkreportdayMonthEntity;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
import com.sxctc.workreport.service.TBWorkreportdayMonthServiceI;

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
 * @Description: 月报
 * @author onlineGenerator
 * @date 2018-08-29 14:54:50
 * @version V1.0   
 *
 */
@Api(value="TBWorkreportdayMonth",description="月报",tags="tBWorkreportdayMonthController")
@Controller
@RequestMapping("/tBWorkreportdayMonthController")
public class TBWorkreportdayMonthController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBWorkreportdayMonthController.class);

	@Autowired
	private TBWorkreportdayMonthServiceI tBWorkreportdayMonthService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 月报列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request, String toolFlag) {
		request.setAttribute("toolFlag", toolFlag);
		return new ModelAndView("com/sxctc/workreport/tBWorkreportdayMonthList");
	}

	@RequestMapping(params = "mainlist")
	public ModelAndView mainlist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/workreport/tBBusiWorkreportMonthMainList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBWorkreportdayMonthEntity tBWorkreportdayMonth,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String reportOpt) {
		CriteriaQuery cq = new CriteriaQuery(TBWorkreportdayMonthEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBWorkreportdayMonth, request.getParameterMap());
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
			String start = request.getParameter("reportDate_begin");
			String end = request.getParameter("reportDate_end");
			if(StringUtil.isNotEmpty(start)){
				cq.ge("reportDate",DateUtils.parseDate(start,"yyyy-MM"));
			}
			if(StringUtil.isNotEmpty(end)){
				cq.le("reportDate",DateUtils.parseDate(end,"yyyy-MM"));
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBWorkreportdayMonthService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除月报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBWorkreportdayMonthEntity tBWorkreportdayMonth, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBWorkreportdayMonth = systemService.getEntity(TBWorkreportdayMonthEntity.class, tBWorkreportdayMonth.getId());
		message = "月报删除成功";
		try{
			tBWorkreportdayMonthService.delete(tBWorkreportdayMonth);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "月报删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除月报
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "月报删除成功";
		try{
			for(String id:ids.split(",")){
				TBWorkreportdayMonthEntity tBWorkreportdayMonth = systemService.getEntity(TBWorkreportdayMonthEntity.class, 
				id
				);
				tBWorkreportdayMonthService.delete(tBWorkreportdayMonth);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "月报删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加月报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBWorkreportdayMonthEntity tBWorkreportdayMonth, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "月报添加成功";
		try{
			tBWorkreportdayMonthService.save(tBWorkreportdayMonth);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "月报添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新月报
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBWorkreportdayMonthEntity tBWorkreportdayMonth, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "月报更新成功";
		TBWorkreportdayMonthEntity t = tBWorkreportdayMonthService.get(TBWorkreportdayMonthEntity.class, tBWorkreportdayMonth.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBWorkreportdayMonth, t);
			tBWorkreportdayMonthService.saveOrUpdateMonth(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "月报更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 月报新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBWorkreportdayMonthEntity tBWorkreportdayMonth, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBWorkreportdayMonth.getId())) {
			tBWorkreportdayMonth = tBWorkreportdayMonthService.getEntity(TBWorkreportdayMonthEntity.class, tBWorkreportdayMonth.getId());
			req.setAttribute("tBWorkreportdayMonthPage", tBWorkreportdayMonth);
		}
		return new ModelAndView("com/sxctc/workreport/tBWorkreportdayMonth-add");
	}
	/**
	 * 月报编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBWorkreportdayMonthEntity tBWorkreportdayMonth, HttpServletRequest req, String toolFlag, String isCheck) {
		TSUser tsUser = ResourceUtil.getSessionUser();
		try {
			if (StringUtil.isNotEmpty(tBWorkreportdayMonth.getId())) {
				tBWorkreportdayMonth = tBWorkreportdayMonthService.getEntity(TBWorkreportdayMonthEntity.class, tBWorkreportdayMonth.getId());
				JSONObject monthDays = DateUtil.getMonthDays(0);
				String beginDate = monthDays.getString("beginDate");
				String endDate = monthDays.getString("endDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Date date = sdf.parse(sdf.format(new Date()));
				tBWorkreportdayMonth.setReportDate(date);

				String doneToday = tBWorkreportdayMonth.getDoneToday();
				if (StringUtils.isBlank(doneToday) && StringUtils.isBlank(isCheck)) {
					// 拼装工作内容
					String doneWork = "";
					List<TBWorkreportdayEntity> byQueryString = tBWorkreportdayMonthService.findByQueryString("from TBWorkreportdayEntity where createBy='" + tsUser.getUserName() + "' and reportType=" + tBWorkreportdayMonth.getReportType() + " and reportDate>='" + beginDate + "' and reportDate<='" + endDate + "'");
					if (byQueryString.size() > 0) {
						for (TBWorkreportdayEntity tbWorkreportdayEntity : byQueryString) {
							String doneDay = tbWorkreportdayEntity.getDoneDay();
							if (StringUtils.isNotBlank(doneDay)) {
								doneWork += (doneDay + "\r\n");
							}
						}
					}
					if (StringUtils.isNotBlank(doneWork)) {
						tBWorkreportdayMonth.setDoneToday(doneWork);
					}
				}
				req.setAttribute("tBWorkreportdayMonthPage", tBWorkreportdayMonth);
				req.setAttribute("toolFlag", toolFlag);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return new ModelAndView("com/sxctc/workreport/tBWorkreportdayMonth-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBWorkreportdayMonthController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBWorkreportdayMonthEntity tBWorkreportdayMonth,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBWorkreportdayMonthEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBWorkreportdayMonth, request.getParameterMap());
		List<TBWorkreportdayMonthEntity> tBWorkreportdayMonths = this.tBWorkreportdayMonthService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"月报");
		modelMap.put(NormalExcelConstants.CLASS,TBWorkreportdayMonthEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("月报列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBWorkreportdayMonths);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBWorkreportdayMonthEntity tBWorkreportdayMonth,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"月报");
    	modelMap.put(NormalExcelConstants.CLASS,TBWorkreportdayMonthEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("月报列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBWorkreportdayMonthEntity> listTBWorkreportdayMonthEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBWorkreportdayMonthEntity.class,params);
				for (TBWorkreportdayMonthEntity tBWorkreportdayMonth : listTBWorkreportdayMonthEntitys) {
					tBWorkreportdayMonthService.save(tBWorkreportdayMonth);
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
	@ApiOperation(value="月报列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBWorkreportdayMonthEntity>> list() {
		List<TBWorkreportdayMonthEntity> listTBWorkreportdayMonths=tBWorkreportdayMonthService.getList(TBWorkreportdayMonthEntity.class);
		return Result.success(listTBWorkreportdayMonths);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取月报信息",notes="根据ID获取月报信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBWorkreportdayMonthEntity task = tBWorkreportdayMonthService.get(TBWorkreportdayMonthEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取月报信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建月报")
	public ResponseMessage<?> create(@ApiParam(name="月报对象")@RequestBody TBWorkreportdayMonthEntity tBWorkreportdayMonth, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBWorkreportdayMonthEntity>> failures = validator.validate(tBWorkreportdayMonth);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBWorkreportdayMonthService.save(tBWorkreportdayMonth);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("月报信息保存失败");
		}
		return Result.success(tBWorkreportdayMonth);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新月报",notes="更新月报")
	public ResponseMessage<?> update(@ApiParam(name="月报对象")@RequestBody TBWorkreportdayMonthEntity tBWorkreportdayMonth) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBWorkreportdayMonthEntity>> failures = validator.validate(tBWorkreportdayMonth);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBWorkreportdayMonthService.saveOrUpdate(tBWorkreportdayMonth);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新月报信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新月报信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除月报")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBWorkreportdayMonthService.deleteEntityById(TBWorkreportdayMonthEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("月报删除失败");
		}

		return Result.success();
	}
}
