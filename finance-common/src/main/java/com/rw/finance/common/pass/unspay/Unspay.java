package com.rw.finance.common.pass.unspay;

import com.google.gson.Gson;
import com.rw.finance.common.pass.unspay.utils.HttpUtils;
import com.rw.finance.common.pass.unspay.utils.UnspayUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huanghongfei
 * @Description 银生宝
 * @Date Create in 9:29 2018/4/26
 */
public class Unspay {

    /**
     * 报件
     */
    public static Map<String,String> reportRegister(String memberId, String name, String certNo, double d0FreeRate, double d0FixedFee, double t1FreeRate, double t1FixedFee){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&").
        append("memberId=").append(memberId).append("&")
        .append("name=").append(name).append("&")
        .append("certType=").append("1").append("&")
        .append("certNo=").append(certNo).append("&")
        .append("D0FeeRate=").append(d0FreeRate).append("&")
        .append("D0FixedFee=").append(d0FixedFee).append("&")
        .append("T1FeeRate=").append(t1FreeRate).append("&")
        .append("T1FixedFee=").append(t1FixedFee).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.REPORT_REGISTER_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询报件
     * @param memberId
     * @param merchantNo
     * @return
     */
    public static Map<String,String> reportQueryInfo(String memberId, String merchantNo){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("memberId=").append(memberId).append("&")
        .append("merchantNo=").append(merchantNo).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.REPORT_QUERY_INFO_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改报件
     * @param memberId
     * @param merchantNo
     * @return
     */
    public static Map<String,String> reportUpdate(String memberId, String merchantNo, double d0FreeRate, double d0FixedFee, double t1FreeRate, double t1FixedFee){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&").
        append("memberId=").append(memberId).append("&")
        .append("merchantNo=").append(merchantNo).append("&")
        .append("D0FeeRate=").append(d0FreeRate).append("&")
        .append("D0FixedFee=").append(d0FixedFee).append("&")
        .append("T1FeeRate=").append(t1FreeRate).append("&")
        .append("T1FixedFee=").append(t1FixedFee).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.REPORT_UPDATE_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 绑卡
     */
    public static Map bindH5bind(String memberId,String merchantNo){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("memberId=").append(memberId).append("&")
        .append("merchantNo=").append(merchantNo).append("&")
        .append("responseUrl=").append(UnspayConstants.BIND_H5_BIND_RESPONSE_URL).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        Map<String,String> map=UnspayUtils.strToMap(params.toString());
        map.remove("key");
        return map;
    }
    /**
     * 绑卡查询
     */
    public static Map bindQueryCardInfo(String memberId,String merchantNo){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("memberId=").append(memberId).append("&")
        .append("merchantNo=").append(merchantNo).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.BIND_QUERY_CARD_INFO_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * WAP版代还
     */
    public static Map quickPayWapPay(String orderNo,double amount,String memberId,String merchantNo,String deductCardToken,String repayCardToken){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
            .append("orderNo=").append(orderNo).append("&")
            .append("amount=").append(amount).append("&")
            .append("memberId=").append(memberId).append("&")
            .append("merchantNo=").append(merchantNo).append("&")
            .append("deductCardToken=").append(deductCardToken).append("&")
            .append("repayCardToken=").append(repayCardToken).append("&")
            .append("repayCycle=").append("D0").append("&")
            .append("purpose=").append("repay").append("&")
            .append("quickPayResponseUrl=").append(UnspayConstants.QUICK_PAY_RESPONSE_URL).append("&")
            .append("delegatePayResponseUrl=").append(UnspayConstants.DELEGATE_PAY_RESPONSE_URL).append("&")
            .append("pageResponseUrl=").append("http://baidu.com").append("&")
            .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        System.err.println(params.toString());
        try {
            String result= HttpUtils.formRequest(UnspayConstants.QUICK_PAY_WAP_PAY_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            //确认信息
            Document doc = Jsoup.parseBodyFragment(result);
            Elements inputs=doc.select("input");
            Map<String,String> params2=new HashMap<>(5);
            params2.put("cardNo",inputs.get(0).val());
            params2.put("orderId",inputs.get(1).val());
            params2.put("cardType",inputs.get(2).val());
            params2.put("delegatePayResponseUrl",inputs.get(3).val());
            params2.put("phoneNo",inputs.get(4).val());
            result=HttpUtils.formRequest(UnspayConstants.QUICK_PAY_WAP_AUTH_URL,params2);
            System.err.println(result);
            //发送手机验证码
            result=HttpUtils.formRequest(UnspayConstants.QUICK_PAY_WAP_SEND_VERIFY_CODE_URL,params2);
            System.err.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UnspayUtils.strToMap(params.toString());
    }
    public static void main(String[] args) {
        Map<String,String> map=Unspay.quickPayWapPay("0929",2.00,"98765432",
                "2110000000000000000094",
                "7C20B926B8D22C01630B432870AF20C8",
                "5E2309EB6ADEE73D6C38425515ACF492");
        System.err.println(1);
    }
    /*public static void main(String[] args)throws Exception {
        Map<String,String> params2=new HashMap<>(5);
        params2.put("cardNo","6225882304840173");
        params2.put("orderId","0929");
        params2.put("cardType","D");
        params2.put("delegatePayResponseUrl","http://huanghongfei.free.ngrok.cc/pay/back/unspay/delegatePayBack");
        params2.put("phoneNo","18996121709");
        params2.put("verifyCode","263251");
        String result=HttpUtils.formRequest(UnspayConstants.QUICK_PAY_WAP_SUBMIT_URL,params2);
        System.err.println(result);
    }*/
    /**
     * 接口版代还(首次还款不能使用接口版)
     */
    public static Map quickPayInterfacePay(String orderNo,int batchNo,double amount,String memberId,String merchantNo,String deductCardToken,String repayCardToken){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("orderNo=").append(orderNo).append("&")
        .append("batchNo=").append(batchNo).append("&")
        .append("amount=").append(amount).append("&")
        .append("memberId=").append(memberId).append("&")
        .append("merchantNo=").append(merchantNo).append("&")
        .append("deductCardToken=").append(deductCardToken).append("&")
        .append("repayCardToken=").append(repayCardToken).append("&")
        .append("repayCycle=").append("D0").append("&")
        .append("purpose=").append("还款").append("&")
        .append("quickPayResponseUrl=").append(UnspayConstants.QUICK_PAY_RESPONSE_URL).append("&")
        .append("delegatePayResponseUrl=").append(UnspayConstants.DELEGATE_PAY_RESPONSE_URL).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.formRequest(UnspayConstants.QUICK_PAY_INTERFACE_PAY_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询扣款订单
     */
    public static Map queryQueryQuickPayOrderStatus(String orderNo){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("orderNo=").append(orderNo).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.QUERY_QUERY_QUICK_PAY_ORDER_STATUS_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询还款订单
     */
    public static Map queryQueryDelegatePayOrderStatus(String orderNo){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("orderNo=").append(orderNo).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.QUERY_QUERY_DELEGATE_PAY_ORDER_STATUS_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
