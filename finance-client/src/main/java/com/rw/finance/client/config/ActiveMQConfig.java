package com.rw.finance.client.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 10:51 2018/4/20
 */
@Configuration
public class ActiveMQConfig {
    /**
     * 任务队列名称
     */
    public static final String REPAY_TASK_QUEUE="REPAY_TASK_QUEUE";
}
