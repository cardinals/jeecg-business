package com.sxctc.business.service.impl;
import com.sxctc.business.service.TBBusinessServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.business.entity.TBBusinessEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
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

@Service("tBBusinessService")
@Transactional
public class TBBusinessServiceImpl extends CommonServiceImpl implements TBBusinessServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TBBusinessEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBBusinessEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBBusinessEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBBusinessEntity t) throws Exception{
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
	private void doUpdateBus(TBBusinessEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(TBBusinessEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBBusinessEntity t){
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
		map.put("bpm_status", t.getBpmStatus());
		map.put("unit_code", t.getUnitCode());
		map.put("unit_name", t.getUnitName());
		map.put("project_code", t.getProjectCode());
		map.put("project_name", t.getProjectName());
		map.put("project_status", t.getProjectStatus());
		map.put("cloud_status", t.getCloudStatus());
		map.put("chance_status", t.getChanceStatus());
		map.put("join_status", t.getJoinStatus());
		map.put("bus_create_time", t.getBusCreateTime());
		map.put("bus_join_time", t.getBusJoinTime());
		map.put("hard_serve_catalog", t.getHardServeCatalog());
		map.put("base_serve_catalog", t.getBaseServeCatalog());
		map.put("protocol_status", t.getProtocolStatus());
		map.put("protocol_time", t.getProtocolTime());
		map.put("audit_status", t.getAuditStatus());
		map.put("backup_field1", t.getBackupField1());
		map.put("backup_field2", t.getBackupField2());
		map.put("backup_field3", t.getBackupField3());
		map.put("backup_field4", t.getBackupField4());
		map.put("backup_field5", t.getBackupField5());
		map.put("backup_field6", t.getBackupField6());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBBusinessEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{unit_code}",String.valueOf(t.getUnitCode()));
 		sql  = sql.replace("#{unit_name}",String.valueOf(t.getUnitName()));
 		sql  = sql.replace("#{project_code}",String.valueOf(t.getProjectCode()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_status}",String.valueOf(t.getProjectStatus()));
 		sql  = sql.replace("#{cloud_status}",String.valueOf(t.getCloudStatus()));
 		sql  = sql.replace("#{chance_status}",String.valueOf(t.getChanceStatus()));
 		sql  = sql.replace("#{join_status}",String.valueOf(t.getJoinStatus()));
 		sql  = sql.replace("#{bus_create_time}",String.valueOf(t.getBusCreateTime()));
 		sql  = sql.replace("#{bus_join_time}",String.valueOf(t.getBusJoinTime()));
 		sql  = sql.replace("#{hard_serve_catalog}",String.valueOf(t.getHardServeCatalog()));
 		sql  = sql.replace("#{base_serve_catalog}",String.valueOf(t.getBaseServeCatalog()));
 		sql  = sql.replace("#{protocol_status}",String.valueOf(t.getProtocolStatus()));
 		sql  = sql.replace("#{protocol_time}",String.valueOf(t.getProtocolTime()));
 		sql  = sql.replace("#{audit_status}",String.valueOf(t.getAuditStatus()));
 		sql  = sql.replace("#{backup_field1}",String.valueOf(t.getBackupField1()));
 		sql  = sql.replace("#{backup_field2}",String.valueOf(t.getBackupField2()));
 		sql  = sql.replace("#{backup_field3}",String.valueOf(t.getBackupField3()));
 		sql  = sql.replace("#{backup_field4}",String.valueOf(t.getBackupField4()));
 		sql  = sql.replace("#{backup_field5}",String.valueOf(t.getBackupField5()));
 		sql  = sql.replace("#{backup_field6}",String.valueOf(t.getBackupField6()));
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
					javaInter.execute("t_b_business",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBBusinessEntity t){
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
}