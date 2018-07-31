package com.sxctc.business.entity;

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
 * @Description: 营销数据业务主表
 * @author onlineGenerator
 * @date 2018-07-28 10:40:10
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
	private Integer unitCode;
	/**厅局名称*/
	@Excel(name="厅局名称",width=15)
	private String unitName;
	/**迁移系统编号*/
	private String projectCode;
	/**迁移系统名称*/
	@Excel(name="迁移系统名称",width=15)
	private String projectName;
	/**系统类型*/
	@Excel(name="系统类型",width=15)
	private Integer projectStatus;
	/**是否上云*/
	@Excel(name="是否上云",width=15)
	private Integer cloudStatus;
	/**是否有机会*/
	@Excel(name="是否有机会",width=15)
	private Integer chanceStatus;
	/**对接状态*/
	@Excel(name="对接状态",width=15)
	private Integer joinStatus;
	/**业务创建时间*/
	@Excel(name="业务创建时间",width=15,format = "yyyy-MM-dd")
	private Date busCreateTime;
	/**业务对接时间*/
	@Excel(name="业务对接时间",width=15,format = "yyyy-MM-dd")
	private Date busJoinTime;
	/**硬件服务目录*/
	@Excel(name="硬件服务目录",width=15)
	private String hardServeCatalog;
	/**基础层服务目录*/
	@Excel(name="基础层服务目录",width=15)
	private String baseServeCatalog;
	/**是否收回协议*/
	@Excel(name="是否收回协议",width=15)
	private Integer protocolStatus;
	/**收回协议时间*/
	@Excel(name="收回协议时间",width=15,format = "yyyy-MM-dd")
	private Date protocolTime;
	/**是否在审计范围*/
	@Excel(name="是否在审计范围",width=15)
	private Integer auditStatus;
	/**备用字段1*/
	private String backupField1;
	/**备用字段2*/
	private String backupField2;
	/**备用字段3*/
	private String backupField3;
	/**备用字段4*/
	private String backupField4;
	/**备用字段5*/
	private String backupField5;
	/**备用字段6*/
	private String backupField6;
	
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

	@Column(name ="CLOUD_STATUS",nullable=false,length=32)
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
	 *@return: java.util.Date  业务对接时间
	 */

	@Column(name ="BUS_JOIN_TIME",nullable=true,length=32)
	public Date getBusJoinTime(){
		return this.busJoinTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  业务对接时间
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段1
	 */

	@Column(name ="BACKUP_FIELD1",nullable=true,length=32)
	public String getBackupField1(){
		return this.backupField1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段1
	 */
	public void setBackupField1(String backupField1){
		this.backupField1 = backupField1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段2
	 */

	@Column(name ="BACKUP_FIELD2",nullable=true,length=32)
	public String getBackupField2(){
		return this.backupField2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段2
	 */
	public void setBackupField2(String backupField2){
		this.backupField2 = backupField2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段3
	 */

	@Column(name ="BACKUP_FIELD3",nullable=true,length=32)
	public String getBackupField3(){
		return this.backupField3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段3
	 */
	public void setBackupField3(String backupField3){
		this.backupField3 = backupField3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段4
	 */

	@Column(name ="BACKUP_FIELD4",nullable=true,length=32)
	public String getBackupField4(){
		return this.backupField4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段4
	 */
	public void setBackupField4(String backupField4){
		this.backupField4 = backupField4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段5
	 */

	@Column(name ="BACKUP_FIELD5",nullable=true,length=32)
	public String getBackupField5(){
		return this.backupField5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段5
	 */
	public void setBackupField5(String backupField5){
		this.backupField5 = backupField5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备用字段6
	 */

	@Column(name ="BACKUP_FIELD6",nullable=true,length=32)
	public String getBackupField6(){
		return this.backupField6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备用字段6
	 */
	public void setBackupField6(String backupField6){
		this.backupField6 = backupField6;
	}
}
