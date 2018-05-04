package com.rw.finance.common.pass.jdsoft;

import java.util.ArrayList;
import java.util.List;

import com.rw.finance.common.utils.MathUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.rw.finance.common.pass.jdsoft.utils.HttpInvoker;
import com.rw.finance.common.pass.jdsoft.utils.SignUtils;
import com.rw.finance.common.pay.PayerBo;

/**
 * 银联支付接口，不带身份信息
 * 
 * @author zhengzhq
 *
 */
public class UnionPay {

  // 产线地址
  private static final String startPayUrl = "https://pay.jdsoft.ltd/api/pay/v2/startPay";

  public static String unionPay(PayerBo.UserInfo userInfo,PayerBo.CardInfo cardInfo,PayerBo.OrderInfo orderInfo){
    List<NameValuePair> paramList = new ArrayList<NameValuePair>();
    // 合作方标识，由绝顶颁发
    paramList.add(new BasicNameValuePair("cooperator", "RYZX"));
    paramList.add(new BasicNameValuePair("algorithm", "RSA"));
    // 流水号
    paramList.add(new BasicNameValuePair("reqMsgId", orderInfo.getTradeNo()));
    // 银联快捷，1-银联无积分、3-银联有积分
    paramList.add(new BasicNameValuePair("type", "3"));
    paramList.add(new BasicNameValuePair("payerName",userInfo.getPayerRealName()));
    paramList.add(new BasicNameValuePair("payerIdCard", userInfo.getPayerIdNo()));
    paramList.add(new BasicNameValuePair("payerMobile",cardInfo.getPayerCardMobile()));
    paramList.add(new BasicNameValuePair("payerBankCard",cardInfo.getPayerCardNo()));
    paramList.add(new BasicNameValuePair("payeeCard",cardInfo.getPayeeCardNo()));
    paramList.add(new BasicNameValuePair("money",String.valueOf(MathUtils.persist(orderInfo.getBizAmount(), 2))));
    paramList.add(new BasicNameValuePair("fixedFee", String.valueOf(MathUtils.persist(orderInfo.getBizFee(),2))));
    paramList.add(new BasicNameValuePair("tradeRate", "40"));
    // 计算签名
    try {
		paramList.add(new BasicNameValuePair("sign", SignUtils.getSign(paramList)));
	} catch (Exception e) {
		e.printStackTrace();
	}
    String result = HttpInvoker.doPost(startPayUrl, paramList);
    System.out.println(result);
    return result;
  }
}
