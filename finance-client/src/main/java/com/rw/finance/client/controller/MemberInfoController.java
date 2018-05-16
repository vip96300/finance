package com.rw.finance.client.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rw.finance.client.utils.RequestUtils;

import com.rw.finance.common.constants.*;
import com.rw.finance.common.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.client.vo.MemberInfoVo;
import com.rw.finance.common.pay.PayResult;
import com.rw.finance.common.pay.PayerBo;
import com.rw.finance.common.pay.PayerFactory;
import com.rw.finance.client.service.ActvcodeInfoService;
import com.rw.finance.client.service.BankInfoService;
import com.rw.finance.client.service.BaseCacheService;
import com.rw.finance.client.service.MemberCardService;
import com.rw.finance.client.service.MemberInfoService;
import com.rw.finance.client.service.QrCodeRegistService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.FileUtils;
import com.rw.finance.common.utils.Md5Util;
import com.rw.finance.common.utils.Result;
import com.rw.finance.common.utils.SmsUtils;
import com.rw.finance.common.utils.UuidUtil;


/**
 * 
 * @file MemberInfoController.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午6:35:30
 * @declaration
 */
@RestController
@RequestMapping(value="/member/info")
public class MemberInfoController {
	
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private BankInfoService bankInfoService;
	@Autowired
	private MemberCardService memberCardService;
	@Autowired
	private BaseCacheService baseCacheService;
	@Autowired
	private ActvcodeInfoService actvcodeInfoService;
	@Autowired
	private QrCodeRegistService qrCodeRegistService;
	@Autowired
	private com.rw.finance.client.config.SystemSetting systemSetting;
	
	private final Logger log=LoggerFactory.getLogger(MemberInfoController.class);
	/**
	 * 文件存储路径
	 */
	@Value("${system.file.dir}")
	private String fileDir;
	/**
	 * 获取注册短信验证码
	 * @param telephone 手机号码
	 * @return
	 */
	@PostMapping(value="/getRegisterCode")
	public Result<Object> getRegisterCode(@RequestParam(value="telephone")String telephone){
		boolean memberInfoIsExist=memberInfoService.isExistByTelephone(telephone);
		if(memberInfoIsExist){//用户已存在
			return new Result<>(501,"用户已存在",null);
		}
		String code=SmsUtils.smsCodeGenerator();
		SmsUtils.send(telephone, code);
		baseCacheService.set(MemberInfoConstants.CacheKey.REGISTER_CODE.getValue(telephone),code,TimeConstants.SMS_CODE_EXPRIE_TIME);
		return new Result<>(200,null,null);
	}
	/**
	 * 检查验证码是否正确
	 * @param telephone
	 * @param code
	 * @return
	 */
	@PostMapping(value="/checkRegisterCode")
	public Result<Object> checkRegisterCode(@RequestParam(value="telephone")String telephone,
			@RequestParam(value="code")String code){
		if(!code.equals(baseCacheService.get(MemberInfoConstants.CacheKey.REGISTER_CODE.getValue(telephone), String.class))){
			return new Result<>(501,"短信验证码不正确",null);
		}
		return new Result<>(200,null,null);
	}
	/**
	 * 注册
	 * @return
	 */
	@PostMapping(value="/register")
	public Result<Object> register(@RequestParam(value="realName")String realName,
		@RequestParam(value="telephone")String telephone,
		@RequestParam(value="password")String password,
		@RequestParam(value="paypwd")String paypwd,
		@RequestParam(value="refertel",required=false)String refertel,
		@RequestParam(value="code")String code,
		@RequestParam(value="agentid",required = false,defaultValue = "0")Long agentId,
		@RequestParam(value="memberid",required = false,defaultValue = "0")Long memberid,
		HttpServletRequest request){
		if(!code.equals(baseCacheService.get(MemberInfoConstants.CacheKey.REGISTER_CODE.getValue(telephone), String.class))){
			return new Result<>(500,"短信验证码不正确",null);
		}
		MemberInfo memberInfo=memberInfoService.getByTelephone(telephone);
		if(!StringUtils.isEmpty(memberInfo)){
			return new Result<>(501,"会员已注册",null);
		}
		memberInfo =new MemberInfo(realName, telephone, password, paypwd, RequestUtils.getIpAddress(request));
		if(!StringUtils.isEmpty(refertel)){
			MemberInfo refer=memberInfoService.getByTelephone(refertel);
			if(!StringUtils.isEmpty(refer)){
				memberInfo.setParentId(refer.getMemberId());
			}else{
				return new Result<>(503,"该推荐手机号未注册",null);
			}
		}
		//前端直传
		if(!StringUtils.isEmpty(agentId)||!StringUtils.isEmpty(memberid)){
			memberInfo.setParentId(memberid);
			memberInfo.setAgentId(agentId);
		}else{//后端通过IP和userAgent定位注册
			QrCodeRegist qrCodeRegist=qrCodeRegistService.getByIpaddrAndUseragent(RequestUtils.getIpAddress(request),new MemberInfoVo().new UserAgentUtils(request.getHeader("user-agent")).getUserAgentInfo());
			//扫描二维码注册的会员
			if(!StringUtils.isEmpty(qrCodeRegist)){
				memberInfo.setParentId(qrCodeRegist.getMemberId());
				memberInfo.setAgentId(qrCodeRegist.getAgentId());
			}
		}
		//如果没有邀请者
		if(StringUtils.isEmpty(refertel)&&agentId==0&&memberid==0){
			return new Result<>(504,"请输入邀请者手机号或者通过二维码注册",null);
		}
		memberInfoService.register(memberInfo);
		return new Result<>(200,null,null);
	}
	/**
	 * 获取找回密码的验证码
	 * @param telephone 手机号码
	 * @return
	 */
	@PostMapping(value="/getFindPasswordCode")
	public Result<Object> getFindPasswordCode(@RequestParam(value="telephone")String telephone){
		boolean memberInfoIsExist=memberInfoService.isExistByTelephone(telephone);
		if(!memberInfoIsExist){
			return new Result<>(501,"会员信息不存在",null);
		}
		String code=SmsUtils.smsCodeGenerator();
		SmsUtils.send(telephone, code);
		baseCacheService.set(MemberInfoConstants.CacheKey.FIND_PASSWORD_CODE.getValue(telephone), code,TimeConstants.SMS_CODE_EXPRIE_TIME);
		return new Result<>(200,null,code);
	}
	/**
	 * 找回密码
	 * @param telephone 手机号码
	 * @param newPassword 新密码
	 * @param code 短信验证码
	 * @return
	 */
	@PostMapping(value="/findPassword")
	public Result<Object> findPassword(@RequestParam(value="telephone")String telephone,
			@RequestParam(value="newPassword")String newPassword,
			@RequestParam(value="code")String code){
		if(!code.equals(baseCacheService.get(MemberInfoConstants.CacheKey.FIND_PASSWORD_CODE.getValue(telephone),String.class))){
			return new Result<>(501,"短信验证码错误",null);
		}
		MemberInfo memberInfo =memberInfoService.getByTelephone(telephone);
		if(StringUtils.isEmpty(memberInfo)){
			return new Result<>(502,"用户信息未找到",null);
		}
		memberInfo.setPassword(Md5Util.md5(newPassword));
		memberInfoService.update(memberInfo);
		return new Result<>(200,null,null);
	}
	/**
	 * 用户登录
	 * @param telephone 手机号码
	 * @param password 登录密码
	 * @return
	 */
	@PostMapping(value="/login")
	public Result<Object> login(@RequestParam(value="telephone")String telephone,
			@RequestParam(value="password")String password){
		String jwt=memberInfoService.login(telephone,password);
		if(StringUtils.isEmpty(jwt)){
			return new Result<>(501,"用户名或密码错误",null);
		}
		return new Result<>(200,null,jwt);
	}
	
	/**
	 * 修改登录密码
	 * @param memberid
	 * @param password 登录密码
	 * @param newPassword 新登录密码
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/updPasswordByMemberidAndPassword")
	public Result<Object> updPasswordByMemberidAndPassowrd(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="password")String password,
			@RequestParam(value="newPassword")String newPassword){
		boolean isSuccess=memberInfoService.updPasswordByMemberidAndPassword(memberid, password,newPassword);
		if(!isSuccess){
			return new Result<>(501,"操作失败",null);
		}
		return new Result<>(200,null,null);
	}
	
	/**
	 * 修改支付密码，需在线状态
	 * @param memberid
	 * @param paypwd 支付密码
	 * @param newPaypwd 新支付密码
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/updPaypwdByMemberidAndPaypwd")
	public Result<Object> updPaypwdByMemberidAndPaypwd(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="paypwd")String paypwd,
			@RequestParam(value="newPaypwd")String newPaypwd){
		boolean isSuccess=memberInfoService.updPaypwdByMemberidAndPaypwd(memberid,paypwd,newPaypwd);
		if(!isSuccess){
			return new Result<>(501,"操作失败",null);
		}
		return new Result<>(200,null,null);
	}
	
	/**
	 * 获取找回支付密码的短信验证码
	 * @param telephone 注册手机号
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/getFindPaypwdCode")
	public Result<Object> getFindPaypwdCode(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="telephone")String telephone){
		MemberInfo memberInfo =memberInfoService.getByTelephone(telephone);
		if(StringUtils.isEmpty(memberInfo)){
			return new Result<>(502,"用户信息未找到",null);
		}
		String code=SmsUtils.smsCodeGenerator();
		SmsUtils.send(telephone, code);
		baseCacheService.set("findPaypwd_"+memberid,code,TimeConstants.SMS_CODE_EXPRIE_TIME);
		return new Result<>(200,null,null);
	}
	
	/**
	 * 找回交易密码
	 * @param memberid
	 * @param newPaypwd 新交易密码
	 * @Param code 短信验证码
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/findPaypwd")
	public Result<Object> findPaypwd(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="newPaypwd")String newPaypwd,
			@RequestParam(value="code")String code){
		if(!code.equals(baseCacheService.get("findPaypwd_"+memberid,String.class))){
			return new Result<>(501,"短信验证码错误",null);
		}
		boolean isSuccess=memberInfoService.updPaypwdByMemberid(memberid, newPaypwd);
		if(!isSuccess){
			return new Result<>(502,"用户信息未找到",null);
		}
		return new Result<>(200,null,null);
	}
	
	/**
	 * 获取用户信息
	 * @param memberid
	 * @return 用户信息
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/getByMemberid")
	public Result<Object> getByMemberid(@RequestAttribute(value="memberid")long memberid){
		MemberInfo memberInfo =memberInfoService.getByMemberid(memberid);
		if(!StringUtils.isEmpty(memberInfo.getLevelTime())){
			if(DateUtils.getTimeByStr(memberInfo.getLevelTime()).getTime()<System.currentTimeMillis()){
				memberInfo.setLevelTime("EXPIRED");
			}
			if(MemberInfoConstants.LEVEL_TIME_DEFAULT.equals(memberInfo.getLevelTime())){
				memberInfo.setLevelTime(null);
			}
		}
		return new Result<>(200,null, memberInfo);
	}
	/**
	 * 获取旧手机号的验证码
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/getUpdTelephoneCode")
	public Result<Object> getUpdTelephoneCode(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="telephone")String telephone){
		MemberInfo memberInfo =memberInfoService.getByMemberidAndTelephone(memberid, telephone);
		if(StringUtils.isEmpty(memberInfo)){
			return new Result<>(501,"用户信息未找到",null);
		}
		String code=SmsUtils.smsCodeGenerator();
		SmsUtils.send(telephone, code);
		baseCacheService.set(MemberInfoConstants.CacheKey.UPDATE_TELEPHONE_CODE.getValue(memberid),code,TimeConstants.SMS_CODE_EXPRIE_TIME);
		return new Result<>(200,null,null);
	}
	/**
	 * 检查旧手机号的验证码
	 * @param memberid
	 * @param code
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/checkUpdTelephoneCode")
	public Result<Object> checkUpdTelephoneCode(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="code")String code){
		if(!code.equals(baseCacheService.get(MemberInfoConstants.CacheKey.UPDATE_TELEPHONE_CODE.getValue(memberid), String.class))){
			return new Result<>(501,"短信验证码不正确",null);
		}
		baseCacheService.remove(MemberInfoConstants.CacheKey.UPDATE_TELEPHONE_CODE.getValue(memberid));
		return new Result<>(200,null,null);
	}
	/**
	 * 获取新手机号的验证码
	 * @param memberid
	 * @param newTelephone
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/getUpdTelephoneCode1")
	public Result<Object> getUpdTelephoneCode1(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="newTelephone")String newTelephone){
		boolean isExistByTelephone=memberInfoService.isExistByTelephone(newTelephone);
		if(isExistByTelephone){
			return new Result<>(501,"新手机号已被注册",null);
		}
		String code=SmsUtils.smsCodeGenerator();
		SmsUtils.send(newTelephone, code);
		baseCacheService.set(MemberInfoConstants.CacheKey.UPDATE_TELEPHONE_CODE_NEW.getValue(memberid),code,TimeConstants.SMS_CODE_EXPRIE_TIME);
		return new Result<>(200,null,null);
	}
	/**
	 * 修改手机号
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/updTelephone")
	public Result<Object> updTelephone(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="newTelephone")String newTelephone,
			@RequestParam(value="code")String code){
		if(!code.equals(baseCacheService.get(MemberInfoConstants.CacheKey.UPDATE_TELEPHONE_CODE_NEW.getValue(memberid), String.class))){
			return new Result<>(501,"短信验证码不正确",null);
		}
		memberInfoService.updTelephoneByMemberid(memberid, newTelephone);
		baseCacheService.remove(MemberInfoConstants.CacheKey.UPDATE_TELEPHONE_CODE_NEW.getValue(memberid));
		return new Result<>(200,null,null);
	}
	/**
	 * 激活码激活用户
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/codeActive")
	public Result<Object> codeActive(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="activecode")String activecode){
		ActvcodeInfo actvcodeInfo=actvcodeInfoService.getByActivecode(activecode);
		if(StringUtils.isEmpty(actvcodeInfo)){
			return new Result<>(501,"激活码不存在",null);
		}
		if(actvcodeInfo.getUseStatus().intValue()!=ActvcodeInfoConstants.UseStatus.STATUS1.getStatus()){
			return new Result<>(502,"激活码无效",null);
		}
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		//未实名认证
		if(memberInfo.getIsReal().intValue()!= Constants.YN.Y.getValue()){
			return new Result<>(503,"请先实名认证",null);
		}
		actvcodeInfoService.codeActive(memberid, activecode);
		return new Result<>(200,null,null);
	}
	/**
	 * 在线支付激活
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@GetMapping(value="/payActive")
	public void payActive(@RequestAttribute(value="memberid")long memberid,
			//@RequestParam(value="bankid")long bankid,
			//@RequestParam(value="cardno")String cardno,
			//@RequestParam(value="expirydate")String expirydate,
			//@RequestParam(value="authcode")String authcode,
			//@RequestParam(value="billdate",required=false)String billdate,
			//@RequestParam(value="repaydate",required=false)String repaydate,
			//@RequestParam(value="mobile")String mobile,
			@RequestParam(value="method")String method,
			@RequestParam(value="level")int level,
			@RequestParam(value="beforeCallbackUrl",required=false)String beforeCallbackUrl,
			HttpServletResponse response){
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		//BankInfo bankInfo=bankInfoService.getByBankid(bankid);
		if(memberInfo.getIsReal().intValue()!= Constants.YN.Y.getValue()){
			return;
		}
		//信用卡
		/*MemberCard memberCard =new MemberCard(memberid,memberInfo.getIdNumber(),bankInfo.getBankid(),
				cardno,memberInfo.getRealName(),expirydate,authcode,billdate,
				repaydate,mobile,bankInfo.getBankcode(),bankInfo.getBankName(),bankInfo.getAbbreviation(),
				bankInfo.getBanklogo(),bankInfo.getCardcolor());*/
		//借记卡
		/*MemberCard memberCard =new MemberCard(memberid, memberInfo.getIdNumber(), bankid, memberInfo.getRealName(), cardno,
				mobile, bankInfo.getBankcode(), bankInfo.getBankName(), bankInfo.getAbbreviation(), bankInfo.getBanklogo(), bankInfo.getCardcolor());*/
		//仅限易宝支付使用该空对象
		MemberCard memberCard=new MemberCard();
		PayResult payResult=actvcodeInfoService.payActive(memberInfo, memberCard, level,method,beforeCallbackUrl);
		if(!payResult.getSuccess()){
			log.error("zhi fu shi bai");
			return;
		}
		/*MemberCardVo.PayActiveVo vo=new MemberCardVo().new PayActiveVo();
		vo.setTradeNo(payResult.getTradeNo());
		vo.setIsNeedSms(payResult.getIsNeedSms());
		vo.setPayUrl(payResult.getDetails());*/
		try {
			response.sendRedirect(payResult.getDetails());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 确认支付激活
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/confirmPayActive")
	public Result<Object> confirmPayActive(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="tradeno")String tradeNo,
			@RequestParam(value="code")String code){
		PayResult payResult=this.actvcodeInfoService.confirmPayActive(tradeNo, code);
		if(!payResult.getSuccess()){
			return new Result<>(501,payResult.getDetails(),null);
		}
		return new Result<>(200,null,null);
	}

	/**
	 * 会员升级
	 * @param memberId
	 * @return
	 */
	@Member(level =MemberInfoConstants.Level.LEVEL_0)
	public Result<Object> upgrade(@RequestAttribute(name="memberid")long memberId){
		actvcodeInfoService.upgrade();//TODO
		return new Result<>(200,null,null);
	}

	/**
	 * 实名认证前资料检查，然后进行实名认证
	 * @See updIsreal();
	 * @return
	 */
	@Member(level =MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(path="/isRealCheck")
	public Result<Object> isRealCheck(){
		//TODO
		return new Result<>(200,null,null);
	}
	/**
	 * 实名认证
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/updIsreal")
	public Result<Object> updIsreal(@RequestAttribute(value="memberid")long memberid,
		@RequestParam(value="bankid")long bankid,
		@RequestParam(value="realName")String realName,
		@RequestParam(value="idNumber")String idNumber,
		@RequestParam(value="cardno")String cardno,
		@RequestParam(value="mobile")String mobile,
		@RequestParam(value="idpath")String idpath,//证件照
		@RequestParam(value="idobverse")String idobverse,//身份证正面
		@RequestParam(value="idreverse")String idreverse,//身份证背面
		@RequestParam(value="cardpath")String cardpath){//银行卡照片
		MemberInfo memberInfo=memberInfoService.getByMemberid(memberid);
		//已实名
		if(memberInfo.getIsReal().intValue()== Constants.YN.Y.getValue()){
			return new Result<>(500,"已实名认证",null);
		}
		if(memberCardService.isExsit(cardno)){
			return new Result<>(501,"卡片已存在",null);
		}
		BankInfo bankInfo=bankInfoService.getByBankid(bankid);
		//添加一张借记卡
		MemberCard memberCard =new MemberCard(memberid,idNumber,bankInfo.getBankId(),realName,cardno,mobile,bankInfo.getBankCode(),
				bankInfo.getBankName(),bankInfo.getAbbreviation(),bankInfo.getBankLogo(),bankInfo.getCardColor(),bankInfo.getBankExtra());
		PayResult payResult=new PayerFactory().EynonPayer().auth(new PayerBo().new UserInfo(idNumber,realName),
				new PayerBo().new CardInfo(bankInfo.getBankName(),memberCard.getProvince(),memberCard.getCity(),memberCard.getAbbreviation(), cardno,mobile,"", ""),
				new PayerBo().new OrderInfo(UuidUtil.TradeNoBuilder(OrderInfoConstants.Prefix.MemberActiveOrder.getPrefix()), "",MemberInfoConstants.ACTIVE_PAY_AMOUNT,0,new PayerFactory().DefaultPayer().getBackUrl(),""));
		//储蓄卡鉴权失败
		if(!payResult.getSuccess()){
			log.info("memberCard auth failed");
			return new Result<>(505,payResult.getDetails(),null);
		}
		memberInfo.isReal(realName, idNumber, idpath, idobverse, idreverse,cardpath);
		try {
			memberInfoService.isReal(memberInfo, memberCard);
		}catch (Exception e){
			log.error(e.getMessage());
			return new Result<>(506,"实名认证失败",null);
		}
		return new Result<>(200,null,null);
	}
	/**
	 * 上传文件接口
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/upload")
	public Result<Object> upload(MultipartHttpServletRequest request){
		MultipartFile file=null;
		for(Entry<String, MultipartFile> map:request.getFileMap().entrySet()){
			file=map.getValue();
			continue;
		}
		Calendar calendar=Calendar.getInstance();
		String filePath=request.getAttribute("memberid")+"/"+calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.HOUR_OF_DAY)+"/"+calendar.get(Calendar.MINUTE)+"/"+System.nanoTime()+FileUtils.getSuffix(file.getOriginalFilename());
		try {
			File destFile=new File(this.fileDir+filePath);
			if(!destFile.getParentFile().exists()){
				destFile.getParentFile().mkdirs();
			}
			byte[] result = file.getBytes();
			FileOutputStream out = new FileOutputStream(this.fileDir+filePath);
			out.write(result);
			out.close();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Result<>(200,null,filePath);
	}
	/**
	 * 上传文件接口(base64)
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/base64")
	public Result<Object> base64(@RequestAttribute(value="memberid")long memberid,
			@RequestParam(value="file")String base64){
		try {
			base64=URLDecoder.decode(base64,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Calendar calendar=Calendar.getInstance();
		String filePath=memberid+"/"+calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.HOUR_OF_DAY)+"/"+calendar.get(Calendar.MINUTE)+"/"+System.nanoTime()+FileUtils.getSuffixByBase64(base64);
		FileUtils.getFileByBase64(base64,this.fileDir+filePath);
		return new Result<>(200,null,filePath);
	}
	
	/**
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/shareRedirect")
	public void shareRedirect(@RequestParam(value="memberid",required=false,defaultValue="0")long memberid,
			@RequestParam(value="agentid",required=false,defaultValue="0")long agentId,
			HttpServletRequest request,
			HttpServletResponse response){
		qrCodeRegistService.add(new QrCodeRegist(memberid,agentId,RequestUtils.getIpAddress(request),new MemberInfoVo().new UserAgentUtils(request.getHeader("user-agent")).getUserAgentInfo()));
		try {
			response.sendRedirect(systemSetting.QR_CODE_SHARE_URL_REDIRECT()+"?page=share-skip.web.js&memberid="+memberid+"&AgentId="+agentId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 分享记录统计页面数据
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/shareCount")
	public Result<Object> shareCount(@RequestAttribute(value="memberid")long memberid){
		List<MemberInfo> memberInfos=memberInfoService.listByParentId(memberid);
		MemberInfoVo.ShareCountVo shareCountVo=new MemberInfoVo().new ShareCountVo();
		shareCountVo.setTotalCount(memberInfos.size());
		int isRealCount=0;//实名认证人数
		int curMonthIsRealCount=0;//本月实名认证人数
		int curMonthShareCount=0;//本月分享人数
		int levelCount=0;//会员激活人数
		int curMonthLevelCount=0;//本月会员激活人数
		Calendar current=Calendar.getInstance();
		Calendar registTime=Calendar.getInstance();
		Calendar isrealtime=Calendar.getInstance();
		Map<String,List<com.rw.finance.client.vo.MemberInfoVo.ShareCountVo.MemberInfo>> all=new LinkedHashMap<String,List<MemberInfoVo.ShareCountVo.MemberInfo>>();
		for(MemberInfo member:memberInfos){
			if(member.getIsReal().intValue()==1){
				isRealCount+=1;
			}
			if(member.getLevel().intValue()>0){
				levelCount+=1;
			}
			registTime.setTime(DateUtils.getTimeByStr(member.getRegisterTime()));
			if(current.get(Calendar.MONTH)==registTime.get(Calendar.MONTH)){
				if(member.getLevel().intValue()>MemberInfoConstants.Level.LEVEL_0){
					curMonthLevelCount+=1;
				}
				curMonthShareCount+=1;
			}
			if(!StringUtils.isEmpty(member.getIsRealTime())){
				isrealtime.setTime(DateUtils.getTimeByStr(member.getIsRealTime()));
				if(current.get(Calendar.MONTH)==isrealtime.get(Calendar.MONTH)){
					curMonthIsRealCount+=1;
				}
			}
			List<com.rw.finance.client.vo.MemberInfoVo.ShareCountVo.MemberInfo> infos=all.get(DateUtils.getMonthStr(DateUtils.getTimeByStr(member.getRegisterTime())));
			com.rw.finance.client.vo.MemberInfoVo.ShareCountVo.MemberInfo info=new com.rw.finance.client.vo.MemberInfoVo().new ShareCountVo().new MemberInfo(member.getTelephone(), member.getIsReal(), member.getRegisterTime());
			if(StringUtils.isEmpty(infos)){
				infos=new ArrayList<>();
			}
			infos.add(info);
			all.put(DateUtils.getMonthStr(DateUtils.getTimeByStr(member.getRegisterTime())), infos);
		}
		shareCountVo.setIsRealCount(isRealCount);
		shareCountVo.setLevelCount(levelCount);
		shareCountVo.setCurMonthShareCount(curMonthShareCount);
		shareCountVo.setCurMonthIsRealCount(curMonthIsRealCount);
		shareCountVo.setCurMonthLevelCount(curMonthLevelCount);
		shareCountVo.setAll(all);
		return new Result<>(200,null,shareCountVo);
	}
}
