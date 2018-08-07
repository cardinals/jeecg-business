package com.sxctc.business.controller;
import com.sxctc.business.service.TBBusiCatalogServiceI;
import com.sxctc.business.entity.TBBusiCatalogEntity;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
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
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 服务目录业务关联表
 * @author onlineGenerator
 * @date 2018-08-05 16:48:39
 * @version V1.0   
 *
 */
@Api(value="TBBusiCatalog",description="服务目录业务关联表",tags="tBBusiCatalogController")
@Controller
@RequestMapping("/tBBusiCatalogController")
public class TBBusiCatalogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBBusiCatalogController.class);

	@Autowired
	private TBBusiCatalogServiceI tBBusiCatalogService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 服务目录业务关联表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/catalog1/tBBusiCatalogList");
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
	public void datagrid(TBBusiCatalogEntity tBBusiCatalog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBBusiCatalogEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiCatalog, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBBusiCatalogService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除服务目录业务关联表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBBusiCatalogEntity tBBusiCatalog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBBusiCatalog = systemService.getEntity(TBBusiCatalogEntity.class, tBBusiCatalog.getId());
		message = "服务目录业务关联表删除成功";
		try{
			tBBusiCatalogService.delete(tBBusiCatalog);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "服务目录业务关联表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除服务目录业务关联表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "服务目录业务关联表删除成功";
		try{
			for(String id:ids.split(",")){
				TBBusiCatalogEntity tBBusiCatalog = systemService.getEntity(TBBusiCatalogEntity.class, 
				id
				);
				tBBusiCatalogService.delete(tBBusiCatalog);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "服务目录业务关联表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加服务目录业务关联表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBBusiCatalogEntity tBBusiCatalog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "服务目录添加成功";
		try{

			// 保存之前先把所有业务有关的目录删除
			// 1、如果修改已经存在的业务，则执行doUpdate方法

			String businessId = tBBusiCatalog.getBusinessId();
			String catalogId = tBBusiCatalog.getCatalogId();
			Integer checkNum = tBBusiCatalog.getCheckNum();

			// 查询该业务id下面所有的关联
			List<TBBusiCatalogEntity> tBusiCatalogList = systemService.findByProperty(TBBusiCatalogEntity.class, "businessId", businessId);

			// 标识
			boolean optFlag = true;

			// 如果是0的话，去库中查找
			// 1、如果库中没有，则不作处理
			// 2、如果库中有，则删除数据
			if (checkNum == 0) {
				String hql = "from TBBusiCatalogEntity t where" + " t.catalogId='" + catalogId + "' and t.businessId='" + businessId + "'";
				List<TBBusiCatalogEntity> byQueryString = systemService.findByQueryString(hql);
				if (byQueryString.size() > 0) {
					for (TBBusiCatalogEntity tbBusiCatalogEntity : byQueryString) {
						systemService.deleteEntityById(TBBusiCatalogEntity.class,tbBusiCatalogEntity.getId());
					}
				}

				// 返回结束
				j.setMsg("服务目录删除成功");
				return j;
			}

			// 遍历
			for (TBBusiCatalogEntity tbBusiCatalog : tBusiCatalogList) {
				// 如果是修改，则执行更新方法
				if (tbBusiCatalog.getCatalogId().equals(catalogId)) {
					tBBusiCatalog.setId(tbBusiCatalog.getId());
					doUpdate(tBBusiCatalog, request);
					optFlag = false;

					message = "服务目录修改成功";
				}
			}

			// 如果没有进行过修改，则保存
			if (optFlag) {
				tBBusiCatalogService.save(tBBusiCatalog);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "服务目录业务关联表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新服务目录业务关联表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBBusiCatalogEntity tBBusiCatalog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "服务目录业务关联表更新成功";
		TBBusiCatalogEntity t = tBBusiCatalogService.get(TBBusiCatalogEntity.class, tBBusiCatalog.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBBusiCatalog, t);
			tBBusiCatalogService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "服务目录业务关联表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 服务目录业务关联表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBBusiCatalogEntity tBBusiCatalog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusiCatalog.getId())) {
			tBBusiCatalog = tBBusiCatalogService.getEntity(TBBusiCatalogEntity.class, tBBusiCatalog.getId());
			req.setAttribute("tBBusiCatalogPage", tBBusiCatalog);
		}
		return new ModelAndView("com/sxctc/catalog1/tBBusiCatalog-add");
	}
	/**
	 * 服务目录业务关联表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBBusiCatalogEntity tBBusiCatalog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusiCatalog.getId())) {
			tBBusiCatalog = tBBusiCatalogService.getEntity(TBBusiCatalogEntity.class, tBBusiCatalog.getId());
			req.setAttribute("tBBusiCatalogPage", tBBusiCatalog);
		}
		return new ModelAndView("com/sxctc/catalog1/tBBusiCatalog-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBBusiCatalogController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBBusiCatalogEntity tBBusiCatalog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBBusiCatalogEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiCatalog, request.getParameterMap());
		List<TBBusiCatalogEntity> tBBusiCatalogs = this.tBBusiCatalogService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"服务目录业务关联表");
		modelMap.put(NormalExcelConstants.CLASS,TBBusiCatalogEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("服务目录业务关联表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBBusiCatalogs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBBusiCatalogEntity tBBusiCatalog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"服务目录业务关联表");
    	modelMap.put(NormalExcelConstants.CLASS,TBBusiCatalogEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("服务目录业务关联表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBBusiCatalogEntity> listTBBusiCatalogEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBBusiCatalogEntity.class,params);
				for (TBBusiCatalogEntity tBBusiCatalog : listTBBusiCatalogEntitys) {
					tBBusiCatalogService.save(tBBusiCatalog);
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
	@ApiOperation(value="服务目录业务关联表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBBusiCatalogEntity>> list() {
		List<TBBusiCatalogEntity> listTBBusiCatalogs=tBBusiCatalogService.getList(TBBusiCatalogEntity.class);
		return Result.success(listTBBusiCatalogs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取服务目录业务关联表信息",notes="根据ID获取服务目录业务关联表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBBusiCatalogEntity task = tBBusiCatalogService.get(TBBusiCatalogEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取服务目录业务关联表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建服务目录业务关联表")
	public ResponseMessage<?> create(@ApiParam(name="服务目录业务关联表对象")@RequestBody TBBusiCatalogEntity tBBusiCatalog, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusiCatalogEntity>> failures = validator.validate(tBBusiCatalog);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusiCatalogService.save(tBBusiCatalog);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("服务目录业务关联表信息保存失败");
		}
		return Result.success(tBBusiCatalog);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新服务目录业务关联表",notes="更新服务目录业务关联表")
	public ResponseMessage<?> update(@ApiParam(name="服务目录业务关联表对象")@RequestBody TBBusiCatalogEntity tBBusiCatalog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusiCatalogEntity>> failures = validator.validate(tBBusiCatalog);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusiCatalogService.saveOrUpdate(tBBusiCatalog);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新服务目录业务关联表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新服务目录业务关联表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除服务目录业务关联表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBBusiCatalogService.deleteEntityById(TBBusiCatalogEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("服务目录业务关联表删除失败");
		}

		return Result.success();
	}
}
