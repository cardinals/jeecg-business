package com.sxctc.business.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 营销数据业务列表
 * @author onlineGenerator
 * @date 2018-08-21 17:11:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_business", schema = "")
@SuppressWarnings("serial")
public class TBBusinessEntity implements java.io.Serializable {
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
	/**流程状态*/
	private String bpmStatus;
	/**厅局编号*/
	@Excel(name="厅局编号",width=15,dicCode="unit_name")
	private Integer unitCode;
	/**厅局名称*/
	private String unitName;
	/**迁移系统编号*/
	private String projectCode;
	/**迁移系统名称*/
	@Excel(name="迁移系统名称",width=15)
	private String projectName;
	/**系统类型*/
	@Excel(name="系统类型",width=15,dicCode="proj_type")
	private Integer projectStatus;
	/**是否上云*/
	@Excel(name="是否上云",width=15,dicCode="dev_flag")
	private Integer cloudStatus;
	/**是否有机会*/
	@Excel(name="是否有机会",width=15,dicCode="dev_flag")
	private Integer chanceStatus;
	/**对接状态*/
	@Excel(name="对接状态",width=15,dicCode="joinStatus")
	private Integer joinStatus;
	/**业务创建时间*/
	@Excel(name="业务创建时间",width=15,format = "yyyy-MM-dd")
	private Date busCreateTime;
	/**上云对接时间*/
	@Excel(name="上云对接时间",width=15,format = "yyyy-MM-dd")
	private Date busJoinTime;
	/**硬件服务目录*/
	private String hardServeCatalog;
	/**基础层服务目录*/
	private String baseServeCatalog;
	/**是否收回协议*/
	@Excel(name="是否收回协议",width=15,dicCode="dev_flag")
	private Integer protocolStatus;
	/**收回协议时间*/
	@Excel(name="收回协议时间",width=15,format = "yyyy-MM-dd")
	private Date protocolTime;
	/**是否在审计范围*/
	private Integer auditStatus;
	/**需求确认时间*/
	private Date demandTime;
	/**迁移方案时间*/
	private Date planTime;
	/**开通云资源时间*/
	private Date resourceTime;
	/**部署测试时间*/
	private Date testTime;
	/**上云完成时间*/
	private Date finishTime;
	/**资金来源*/
	private Integer fundsProvided;
	/**时间跨越*/
	@Excel(name="时间跨越",width=15)
	private Integer dayRange;

	/**自定义返回参数*/
	/**总收入*/
	private BigDecimal total;
	/**服务目录当年选用数量*/
	private Integer sum;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  厅局编号
	 */

	@Column(name ="UNIT_CODE",nullable=false,length=32)
	public Integer getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  厅局编号
	 */
	public void setUnitCode(Integer unitCode){
		this.unitCode = unitCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厅局名称
	 */

	@Column(name ="UNIT_NAME",nullable=false,length=32)
	public String getUnitName(){
		return this.unitName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厅局名称
	 */
	public void setUnitName(String unitName){
		this.unitName = unitName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  迁移系统编号
	 */

	@Column(name ="PROJECT_CODE",nullable=true,length=32)
	public String getProjectCode(){
		return this.projectCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  迁移系统编号
	 */
	public void setProjectCode(String projectCode){
		this.projectCode = projectCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  迁移系统名称
	 */

	@Column(name ="PROJECT_NAME",nullable=false,length=32)
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  迁移系统名称
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  系统类型
	 */

	@Column(name ="PROJECT_STATUS",nullable=false,length=32)
	public Integer getProjectStatus(){
		return this.projectStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  系统类型
	 */
	public void setProjectStatus(Integer projectStatus){
		this.projectStatus = projectStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否上云
	 */

	@Column(name ="CLOUD_STATUS",nullable=true,length=32)
	public Integer getCloudStatus(){
		return this.cloudStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否上云
	 */
	public void setCloudStatus(Integer cloudStatus){
		this.cloudStatus = cloudStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否有机会
	 */

	@Column(name ="CHANCE_STATUS",nullable=false,length=32)
	public Integer getChanceStatus(){
		return this.chanceStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否有机会
	 */
	public void setChanceStatus(Integer chanceStatus){
		this.chanceStatus = chanceStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  对接状态
	 */

	@Column(name ="JOIN_STATUS",nullable=false,length=32)
	public Integer getJoinStatus(){
		return this.joinStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  对接状态
	 */
	public void setJoinStatus(Integer joinStatus){
		this.joinStatus = joinStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  业务创建时间
	 */

	@Column(name ="BUS_CREATE_TIME",nullable=false,length=32)
	public Date getBusCreateTime(){
		return this.busCreateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  业务创建时间
	 */
	public void setBusCreateTime(Date busCreateTime){
		this.busCreateTime = busCreateTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上云对接时间
	 */

	@Column(name ="BUS_JOIN_TIME",nullable=true,length=32)
	public Date getBusJoinTime(){
		return this.busJoinTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上云对接时间
	 */
	public void setBusJoinTime(Date busJoinTime){
		this.busJoinTime = busJoinTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  硬件服务目录
	 */

	@Column(name ="HARD_SERVE_CATALOG",nullable=true,length=500)
	public String getHardServeCatalog(){
		return this.hardServeCatalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  硬件服务目录
	 */
	public void setHardServeCatalog(String hardServeCatalog){
		this.hardServeCatalog = hardServeCatalog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基础层服务目录
	 */

	@Column(name ="BASE_SERVE_CATALOG",nullable=true,length=500)
	public String getBaseServeCatalog(){
		return this.baseServeCatalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基础层服务目录
	 */
	public void setBaseServeCatalog(String baseServeCatalog){
		this.baseServeCatalog = baseServeCatalog;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否收回协议
	 */

	@Column(name ="PROTOCOL_STATUS",nullable=true,length=32)
	public Integer getProtocolStatus(){
		return this.protocolStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否收回协议
	 */
	public void setProtocolStatus(Integer protocolStatus){
		this.protocolStatus = protocolStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  收回协议时间
	 */

	@Column(name ="PROTOCOL_TIME",nullable=true,length=32)
	public Date getProtocolTime(){
		return this.protocolTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  收回协议时间
	 */
	public void setProtocolTime(Date protocolTime){
		this.protocolTime = protocolTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否在审计范围
	 */

	@Column(name ="AUDIT_STATUS",nullable=true,length=32)
	public Integer getAuditStatus(){
		return this.auditStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否在审计范围
	 */
	public void setAuditStatus(Integer auditStatus){
		this.auditStatus = auditStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  需求确认时间
	 */

	@Column(name ="DEMAND_TIME",nullable=true,length=32)
	public Date getDemandTime(){
		return this.demandTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  需求确认时间
	 */
	public void setDemandTime(Date demandTime){
		this.demandTime = demandTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  迁移方案时间
	 */

	@Column(name ="PLAN_TIME",nullable=true,length=32)
	public Date getPlanTime(){
		return this.planTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  迁移方案时间
	 */
	public void setPlanTime(Date planTime){
		this.planTime = planTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开通云资源时间
	 */

	@Column(name ="RESOURCE_TIME",nullable=true,length=32)
	public Date getResourceTime(){
		return this.resourceTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开通云资源时间
	 */
	public void setResourceTime(Date resourceTime){
		this.resourceTime = resourceTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  部署测试时间
	 */

	@Column(name ="TEST_TIME",nullable=true,length=32)
	public Date getTestTime(){
		return this.testTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  部署测试时间
	 */
	public void setTestTime(Date testTime){
		this.testTime = testTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上云完成时间
	 */

	@Column(name ="FINISH_TIME",nullable=true,length=32)
	public Date getFinishTime(){
		return this.finishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上云完成时间
	 */
	public void setFinishTime(Date finishTime){
		this.finishTime = finishTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  资金来源
	 */

	@Column(name ="FUNDS_PROVIDED",nullable=true,length=32)
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时间跨越
	 */

	@Column(name ="DAY_RANGE",nullable=true,length=32)
	public Integer getDayRange(){
		return this.dayRange;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时间跨越
	 */
	public void setDayRange(Integer dayRange){
		this.dayRange = dayRange;
	}

	@Transient
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Transient
	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
}
