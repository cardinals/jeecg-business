package com.sxctc.sms.task;

import com.sxctc.sms.service.TBSmsServiceI;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @ClassName:ReportSmsSendTask
 * @Description: 日志提醒消息推送定时任务
 * @date 2018-11-07 下午5:06:34
 * 
 */
@Service("reportSmsSendTask")
public class ReportSmsSendTask implements Job{
	
	@Autowired
	private TBSmsServiceI tBSmsService;
	
	public void run() {
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================推送消息定时任务开始===================");
		try {			
			tBSmsService.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		org.jeecgframework.core.util.LogUtil.info("===================推送消息定时任务结束===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		org.jeecgframework.core.util.LogUtil.info("总耗时"+times+"毫秒");
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		run();
	}
}
