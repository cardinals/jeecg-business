package com.sxctc.profit.controller;
import com.sxctc.profit.dao.TBProfitTargetDao;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import com.sxctc.profit.service.TBProfitTargetServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: 毛利润指标
 * @author onlineGenerator
 * @date 2018-08-24 15:53:30
 * @version V1.0   
 *
 */
@Api(value="TBProfitTarget",description="毛利润指标",tags="tBProfitTargetController")
@Controller
@RequestMapping("/tBProfitTargetController")
public class TBProfitTargetController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBProfitTargetController.class);

	@Autowired
	private TBProfitTargetServiceI tBProfitTargetService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private TBProfitTargetDao tbProfitTargetDao;



	/**
	 * 毛利润指标列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/profit/tBProfitTargetList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBProfitTargetEntity tBProfitTarget,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBProfitTargetEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBProfitTarget, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBProfitTargetService.getDataGridReturn(cq, true);

		/*
		 * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
		 */
		TSUser tsUser = ResourceUtil.getSessionUser();
		String orgCode = tsUser.getCurrentDepart().getOrgCode();
		String userName = tsUser.getUserName();
		String createBy = tBProfitTarget.getCreateBy();
		if (!"A04A01A01A01".equals(orgCode)) {
			userName = null;
		}
		if (StringUtils.isNotBlank(createBy)) {
			userName = createBy;
		}
		String sumContractValue = String.valueOf(tbProfitTargetDao.getSumContractValue(userName));
		String sumProfitTarget = String.valueOf(tbProfitTargetDao.getSumProfitTarget(userName));
		String sumConfirmIncome = String.valueOf(tbProfitTargetDao.getSumConfirmIncome(userName));
		dataGrid.setFooter("contractValue:"+(sumContractValue.equalsIgnoreCase("null")?"0.0":sumContractValue)+",profitTarget:"+(sumProfitTarget.equalsIgnoreCase("null")?"0.0":sumProfitTarget)+",confirmIncome:"+(sumConfirmIncome.equalsIgnoreCase("null")?"0.0":sumConfirmIncome)+",projectName:合计（万元）:");

		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除毛利润指标
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBProfitTargetEntity tBProfitTarget, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBProfitTarget = systemService.getEntity(TBProfitTargetEntity.class, tBProfitTarget.getId());
		message = "毛利润指标删除成功";
		try{
			//tBProfitTargetService.delete(tBProfitTarget);
			tBProfitTargetService.deleteProfitTarget(tBProfitTarget);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "毛利润指标删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除毛利润指标
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "毛利润指标删除成功";
		try{
			for(String id:ids.split(",")){
				TBProfitTargetEntity tBProfitTarget = systemService.getEntity(TBProfitTargetEntity.class, 
				id
				);
				tBProfitTargetService.delete(tBProfitTarget);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "毛利润指标删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加毛利润指标
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBProfitTargetEntity tBProfitTarget, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "毛利润指标添加成功";
		try{
			tBProfitTargetService.save(tBProfitTarget);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "毛利润指标添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新毛利润指标
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBProfitTargetEntity tBProfitTarget, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "毛利润指标更新成功";
		TBProfitTargetEntity t = tBProfitTargetService.get(TBProfitTargetEntity.class, tBProfitTarget.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBProfitTarget, t);
			tBProfitTargetService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "毛利润指标更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 毛利润指标新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBProfitTargetEntity tBProfitTarget, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBProfitTarget.getId())) {
			tBProfitTarget = tBProfitTargetService.getEntity(TBProfitTargetEntity.class, tBProfitTarget.getId());
			req.setAttribute("tBProfitTargetPage", tBProfitTarget);
		}
		return new ModelAndView("com/sxctc/profit/tBProfitTarget-add");
	}
	/**
	 * 毛利润指标编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBProfitTargetEntity tBProfitTarget, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBProfitTarget.getId())) {
			tBProfitTarget = tBProfitTargetService.getEntity(TBProfitTargetEntity.class, tBProfitTarget.getId());
			req.setAttribute("tBProfitTargetPage", tBProfitTarget);
		}
		return new ModelAndView("com/sxctc/profit/tBProfitTarget-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBProfitTargetController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBProfitTargetEntity tBProfitTarget,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBProfitTargetEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBProfitTarget, request.getParameterMap());
		List<TBProfitTargetEntity> tBProfitTargets = this.tBProfitTargetService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"毛利润指标");
		modelMap.put(NormalExcelConstants.CLASS,TBProfitTargetEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("毛利润指标列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBProfitTargets);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBProfitTargetEntity tBProfitTarget,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"毛利润指标");
    	modelMap.put(NormalExcelConstants.CLASS,TBProfitTargetEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("毛利润指标列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBProfitTargetEntity> listTBProfitTargetEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBProfitTargetEntity.class,params);
				for (TBProfitTargetEntity tBProfitTarget : listTBProfitTargetEntitys) {
					tBProfitTargetService.save(tBProfitTarget);
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
	@ApiOperation(value="毛利润指标列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBProfitTargetEntity>> list() {
		List<TBProfitTargetEntity> listTBProfitTargets=tBProfitTargetService.getList(TBProfitTargetEntity.class);
		return Result.success(listTBProfitTargets);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取毛利润指标信息",notes="根据ID获取毛利润指标信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBProfitTargetEntity task = tBProfitTargetService.get(TBProfitTargetEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取毛利润指标信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建毛利润指标")
	public ResponseMessage<?> create(@ApiParam(name="毛利润指标对象")@RequestBody TBProfitTargetEntity tBProfitTarget, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBProfitTargetEntity>> failures = validator.validate(tBProfitTarget);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBProfitTargetService.save(tBProfitTarget);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("毛利润指标信息保存失败");
		}
		return Result.success(tBProfitTarget);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新毛利润指标",notes="更新毛利润指标")
	public ResponseMessage<?> update(@ApiParam(name="毛利润指标对象")@RequestBody TBProfitTargetEntity tBProfitTarget) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBProfitTargetEntity>> failures = validator.validate(tBProfitTarget);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBProfitTargetService.saveOrUpdate(tBProfitTarget);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新毛利润指标信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新毛利润指标信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除毛利润指标")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBProfitTargetService.deleteEntityById(TBProfitTargetEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("毛利润指标删除失败");
		}

		return Result.success();
	}
}
