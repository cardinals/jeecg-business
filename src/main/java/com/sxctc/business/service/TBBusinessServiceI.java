package com.sxctc.business.service;
import com.sxctc.business.entity.TBBusinessEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusinessServiceI extends CommonService{
	
 	public void delete(TBBusinessEntity entity) throws Exception;
 	
 	public Serializable save(TBBusinessEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusinessEntity entity) throws Exception;

 	/**
 	 * @Title deleteBusiness
 	 * @Description 上云业务列表删除逻辑
 	 * @Param [tBBusiness, busiWorkreportId]
 	 * @Return void
 	 * @Author liuzc
 	 * @Date 2018/8/29 下午1:53
 	 **/
	public void deleteBusiness(TBBusinessEntity tBBusiness, String busiWorkreportId) throws Exception;

	/**
	 * @Title doAddBusiness
	 * @Description 上云业务保存逻辑
	 * @Param [tBBusiness, busiWorkreportId]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/29 下午2:02
	 **/
	public void doAddBusiness(TBBusinessEntity tBBusiness) throws Exception;
}
