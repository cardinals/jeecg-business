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
 * @Description: 服务目录业务关联表
 * @author onlineGenerator
 * @date 2018-08-05 16:48:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_busi_catalog", schema = "")
@SuppressWarnings("serial")
public class TBBusiCatalogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**所选服务目录id*/
	@Excel(name="所选服务目录id",width=15)
	private String catalogId;
	/**业务id*/
	@Excel(name="业务id",width=15)
	private String businessId;
	/**服务目录选择数量*/
	@Excel(name="服务目录选择数量",width=15)
	private Integer checkNum;
	
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
	 *@return: java.lang.String  所选服务目录id
	 */

	@Column(name ="CATALOG_ID",nullable=false,length=36)
	public String getCatalogId(){
		return this.catalogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所选服务目录id
	 */
	public void setCatalogId(String catalogId){
		this.catalogId = catalogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务id
	 */

	@Column(name ="BUSINESS_ID",nullable=false,length=36)
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
	 *@return: java.lang.Integer  服务目录选择数量
	 */

	@Column(name ="CHECK_NUM",nullable=true,length=32)
	public Integer getCheckNum(){
		return this.checkNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  服务目录选择数量
	 */
	public void setCheckNum(Integer checkNum){
		this.checkNum = checkNum;
	}
}
