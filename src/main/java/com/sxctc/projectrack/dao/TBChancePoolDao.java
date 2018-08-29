package com.sxctc.projectrack.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

@MiniDao
public interface TBChancePoolDao {

    @Arguments("createBy")
    @Sql("select sum(project_budget) from t_b_chance_pool where create_by=:createBy")
    Integer getSumProjectBudget(String createBy);

    @Arguments("createBy")
    @Sql("select sum(project_server) from t_b_chance_pool where create_by=:createBy")
    Integer getSumProjectServer(String createBy);

    @Arguments("createBy")
    @Sql("select sum(project_hardware) from t_b_chance_pool where create_by=:createBy")
    Integer getSumProjectHardware(String createBy);
}
