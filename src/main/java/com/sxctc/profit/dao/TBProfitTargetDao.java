package com.sxctc.profit.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface TBProfitTargetDao {

    @Arguments("createBy")
    @Sql("select sum(contract_value) from t_b_profit_target where create_by=:createBy")
    Integer getSumContractValue(String createBy);

    @Arguments("createBy")
    @Sql("select sum(profit_target) from t_b_profit_target where create_by=:createBy")
    Integer getSumProfitTarget(String createBy);

    @Arguments("createBy")
    @Sql("select sum(confirm_income) from t_b_profit_target where create_by=:createBy")
    Integer getSumConfirmIncome(String createBy);
}
