package com.sxctc.business.service;
import com.sxctc.business.entity.TBBusinessEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusinessServiceI extends CommonService{
	
 	public void delete(TBBusinessEntity entity) throws Exception;
 	
 	public Serializable save(TBBusinessEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusinessEntity entity) throws Exception;
 	
}
