package com.sxctc.statistics.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.statistics.vo.Histogram;
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


    @ResultType(Histogram.class)
    public List<Histogram> getRankOfUnit();


    @ResultType(Histogram.class)
    public List<Histogram> getRankOfSale();

    @ResultType(Histogram.class)
    public List<Histogram> getGradeTotal();

    @ResultType(String.class)
    public String getSequenceStatistics();

    @ResultType(Integer.class)
    public int getCloudConfirmCount();

    @ResultType(Integer.class)
    public int getTrackConfirmCount();

    @ResultType(Integer.class)
    public int getCloudCompleteNum();

    @ResultType(Integer.class)
    public int getTransferCompleteNum();

    @ResultType(Integer.class)
    public int getCheckedSystemNum();

    @ResultType(Integer.class)
    public int getNotDockSystemNum();

    @ResultType(Integer.class)
    public int getCloudDockSystemNum();

    @ResultType(Integer.class)
    public int getResearchFormSystemNum();

    @ResultType(Integer.class)
    public int getSignPlanSystemNum();

    @ResultType(Integer.class)
    public int getAllocatingResourcesSystemNum();

    @ResultType(Integer.class)
    public int getCloudTestSystemNum();

    @ResultType(Integer.class)
    public int getRecoveryAgreementSystemNum();

    @ResultType(Integer.class)
    public int getCloudCompleteSystemNum();

    @ResultType(Integer.class)
    public int getWinTheBidProjectNum();

    @ResultType(Integer.class)
    public int getTargetCloudSystemNum();

    @ResultType(Integer.class)
    public int getTargetConstructProjectNum();
}
