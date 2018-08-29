package com.sxctc.businessoppty.entity;

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
 * @Description: 商机评估
 * @author onlineGenerator
 * @date 2018-08-27 17:26:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_business_oppty", schema = "")
@SuppressWarnings("serial")
public class TBBusinessOpptyEntity implements java.io.Serializable {
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
	/**赢单区间*/
	private Integer opptyRange;
	/**评估值1win*/
	@Excel(name="评估值1win",width=15)
	private String evaluateWin;
	/**评估值3first*/
	@Excel(name="评估值3first",width=15)
	private String evaluateFirst;
	/**评估值9confirm*/
	@Excel(name="评估值9confirm",width=15)
	private String evaluateConfirm;
	/**赢单率*/
	private String opptyRatio;
	/**制胜拐点*/
	private Integer opptyPoint;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String projectName;
	/**单位编号*/
	private Integer unitCode;
	/**业务id*/
	private String businessId;
	/**排序id*/
	@Excel(name="排序id",width=15)
	private Integer sortNum;
	/**业务状态*/
	@Excel(name="业务状态",width=15)
	private Integer businessStatus;
	
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
	 *@return: java.lang.Integer  赢单区间
	 */

	@Column(name ="OPPTY_RANGE",nullable=true,length=4)
	public Integer getOpptyRange(){
		return this.opptyRange;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  赢单区间
	 */
	public void setOpptyRange(Integer opptyRange){
		this.opptyRange = opptyRange;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评估值1win
	 */

	@Column(name ="EVALUATE_WIN",nullable=true,length=10)
	public String getEvaluateWin(){
		return this.evaluateWin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评估值1win
	 */
	public void setEvaluateWin(String evaluateWin){
		this.evaluateWin = evaluateWin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评估值3first
	 */

	@Column(name ="EVALUATE_FIRST",nullable=true,length=10)
	public String getEvaluateFirst(){
		return this.evaluateFirst;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评估值3first
	 */
	public void setEvaluateFirst(String evaluateFirst){
		this.evaluateFirst = evaluateFirst;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评估值9confirm
	 */

	@Column(name ="EVALUATE_CONFIRM",nullable=true,length=10)
	public String getEvaluateConfirm(){
		return this.evaluateConfirm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评估值9confirm
	 */
	public void setEvaluateConfirm(String evaluateConfirm){
		this.evaluateConfirm = evaluateConfirm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赢单率
	 */

	@Column(name ="OPPTY_RATIO",nullable=true,length=10)
	public String getOpptyRatio(){
		return this.opptyRatio;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赢单率
	 */
	public void setOpptyRatio(String opptyRatio){
		this.opptyRatio = opptyRatio;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  制胜拐点
	 */

	@Column(name ="OPPTY_POINT",nullable=true,length=4)
	public Integer getOpptyPoint(){
		return this.opptyPoint;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  制胜拐点
	 */
	public void setOpptyPoint(Integer opptyPoint){
		this.opptyPoint = opptyPoint;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="PROJECT_NAME",nullable=true,length=50)
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
	 *@return: java.lang.Integer  排序id
	 */

	@Column(name ="SORT_NUM",nullable=true,length=4)
	public Integer getSortNum(){
		return this.sortNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序id
	 */
	public void setSortNum(Integer sortNum){
		this.sortNum = sortNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  业务状态
	 */

	@Column(name ="BUSINESS_STATUS",nullable=true,length=4)
	public Integer getBusinessStatus(){
		return this.businessStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  业务状态
	 */
	public void setBusinessStatus(Integer businessStatus){
		this.businessStatus = businessStatus;
	}
}
