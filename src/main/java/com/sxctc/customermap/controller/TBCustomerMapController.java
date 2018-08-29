package com.sxctc.customermap.controller;
import com.sxctc.customermap.entity.TBCustomerMapEntity;
import com.sxctc.customermap.service.TBCustomerMapServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxctc.customermap.vo.TBCustomerMapVo;
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
import java.util.Map;
import java.util.HashMap;
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
import java.util.Set;
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
 * @Description: 客户地图
 * @author onlineGenerator
 * @date 2018-08-24 16:41:15
 * @version V1.0   
 *
 */
@Api(value="TBCustomerMap",description="客户地图",tags="tBCustomerMapController")
@Controller
@RequestMapping("/tBCustomerMapController")
public class TBCustomerMapController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBCustomerMapController.class);

	@Autowired
	private TBCustomerMapServiceI tBCustomerMapService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 客户地图列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/customermap/tBCustomerMapList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBCustomerMapEntity tBCustomerMap,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBCustomerMapEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCustomerMap, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBCustomerMapService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除客户地图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBCustomerMapEntity tBCustomerMap, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBCustomerMap = systemService.getEntity(TBCustomerMapEntity.class, tBCustomerMap.getId());
		message = "客户地图删除成功";
		try{
			tBCustomerMapService.delete(tBCustomerMap);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户地图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除客户地图
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户地图删除成功";
		try{
			for(String id:ids.split(",")){
				TBCustomerMapEntity tBCustomerMap = systemService.getEntity(TBCustomerMapEntity.class, 
				id
				);
				tBCustomerMapService.delete(tBCustomerMap);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客户地图删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加客户地图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBCustomerMapVo tBCustomerMapVo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户地图添加成功";
		try{
			TBCustomerMapEntity tBCustomerMap = new TBCustomerMapEntity();
			Integer worthStatus = tBCustomerMapVo.getWorthStatus();
			String projectName = tBCustomerMapVo.getProjectName();
			Integer cooperateStatus = tBCustomerMapVo.getCooperateStatus();
			Integer unitCode = tBCustomerMapVo.getUnitCode();

			if (worthStatus != null) {
				if (worthStatus == 1) {
					tBCustomerMap.setWorthLow(projectName);
				}
				if (worthStatus == 2) {
					tBCustomerMap.setWorthMid(projectName);
				}
				if (worthStatus == 3) {
					tBCustomerMap.setWorthHigh(projectName);
				}
			}
			tBCustomerMap.setCooperateStatus(cooperateStatus);
			tBCustomerMap.setUnitCode(unitCode);

			tBCustomerMapService.save(tBCustomerMap);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户地图添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新客户地图
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBCustomerMapEntity tBCustomerMap, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客户地图更新成功";
		TBCustomerMapEntity t = tBCustomerMapService.get(TBCustomerMapEntity.class, tBCustomerMap.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBCustomerMap, t);
			tBCustomerMapService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "客户地图更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 客户地图新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBCustomerMapEntity tBCustomerMap, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBCustomerMap.getId())) {
			tBCustomerMap = tBCustomerMapService.getEntity(TBCustomerMapEntity.class, tBCustomerMap.getId());
			req.setAttribute("tBCustomerMapPage", tBCustomerMap);
		}
		return new ModelAndView("com/sxctc/customermap/tBCustomerMap-add");
	}
	/**
	 * 客户地图编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBCustomerMapEntity tBCustomerMap, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBCustomerMap.getId())) {
			tBCustomerMap = tBCustomerMapService.getEntity(TBCustomerMapEntity.class, tBCustomerMap.getId());
			req.setAttribute("tBCustomerMapPage", tBCustomerMap);
		}
		return new ModelAndView("com/sxctc/customermap/tBCustomerMap-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBCustomerMapController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBCustomerMapEntity tBCustomerMap,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBCustomerMapEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCustomerMap, request.getParameterMap());
		List<TBCustomerMapEntity> tBCustomerMaps = this.tBCustomerMapService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"客户地图");
		modelMap.put(NormalExcelConstants.CLASS,TBCustomerMapEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户地图列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBCustomerMaps);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBCustomerMapEntity tBCustomerMap,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"客户地图");
    	modelMap.put(NormalExcelConstants.CLASS,TBCustomerMapEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客户地图列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBCustomerMapEntity> listTBCustomerMapEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBCustomerMapEntity.class,params);
				for (TBCustomerMapEntity tBCustomerMap : listTBCustomerMapEntitys) {
					tBCustomerMapService.save(tBCustomerMap);
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
	@ApiOperation(value="客户地图列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBCustomerMapEntity>> list() {
		List<TBCustomerMapEntity> listTBCustomerMaps=tBCustomerMapService.getList(TBCustomerMapEntity.class);
		return Result.success(listTBCustomerMaps);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取客户地图信息",notes="根据ID获取客户地图信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBCustomerMapEntity task = tBCustomerMapService.get(TBCustomerMapEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取客户地图信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建客户地图")
	public ResponseMessage<?> create(@ApiParam(name="客户地图对象")@RequestBody TBCustomerMapEntity tBCustomerMap, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBCustomerMapEntity>> failures = validator.validate(tBCustomerMap);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBCustomerMapService.save(tBCustomerMap);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户地图信息保存失败");
		}
		return Result.success(tBCustomerMap);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新客户地图",notes="更新客户地图")
	public ResponseMessage<?> update(@ApiParam(name="客户地图对象")@RequestBody TBCustomerMapEntity tBCustomerMap) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBCustomerMapEntity>> failures = validator.validate(tBCustomerMap);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBCustomerMapService.saveOrUpdate(tBCustomerMap);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新客户地图信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新客户地图信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除客户地图")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBCustomerMapService.deleteEntityById(TBCustomerMapEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("客户地图删除失败");
		}

		return Result.success();
	}
}
