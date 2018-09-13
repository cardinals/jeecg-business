package com.sxctc.finalform.service.impl;
import com.sxctc.finalform.dao.TBFinalformExportDao;
import com.sxctc.finalform.service.TBFinalformExportServiceI;
import com.sxctc.finalform.vo.CloudInComeVo;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.finalform.entity.TBFinalformExportEntity;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("tBFinalformExportService")
@Transactional
public class TBFinalformExportServiceImpl extends CommonServiceImpl implements TBFinalformExportServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private TBFinalformExportDao tBFinalformExportDao;
	
 	public void delete(TBFinalformExportEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBFinalformExportEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBFinalformExportEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}

	@Override
	public MiniDaoPage<TBFinalformExportEntity> tbFinalformExport(TBFinalformExportEntity tbFinalformExport, int page, int rows) {
		return tBFinalformExportDao.tbFinalformExport(page,rows);
	}

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBFinalformExportEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(TBFinalformExportEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(TBFinalformExportEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------

	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBFinalformExportEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("unit_code", t.getUnitCode());
		map.put("system_name", t.getSystemName());
		map.put("cloud_count", t.getCloudCount());
		map.put("project_count", t.getProjectCount());
		map.put("total_coiunt", t.getTotalCount());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBFinalformExportEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{unit_code}",String.valueOf(t.getUnitCode()));
 		sql  = sql.replace("#{system_name}",String.valueOf(t.getSystemName()));
 		sql  = sql.replace("#{cloud_count}",String.valueOf(t.getCloudCount()));
 		sql  = sql.replace("#{project_count}",String.valueOf(t.getProjectCount()));
 		sql  = sql.replace("#{total_coiunt}",String.valueOf(t.getTotalCount()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("t_b_finalform_export",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBFinalformExportEntity t){
	 	Map<String,Object> data = populationMap(t);
	 	sqlEnhance = ResourceUtil.formateSQl(sqlEnhance, data);
	 	boolean isMiniDao = false;
	 	try {
	 		data = ResourceUtil.minidaoReplaceExtendSqlSysVar(data);
	 		sqlEnhance = FreemarkerParseFactory.parseTemplateContent(sqlEnhance, data);
			isMiniDao = true;
		} catch (Exception e) {
		}
	 	String [] sqls = sqlEnhance.split(";");
		for(String sql:sqls){
			if(sql == null || sql.toLowerCase().trim().equals("")){
				continue;
			}
			int num = 0;
			if(isMiniDao){
				num = namedParameterJdbcTemplate.update(sql, data);
			}else{
				num = this.executeSql(sql);
			}
		}
 	}

	/**
	 * @Title: getSumCloudInCome
	 * @description: 获取上云收入总和
	 * @Param
	 * @Return
	 * @author: Dukaimin
	 * @data:
	 **/
	public BigDecimal getSumCloudInCome() throws Exception {
		List<CloudInComeVo> sumCloudInCome = tBFinalformExportDao.getSumCloudInCome();
		BigDecimal total = new BigDecimal(0);
		if (sumCloudInCome.size() > 0) {
			for (CloudInComeVo cloudInComeVo : sumCloudInCome) {
				Integer checkNum = cloudInComeVo.getCheckNum();
				BigDecimal price = cloudInComeVo.getPrice();
				if (checkNum != null && price != null) {
					total = total.add(price.multiply(new BigDecimal(checkNum)));
				}
			}
		}
		return total;
	}

	/**
	 * @Title: getSumProjectInCome
	 * @description: 获取项目收入总和
	 * @Param
	 * @Return
	 * @author: Dukaimin
	 * @data:
	 **/
	public BigDecimal getSumProjectInCome() throws Exception {
		List<TBProfitTargetEntity> sumProjectInCome = tBFinalformExportDao.getSumProjectInCome();
		BigDecimal total = new BigDecimal(0);
		if (sumProjectInCome.size() > 0) {
			for (TBProfitTargetEntity tbProfitTargetEntity : sumProjectInCome) {
				BigDecimal confirmIncome = tbProfitTargetEntity.getConfirmIncome();
				if (confirmIncome != null) {
					total = total.add(confirmIncome);
				}
			}
		}
		return total;
	}
}