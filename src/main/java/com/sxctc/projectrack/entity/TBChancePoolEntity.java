package com.sxctc.projectrack.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 项目机会池
 * @author onlineGenerator
 * @date 2018-08-23 17:07:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_chance_pool", schema = "")
@SuppressWarnings("serial")
public class TBChancePoolEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**单位名称*/
	@Excel(name="单位名称",width=15,dicCode="unit_name")
	private java.lang.Integer unitCode;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String projectName;
	/**项目预算*/
	@Excel(name="项目预算",width=15)
	private java.math.BigDecimal projectBudget;
	/**软件和服务*/
	@Excel(name="软件和服务",width=15)
	private java.math.BigDecimal projectServer;
	/**硬件*/
	@Excel(name="硬件",width=15)
	private java.math.BigDecimal projectHardware;
	/**主要合作公司*/
	@Excel(name="主要合作公司",width=15)
	private java.lang.String businessParters;
	/**竞争对手*/
	@Excel(name="竞争对手",width=15)
	private java.lang.String businessCompetitor;
	/**预计招标时间*/
	@Excel(name="预计招标时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date predictTenderTime;
	/**资金来源*/
	@Excel(name="资金来源",width=15,dicCode="provide")
	private java.lang.Integer fundsProvided;
	/**上层关系*/
	@Excel(name="上层关系",width=15)
	private java.lang.String topRelation;
	/**中层关系*/
	@Excel(name="中层关系",width=15)
	private java.lang.String midRelation;
	/**下层关系*/
	@Excel(name="下层关系",width=15)
	private java.lang.String bottomRelation;
	/**当年把控度*/
	@Excel(name="当年把控度",width=15)
	private java.lang.String controlDegree;
	/**现在及下一步计划*/
	@Excel(name="现在及下一步计划",width=15)
	private java.lang.String projectPlan;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String remark;
	/**是否中标*/
	@Excel(name="是否中标",width=15,dicCode="dev_flag")
	private java.lang.Integer winningResult;
	/**业务主表id*/
	private java.lang.String businessId;
	/**商机评估要素1win*/
	private java.lang.Integer evaluateWin;
	/**商机评估要素3first*/
	private java.lang.Integer evaluateFirst;
	/**商机评估要素9confirm*/
	private java.lang.Integer evaluateConfirm;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  单位名称
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=10)
	public java.lang.Integer getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  单位名称
	 */
	public void setUnitCode(java.lang.Integer unitCode){
		this.unitCode = unitCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="PROJECT_NAME",nullable=true,length=32)
	public java.lang.String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  项目预算
	 */

	@Column(name ="PROJECT_BUDGET",nullable=true,length=32)
	public java.math.BigDecimal getProjectBudget(){
		return this.projectBudget;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  项目预算
	 */
	public void setProjectBudget(java.math.BigDecimal projectBudget){
		this.projectBudget = projectBudget;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  软件和服务
	 */

	@Column(name ="PROJECT_SERVER",nullable=true,length=32)
	public java.math.BigDecimal getProjectServer(){
		return this.projectServer;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  软件和服务
	 */
	public void setProjectServer(java.math.BigDecimal projectServer){
		this.projectServer = projectServer;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  硬件
	 */

	@Column(name ="PROJECT_HARDWARE",nullable=true,length=32)
	public java.math.BigDecimal getProjectHardware(){
		return this.projectHardware;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  硬件
	 */
	public void setProjectHardware(java.math.BigDecimal projectHardware){
		this.projectHardware = projectHardware;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主要合作公司
	 */

	@Column(name ="BUSINESS_PARTERS",nullable=true,length=32)
	public java.lang.String getBusinessParters(){
		return this.businessParters;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主要合作公司
	 */
	public void setBusinessParters(java.lang.String businessParters){
		this.businessParters = businessParters;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  竞争对手
	 */

	@Column(name ="BUSINESS_COMPETITOR",nullable=true,length=200)
	public java.lang.String getBusinessCompetitor(){
		return this.businessCompetitor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  竞争对手
	 */
	public void setBusinessCompetitor(java.lang.String businessCompetitor){
		this.businessCompetitor = businessCompetitor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计招标时间
	 */

	@Column(name ="PREDICT_TENDER_TIME",nullable=true)
	public java.util.Date getPredictTenderTime(){
		return this.predictTenderTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计招标时间
	 */
	public void setPredictTenderTime(java.util.Date predictTenderTime){
		this.predictTenderTime = predictTenderTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  资金来源
	 */

	@Column(name ="FUNDS_PROVIDED",nullable=true,length=4)
	public java.lang.Integer getFundsProvided(){
		return this.fundsProvided;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  资金来源
	 */
	public void setFundsProvided(java.lang.Integer fundsProvided){
		this.fundsProvided = fundsProvided;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上层关系
	 */

	@Column(name ="TOP_RELATION",nullable=true,length=500)
	public java.lang.String getTopRelation(){
		return this.topRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上层关系
	 */
	public void setTopRelation(java.lang.String topRelation){
		this.topRelation = topRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中层关系
	 */

	@Column(name ="MID_RELATION",nullable=true,length=500)
	public java.lang.String getMidRelation(){
		return this.midRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中层关系
	 */
	public void setMidRelation(java.lang.String midRelation){
		this.midRelation = midRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下层关系
	 */

	@Column(name ="BOTTOM_RELATION",nullable=true,length=500)
	public java.lang.String getBottomRelation(){
		return this.bottomRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下层关系
	 */
	public void setBottomRelation(java.lang.String bottomRelation){
		this.bottomRelation = bottomRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当年把控度
	 */

	@Column(name ="CONTROL_DEGREE",nullable=true,length=32)
	public java.lang.String getControlDegree(){
		return this.controlDegree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当年把控度
	 */
	public void setControlDegree(java.lang.String controlDegree){
		this.controlDegree = controlDegree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现在及下一步计划
	 */

	@Column(name ="PROJECT_PLAN",nullable=true)
	public java.lang.String getProjectPlan(){
		return this.projectPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现在及下一步计划
	 */
	public void setProjectPlan(java.lang.String projectPlan){
		this.projectPlan = projectPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true,length=32)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否中标
	 */

	@Column(name ="WINNING_RESULT",nullable=true,length=4)
	public java.lang.Integer getWinningResult(){
		return this.winningResult;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否中标
	 */
	public void setWinningResult(java.lang.Integer winningResult){
		this.winningResult = winningResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务主表id
	 */

	@Column(name ="BUSINESS_ID",nullable=true,length=36)
	public java.lang.String getBusinessId(){
		return this.businessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务主表id
	 */
	public void setBusinessId(java.lang.String businessId){
		this.businessId = businessId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商机评估要素1win
	 */

	@Column(name ="EVALUATE_WIN",nullable=true,length=4)
	public java.lang.Integer getEvaluateWin(){
		return this.evaluateWin;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商机评估要素1win
	 */
	public void setEvaluateWin(java.lang.Integer evaluateWin){
		this.evaluateWin = evaluateWin;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商机评估要素3first
	 */

	@Column(name ="EVALUATE_FIRST",nullable=true,length=4)
	public java.lang.Integer getEvaluateFirst(){
		return this.evaluateFirst;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商机评估要素3first
	 */
	public void setEvaluateFirst(java.lang.Integer evaluateFirst){
		this.evaluateFirst = evaluateFirst;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商机评估要素9confirm
	 */

	@Column(name ="EVALUATE_CONFIRM",nullable=true,length=4)
	public java.lang.Integer getEvaluateConfirm(){
		return this.evaluateConfirm;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商机评估要素9confirm
	 */
	public void setEvaluateConfirm(java.lang.Integer evaluateConfirm){
		this.evaluateConfirm = evaluateConfirm;
	}
}
