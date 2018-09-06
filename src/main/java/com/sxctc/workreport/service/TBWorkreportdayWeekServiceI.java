package com.sxctc.workreport.service;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBWorkreportdayWeekServiceI extends CommonService{
	
 	public void delete(TBWorkreportdayWeekEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkreportdayWeekEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkreportdayWeekEntity entity) throws Exception;

	/**
	 * @Title saveOrUpdateWeek
	 * @Description 保存更新周报逻辑
	 * @Param [t]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/9/6 下午3:35
	 **/
	public void saveOrUpdateWeek(TBWorkreportdayWeekEntity t) throws Exception;
 	
}
