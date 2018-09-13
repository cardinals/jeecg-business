package com.sxctc.finalform.dao;

import com.sxctc.finalform.entity.TBFinalformExportEntity;
import com.sxctc.finalform.vo.CloudInComeVo;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import java.math.BigDecimal;
import java.util.List;

@MiniDao
public interface TBFinalformExportDao {

    @Arguments({"page", "rows"})
    @ResultType(TBFinalformExportEntity.class)
    public MiniDaoPage<TBFinalformExportEntity> tbFinalformExport(int page, int rows);

    @ResultType(CloudInComeVo.class)
    public List<CloudInComeVo> getSumCloudInCome();

    @ResultType(TBProfitTargetEntity.class)
    public List<TBProfitTargetEntity> getSumProjectInCome();

}
