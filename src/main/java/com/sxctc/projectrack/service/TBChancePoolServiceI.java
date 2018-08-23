package com.sxctc.projectrack.service;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBChancePoolServiceI extends CommonService{
	
 	public void delete(TBChancePoolEntity entity) throws Exception;
 	
 	public Serializable save(TBChancePoolEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBChancePoolEntity entity) throws Exception;
 	
}
