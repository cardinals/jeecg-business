package com.sxctc.profit.service;
import com.sxctc.profit.entity.TBProfitTargetEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBProfitTargetServiceI extends CommonService{
	
 	public void delete(TBProfitTargetEntity entity) throws Exception;
 	
 	public Serializable save(TBProfitTargetEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBProfitTargetEntity entity) throws Exception;
 	
}
