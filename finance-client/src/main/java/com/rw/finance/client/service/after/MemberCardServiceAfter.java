package com.rw.finance.client.service.after;

import com.rw.finance.client.service.MemberCardService;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.pass.unspay.Unspay;
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
 * @Date Create in 14:27 2018/5/15
 */
@Aspect
@Configuration
public class MemberCardServiceAfter {

    private static final Logger log= LoggerFactory.getLogger(MemberCardServiceAfter.class);

    @Autowired
    private MemberInfoService memberInfoService;
    @Autowired
    private MemberCardService memberCardService;

    /**
     * 删除后解绑卡片
     * @param joinPoint
     */
    @After("execution(* com.rw.finance.client.service.MemberCardService.delByMemberidAndCardid(..))")
    public void delByMemberidAndCardid(JoinPoint joinPoint){
        log.debug("aop:delByMemberidAndCardid after");
        long memberId=Long.valueOf(joinPoint.getArgs()[0].toString());
        MemberInfo memberInfo=memberInfoService.getByMemberid(memberId);
        if(memberInfo==null){
            return;
        }
        long cardId=Long.valueOf(joinPoint.getArgs()[1].toString());
        MemberCard memberCard=memberCardService.getByMemberidAndCardid(memberId,cardId);
        if(memberCard==null){
            return;
        }
        try {
            Unspay.bindUnBind(String.valueOf(memberId),memberInfo.getMemberToken(),memberCard.getCardToken());
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
