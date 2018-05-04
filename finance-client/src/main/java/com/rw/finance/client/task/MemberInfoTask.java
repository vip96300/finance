package com.rw.finance.client.task;

import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author huanghongfei
 * @Description
 * @Date Create in 9:40 2018/3/12
 */
@Component
public class MemberInfoTask {

    @Autowired
    private MemberInfoService memberInfoService;
    /**
     * 每天遍历检查会员是否到期
     */
    /*@Scheduled(cron="0 0 1 * * ? ")
    public void levelTime(){
        List<MemberInfo> memberInfoList=memberInfoService.listByLevelGreaterThanAndLeveltimeLessThan(MemberInfoConstants.Level.LEVEL_0, DateUtils.getTimeStr(new Date()));
        memberInfoList.forEach(memberInfo -> {
            memberInfo.setLevel(0);
            memberInfo.setActiveTime("");
            memberInfoService.update(memberInfo);
        });
    }*/
}
