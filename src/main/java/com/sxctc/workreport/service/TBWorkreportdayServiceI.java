package com.sxctc.workreport.service;
import com.sxctc.workreport.entity.TBWorkreportdayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.Date;

public interface TBWorkreportdayServiceI extends CommonService{
	
 	public void delete(TBWorkreportdayEntity entity) throws Exception;
 	
 	public Serializable save(TBWorkreportdayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBWorkreportdayEntity entity) throws Exception;

}
