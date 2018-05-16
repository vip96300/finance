package com.rw.finance.common.pass.unspay.utils;

import com.rw.finance.common.pass.unspay.UnspayConstants;
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

    /**
     * 绑卡回调验签
     * @param params
     * @return
     */
    public static boolean h5BindBackVerify(Map<String,String> params){
        StringBuilder str=new StringBuilder();
        str.append("result_code").append("=").append(params.get("result_code")).append("&");
        str.append("resultMsg").append("=").append(params.get("resultMsg")).append("&");
        str.append("bindCode").append("=").append(params.get("bindCode")).append("&");
        str.append("bindMsg").append("=").append(params.get("bindMsg")).append("&");
        str.append("accountId").append("=").append(params.get("accountId")).append("&");
        str.append("memberId").append("=").append(params.get("memberId")).append("&");
        str.append("merchantNo").append("=").append(params.get("merchantNo")).append("&");
        str.append("name").append("=").append(params.get("name")).append("&");
        //成功情况的验签
        if("1301".equals(params.get("bindCode"))){
            str.append("cardType").append("=").append(params.get("cardType")).append("&");
            str.append("cardNo").append("=").append(params.get("cardNo")).append("&");
            str.append("bankName").append("=").append(params.get("bankName")).append("&");
            str.append("key").append("=").append(UnspayConstants.KEY).append("&");
            if(params.get("mac").equals(UnspayUtils.MD5(str.toString()).toUpperCase())){
                return true;
            }
        }else{
            //失败情况的验签
            str.append("key").append("=").append(UnspayConstants.KEY).append("&");
            if(params.get("mac").equals(UnspayUtils.MD5(str.toString()).toUpperCase())){
                return true;
            }
        }
        return false;
    }

    /**
     * 银生宝扣款回调验签
     * @param params
     * @return
     */
    public static boolean quickPayBakcVerify(Map<String,String> params){
        StringBuilder str=new StringBuilder();
        str.append("accountId").append("=").append(UnspayConstants.ACCOUNT_ID).append("&");
        str.append("orderNo").append("=").append(params.get("orderNo")).append("&");
        str.append("batchNo").append("=").append(params.get("batchNo")).append("&");
        str.append("memberId").append("=").append(params.get("memberId")).append("&");
        str.append("bankName").append("=").append(params.get("bankName")).append("&");
        str.append("tailNo").append("=").append(params.get("tailNo")).append("&");
        str.append("amount").append("=").append(params.get("amount")).append("&");
        str.append("result_code").append("=").append(params.get("result_code")).append("&");
        str.append("result_msg").append("=").append(params.get("result_msg")).append("&");
        str.append("key").append("=").append(UnspayConstants.KEY);
        if(params.get("mac").equals(UnspayUtils.MD5(str.toString()).toUpperCase())){
            return true;
        }
        return false;
    }
    /**
     * 银生宝还款回调验签
     * @param params
     * @return
     */
    public static boolean delegatePayBackVerify(Map<String,String> params){
        StringBuilder str=new StringBuilder();
        str.append("accountId").append("=").append(UnspayConstants.ACCOUNT_ID).append("&");
        str.append("orderId").append("=").append(params.get("orderId")).append("&");
        str.append("amount").append("=").append(params.get("amount")).append("&");
        str.append("result_code").append("=").append(params.get("result_code")).append("&");
        str.append("result_msg").append("=").append(params.get("result_msg")).append("&");
        str.append("accountId").append("=").append(UnspayConstants.ACCOUNT_ID).append("&");
        str.append("key").append("=").append(UnspayConstants.KEY);
        if(params.get("mac").equals(UnspayUtils.MD5(str.toString()).toUpperCase())){
            return true;
        }
        return false;
    }
}
