package com.sxctc.statistics.vo;

import javax.persistence.Entity;

/**
 * @ClassName: StatisticsVo
 * @Description: 统计分析返回结果类
 * @author liuzc
 * @date 2018/8/16 上午9:19
 * @version V1.0
 */
public class StatisticsVo{
    private String createName;
    private String projectCount;

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(String projectCount) {
        this.projectCount = projectCount;
    }
}
