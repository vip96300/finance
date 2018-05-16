package com.rw.finance.common.pass.unspay;

import com.google.gson.Gson;
import com.rw.finance.common.pass.unspay.utils.HttpUtils;
import com.rw.finance.common.pass.unspay.utils.UnspayUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huanghongfei
 * @Description 银生宝
 * @Date Create in 9:29 2018/4/26
 */
public class Unspay {

    private static Logger log= LoggerFactory.getLogger(Unspay.class);
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

    /*public static void main(String[] args) {
        Map<String,String> map=Unspay.reportRegister("1","徐桢","510219198011049158",0.56,3.0,0.50,2.0);
        System.err.println(1);
        //{"result_code":"0000","accountId":"2120180512094724001","result_msg":"受理成功","aduitMsg":"商户会员报件审核通过","memberId":"1","merchantNo":"2110000000000000000370","aduitCode":"1018"}
    }*/
    /*public static void main(String[] args) {
        Map<String,String> map=Unspay.reportRegister("2","陈浩","500113198802046513",0.56,3.0,0.50,2.0);
        System.err.println(1);
        //{"result_code":"0000","accountId":"2120180512094724001","result_msg":"受理成功","aduitMsg":"商户会员报件审核通过","memberId":"2","merchantNo":"2110000000000000000375","aduitCode":"1018"}
    }*/
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

    /*public static void main(String[] args) {
        Map<String,String> map=Unspay.reportUpdate("1","2110000000000000000370",0.56,3,0.55,3);
        System.err.println(map.get("aduitCode"));
    }*/

    /**
     * 绑卡
     */
    public static Map<String,String> bindH5bind(String memberId,String merchantNo,String cardNo,String phone,String expiryDate,String cvv2) throws Exception{
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
        .append("memberId=").append(memberId).append("&")
        .append("merchantNo=").append(merchantNo).append("&")
        .append("responseUrl=").append(UnspayConstants.BIND_H5_BIND_RESPONSE_URL).append("&")
        .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        //发起请求1
        Map<String,String> params1=UnspayUtils.strToMap(params.toString());
        String result1= HttpUtils.formRequest(UnspayConstants.BIND_H5_BIND_URL,params1);
        //填写卡号2
        Document doc2 = Jsoup.parseBodyFragment(result1);
        Elements inputs2=doc2.select("input");
        Map<String,String> params2=new HashMap<>(inputs2.size());
        for(int i=0;i<inputs2.size();i++){
            params2.put(inputs2.get(i).attr("name"),inputs2.get(i).val());
        }
        params2.put("cardNo",cardNo);
        String result2=HttpUtils.formRequest(UnspayConstants.BIND_H5_INPUT_URL,params2);
        //填写其他信息3
        Document doc3 = Jsoup.parseBodyFragment(result2);
        Elements inputs3=doc3.select("input");
        Map<String,String> params3=new HashMap<>(inputs3.size());
        for(int i=0;i<inputs3.size();i++){
            params3.put(inputs3.get(i).attr("name"),inputs3.get(i).val());
        }
        params3.put("phone",phone);
        if(params3.get("cardType").equals("0")){
            //借记卡只需要手机号
        }else{
            //贷记卡，安全码，有效期
            params3.put("validityPeriod",expiryDate);
            params3.put("cvv2",cvv2);
        }
        String result3=HttpUtils.formRequest(UnspayConstants.BIND_H5_CHECK_URL,params3);
        //填写验证码提交5
        Document doc4= Jsoup.parseBodyFragment(result3);
        Elements inputs4=doc4.select("input");
        Map<String,String> params4=new HashMap<>(inputs4.size());
        for(int i=0;i<inputs4.size();i++){
            params4.put(inputs4.get(i).attr("name"),inputs4.get(i).val());
        }
        //如果是借记卡需要主动发送验证码
        if(params3.get("cardType").equals("0")){
            //直接使用所有参数去获取验证码
            String sendCodeResult=HttpUtils.jsonRequest(UnspayConstants.BIND_H5_SEND_CODE_URL,params4);
            log.debug(sendCodeResult);
        }
        for(Map.Entry<String, String> map:params4.entrySet()){
            System.err.println("key="+map.getKey()+"/value="+map.getValue());
        }
        return params4;
    }

    /**
     * 输入短信验证码确认绑卡提交
     * @throws Exception
     */
    public static void bindH5bindSubmit(String cvv2,String idCardNo,String cardType,String bankName,String messageId,String cardNo,String expiryDate,String phone,String name,String safeCode,String merchantNo)throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("cvv2",cvv2);
        params.put("idCardNo",idCardNo);
        params.put("cardType",cardType);
        params.put("bankName",bankName);
        params.put("accountUserRSeq",messageId);
        params.put("cardNo",cardNo);
        params.put("validityPeriod",expiryDate);
        params.put("responseUrl",UnspayConstants.BIND_H5_BIND_RESPONSE_URL);
        params.put("phone",phone);
        params.put("name",name);
        params.put("safeCode",safeCode);
        params.put("merchantNo",merchantNo);
        String result4=HttpUtils.formRequest(UnspayConstants.BIND_H5_SUBMIT_URL,params);
        System.err.println(result4);
    }
    public static void main0(String[] args) throws Exception {
        Unspay.bindH5bind("1","2110000000000000000370","4637580008370243","18602368955","0620","321");
    }
    public static void main1(String[] args)throws Exception {
        Unspay.bindH5bindSubmit("321","510219198011049158","1","农业银行","158408","4637580008370243","0620","18602368955","徐桢","177038","2110000000000000000370");
    }
    /**
     * 解绑接口
     * @param memberId
     * @param merchantNo
     * @param token 卡片识别码
     * @return
     */
    public static Map bindUnBind(String memberId,String merchantNo,String token){
        StringBuilder params=new StringBuilder();
        params.append("accountId=").append(UnspayConstants.ACCOUNT_ID).append("&")
                .append("memberId=").append(memberId).append("&")
                .append("merchantNo=").append(merchantNo).append("&")
                .append("token=").append(token).append("&")
                .append("key=").append(UnspayConstants.KEY);
        System.err.println(params.toString());
        String mac= UnspayUtils.MD5(params.toString()).toUpperCase();
        params.append("&").append("mac=").append(mac);
        Map<String,String> map=UnspayUtils.strToMap(params.toString());
        map.remove("key");
        try {
            String result= HttpUtils.jsonRequest(UnspayConstants.BIND_UN_BIND_URL,UnspayUtils.strToMap(params.toString()));
            System.out.println(result);
            return new Gson().fromJson(result,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public static void main(String[] args) {
        Map<String,String> map=Unspay.bindUnBind("1","2110000000000000000370","8503728305389C82AA99A3A66B8E2AC6");
        System.err.println();
    }*/

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
            Map<String,String> params2=new HashMap<>(inputs.size());
            for(int i=0;i<inputs.size();i++){
                params2.put(inputs.get(i).attr("name"),inputs.get(i).val());
            }
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

    /**
     *
     * @param cardNo 卡号
     * @param orderId 订单号，需要从上一步参数获取
     * @param cardType 卡类型，需要从上一步参数中获取
     * @param phoneNo 手机号
     * @param verifyCode 短信验证码
     * @return
     */
    public static Map quickPayWapPaySubmit(String cardNo,String orderId,String cardType,String phoneNo,String verifyCode)throws Exception{
        Map<String,String> params2=new HashMap<>(5);
        params2.put("cardNo",cardNo);
        params2.put("orderId",orderId);
        params2.put("cardType",cardType);
        params2.put("delegatePayResponseUrl",UnspayConstants.DELEGATE_PAY_RESPONSE_URL);
        params2.put("phoneNo",phoneNo);
        params2.put("verifyCode",verifyCode);
        String result=HttpUtils.formRequest(UnspayConstants.QUICK_PAY_WAP_SUBMIT_URL,params2);
        System.err.println(result);
        //等待结果回调
        return null;
    }

    /*public static void main(String[] args) {
        Map<String,String> map=Unspay.quickPayWapPay("1711",1,"1","2110000000000000000370","8503728305389C82AA99A3A66B8E2AC6","9E00FD81C13B453511E1477B120892E1");
        System.err.println(1);
    }*/
    /*public static void main(String[] args)throws Exception {
        Unspay.quickPayWapPaySubmit("4637580008370243","1718","D","18602368955","248654");
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
