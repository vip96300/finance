package com.rw.finance.client.service;

/**
 * 
 * @file PayResultService.java	
 * @author huanghongfei
 * @date 2018年1月12日 上午11:51:58
 * @declaration
 */
public interface PayResultService {

	/**
	 * 创新支付回调
	 * @param tradeNo
	 * @param cxOrderNo
	 * @param dealCode
	 * @param dealMsg
	 */
	void chuangXinPayBack(String tradeNo,String cxOrderNo,String dealCode,String dealMsg);
	/**
	 * 易宝支付回调
	 * @param TradeNo
	 */
	void yeeBaoPayBack(String TradeNo);
	/**
	 * 易宝2支付回调
	 * @param TradeNo
	 */
	void yeeBao2PayBack(String TradeNo);
	/**
	 * 易宝2代付回调
	 * @param TradeNo
	 */
	void yeeBao2AgentPayBack(String TradeNo);
	/**
	 * 绝顶支付回调接口
	 * @param TradeNo
	 */
	void jdsoftPayBack(String TradeNo);

	/**
	 * 银生宝绑卡成功回调
	 * @param memberId 会员编号
	 * @param cardNo 银行卡尾号
	 * @Param token 银生宝绑卡唯一编号
	 */
	void unspayH5BindBack(long memberId,String cardNo,String token);
}
