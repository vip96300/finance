package com.rw.finance.common.entity;

import java.io.Serializable;

public class MemberAccount implements Serializable {

    public MemberAccount() {
    }

    public MemberAccount(long memberid, double repayrate, double repaytotal, double cashtotal,double borrowtotal, double userablebalance, double LockBalance) {
        this.memberId = memberid;
        this.repayRate = repayrate;
        this.repayTotal = repaytotal;
        this.cashTotal = cashtotal;
        this.borrowTotal=borrowtotal;
        this.UsableBalance = userablebalance;
        this.LockBalance = LockBalance;
    }

    private Long accountId;

    private Double cashTotal;

    private Double LockBalance;

    private Long memberId;

    private Double repayRate;

    private Double repayTotal;

    private Double UsableBalance;

    private Double borrowTotal;

    private static final long serialVersionUID = 1L;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Double getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(Double repayRate) {
        this.repayRate = repayRate;
    }

    public Double getRepayTotal() {
        return repayTotal;
    }

    public void setRepayTotal(Double repayTotal) {
        this.repayTotal = repayTotal;
    }

    public Double getUsableBalance() {
        return UsableBalance;
    }

    public void setUsableBalance(Double UsableBalance) {
        this.UsableBalance = UsableBalance;
    }

    public Double getBorrowTotal() {
        return borrowTotal;
    }

    public void setBorrowTotal(Double borrowTotal) {
        this.borrowTotal = borrowTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountId=").append(accountId);
        sb.append(", cashTotal=").append(cashTotal);
        sb.append(", LockBalance=").append(LockBalance);
        sb.append(", memberId=").append(memberId);
        sb.append(", repayRate=").append(repayRate);
        sb.append(", repayTotal=").append(repayTotal);
        sb.append(", UsableBalance=").append(UsableBalance);
        sb.append(", borrowTotal=").append(borrowTotal);
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
        MemberAccount other = (MemberAccount) that;
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getCashTotal() == null ? other.getCashTotal() == null : this.getCashTotal().equals(other.getCashTotal()))
            && (this.getLockBalance() == null ? other.getLockBalance() == null : this.getLockBalance().equals(other.getLockBalance()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getRepayRate() == null ? other.getRepayRate() == null : this.getRepayRate().equals(other.getRepayRate()))
            && (this.getRepayTotal() == null ? other.getRepayTotal() == null : this.getRepayTotal().equals(other.getRepayTotal()))
            && (this.getUsableBalance() == null ? other.getUsableBalance() == null : this.getUsableBalance().equals(other.getUsableBalance()))
            && (this.getBorrowTotal() == null ? other.getBorrowTotal() == null : this.getBorrowTotal().equals(other.getBorrowTotal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getCashTotal() == null) ? 0 : getCashTotal().hashCode());
        result = prime * result + ((getLockBalance() == null) ? 0 : getLockBalance().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getRepayRate() == null) ? 0 : getRepayRate().hashCode());
        result = prime * result + ((getRepayTotal() == null) ? 0 : getRepayTotal().hashCode());
        result = prime * result + ((getUsableBalance() == null) ? 0 : getUsableBalance().hashCode());
        result = prime * result + ((getBorrowTotal() == null) ? 0 : getBorrowTotal().hashCode());
        return result;
    }
}