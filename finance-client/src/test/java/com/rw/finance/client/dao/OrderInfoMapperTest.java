package com.rw.finance.client.dao;

import com.rw.finance.client.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 14:57 2018/4/20
 */
public class OrderInfoMapperTest extends BaseTest{

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Test
    public void selectByDetailsLike(){
        System.err.println(orderInfoMapper.selectByDetailsLike("\"taskId\":6001"));
    }
}
