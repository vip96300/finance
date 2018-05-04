package com.rw.finance.common.pass.chuangxin;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.innovatepay.merchsdk.DefaultChinaInPayClient;
import com.innovatepay.merchsdk.request.ChinaInPayOnePayRequest;
import com.innovatepay.merchsdk.request.ChinaInPayQuickPayRequest;
import com.innovatepay.merchsdk.request.ChinaInPayRefundRequest;
import com.innovatepay.merchsdk.request.ChinaInPayRequest;
import com.innovatepay.merchsdk.request.ChinaInPaySameNamePayRequest;
import com.innovatepay.merchsdk.request.ChinaInPaySearchOrder;
import com.innovatepay.merchsdk.util.AESUtil;
import com.innovatepay.merchsdk.util.Base64Util;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerBo.CardInfo;
import com.rw.finance.common.pay.PayerBo.OrderInfo;
import com.rw.finance.common.pay.PayerBo.UserInfo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.UuidUtil;

/**
 * 创新支付
 * 
 * @file ChuangXinPay.java
 * @author huanghongfei
 * @date 2018年1月8日 下午2:15:33
 * @declaration
 */
public class ChuangXinPay {
	/**
	 * 公钥
	 */
	public static final String PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDTwGNIrCohQmBiP+L1h7urcTa4JBYGzGWylkqtS20dHuCCafU7aVgYxFqMc7ZdpgAL0052+c+i2H9ecdMnaXSRXocZBJepN0d9RA6txWvppLNpzBFsU5VVXFdpndn7EGhLiCV7aPag3+GIC0QZfhMMfra4iEBzrVjJ8uudO9j6wIDAQAB";
	/**
	 * 私钥
	 */
	private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAINPAY0isKiFCYGI/4vWHu6txNrgkFgbMZbKWSq1LbR0e4IJp9TtpWBjEWoxztl2mAAvTTnb5z6LYf15x0ydpdJFehxkEl6k3R31EDq3Fa+mks2nMEWxTlVVcV2md2fsQaEuIJXto9qDf4YgLRBl+Ewx+triIQHOtWMny65072PrAgMBAAECgYAnWrSCUlVUDJtuwVql1ITs0BPh7dAVOAFCyl6zGB4cqZSiwrYUcS1RmB+ODmOKdarU01h38Np7ulaiG6+J3O3nhmIF1krBtvBIxCnlAu5NyZP2l/Gv1r8FXrETjWTgg7b6/rZk4qdElzR8TTAooPsBmBAj7VPIgfTjc8nfWd0ysQJBAPktAsK/2QY37d5ueCfEUfaslUoJg3RfxEL355XHxgqfm1NjD5+0FspQkC8LG07Sx2O/hFi8ALdgjfYkRgSSGG8CQQCG55642k2Alyr5OFuCAbkhWCeutcn5YdTms+zlik5h4xoWDL8JqoqhoZumyOPlzqhLWtpIwNAdiwhumz7/GRJFAkEAwWk0uWIc3PzQwFTTI1r5nBU+FCfqR4yGVM0Ej3hvupNFB6be28H35rY+FKX0XmyxpDVmT1Iu5CgoSSTCzI1yNQJAJZEWaA+SiX6PHvuMr/Ve4mQ0GLjS17lgmiX8kCclkKi3OPCvujddh4kDWTyUCgi0YNeZ9ayLx85RuMtOjacjqQJBAJYHVDBGqlixZoIfTCvM/f3p7YQw6lIYhD2P7KthCE0dnXqALngQAgy+8yVagUiglm9kJ0Mapper5DyCx4Me3RitxE=";
	/**
	 * 商户号
	 */
	private static final String merchantNo = "CX0002552";
	/**
	 * aes加密key
	 */
	private static final String AES_KEY="380701bca8ae4585b78b605ec075fbc1";
	
	/**
	 * 快捷支付预下单接口
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 */
	public static String quickPayApply(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo){
		ChinaInPayQuickPayRequest params=new ChinaInPayQuickPayRequest();
		params.setService("quickPayApply");
		params.setMerchantNo(merchantNo);
		params.setBgUrl(orderInfo.getBackUrl());
		params.setVersion("V2.0");
		params.setPayChannelCode(cardInfo.getPayerBankAbbreviation());
		params.setPayChannelType("6");
		params.setOrderNo(orderInfo.getTradeNo());
		params.setOrderAmount(String.valueOf((int)(orderInfo.getBizAmount()*100)));
		params.setCurCode("CNY");
		params.setOrderTime(DateUtils.getTimeStr(new Date()).replace("-","").replace(":","").replace(" ", ""));
		params.setProductName("商品名称");
		params.setBankCardNo(AESUtil.AESEncode(AES_KEY,cardInfo.getPayerCardNo()));
		params.setIdType("01");
		params.setUserName(AESUtil.AESEncode(AES_KEY,userInfo.getPayerRealName()));
		params.setIdCode(AESUtil.AESEncode(AES_KEY,userInfo.getPayerIdNo()));
		params.setPhone(AESUtil.AESEncode(AES_KEY, cardInfo.getPayerCardMobile()));
		params.setCvv2(AESUtil.AESEncode(AES_KEY, cardInfo.getPayerCardCvv2()));
		params.setValidPeriod(AESUtil.AESEncode(AES_KEY, cardInfo.getPayerCardExpire()));
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPayQuickPayRequest> request = new ChinaInPayRequest<ChinaInPayQuickPayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/quickPay";
		String serviceName = "quickPayApply";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 快捷确认支付
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 */
	public static String quickPayConfirm(OrderInfo orderInfo){
		ChinaInPayQuickPayRequest params=new ChinaInPayQuickPayRequest();
		params.setService("quickPayConfirm");
		params.setMerchantNo(merchantNo);
		params.setBgUrl(orderInfo.getBackUrl());
		params.setVersion("V2.0");
		params.setOrderNo(orderInfo.getTradeNo());
		params.setSmsCode(orderInfo.getSmsCode());
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPayQuickPayRequest> request = new ChinaInPayRequest<ChinaInPayQuickPayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/quickPay";
		String serviceName = "quickPayConfirm";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 快捷支付：当预下单返回参数needSms值为0时，重发短信。
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 */
	public static String quickPayReSendVfCode(OrderInfo orderInfo){
		ChinaInPayQuickPayRequest params=new ChinaInPayQuickPayRequest();
		params.setService("quickPayReSendVfCode");
		params.setMerchantNo(merchantNo);
		params.setVersion("V2.0");
		params.setOrderNo(orderInfo.getTradeNo());
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPayQuickPayRequest> request = new ChinaInPayRequest<ChinaInPayQuickPayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/quickPay";
		String serviceName = "quickPayReSendVfCode";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 创新支付代付接口，超过五万验证BankName，bankProvcince，bankCity字段信息，反之不验证。
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 */
	public static String payForSameName(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo){
		ChinaInPaySameNamePayRequest params=new ChinaInPaySameNamePayRequest();
		params.setService("payForSameName");
		params.setMerchantNo(merchantNo);
		params.setOrderNo(orderInfo.getTradeNo());
		params.setOrderNoList(orderInfo.getRemark());
		params.setVersion("V2.0");
		params.setAccountProp("1");
		params.setAccountNo(Base64Util.encodeData(cardInfo.getPayerCardNo()));
		params.setAccountName(Base64Util.encodeData(userInfo.getPayerRealName()));
		params.setBankGenneralName(cardInfo.getPayerBankName());
		params.setBankName(cardInfo.getPayerBankName());
		params.setBankCode(cardInfo.getPayerBankAbbreviation());
		params.setCurrency("CNY");
		params.setBankProvcince(cardInfo.getPayerBankProvince()==null?"0":cardInfo.getPayerBankProvince());
		params.setBankCity(cardInfo.getPayerBankCity()==null?"0":cardInfo.getPayerBankProvince());
		params.setOrderAmount(String.valueOf((int)(orderInfo.getBizAmount()*100)));
		params.setTel(cardInfo.getPayerCardMobile());
		params.setCause("0");
		params.setOrderTime(DateUtils.getTimeStr(new Date()).replace("-","").replace(":","").replace(" ", ""));
		params.setNotifyUrl(orderInfo.getBackUrl());
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPaySameNamePayRequest> request = new ChinaInPayRequest<ChinaInPaySameNamePayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/agentPay";
		String serviceName = "payForSameName";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*public static void main(String[] args) {
		ChinaInPaySameNamePayRequest params=new ChinaInPaySameNamePayRequest();
		String orderList="201804030915551965367938";
		String accountNo="4041170078350083";
		String accountName="钟宇涛";
		String bankGenneralName="中国农业银行";
		String BankName="中国农业银行";
		String bankCode="ABC";
		double amount=754.01;
		String tel="13922738765";
		params.setService("payForSameName");
		params.setMerchantNo(merchantNo);
		params.setOrderNo(UuidUtil.TradeNoBuilder(""));
		params.setOrderNoList(orderList);
		params.setVersion("V2.0");
		params.setAccountProp("1");
		params.setAccountNo(Base64Util.encodeData(accountNo));
		params.setAccountName(Base64Util.encodeData(accountName));
		params.setBankGenneralName(bankGenneralName);
		params.setBankName(BankName);
		params.setBankCode(bankCode);
		params.setCurrency("CNY");
		params.setBankProvcince("信用卡中心");
		params.setBankCity("信用卡中心");
		params.setOrderAmount(amount*100+"");
		params.setTel(tel);
		params.setCause("0");
		params.setOrderTime(DateUtils.getTimeStr(new Date()).replace("-","").replace(":","").replace(" ", ""));
		params.setNotifyUrl("0");
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPaySameNamePayRequest> request = new ChinaInPayRequest<ChinaInPaySameNamePayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/agentPay";
		String serviceName = "payForSameName";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * 3.单笔付款接口3.1接口说明创新支付代付接口，超过五万验证BankName，bankProvcince，bankCity字段信息，反之不验证。
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 * @return
	 */
	public static String payForAnotherOne(UserInfo userInfo,CardInfo cardInfo,OrderInfo orderInfo){
		ChinaInPayOnePayRequest params=new ChinaInPayOnePayRequest();
		params.setService("payForAnotherOne");
		params.setMerchantNo(merchantNo);
		params.setNotifyUrl(orderInfo.getBackUrl());
		params.setOrderNo(orderInfo.getTradeNo());
		params.setVersion("V2.0");
		params.setAccountProp("1");
		params.setAccountNo(Base64Util.encodeData(cardInfo.getPayerCardNo()));
		params.setAccountName(Base64Util.encodeData(userInfo.getPayerRealName()));
		params.setBankGenneralName(cardInfo.getPayerBankName());
		params.setBankName(cardInfo.getPayerBankName());
		params.setBankCode(cardInfo.getPayerBankAbbreviation());
		params.setCurrency("CNY");
		params.setBankProvcince(cardInfo.getPayerBankProvince()==null?"0":cardInfo.getPayerBankProvince());
		params.setBankCity(cardInfo.getPayerBankCity()==null?"0":cardInfo.getPayerBankProvince());
		params.setOrderAmount(String.valueOf((int)(orderInfo.getBizAmount()*100)));
		params.setTel(cardInfo.getPayerCardMobile());
		params.setCause("0");
		params.setOrderTime(DateUtils.getTimeStr(new Date()).replace("-","").replace(":","").replace(" ", ""));
		params.setNotifyUrl(orderInfo.getBackUrl());
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPayOnePayRequest> request = new ChinaInPayRequest<ChinaInPayOnePayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/agentPay";
		String serviceName = "payForAnotherOne";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(orderInfo.getTradeNo());
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 商户用商户订单号查询同名付款订单的信息，同名付款交易一般30 秒内有结果。
	 * @param orderInfo
	 * @return
	 */
	public static String payForAnotherOneSearch(OrderInfo orderInfo){
		ChinaInPayOnePayRequest params=new ChinaInPayOnePayRequest();
		params.setService("payForAnotherOneSearch");
		params.setMerchantNo(merchantNo);
		params.setOrderNo(orderInfo.getTradeNo());
		params.setVersion("V2.0");
		params.setOrderSource("1");
		ChinaInPayRequest<ChinaInPayOnePayRequest> request = new ChinaInPayRequest<ChinaInPayOnePayRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/agentPay";
		String serviceName = "payForAnotherOneSearch";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 商户用商户订单号查询快捷订单的信息，同名付款交易一般30 秒内有结果。
	 * @param orderInfo
	 * @return
	 */
	public static String payForAnotherOneSearchForQuckly(OrderInfo orderInfo){
		ChinaInPaySearchOrder chinaInPaySearchOrder=new ChinaInPaySearchOrder();
		chinaInPaySearchOrder.setService("paySearchOrder");
		chinaInPaySearchOrder.setMerchantNo(merchantNo);
		chinaInPaySearchOrder.setOrderNo(orderInfo.getTradeNo());
		chinaInPaySearchOrder.setVersion("V2.0");
		ChinaInPayRequest<ChinaInPaySearchOrder> request = new ChinaInPayRequest<ChinaInPaySearchOrder>();
		request.setTransDetail(chinaInPaySearchOrder);
		String url = "http://service.gaohuitong.com/PayApi/paySearchOrder";
		String serviceName = "paySearchOrder";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ChuangXinPay.PayOrder payOrder=new Gson().fromJson(new PayerFactory().ChuangXinPayer().queryOrder(new com.rw.finance.common.pay.PayerBo().new OrderInfo("201804121302181718401771", "", 0 ,0, "", "")).getResult(), ChuangXinPay.PayOrder.class);
		System.err.println(payOrder.getDealCode());
	}
	/**
	 * 退款
	 * @param orderInfo
	 * @return
	 */
	public static String refundOrder(OrderInfo orderInfo){
		ChinaInPayRefundRequest params=new ChinaInPayRefundRequest();
		params.setService("refundOrder");
		params.setMerchantNo(merchantNo);
		params.setRefundNo(UuidUtil.TradeNoBuilder(""));
		params.setOrderNo(orderInfo.getTradeNo());
		params.setVersion("V2.0");
		params.setCurCode("CNY");
		params.setRefundAmount(String.valueOf((int)(orderInfo.getBizAmount()*100)));
		params.setRefundTime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		params.setRefundDesc("");
		ChinaInPayRequest<ChinaInPayRefundRequest> request = new ChinaInPayRequest<ChinaInPayRefundRequest>();
		request.setTransDetail(params);
		String url = "http://service.gaohuitong.com/PayApi/refundOrder";
		String serviceName = "refundOrder";
		DefaultChinaInPayClient client = new DefaultChinaInPayClient(url,serviceName, PRIVATE_KEY);
		try {
			String result = client.execute(request);
			System.err.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*public static void main(String[] orgs){
		ChuangXinPay.refundOrder(new PayerBo().new OrderInfo("2018022709533375308897","",98.4,"",""));
	}*/
	public static class Result{
		/**
		 * 商户编号（商户在的唯一标识）
		 */
		private String merchantNo;
		/**
		 * 结果代码（创新支付支付结果代码，为10000代表支付成功）
		 */
		private String dealCode;
		/**
		 * 结果消息
		 */
		private String dealMsg;
		/**
		 * 商户订单号
		 */
		private String orderNo;
		/**
		 * 支付订单号
		 */
		private String cxOrderNo;
		/**
		 * 订单金额（分）
		 */
		private String OrderAmount;
		/**
		 * 该笔支付是否需要短信验证码（本笔订单确认支付时，是否需要短信验证码0需要1不需要）
		 */
		private String needSms;
		/**
		 * 签名
		 */
		private String sign;
		public String getMerchantNo() {
			return merchantNo;
		}
		public void setMerchantNo(String merchantNo) {
			this.merchantNo = merchantNo;
		}
		public String getDealCode() {
			return dealCode;
		}
		public void setDealCode(String dealCode) {
			this.dealCode = dealCode;
		}
		public String getDealMsg() {
			return dealMsg;
		}
		public void setDealMsg(String dealMsg) {
			this.dealMsg = dealMsg;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getCxOrderNo() {
			return cxOrderNo;
		}
		public void setCxOrderNo(String cxOrderNo) {
			this.cxOrderNo = cxOrderNo;
		}
		public String getOrderAmount() {
			return OrderAmount;
		}
		public void setOrderAmount(String OrderAmount) {
			this.OrderAmount = OrderAmount;
		}
		public String getNeedSms() {
			return needSms;
		}
		public void setNeedSms(String needSms) {
			this.needSms = needSms;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
	}
	/**
	 * 创新支付订单对象
	 * @file ChuangXinPay.java	
	 * @author huanghongfei
	 * @date 2018年1月10日 下午2:57:36
	 * @declaration
	 */
	public class PayOrder{
		/**
		 * 商户订单号
		 */
		private String merchantNo;
		/**
		 * 处理结果代码
		 */
		private String dealCode;
		/**
		 * 处理结果信息
		 */
		private String dealMsg;
		/**
		 * 商户订单号
		 */
		private String orderNo;
		/**
		 * 创新支付订单号
		 */
		private String cxOrderNo;
		/**
		 * 商户订单金额
		 */
		private String OrderAmount;
		/**
		 * 交易币种
		 */
		private String curCode;
		/**
		 * 订单时间
		 */
		private String orderTime;
		/**
		 * 创新支付交易时间
		 */
		private String dealTime;
		/**
		 * 手续费
		 */
		private String fee;
		/**
		 * 订单状态
		 */
		private int orderStatus;
		/**
		 * 开户行名称
		 */
		private String BankName;
		/**
		 * 开户行编码
		 */
		private String bankCode;
		/**
		 * 银行帐号
		 */
		private String accountNo;
		/**
		 * 收款
		 */
		private String accountName;
		/**
		 * 货币类型
		 */
		private String currency;
		/**
		 * 手机号
		 */
		private String tel;
		/**
		 * 打款原因
		 */
		private String cause;
		/**
		 * 签名数据
		 */
		private String sign;
		public String getMerchantNo() {
			return merchantNo;
		}
		public void setMerchantNo(String merchantNo) {
			this.merchantNo = merchantNo;
		}
		public String getDealCode() {
			return dealCode;
		}
		public void setDealCode(String dealCode) {
			this.dealCode = dealCode;
		}
		public String getDealMsg() {
			return dealMsg;
		}
		public void setDealMsg(String dealMsg) {
			this.dealMsg = dealMsg;
		}
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getCxOrderNo() {
			return cxOrderNo;
		}
		public void setCxOrderNo(String cxOrderNo) {
			this.cxOrderNo = cxOrderNo;
		}
		public String getOrderAmount() {
			return OrderAmount;
		}
		public void setOrderAmount(String OrderAmount) {
			this.OrderAmount = OrderAmount;
		}
		public String getCurCode() {
			return curCode;
		}
		public void setCurCode(String curCode) {
			this.curCode = curCode;
		}
		public String getOrderTime() {
			return orderTime;
		}
		public void setOrderTime(String orderTime) {
			this.orderTime = orderTime;
		}
		public String getDealTime() {
			return dealTime;
		}
		public void setDealTime(String dealTime) {
			this.dealTime = dealTime;
		}
		public String getFee() {
			return fee;
		}
		public void setFee(String fee) {
			this.fee = fee;
		}
		public int getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(int orderStatus) {
			this.orderStatus = orderStatus;
		}
		public String getBankName() {
			return BankName;
		}
		public void setBankName(String BankName) {
			this.BankName = BankName;
		}
		public String getBankCode() {
			return bankCode;
		}
		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getCause() {
			return cause;
		}
		public void setCause(String cause) {
			this.cause = cause;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
	}
}
