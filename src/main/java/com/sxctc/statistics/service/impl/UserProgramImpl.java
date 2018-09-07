package com.sxctc.statistics.service.impl;

import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.statistics.dao.UserProgramDao;
import com.sxctc.statistics.service.UserProgramService;
import com.sxctc.statistics.vo.Histogram;
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
@Service("serProgramuService")
@Transactional
public class UserProgramImpl extends CommonServiceImpl implements UserProgramService {

    @Autowired
    private UserProgramDao userProgramDao;

    @Override
    public List<Histogram> getManagerList() {
        return  userProgramDao.getManagerList();
    }

    @Override
    public  String getSequenceStatistics(String userCode){
        return userProgramDao.getSequenceStatistics(userCode);
    }
    @Override
    public String getSequenceDiagram(String businessId){
        return userProgramDao.getSequenceDiagram(businessId);
    }

    @Override
    public List<Histogram> getGradeTotal(String userCode){
        return userProgramDao.getGradeTotal(userCode);
    }


    @Override
    public List<Histogram> getRankOfUnit(String userCode){
        return userProgramDao.getRankOfUnit(userCode);
    }

    @Override
    public List<TBBusinessEntity> getProgramList(String userCode){
        return userProgramDao.getProgramList(userCode);
    }

    @Override
    public List<TBChancePoolEntity> getChanceProgramList(String userCode){
        return userProgramDao.getChanceProgramList(userCode);
    }


}
