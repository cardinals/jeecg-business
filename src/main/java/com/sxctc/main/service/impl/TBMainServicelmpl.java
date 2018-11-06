package com.sxctc.main.service.impl;

import com.sxctc.main.dao.TBMainDao;
import com.sxctc.main.service.TBMainServicel;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tbMainService")
@Transactional
public class TBMainServicelmpl extends CommonServiceImpl implements TBMainServicel {

    @Autowired
    private TBMainDao tbMainDao;

    @Override
    public int getProjectTotalNum(String userName) {
        return tbMainDao.getProjectTotalNum(userName);
    }

    @Override
    public int getNotDockSystemNum(String userName) {
        return tbMainDao.getNotDockSystemNum(userName);
    }

    @Override
    public int getCloudDockSystemNum(String userName) {
        return tbMainDao.getCloudDockSystemNum(userName);
    }

    @Override
    public int getResearchFormSystemNum(String userName) {
        return tbMainDao.getResearchFormSystemNum(userName);
    }

    @Override
    public int getSignPlanSystemNum(String userName) {
        return tbMainDao.getSignPlanSystemNum(userName);
    }

    @Override
    public int getAllocatingResourcesSystemNum(String userName) {
        return tbMainDao.getAllocatingResourcesSystemNum(userName);
    }

    @Override
    public int getCloudTestSystemNum(String userName) {
        return tbMainDao.getCloudTestSystemNum(userName);
    }

    @Override
    public int getRecoveryAgreementSystemNum(String userName) {
        return tbMainDao.getRecoveryAgreementSystemNum(userName);
    }

    @Override
    public int getCloudCompleteNum(String userName) {
        return tbMainDao.getCloudCompleteNum(userName);
    }
}
