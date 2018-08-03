package com.sxctc.workdays.entity;

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
 * @Description: 日报管理
 * @author onlineGenerator
 * @date 2018-08-03 09:42:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_workreportday", schema = "")
@SuppressWarnings("serial")
public class TBWorkreportdayEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	@Excel(name="创建人名称",width=15)
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private Date createDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**厅局单位*/
	@Excel(name="厅局单位",width=15,dicCode="unit_name")
	private String tingjvdanweiName;
	/**系统名称*/
	@Excel(name="系统名称",width=15)
	private String xitongName;
	/**今日工作内容*/
	@Excel(name="今日工作内容",width=15)
	private String workDay;
	/**明日工作计划*/
	@Excel(name="明日工作计划",width=15)
	private String tomDay;
	/**今日工作计划*/
	@Excel(name="今日工作计划",width=15)
	private String workDays;
	/**需要的帮助和支持*/
	@Excel(name="需要的帮助和支持",width=15)
	private String bangZhu;
	/**备注*/
	@Excel(name="备注",width=15)
	private String beizhu;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厅局单位
	 */

	@Column(name ="TINGJVDANWEI_NAME",nullable=true,length=32)
	public String getTingjvdanweiName(){
		return this.tingjvdanweiName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厅局单位
	 */
	public void setTingjvdanweiName(String tingjvdanweiName){
		this.tingjvdanweiName = tingjvdanweiName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系统名称
	 */

	@Column(name ="XITONG_NAME",nullable=true,length=32)
	public String getXitongName(){
		return this.xitongName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统名称
	 */
	public void setXitongName(String xitongName){
		this.xitongName = xitongName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  今日工作内容
	 */

	@Column(name ="WORK_DAY",nullable=true,length=256)
	public String getWorkDay(){
		return this.workDay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  今日工作内容
	 */
	public void setWorkDay(String workDay){
		this.workDay = workDay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  明日工作计划
	 */

	@Column(name ="TOM_DAY",nullable=true,length=256)
	public String getTomDay(){
		return this.tomDay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  明日工作计划
	 */
	public void setTomDay(String tomDay){
		this.tomDay = tomDay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  今日工作计划
	 */

	@Column(name ="WORK_DAYS",nullable=true,length=256)
	public String getWorkDays(){
		return this.workDays;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  今日工作计划
	 */
	public void setWorkDays(String workDays){
		this.workDays = workDays;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需要的帮助和支持
	 */

	@Column(name ="BANG_ZHU",nullable=true,length=256)
	public String getBangZhu(){
		return this.bangZhu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需要的帮助和支持
	 */
	public void setBangZhu(String bangZhu){
		this.bangZhu = bangZhu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BEIZHU",nullable=true,length=256)
	public String getBeizhu(){
		return this.beizhu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBeizhu(String beizhu){
		this.beizhu = beizhu;
	}
}
