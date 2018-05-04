package com.rw.finance.client.service;

import com.rw.finance.common.entity.ActvcodeInfo;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.pay.PayResult;

/**
 * 
 * @file ActvcodeInfoService.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:27:28
 * @declaration
 */
public interface ActvcodeInfoService {
	/**
	 * 根据激活码获取激活码信息
	 * @param activecode
	 * @return
	 */
	ActvcodeInfo getByActivecode(String activecode);

	/**
	 * 会员试用
	 * @param memberid
	 */
	void testActive(long memberid);
	/**
	 * 激活会员
	 * @param memberid
	 * @param activecode
	 */
	void codeActive(long memberid, String activecode);
	/**
	 * 支付激活会员
	 * @param memberInfo
	 * @param memberCard
	 * @param level 需要激活的会员等级
	 * @return 支付号
	 */
	PayResult payActive(MemberInfo memberInfo, MemberCard memberCard, int level, String method, String beforeCallbakcUrl);
	/**
	 * 确认支付激活
	 * @param TradeNo 支付号
	 * @param code 短信验证码
	 * @return
	 */
	PayResult confirmPayActive(String TradeNo, String code);
	/**
	 * 支付升级
	 * @return
	 */
	PayResult upgrade();
}
