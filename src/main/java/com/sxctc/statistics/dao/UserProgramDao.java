package com.sxctc.statistics.dao;

import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.statistics.vo.Histogram;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;

import java.util.List;

@MiniDao
public interface UserProgramDao {

    @Arguments({"userCode"})
    @ResultType(String.class)
    String getSequenceStatistics(String userCode);

    @Arguments({"businessId"})
    @ResultType(String.class)
    String getSequenceDiagram(String businessId);

    @Arguments({"manageType"})
    @ResultType(Histogram.class)
    List<Histogram> getManagerList(String manageType);

    @Arguments({"userCode"})
    @ResultType(Histogram.class)
    List<Histogram> getGradeTotal(String userCode);


    @Arguments({"userCode"})
    @ResultType(Histogram.class)
    List<Histogram> getRankOfUnit(String userCode);

    @Arguments({"userCode"})
    @ResultType(TBBusinessEntity.class)
    List<TBBusinessEntity> getProgramList(String userCode);


    @Arguments({"userCode"})
    @ResultType(TBChancePoolEntity.class)
    List<TBChancePoolEntity> getChanceProgramList(String userCode);
}
