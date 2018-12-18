package com.sxctc.statistics.service;

import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.statistics.vo.Histogram;
import org.jeecgframework.core.common.service.CommonService;

import java.util.List;

public interface UserProgramService extends CommonService {

    /**
     * 获取销售人员列表
     * @return
     */
    List<Histogram> getManagerList(String manageType);

    /**
     * 获取时间差统计
     * 
     */
    String getSequenceStatistics(String userCode);

    /**
     * 获取时序
     *
     */
    String getSequenceDiagram(String businessId);
    /**
     * 获取平台各层费用
     * @return
     */
    List<Histogram> getGradeTotal(String userCode);

    /**
     * 获取各个厅局上云费用
     * @return
     */
    List<Histogram> getRankOfUnit(String userCode);

    /**
     * 获取项目列表
     * @return
     */
    List<TBBusinessEntity> getProgramList(String userCode);
    /**
     * 获取机会池项目列表
     * @return
     */
    List<TBChancePoolEntity> getChanceProgramList(String userCode);
}
