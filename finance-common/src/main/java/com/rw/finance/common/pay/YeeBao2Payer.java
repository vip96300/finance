package com.rw.finance.common.pay;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rw.finance.common.pass.yeepay2.Configuration;
import com.rw.finance.common.pass.yeepay2.YeepayService;
import com.rw.finance.common.pass.yeepay2.agent.PaymentQueryServlet;
import com.rw.finance.common.pass.yeepay2.agent.PaymentServlet;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.PayInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
import com.rw.finance.common.utils.UuidUtil;
/**
 * 
 * @file YeeBao2Payer.java	
 * @author huanghongfei
 * @date 2018年1月26日 下午1:10:26
 * @declaration
 */
public class YeeBao2Payer{

	private static final Logger log = LoggerFactory.getLogger(YeeBao2Payer.class);
	//获取token请求参数列表
    static String[] params = {"parentMerchantNo", "merchantNo", "OrderId", "OrderAmount", "timeoutExpress", "requestDate", "redirectUrl", "notifyUrl", "goodsParamExt", "paymentParamExt", "memo", "riskParamExt"};

    //数据存储
    static HashMap<String, String> orderData = new HashMap<String, String>();

    //请求数据存储
    static Map<String, String> requestBasicParams = new HashMap<String, String>();

    static {
        requestBasicParams.put("parentMerchantNo", Configuration.getInstance().getValue("merchantNo"));
        requestBasicParams.put("merchantNo", Configuration.getInstance().getValue("merchantNo"));
        requestBasicParams.put("notifyUrl",new YeeBao2Payer().getBackUrl());
    }
	
	public String getBackUrl() {
		return "http://api.rongyaozhixin.com/pay/back/yeeBao2PayBack";
	}

	public PayResult pay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo,PayInfo payInfo) {
		String OrderId = orderInfo.getTradeNo();
		String OrderAmount = String.valueOf(orderInfo.getBizAmount());
		String timeoutExpress = "60";
		String requestDate = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss");
		String redirectUrl = orderInfo.getBeforeBackUrl();
		String notifyUrl = orderInfo.getBackUrl();
		String goodsName = orderInfo.getProductInfo().getName();
		String goodsDesc = orderInfo.getProductInfo().getDetails();
		//String paymentParamExt = "YJZF".equals(method) ? "" : "{\"bankCardNo\":\"6217996900028884931\",\"idCardNo\":\"500241199101146517\",\"cardName\":\"曾宪学\"}";
		//String bizSource = "WEB";
		//String bizEntity = "荣耀之心";
		String memo = "-";
		String riskParamExt = "";
		String csUrl = "";
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		//String directPayType = payInfo.getMethod();
		String cardType = "";
		String appId = payInfo.getAppId();
		String openId = payInfo.getOpenId();
		String clientId = "";
		String userNo = UuidUtil.uuidBuilder();
		String userType = "USER_ID";
		
		String goodsParamExt = "{\"goodsName\":\""+goodsName+"\",\"goodsDesc\":\""+goodsDesc+"\"}";
		//String industryParamExt = "{\"bizSource\":\""+bizSource+"\",\"bizEntity\":\""+bizEntity+"\"}";
		String ext = "WECHAT".equals( payInfo.getMethod()) ? "{\"appId\":\""+appId+"\",\"openId\":\""+openId+"\",\"clientId\":\""+clientId+"\"}" : "";
		
		Map<String, String> params = new HashMap<>();
		params.put("OrderId", OrderId);
		params.put("OrderAmount", OrderAmount);
		params.put("timeoutExpress", timeoutExpress);
		params.put("requestDate", requestDate);
		params.put("redirectUrl", redirectUrl);
		params.put("notifyUrl", notifyUrl);
		params.put("goodsParamExt", goodsParamExt);
		//params.put("paymentParamExt", paymentParamExt);
		//params.put("industryParamExt", industryParamExt);
		params.put("memo", memo);
		params.put("riskParamExt", riskParamExt);
		params.put("csUrl", csUrl);
		
		Map<String, String> result = new HashMap<>();
		String uri = YeepayService.getUrl(YeepayService.TRADEORDER_URL);
		result = YeepayService.requestYOP(params, uri, YeepayService.TRADEORDER);
		
		String token = result.get("token");
		String codeRe = result.get("code");
		if(!"OPR00000".equals(codeRe)){
			String message = result.get("message");
			log.error("获取Token失败：{}", message);
			return new PayResult(result.get("code"), false, result.get("uniqueOrderNo"), orderInfo.getTradeNo(),result.get("message"), 0);
		}
					
		String parentMerchantNo = YeepayService.getParentMerchantNo();
		String merchantNo = YeepayService.getMerchantNo();
			
		params.put("parentMerchantNo", parentMerchantNo);
		params.put("merchantNo", merchantNo);
		params.put("OrderId", OrderId);
		params.put("token", token);
		params.put("timestamp", timestamp);
		//params.put("directPayType", directPayType);
		params.put("cardType", cardType);
		params.put("userNo", userNo);
		params.put("userType", userType);
		params.put("ext", ext);
		String url="";
		try {
			url = YeepayService.getUrl(params);
			log.info("Redirect URL : {}", url);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new PayResult(result.get("code"), result.get("code").equals("OPR00000"), result.get("uniqueOrderNo"), orderInfo.getTradeNo(), url, 0);
	}
	/**
	 * 查询订单
	 * @param orderInfo
	 * @return
	 */
	public PayResult queryOrder(PayerBo.OrderInfo orderInfo){
		Map<String, String> params = new HashMap<>();
		params.put("OrderId", orderInfo.getTradeNo());
		params.put("uniqueOrderNo", orderInfo.getPayTradeNo());
		Map<String, String> result = new HashMap<String, String>();
		String uri = YeepayService.getUrl(YeepayService.ORDERQUERY_URL);
		result = YeepayService.requestYOP(params, uri, YeepayService.ORDERQUERY);
		System.err.println(result);
		return new PayResult(result.get("code"), result.get("status").equals("SUCCESS"), orderInfo.getPayTradeNo(), orderInfo.getTradeNo(), "", 0);
	}
	/**
	 * 易宝代付订单查询接口
	 * @param orderInfo
	 * @return
	 */
	public PayResult queryAgentOrder(PayerBo.OrderInfo orderInfo){
		Map<String,String> params=PaymentQueryServlet.doPost(orderInfo);
		List<Map<String,Object>> orders=new Gson().fromJson(params.get("list"),List.class);
		return new PayResult(orders.get(0).get("transferStatusCode").toString(),orders.get(0).get("transferStatusCode").equals("0026"),"", orderInfo.getTradeNo(),"", 0);
	}
	/**
	 * 易宝代付转账接口
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 * @return
	 */
	public PayResult agentPay(UserInfo userInfo, CardInfo cardInfo,OrderInfo orderInfo){
		Map<String,String> params=PaymentServlet.doPost(userInfo, cardInfo, orderInfo);
		return new PayResult(params.get("errorCode"), params.get("errorCode").equals("BAC001"),"", orderInfo.getTradeNo(),params.get("errorMsg"), 0);
	}
	
}
