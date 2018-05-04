package com.rw.finance.client.interceptor;

import java.util.Date;

import com.rw.finance.client.service.LogInfoService;
import com.rw.finance.client.utils.RequestUtils;
import com.rw.finance.common.entity.LogInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rw.finance.common.constants.JwtConstants;
import com.rw.finance.common.constants.LogInfoRoleConstants;
import com.rw.finance.common.utils.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 操作日志拦截器
 * @file AdminAuthorInterceptor.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:17:13
 * @declaration
 */
@Component
public class LogInfoInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log=LoggerFactory.getLogger(LogInfoInterceptor.class);
	
	@Autowired
	private LogInfoService logInfoService;

	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) {
    	log.info(">>> {}",request.getRequestURI());
    	String jwt=request.getParameter("jwt");
    	if(StringUtils.isEmpty(jwt)){
    		return true;
    	}
    	Jws<Claims> claims = Jwts.parser().setSigningKey(JwtConstants.JWT_SECURE).parseClaimsJws(jwt);
    	String ipAddress= RequestUtils.getIpAddress(request);
    	logInfoService.add(new LogInfo(LogInfoRoleConstants.Role.RoleMember.getRole(), Long.valueOf(claims.getBody().get("memberid").toString()),request.getRequestURI(), request.getHeader("user-agent"),request.getMethod(),request.getQueryString(),"", 200,ipAddress,"",DateUtils.getTimeStr(new Date())));
    	request.setAttribute("memberid",claims.getBody().get("memberid"));
        return true;
    }
}
