package com.rw.finance.common.entity;

import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class MemberProfit implements Serializable {

    public MemberProfit() {
    }

    public MemberProfit(long memberid, long promemberid, String protelephone, int biztype, Double bizamount,
                        Double amount, String TradeNo, int level) {
        this.memberId = memberid;
        this.proMemberId = promemberid;
        this.proTelephone = protelephone;
        this.bizType = biztype;
        this.bizAmount = bizamount;
        this.amount = amount;
        this.TradeNo = TradeNo;
        this.level = level;
        this.createTime = DateUtils.getTimeStr(new Date());
    }

    private Long pofitId;

    private Double amount;

    private Double bizAmount;

    private Integer bizType;

    private String createTime;

    private Integer level;

    private Long memberId;

    private Long proMemberId;

    private String proTelephone;

    private String TradeNo;

    private static final long serialVersionUID = 1L;

    public Long getPofitId() {
        return pofitId;
    }

    public void setPofitId(Long pofitId) {
        this.pofitId = pofitId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBizAmount() {
        return bizAmount;
    }

    public void setBizAmount(Double bizAmount) {
        this.bizAmount = bizAmount;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getProMemberId() {
        return proMemberId;
    }

    public void setProMemberId(Long proMemberId) {
        this.proMemberId = proMemberId;
    }

    public String getProTelephone() {
        return proTelephone;
    }

    public void setProTelephone(String proTelephone) {
        this.proTelephone = proTelephone;
    }

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String TradeNo) {
        this.TradeNo = TradeNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pofitId=").append(pofitId);
        sb.append(", amount=").append(amount);
        sb.append(", bizAmount=").append(bizAmount);
        sb.append(", bizType=").append(bizType);
        sb.append(", createTime=").append(createTime);
        sb.append(", level=").append(level);
        sb.append(", memberId=").append(memberId);
        sb.append(", proMemberId=").append(proMemberId);
        sb.append(", proTelephone=").append(proTelephone);
        sb.append(", TradeNo=").append(TradeNo);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MemberProfit other = (MemberProfit) that;
        return (this.getPofitId() == null ? other.getPofitId() == null : this.getPofitId().equals(other.getPofitId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getBizAmount() == null ? other.getBizAmount() == null : this.getBizAmount().equals(other.getBizAmount()))
            && (this.getBizType() == null ? other.getBizType() == null : this.getBizType().equals(other.getBizType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getProMemberId() == null ? other.getProMemberId() == null : this.getProMemberId().equals(other.getProMemberId()))
            && (this.getProTelephone() == null ? other.getProTelephone() == null : this.getProTelephone().equals(other.getProTelephone()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPofitId() == null) ? 0 : getPofitId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getBizAmount() == null) ? 0 : getBizAmount().hashCode());
        result = prime * result + ((getBizType() == null) ? 0 : getBizType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getProMemberId() == null) ? 0 : getProMemberId().hashCode());
        result = prime * result + ((getProTelephone() == null) ? 0 : getProTelephone().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        return result;
    }
}