package com.sxctc.main.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
@MiniDao
public interface TBMainDao {
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getProjectTotalNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getCloudCompleteNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getNotDockSystemNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getCloudDockSystemNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getResearchFormSystemNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getSignPlanSystemNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getAllocatingResourcesSystemNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getCloudTestSystemNum(String userName);
    @Arguments({"userName"})
    @ResultType(Integer.class)
    public int getRecoveryAgreementSystemNum(String userName);
}
