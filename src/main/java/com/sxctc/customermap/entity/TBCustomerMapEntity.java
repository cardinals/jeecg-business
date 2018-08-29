package com.sxctc.customermap.entity;

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
 * @Description: 客户地图
 * @author onlineGenerator
 * @date 2018-08-24 16:41:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_customer_map", schema = "")
@SuppressWarnings("serial")
public class TBCustomerMapEntity implements java.io.Serializable {
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
	/**价值低*/
	@Excel(name="价值低",width=15)
	private String worthLow;
	/**价值中*/
	@Excel(name="价值中",width=15)
	private String worthMid;
	/**价值高*/
	@Excel(name="价值高",width=15)
	private String worthHigh;
	/**合作状态*/
	@Excel(name="合作状态",width=15,dicCode="cooperate")
	private Integer cooperateStatus;
	/**业务id*/
	private String businessId;
	/**单位编号*/
	private Integer unitCode;
	
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
	 *@return: java.lang.String  价值低
	 */

	@Column(name ="WORTH_LOW",nullable=true,length=50)
	public String getWorthLow(){
		return this.worthLow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价值低
	 */
	public void setWorthLow(String worthLow){
		this.worthLow = worthLow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价值中
	 */

	@Column(name ="WORTH_MID",nullable=true,length=50)
	public String getWorthMid(){
		return this.worthMid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价值中
	 */
	public void setWorthMid(String worthMid){
		this.worthMid = worthMid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价值高
	 */

	@Column(name ="WORTH_HIGH",nullable=true,length=50)
	public String getWorthHigh(){
		return this.worthHigh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价值高
	 */
	public void setWorthHigh(String worthHigh){
		this.worthHigh = worthHigh;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  合作状态
	 */

	@Column(name ="COOPERATE_STATUS",nullable=true,length=4)
	public Integer getCooperateStatus(){
		return this.cooperateStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  合作状态
	 */
	public void setCooperateStatus(Integer cooperateStatus){
		this.cooperateStatus = cooperateStatus;
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
}
