package com.sxctc.business.service.impl;
import com.sxctc.business.entity.TBBusiCatalogEntity;
import com.sxctc.business.service.TBBusinessServiceI;
import com.sxctc.businessoppty.entity.TBBusinessOpptyEntity;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.unitManage.entity.TBUnitManageEntity;
import com.sxctc.workreport.entity.TBBusiWorkreportEntity;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import com.sxctc.workreport.entity.TBWorkreportdayMonthEntity;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.business.entity.TBBusinessEntity;
import org.jeecgframework.web.system.pojo.base.TSUser;
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
		map.put("demand_time", t.getDemandTime());
		map.put("plan_time", t.getPlanTime());
		map.put("resource_time", t.getResourceTime());
		map.put("test_time", t.getTestTime());
		map.put("finish_time", t.getFinishTime());
		map.put("funds_provided", t.getFundsProvided());
		map.put("day_range", t.getDayRange());
		map.put("remark", t.getRemark());
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
		sql  = sql.replace("#{demand_time}",String.valueOf(t.getDemandTime()));
		sql  = sql.replace("#{plan_time}",String.valueOf(t.getPlanTime()));
		sql  = sql.replace("#{resource_time}",String.valueOf(t.getResourceTime()));
		sql  = sql.replace("#{test_time}",String.valueOf(t.getTestTime()));
		sql  = sql.replace("#{finish_time}",String.valueOf(t.getFinishTime()));
		sql  = sql.replace("#{funds_provided}",String.valueOf(t.getFundsProvided()));
		sql  = sql.replace("#{day_range}",String.valueOf(t.getDayRange()));
		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
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


	/**
	 * @Title deleteBusiness
	 * @Description 上云业务列表删除逻辑
	 * @Param [tBBusiness, busiWorkreportId]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/29 下午1:53
	 **/
	public void deleteBusiness(TBBusinessEntity tBBusiness, String busiWorkreportId) throws Exception{
		// 获取项目归属人
		String createBy = tBBusiness.getCreateBy();
		Integer chanceStatus = tBBusiness.getChanceStatus();
		/**
		 * 删除系统上云列表和日报有关内容
		 **/
		// 删除业务主表
		this.delete(tBBusiness);

		// 接着删除日报有关信息
		// 1、删除今日日报
		List<TBBusiWorkreportEntity> busiReportList = this.findByProperty(TBBusiWorkreportEntity.class, "businessId", busiWorkreportId);
		if (busiReportList.size() > 0) {
			for (TBBusiWorkreportEntity tbBusiWorkreportEntity : busiReportList) {
				String busiReportId = tbBusiWorkreportEntity.getId();
				this.deleteEntityById(TBBusiWorkreportEntity.class,busiReportId);
				// 删除历史日报关联数据
				List<TBWorkreportdayEntity> workReportList = this.findByProperty(TBWorkreportdayEntity.class, "busiReportId", busiReportId);
				if (workReportList.size() > 0) {
					for (TBWorkreportdayEntity tbWorkreportdayEntity : workReportList) {
						this.deleteEntityById(TBWorkreportdayEntity.class,tbWorkreportdayEntity.getId());
					}
				}
			}
		}
		// 2、删除周报
		List<TBWorkreportdayWeekEntity> weekReportList = this.findByProperty(TBWorkreportdayWeekEntity.class, "businessId", busiWorkreportId);
		if (weekReportList.size() > 0) {
			for (TBWorkreportdayWeekEntity tbWeekreportEntity : weekReportList) {
				String busiReportId = tbWeekreportEntity.getId();
				this.deleteEntityById(TBWorkreportdayWeekEntity.class,busiReportId);
			}
		}
		// 3、删除月报
		List<TBWorkreportdayMonthEntity> monthReportList = this.findByProperty(TBWorkreportdayMonthEntity.class, "businessId", busiWorkreportId);
		if (busiReportList.size() > 0) {
			for (TBWorkreportdayMonthEntity tbMonthreportEntity : monthReportList) {
				String busiReportId = tbMonthreportEntity.getId();
				this.deleteEntityById(TBWorkreportdayMonthEntity.class,busiReportId);
			}
		}

		// 删除服务目录有关信息
		List<TBBusiCatalogEntity> busiCatalogList = this.findByProperty(TBBusiCatalogEntity.class, "businessId", busiWorkreportId);
		if (busiCatalogList.size() > 0) {
			for (TBBusiCatalogEntity tbBusiCatalogEntity : busiCatalogList) {
				this.deleteEntityById(TBBusiCatalogEntity.class,tbBusiCatalogEntity.getId());
			}
		}

		/**
		 * 删除项目机会池和商机评估表中关联内容（如果是有）
		 **/
		// 如果是跟踪项目，那么一定有信息
		if (chanceStatus == 1) {
			// 获取项目机会池信息
			TBChancePoolEntity tBChancePool = this.findUniqueByProperty(TBChancePoolEntity.class, "businessId", busiWorkreportId);

			if (tBChancePool != null && StringUtils.isNotBlank(tBChancePool.getId())) {
				// 1、删除机会池中项目
				this.delete(tBChancePool);

				// 2、删除商机评估中数据（如果有）
				String hql = "from TBBusinessOpptyEntity where businessId=? and createBy=? and businessStatus=1";
				List<TBBusinessOpptyEntity> tBBusinessOpptyList = this.findHql(hql, busiWorkreportId, createBy);
				if (tBBusinessOpptyList.size() == 1) {
					TBBusinessOpptyEntity tbBusinessOpptyEntity = tBBusinessOpptyList.get(0);
					// 判断是不是其用户下唯一一个评级
					// 获取他现在的评级
					Integer sortNum = tbBusinessOpptyEntity.getSortNum();
					// 根据评级筛选
					String hql1 = "from TBBusinessOpptyEntity where sortNum=? and createBy=? and businessStatus=1";
					List<TBBusinessOpptyEntity> tBBusinessOppty = this.findHql(hql1, sortNum, createBy);
					// 如果不是，则直接删除
					if (tBBusinessOppty.size() > 1) {
						this.delete(tbBusinessOpptyEntity);
					}
					// 如果是，则更新为空
					if (tBBusinessOppty.size() == 1) {
						tbBusinessOpptyEntity.setUpdateDate(null);
						tbBusinessOpptyEntity.setUpdateBy(null);
						tbBusinessOpptyEntity.setUpdateName(null);
						tbBusinessOpptyEntity.setProjectName(null);
						tbBusinessOpptyEntity.setUnitCode(null);
						tbBusinessOpptyEntity.setBusinessId(null);
						this.updateEntitie(tbBusinessOpptyEntity);
					}

				}
			}
		}


		/**
		 * 删除已签订项目列表数据（如果有）
		 **/
		// 获取项目机会池信息
		TBProfitTargetEntity tBProfitTarget = this.findUniqueByProperty(TBProfitTargetEntity.class, "businessId", busiWorkreportId);
		if (tBProfitTarget != null && StringUtils.isNotBlank(tBProfitTarget.getId())) {
			// 删除已签订项目
			this.delete(tBProfitTarget);
		}

	}

	/**
	 * @Title doAddBusiness
	 * @Description 上云业务保存逻辑
	 * @Param [tBBusiness, busiWorkreportId]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/29 下午2:02
	 **/
	public void doAddBusiness(TBBusinessEntity tBBusiness) throws Exception{
		Date finishTime = tBBusiness.getFinishTime();
		Date busJoinTime = tBBusiness.getBusJoinTime();
		if (finishTime != null) {
			long day=(finishTime.getTime()-busJoinTime.getTime())/(24*60*60*1000);
			if (day >= 0) {
				tBBusiness.setDayRange((int)day);
			}
		}
		this.save(tBBusiness);

		// 同时往日志表里存一条数据
		TBBusiWorkreportEntity tbBusiWorkreportEntity1 = new TBBusiWorkreportEntity();
		tbBusiWorkreportEntity1.setBusinessId(tBBusiness.getId());
		tbBusiWorkreportEntity1.setUnitCode(String.valueOf(tBBusiness.getUnitCode()));
		tbBusiWorkreportEntity1.setReportTitle(tBBusiness.getProjectName());
		tbBusiWorkreportEntity1.setReportType(0);
		// 保存初级日报
		this.save(tbBusiWorkreportEntity1);

		// 同时往周报表里存一条数据
		TBWorkreportdayWeekEntity tbWorkreportdayWeekEntity = new TBWorkreportdayWeekEntity();
		tbWorkreportdayWeekEntity.setBusinessId(tBBusiness.getId());
		tbWorkreportdayWeekEntity.setUnitCode(String.valueOf(tBBusiness.getUnitCode()));
		tbWorkreportdayWeekEntity.setProjectName(tBBusiness.getProjectName());
		tbWorkreportdayWeekEntity.setReportType(0);
		// 保存周报
		this.save(tbWorkreportdayWeekEntity);

		// 同时往月报表里存一条数据
		TBWorkreportdayMonthEntity tbWorkreportdayMonthEntity = new TBWorkreportdayMonthEntity();
		tbWorkreportdayMonthEntity.setBusinessId(tBBusiness.getId());
		tbWorkreportdayMonthEntity.setUnitCode(tBBusiness.getUnitCode());
		tbWorkreportdayMonthEntity.setReportTitle(tBBusiness.getProjectName());
		tbWorkreportdayMonthEntity.setReportType(0);
		// 保存月报
		this.save(tbWorkreportdayMonthEntity);

		// 判断是否跟踪：如果是，则往项目跟踪表插入数据
		Integer chanceStatus = tBBusiness.getChanceStatus();
		if (chanceStatus == 1) {
			TBChancePoolEntity tbChancePoolEntity = new TBChancePoolEntity();
			tbChancePoolEntity.setBusinessId(tBBusiness.getId());
			tbChancePoolEntity.setUnitCode(tBBusiness.getUnitCode());
			tbChancePoolEntity.setProjectName(tBBusiness.getProjectName());
			tbChancePoolEntity.setWinningResult(0);
			this.save(tbChancePoolEntity);
		}
	}

	/**
	 * @Title importSaleBusiness
	 * @Description 导入销售负责系统
	 * @Param [tBBusiness]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/12/10 14:15
	 **/
	public void importSaleBusiness(TBBusinessEntity tBBusiness) throws Exception {
		// 获取当前系统用户
		TSUser tsUser = ResourceUtil.getSessionUser();

		// 修改系统负责人
		tBBusiness.setCreateBy(tsUser.getUserName());
		tBBusiness.setCreateName(tsUser.getRealName());
		tBBusiness.setSysOrgCode(tsUser.getCurrentDepart().getOrgCode());
		tBBusiness.setSysCompanyCode(tsUser.getCurrentDepart().getSysCompanyCode());
		tBBusiness.setChanceStatus(0);
		// 更新
		this.saveOrUpdate(tBBusiness);

		// 同时往日志表里存一条数据
		TBBusiWorkreportEntity tbBusiWorkreportEntity1 = new TBBusiWorkreportEntity();
		tbBusiWorkreportEntity1.setBusinessId(tBBusiness.getId());
		tbBusiWorkreportEntity1.setUnitCode(String.valueOf(tBBusiness.getUnitCode()));
		tbBusiWorkreportEntity1.setReportTitle(tBBusiness.getProjectName());
		tbBusiWorkreportEntity1.setReportType(0);
		// 保存初级日报
		this.save(tbBusiWorkreportEntity1);

		// 同时往周报表里存一条数据
		TBWorkreportdayWeekEntity tbWorkreportdayWeekEntity = new TBWorkreportdayWeekEntity();
		tbWorkreportdayWeekEntity.setBusinessId(tBBusiness.getId());
		tbWorkreportdayWeekEntity.setUnitCode(String.valueOf(tBBusiness.getUnitCode()));
		tbWorkreportdayWeekEntity.setProjectName(tBBusiness.getProjectName());
		tbWorkreportdayWeekEntity.setReportType(0);
		// 保存周报
		this.save(tbWorkreportdayWeekEntity);

		// 同时往月报表里存一条数据
		TBWorkreportdayMonthEntity tbWorkreportdayMonthEntity = new TBWorkreportdayMonthEntity();
		tbWorkreportdayMonthEntity.setBusinessId(tBBusiness.getId());
		tbWorkreportdayMonthEntity.setUnitCode(tBBusiness.getUnitCode());
		tbWorkreportdayMonthEntity.setReportTitle(tBBusiness.getProjectName());
		tbWorkreportdayMonthEntity.setReportType(0);
		// 保存月报
		this.save(tbWorkreportdayMonthEntity);

	}
}