package com.sxctc.workday.service;
import com.sxctc.workday.entity.TBWorkdayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBWorkdayServiceI extends CommonService{
	
 	public void delete(TBWorkdayEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkdayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkdayEntity entity) throws Exception;
 	
}
