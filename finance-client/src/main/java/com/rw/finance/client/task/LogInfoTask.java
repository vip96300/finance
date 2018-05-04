package com.rw.finance.client.task;

import com.rw.finance.client.dao.LogInfoMapper;
import com.rw.finance.common.entity.LogInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 日志收集定时任务
 * @file LogInfoTask.java	
 * @author huanghongfei
 * @date 2018年1月2日 上午11:43:03
 * @declaration
 */
@Component
public class LogInfoTask {

	@Autowired
	private LogInfoMapper logInfoMapper;
	
	/**
	 * 每月1号0点0分删除日志记录
	 */
	@Scheduled(cron="0 0 0 1 * ?") 
	public void delete(){
		logInfoMapper.deleteByExample(new LogInfoExample());
	}
}
