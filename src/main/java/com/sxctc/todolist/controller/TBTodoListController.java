package com.sxctc.todolist.controller;
import com.sxctc.todolist.entity.TBTodoListEntity;
import com.sxctc.todolist.service.TBTodoListServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxctc.util.DateUtil;
import org.apache.log4j.Logger;
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
 * @Description: 代办事项
 * @author onlineGenerator
 * @date 2018-11-06 14:19:37
 * @version V1.0   
 *
 */
@Api(value="TBTodoList",description="代办事项",tags="tBTodoListController")
@Controller
@RequestMapping("/tBTodoListController")
public class TBTodoListController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBTodoListController.class);

	@Autowired
	private TBTodoListServiceI tBTodoListService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 代办事项列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/todolist/tBTodoListList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBTodoListEntity tBTodoList,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBTodoListEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBTodoList, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("createBy", ResourceUtil.getSessionUser().getUserName());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBTodoListService.getDataGridReturn(cq, true);

		List<TBTodoListEntity> results = dataGrid.getResults();
		for (TBTodoListEntity result : results) {
			Date createDate = result.getCreateDate();
			if (DateUtil.getIntervalDays(new Date(), createDate) >1) {
				result.setIsDel(0);
			}else {
				result.setIsDel(1);
			}
		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除代办事项
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBTodoListEntity tBTodoList, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBTodoList = systemService.getEntity(TBTodoListEntity.class, tBTodoList.getId());
		message = "代办事项删除成功";
		try{
			tBTodoListService.delete(tBTodoList);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "代办事项删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除代办事项
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "代办事项删除成功";
		try{
			for(String id:ids.split(",")){
				TBTodoListEntity tBTodoList = systemService.getEntity(TBTodoListEntity.class, 
				id
				);
				tBTodoListService.delete(tBTodoList);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "代办事项删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加代办事项
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBTodoListEntity tBTodoList, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "代办事项添加成功";
		try{
			tBTodoListService.save(tBTodoList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "代办事项添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新代办事项
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBTodoListEntity tBTodoList, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "代办事项更新成功";
		TBTodoListEntity t = tBTodoListService.get(TBTodoListEntity.class, tBTodoList.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBTodoList, t);
			tBTodoListService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "代办事项更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 代办事项新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBTodoListEntity tBTodoList, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBTodoList.getId())) {
			tBTodoList = tBTodoListService.getEntity(TBTodoListEntity.class, tBTodoList.getId());
			req.setAttribute("tBTodoListPage", tBTodoList);
		}
		return new ModelAndView("com/sxctc/todolist/tBTodoList-add");
	}
	/**
	 * 代办事项编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBTodoListEntity tBTodoList, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBTodoList.getId())) {
			tBTodoList = tBTodoListService.getEntity(TBTodoListEntity.class, tBTodoList.getId());
			req.setAttribute("tBTodoListPage", tBTodoList);
		}
		return new ModelAndView("com/sxctc/todolist/tBTodoList-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBTodoListController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBTodoListEntity tBTodoList,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBTodoListEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBTodoList, request.getParameterMap());
		List<TBTodoListEntity> tBTodoLists = this.tBTodoListService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"代办事项");
		modelMap.put(NormalExcelConstants.CLASS,TBTodoListEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("代办事项列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBTodoLists);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBTodoListEntity tBTodoList,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"代办事项");
    	modelMap.put(NormalExcelConstants.CLASS,TBTodoListEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("代办事项列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBTodoListEntity> listTBTodoListEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBTodoListEntity.class,params);
				for (TBTodoListEntity tBTodoList : listTBTodoListEntitys) {
					tBTodoListService.save(tBTodoList);
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
	@ApiOperation(value="代办事项列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBTodoListEntity>> list() {
		List<TBTodoListEntity> listTBTodoLists=tBTodoListService.getList(TBTodoListEntity.class);
		return Result.success(listTBTodoLists);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取代办事项信息",notes="根据ID获取代办事项信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBTodoListEntity task = tBTodoListService.get(TBTodoListEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取代办事项信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建代办事项")
	public ResponseMessage<?> create(@ApiParam(name="代办事项对象")@RequestBody TBTodoListEntity tBTodoList, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBTodoListEntity>> failures = validator.validate(tBTodoList);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBTodoListService.save(tBTodoList);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("代办事项信息保存失败");
		}
		return Result.success(tBTodoList);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新代办事项",notes="更新代办事项")
	public ResponseMessage<?> update(@ApiParam(name="代办事项对象")@RequestBody TBTodoListEntity tBTodoList) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBTodoListEntity>> failures = validator.validate(tBTodoList);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBTodoListService.saveOrUpdate(tBTodoList);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新代办事项信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新代办事项信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除代办事项")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBTodoListService.deleteEntityById(TBTodoListEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("代办事项删除失败");
		}

		return Result.success();
	}
}
