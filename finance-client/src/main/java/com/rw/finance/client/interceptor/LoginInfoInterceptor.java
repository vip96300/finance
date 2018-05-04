package com.rw.finance.client.interceptor;

import com.rw.finance.client.utils.RequestUtils;
import com.rw.finance.common.entity.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rw.finance.common.constants.LoginInfoConstants;
import com.rw.finance.client.service.LoginInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录日志拦截器
 * @file LoginInfoInterceptor.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:17:13
 * @declaration
 */
@Component
public class LoginInfoInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private LoginInfoService loginInfoService;

	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) {
    	if(request.getRequestURI().contains("login")){
    		loginInfoService.add(new LoginInfo(request.getParameter("telephone"),LoginInfoConstants.AccountType.MEMBER.getAccountType(), RequestUtils.getIpAddress(request)));
    	}
        return true;
    }

}
