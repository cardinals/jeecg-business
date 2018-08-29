package com.sxctc.unitManage.service.impl;
import com.sxctc.unitManage.service.TBUnitManageServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.unitManage.entity.TBUnitManageEntity;
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

@Service("tBUnitManageService")
@Transactional
public class TBUnitManageServiceImpl extends CommonServiceImpl implements TBUnitManageServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TBUnitManageEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBUnitManageEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBUnitManageEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBUnitManageEntity t) throws Exception{
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
	private void doUpdateBus(TBUnitManageEntity t) throws Exception{
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
	private void doDelBus(TBUnitManageEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBUnitManageEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("user_code", t.getUserCode());
		map.put("unit_code", t.getUnitCode());
		map.put("unit_name", t.getUnitName());
		map.put("user_name", t.getUserName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBUnitManageEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_code}",String.valueOf(t.getUserCode()));
 		sql  = sql.replace("#{unit_code}",String.valueOf(t.getUnitCode()));
 		sql  = sql.replace("#{unit_name}",String.valueOf(t.getUnitName()));
 		sql  = sql.replace("#{user_name}",String.valueOf(t.getUserName()));
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
					javaInter.execute("t_b_unit_manage",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBUnitManageEntity t){
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