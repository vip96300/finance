package com.rw.finance.client.controller;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.innovatepay.merchsdk.util.CheckSign;
import com.rw.finance.client.utils.HttpUtils;
import com.rw.finance.common.pass.chuangxin.ChuangXinPay;
import com.rw.finance.common.pass.unspay.Unspay;
import com.rw.finance.common.pass.unspay.UnspayConstants;
import com.rw.finance.common.pass.unspay.utils.UnspayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.rw.finance.common.pass.chuangxin.ChuangXinPayResponse;
import com.rw.finance.common.pass.jdsoft.utils.KeyInitialzer;
import com.rw.finance.common.pass.jdsoft.utils.RSAHelper;
import com.rw.finance.common.pass.yeepay.utils.PaymobileUtils;
import com.rw.finance.common.pass.yeepay2.YeepayService;
import com.rw.finance.client.service.PayResultService;
import com.yeepay.g3.facade.yop.ca.dto.DigitalEnvelopeDTO;
import com.yeepay.g3.facade.yop.ca.enums.CertTypeEnum;
import com.yeepay.g3.frame.yop.ca.DigitalEnvelopeUtils;
import com.yeepay.g3.sdk.yop.utils.InternalConfig;

/**
 * 支付回调
 * @file PayResultController.java	
 * @author huanghongfei
 * @date 2017年12月23日 下午5:16:39
 * @declaration
 */
@RestController
@RequestMapping(value="/pay/back")
public class PayResultController {

	@Autowired
	private PayResultService payResultService;

	private static Logger log= LoggerFactory.getLogger(PayResultController.class);

	/**
	 * 爱农支付回调(eynon支付回调)
	 * @return
	 */
	@RequestMapping(value="/eynonPayBack")
	public Object eynonBack(@RequestParam(value="merOrderId")String merOrderId){
		return "success";
	}
	/**
	 * 创新支付回调接口
	 * @return
	 */
	@RequestMapping(value="/ChuangXinPayBack")
	public ChuangXinPayResponse chuangXinBack(@RequestParam(value="orderNo")String orderNo,
			@RequestParam(name="cxOrderNo")String cxOrderNo,
			@RequestParam(value="merchantNo")String merchantNo,
			@RequestParam(name="dealCode")String dealCode,
			@RequestParam(value="dealMsg",required = false)String dealMsg,
			@RequestParam(value="sign")String sign,
			HttpServletRequest request){
		//验签
		Map<String,String> params=new HashMap<>();
		for(Map.Entry<String, String[]> map:request.getParameterMap().entrySet()){
			params.put(map.getKey(),map.getValue().length==0?null:map.getValue()[0]);
		}
		if(!CheckSign.check(new Gson().toJson(params), ChuangXinPay.PUBLIC_KEY)){
			log.error("check sign failed,sign:{}",sign);
			return null;
		}
		//处理中
		if("10001".equals(dealCode)){
			return null;
		}
		payResultService.chuangXinPayBack(orderNo,cxOrderNo,dealCode,dealMsg);
		return new ChuangXinPayResponse(merchantNo, "SUCCESS",sign);
	}
	/**
	 * 易宝支付回调
	 * @param data
	 * @param encryptkey
	 * @return
	 */
	@RequestMapping(value="/yeeBaoPayBack")
	public String yeeBaoPayBack(@RequestParam(value="data")String data,
			@RequestParam(value="encryptkey")String encryptkey){
		//解密data
		TreeMap<String, String>	dataMap	= PaymobileUtils.decrypt(data, encryptkey);
		//sign验签
		if(!PaymobileUtils.checkSign(dataMap)) {
			throw new RuntimeException("server under attack");
		}
		payResultService.yeeBaoPayBack(dataMap.get("OrderId"));
		return "SUCCESS";
	}
	/**
	 * 易宝支付回调
	 * @return
	 */
	@RequestMapping(value="/yeeBao2PayBack")
	public String yeeBao2PayBack(@RequestParam(value="response")String response,
			@RequestParam(value="customerIdentification")String customerIdentification){
		log.info("response:{}",response);
		log.info("customerIdentification:{}",customerIdentification);
		Map<String,String> result=YeepayService.callback(response);
		payResultService.yeeBao2PayBack(result.get("OrderId"));
		return "SUCCESS";
	}
	/**
	 * 易宝2代付回调
	 * @return
	 */
	@RequestMapping(value="/yeeBao2AgentPayBack")
	public String yeeBao2AgentPayBack(HttpServletRequest request){
		DigitalEnvelopeDTO dto = new DigitalEnvelopeDTO();
		dto.setCipherText(request.getParameter("response"));
		PrivateKey privateKey = InternalConfig.getISVPrivateKey(CertTypeEnum.RSA2048);
		PublicKey publicKey = InternalConfig.getYopPublicKey(CertTypeEnum.RSA2048);
		dto = DigitalEnvelopeUtils.decrypt(dto, privateKey, publicKey);
		Map<String, String> jsonMap =JSON.parseObject(dto.getPlainText(),new TypeReference<TreeMap<String, String>>() {});
		payResultService.yeeBao2AgentPayBack(jsonMap.get("OrderId"));
		return "SUCCESS";
	}
	/**
	 * 绝顶支付回调
	 * @param data 密文
	 * @return
	 */
	@RequestMapping(value="/jdsoftPayBack")
	public String jdsoftPayBack(@RequestParam(value="data")String data){
		RSAPrivateKey rsaPrivateKey = KeyInitialzer.initPrivateKey();
		data=RSAHelper.decryptWithPKCS1(data,rsaPrivateKey);
		System.err.println(data);
		Map<String,Object> params=new Gson().fromJson(data, Map.class);
		payResultService.jdsoftPayBack(params.get("reqMsgId").toString());
		return "success";
	}

	/**
	 * 银生宝h5绑卡回调地址
	 * @param request
	 */
	@RequestMapping(value="/unspay/h5BindBack")
	public void h5bindBack(HttpServletRequest request){
		Map<String,String> params=new HashMap<>(request.getParameterMap().size());
		for(Map.Entry<String, String[]> map:request.getParameterMap().entrySet()){
			params.put(map.getKey(),map.getValue()[0]);
		}
		//验签
		if(!UnspayUtils.h5BindBackVerify(params)){
			log.error("h5BindBack verify failed");
			return;
		}
		payResultService.unspayH5BindBack(Long.valueOf(params.get("memberId")),params.get("cardNo"),params.get("token"));
	}

	/**
     * 已过期
	 * wap版本代还接口
	 * @param response
	 */
	@Deprecated
	@RequestMapping(path="/unspay/quickPayWapPay")
	public void quickPayWapPay(HttpServletResponse response){
		Map<String,String> map=Unspay.quickPayWapPay("1112",2.00,"98765432",
				"2110000000000000000094",
				"7C20B926B8D22C01630B432870AF20C8",
				"5E2309EB6ADEE73D6C38425515ACF492");
		try {
			HttpUtils.redirect(UnspayConstants.QUICK_PAY_WAP_PAY_URL,map,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 银生宝扣款回调
	 * @param request
	 */
	@RequestMapping(value="/unspay/quickPayBack")
	public void quickPayBakc(HttpServletRequest request){
		Map<String,String> params=new HashMap<>(request.getParameterMap().size());
		for(Map.Entry<String, String[]> map:request.getParameterMap().entrySet()){
			params.put(map.getKey(),map.getValue()[0]);
		}
		//验签
		if(!UnspayUtils.quickPayBakcVerify(params)){
			log.error("h5BindBack verify failed");
			return;
		}
		//TODO 开始回调
	}
	/**
	 * 银生宝还款回调
	 * @param request
	 */
	@RequestMapping(value="/unspay/delegatePayBack")
	public void delegatePayBack(HttpServletRequest request){
		Map<String,String> params=new HashMap<>(request.getParameterMap().size());
		for(Map.Entry<String, String[]> map:request.getParameterMap().entrySet()){
			params.put(map.getKey(),map.getValue()[0]);
		}
		//验签
		if(!UnspayUtils.delegatePayBackVerify(params)){
			log.error("h5BindBack verify failed");
			return;
		}
		//TODO 开始回调
	}
}
