package com.sxctc.businessoppty.controller;
import com.sxctc.businessoppty.entity.TBBusinessOpptyEntity;
import com.sxctc.businessoppty.service.TBBusinessOpptyServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxctc.projectrack.entity.TBChancePoolEntity;
import io.swagger.models.auth.In;
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
 * @Description: 商机评估
 * @author onlineGenerator
 * @date 2018-08-25 10:24:32
 * @version V1.0   
 *
 */
@Api(value="TBBusinessOppty",description="商机评估",tags="tBBusinessOpptyController")
@Controller
@RequestMapping("/tBBusinessOpptyController")
public class TBBusinessOpptyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBBusinessOpptyController.class);

	@Autowired
	private TBBusinessOpptyServiceI tBBusinessOpptyService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 商机评估列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "mainlist")
	public ModelAndView mainlist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/businessoppty/tBBusinessOpptyMainList");
	}

	/**
	 * 商机评估列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "chancelist")
	public ModelAndView chancelist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/businessoppty/tBBusiChancePoolList");
	}

	/**
	 * 商机评估列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/businessoppty/tBBusinessOpptyList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBBusinessOpptyEntity tBBusinessOppty,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBBusinessOpptyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusinessOppty, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.eq("businessStatus",1);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBBusinessOpptyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除商机评估
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBBusinessOpptyEntity tBBusinessOppty, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBBusinessOppty = systemService.getEntity(TBBusinessOpptyEntity.class, tBBusinessOppty.getId());
		message = "商机评估删除成功";
		try{
			//tBBusinessOpptyService.delete(tBBusinessOppty);
			tBBusinessOpptyService.deleteBusinessOppty(tBBusinessOppty);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "商机评估删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除商机评估
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商机评估删除成功";
		try{
			for(String id:ids.split(",")){
				TBBusinessOpptyEntity tBBusinessOppty = systemService.getEntity(TBBusinessOpptyEntity.class, 
				id
				);
				tBBusinessOpptyService.delete(tBBusinessOppty);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "商机评估删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加商机评估
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBBusinessOpptyEntity tBBusinessOppty, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商机评估添加成功";
		try{
			// 获取机会池id
			String chancePoolId = tBBusinessOppty.getId();
			String evaluateWin = tBBusinessOppty.getEvaluateWin();
			String evaluateFirst = tBBusinessOppty.getEvaluateFirst();
			String evaluateConfirm = tBBusinessOppty.getEvaluateConfirm();

			// 查询机会池业务
			TBChancePoolEntity tBChancePool = tBBusinessOpptyService.getEntity(TBChancePoolEntity.class, chancePoolId);
			String businessId = tBChancePool.getBusinessId();
			String projectName = tBChancePool.getProjectName();
			Integer unitCode = tBChancePool.getUnitCode();

			// 重新构建实体并保存
			tBBusinessOppty = new TBBusinessOpptyEntity();
			tBBusinessOppty.setBusinessId(businessId);
			tBBusinessOppty.setUnitCode(unitCode);
			tBBusinessOppty.setProjectName(projectName);

			// 判断得出业务参数
			if (StringUtils.isNotBlank(evaluateWin) && StringUtils.isNotBlank(evaluateFirst) && StringUtils.isNotBlank(evaluateConfirm)) {
				int win = Integer.parseInt(evaluateWin);
				int first = Integer.parseInt(evaluateFirst);
				int confirm = Integer.parseInt(evaluateConfirm);

				// 执行业务
				tBBusinessOpptyService.evaluate(tBBusinessOppty,win,first,confirm);
			}


			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "商机评估添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新商机评估
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBBusinessOpptyEntity tBBusinessOppty, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商机评估更新成功";
		TBBusinessOpptyEntity t = tBBusinessOpptyService.get(TBBusinessOpptyEntity.class, tBBusinessOppty.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBBusinessOppty, t);
			tBBusinessOpptyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "商机评估更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 商机评估新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBBusinessOpptyEntity tBBusinessOppty, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusinessOppty.getId())) {
			//tBBusinessOppty = tBBusinessOpptyService.getEntity(TBBusinessOpptyEntity.class, tBBusinessOppty.getId());
			TBChancePoolEntity tBChancePoolEntity = tBBusinessOpptyService.getEntity(TBChancePoolEntity.class, tBBusinessOppty.getId());
			req.setAttribute("tBBusinessOpptyPage", tBChancePoolEntity);
		}
		return new ModelAndView("com/sxctc/businessoppty/tBBusinessOppty-add");
	}
	/**
	 * 商机评估编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBBusinessOpptyEntity tBBusinessOppty, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusinessOppty.getId())) {
			tBBusinessOppty = tBBusinessOpptyService.getEntity(TBBusinessOpptyEntity.class, tBBusinessOppty.getId());
			req.setAttribute("tBBusinessOpptyPage", tBBusinessOppty);
		}
		return new ModelAndView("com/sxctc/businessoppty/tBBusinessOppty-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBBusinessOpptyController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBBusinessOpptyEntity tBBusinessOppty,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBBusinessOpptyEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusinessOppty, request.getParameterMap());
		List<TBBusinessOpptyEntity> tBBusinessOpptys = this.tBBusinessOpptyService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"商机评估");
		modelMap.put(NormalExcelConstants.CLASS,TBBusinessOpptyEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("商机评估列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBBusinessOpptys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBBusinessOpptyEntity tBBusinessOppty,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"商机评估");
    	modelMap.put(NormalExcelConstants.CLASS,TBBusinessOpptyEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("商机评估列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBBusinessOpptyEntity> listTBBusinessOpptyEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBBusinessOpptyEntity.class,params);
				for (TBBusinessOpptyEntity tBBusinessOppty : listTBBusinessOpptyEntitys) {
					tBBusinessOpptyService.save(tBBusinessOppty);
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
	@ApiOperation(value="商机评估列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBBusinessOpptyEntity>> list() {
		List<TBBusinessOpptyEntity> listTBBusinessOpptys=tBBusinessOpptyService.getList(TBBusinessOpptyEntity.class);
		return Result.success(listTBBusinessOpptys);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取商机评估信息",notes="根据ID获取商机评估信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBBusinessOpptyEntity task = tBBusinessOpptyService.get(TBBusinessOpptyEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取商机评估信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建商机评估")
	public ResponseMessage<?> create(@ApiParam(name="商机评估对象")@RequestBody TBBusinessOpptyEntity tBBusinessOppty, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusinessOpptyEntity>> failures = validator.validate(tBBusinessOppty);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusinessOpptyService.save(tBBusinessOppty);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("商机评估信息保存失败");
		}
		return Result.success(tBBusinessOppty);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新商机评估",notes="更新商机评估")
	public ResponseMessage<?> update(@ApiParam(name="商机评估对象")@RequestBody TBBusinessOpptyEntity tBBusinessOppty) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusinessOpptyEntity>> failures = validator.validate(tBBusinessOppty);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBBusinessOpptyService.saveOrUpdate(tBBusinessOppty);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新商机评估信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新商机评估信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除商机评估")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBBusinessOpptyService.deleteEntityById(TBBusinessOpptyEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("商机评估删除失败");
		}

		return Result.success();
	}
}
