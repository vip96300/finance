package com.rw.finance.common.entity;

import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class OrderCount implements Serializable {

    public OrderCount() {
    }

    public OrderCount(String TradeNo, String tradeType, double tradeAmount, double memberProfitTotal, double
            agentProfitTotal, double companyProfitTotal) {
        this.TradeNo = TradeNo;
        this.tradeType = tradeType;
        this.tradeAmount = tradeAmount;
        this.memberProfitTotal = memberProfitTotal;
        this.agentProfitTotal = agentProfitTotal;
        this.companyProfitTotal = companyProfitTotal;
        this.createTime = DateUtils.getTimeStr(new Date());
    }

    private Long countId;

    private Double agentProfitTotal;

    private Double companyProfitTotal;

    private String createTime;

    private Double memberProfitTotal;

    private Double tradeAmount;

    private String TradeNo;

    private String tradeType;

    private static final long serialVersionUID = 1L;

    public Long getCountId() {
        return countId;
    }

    public void setCountId(Long countId) {
        this.countId = countId;
    }

    public Double getAgentProfitTotal() {
        return agentProfitTotal;
    }

    public void setAgentProfitTotal(Double agentProfitTotal) {
        this.agentProfitTotal = agentProfitTotal;
    }

    public Double getCompanyProfitTotal() {
        return companyProfitTotal;
    }

    public void setCompanyProfitTotal(Double companyProfitTotal) {
        this.companyProfitTotal = companyProfitTotal;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getMemberProfitTotal() {
        return memberProfitTotal;
    }

    public void setMemberProfitTotal(Double memberProfitTotal) {
        this.memberProfitTotal = memberProfitTotal;
    }

    public Double getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String TradeNo) {
        this.TradeNo = TradeNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countId=").append(countId);
        sb.append(", agentProfitTotal=").append(agentProfitTotal);
        sb.append(", companyProfitTotal=").append(companyProfitTotal);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberProfitTotal=").append(memberProfitTotal);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append(", TradeNo=").append(TradeNo);
        sb.append(", tradeType=").append(tradeType);
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
        OrderCount other = (OrderCount) that;
        return (this.getCountId() == null ? other.getCountId() == null : this.getCountId().equals(other.getCountId()))
            && (this.getAgentProfitTotal() == null ? other.getAgentProfitTotal() == null : this.getAgentProfitTotal().equals(other.getAgentProfitTotal()))
            && (this.getCompanyProfitTotal() == null ? other.getCompanyProfitTotal() == null : this.getCompanyProfitTotal().equals(other.getCompanyProfitTotal()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getMemberProfitTotal() == null ? other.getMemberProfitTotal() == null : this.getMemberProfitTotal().equals(other.getMemberProfitTotal()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCountId() == null) ? 0 : getCountId().hashCode());
        result = prime * result + ((getAgentProfitTotal() == null) ? 0 : getAgentProfitTotal().hashCode());
        result = prime * result + ((getCompanyProfitTotal() == null) ? 0 : getCompanyProfitTotal().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getMemberProfitTotal() == null) ? 0 : getMemberProfitTotal().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        return result;
    }
}