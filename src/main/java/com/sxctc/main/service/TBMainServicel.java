package com.sxctc.main.service;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.jeecgframework.core.common.service.CommonService;

public interface TBMainServicel extends CommonService {

    /**
     * @Title getProjectCountByUserid
     * @Description 获取系统数量
     * @Param
     * @Return int
     * @Author liuzc
     * @Date 2018/8/15 下午3:23
     **/
    public int getProjectTotalNum(String userName);


    /**
     * @Title: getNotDockSystemNum
     * @description: 获取未对接系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getNotDockSystemNum(String userName);

    /**
     * @Title: getCloudDockSystemNum
     * @description: 获取上云对接系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getCloudDockSystemNum(String userName);

    /**
     * @Title: getResearchFormSystemNum
     * @description: 获取取得调研表/系统需求表系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getResearchFormSystemNum(String userName);

    /**
     * @Title: getSignPlanSystemNum
     * @description: 获取签订协议系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getSignPlanSystemNum(String userName);

    /**
     * @Title: getAllocatingResourcesSystemNum
     * @description: 获取分配资源系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getAllocatingResourcesSystemNum(String userName);

    /**
     * @Title: getCloudTestSystemNum
     * @description: 获取上云测试系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getCloudTestSystemNum(String userName);

    /**
     * @Title: getRecoveryAgreementSystemNum
     * @description: 获取回收协议系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getRecoveryAgreementSystemNum(String userName);


    /**
     * @Title: getCloudCompleteNum
     * @description: 获取上云完成数量
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getCloudCompleteNum(String userName);


}
