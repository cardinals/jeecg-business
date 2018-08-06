package com.sxctc.catalogs.service;
import com.sxctc.catalogs.entity.TBCatalogdataEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBCatalogdataServiceI extends CommonService{
	
 	public void delete(TBCatalogdataEntity entity) throws Exception;
 	
 	public Serializable save(TBCatalogdataEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBCatalogdataEntity entity) throws Exception;
 	
}
