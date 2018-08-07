package com.sxctc.catalogt.entity;

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
 * @Description: 服务目录管理
 * @author onlineGenerator
 * @date 2018-08-07 16:03:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_catalogdata", schema = "")
@SuppressWarnings("serial")
public class TBCatalogdataEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**名称*/
	@Excel(name="名称",width=15)
	private String name;
	/**单位*/
	@Excel(name="单位",width=15)
	private String danwei;
	/**父节点ID*/
	@Excel(name="父节点ID",width=15)
	private String fartherid;
	/**数量*/
	@Excel(name="数量",width=15)
	private Integer num;
	/**备注*/
	@Excel(name="备注",width=15)
	private String beizhu;
	/**类型*/
	@Excel(name="类型",width=15)
	private String type;
	
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
	 *@return: java.lang.String  名称
	 */

	@Column(name ="NAME",nullable=true,length=32)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="DANWEI",nullable=true,length=32)
	public String getDanwei(){
		return this.danwei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setDanwei(String danwei){
		this.danwei = danwei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  父节点ID
	 */

	@Column(name ="FARTHERID",nullable=true,length=32)
	public String getFartherid(){
		return this.fartherid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父节点ID
	 */
	public void setFartherid(String fartherid){
		this.fartherid = fartherid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */

	@Column(name ="NUM",nullable=true,length=32)
	public Integer getNum(){
		return this.num;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setNum(Integer num){
		this.num = num;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="BEIZHU",nullable=true,length=64)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */

	@Column(name ="TYPE",nullable=true,length=32)
	public String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setType(String type){
		this.type = type;
	}
}
