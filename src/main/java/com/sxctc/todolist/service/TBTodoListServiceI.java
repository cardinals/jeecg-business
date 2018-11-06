package com.sxctc.todolist.service;
import com.sxctc.todolist.entity.TBTodoListEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBTodoListServiceI extends CommonService{
	
 	public void delete(TBTodoListEntity entity) throws Exception;
 	
 	public Serializable save(TBTodoListEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBTodoListEntity entity) throws Exception;
 	
}
