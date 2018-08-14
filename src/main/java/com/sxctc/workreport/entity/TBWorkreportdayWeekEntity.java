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
 * @Description: 周报
 * @author onlineGenerator
 * @date 2018-08-13 10:00:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_workreportday_week", schema = "")
@SuppressWarnings("serial")
public class TBWorkreportdayWeekEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**厅局单位*/
	@Excel(name="厅局单位",width=15)
	private String unitCode;
	/**迁移系统名称*/
	@Excel(name="迁移系统名称",width=15)
	private String projectName;
	/**今日完成的工作*/
	@Excel(name="今日完成的工作",width=15)
	private String doneDay;
	/**未完成的工作*/
	@Excel(name="未完成的工作",width=15)
	private String unDoneDay;
	/**需要协调的工作*/
	@Excel(name="需要协调的工作",width=15)
	private String coordinateWork;
	/**备注*/
	@Excel(name="备注",width=15)
	private String remark;
	/**日志业务关联表id*/
	private String busiReportId;
	/**周报日期开始*/
	@Excel(name="周报日期开始",width=15,format = "yyyy-MM-dd")
	private Date reportStartDate;
	/**周报日期结束*/
	@Excel(name="周报日期结束",width=15,format = "yyyy-MM-dd")
	private Date reportEndDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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

	@Column(name ="CREATE_DATE",nullable=true)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厅局单位
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=32)
	public String getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厅局单位
	 */
	public void setUnitCode(String unitCode){
		this.unitCode = unitCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  迁移系统名称
	 */

	@Column(name ="PROJECT_NAME",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  今日完成的工作
	 */

	@Column(name ="DONE_DAY",nullable=true)
	public String getDoneDay(){
		return this.doneDay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  今日完成的工作
	 */
	public void setDoneDay(String doneDay){
		this.doneDay = doneDay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  未完成的工作
	 */

	@Column(name ="UN_DONE_DAY",nullable=true)
	public String getUnDoneDay(){
		return this.unDoneDay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  未完成的工作
	 */
	public void setUnDoneDay(String unDoneDay){
		this.unDoneDay = unDoneDay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需要协调的工作
	 */

	@Column(name ="COORDINATE_WORK",nullable=true)
	public String getCoordinateWork(){
		return this.coordinateWork;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需要协调的工作
	 */
	public void setCoordinateWork(String coordinateWork){
		this.coordinateWork = coordinateWork;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="REMARK",nullable=true)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  日志业务关联表id
	 */

	@Column(name ="BUSI_REPORT_ID",nullable=true,length=36)
	public String getBusiReportId(){
		return this.busiReportId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  日志业务关联表id
	 */
	public void setBusiReportId(String busiReportId){
		this.busiReportId = busiReportId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  周报日期开始
	 */

	@Column(name ="REPORT_START_DATE",nullable=true)
	public Date getReportStartDate(){
		return this.reportStartDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  周报日期开始
	 */
	public void setReportStartDate(Date reportStartDate){
		this.reportStartDate = reportStartDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  周报日期结束
	 */

	@Column(name ="REPORT_END_DATE",nullable=true)
	public Date getReportEndDate(){
		return this.reportEndDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  周报日期结束
	 */
	public void setReportEndDate(Date reportEndDate){
		this.reportEndDate = reportEndDate;
	}
}
