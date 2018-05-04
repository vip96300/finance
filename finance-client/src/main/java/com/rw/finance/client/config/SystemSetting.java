package com.rw.finance.client.config;

import com.google.gson.Gson;
import com.rw.finance.client.vo.SystemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rw.finance.client.service.BaseCacheService;
import com.rw.finance.client.service.SystemSettingService;
/**
 * 
 * @file SystemSettingService.java	
 * @author huanghongfei
 * @date 2018年1月16日 下午2:40:55
 * @declaration
 */
@Configuration
public class SystemSetting {

	@Autowired
	private SystemSettingService systemSettingService;

	@Autowired
	private BaseCacheService baseCacheService;
	/**
	 * 二维码上面的报文地址
	 * @return
	 */
	public String QR_CODE_SHARE_URL_REQUEST(){
		String key="QR_CODE_SHARE_URL_REQUEST";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return value.toString();
		}
		return systemSettingService.getByDictkey(key).getDictVal();
	}
	/**
	 * 二维码分享地址落地页
	 * @return
	 */
	public String QR_CODE_SHARE_URL_REDIRECT(){
		String key="QR_CODE_SHARE_URL_REDIRECT";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return value.toString();
		}
		return systemSettingService.getByDictkey(key).getDictVal();
	}

	/**
	 * 二维码分享地址落地页
	 * @return
	 */
	public SystemVo.Version APP_LAST_VERSION(){
		com.rw.finance.common.entity.SystemSetting systemSetting=systemSettingService.getByDictkey("APP_LAST_VERSION");
		return new Gson().fromJson(systemSetting.getDictVal(),SystemVo.Version.class);
	}

	/**
	 * 获取会员升级至下一级的金额
	 * @param level
	 * @return
	 */
	public double getLevelUpgradePrice(int level){
		String key="MEMBER_INFO_LEVEL"+(level+1)+"_PRICE";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString().split("/")[0]);
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal().split("/")[0]);
	}
	/**
	 * 获取会员下一等级的阀值
	 * @param level
	 * @return
	 */
	public int getLevelThreshold (int level){
		String key="MEMBER_INFO_LEVEL"+(level+1)+"_PRICE";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return Integer.valueOf(value.toString().split("/")[1]);
		}
		return Integer.parseInt(systemSettingService.getByDictkey(key).getDictVal().split("/")[1]);
	}
	/**
	 * 获取会员等级的价格
	 * @param level
	 * @return
	 */
	public double getLevelPrice(int level){
		String key="MEMBER_INFO_LEVEL"+level+"_PRICE";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString().split("/")[2]);
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal().split("/")[2]);
	}
	/**
	 * 支付渠道费率
	 * @return
	 */
	public double PAY_SYSTEM_RATE(){
		String key="PAY_SYSTEM_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString());
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal());
	}
	/**
	 * 会员邀请等级会员还款分润利率
	 * @param level
	 * @return
	 */
	public double MEMBER_PROFIT_REPAY_LEVEL_RATE(int level){
		String key="MEMBER_PROFIT_REPAY_LEVEL"+level+"_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString());
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal());
	}
	/**
	 * 会员邀请等级会员提现分润利率
	 * @param level
	 * @return
	 */
	public double MEMBER_PROFIT_CASH_LEVEL_RATE(int level){
		String key="MEMBER_PROFIT_CASH_LEVEL"+level+"_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString());
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal());
	}
	/**
	 * 会员邀请等级会员套现分润利率
	 * @param level
	 * @return
	 */
	public double MEMBER_PROFIT_BORROW_LEVEL_RATE(int level){
		String key="MEMBER_PROFIT_BORROW_LEVEL"+level+"_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString());
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal());
	}
	/**
	 * 会员激活下级分润比例
	 * @param level
	 * @return
	 */
	public double MEMBER_PROFIT_ACTIVE_LEVEL_RATE_D(int level){
		String key="MEMBER_PROFIT_ACTIVE_LEVEL"+level+"_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString().split("/")[0]);
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal().split("/")[0]);
	}
	/**
	 * 会员激活下下级分润比例
	 * @param level
	 * @return
	 */
	public double MEMBER_PROFIT_ACTIVE_LEVEL_RATE_DD(int level){
		String key="MEMBER_PROFIT_ACTIVE_LEVEL"+level+"_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString().split("/")[1]);
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal().split("/")[1]);
	}

	/**
	 * 会员还款所有代理收益总金额比例
	 * @return
	 */
	public double MEMBER_REPAY_AGENT_PROFIT_TOTAL_RATE(){
		String key="MEMBER_REPAY_AGENT_PROFIT_TOTAL_RATE";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString());
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal());
	}

	/**
	 * 会员提现最低金额
	 * @return
	 */
	public double MEMBER_CASH_MIN_AMOUNT(){
		String key="MEMBER_CASH_MIN_AMOUNT";
		Object value=baseCacheService.get(key,Double.class);
		if(!StringUtils.isEmpty(value)){
			return Double.parseDouble(value.toString());
		}
		return Double.parseDouble(systemSettingService.getByDictkey(key).getDictVal());
	}
	/**
	 * 任务失败邮件发送地址
	 * @return
	 */
	public String SYSTEM_MAIL_TASK_TO(){
		String key="SYSTEM_MAIL_TASK_TO";
		Object value=baseCacheService.get(key,String.class);
		if(!StringUtils.isEmpty(value)){
			return value.toString();
		}
		return systemSettingService.getByDictkey(key).getDictVal();
	}
}
