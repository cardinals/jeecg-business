package com.sxctc.finalform.entity;

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
 * @Description: 财务报表导出
 * @author onlineGenerator
 * @date 2018-09-05 15:23:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_finalform_export", schema = "")
@SuppressWarnings("serial")
public class TBFinalformExportEntity implements java.io.Serializable {
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
	@Excel(name="单位名称",width=15)
	private Integer unitCode;
	/**系统名称*/
	@Excel(name="系统名称",width=15)
	private String systemName;
	/**上云收入*/
	@Excel(name="上云收入",width=15)
	private String cloudCount;
	/**项目收入*/
	@Excel(name="项目收入",width=15)
	private String projectCount;
	/**合计收入*/
	@Excel(name="合计收入",width=15)
	private String totalCount;

	/**自定义字段*/
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
	 *@return: java.lang.String  系统名称
	 */

	@Column(name ="SYSTEM_NAME",nullable=true,length=32)
	public String getSystemName(){
		return this.systemName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统名称
	 */
	public void setSystemName(String systemName){
		this.systemName = systemName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上云收入
	 */

	@Column(name ="CLOUD_COUNT",nullable=true,length=32)
	public String getCloudCount(){
		return this.cloudCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上云收入
	 */
	public void setCloudCount(String cloudCount){
		this.cloudCount = cloudCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目收入
	 */

	@Column(name ="PROJECT_COUNT",nullable=true,length=32)
	public String getProjectCount(){
		return this.projectCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目收入
	 */
	public void setProjectCount(String projectCount){
		this.projectCount = projectCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合计收入
	 */

	@Column(name ="TOTAL_COUNT",nullable=true,length=32)
	public String getTotalCount(){
		return this.totalCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合计收入
	 */
	public void setTotalCount(String totalCount){
		this.totalCount = totalCount;
	}

	@Transient
	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
}
