package com.sxctc.catalogs.service;
import com.sxctc.catalogs.entity.TBCatalogdataEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBCatalogdataServiceI extends CommonService{
	
 	public void delete(TBCatalogdataEntity entity) throws Exception;
 	
 	public Serializable save(TBCatalogdataEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBCatalogdataEntity entity) throws Exception;

 	/**
 	 * @Title makeCatalogCode
 	 * @Description 生成服务目录编号
 	 * @Param [entity]
 	 * @Return java.lang.String
 	 * @Author liuzc
 	 * @Date 2018/8/31 下午5:57
 	 **/
	public String makeCatalogCode(String type, String fartherid) throws Exception;
}
