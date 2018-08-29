package com.sxctc.workreport.service;
import com.sxctc.workreport.entity.TBWorkreportdayMonthEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBWorkreportdayMonthServiceI extends CommonService{
	
 	public void delete(TBWorkreportdayMonthEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkreportdayMonthEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkreportdayMonthEntity entity) throws Exception;
 	
}
