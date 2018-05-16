package com.rw.finance.client.service.after;

import com.rw.finance.client.service.MemberInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 14:59 2018/5/15
 */
@Aspect
@Configuration
public class MemberInfoServiceAfter {

    private static final Logger log= LoggerFactory.getLogger(MemberInfoServiceAfter.class);

    @Autowired
    private MemberInfoService memberInfoService;

    /**
     * 实名后报件
     * @param joinPoint
     */
    @After("execution(* com.rw.finance.client.service.MemberInfoService.isReal(..))")
    public void isReal(JoinPoint joinPoint){

    }
}
