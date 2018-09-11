package com.sxctc.statistics.service.impl;

import com.sxctc.statistics.dao.EchartsDao;
import com.sxctc.statistics.service.EchartServiceI;
import com.sxctc.statistics.vo.CloudCount;
import com.sxctc.statistics.vo.Histogram;
import com.sxctc.statistics.vo.StatisticsVo;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: EchartServiceImpl
 * @Description: 图表分析业务层实现类
 * @author liuzc
 * @date 2018/8/15 下午2:46
 * @version V1.0
 */
@Service("echartService")
@Transactional
public class EchartServiceImpl extends CommonServiceImpl implements EchartServiceI {

    @Autowired
    private EchartsDao echartsDao;

    @Override
    public int getProjectCountByUserid(String id, String optFlag) {
        return echartsDao.getProjectCountByUserid(id,optFlag);
    }

    @Override
    public int getProjectCountByMonth(String id, String months) {
        return echartsDao.getProjectCountByMonth(id,months);
    }

    @Override
    public List<StatisticsVo> getEveryProjectCount() {
        return echartsDao.getEveryProjectCount();
    }


    @Override
    public List<Histogram> getRankOfUnit(){
        return echartsDao.getRankOfUnit();
    }

    @Override
    public List<Histogram> getRankOfSale(){
        return echartsDao.getRankOfSale();
    }

     @Override
    public List<Histogram> getGradeTotal(){
        return echartsDao.getGradeTotal();
    }

     @Override
    public List<Histogram>getSecondGradeTotal(String  rootType){
        return echartsDao.getSecondGradeTotal(rootType);
    }

    @Override
    public String getSequenceStatistics(){
        return echartsDao.getSequenceStatistics();
    }

    @Override
    public List<CloudCount> getCloudConfirmCount() {
        return echartsDao.getCloudConfirmCount();
    }

    @Override
    public Integer getTrackConfirmCount() {
        return echartsDao.getTrackConfirmCount();
    }

    @Override
    public int getCloudCompleteNum() {
        return echartsDao.getCloudCompleteNum();
    }

    @Override
    public int getTransferCompleteNum() {
        return echartsDao.getTransferCompleteNum();
    }

    @Override
    public int getCheckedSystemNum() {
        return echartsDao.getCheckedSystemNum();
    }

    @Override
    public int getNotDockSystemNum() {
        return echartsDao.getNotDockSystemNum();
    }

    @Override
    public int getCloudDockSystemNum() {
        return echartsDao.getCloudDockSystemNum();
    }

    @Override
    public int getResearchFormSystemNum() {
        return echartsDao.getResearchFormSystemNum();
    }

    @Override
    public int getSignPlanSystemNum() {
        return echartsDao.getSignPlanSystemNum();
    }

    @Override
    public int getAllocatingResourcesSystemNum() {
        return echartsDao.getAllocatingResourcesSystemNum();
    }

    @Override
    public int getCloudTestSystemNum() {
        return echartsDao.getCloudTestSystemNum();
    }

    @Override
    public int getRecoveryAgreementSystemNum() {
        return echartsDao.getRecoveryAgreementSystemNum();
    }

    @Override
    public int getTargetRevenueCount() {
        return echartsDao.getTargetRevenueCount();
    }

    @Override
    public int getWinTheBidProjectNum() {
        return echartsDao.getWinTheBidProjectNum();
    }

    @Override
    public int getTargetCloudSystemNum() {
        return echartsDao.getTargetCloudSystemNum();
    }

    @Override
    public int getTargetConstructProjectNum() {
        return echartsDao.getTargetConstructProjectNum();
    }


}
