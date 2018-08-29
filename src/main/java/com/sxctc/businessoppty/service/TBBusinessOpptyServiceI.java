package com.sxctc.businessoppty.service;
import com.sxctc.businessoppty.entity.TBBusinessOpptyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusinessOpptyServiceI extends CommonService{
	
 	public void delete(TBBusinessOpptyEntity entity) throws Exception;
 	
 	public Serializable save(TBBusinessOpptyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusinessOpptyEntity entity) throws Exception;

	/**
	 * @Title deleteBusinessOppty
	 * @Description 删除重写方法
	 * @Param [tBBusinessOppty]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/28 上午9:47
	 **/
	public void deleteBusinessOppty(TBBusinessOpptyEntity tBBusinessOppty) throws Exception;

	/**
	 * @Title evaluate
	 * @Description 进行业务调用，调用公共方法：组装评估结果
	 * @Param [tBBusinessOppty, evaluateWin, evaluateWinFirst, evaluateConfirm, opptyRange, opptyRatio, sortNum]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/28 上午9:41
	 **/
	public void evaluate(TBBusinessOpptyEntity tBBusinessOppty, int win, int first, int confirm) throws Exception;

 	/**
	 * @Title evaluateWinSaveOrUpdate
	 * @Description 公共方法：组装评估结果
	 * @Param [tBBusinessOppty, evaluateWin, evaluateWinFirst, evaluateConfirm, opptyRange, opptyRatio]
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/8/27 下午2:38
	 **/
	public void evaluateWinSaveOrUpdate(TBBusinessOpptyEntity tBBusinessOppty, String evaluateWin, String evaluateWinFirst, String evaluateConfirm, int opptyRange, String opptyRatio, int sortNum) throws Exception;

}
