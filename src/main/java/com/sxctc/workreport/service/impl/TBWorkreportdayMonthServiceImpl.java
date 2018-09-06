package com.sxctc.workreport.service.impl;
import com.sxctc.workreport.entity.TBWorkreportdayMonthEntity;
import com.sxctc.workreport.service.TBWorkreportdayMonthServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.workreport.entity.TBWorkreportdayMonthEntity;
import org.jeecgframework.core.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("tBWorkreportdayMonthService")
@Transactional
public class TBWorkreportdayMonthServiceImpl extends CommonServiceImpl implements TBWorkreportdayMonthServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TBWorkreportdayMonthEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBWorkreportdayMonthEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBWorkreportdayMonthEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBWorkreportdayMonthEntity t) throws Exception{
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
	private void doUpdateBus(TBWorkreportdayMonthEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(TBWorkreportdayMonthEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBWorkreportdayMonthEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("unit_code", t.getUnitCode());
		map.put("report_title", t.getReportTitle());
		map.put("report_date", t.getReportDate());
		map.put("done_today", t.getDoneToday());
		map.put("next_done", t.getNextDone());
		map.put("coordinate_work", t.getCoordinateWork());
		map.put("report_type", t.getReportType());
		map.put("business_id", t.getBusinessId());
		map.put("work_sum", t.getWorkSum());
		map.put("father_id", t.getFatherId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBWorkreportdayMonthEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{unit_code}",String.valueOf(t.getUnitCode()));
 		sql  = sql.replace("#{report_title}",String.valueOf(t.getReportTitle()));
 		sql  = sql.replace("#{report_date}",String.valueOf(t.getReportDate()));
 		sql  = sql.replace("#{done_today}",String.valueOf(t.getDoneToday()));
 		sql  = sql.replace("#{next_done}",String.valueOf(t.getNextDone()));
 		sql  = sql.replace("#{coordinate_work}",String.valueOf(t.getCoordinateWork()));
 		sql  = sql.replace("#{report_type}",String.valueOf(t.getReportType()));
 		sql  = sql.replace("#{business_id}",String.valueOf(t.getBusinessId()));
 		sql  = sql.replace("#{work_sum}",String.valueOf(t.getWorkSum()));
 		sql  = sql.replace("#{father_id}",String.valueOf(t.getFatherId()));
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
					javaInter.execute("t_b_workreportday_month",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBWorkreportdayMonthEntity t){
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
	 * @Title saveOrUpdateMonth
	 * @Description 保存更新周报逻辑
	 * @Param [t]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/9/6 下午3:35
	 **/
	public void saveOrUpdateMonth(TBWorkreportdayMonthEntity t) throws Exception {
		// 先保存更新系统主数据
		this.saveOrUpdate(t);

		// 再保存更新主数据对应的字数据
		String hql = "from TBWorkreportdayMonthEntity where reportDate=? and fatherId=?";
		List<TBWorkreportdayMonthEntity> list = this.findHql(hql, t.getReportDate(), t.getId());
		// 进行更新
		if (list.size() == 1) {
			TBWorkreportdayMonthEntity oldMonthEntity = list.get(0);
			String childId = oldMonthEntity.getId();
			MyBeanUtils.copyBeanNotNull2Bean(t, oldMonthEntity);
			oldMonthEntity.setId(childId);
			oldMonthEntity.setReportType(9);

			this.saveOrUpdate(oldMonthEntity);
		}

		// 进行新建
		if (list.size() == 0) {
			TBWorkreportdayMonthEntity newMonthEntity = new TBWorkreportdayMonthEntity();
			MyBeanUtils.copyBeanNotNull2Bean(t, newMonthEntity);
			newMonthEntity.setId(null);
			newMonthEntity.setFatherId(t.getId());
			newMonthEntity.setReportType(9);

			this.save(newMonthEntity);
		}

	}
}