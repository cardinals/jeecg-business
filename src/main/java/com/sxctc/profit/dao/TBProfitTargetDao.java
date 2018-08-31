package com.sxctc.profit.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface TBProfitTargetDao {

    @Arguments({"createBy"})
    @ResultType(Integer.class)
    Integer getSumContractValue(String createBy);

    @Arguments({"createBy"})
    @ResultType(Integer.class)
    Integer getSumProfitTarget(String createBy);

    @Arguments({"createBy"})
    @ResultType(Integer.class)
    Integer getSumConfirmIncome(String createBy);
}
