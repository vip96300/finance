package com.rw.finance.common.constants;

/**
 * 用户表中的idtype枚举
 * @file MenberIdTypeConstants.java	
 * @author huanghongfei
 * @date 2017年12月13日 下午3:20:34
 * @declaration
 */
public class MemberInfoConstants {
	

	/**
	 * 银行卡鉴权支付的金额
	 */
	public static final double ACTIVE_PAY_AMOUNT=1;
	/**
	 * 会员使用默认到期时间
	 */
	public static final String LEVEL_TIME_DEFAULT="9999-12-30 00:00:00";
	/**
	 * 会员试用时间（天）
	 */
	public static final int TEST_ACTIVE_DATE=30;
	/**
	 * 会员等级
	 * @file LoginInfoConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月28日 上午10:57:03
	 * @declaration
	 */
	public class Level{

		public static final int LEVEL_0=0;

		public static final int LEVEL_1=1;

		public static final int LEVEL_2=2;

		public static final int LEVEL_3=3;

		public static final int LEVEL_4=4;

		public static final int LEVEL_5=5;

		public static final int LEVEL_6=6;
	}

	/**
	 * CACHE KEY
	 */
	public enum CacheKey{
		/**
		 * 注册手机号的短信验证码cache key
		 */
		REGISTER_CODE("REGISTER_CODE_"),
		/**
		 * 找回密码的验证码的cache key
		 */
		FIND_PASSWORD_CODE("FIND_PASSWORD_CODE_"),
		/**
		 * 旧手机号验证码的 cache key
		 */
		UPDATE_TELEPHONE_CODE("UPDATE_TELEPHONE_CODE_"),
		/**
		 * 新手机号验证码的cache key
		 */
		UPDATE_TELEPHONE_CODE_NEW("UPDATE_TELEPHONE_CODE_NEW_");
		private String key;
		CacheKey(String key){
			this.key=key;
		}
		public String getValue(Object id){
			return key+id;
		}
	}
	/**
	 * 证件类型
	 * @file MemberInfoConstants.java	
	 * @author huanghongfei
	 * @date 2017年12月22日 下午4:12:01
	 * @declaration
	 */
	public enum IdType{
		/**
		 * 其他证件
		 */
		IDTYPE0(0),
		/**
		 * 身份证
		 */
		IDTYPE1(1),
		/**
		 * 军官证
		 */
		IDTYPE2(2),
		/**
		 * 护照
		 */
		IDTYPE3(3),
		/**
		 * 回乡证
		 */
		IDTYPE4(4),
		/**
		 * 台胞证
		 */
		IDTYPE5(5),
		/**
		 * 警官证
		 */
		IDTYPE6(6),
		/**
		 * 士兵证
		 */
		IDTYPE7(7);
		private int idType;
		IdType(int idType){
			this.idType=idType;
		}
		public int getIdType(){
			return idType;
		}
	}
	public enum Status{
		/**
		 * 正常
		 */
		STATUS1(1),
		/**
		 * 停用
		 */
		STATUS2(2);
		private int status;
		Status(int status){
			this.status=status;
		}
		public int getStatus(){
			return status;
		}
	}
}
