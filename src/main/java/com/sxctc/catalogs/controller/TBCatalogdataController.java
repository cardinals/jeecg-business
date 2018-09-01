package com.sxctc.catalogs.controller;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.catalogs.entity.TBCatalogdataEntity;
import com.sxctc.catalogs.service.TBCatalogdataServiceI;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxctc.util.DateUtil;
import com.sxctc.util.FastJsonUtil;
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
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

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
 * @Description: 服务目录管理
 * @author onlineGenerator
 * @date 2018-08-08 10:45:17
 * @version V1.0   
 *
 */
@Api(value="TBCatalogdata",description="服务目录管理",tags="tBCatalogdataController")
@Controller
@RequestMapping("/tBCatalogdataController")
public class TBCatalogdataController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBCatalogdataController.class);

	@Autowired
	private TBCatalogdataServiceI tBCatalogdataService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 服务目录管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String type = request.getParameter("type");
		request.setAttribute("type",type);
		return new ModelAndView("com/sxctc/catalogs/tBCatalogdataList");
	}

	@RequestMapping(params = "tablist")
	public ModelAndView testlist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/catalogs/tBCatalogTab");
	}
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBCatalogdataEntity tBCatalogdata,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBCatalogdataEntity.class, dataGrid);
		String types = request.getParameter("catalogtype");
		if(StringUtil.isEmpty(tBCatalogdata.getId())){
			cq.isNull("fartherid");
		}else{
			cq.eq("fartherid", tBCatalogdata.getId());
			tBCatalogdata.setId(null);
		}
		cq.eq("type",types);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCatalogdata, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBCatalogdataService.getDataGridReturn(cq, true);
		TagUtil.treegrid(response, dataGrid);
	}
	
	/**
	 * 删除服务目录管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBCatalogdataEntity tBCatalogdata, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBCatalogdata = systemService.getEntity(TBCatalogdataEntity.class, tBCatalogdata.getId());
		message = "服务目录管理删除成功";
		try{
			tBCatalogdataService.delete(tBCatalogdata);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "服务目录管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除服务目录管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "服务目录管理删除成功";
		try{
			for(String id:ids.split(",")){
				TBCatalogdataEntity tBCatalogdata = systemService.getEntity(TBCatalogdataEntity.class, 
				id
				);
				tBCatalogdataService.delete(tBCatalogdata);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "服务目录管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加服务目录管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBCatalogdataEntity tBCatalogdata, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "服务目录管理添加成功";
		String type = tBCatalogdata.getType();
		String fartherid = tBCatalogdata.getFartherid();
		try{
			if(StringUtil.isEmpty(fartherid)){
				tBCatalogdata.setFartherid(null);
			}
			String catalogCode = tBCatalogdataService.makeCatalogCode(type, fartherid);
			tBCatalogdata.setCatalogCode(catalogCode);

			// 拼装节点类型 0根节点，1..2..
			if (StringUtils.isBlank(fartherid)) {
				tBCatalogdata.setNodeId(0); // 设置为根节点
			}else {
				String initFartherId = fartherid;
				int deep = 0;
				while (StringUtils.isNotBlank(initFartherId)) {
					// 计数
					deep ++;

					// 查询
					TBCatalogdataEntity fartherCatalog = tBCatalogdataService.get(TBCatalogdataEntity.class, initFartherId);
					if (fartherCatalog != null) {
						initFartherId = fartherCatalog.getFartherid();
					}
				}
				tBCatalogdata.setNodeId(deep);
			}

			// 按年份拼装数量
			String currentYear = DateUtil.getCurrentYear();
			JSONObject sumJson = new JSONObject();
			sumJson.put(currentYear,tBCatalogdata.getPrice());
			tBCatalogdata.setPriceJson(sumJson.toJSONString());


			tBCatalogdataService.save(tBCatalogdata);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "服务目录管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新服务目录管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBCatalogdataEntity tBCatalogdata, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "服务目录管理更新成功";
		TBCatalogdataEntity t = tBCatalogdataService.get(TBCatalogdataEntity.class, tBCatalogdata.getId());
		try {
			// 拼装节点编号
            String type = tBCatalogdata.getType();
            String fartherid = tBCatalogdata.getFartherid();
            if (StringUtils.isBlank(t.getCatalogCode())) {
				String catalogCode = tBCatalogdataService.makeCatalogCode(type, fartherid);
				t.setCatalogCode(catalogCode);
			}

			// 拼装节点类型 0根节点，1..2..
            if (StringUtils.isBlank(fartherid)) {
            	t.setNodeId(0); // 设置为根节点
			}else {
            	String initFartherId = fartherid;
            	int deep = 0;
            	while (StringUtils.isNotBlank(initFartherId)) {
            		// 计数
					deep ++;

					// 查询
					TBCatalogdataEntity fartherCatalog = tBCatalogdataService.get(TBCatalogdataEntity.class, initFartherId);
					if (fartherCatalog != null) {
						initFartherId = fartherCatalog.getFartherid();
					}
				}
				t.setNodeId(deep);
			}

            MyBeanUtils.copyBeanNotNull2Bean(tBCatalogdata, t);
			if(StringUtil.isEmpty(t.getFartherid())){
				t.setFartherid(null);
			}

			// 更新单价json
			String priceJson = t.getPriceJson();
			JSONObject jsonObject = JSONObject.parseObject(priceJson);
			String currentYear = DateUtil.getCurrentYear();
			if (FastJsonUtil.isEmpty(jsonObject)) {
                jsonObject = new JSONObject();
            }
			jsonObject.put(currentYear,tBCatalogdata.getPrice());
			t.setPriceJson(jsonObject.toJSONString());

			tBCatalogdataService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "服务目录管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 服务目录管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBCatalogdataEntity tBCatalogdata, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBCatalogdata.getId())) {
			tBCatalogdata = tBCatalogdataService.getEntity(TBCatalogdataEntity.class, tBCatalogdata.getId());
			req.setAttribute("tBCatalogdataPage", tBCatalogdata);
		}
		return new ModelAndView("com/sxctc/catalogs/tBCatalogdata-add");
	}
	/**
	 * 服务目录管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBCatalogdataEntity tBCatalogdata, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBCatalogdata.getId())) {
			tBCatalogdata = tBCatalogdataService.getEntity(TBCatalogdataEntity.class, tBCatalogdata.getId());
			req.setAttribute("tBCatalogdataPage", tBCatalogdata);
		}
		return new ModelAndView("com/sxctc/catalogs/tBCatalogdata-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBCatalogdataController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBCatalogdataEntity tBCatalogdata,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBCatalogdataEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCatalogdata, request.getParameterMap());
		List<TBCatalogdataEntity> tBCatalogdatas = this.tBCatalogdataService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"服务目录管理");
		modelMap.put(NormalExcelConstants.CLASS,TBCatalogdataEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("服务目录管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBCatalogdatas);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBCatalogdataEntity tBCatalogdata,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"服务目录管理");
    	modelMap.put(NormalExcelConstants.CLASS,TBCatalogdataEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("服务目录管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBCatalogdataEntity> listTBCatalogdataEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBCatalogdataEntity.class,params);
				for (TBCatalogdataEntity tBCatalogdata : listTBCatalogdataEntitys) {
					tBCatalogdataService.save(tBCatalogdata);
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
	@ApiOperation(value="服务目录管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBCatalogdataEntity>> list() {
		List<TBCatalogdataEntity> listTBCatalogdatas=tBCatalogdataService.getList(TBCatalogdataEntity.class);
		return Result.success(listTBCatalogdatas);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取服务目录管理信息",notes="根据ID获取服务目录管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBCatalogdataEntity task = tBCatalogdataService.get(TBCatalogdataEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取服务目录管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建服务目录管理")
	public ResponseMessage<?> create(@ApiParam(name="服务目录管理对象")@RequestBody TBCatalogdataEntity tBCatalogdata, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBCatalogdataEntity>> failures = validator.validate(tBCatalogdata);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBCatalogdataService.save(tBCatalogdata);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("服务目录管理信息保存失败");
		}
		return Result.success(tBCatalogdata);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新服务目录管理",notes="更新服务目录管理")
	public ResponseMessage<?> update(@ApiParam(name="服务目录管理对象")@RequestBody TBCatalogdataEntity tBCatalogdata) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBCatalogdataEntity>> failures = validator.validate(tBCatalogdata);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBCatalogdataService.saveOrUpdate(tBCatalogdata);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新服务目录管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新服务目录管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除服务目录管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBCatalogdataService.deleteEntityById(TBCatalogdataEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("服务目录管理删除失败");
		}

		return Result.success();
	}
}
