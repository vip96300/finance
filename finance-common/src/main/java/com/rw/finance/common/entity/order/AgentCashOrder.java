package com.rw.finance.common.entity.order;

/**
 * 代理提现明细
 *
 * @author huanghongfei
 * @file AgentCashOrder.java
 * @date 2018年1月9日 上午10:41:48
 * @declaration
 */
public class AgentCashOrder {
    /**
     * 卡片编号
     */
    private Long cardid;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String cardno;

    /**
     * 持卡人名
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String BankName) {
        this.bankName = BankName;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
