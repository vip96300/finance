package com.rw.finance.client.service;

import com.rw.finance.client.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 14:42 2018/5/15
 */
public class MemberCardServiceTest extends BaseTest{

    @Autowired
    private MemberCardService memberCardService;

    @Test
    public void delByMemberidAndCardid(){
        memberCardService.delByMemberidAndCardid(28,22);
    }
}
