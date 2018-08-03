package com.sxctc.workdays.service;
import com.sxctc.workdays.entity.TBWorkreportdayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBWorkreportdayServiceI extends CommonService{
	
 	public void delete(TBWorkreportdayEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkreportdayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkreportdayEntity entity) throws Exception;
 	
}
