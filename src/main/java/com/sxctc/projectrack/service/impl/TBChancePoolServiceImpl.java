package com.sxctc.projectrack.service.impl;
import com.sxctc.businessoppty.entity.TBBusinessOpptyEntity;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import com.sxctc.projectrack.service.TBChancePoolServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

@Service("tBChancePoolService")
@Transactional
public class TBChancePoolServiceImpl extends CommonServiceImpl implements TBChancePoolServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void delete(TBChancePoolEntity entity) throws Exception{
		super.delete(entity);
		//执行删除操作增强业务
		this.doDelBus(entity);
	}

	public Serializable save(TBChancePoolEntity entity) throws Exception{
		Serializable t = super.save(entity);
		//执行新增操作增强业务
		this.doAddBus(entity);
		return t;
	}

	public void saveOrUpdate(TBChancePoolEntity entity) throws Exception{
		super.saveOrUpdate(entity);
		//执行更新操作增强业务
		this.doUpdateBus(entity);
	}

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBChancePoolEntity t) throws Exception{
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
	private void doUpdateBus(TBChancePoolEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}
	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(TBChancePoolEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
		//-----------------sql增强 end------------------------------

		//-----------------java增强 start---------------------------
		//-----------------java增强 end-----------------------------
	}

	private Map<String,Object> populationMap(TBChancePoolEntity t){
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
		map.put("project_name", t.getProjectName());
		map.put("project_budget", t.getProjectBudget());
		map.put("project_server", t.getProjectServer());
		map.put("project_hardware", t.getProjectHardware());
		map.put("business_parters", t.getBusinessParters());
		map.put("business_competitor", t.getBusinessCompetitor());
		map.put("predict_tender_time", t.getPredictTenderTime());
		map.put("funds_provided", t.getFundsProvided());
		map.put("top_relation", t.getTopRelation());
		map.put("mid_relation", t.getMidRelation());
		map.put("bottom_relation", t.getBottomRelation());
		map.put("control_degree", t.getControlDegree());
		map.put("project_plan", t.getProjectPlan());
		map.put("remark", t.getRemark());
		map.put("winning_result", t.getWinningResult());
		map.put("business_id", t.getBusinessId());
		map.put("evaluate_status", t.getEvaluateStatus());
		map.put("history_plan", t.getHistoryPlan());
		return map;
	}

	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
	public String replaceVal(String sql,TBChancePoolEntity t){
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
		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
		sql  = sql.replace("#{project_budget}",String.valueOf(t.getProjectBudget()));
		sql  = sql.replace("#{project_server}",String.valueOf(t.getProjectServer()));
		sql  = sql.replace("#{project_hardware}",String.valueOf(t.getProjectHardware()));
		sql  = sql.replace("#{business_parters}",String.valueOf(t.getBusinessParters()));
		sql  = sql.replace("#{business_competitor}",String.valueOf(t.getBusinessCompetitor()));
		sql  = sql.replace("#{predict_tender_time}",String.valueOf(t.getPredictTenderTime()));
		sql  = sql.replace("#{funds_provided}",String.valueOf(t.getFundsProvided()));
		sql  = sql.replace("#{top_relation}",String.valueOf(t.getTopRelation()));
		sql  = sql.replace("#{mid_relation}",String.valueOf(t.getMidRelation()));
		sql  = sql.replace("#{bottom_relation}",String.valueOf(t.getBottomRelation()));
		sql  = sql.replace("#{control_degree}",String.valueOf(t.getControlDegree()));
		sql  = sql.replace("#{project_plan}",String.valueOf(t.getProjectPlan()));
		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
		sql  = sql.replace("#{winning_result}",String.valueOf(t.getWinningResult()));
		sql  = sql.replace("#{business_id}",String.valueOf(t.getBusinessId()));
		sql  = sql.replace("#{evaluate_status}",String.valueOf(t.getEvaluateStatus()));
		sql  = sql.replace("#{history_plan}",String.valueOf(t.getHistoryPlan()));
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
					javaInter.execute("t_b_chance_pool",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			}
		}
	}

	private void executeSqlEnhance(String sqlEnhance,TBChancePoolEntity t){
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
	 * @Title saveOrUpdateChancePool
	 * @Description 更新机会池操作
	 * @Param [entity]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/9/1 上午10:57
	 **/
	public void saveOrUpdateChancePool(TBChancePoolEntity t, TBChancePoolEntity tBChancePool) throws Exception {
		TSUser tsUser = ResourceUtil.getSessionUser();

		// 更新
		this.saveOrUpdate(t);

		// 如果是已中标，则将数据添加到已签订项目中
		Integer winningResult = tBChancePool.getWinningResult();
		if (winningResult == 1) {
			// 将数据添加到已签订项目中
			TBProfitTargetEntity tbProfitTargetEntity = new TBProfitTargetEntity();
			tbProfitTargetEntity.setBusinessId(tBChancePool.getBusinessId());
			tbProfitTargetEntity.setProjectName(tBChancePool.getProjectName());
			tbProfitTargetEntity.setUnitCode(tBChancePool.getUnitCode());
			this.save(tbProfitTargetEntity);

			// 更新商机评估表将业务状态置为0
			List<TBBusinessOpptyEntity> byQueryString = this.findByQueryString("from TBBusinessOpptyEntity where businessId='" + t.getBusinessId() + "' and businessStatus=1 and createBy='" + tsUser.getUserName() + "'");
			if (byQueryString.size() > 0) {
				for (TBBusinessOpptyEntity tbBusinessOpptyEntity : byQueryString) {
					tbBusinessOpptyEntity.setBusinessStatus(0);
					this.saveOrUpdate(tbBusinessOpptyEntity);

					String evaluateWin = tbBusinessOpptyEntity.getEvaluateWin();
					String evaluateFirst = tbBusinessOpptyEntity.getEvaluateFirst();
					String evaluateConfirm = tbBusinessOpptyEntity.getEvaluateConfirm();
					String hql = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and businessStatus=1 and createBy=?";
					List<TBBusinessOpptyEntity> tBBusinessOpptyList = this.findHql(hql, evaluateWin, evaluateFirst, evaluateConfirm, tsUser.getUserName());
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

						this.save(tbBusinessOppty);

					}
				}
			}
		}
	}
}