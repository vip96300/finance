package com.rw.finance.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数学计算工具
 * @file MathUtils.java	
 * @author huanghongfei
 * @date 2017年12月18日 上午9:29:10
 * @declaration
 */
public class MathUtils {
	
	/**
	 * 加法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.add(b2).doubleValue();  
    }  
	/**
	 * 减法
	 * @param v1
	 * @param v2
	 * @return
	 */
    public static double subtract(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.subtract(b2).doubleValue();  
    }  
    /**
     * 乘法
     * @param v1
     * @param v2
     * @return
     */
    public static double multiply(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.multiply(b2).doubleValue();  
    }  
    /**
     * 除法
     * @param v1
     * @param v2
     * @return
     */
    public static double divide(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 检查是否数字
     * @param value
     * @return
     */
    public static boolean isNumber(String value) {
        String patternStr = "^\\d+$";
        Pattern p = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(value);  
        return m.find();  
    }  
    /**
     * 保留小数位
     * @param value 初始值
     * @param offset 小数偏移量
     * @return
     */
    public static double persist(double value,int offset){
    	BigDecimal bigDecimal=new BigDecimal(value); 
    	value=bigDecimal.setScale(offset,BigDecimal.ROUND_HALF_UP).doubleValue();
    	return value;
    }
}
