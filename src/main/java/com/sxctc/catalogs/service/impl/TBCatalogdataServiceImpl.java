package com.sxctc.catalogs.service.impl;
import com.sxctc.catalogs.service.TBCatalogdataServiceI;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.catalogs.entity.TBCatalogdataEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("tBCatalogdataService")
@Transactional
public class TBCatalogdataServiceImpl extends CommonServiceImpl implements TBCatalogdataServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TBCatalogdataEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBCatalogdataEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBCatalogdataEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBCatalogdataEntity t) throws Exception{
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
	private void doUpdateBus(TBCatalogdataEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(TBCatalogdataEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBCatalogdataEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("name", t.getName());
		map.put("danwei", t.getDanwei());
		map.put("fartherid", t.getFartherid());
		map.put("num", t.getNum());
		map.put("beizhu", t.getBeizhu());
		map.put("type", t.getType());
		map.put("price", t.getPrice());
		map.put("price_json", t.getPriceJson());
		map.put("status", t.getStatus());
		map.put("catalog_code", t.getCatalogCode());
		map.put("node_id", t.getNodeId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBCatalogdataEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{danwei}",String.valueOf(t.getDanwei()));
 		sql  = sql.replace("#{fartherid}",String.valueOf(t.getFartherid()));
 		sql  = sql.replace("#{num}",String.valueOf(t.getNum()));
 		sql  = sql.replace("#{beizhu}",String.valueOf(t.getBeizhu()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{price_json}",String.valueOf(t.getPriceJson()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{catalog_code}",String.valueOf(t.getCatalogCode()));
 		sql  = sql.replace("#{node_id}",String.valueOf(t.getNodeId()));
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
					javaInter.execute("t_b_catalogdata",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBCatalogdataEntity t){
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
	 * @Title makeCatalogCode
	 * @Description 生成服务目录编号
	 * @Param [entity]
	 * @Return java.lang.String
	 * @Author liuzc
	 * @Date 2018/8/31 下午5:57
	 **/
	public String makeCatalogCode(String type, String fartherid) throws Exception {
		int nextCode = 0;
		String prefix = "";
		if ("01".equals(type)) {prefix = "IAAS-";}
		if ("02".equals(type)) {prefix = "PAAS-";}
		if ("03".equals(type)) {prefix = "SAAS-";}
		if ("04".equals(type)) {prefix = "DAAS-";}

		List<TBCatalogdataEntity> tBCatalogList = new ArrayList<TBCatalogdataEntity>();
		if(StringUtil.isEmpty(fartherid)){
			// 获取父节点编号
			tBCatalogList = this.findByQueryString("from TBCatalogdataEntity where fartherid is null and type='" + type + "' order by catalogCode desc");
		}else {
			// 获取父节点编号
			tBCatalogList = this.findByQueryString("from TBCatalogdataEntity where fartherid='" + fartherid + "' and type='" + type + "' order by catalogCode desc");
		}

		if (tBCatalogList.size() > 0) {
			TBCatalogdataEntity tbCatalogdataEntity = tBCatalogList.get(0);
			String catalogCode = tbCatalogdataEntity.getCatalogCode();
			if (StringUtils.isNotBlank(catalogCode)) {
				String code = catalogCode.substring(catalogCode.length()-3,catalogCode.length());
				nextCode = Integer.parseInt(code);
				String strCode = String.format("%0" + 3 + "d", (nextCode+1));
				if (StringUtil.isEmpty(fartherid)) {
					return prefix + strCode;
				}else {
					return catalogCode.substring(0,catalogCode.length()-4) + "-" + strCode;
				}
			}else {
				List<TBCatalogdataEntity> tBCatalogList1 = this.findByQueryString("from TBCatalogdataEntity where id='" + fartherid + "' and type='" + type + "'");
				if (tBCatalogList1.size() == 1) {
					TBCatalogdataEntity tbCatalogdataEntity1 = tBCatalogList1.get(0);
					catalogCode = tbCatalogdataEntity1.getCatalogCode();
				}
				String strCode = String.format("%0" + 3 + "d", (nextCode+1));
				if (StringUtil.isEmpty(fartherid)) {
					return prefix + strCode;
				}else {
					return catalogCode + "-" + strCode;
				}
			}

		}else {
			tBCatalogList = this.findByQueryString("from TBCatalogdataEntity where id='" + fartherid + "' and type='" + type + "'");
			if (tBCatalogList.size() > 0) {
				TBCatalogdataEntity tbCatalogdataEntity = tBCatalogList.get(0);
				String catalogCode = tbCatalogdataEntity.getCatalogCode();
				String strCode = String.format("%0" + 3 + "d", (nextCode+1));
				return catalogCode + "-" + strCode;
			}
		}

		return null;
	}
}