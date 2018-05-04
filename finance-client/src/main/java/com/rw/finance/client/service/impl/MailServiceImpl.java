package com.rw.finance.client.service.impl;

import com.rw.finance.client.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 14:01 2018/3/30
 */
@Component
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Async
    public void send(String to,String title, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("935160293@qq.com");
        msg.setTo(to);
        msg.setSubject(title);
        msg.setText(message);
        javaMailSender.send(msg);
    }
}
