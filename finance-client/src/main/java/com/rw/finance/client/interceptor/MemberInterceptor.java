package com.rw.finance.client.interceptor;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.entity.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rw.finance.common.constants.JwtConstants;
import com.rw.finance.client.service.MemberInfoService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;

/**
 * 
 * @file MemberInfoAuthorInterceptor.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:17:13
 * @declaration
 */
@Component
public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private MemberInfoService memberInfoService;

	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler){
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(Member.class)) {
        	String jwt=request.getParameter(JwtConstants.JWT);
        	if(StringUtils.isEmpty(jwt)){
        		response.setStatus(401);
        		return false;
        	}
        	Jws<Claims> claims = Jwts.parser().setSigningKey(JwtConstants.JWT_SECURE).parseClaimsJws(jwt);
        	MemberInfo memberInfo =memberInfoService.getByMemberid(Long.valueOf(claims.getBody().get("memberid").toString()));
        	if(StringUtils.isEmpty(memberInfo)){
        		response.setStatus(401);
        		return false;
        	}
        	if(memberInfo.getLevel()<method.getAnnotation(Member.class).level()){
        		response.setStatus(401);
        		return false;
        	}
        }
        return true;
    }
}
