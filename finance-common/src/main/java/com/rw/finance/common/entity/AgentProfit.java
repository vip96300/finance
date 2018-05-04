package com.rw.finance.common.entity;

import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class AgentProfit implements Serializable {

    public AgentProfit(){}

    public AgentProfit(long AgentId,long promemberid,long OrderId,String TradeNo,double rate,double tradeamount,double amount,int profittype){
        this.AgentId=AgentId;
        this.proMemberId=promemberid;
        this.OrderId=OrderId;
        this.TradeNo=TradeNo;
        this.rate=rate;
        this.tradeAmount=tradeamount;
        this.amount=amount;
        this.profitType=profittype;
        this.createTime= DateUtils.getTimeStr(new Date());
    }

    private Long profitId;

    private Long AgentId;

    private Double amount;

    private String createTime;

    private Long OrderId;

    private Integer profitType;

    private Long proMemberId;

    private Double rate;

    private Double tradeAmount;

    private String TradeNo;

    private static final long serialVersionUID = 1L;

    public Long getProfitId() {
        return profitId;
    }

    public void setProfitId(Long profitId) {
        this.profitId = profitId;
    }

    public Long getAgentId() {
        return AgentId;
    }

    public void setAgentId(Long AgentId) {
        this.AgentId = AgentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }

    public Integer getProfitType() {
        return profitType;
    }

    public void setProfitType(Integer profitType) {
        this.profitType = profitType;
    }

    public Long getProMemberId() {
        return proMemberId;
    }

    public void setProMemberId(Long proMemberId) {
        this.proMemberId = proMemberId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", profitId=").append(profitId);
        sb.append(", AgentId=").append(AgentId);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", OrderId=").append(OrderId);
        sb.append(", profitType=").append(profitType);
        sb.append(", proMemberId=").append(proMemberId);
        sb.append(", rate=").append(rate);
        sb.append(", tradeAmount=").append(tradeAmount);
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
        AgentProfit other = (AgentProfit) that;
        return (this.getProfitId() == null ? other.getProfitId() == null : this.getProfitId().equals(other.getProfitId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getProfitType() == null ? other.getProfitType() == null : this.getProfitType().equals(other.getProfitType()))
            && (this.getProMemberId() == null ? other.getProMemberId() == null : this.getProMemberId().equals(other.getProMemberId()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getTradeAmount() == null ? other.getTradeAmount() == null : this.getTradeAmount().equals(other.getTradeAmount()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProfitId() == null) ? 0 : getProfitId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getProfitType() == null) ? 0 : getProfitType().hashCode());
        result = prime * result + ((getProMemberId() == null) ? 0 : getProMemberId().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getTradeAmount() == null) ? 0 : getTradeAmount().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        return result;
    }
}