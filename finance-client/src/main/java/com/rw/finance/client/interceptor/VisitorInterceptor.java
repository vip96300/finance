package com.rw.finance.client.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rw.finance.client.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rw.finance.common.constants.TimeConstants;
import com.rw.finance.client.service.BaseCacheService;
/**
 * 访问频率控制
 * @file VisitFrequencyInterceptor.java	
 * @author huanghongfei
 * @date 2017年12月28日 下午5:50:28
 * @declaration
 */
@Component
public class VisitorInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private BaseCacheService baseCacheService;
	
	private static final Logger log=LoggerFactory.getLogger(VisitorInterceptor.class);
	
	/**
	 * 访问频率时间戳key后缀
	 */
	private static final String FREQUENCY_SUFFIX="_FREQUENCY";

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String lastVisitTimestamp =baseCacheService.get(request.getRemoteHost()+FREQUENCY_SUFFIX,String.class).toString();
		if(StringUtils.isEmpty(lastVisitTimestamp)){
			baseCacheService.set(RequestUtils.getIpAddress(request)+FREQUENCY_SUFFIX,String.valueOf(System.currentTimeMillis()),TimeConstants.CACHE_EXPRIE_TIME);
			return true;
		}
		log.info("current timestamp:{},last timestamp:{},frequency:{}",System.currentTimeMillis(),lastVisitTimestamp,System.currentTimeMillis()-Long.valueOf(lastVisitTimestamp));
		if(System.currentTimeMillis()-Long.valueOf(lastVisitTimestamp)<TimeConstants.VISIT_FREQUENCY_TIMESTAMP){
			response.setStatus(250);
			response.getWriter().write("what's your problem?");
			return false;
		}
		baseCacheService.set(RequestUtils.getIpAddress(request)+FREQUENCY_SUFFIX,String.valueOf(System.currentTimeMillis()),TimeConstants.CACHE_EXPRIE_TIME);
        return true;
    }
	
}
