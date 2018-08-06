package com.sxctc.business.service;
import com.sxctc.business.entity.TBBusiCatalogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusiCatalogServiceI extends CommonService{
	
 	public void delete(TBBusiCatalogEntity entity) throws Exception;
 	
 	public Serializable save(TBBusiCatalogEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusiCatalogEntity entity) throws Exception;
 	
}
