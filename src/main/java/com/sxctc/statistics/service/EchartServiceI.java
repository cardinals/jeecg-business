package com.sxctc.statistics.service;

import com.sxctc.statistics.vo.CloudCount;
import com.sxctc.statistics.vo.Histogram;
import com.sxctc.statistics.vo.StatisticsVo;
import org.jeecgframework.core.common.service.CommonService;

import java.util.List;

/**
 * @ClassName: EchartServiceI
 * @Description: 图表分析业务层接口类
 * @author liuzc
 * @date 2018/8/15 下午2:46
 * @version V1.0
 */
public interface EchartServiceI extends CommonService {

    /**
     * @Title getProjectCountByUserid
     * @Description 获取系统数量
     * @Param [id 用户ID null所有, optFlag 0未对接 1已经对接 null所有]
     * @Return int
     * @Author liuzc
     * @Date 2018/8/15 下午3:23
     **/
    public int getProjectCountByUserid(String id, String optFlag);

    /**
     * @Title getProjectCountByMonth
     * @Description 获取每个月新增的对接系统
     * @Param [id, months]
     * @Return int
     * @Author liuzc
     * @Date 2018/8/15 下午5:01
     **/
    public int getProjectCountByMonth(String id, String months);

    /**
     * @Title getEveryProjectCount
     * @Description 获取每个人负责的系统数
     * @Param []
     * @Return com.alibaba.fastjson.JSONObject
     * @Author liuzc
     * @Date 2018/8/16 上午9:02
     **/
    public List<StatisticsVo> getEveryProjectCount();

    /**
     * 获取厅局费用排名
     * @return
     */
    public List<Histogram> getRankOfUnit();
    /**
     * 获取销售总额费用排名
     * @return
     */
    public List<Histogram> getRankOfSale();
    /**
     * 获取平台各层费用
     * @return
     */
    public List<Histogram> getGradeTotal();

    /**
     * 获取第二层费用
     * @return
     */
    public List<Histogram> getSecondGradeTotal(String  rootType);
    /**
     * 获取时间差统计
     * @return
     */
    public String getSequenceStatistics();

    /**
    * @Title: getCloudConfirmCount
    * @description: 获取上云完成金额
    * @Param
    * @Return
    * @author: Dukaimin
    * @data:
    **/
    public List<CloudCount> getCloudConfirmCount();

    /**
    * @Title: getTrackConfimCount
    * @description: 获取迁移完成确认金额
    * @Param
    * @Return
    * @author: Dukaimin
    * @data:
    **/
    public Integer getTrackConfirmCount();

    /**
     * @Title: getCloudCompleteNum
     * @description: 获取上云完成数量
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getCloudCompleteNum();

    /**
     * @Title: getTransferCompleteNum
     * @description: 获取迁移完成数量
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getTransferCompleteNum();

    /**
    * @Title: getCheckedSystemNum
    * @description: 获取已验收系统总数
    * @Param
    * @Return
    * @author: Dukaimin
    * @data:
    **/
    public int getCheckedSystemNum();

    /**
     * @Title: getNotDockSystemNum
     * @description: 获取未对接系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getNotDockSystemNum();

    /**
     * @Title: getCloudDockSystemNum
     * @description: 获取上云对接系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getCloudDockSystemNum();

    /**
     * @Title: getResearchFormSystemNum
     * @description: 获取取得调研表/系统需求表系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getResearchFormSystemNum();

    /**
     * @Title: getSignPlanSystemNum
     * @description: 获取签订协议系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getSignPlanSystemNum();

    /**
     * @Title: getAllocatingResourcesSystemNum
     * @description: 获取分配资源系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getAllocatingResourcesSystemNum();

    /**
     * @Title: getCloudTestSystemNum
     * @description: 获取上云测试系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getCloudTestSystemNum();

    /**
     * @Title: getRecoveryAgreementSystemNum
     * @description: 获取回收协议系统总数
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getRecoveryAgreementSystemNum();

    /**
     * @Title: getWinTheBidProjectNum
     * @description: 获取已中标项目数量
     * @Param
     * @Return
     * @author: Dukaimin
     * @data:
     **/
    public int getWinTheBidProjectNum();

    /**
    * @Title: getTargetCloudSystemNum
    * @description: 获取字典表中2018上云系统目标数量
    * @Param
    * @Return
    * @author: Dukaimin
    * @data:
    **/
    public int getTargetCloudSystemNum();

    /**
    * @Title: getTargetConstructProjectNum
    * @description: 获取字典表中2018目标承建大数据项目数量
    * @Param
    * @Return
    * @author: Dukaimin
    * @data:
    **/
    public int getTargetConstructProjectNum();

    /**
    * @Title: getTargetRevenueCount
    * @description: 获取字典表中2018目标营收额
    * @Param
    * @Return
    * @author: Dukaimin
    * @data:
    **/
    public int getTargetRevenueCount();
}
