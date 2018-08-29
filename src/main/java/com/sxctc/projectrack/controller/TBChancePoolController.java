package com.sxctc.projectrack.controller;
import com.jeecg.demo.dao.JeecgMinidaoDao;
import com.sxctc.businessoppty.entity.TBBusinessOpptyEntity;
import com.sxctc.businessoppty.service.TBBusinessOpptyServiceI;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import com.sxctc.profit.service.TBProfitTargetServiceI;
import com.sxctc.projectrack.dao.TBChancePoolDao;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.projectrack.service.TBChancePoolServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: 项目机会池
 * @author onlineGenerator
 * @date 2018-08-23 16:20:22
 * @version V1.0   
 *
 */
@Api(value="TBChancePool",description="项目机会池",tags="tBChancePoolController")
@Controller
@RequestMapping("/tBChancePoolController")
public class TBChancePoolController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBChancePoolController.class);

	@Autowired
	private TBChancePoolServiceI tBChancePoolService;
	@Autowired
	private TBProfitTargetServiceI tBProfitTargetService;
	@Autowired
	private TBBusinessOpptyServiceI tBBusinessOpptyService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private TBChancePoolDao tbChancePoolDao;


	/**
	 * 项目机会池列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/sxctc/projectrack/tBChancePoolList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBChancePoolEntity tBChancePool,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBChancePoolEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBChancePool, request.getParameterMap());
		try{
			//自定义追加查询条件
			cq.notEq("winningResult",1);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBChancePoolService.getDataGridReturn(cq, true);

		/*
		 * 说明：格式为 字段名:值(可选，不写该值时为分页数据的合计) 多个合计 以 , 分割
		 */
		String userName = ResourceUtil.getSessionUser().getUserName();
		String sumProjectBudget = String.valueOf(tbChancePoolDao.getSumProjectBudget(userName));
		String sumProjectServer = String.valueOf(tbChancePoolDao.getSumProjectServer(userName));
		String sumProjectHardware = String.valueOf(tbChancePoolDao.getSumProjectHardware(userName));
		dataGrid.setFooter("projectBudget:"+(sumProjectBudget.equalsIgnoreCase("null")?"0.0":sumProjectBudget)+",projectServer:"+(sumProjectServer.equalsIgnoreCase("null")?"0.0":sumProjectServer)+",projectHardware:"+(sumProjectHardware.equalsIgnoreCase("null")?"0.0":sumProjectHardware)+",projectName:合计");

		TagUtil.datagrid(response, dataGrid);
	}

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "busiDatagrid")
    public void busiDatagrid(TBChancePoolEntity tBChancePool,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(TBChancePoolEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBChancePool, request.getParameterMap());
        try{
            //自定义追加查询条件
            cq.notEq("winningResult",1);
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.tBChancePoolService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

	/**
	 * 删除项目机会池
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBChancePoolEntity tBChancePool, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBChancePool = systemService.getEntity(TBChancePoolEntity.class, tBChancePool.getId());
		message = "项目机会池删除成功";
		try{
			tBChancePoolService.delete(tBChancePool);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目机会池删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除项目机会池
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目机会池删除成功";
		try{
			for(String id:ids.split(",")){
				TBChancePoolEntity tBChancePool = systemService.getEntity(TBChancePoolEntity.class, 
				id
				);
				tBChancePoolService.delete(tBChancePool);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目机会池删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目机会池
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBChancePoolEntity tBChancePool, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目机会池添加成功";
		try{
			tBChancePoolService.save(tBChancePool);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目机会池添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新项目机会池
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBChancePoolEntity tBChancePool, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目机会池更新成功";
		TBChancePoolEntity t = tBChancePoolService.get(TBChancePoolEntity.class, tBChancePool.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBChancePool, t);
			tBChancePoolService.saveOrUpdate(t);

			// 如果是已中标，则将数据添加到已签订项目中
			Integer winningResult = tBChancePool.getWinningResult();
			if (winningResult == 1) {
				// 将数据添加到已签订项目中
				TBProfitTargetEntity tbProfitTargetEntity = new TBProfitTargetEntity();
				tbProfitTargetEntity.setBusinessId(tBChancePool.getBusinessId());
				tbProfitTargetEntity.setProjectName(tBChancePool.getProjectName());
				tbProfitTargetEntity.setUnitCode(tBChancePool.getUnitCode());
				tBProfitTargetService.save(tbProfitTargetEntity);

				// 更新商机评估表将业务状态置为0
				List<TBBusinessOpptyEntity> byQueryString = tBBusinessOpptyService.findByQueryString("from TBBusinessOpptyEntity where businessId='" + t.getBusinessId() + "'");
				if (byQueryString.size() > 0) {
					for (TBBusinessOpptyEntity tbBusinessOpptyEntity : byQueryString) {
						tbBusinessOpptyEntity.setBusinessStatus(0);
						tBBusinessOpptyService.saveOrUpdate(tbBusinessOpptyEntity);

						String evaluateWin = tbBusinessOpptyEntity.getEvaluateWin();
						String evaluateFirst = tbBusinessOpptyEntity.getEvaluateFirst();
						String evaluateConfirm = tbBusinessOpptyEntity.getEvaluateConfirm();
						String hql = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and businessStatus=1";
						List<TBBusinessOpptyEntity> tBBusinessOpptyList = tBBusinessOpptyService.findHql(hql, evaluateWin, evaluateFirst, evaluateConfirm);
						if (tBBusinessOpptyList.size() == 0) {
							TBBusinessOpptyEntity tbBusinessOppty = new TBBusinessOpptyEntity();
							tbBusinessOppty.setBusinessStatus(1);
							tbBusinessOppty.setSortNum(tbBusinessOpptyEntity.getSortNum());
							tbBusinessOppty.setOpptyPoint(tbBusinessOpptyEntity.getOpptyPoint());
							tbBusinessOppty.setOpptyRatio(tbBusinessOpptyEntity.getOpptyRatio());
							tbBusinessOppty.setEvaluateConfirm(tbBusinessOpptyEntity.getEvaluateConfirm());
							tbBusinessOppty.setEvaluateFirst(tbBusinessOpptyEntity.getEvaluateFirst());
							tbBusinessOppty.setEvaluateWin(tbBusinessOpptyEntity.getEvaluateWin());
							tbBusinessOppty.setOpptyRange(tbBusinessOpptyEntity.getOpptyRange());

							tBBusinessOpptyService.save(tbBusinessOppty);

						}
					}
				}
			}

			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "项目机会池更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 项目机会池新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBChancePoolEntity tBChancePool, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBChancePool.getId())) {
			tBChancePool = tBChancePoolService.getEntity(TBChancePoolEntity.class, tBChancePool.getId());
			req.setAttribute("tBChancePoolPage", tBChancePool);
		}
		return new ModelAndView("com/sxctc/projectrack/tBChancePool-add");
	}
	/**
	 * 项目机会池编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBChancePoolEntity tBChancePool, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBChancePool.getId())) {
			tBChancePool = tBChancePoolService.getEntity(TBChancePoolEntity.class, tBChancePool.getId());
			req.setAttribute("tBChancePoolPage", tBChancePool);
		}
		return new ModelAndView("com/sxctc/projectrack/tBChancePool-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBChancePoolController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBChancePoolEntity tBChancePool,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBChancePoolEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBChancePool, request.getParameterMap());
		List<TBChancePoolEntity> tBChancePools = this.tBChancePoolService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"项目机会池");
		modelMap.put(NormalExcelConstants.CLASS,TBChancePoolEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目机会池列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBChancePools);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBChancePoolEntity tBChancePool,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"项目机会池");
    	modelMap.put(NormalExcelConstants.CLASS,TBChancePoolEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目机会池列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBChancePoolEntity> listTBChancePoolEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBChancePoolEntity.class,params);
				for (TBChancePoolEntity tBChancePool : listTBChancePoolEntitys) {
					tBChancePoolService.save(tBChancePool);
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
	@ApiOperation(value="项目机会池列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBChancePoolEntity>> list() {
		List<TBChancePoolEntity> listTBChancePools=tBChancePoolService.getList(TBChancePoolEntity.class);
		return Result.success(listTBChancePools);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取项目机会池信息",notes="根据ID获取项目机会池信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBChancePoolEntity task = tBChancePoolService.get(TBChancePoolEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取项目机会池信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建项目机会池")
	public ResponseMessage<?> create(@ApiParam(name="项目机会池对象")@RequestBody TBChancePoolEntity tBChancePool, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBChancePoolEntity>> failures = validator.validate(tBChancePool);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBChancePoolService.save(tBChancePool);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("项目机会池信息保存失败");
		}
		return Result.success(tBChancePool);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新项目机会池",notes="更新项目机会池")
	public ResponseMessage<?> update(@ApiParam(name="项目机会池对象")@RequestBody TBChancePoolEntity tBChancePool) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBChancePoolEntity>> failures = validator.validate(tBChancePool);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBChancePoolService.saveOrUpdate(tBChancePool);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新项目机会池信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新项目机会池信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除项目机会池")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBChancePoolService.deleteEntityById(TBChancePoolEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("项目机会池删除失败");
		}

		return Result.success();
	}
}
