package com.rw.finance.client.controller;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.client.service.ActvcodeInfoService;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @file ActvcodeInfoController.java	
 * @author huanghongfei
 * @date 2017年12月28日 上午9:33:21
 * @declaration
 */
@RestController
@RequestMapping(value="/actvcode/info")
public class ActvcodeInfoController {


    @Autowired
    private ActvcodeInfoService actvcodeInfoService;

    @Autowired
    private MemberInfoService memberInfoService;
    /**
     * 会员试用
     * @param memberid 会员编号
     * @return
     */
    @Member(level= MemberInfoConstants.Level.LEVEL_0)
    //@PostMapping(value="/testActive")
    public Result<Object> testActive(@RequestAttribute(value="memberid")long memberid){
        MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
        if(!StringUtils.isEmpty(memberInfo.getLevelTime())){
            //会员已试用或者已激活
            return new Result<>(501,"会员已试用或者已激活",null);
        }
        actvcodeInfoService.testActive(memberid);
        return new Result<Object>(200,null,null);
    }
}
