package com.rw.finance.common.pass.unspay.utils;

import com.rw.finance.common.utils.Md5Util;
import org.apache.commons.codec.digest.Md5Crypt;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 10:30 2018/4/26
 */
public class UnspayUtils {

    /**
     * 将拼接的url参数转换为map
     * @param str
     * @return
     */
    public static Map<String,String> strToMap(String str){
        Map<String,String> map=new HashMap<>();
        String [] params=str.split("&");
        for(int i=0;i<params.length;i++){
            map.put(params[i].split("=")[0],params[i].split("=")[1]);
        }
        return map;
    }

    /**
     * 将参数map转换为url跟参形式
     * @param params
     * @return
     */
    public static String mapToStr(Map<String,String> params){
        StringBuilder str=new StringBuilder();
        for(Map.Entry<String, String> map:params.entrySet()){
            str.append(map.getKey());
            str.append("=");
            str.append(map.getValue());
            str.append("&");
        }
        str.delete(str.toString().length()-1,str.toString().length());
        return str.toString();
    }

    /**
     * md5加密
     * @param str
     * @return
     */
    public static String MD5(String str) {
        return Md5Util.md5(str);
    }

}
