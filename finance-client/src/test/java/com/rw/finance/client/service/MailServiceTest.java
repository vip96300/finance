package com.rw.finance.client.service;

import com.rw.finance.client.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 9:44 2018/4/17
 */
public class MailServiceTest extends BaseTest{

    @Autowired
    private MailService mailService;

    @Test
    public void send(){
        mailService.send("974397896@qq.com","title","message");
    }
}
