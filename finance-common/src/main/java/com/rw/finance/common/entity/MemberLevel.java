package com.rw.finance.common.entity;

import java.io.Serializable;

public class MemberLevel implements Serializable {
    private Long levelId;

    /**
     * 会员等级
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 套现费率
     *
     * @mbg.generated
     */
    private Double borrowRate;

    /**
     * 提现费率
     *
     * @mbg.generated
     */
    private Double cashRate;

    /**
     * 还款费率
     *
     * @mbg.generated
     */
    private Double repayRate;

    /**
     * 渠道编号
     *
     * @mbg.generated
     */
    private Long channelId;

    /**
     * 套现手续费
     *
     * @mbg.generated
     */
    private Double borrowPoundage;

    /**
     * 提现手续费
     *
     * @mbg.generated
     */
    private Double cashPoundage;

    /**
     * 还款手续费
     *
     * @mbg.generated
     */
    private Double repayPoundage;

    private static final long serialVersionUID = 1L;

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getBorrowRate() {
        return borrowRate;
    }

    public void setBorrowRate(Double borrowRate) {
        this.borrowRate = borrowRate;
    }

    public Double getCashRate() {
        return cashRate;
    }

    public void setCashRate(Double cashRate) {
        this.cashRate = cashRate;
    }

    public Double getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(Double repayRate) {
        this.repayRate = repayRate;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Double getBorrowPoundage() {
        return borrowPoundage;
    }

    public void setBorrowPoundage(Double borrowPoundage) {
        this.borrowPoundage = borrowPoundage;
    }

    public Double getCashPoundage() {
        return cashPoundage;
    }

    public void setCashPoundage(Double cashPoundage) {
        this.cashPoundage = cashPoundage;
    }

    public Double getRepayPoundage() {
        return repayPoundage;
    }

    public void setRepayPoundage(Double repayPoundage) {
        this.repayPoundage = repayPoundage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", levelId=").append(levelId);
        sb.append(", level=").append(level);
        sb.append(", borrowRate=").append(borrowRate);
        sb.append(", cashRate=").append(cashRate);
        sb.append(", repayRate=").append(repayRate);
        sb.append(", channelId=").append(channelId);
        sb.append(", borrowPoundage=").append(borrowPoundage);
        sb.append(", cashPoundage=").append(cashPoundage);
        sb.append(", repayPoundage=").append(repayPoundage);
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
        MemberLevel other = (MemberLevel) that;
        return (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getBorrowRate() == null ? other.getBorrowRate() == null : this.getBorrowRate().equals(other.getBorrowRate()))
            && (this.getCashRate() == null ? other.getCashRate() == null : this.getCashRate().equals(other.getCashRate()))
            && (this.getRepayRate() == null ? other.getRepayRate() == null : this.getRepayRate().equals(other.getRepayRate()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getBorrowPoundage() == null ? other.getBorrowPoundage() == null : this.getBorrowPoundage().equals(other.getBorrowPoundage()))
            && (this.getCashPoundage() == null ? other.getCashPoundage() == null : this.getCashPoundage().equals(other.getCashPoundage()))
            && (this.getRepayPoundage() == null ? other.getRepayPoundage() == null : this.getRepayPoundage().equals(other.getRepayPoundage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getBorrowRate() == null) ? 0 : getBorrowRate().hashCode());
        result = prime * result + ((getCashRate() == null) ? 0 : getCashRate().hashCode());
        result = prime * result + ((getRepayRate() == null) ? 0 : getRepayRate().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getBorrowPoundage() == null) ? 0 : getBorrowPoundage().hashCode());
        result = prime * result + ((getCashPoundage() == null) ? 0 : getCashPoundage().hashCode());
        result = prime * result + ((getRepayPoundage() == null) ? 0 : getRepayPoundage().hashCode());
        return result;
    }
}