package com.sxctc.workreport.service;
import com.sxctc.workreport.entity.TBBusiWorkreportEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusiWorkreportServiceI extends CommonService{
	
 	public void delete(TBBusiWorkreportEntity entity) throws Exception;
 	
 	public Serializable save(TBBusiWorkreportEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusiWorkreportEntity entity) throws Exception;
 	
}
