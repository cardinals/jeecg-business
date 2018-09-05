package com.sxctc.finalform.controller;
import com.sxctc.business.entity.TBBusiCatalogEntity;
import com.sxctc.catalogs.entity.TBCatalogdataEntity;
import com.sxctc.finalform.entity.TBFinalformExportEntity;
import com.sxctc.finalform.service.TBFinalformExportServiceI;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxctc.profit.entity.TBProfitTargetEntity;
import org.apache.log4j.Logger;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
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
 * @Description: 财务报表导出
 * @author onlineGenerator
 * @date 2018-08-31 11:17:58
 * @version V1.0
 *
 */
@Api(value="TBFinalformExport",description="财务报表导出",tags="tBFinalformExportController")
@Controller
@RequestMapping("/tBFinalformExportController")
public class TBFinalformExportController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBFinalformExportController.class);

	@Autowired
	private TBFinalformExportServiceI tBFinalformExportService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	/**
	 * 财务报表导出列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/finalform/tBFinalformExportList");
	}

	/**
	 * easyui AJAX请求数据
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBFinalformExportEntity tbFinalformExport,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<TBFinalformExportEntity> miniDaoPage = tBFinalformExportService.tbFinalformExport(tbFinalformExport, dataGrid.getPage(), dataGrid.getRows());
		List<TBFinalformExportEntity> finalformList = miniDaoPage.getResults();

		dataGrid.setTotal(miniDaoPage.getTotal());
		dataGrid.setResults(finalformList);

		// 遍历查询结果，组装统计字段
		List<TBFinalformExportEntity> results = dataGrid.getResults();
		if (results.size() == 0) {
			TagUtil.datagrid(response, dataGrid);
			return;
		}

		// 遍历
		for (TBFinalformExportEntity result : results) {
			String businessId = result.getBusinessId();

			String hql = "from TBProfitTargetEntity where businessId =?";
			List<TBProfitTargetEntity> profitTargetList = this.tBFinalformExportService.findHql(hql,businessId);
			if (profitTargetList.size() > 0) {
				// 进行数据状态
				for (TBProfitTargetEntity tbProfitTargetEntity : profitTargetList) {
					BigDecimal confirmIncome = tbProfitTargetEntity.getConfirmIncome();
					if (confirmIncome != null) {
						result.setProjectCount(confirmIncome.toString());
					}else {
						result.setProjectCount("0");
					}
				}
			}else{
				result.setProjectCount("0");
			}
			result.setCloudCount("0");

			// 计算总合计收入
			String cloudCount = result.getCloudCount();
			String projectCount = result.getProjectCount();
			BigDecimal bg1 = new BigDecimal(cloudCount);
			BigDecimal bg2 = new BigDecimal(projectCount);

			result.setTotalCount(bg1.add(bg2).toString());
		}

		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除财务报表导出
	 *
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBFinalformExportEntity tBFinalformExport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBFinalformExport = systemService.getEntity(TBFinalformExportEntity.class, tBFinalformExport.getId());
		message = "财务报表导出删除成功";
		try{
			tBFinalformExportService.delete(tBFinalformExport);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "财务报表导出删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除财务报表导出
	 *
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "财务报表导出删除成功";
		try{
			for(String id:ids.split(",")){
				TBFinalformExportEntity tBFinalformExport = systemService.getEntity(TBFinalformExportEntity.class,
						id
				);
				tBFinalformExportService.delete(tBFinalformExport);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "财务报表导出删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加财务报表导出
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBFinalformExportEntity tBFinalformExport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "财务报表导出添加成功";
		try{
			tBFinalformExportService.save(tBFinalformExport);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "财务报表导出添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新财务报表导出
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBFinalformExportEntity tBFinalformExport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "财务报表导出更新成功";
		TBFinalformExportEntity t = tBFinalformExportService.get(TBFinalformExportEntity.class, tBFinalformExport.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBFinalformExport, t);
			tBFinalformExportService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "财务报表导出更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 财务报表导出新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBFinalformExportEntity tBFinalformExport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBFinalformExport.getId())) {
			tBFinalformExport = tBFinalformExportService.getEntity(TBFinalformExportEntity.class, tBFinalformExport.getId());
			req.setAttribute("tBFinalformExportPage", tBFinalformExport);
		}
		return new ModelAndView("com/sxctc/finalform/tBFinalformExport-add");
	}
	/**
	 * 财务报表导出编辑页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBFinalformExportEntity tBFinalformExport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBFinalformExport.getId())) {
			tBFinalformExport = tBFinalformExportService.getEntity(TBFinalformExportEntity.class, tBFinalformExport.getId());
			req.setAttribute("tBFinalformExportPage", tBFinalformExport);
		}
		return new ModelAndView("com/sxctc/finalform/tBFinalformExport-update");
	}

	/**
	 * 导入功能跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBFinalformExportController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBFinalformExportEntity tBFinalformExport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
//		CriteriaQuery cq = new CriteriaQuery(TBFinalformExportEntity.class, dataGrid);
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBFinalformExport, request.getParameterMap());
//		List<TBFinalformExportEntity> tBFinalformExports = this.tBFinalformExportService.getListByCriteriaQuery(cq,false);

		MiniDaoPage<TBFinalformExportEntity> miniDaoPage = tBFinalformExportService.tbFinalformExport(tBFinalformExport, dataGrid.getPage(), dataGrid.getRows());
		List<TBFinalformExportEntity> finalformList = miniDaoPage.getResults();

		dataGrid.setTotal(miniDaoPage.getTotal());
		dataGrid.setResults(finalformList);

		// 遍历查询结果，组装统计字段
		List<TBFinalformExportEntity> results = dataGrid.getResults();

		// 遍历
		for (TBFinalformExportEntity result : results) {
			String businessId = result.getBusinessId();

			String hql = "from TBProfitTargetEntity where businessId =?";
			List<TBProfitTargetEntity> profitTargetList = this.tBFinalformExportService.findHql(hql,businessId);
			if (profitTargetList.size() > 0) {
				// 进行数据状态
				for (TBProfitTargetEntity tbProfitTargetEntity : profitTargetList) {
					BigDecimal confirmIncome = tbProfitTargetEntity.getConfirmIncome();
					if (confirmIncome != null) {
						result.setProjectCount(confirmIncome.toString());
					}else {
						result.setProjectCount("0");
					}
				}
			}else{
				result.setProjectCount("0");
			}
			result.setCloudCount("0");

			// 计算总合计收入
			String cloudCount = result.getCloudCount();
			String projectCount = result.getProjectCount();
			BigDecimal bg1 = new BigDecimal(cloudCount);
			BigDecimal bg2 = new BigDecimal(projectCount);

			result.setTotalCount(bg1.add(bg2).toString());
		}


		modelMap.put(NormalExcelConstants.FILE_NAME,"财务报表导出");
		modelMap.put(NormalExcelConstants.CLASS,TBFinalformExportEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("财务报表导出列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
				"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,results);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBFinalformExportEntity tBFinalformExport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(NormalExcelConstants.FILE_NAME,"财务报表导出");
		modelMap.put(NormalExcelConstants.CLASS,TBFinalformExportEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("财务报表导出列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBFinalformExportEntity> listTBFinalformExportEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBFinalformExportEntity.class,params);
				for (TBFinalformExportEntity tBFinalformExport : listTBFinalformExportEntitys) {
					tBFinalformExportService.save(tBFinalformExport);
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
	@ApiOperation(value="财务报表导出列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBFinalformExportEntity>> list() {
		List<TBFinalformExportEntity> listTBFinalformExports=tBFinalformExportService.getList(TBFinalformExportEntity.class);
		return Result.success(listTBFinalformExports);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取财务报表导出信息",notes="根据ID获取财务报表导出信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBFinalformExportEntity task = tBFinalformExportService.get(TBFinalformExportEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取财务报表导出信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建财务报表导出")
	public ResponseMessage<?> create(@ApiParam(name="财务报表导出对象")@RequestBody TBFinalformExportEntity tBFinalformExport, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBFinalformExportEntity>> failures = validator.validate(tBFinalformExport);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBFinalformExportService.save(tBFinalformExport);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("财务报表导出信息保存失败");
		}
		return Result.success(tBFinalformExport);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新财务报表导出",notes="更新财务报表导出")
	public ResponseMessage<?> update(@ApiParam(name="财务报表导出对象")@RequestBody TBFinalformExportEntity tBFinalformExport) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBFinalformExportEntity>> failures = validator.validate(tBFinalformExport);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBFinalformExportService.saveOrUpdate(tBFinalformExport);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新财务报表导出信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新财务报表导出信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除财务报表导出")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBFinalformExportService.deleteEntityById(TBFinalformExportEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("财务报表导出删除失败");
		}

		return Result.success();
	}
}
