package com.sxctc.statistics.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.statistics.vo.StatisticsVo;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;

import java.util.List;

@MiniDao
public interface EchartsDao {

    @Arguments({"id","optFlag"})
    @ResultType(Integer.class)
    public int getProjectCountByUserid(String id, String optFlag);

    @Arguments({"id","months"})
    @ResultType(Integer.class)
    public int getProjectCountByMonth(String id, String months);

    @ResultType(StatisticsVo.class)
    public List<StatisticsVo> getEveryProjectCount();
}
