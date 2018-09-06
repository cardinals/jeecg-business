package com.sxctc.workreport.controller;

import com.alibaba.fastjson.JSONArray;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.service.TBBusiWorkreportServiceI;
import com.sxctc.workreport.service.TBWorkreportdayServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: 日报报表
 * @author onlineGenerator
 * @date 2018-08-08 14:29:12
 * @version V1.0   
 *
 */
@Api(value="TBReportSearch",description="日报报表",tags="tBReportSearchController")
@Controller
@RequestMapping("/tBReportSearchController")
public class TBReportSearchController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBReportSearchController.class);

	@Autowired
	private TBWorkreportdayServiceI tBWorkreportdayService;
	@Autowired
	private TBBusiWorkreportServiceI tBBusiWorkreportService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 日报管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tablist")
	public ModelAndView tablist(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/workreport/tBReportSearchTab");
	}

	/**
	 * 日报管理列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String toolFlag = request.getParameter("toolFlag");
		request.setAttribute("toolFlag",toolFlag);
		return new ModelAndView("com/sxctc/workreport/tBReportSearchList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBWorkreportdayEntity tBWorkreportday,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBWorkreportdayEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBWorkreportday, request.getParameterMap());
		try{
			//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBWorkreportdayService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除日报管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBWorkreportdayEntity tBWorkreportday, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBWorkreportday = systemService.getEntity(TBWorkreportdayEntity.class, tBWorkreportday.getId());
		message = "日报管理删除成功";
		try{
			tBWorkreportdayService.delete(tBWorkreportday);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "日报管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除日报管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "日报管理删除成功";
		try{
			for(String id:ids.split(",")){
				TBWorkreportdayEntity tBWorkreportday = systemService.getEntity(TBWorkreportdayEntity.class, 
				id
				);
				tBWorkreportdayService.delete(tBWorkreportday);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "日报管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加日报管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBWorkreportdayEntity tBWorkreportday, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "日报管理添加成功";
		try{
			tBWorkreportdayService.save(tBWorkreportday);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "日报管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新日报管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBWorkreportdayEntity tBWorkreportday, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "日报管理更新成功";
		TBWorkreportdayEntity t = tBWorkreportdayService.get(TBWorkreportdayEntity.class, tBWorkreportday.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBWorkreportday, t);
			tBWorkreportdayService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "日报管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 日报管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBWorkreportdayEntity tBWorkreportday, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBWorkreportday.getId())) {
			tBWorkreportday = tBWorkreportdayService.getEntity(TBWorkreportdayEntity.class, tBWorkreportday.getId());
			req.setAttribute("tBWorkreportdayPage", tBWorkreportday);
		}
		return new ModelAndView("com/sxctc/workreport/tBWorkreportday-add");
	}
	/**
	 * 日报管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBWorkreportdayEntity tBWorkreportday, HttpServletRequest req, String toolFlag) {
		if (StringUtil.isNotEmpty(tBWorkreportday.getId())) {
			String id = tBWorkreportday.getId();
			// 去t_b_busi_workreport表查询回填信息
			tBWorkreportday = tBBusiWorkreportService.getEntity(TBWorkreportdayEntity.class, id);
			req.setAttribute("tBWorkreportdayPage", tBWorkreportday);
			req.setAttribute("toolFlag", toolFlag);
		}
		return new ModelAndView("com/sxctc/workreport/tBWorkreportday-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBWorkreportdayController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBWorkreportdayEntity tBWorkreportday,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBWorkreportdayEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBWorkreportday, request.getParameterMap());
		List<TBWorkreportdayEntity> tBWorkreportdays = this.tBWorkreportdayService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"日报管理");
		modelMap.put(NormalExcelConstants.CLASS,TBWorkreportdayEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("日报管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBWorkreportdays);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBWorkreportdayEntity tBWorkreportday,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"日报管理");
    	modelMap.put(NormalExcelConstants.CLASS,TBWorkreportdayEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("日报管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBWorkreportdayEntity> listTBWorkreportdayEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBWorkreportdayEntity.class,params);
				for (TBWorkreportdayEntity tBWorkreportday : listTBWorkreportdayEntitys) {
					tBWorkreportdayService.save(tBWorkreportday);
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
	@ApiOperation(value="日报管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBWorkreportdayEntity>> list() {
		List<TBWorkreportdayEntity> listTBWorkreportdays=tBWorkreportdayService.getList(TBWorkreportdayEntity.class);
		return Result.success(listTBWorkreportdays);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取日报管理信息",notes="根据ID获取日报管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBWorkreportdayEntity task = tBWorkreportdayService.get(TBWorkreportdayEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取日报管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建日报管理")
	public ResponseMessage<?> create(@ApiParam(name="日报管理对象")@RequestBody TBWorkreportdayEntity tBWorkreportday, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBWorkreportdayEntity>> failures = validator.validate(tBWorkreportday);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBWorkreportdayService.save(tBWorkreportday);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("日报管理信息保存失败");
		}
		return Result.success(tBWorkreportday);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新日报管理",notes="更新日报管理")
	public ResponseMessage<?> update(@ApiParam(name="日报管理对象")@RequestBody TBWorkreportdayEntity tBWorkreportday) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBWorkreportdayEntity>> failures = validator.validate(tBWorkreportday);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBWorkreportdayService.saveOrUpdate(tBWorkreportday);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新日报管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新日报管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除日报管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBWorkreportdayService.deleteEntityById(TBWorkreportdayEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("日报管理删除失败");
		}

		return Result.success();
	}
}
