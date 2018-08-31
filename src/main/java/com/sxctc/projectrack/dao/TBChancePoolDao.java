package com.sxctc.projectrack.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface TBChancePoolDao {

    @Arguments({"createBy"})
    @ResultType(Integer.class)
    Integer getSumProjectBudget(String createBy);

    @Arguments({"createBy"})
    @ResultType(Integer.class)
    Integer getSumProjectServer(String createBy);

    @Arguments({"createBy"})
    @ResultType(Integer.class)
    Integer getSumProjectHardware(String createBy);
}
