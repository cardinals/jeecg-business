package com.sxctc.finalform.service;
import com.sxctc.finalform.entity.TBFinalformExportEntity;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import java.io.Serializable;
import java.math.BigDecimal;

public interface TBFinalformExportServiceI extends CommonService{
	
 	public void delete(TBFinalformExportEntity entity) throws Exception;
 	
 	public Serializable save(TBFinalformExportEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBFinalformExportEntity entity) throws Exception;
 	
 	
	/**
	* @Title: 获取财务报表数据
	* @description: //TODO
	* @Param 
	* @Return 
	* @author: Dukaimin
	* @data:  
	**/
	public MiniDaoPage<TBFinalformExportEntity> tbFinalformExport(TBFinalformExportEntity tbFinalformExport, int page, int rows);

	/**
	 * @Title: getSumCloudInCome
	 * @description: 获取上云收入总和
	 * @Param
	 * @Return
	 * @author: Dukaimin
	 * @data:
	 **/
	public BigDecimal getSumCloudInCome() throws Exception;

	/**
	 * @Title: getSumProjectInCome
	 * @description: 获取项目收入总和
	 * @Param
	 * @Return
	 * @author: Dukaimin
	 * @data:
	 **/
	public BigDecimal getSumProjectInCome() throws Exception;
 	
}
