package com.sxctc.business.controller;
import com.sxctc.business.entity.TBBusiCatalogEntity;
import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.business.service.TBBusiCatalogServiceI;
import com.sxctc.business.service.TBBusinessServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.projectrack.service.TBChancePoolServiceI;
import com.sxctc.unitManage.entity.TBUnitManageEntity;
import com.sxctc.unitManage.service.TBUnitManageServiceI;
import com.sxctc.workreport.entity.TBBusiWorkreportEntity;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.service.TBBusiWorkreportServiceI;
import org.apache.log4j.Logger;
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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.jeecgframework.core.util.ExceptionUtil;

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
 * @Description: 营销数据业务列表
 * @author onlineGenerator
 * @date 2018-08-02 15:29:29
 * @version V1.0   
 *
 */
@Api(value="TBBusiness",description="营销数据业务列表",tags="tBBusinessController")
@Controller
@RequestMapping("/tBBusinessController")
public class TBBusinessController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBBusinessController.class);

	@Autowired
	private TBBusinessServiceI tBBusinessService;
	@Autowired
	private TBBusiWorkreportServiceI tBBusiWorkreportService;
	@Autowired
	private TBBusiCatalogServiceI tBBusiCatalogServiceI;
	@Autowired
	private TBChancePoolServiceI tbChancePoolService;
	@Autowired
	private TBUnitManageServiceI tbUnitManageService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 营销数据业务列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/business/tBBusinessList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBBusinessEntity tBBusiness,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBBusinessEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiness, request.getParameterMap());
		try{
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBBusinessService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除营销数据业务列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBBusinessEntity tBBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		String businessId = tBBusiness.getId();
		tBBusiness = systemService.getEntity(TBBusinessEntity.class, businessId);
		message = "营销数据业务列表删除成功";
		try{

            tBBusinessService.deleteBusiness(tBBusiness, businessId);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "营销数据业务列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除营销数据业务列表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "营销数据业务列表删除成功";
		try{
			for(String id:ids.split(",")){
				TBBusinessEntity tBBusiness = systemService.getEntity(TBBusinessEntity.class, 
				id
				);
				tBBusinessService.deleteBusiness(tBBusiness,id);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "营销数据业务列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加营销数据业务列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBBusinessEntity tBBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "营销数据业务列表添加成功";
		try{
			tBBusinessService.doAddBusiness(tBBusiness);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "营销数据业务列表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新营销数据业务列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBBusinessEntity tBBusiness, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "营销数据业务列表更新成功";

		TBBusinessEntity t = tBBusinessService.get(TBBusinessEntity.class, tBBusiness.getId());

		Date finishTime = tBBusiness.getFinishTime();
		Date busJoinTime = t.getBusJoinTime();
		if (finishTime != null) {
			long day=(finishTime.getTime()-busJoinTime.getTime())/(24*60*60*1000);
			if (day >= 0) {
				tBBusiness.setDayRange((int)day);
			}
		}
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBBusiness, t);
			tBBusinessService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "营销数据业务列表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 营销数据业务列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBBusinessEntity tBBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusiness.getId())) {
			tBBusiness = tBBusinessService.getEntity(TBBusinessEntity.class, tBBusiness.getId());
			req.setAttribute("tBBusinessPage", tBBusiness);
		}
		TSUser user = ResourceUtil.getSessionUser();
		String currentUser = user.getUserName();
		req.setAttribute("currentUser", currentUser);
		return new ModelAndView("com/sxctc/business/tBBusiness-add");
	}
	/**
	 * 营销数据业务列表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBBusinessEntity tBBusiness, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusiness.getId())) {
			tBBusiness = tBBusinessService.getEntity(TBBusinessEntity.class, tBBusiness.getId());
			req.setAttribute("tBBusinessPage", tBBusiness);
		}
		return new ModelAndView("com/sxctc/business/tBBusiness-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBBusinessController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBBusinessEntity tBBusiness,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBBusinessEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiness, request.getParameterMap());
		List<TBBusinessEntity> tBBusinesss = this.tBBusinessService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"营销数据业务列表");
		modelMap.put(NormalExcelConstants.CLASS,TBBusinessEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("营销数据业务列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBBusinesss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBBusinessEntity tBBusiness,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"营销数据业务列表");
    	modelMap.put(NormalExcelConstants.CLASS,TBBusinessEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("营销数据业务列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBBusinessEntity> listTBBusinessEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBBusinessEntity.class,params);
				for (TBBusinessEntity tBBusiness : listTBBusinessEntitys) {
					tBBusinessService.save(tBBusiness);
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
	@ApiOperation(value="营销数据业务列表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBBusinessEntity>> list() {
		List<TBBusinessEntity> listTBBusinesss=tBBusinessService.getList(TBBusinessEntity.class);
		return Result.success(listTBBusinesss);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取营销数据业务列表信息",notes="根据ID获取营销数据业务列表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBBusinessEntity task = tBBusinessService.get(TBBusinessEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取营销数据业务列表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建营销数据业务列表")
	public ResponseMessage<?> create(@ApiParam(name="营销数据业务列表对象")@RequestBody TBBusinessEntity tBBusiness, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusinessEntity>> failures = validator.validate(tBBusiness);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusinessService.save(tBBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("营销数据业务列表信息保存失败");
		}
		return Result.success(tBBusiness);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新营销数据业务列表",notes="更新营销数据业务列表")
	public ResponseMessage<?> update(@ApiParam(name="营销数据业务列表对象")@RequestBody TBBusinessEntity tBBusiness) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusinessEntity>> failures = validator.validate(tBBusiness);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusinessService.saveOrUpdate(tBBusiness);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新营销数据业务列表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新营销数据业务列表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除营销数据业务列表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBBusinessService.deleteEntityById(TBBusinessEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("营销数据业务列表删除失败");
		}

		return Result.success();
	}
}
