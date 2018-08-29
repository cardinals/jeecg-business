package com.sxctc.customermap.vo;


/**
 * @ClassName: TBCustomerMapVo
 * @Description: 客户地图vo类
 * @author liuzc
 * @date 2018/8/24 下午5:04
 * @version V1.0
 */
public class TBCustomerMapVo {
    private String projectName;
    private Integer worthStatus;
    private Integer cooperateStatus;
    private Integer unitCode;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getWorthStatus() {
        return worthStatus;
    }

    public void setWorthStatus(Integer worthStatus) {
        this.worthStatus = worthStatus;
    }

    public Integer getCooperateStatus() {
        return cooperateStatus;
    }

    public void setCooperateStatus(Integer cooperateStatus) {
        this.cooperateStatus = cooperateStatus;
    }

    public Integer getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Integer unitCode) {
        this.unitCode = unitCode;
    }
}
