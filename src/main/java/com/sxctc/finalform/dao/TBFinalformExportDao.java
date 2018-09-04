package com.sxctc.finalform.dao;

import com.sxctc.finalform.entity.TBFinalformExportEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

@MiniDao
public interface TBFinalformExportDao {

    @Arguments({"page", "rows"})
    @ResultType(TBFinalformExportEntity.class)
    public MiniDaoPage<TBFinalformExportEntity> tbFinalformExport(int page, int rows);

}
