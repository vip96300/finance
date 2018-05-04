package com.rw.finance.client.service;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 13:55 2018/3/30
 */
public interface MailService {

    /**
     * 发送邮件
     * @param to 收件人
     * @Param title 标题
     * @param message 消息
     */
    void send(String to, String title, String message);
}
