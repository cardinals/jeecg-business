package com.sxctc.workreport.service.impl;
import com.sxctc.workreport.service.TBWorkreportdayWeekServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
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

@Service("tBWorkreportdayWeekService")
@Transactional
public class TBWorkreportdayWeekServiceImpl extends CommonServiceImpl implements TBWorkreportdayWeekServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TBWorkreportdayWeekEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBWorkreportdayWeekEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBWorkreportdayWeekEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBWorkreportdayWeekEntity t) throws Exception{
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
	private void doUpdateBus(TBWorkreportdayWeekEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(TBWorkreportdayWeekEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBWorkreportdayWeekEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("unit_code", t.getUnitCode());
		map.put("project_name", t.getProjectName());
		map.put("done_day", t.getDoneDay());
		map.put("next_done", t.getNextDone());
		map.put("coordinate_work", t.getCoordinateWork());
		map.put("remark", t.getRemark());
		map.put("business_id", t.getBusinessId());
		map.put("report_start_date", t.getReportStartDate());
		map.put("report_end_date", t.getReportEndDate());
		map.put("report_type", t.getReportType());
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
 	public String replaceVal(String sql,TBWorkreportdayWeekEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{unit_code}",String.valueOf(t.getUnitCode()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{done_day}",String.valueOf(t.getDoneDay()));
 		sql  = sql.replace("#{next_done}",String.valueOf(t.getNextDone()));
 		sql  = sql.replace("#{coordinate_work}",String.valueOf(t.getCoordinateWork()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{business_id}",String.valueOf(t.getBusinessId()));
 		sql  = sql.replace("#{report_start_date}",String.valueOf(t.getReportStartDate()));
 		sql  = sql.replace("#{report_end_date}",String.valueOf(t.getReportEndDate()));
 		sql  = sql.replace("#{report_type}",String.valueOf(t.getReportType()));
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
					javaInter.execute("t_b_workreportday_week",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBWorkreportdayWeekEntity t){
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
 	 * @Title saveOrUpdateWeek
 	 * @Description 保存更新周报逻辑
 	 * @Param [t]
 	 * @Return void
 	 * @Author liuzc
 	 * @Date 2018/9/6 下午3:35
 	 **/
 	public void saveOrUpdateWeek(TBWorkreportdayWeekEntity t) throws Exception {
 		// 先保存更新系统主数据
		this.saveOrUpdate(t);

		// 再保存更新主数据对应的字数据
		String hql = "from TBWorkreportdayWeekEntity where reportStartDate=? and reportEndDate=? and fatherId=?";
		List<TBWorkreportdayWeekEntity> list = this.findHql(hql, t.getReportStartDate(), t.getReportEndDate(), t.getId());
		// 进行更新
		if (list.size() == 1) {
			TBWorkreportdayWeekEntity oldWeekEntity = list.get(0);
			String childId = oldWeekEntity.getId();
			MyBeanUtils.copyBeanNotNull2Bean(t, oldWeekEntity);
			oldWeekEntity.setId(childId);
			oldWeekEntity.setReportType(9);

			this.saveOrUpdate(oldWeekEntity);
		}

		// 进行新建
		if (list.size() == 0) {
			TBWorkreportdayWeekEntity newWeekEntity = new TBWorkreportdayWeekEntity();
			MyBeanUtils.copyBeanNotNull2Bean(t, newWeekEntity);
			newWeekEntity.setId(null);
			newWeekEntity.setFatherId(t.getId());
			newWeekEntity.setReportType(9);

			this.save(newWeekEntity);
		}

	}
}