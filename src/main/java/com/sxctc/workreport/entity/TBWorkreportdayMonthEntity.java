package com.sxctc.workreport.entity;

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
 * @Description: 月报
 * @author onlineGenerator
 * @date 2018-08-29 15:11:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_workreportday_month", schema = "")
@SuppressWarnings("serial")
public class TBWorkreportdayMonthEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
//	/**更新人名称*/
//	private String updateName;
//	/**更新人登录名称*/
//	private String updateBy;
//	/**更新日期*/
//	private Date updateDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**厅局编号*/
	@Excel(name="厅局编号",width=15,dicCode="unit_name")
	private Integer unitCode;
	/**厅局名称*/
	@Excel(name="厅局名称",width=15)
	private String reportTitle;
	/**月份*/
	@Excel(name="月份",width=15,format = "yyyy-MM-dd")
	private Date reportDate;
	/**本月工作工作*/
	@Excel(name="本月工作工作",width=15)
	private String doneToday;
	/**下月工作计划*/
	@Excel(name="下月工作计划",width=15)
	private String nextDone;
	/**协调工作*/
	@Excel(name="协调工作",width=15)
	private String coordinateWork;
	/**日志类型*/
	private Integer reportType;
	/**业务id*/
	private String businessId;
	/**工作总结*/
	@Excel(name="工作总结",width=15)
	private String workSum;
	/**所属系统id*/
	private String fatherId;
	
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
	 *@return: java.lang.Integer  厅局编号
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=4)
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

	@Column(name ="REPORT_TITLE",nullable=true,length=32)
	public String getReportTitle(){
		return this.reportTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厅局名称
	 */
	public void setReportTitle(String reportTitle){
		this.reportTitle = reportTitle;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  月份
	 */

	@Column(name ="REPORT_DATE",nullable=true)
	public Date getReportDate(){
		return this.reportDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  月份
	 */
	public void setReportDate(Date reportDate){
		this.reportDate = reportDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本月工作工作
	 */

	@Column(name ="DONE_TODAY",nullable=true)
	public String getDoneToday(){
		return this.doneToday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本月工作工作
	 */
	public void setDoneToday(String doneToday){
		this.doneToday = doneToday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下月工作计划
	 */

	@Column(name ="NEXT_DONE",nullable=true)
	public String getNextDone(){
		return this.nextDone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下月工作计划
	 */
	public void setNextDone(String nextDone){
		this.nextDone = nextDone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  协调工作
	 */

	@Column(name ="COORDINATE_WORK",nullable=true)
	public String getCoordinateWork(){
		return this.coordinateWork;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  协调工作
	 */
	public void setCoordinateWork(String coordinateWork){
		this.coordinateWork = coordinateWork;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  日志类型
	 */

	@Column(name ="REPORT_TYPE",nullable=true,length=4)
	public Integer getReportType(){
		return this.reportType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  日志类型
	 */
	public void setReportType(Integer reportType){
		this.reportType = reportType;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作总结
	 */

	@Column(name ="WORK_SUM",nullable=true)
	public String getWorkSum(){
		return this.workSum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作总结
	 */
	public void setWorkSum(String workSum){
		this.workSum = workSum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属系统id
	 */

	@Column(name ="father_id",nullable=true,length=36)
	public String getFatherId() { return fatherId; }

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属系统id
	 */
	public void setFatherId(String fatherId) { this.fatherId = fatherId; }
}
