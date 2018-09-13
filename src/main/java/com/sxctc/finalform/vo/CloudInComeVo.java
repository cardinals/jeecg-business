package com.sxctc.finalform.vo;

import java.math.BigDecimal;

/**
 * @author liuzc
 * @version V1.0
 * @ClassName: CloudInComeVo
 * @Description: //TODO
 * @date 2018/9/12 下午6:02
 */
public class CloudInComeVo {
    private Integer checkNum;
    private BigDecimal price;

    public Integer getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(Integer checkNum) {
        this.checkNum = checkNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
