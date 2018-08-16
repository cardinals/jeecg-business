package com.sxctc.statistics.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
}
