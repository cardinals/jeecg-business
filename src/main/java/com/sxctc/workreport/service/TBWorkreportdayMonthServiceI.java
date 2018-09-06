package com.sxctc.workreport.service;
import com.sxctc.workreport.entity.TBWorkreportdayMonthEntity;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBWorkreportdayMonthServiceI extends CommonService{
	
 	public void delete(TBWorkreportdayMonthEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkreportdayMonthEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkreportdayMonthEntity entity) throws Exception;

	/**
	 * @Title saveOrUpdateWeek
	 * @Description 保存更新月报逻辑
	 * @Param [t]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/9/6 下午3:35
	 **/
	public void saveOrUpdateMonth(TBWorkreportdayMonthEntity t) throws Exception;
}
