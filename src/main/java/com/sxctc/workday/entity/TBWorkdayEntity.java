package com.sxctc.workday.entity;

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
 * @Description: 日报信息管理
 * @author onlineGenerator
 * @date 2018-08-02 10:14:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_workday", schema = "")
@SuppressWarnings("serial")
public class TBWorkdayEntity implements java.io.Serializable {
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
	/**项目单位名称*/
	@Excel(name="项目单位名称",width=15)
	private String xiangmudanwei;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String xiangmu;
	/**今日工作内容*/
	@Excel(name="今日工作内容",width=15)
	private String jinri;
	/**今日工作总结*/
	@Excel(name="今日工作总结",width=15)
	private String jinrizongjie;
	/**明天工作计划*/
	@Excel(name="明天工作计划",width=15)
	private String tojihua;
	/**需要帮助和支持*/
	@Excel(name="需要帮助和支持",width=15)
	private String xvyao;
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
	 *@return: java.lang.String  项目单位名称
	 */

	@Column(name ="XIANGMUDANWEI",nullable=true,length=32)
	public String getXiangmudanwei(){
		return this.xiangmudanwei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目单位名称
	 */
	public void setXiangmudanwei(String xiangmudanwei){
		this.xiangmudanwei = xiangmudanwei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="XIANGMU",nullable=true,length=128)
	public String getXiangmu(){
		return this.xiangmu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setXiangmu(String xiangmu){
		this.xiangmu = xiangmu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  今日工作内容
	 */

	@Column(name ="JINRI",nullable=true,length=256)
	public String getJinri(){
		return this.jinri;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  今日工作内容
	 */
	public void setJinri(String jinri){
		this.jinri = jinri;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  今日工作总结
	 */

	@Column(name ="JINRIZONGJIE",nullable=true,length=256)
	public String getJinrizongjie(){
		return this.jinrizongjie;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  今日工作总结
	 */
	public void setJinrizongjie(String jinrizongjie){
		this.jinrizongjie = jinrizongjie;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  明天工作计划
	 */

	@Column(name ="TOJIHUA",nullable=true,length=256)
	public String getTojihua(){
		return this.tojihua;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  明天工作计划
	 */
	public void setTojihua(String tojihua){
		this.tojihua = tojihua;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  需要帮助和支持
	 */

	@Column(name ="XVYAO",nullable=true,length=256)
	public String getXvyao(){
		return this.xvyao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  需要帮助和支持
	 */
	public void setXvyao(String xvyao){
		this.xvyao = xvyao;
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
