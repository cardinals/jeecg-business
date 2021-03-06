package com.sxctc.projectrack.service;
import com.sxctc.projectrack.entity.TBChancePoolEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBChancePoolServiceI extends CommonService{
	
 	public void delete(TBChancePoolEntity entity) throws Exception;
 	
 	public Serializable save(TBChancePoolEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBChancePoolEntity entity) throws Exception;

 	/**
 	 * @Title saveOrUpdateChancePool
 	 * @Description 更新机会池操作
 	 * @Param [entity]
 	 * @Return void
 	 * @Author liuzc
 	 * @Date 2018/9/1 上午10:57
 	 **/
	public void saveOrUpdateChancePool(TBChancePoolEntity t, TBChancePoolEntity tBChancePool) throws Exception;

	/**
	 * @Title deleteChancePool
	 * @Description 删除机会吃
	 * @Param [entity]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/9/1 上午10:57
	 **/
	public void deleteChancePool(TBChancePoolEntity entity) throws Exception;

	/**
	 * @Title saveChancePool
	 * @Description 销售新增项目机会池项目
	 * @Param [entity]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/12/6 15:43
	 **/
	public void saveChancePool(TBChancePoolEntity entity) throws Exception;
}
