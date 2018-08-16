package com.sxctc.statistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxctc.statistics.dao.EchartsDao;
import com.sxctc.statistics.service.EchartServiceI;
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
}
