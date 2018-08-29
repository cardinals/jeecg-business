package com.sxctc.unitManage.service;
import com.sxctc.unitManage.entity.TBUnitManageEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBUnitManageServiceI extends CommonService{
	
 	public void delete(TBUnitManageEntity entity) throws Exception;
 	
 	public Serializable save(TBUnitManageEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBUnitManageEntity entity) throws Exception;
 	
}
