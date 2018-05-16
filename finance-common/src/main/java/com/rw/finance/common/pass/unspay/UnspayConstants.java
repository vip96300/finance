package com.rw.finance.common.pass.unspay;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 9:50 2018/4/26
 */
public class UnspayConstants {

    /**
     * 商户号
     */
    public static final String ACCOUNT_ID="2120180512094724001";

    /**
     * 加密key
     */
    public static final String KEY="ysb794446";
    /**
     * 报件接口地址
     */
    public static final String REPORT_REGISTER_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/report/register";
    /**
     * 查询报件接口地址
     */
    public static final String REPORT_QUERY_INFO_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/report/queryInfo";
    /**
     * 修改报件接口地址
     */
    public static final String REPORT_UPDATE_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/report/update";
    /**
     * h5绑卡接口地址(1)
     */
    public static final String BIND_H5_BIND_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/h5bind";
    /**
     * h5绑卡接口(2)-输入卡号
     */
    public static final String BIND_H5_INPUT_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/h5bindInfo";
    /**
     * h5绑卡接口(3)-检查卡片信息
     */
    public static final String BIND_H5_CHECK_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/checkCardInfo";
    /**
     * h5绑卡接口(3)-借记卡主动发送验证码
     */
    public static final String BIND_H5_SEND_CODE_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/sendCode";
    /**
     * h5绑卡接口(4)-输入验证码提交
     */
    public static final String BIND_H5_SUBMIT_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/sendCode";
    /**
     * h5绑卡回调地址
     */
    public static final String BIND_H5_BIND_RESPONSE_URL="http://huanghongfei.free.ngrok.cc/pay/back/unspay/h5BindBack";
    /**
     * 绑卡解绑接口地址
     */
    public static final String BIND_UN_BIND_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/unbindCard";
    /**
     * 查询绑卡接口地址
     */
    public static final String BIND_QUERY_CARD_INFO_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/bind/queryCardInfo";
    /**
     * 代还WAP地址(1)
     */
    public static final String QUICK_PAY_WAP_PAY_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/quickPayWap/prePay";
    /**
     * 代还WAP确认地址(2)
     */
    public static final String QUICK_PAY_WAP_AUTH_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business//quickPayWap/auth";
    /**
     * 代还WAP发送短信验证码地址(3)
     */
    public static final String QUICK_PAY_WAP_SEND_VERIFY_CODE_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/quickPayWap/sendVerifyCode";
    /**
     * 代还WAP输入短信验证码表单提交地址(4)
     */
    public static final String QUICK_PAY_WAP_SUBMIT_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/quickPayWap/pay";
    /**
     * 代还接口地址
     */
    public static final String QUICK_PAY_INTERFACE_PAY_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/quickPayInterface/pay";
    /**
     * 扣款结果回调地址
     */
    public static final String QUICK_PAY_RESPONSE_URL="http://huanghongfei.free.ngrok.cc/pay/back/unspay/quickPayBack";
    /**
     * 还款结果回调地址
     */
    public static final String DELEGATE_PAY_RESPONSE_URL="http://huanghongfei.free.ngrok.cc/pay/back/unspay/delegatePayBack";
    /**
     * 查询扣款订单接口地址
     */
    public static final String QUERY_QUERY_QUICK_PAY_ORDER_STATUS_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/query/queryQuickPayOrderStatus";
    /**
     * 查询还款订单接口地址
     */
    public static final String QUERY_QUERY_DELEGATE_PAY_ORDER_STATUS_URL="http://114.80.54.76:48081/unspay-creditCardRepayment-business/query/queryDelegatePayOrderStatus";
}
