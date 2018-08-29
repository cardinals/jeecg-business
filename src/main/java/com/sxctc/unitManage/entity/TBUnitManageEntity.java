package com.sxctc.unitManage.entity;

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
 * @Description: 厅局管理
 * @author onlineGenerator
 * @date 2018-08-23 18:23:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_unit_manage", schema = "")
@SuppressWarnings("serial")
public class TBUnitManageEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户*/
	@Excel(name="用户",width=15)
	private String userCode;
	/**单位编号*/
	@Excel(name="单位编号",width=15,dicCode="unit_name")
	private Integer unitCode;
	/**负责单位*/
	private String unitName;
	/**业务名称*/
	private String userName;
	
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
	 *@return: java.lang.String  用户
	 */

	@Column(name ="USER_CODE",nullable=true,length=32)
	public String getUserCode(){
		return this.userCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户
	 */
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  单位编号
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=10)
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
	 *@return: java.lang.String  负责单位
	 */

	@Column(name ="UNIT_NAME",nullable=true,length=50)
	public String getUnitName(){
		return this.unitName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  负责单位
	 */
	public void setUnitName(String unitName){
		this.unitName = unitName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务名称
	 */

	@Column(name ="USER_NAME",nullable=true,length=32)
	public String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务名称
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
}
