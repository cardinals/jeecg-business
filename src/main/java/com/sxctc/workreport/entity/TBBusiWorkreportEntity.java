package com.sxctc.workreport.entity;

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
 * @Description: 今日日报列表
 * @author onlineGenerator
 * @date 2018-08-08 11:29:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_busi_workreport", schema = "")
@SuppressWarnings("serial")
public class TBBusiWorkreportEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	@Excel(name="人员名称",width=15,mergeVertical = true)
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
	/**厅局编号*/
	@Excel(name="单位名称",width=30,dicCode = "unit_name",mergeVertical = true)
	private String unitCode;
	/**厅局名称*/
	@Excel(name="系统名称",width=30)
	private String reportTitle;
	/**今日时间*/
	@Excel(name="日报时间",width=15,format = "yyyy-MM-dd")
	private Date reportDate;
	/**完成工作*/
	@Excel(name="完成工作",width=15)
	private String doneToday;
	/**未完成工作*/
	@Excel(name="未完成工作",width=15)
	private String unDoneToday;
	/**协调工作*/
	@Excel(name="协调工作",width=15)
	private String coordinateWork;
	/**日报类型*/
	private Integer reportType;
	/**业务id*/
	private String businessId;
	/**备注*/
	@Excel(name="备注",width=15)
	private String remark;

	/**自定义字段*/
	/**未跟踪时间*/
	private Integer unFollowDay;
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
	 *@return: java.lang.String  厅局编号
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=4)
	public String getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厅局编号
	 */
	public void setUnitCode(String unitCode){
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
	 *@return: java.util.Date  今日时间
	 */

	@Column(name ="REPORT_DATE",nullable=true,length=20)
	public Date getReportDate(){
		return this.reportDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  今日时间
	 */
	public void setReportDate(Date reportDate){
		this.reportDate = reportDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  完成工作
	 */

	@Column(name ="DONE_TODAY",nullable=true,length=300)
	public String getDoneToday(){
		return this.doneToday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  完成工作
	 */
	public void setDoneToday(String doneToday){
		this.doneToday = doneToday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  未完成工作
	 */

	@Column(name ="UN_DONE_TODAY",nullable=true,length=300)
	public String getUnDoneToday(){
		return this.unDoneToday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  未完成工作
	 */
	public void setUnDoneToday(String unDoneToday){
		this.unDoneToday = unDoneToday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  协调工作
	 */

	@Column(name ="COORDINATE_WORK",nullable=true,length=300)
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
	 *@return: java.lang.Integer  日报类型
	 */

	@Column(name ="REPORT_TYPE",nullable=true,length=4)
	public Integer getReportType(){
		return this.reportType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  日报类型
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
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true,length=300)
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

	@Transient
	public Integer getUnFollowDay() {
		return unFollowDay;
	}

	public void setUnFollowDay(Integer unFollowDay) {
		this.unFollowDay = unFollowDay;
	}
}
