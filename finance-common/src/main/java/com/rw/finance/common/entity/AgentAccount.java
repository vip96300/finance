package com.rw.finance.common.entity;

import java.io.Serializable;

public class AgentAccount implements Serializable {
    private Long accountId;

    private Double ActivateShareRate;

    private Long AgentId;

    private Double cashIncome;

    private Double cashTotal;

    private Double LockBalance;

    private Double repayIncome;

    private Double repayTotal;

    private Integer settleCircle;

    private Double settleRate;

    private Double repayShareRate;

    private Double UsableBalance;

    private Double userRate;

    private Double BorrowShareRate;

    private static final long serialVersionUID = 1L;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getActivateShareRate() {
        return ActivateShareRate;
    }

    public void setActivateShareRate(Double ActivateShareRate) {
        this.ActivateShareRate = ActivateShareRate;
    }

    public Long getAgentId() {
        return AgentId;
    }

    public void setAgentId(Long AgentId) {
        this.AgentId = AgentId;
    }

    public Double getCashIncome() {
        return cashIncome;
    }

    public void setCashIncome(Double cashIncome) {
        this.cashIncome = cashIncome;
    }

    public Double getCashTotal() {
        return cashTotal;
    }

    public void setCashTotal(Double cashTotal) {
        this.cashTotal = cashTotal;
    }

    public Double getLockBalance() {
        return LockBalance;
    }

    public void setLockBalance(Double LockBalance) {
        this.LockBalance = LockBalance;
    }

    public Double getRepayIncome() {
        return repayIncome;
    }

    public void setRepayIncome(Double repayIncome) {
        this.repayIncome = repayIncome;
    }

    public Double getRepayTotal() {
        return repayTotal;
    }

    public void setRepayTotal(Double repayTotal) {
        this.repayTotal = repayTotal;
    }

    public Integer getSettleCircle() {
        return settleCircle;
    }

    public void setSettleCircle(Integer settleCircle) {
        this.settleCircle = settleCircle;
    }

    public Double getSettleRate() {
        return settleRate;
    }

    public void setSettleRate(Double settleRate) {
        this.settleRate = settleRate;
    }

    public Double getRepayShareRate() {
        return repayShareRate;
    }

    public void setRepayShareRate(Double repayShareRate) {
        this.repayShareRate = repayShareRate;
    }

    public Double getUsableBalance() {
        return UsableBalance;
    }

    public void setUsableBalance(Double UsableBalance) {
        this.UsableBalance = UsableBalance;
    }

    public Double getUserRate() {
        return userRate;
    }

    public void setUserRate(Double userRate) {
        this.userRate = userRate;
    }

    public Double getBorrowShareRate() {
        return BorrowShareRate;
    }

    public void setBorrowShareRate(Double BorrowShareRate) {
        this.BorrowShareRate = BorrowShareRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountId=").append(accountId);
        sb.append(", ActivateShareRate=").append(ActivateShareRate);
        sb.append(", AgentId=").append(AgentId);
        sb.append(", cashIncome=").append(cashIncome);
        sb.append(", cashTotal=").append(cashTotal);
        sb.append(", LockBalance=").append(LockBalance);
        sb.append(", repayIncome=").append(repayIncome);
        sb.append(", repayTotal=").append(repayTotal);
        sb.append(", settleCircle=").append(settleCircle);
        sb.append(", settleRate=").append(settleRate);
        sb.append(", repayShareRate=").append(repayShareRate);
        sb.append(", UsableBalance=").append(UsableBalance);
        sb.append(", userRate=").append(userRate);
        sb.append(", BorrowShareRate=").append(BorrowShareRate);
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
        AgentAccount other = (AgentAccount) that;
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getActivateShareRate() == null ? other.getActivateShareRate() == null : this.getActivateShareRate().equals(other.getActivateShareRate()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getCashIncome() == null ? other.getCashIncome() == null : this.getCashIncome().equals(other.getCashIncome()))
            && (this.getCashTotal() == null ? other.getCashTotal() == null : this.getCashTotal().equals(other.getCashTotal()))
            && (this.getLockBalance() == null ? other.getLockBalance() == null : this.getLockBalance().equals(other.getLockBalance()))
            && (this.getRepayIncome() == null ? other.getRepayIncome() == null : this.getRepayIncome().equals(other.getRepayIncome()))
            && (this.getRepayTotal() == null ? other.getRepayTotal() == null : this.getRepayTotal().equals(other.getRepayTotal()))
            && (this.getSettleCircle() == null ? other.getSettleCircle() == null : this.getSettleCircle().equals(other.getSettleCircle()))
            && (this.getSettleRate() == null ? other.getSettleRate() == null : this.getSettleRate().equals(other.getSettleRate()))
            && (this.getRepayShareRate() == null ? other.getRepayShareRate() == null : this.getRepayShareRate().equals(other.getRepayShareRate()))
            && (this.getUsableBalance() == null ? other.getUsableBalance() == null : this.getUsableBalance().equals(other.getUsableBalance()))
            && (this.getUserRate() == null ? other.getUserRate() == null : this.getUserRate().equals(other.getUserRate()))
            && (this.getBorrowShareRate() == null ? other.getBorrowShareRate() == null : this.getBorrowShareRate().equals(other.getBorrowShareRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getActivateShareRate() == null) ? 0 : getActivateShareRate().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getCashIncome() == null) ? 0 : getCashIncome().hashCode());
        result = prime * result + ((getCashTotal() == null) ? 0 : getCashTotal().hashCode());
        result = prime * result + ((getLockBalance() == null) ? 0 : getLockBalance().hashCode());
        result = prime * result + ((getRepayIncome() == null) ? 0 : getRepayIncome().hashCode());
        result = prime * result + ((getRepayTotal() == null) ? 0 : getRepayTotal().hashCode());
        result = prime * result + ((getSettleCircle() == null) ? 0 : getSettleCircle().hashCode());
        result = prime * result + ((getSettleRate() == null) ? 0 : getSettleRate().hashCode());
        result = prime * result + ((getRepayShareRate() == null) ? 0 : getRepayShareRate().hashCode());
        result = prime * result + ((getUsableBalance() == null) ? 0 : getUsableBalance().hashCode());
        result = prime * result + ((getUserRate() == null) ? 0 : getUserRate().hashCode());
        result = prime * result + ((getBorrowShareRate() == null) ? 0 : getBorrowShareRate().hashCode());
        return result;
    }
}