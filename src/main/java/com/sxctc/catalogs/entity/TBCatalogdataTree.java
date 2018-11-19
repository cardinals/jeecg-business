package com.sxctc.catalogs.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.web.system.pojo.base.TSDepart;

/**
 * @Title: Entity
 * @Description: 服务目录管理
 * @author onlineGenerator
 * @date 2018-08-31 15:49:03
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_b_catalogdata", schema = "")
@SuppressWarnings("serial")
public class TBCatalogdataTree extends IdEntity implements java.io.Serializable {
    /**主键*/
//	private String id;
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
    @Excel(name="类型",width=15,dicCode="catatype")
    private String type;
    /**单价*/
    @Excel(name="单价",width=15)
    private BigDecimal price;
    /**单价汇总*/
    @Excel(name="单价汇总",width=15)
    private String priceJson;
    /**服务目录状态*/
    @Excel(name="服务目录状态",width=15)
    private Integer status;
    /**服务目录编码*/
    @Excel(name="服务目录编码",width=15)
    private String catalogCode;
    /**节点ID*/
    @Excel(name="节点ID",width=15)
    private Integer nodeId;

    /**自定义参数*/
    private BigDecimal total;

    /**上级目录*/
    private TBCatalogdataTree TBPCatalogdata;

    /**下属目录*/
    private List<TBCatalogdataTree> TBCatalogdatas = new ArrayList<TBCatalogdataTree>();//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fartherid")
    public TBCatalogdataTree getTBPCatalogdata() {
        return TBPCatalogdata;
    }

    public void setTBPCatalogdata(TBCatalogdataTree TBPCatalogdata) {
        this.TBPCatalogdata = TBPCatalogdata;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBPCatalogdata")
    public List<TBCatalogdataTree> getTBCatalogdatas() {
        return TBCatalogdatas;
    }

    public void setTBCatalogdatas(List<TBCatalogdataTree> TBCatalogdatas) {
        this.TBCatalogdatas = TBCatalogdatas;
    }


    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键
     */
//	@Id
//	@GeneratedValue(generator = "paymentableGenerator")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

//	@Column(name ="ID",nullable=false,length=36)
//	public String getId(){
//		return this.id;
//	}

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
//	public void setId(String id){
//		this.id = id;
//	}
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
    /**
     *方法: 取得java.math.BigDecimal
     *@return: java.math.BigDecimal  单价
     */

    @Column(name ="PRICE",nullable=true,length=32)
    public BigDecimal getPrice(){
        return this.price;
    }

    /**
     *方法: 设置java.math.BigDecimal
     *@param: java.math.BigDecimal  单价
     */
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  单价汇总
     */

    @Column(name ="PRICE_JSON",nullable=true)
    public String getPriceJson(){
        return this.priceJson;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  单价汇总
     */
    public void setPriceJson(String priceJson){
        this.priceJson = priceJson;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  服务目录状态
     */

    @Column(name ="STATUS",nullable=true,length=4)
    public Integer getStatus(){
        return this.status;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  服务目录状态
     */
    public void setStatus(Integer status){
        this.status = status;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  服务目录编码
     */

    @Column(name ="CATALOG_CODE",nullable=true,length=32)
    public String getCatalogCode(){
        return this.catalogCode;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  服务目录编码
     */
    public void setCatalogCode(String catalogCode){
        this.catalogCode = catalogCode;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  节点ID
     */

    @Column(name ="NODE_ID",nullable=true,length=4)
    public Integer getNodeId(){
        return this.nodeId;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  节点ID
     */
    public void setNodeId(Integer nodeId){
        this.nodeId = nodeId;
    }

    @Transient
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
