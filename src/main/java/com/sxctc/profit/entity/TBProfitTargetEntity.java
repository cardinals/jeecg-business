package com.sxctc.profit.entity;

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
 * @Description: 毛利润指标
 * @author onlineGenerator
 * @date 2018-08-24 15:53:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_profit_target", schema = "")
@SuppressWarnings("serial")
public class TBProfitTargetEntity implements java.io.Serializable {
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
	/**单位编号*/
	@Excel(name="单位编号",width=15,dicCode="unit_name")
	private Integer unitCode;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String projectName;
	/**项目令号*/
	@Excel(name="项目令号",width=15)
	private String projectOrder;
	/**项目经理*/
	@Excel(name="项目经理",width=15)
	private String projectManage;
	/**合同签订时间*/
	@Excel(name="合同签订时间",width=15,format = "yyyy-MM-dd")
	private Date signTime;
	/**合同额*/
	@Excel(name="合同额",width=15)
	private BigDecimal contractValue;
	/**毛利率*/
	@Excel(name="毛利率",width=15)
	private String profitTargetRatio;
	/**毛利润*/
	@Excel(name="毛利润",width=15)
	private BigDecimal profitTarget;
	/**确认收入额*/
	@Excel(name="确认收入额",width=15)
	private BigDecimal confirmIncome;
	/**确认收入比率*/
	@Excel(name="确认收入比率",width=15)
	private String confirmIncomeRatio;
	/**回款总额*/
	@Excel(name="回款总额",width=15)
	private BigDecimal receivedPay;
	/**回款比例*/
	@Excel(name="回款比例",width=15)
	private String receivedPayRatio;
	/**项目实施状态*/
	@Excel(name="项目实施状态",width=15)
	private Integer projectStatus;
	/**业务id*/
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
	 *@return: java.lang.Integer  单位编号
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=4)
	public Integer getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  单位编号
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目令号
	 */

	@Column(name ="PROJECT_ORDER",nullable=true,length=32)
	public String getProjectOrder(){
		return this.projectOrder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目令号
	 */
	public void setProjectOrder(String projectOrder){
		this.projectOrder = projectOrder;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目经理
	 */

	@Column(name ="PROJECT_MANAGE",nullable=true,length=32)
	public String getProjectManage(){
		return this.projectManage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目经理
	 */
	public void setProjectManage(String projectManage){
		this.projectManage = projectManage;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同签订时间
	 */

	@Column(name ="SIGN_TIME",nullable=true)
	public Date getSignTime(){
		return this.signTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同签订时间
	 */
	public void setSignTime(Date signTime){
		this.signTime = signTime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  合同额
	 */

	@Column(name ="CONTRACT_VALUE",nullable=true,length=32)
	public BigDecimal getContractValue(){
		return this.contractValue;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  合同额
	 */
	public void setContractValue(BigDecimal contractValue){
		this.contractValue = contractValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毛利率
	 */

	@Column(name ="PROFIT_TARGET_RATIO",nullable=true,length=32)
	public String getProfitTargetRatio(){
		return this.profitTargetRatio;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毛利率
	 */
	public void setProfitTargetRatio(String profitTargetRatio){
		this.profitTargetRatio = profitTargetRatio;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  毛利润
	 */

	@Column(name ="PROFIT_TARGET",nullable=true,length=32)
	public BigDecimal getProfitTarget(){
		return this.profitTarget;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  毛利润
	 */
	public void setProfitTarget(BigDecimal profitTarget){
		this.profitTarget = profitTarget;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  确认收入额
	 */

	@Column(name ="CONFIRM_INCOME",nullable=true,length=32)
	public BigDecimal getConfirmIncome(){
		return this.confirmIncome;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  确认收入额
	 */
	public void setConfirmIncome(BigDecimal confirmIncome){
		this.confirmIncome = confirmIncome;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  确认收入比率
	 */

	@Column(name ="CONFIRM_INCOME_RATIO",nullable=true,length=32)
	public String getConfirmIncomeRatio(){
		return this.confirmIncomeRatio;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  确认收入比率
	 */
	public void setConfirmIncomeRatio(String confirmIncomeRatio){
		this.confirmIncomeRatio = confirmIncomeRatio;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  回款总额
	 */

	@Column(name ="RECEIVED_PAY",nullable=true,length=32)
	public BigDecimal getReceivedPay(){
		return this.receivedPay;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  回款总额
	 */
	public void setReceivedPay(BigDecimal receivedPay){
		this.receivedPay = receivedPay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  回款比例
	 */

	@Column(name ="RECEIVED_PAY_RATIO",nullable=true,length=32)
	public String getReceivedPayRatio(){
		return this.receivedPayRatio;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回款比例
	 */
	public void setReceivedPayRatio(String receivedPayRatio){
		this.receivedPayRatio = receivedPayRatio;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  项目实施状态
	 */

	@Column(name ="PROJECT_STATUS",nullable=true,length=4)
	public Integer getProjectStatus(){
		return this.projectStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  项目实施状态
	 */
	public void setProjectStatus(Integer projectStatus){
		this.projectStatus = projectStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务id
	 */

	@Column(name ="BUSINESS_ID",nullable=true,length=36)
	public String getBusinessId(){
		return this.businessId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务id
	 */
	public void setBusinessId(String businessId){
		this.businessId = businessId;
	}
}
