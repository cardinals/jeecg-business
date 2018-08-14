package com.sxctc.workreport.service;
import com.sxctc.workreport.entity.TBWorkreportdayWeekEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBWorkreportdayWeekServiceI extends CommonService{
	
 	public void delete(TBWorkreportdayWeekEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkreportdayWeekEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkreportdayWeekEntity entity) throws Exception;
 	
}
