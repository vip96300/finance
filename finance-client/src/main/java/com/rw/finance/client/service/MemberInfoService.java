package com.rw.finance.client.service;

import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;

import java.util.List;

public interface MemberInfoService {

	/**
	 * 判断用户是否存在
	 * @param telephone
	 * @return
	 */
	boolean isExistByTelephone(String telephone);
	/**
	 * 注册
	 * @param memberInfo
	 */
	void register(MemberInfo memberInfo);
	/**
	 * 实名认证
	 * @param memberInfo
	 * @param memberCard
	 */
	void isReal(MemberInfo memberInfo, MemberCard memberCard);
	/**
	 * 根据手机号获取用户
	 * @param telephone
	 * @return
	 */
	MemberInfo getByTelephone(String telephone);
	/**
	 * 更新用户信息
	 * @param memberInfo
	 */
	void update(MemberInfo memberInfo);
	/**
	 * 用户登录
	 * @param telephone
	 * @param password
	 * @return
	 */
	String login(String telephone, String password);
	/**
	 * 根据主键获取user
	 * @param memberid
	 * @return
	 */
	MemberInfo getByMemberid(long memberid);
	/**
	 * 修改登录密码
	 * @param password 登录密码
	 * @param newPassword 新登录密码
	 * @return
	 */
	boolean updPasswordByMemberidAndPassword(long memberid, String password, String newPassword);
	/**
	 * 修改支付密码
	 * @param memberid
	 * @param paypwd
	 * @param newPaypwd
	 * @return
	 */
	boolean updPaypwdByMemberidAndPaypwd(long memberid, String paypwd, String newPaypwd);
	/**
	 * 找回交易密码
	 * @param memberid
	 * @param newPaypwd 新交易密码
	 * @return
	 */
	boolean updPaypwdByMemberid(long memberid, String newPaypwd);
	/**
	 * 根据用户编号和原手机号修改新手机号码
	 * @param memberid
	 * @param newTelephone
	 * @return
	 */
	boolean updTelephoneByMemberid(long memberid, String newTelephone);
	/**
	 * 根据useid和telephone获取用户
	 * @param memberid
	 * @param telephone
	 * @return
	 */
	MemberInfo getByMemberidAndTelephone(long memberid, String telephone);
	/**
	 * 通过父编号获取受邀会员列表
	 * @param ParentId 父会员编号
	 * @return
	 */
	List<MemberInfo> listByParentId(long ParentId);

	/**
	 * 获取大于level并且小于levelTime
	 * @param level
	 * @param levelTime
	 * @return
	 */
	List<MemberInfo> listByLevelGreaterThanAndLeveltimeLessThan(int level,String levelTime);
}
