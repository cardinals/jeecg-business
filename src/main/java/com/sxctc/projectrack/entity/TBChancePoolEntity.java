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
 * @date 2018-08-23 16:20:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_chance_pool", schema = "")
@SuppressWarnings("serial")
public class TBChancePoolEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新人登录名称*/
	private String updateBy;
	/**更新日期*/
	private Date updateDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**单位名称*/
	@Excel(name="单位名称",width=15,dicCode="unit_name")
	private Integer unitCode;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String projectName;
	/**项目预算*/
	@Excel(name="项目预算",width=15)
	private BigDecimal projectBudget;
	/**软件和服务*/
	@Excel(name="软件和服务",width=15)
	private BigDecimal projectServer;
	/**硬件*/
	@Excel(name="硬件",width=15)
	private BigDecimal projectHardware;
	/**主要合作公司*/
	@Excel(name="主要合作公司",width=15)
	private String businessParters;
	/**竞争对手*/
	@Excel(name="竞争对手",width=15)
	private String businessCompetitor;
	/**预计招标时间*/
	@Excel(name="预计招标时间",width=15,format = "yyyy-MM-dd")
	private Date predictTenderTime;
	/**资金来源*/
	@Excel(name="资金来源",width=15,dicCode="provide")
	private Integer fundsProvided;
	/**上层关系*/
	@Excel(name="上层关系",width=15)
	private String topRelation;
	/**中层关系*/
	@Excel(name="中层关系",width=15)
	private String midRelation;
	/**下层关系*/
	@Excel(name="下层关系",width=15)
	private String bottomRelation;
	/**当年把控度*/
	@Excel(name="当年把控度",width=15)
	private String controlDegree;
	/**现在及下一步计划*/
	@Excel(name="现在及下一步计划",width=15)
	private String projectPlan;
	/**备注*/
	@Excel(name="备注",width=15)
	private String remark;
	/**是否中标*/
	@Excel(name="是否中标",width=15,dicCode="dev_flag")
	private Integer winningResult;
	/**业务主表id*/
	private String businessId;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  单位名称
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=10)
	public Integer getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  单位名称
	 */
	public void setUnitCode(Integer unitCode){
		this.unitCode = unitCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="PROJECT_NAME",nullable=true,length=32)
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  项目预算
	 */

	@Column(name ="PROJECT_BUDGET",nullable=true,length=32)
	public BigDecimal getProjectBudget(){
		return this.projectBudget;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  项目预算
	 */
	public void setProjectBudget(BigDecimal projectBudget){
		this.projectBudget = projectBudget;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  软件和服务
	 */

	@Column(name ="PROJECT_SERVER",nullable=true,length=32)
	public BigDecimal getProjectServer(){
		return this.projectServer;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  软件和服务
	 */
	public void setProjectServer(BigDecimal projectServer){
		this.projectServer = projectServer;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  硬件
	 */

	@Column(name ="PROJECT_HARDWARE",nullable=true,length=32)
	public BigDecimal getProjectHardware(){
		return this.projectHardware;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  硬件
	 */
	public void setProjectHardware(BigDecimal projectHardware){
		this.projectHardware = projectHardware;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主要合作公司
	 */

	@Column(name ="BUSINESS_PARTERS",nullable=true,length=32)
	public String getBusinessParters(){
		return this.businessParters;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主要合作公司
	 */
	public void setBusinessParters(String businessParters){
		this.businessParters = businessParters;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  竞争对手
	 */

	@Column(name ="BUSINESS_COMPETITOR",nullable=true,length=200)
	public String getBusinessCompetitor(){
		return this.businessCompetitor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  竞争对手
	 */
	public void setBusinessCompetitor(String businessCompetitor){
		this.businessCompetitor = businessCompetitor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计招标时间
	 */

	@Column(name ="PREDICT_TENDER_TIME",nullable=true)
	public Date getPredictTenderTime(){
		return this.predictTenderTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计招标时间
	 */
	public void setPredictTenderTime(Date predictTenderTime){
		this.predictTenderTime = predictTenderTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  资金来源
	 */

	@Column(name ="FUNDS_PROVIDED",nullable=true,length=4)
	public Integer getFundsProvided(){
		return this.fundsProvided;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  资金来源
	 */
	public void setFundsProvided(Integer fundsProvided){
		this.fundsProvided = fundsProvided;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上层关系
	 */

	@Column(name ="TOP_RELATION",nullable=true,length=500)
	public String getTopRelation(){
		return this.topRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上层关系
	 */
	public void setTopRelation(String topRelation){
		this.topRelation = topRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中层关系
	 */

	@Column(name ="MID_RELATION",nullable=true,length=500)
	public String getMidRelation(){
		return this.midRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中层关系
	 */
	public void setMidRelation(String midRelation){
		this.midRelation = midRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下层关系
	 */

	@Column(name ="BOTTOM_RELATION",nullable=true,length=500)
	public String getBottomRelation(){
		return this.bottomRelation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下层关系
	 */
	public void setBottomRelation(String bottomRelation){
		this.bottomRelation = bottomRelation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当年把控度
	 */

	@Column(name ="CONTROL_DEGREE",nullable=true,length=32)
	public String getControlDegree(){
		return this.controlDegree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当年把控度
	 */
	public void setControlDegree(String controlDegree){
		this.controlDegree = controlDegree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现在及下一步计划
	 */

	@Column(name ="PROJECT_PLAN",nullable=true)
	public String getProjectPlan(){
		return this.projectPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现在及下一步计划
	 */
	public void setProjectPlan(String projectPlan){
		this.projectPlan = projectPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true,length=32)
	public String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否中标
	 */

	@Column(name ="WINNING_RESULT",nullable=true,length=4)
	public Integer getWinningResult(){
		return this.winningResult;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否中标
	 */
	public void setWinningResult(Integer winningResult){
		this.winningResult = winningResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务主表id
	 */

	@Column(name ="BUSINESS_ID",nullable=true,length=36)
	public String getBusinessId(){
		return this.businessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务主表id
	 */
	public void setBusinessId(String businessId){
		this.businessId = businessId;
	}
}
