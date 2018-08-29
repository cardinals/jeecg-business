package com.sxctc.customermap.service;
import com.sxctc.customermap.entity.TBCustomerMapEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBCustomerMapServiceI extends CommonService{
	
 	public void delete(TBCustomerMapEntity entity) throws Exception;
 	
 	public Serializable save(TBCustomerMapEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBCustomerMapEntity entity) throws Exception;
 	
}
