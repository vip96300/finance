package com.rw.finance.common.pass.yeepay2.agent;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.rw.finance.common.utils.UuidUtil;
import org.apache.commons.codec.binary.Base64;

import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.utils.MathUtils;

public class PaymentServlet {

	/**
	 * 转账，代付
	 * @param userInfo
	 * @param cardInfo
	 * @param orderInfo
	 */
	public static Map<String,String> doPost(PayerBo.UserInfo userInfo,PayerBo.CardInfo cardInfo,PayerBo.OrderInfo orderInfo){
		String customerNumber = format(Config.getInstance().getValue("customerNumber"));
		String groupNumber=format(Config.getInstance().getValue("groupNumber"));
		String batchNo = format(orderInfo.getTradeNo().substring(orderInfo.getTradeNo().length()-15,orderInfo.getTradeNo().length()));
		String OrderId = format(orderInfo.getTradeNo());
		String amount = format(String.valueOf(MathUtils.persist(orderInfo.getBizAmount(), 2)));
		//处理amount小数后两位
		if(amount.contains(".")){//有小数点
			if(amount.split("\\.")[1].length()<2){
				amount+="0";
			}
		}else{
			amount+=".00";
		}
		//String product = format("RJT");//为空走委托结算出款，值为RJT为日结通出款
		String urgency=format("0");//当product为日结通出款时该参数不传，0非加急，1加急
		String accountName = format(userInfo.getPayeerealName());
		String accountNumber = format(cardInfo.getPayeeCardNo());
		String bankCode = format(cardInfo.getPayeeBankAbbreviation());
		String BankName =format("0");
		//String bankBranchName = format(request.getParameter("bankBranchName"));
		//String provinceCode = format(request.getParameter("provinceCode"));
		//String cityCode =format( request.getParameter("cityCode"));
		String feeType = format("SOURCE");//手续费方式，SOURCE商户承担，TARGET用户承担
		//String desc =format( request.getParameter("desc"));
		//String leaveWord = format(request.getParameter("leaveWord"));		
		//String abstractInfo =format( request.getParameter("abstractInfo"));
		Map<String, String> params = new HashMap<>();
		params.put("customerNumber", customerNumber);
		params.put("groupNumber", groupNumber);
		params.put("batchNo", batchNo);
		params.put("OrderId", OrderId);
		params.put("amount",amount);
		//params.put("product", product);
		params.put("urgency", urgency);
		params.put("accountName", accountName);
		params.put("accountNumber", accountNumber);
		params.put("bankCode", bankCode);
		params.put("BankName", BankName);
		//params.put("bankBranchName", bankBranchName);
		//params.put("provinceCode", provinceCode);
		//params.put("cityCode", cityCode);
		params.put("feeType", feeType);
		//params.put("desc", desc);
		//params.put("leaveWord", leaveWord);
		//params.put("abstractInfo", abstractInfo);
		String uri = Config.getInstance().getValue("paymentUri");
		Map<String,String> yopresponsemap	=	YeepayService.yeepayYOP(params,uri);
		return yopresponsemap;
	}
	
	/*public static void main(String []orgs) throws Exception{
		PayerBo.CardInfo ci=new PayerBo().new CardInfo("","","","","", "", "", "","6217996900028884931");
		ci.setPayeeBankAbbreviation("ECITIC");
		PaymentServlet.doPost(new PayerBo().new UserInfo("", "","","曾宪学"),
				ci,
				new PayerBo().new OrderInfo(UuidUtil.TradeNoBuilder(""),"", 1.00, "", ""));
	}*/

	public static String format(String text){
		return text==null?"":text.trim();
	}
	
	public static void readPfx() throws Exception{
		String password="339924";
		// 实例化密钥库，默认JKS类型
        KeyStore ks = KeyStore.getInstance("PKCS12");
        // 获得密钥库文件流
        FileInputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\merchan.pfx");
        // 加载密钥库
        ks.load(is,password.toCharArray());
        // 关闭密钥库文件流
        is.close();
 
        //私钥
        Enumeration aliases = ks.aliases();
        String keyAlias = null;
        if (aliases.hasMoreElements()){
            keyAlias = (String)aliases.nextElement();
            System.out.println("p12's alias----->"+keyAlias);
        }
        PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias,password.toCharArray());
        String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
        System.out.println("私钥------------->" + privateKeyStr);

        Certificate certificate = ks.getCertificate(keyAlias);
        String publicKeyStr = Base64.encodeBase64String(certificate.getPublicKey().getEncoded());
        System.out.println("公钥------------->"+publicKeyStr);
	}

	public static void readCer() throws Exception{
		X509Certificate x509Certificate = null;
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\10018503410.cer");
		x509Certificate = (X509Certificate) certificateFactory.generateCertificate(fileInputStream);
		fileInputStream.close();
		System.out.println("读取Cer证书信息...");
		System.out.println("x509Certificate_SerialNumber_序列号___:"+x509Certificate.getSerialNumber());
		System.out.println("x509Certificate_getIssuerDN_发布方标识名___:"+x509Certificate.getIssuerDN());
		System.out.println("x509Certificate_getSubjectDN_主体标识___:"+x509Certificate.getSubjectDN());
		System.out.println("x509Certificate_getSigAlgOID_证书算法OID字符串___:"+x509Certificate.getSigAlgOID());
		System.out.println("x509Certificate_getNotBefore_证书有效期___:"+x509Certificate.getNotAfter());
		System.out.println("x509Certificate_getSigAlgName_签名算法___:"+x509Certificate.getSigAlgName());
		System.out.println("x509Certificate_getVersion_版本号___:"+x509Certificate.getVersion());
		System.out.println("公钥------------->"+Base64.encodeBase64String(x509Certificate.getPublicKey().getEncoded()));
	}
}
