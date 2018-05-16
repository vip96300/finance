package com.rw.finance.client.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rw.finance.common.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @file ExceptionController.java	
 * @author huanghongfei
 * @date 2017年12月22日 上午9:44:12
 * @declaration
 */
@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value=Exception.class)
	public Result<Object> exception(HttpServletRequest request,
									HttpServletResponse response,
									Exception e){
		return new Result<>(999,"系统异常",null);
	}
}
