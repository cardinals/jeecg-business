package com.sxctc.businessoppty.service.impl;
import com.sxctc.businessoppty.service.TBBusinessOpptyServiceI;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sxctc.businessoppty.entity.TBBusinessOpptyEntity;
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

@Service("tBBusinessOpptyService")
@Transactional
public class TBBusinessOpptyServiceImpl extends CommonServiceImpl implements TBBusinessOpptyServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TBBusinessOpptyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBBusinessOpptyEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBBusinessOpptyEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBBusinessOpptyEntity t) throws Exception{
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
	private void doUpdateBus(TBBusinessOpptyEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(TBBusinessOpptyEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBBusinessOpptyEntity t){
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
		map.put("oppty_range", t.getOpptyRange());
		map.put("evaluate_win", t.getEvaluateWin());
		map.put("evaluate_first", t.getEvaluateFirst());
		map.put("evaluate_confirm", t.getEvaluateConfirm());
		map.put("oppty_ratio", t.getOpptyRatio());
		map.put("oppty_point", t.getOpptyPoint());
		map.put("project_name", t.getProjectName());
		map.put("unit_code", t.getUnitCode());
		map.put("business_id", t.getBusinessId());
		map.put("sort_num", t.getSortNum());
		map.put("business_status", t.getBusinessStatus());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBBusinessOpptyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{oppty_range}",String.valueOf(t.getOpptyRange()));
 		sql  = sql.replace("#{evaluate_win}",String.valueOf(t.getEvaluateWin()));
 		sql  = sql.replace("#{evaluate_first}",String.valueOf(t.getEvaluateFirst()));
 		sql  = sql.replace("#{evaluate_confirm}",String.valueOf(t.getEvaluateConfirm()));
 		sql  = sql.replace("#{oppty_ratio}",String.valueOf(t.getOpptyRatio()));
 		sql  = sql.replace("#{oppty_point}",String.valueOf(t.getOpptyPoint()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{unit_code}",String.valueOf(t.getUnitCode()));
 		sql  = sql.replace("#{business_id}",String.valueOf(t.getBusinessId()));
 		sql  = sql.replace("#{sort_num}",String.valueOf(t.getSortNum()));
 		sql  = sql.replace("#{business_status}",String.valueOf(t.getBusinessStatus()));
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
					javaInter.execute("t_b_business_oppty",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
 	
 	private void executeSqlEnhance(String sqlEnhance,TBBusinessOpptyEntity t){
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
	 * @Title deleteBusinessOppty
	 * @Description 删除重写方法
	 * @Param [tBBusinessOppty]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/28 上午9:47
	 **/
	public void deleteBusinessOppty(TBBusinessOpptyEntity tBBusinessOppty) throws Exception{
		TSUser tsUser = ResourceUtil.getSessionUser();
		if (tBBusinessOppty != null) {
			Integer sortNum = tBBusinessOppty.getSortNum();
			//List<TBBusinessOpptyEntity> byQueryString = this.findByQueryString("from TBBusinessOpptyEntity where sortNum=" + sortNum + " and businessStatus=1 and createBy='" + tsUser.getUserName() + "'");
			String hql = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and createBy=? and businessStatus=1";
			List<TBBusinessOpptyEntity> byQueryString = this.findHql(hql, tBBusinessOppty.getEvaluateWin(), tBBusinessOppty.getEvaluateFirst(), tBBusinessOppty.getEvaluateConfirm(), tsUser.getUserName());
			// 如果只剩一条，需要初始化一条数据
			if (byQueryString.size() == 1) {
				TBBusinessOpptyEntity tbBusinessOpptyNew = new TBBusinessOpptyEntity();
				tbBusinessOpptyNew.setBusinessStatus(1);
				tbBusinessOpptyNew.setSortNum(tBBusinessOppty.getSortNum());
				tbBusinessOpptyNew.setOpptyPoint(tBBusinessOppty.getOpptyPoint());
				tbBusinessOpptyNew.setOpptyRatio(tBBusinessOppty.getOpptyRatio());
				tbBusinessOpptyNew.setEvaluateConfirm(tBBusinessOppty.getEvaluateConfirm());
				tbBusinessOpptyNew.setEvaluateFirst(tBBusinessOppty.getEvaluateFirst());
				tbBusinessOpptyNew.setEvaluateWin(tBBusinessOppty.getEvaluateWin());
				tbBusinessOpptyNew.setOpptyRange(tBBusinessOppty.getOpptyRange());

				this.save(tbBusinessOpptyNew);
			}

			// 删除要删除的记录
			this.delete(tBBusinessOppty);

			// 更改项目机会池评估状态
			String businessId = tBBusinessOppty.getBusinessId();
			List<TBChancePoolEntity> tBChancePoolList = this.findByQueryString("from TBChancePoolEntity where businessId='" + businessId + "' and evaluateStatus=1");
			if (tBChancePoolList.size() > 0 ) {
				for (TBChancePoolEntity tbChancePoolEntity : tBChancePoolList) {
					tbChancePoolEntity.setEvaluateStatus(null);
					this.updateEntitie(tbChancePoolEntity);
				}
			}
		}
	}
	/**
	 * @Title evaluate
	 * @Description 进行业务调用，调用公共方法：组装评估结果
	 * @Param [tBBusinessOppty, evaluateWin, evaluateWinFirst, evaluateConfirm, opptyRange, opptyRatio, sortNum]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/28 上午9:41
	 **/
	public void evaluate(TBBusinessOpptyEntity tBBusinessOppty, int win, int first, int confirm) {
		if (win==1 && first==3) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","3F","*C",1,"100%",1);}
		if (win==1 && first==2) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","2F","*C",1,"99%",2);}
		if (win==1 && first==1 && confirm==9) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","9C",1,"91%",3);}
		if (win==1 && first==1 && confirm==8) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","8C",1,"85%",4);}
		if (win==1 && first==1 && confirm==7) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","7C",1,"85%",5);}
		if (win==1 && first==1 && confirm==6) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","6C",1,"85%",6);}
		if (win==1 && first==1 && confirm==5) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","5C",2,"50%",7);}
		if (win==1 && first==1 && confirm==4) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","4C",2,"50%",8);}
		if (win==1 && first==1 && confirm==3) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","3C",2,"50%",9);}
		if (win==1 && first==1 && confirm==2) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","2C",2,"50%",10);}
		if (win==1 && first==1 && confirm==1) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","1C",2,"50%",11);}
		if (win==1 && first==1 && confirm==0) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"1W","1F","0C",2,"50%",12);}
		if (win==0 && first==2 && confirm==8) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"0W","2F","8C",2,"50%",13);}
		if (win==0 && first==2 && confirm==7) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"0W","2F","7C",2,"50%",14);}
		if (win==0 && first==2 && confirm==6) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"0W","2F","6C",3,"26%",15);}
		if (win==0 && first==2) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"0W","2F","*C",3,"22%",16);}
		if (win==0 && first==1) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"0W","1F","*C",3,"3%",17);}
		if (win==0 && first==0) {this.evaluateWinSaveOrUpdate(tBBusinessOppty,"0W","0F","*C",3,"0%",18);}
	}

	/**
	 * @Title evaluateWinSaveOrUpdate
	 * @Description 公共方法：组装评估结果
	 * @Param [tBBusinessOppty, evaluateWin, evaluateWinFirst, evaluateConfirm, opptyRange, opptyRatio]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/27 下午2:38
	 **/
	public void evaluateWinSaveOrUpdate(TBBusinessOpptyEntity tBBusinessOppty, String evaluateWin, String evaluateWinFirst, String evaluateConfirm, int opptyRange, String opptyRatio, int sortNum){
		try {
			TSUser tsUser = ResourceUtil.getSessionUser();

			// 拼装基本数据
			tBBusinessOppty.setEvaluateWin(evaluateWin);
			tBBusinessOppty.setEvaluateFirst(evaluateWinFirst);
			tBBusinessOppty.setEvaluateConfirm(evaluateConfirm);
			tBBusinessOppty.setOpptyRatio(opptyRatio);
			tBBusinessOppty.setOpptyRange(opptyRange);
			tBBusinessOppty.setSortNum(sortNum);
			tBBusinessOppty.setBusinessStatus(1);

			// 拐点判断
			if ("1W".equals(evaluateWin) && "1F".equals(evaluateWinFirst) && "6C".equals(evaluateConfirm)) {
				tBBusinessOppty.setOpptyPoint(1);
			}
			if ("0W".equals(evaluateWin) && "2F".equals(evaluateWinFirst) && "6C".equals(evaluateConfirm)) {
				tBBusinessOppty.setOpptyPoint(2);
			}

			// 判断该系统是否已经评估过
			// 商机评估
			String hql2 = "from TBBusinessOpptyEntity where businessId=? and createBy=? and businessStatus=1";
			List<TBBusinessOpptyEntity> opptyList = this.findHql(hql2, tBBusinessOppty.getBusinessId(), tsUser.getUserName());
			// 已评估过：接下来判断是覆盖还是新的评估
			if (opptyList.size() == 1) {
				TBBusinessOpptyEntity tbBusinessOpptyEntity = opptyList.get(0);

				// 判断是不是其评级下面唯一一个
				String hql3 = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and createBy=? and businessStatus=1";
				List<TBBusinessOpptyEntity> arrayList = this.findHql(hql3, tbBusinessOpptyEntity.getEvaluateWin(), tbBusinessOpptyEntity.getEvaluateFirst(), tbBusinessOpptyEntity.getEvaluateConfirm(), tsUser.getUserName());
				// 是唯一一个，需要更新
				if (arrayList.size() == 1) {
					TBBusinessOpptyEntity tbBusiness = arrayList.get(0);
					// 如果是评级更新，则需要覆盖
					if (tbBusiness.getSortNum() == tBBusinessOppty.getSortNum()) {
						tBBusinessOppty.setId(tbBusiness.getId());
						tBBusinessOppty.setCreateName(tbBusiness.getCreateName());
						tBBusinessOppty.setCreateBy(tbBusiness.getCreateBy());
						tBBusinessOppty.setCreateDate(tbBusiness.getCreateDate());
						tBBusinessOppty.setSysOrgCode(tbBusiness.getSysOrgCode());
						tBBusinessOppty.setSysCompanyCode(tbBusiness.getSysCompanyCode());
						this.getSession().merge(tBBusinessOppty);

					}else {
						// 如果不是统一评级，需要删除之前的，再保存（删除时候注意判断是否最后一个）
						// 删除之前的
						tbBusiness.setUpdateDate(null);
						tbBusiness.setUpdateBy(null);
						tbBusiness.setUpdateName(null);
						tbBusiness.setProjectName(null);
						tbBusiness.setUnitCode(null);
						tbBusiness.setBusinessId(null);
						this.updateEntitie(tbBusiness);

						// 保存新的,要注意保存和覆盖
						String hql4 = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and businessId is null and createBy=?";
						List<TBBusinessOpptyEntity> tBBusinessOpptyList1 = this.findHql(hql4, evaluateWin, evaluateWinFirst, evaluateConfirm, tsUser.getUserName());
						if (tBBusinessOpptyList1.size() == 1) {
							tBBusinessOppty.setId(tBBusinessOpptyList1.get(0).getId());
							tBBusinessOppty.setCreateName(tBBusinessOpptyList1.get(0).getCreateName());
							tBBusinessOppty.setCreateBy(tBBusinessOpptyList1.get(0).getCreateBy());
							tBBusinessOppty.setCreateDate(tBBusinessOpptyList1.get(0).getCreateDate());
							tBBusinessOppty.setSysOrgCode(tBBusinessOpptyList1.get(0).getSysOrgCode());
							tBBusinessOppty.setSysCompanyCode(tBBusinessOpptyList1.get(0).getSysCompanyCode());
							this.getSession().merge(tBBusinessOppty);
						}else {
							tBBusinessOppty.setUpdateName(tsUser.getRealName());
							tBBusinessOppty.setUpdateBy(tsUser.getUserName());
							tBBusinessOppty.setUpdateDate(new Date());
							this.save(tBBusinessOppty);
						}

					}
				}else {
					// 不是唯一一个，删除原来的，直接保存
					this.delete(tbBusinessOpptyEntity);

					// 保存新的
					String hql4 = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and businessId is null and createBy=?";
					List<TBBusinessOpptyEntity> tBBusinessOpptyList1 = this.findHql(hql4, evaluateWin, evaluateWinFirst, evaluateConfirm, tsUser.getUserName());
					if (tBBusinessOpptyList1.size() == 1) {
						tBBusinessOppty.setId(tBBusinessOpptyList1.get(0).getId());
						tBBusinessOppty.setCreateName(tBBusinessOpptyList1.get(0).getCreateName());
						tBBusinessOppty.setCreateBy(tBBusinessOpptyList1.get(0).getCreateBy());
						tBBusinessOppty.setCreateDate(tBBusinessOpptyList1.get(0).getCreateDate());
						tBBusinessOppty.setSysOrgCode(tBBusinessOpptyList1.get(0).getSysOrgCode());
						tBBusinessOppty.setSysCompanyCode(tBBusinessOpptyList1.get(0).getSysCompanyCode());
						this.getSession().merge(tBBusinessOppty);
					}else {
						tBBusinessOppty.setUpdateName(tsUser.getRealName());
						tBBusinessOppty.setUpdateBy(tsUser.getUserName());
						tBBusinessOppty.setUpdateDate(new Date());
						this.save(tBBusinessOppty);
					}
				}

			}else {
				// 没有评估过的话直接进行评估，要注意保存和覆盖
				// 商机评估
				String hql4 = "from TBBusinessOpptyEntity where evaluateWin=? and evaluateFirst=? and evaluateConfirm=? and businessId is null and createBy=?";
				List<TBBusinessOpptyEntity> tBBusinessOpptyList1 = this.findHql(hql4, evaluateWin, evaluateWinFirst, evaluateConfirm, tsUser.getUserName());
				if (tBBusinessOpptyList1.size() == 1) {
					tBBusinessOppty.setId(tBBusinessOpptyList1.get(0).getId());
					tBBusinessOppty.setCreateName(tBBusinessOpptyList1.get(0).getCreateName());
					tBBusinessOppty.setCreateBy(tBBusinessOpptyList1.get(0).getCreateBy());
					tBBusinessOppty.setCreateDate(tBBusinessOpptyList1.get(0).getCreateDate());
					tBBusinessOppty.setSysOrgCode(tBBusinessOpptyList1.get(0).getSysOrgCode());
					tBBusinessOppty.setSysCompanyCode(tBBusinessOpptyList1.get(0).getSysCompanyCode());
					this.getSession().merge(tBBusinessOppty);
				}else {
					tBBusinessOppty.setUpdateName(tsUser.getRealName());
					tBBusinessOppty.setUpdateBy(tsUser.getUserName());
					tBBusinessOppty.setUpdateDate(new Date());
					this.save(tBBusinessOppty);
				}

			}

			// 修改项目机会池评估状态
			String businessId = tBBusinessOppty.getBusinessId();
			List<TBChancePoolEntity> byQueryString = this.findByQueryString("from TBChancePoolEntity where businessId='" + businessId + "' and evaluateStatus is null");
			if (byQueryString.size() > 0) {
				for (TBChancePoolEntity tbChancePoolEntity : byQueryString) {
					tbChancePoolEntity.setEvaluateStatus(1);
					this.updateEntitie(tbChancePoolEntity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
}