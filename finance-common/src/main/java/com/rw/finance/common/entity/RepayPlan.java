package com.rw.finance.common.entity;

import com.rw.finance.common.constants.RepayPlanConstants;
import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class RepayPlan implements Serializable {

    public RepayPlan(){}

    public RepayPlan(long memberId,long cardId,int planType,double poundage,double money,int stageCount,String begDate,String endDate){
        this.memberId=memberId;
        this.cardId=cardId;
        this.planType=planType;
        this.poundage=poundage;
        this.money=money;
        this.stageCount=stageCount;
        this.begDate=begDate;
        this.endDate=endDate;
        this.status= RepayPlanConstants.Status.STATUS0.getStatus();
        this.updateTime= DateUtils.getTimeStr(new Date());
        this.createTime=DateUtils.getTimeStr(new Date());
    }

    private Long planId;

    private String begDate;

    private Long cardId;

    private String createTime;

    private String endDate;

    private Long memberId;

    private Double money;

    private Integer planType;

    private Double poundage;

    private Integer stageCount;

    private Integer status;

    private String updateTime;

    public String memberMobile;

    public String memberName;

    private static final long serialVersionUID = 1L;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Double getPoundage() {
        return poundage;
    }

    public void setPoundage(Double poundage) {
        this.poundage = poundage;
    }

    public Integer getStageCount() {
        return stageCount;
    }

    public void setStageCount(Integer stageCount) {
        this.stageCount = stageCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planId=").append(planId);
        sb.append(", begDate=").append(begDate);
        sb.append(", cardId=").append(cardId);
        sb.append(", createTime=").append(createTime);
        sb.append(", endDate=").append(endDate);
        sb.append(", memberId=").append(memberId);
        sb.append(", money=").append(money);
        sb.append(", planType=").append(planType);
        sb.append(", poundage=").append(poundage);
        sb.append(", stageCount=").append(stageCount);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
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
        RepayPlan other = (RepayPlan) that;
        return (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getBegDate() == null ? other.getBegDate() == null : this.getBegDate().equals(other.getBegDate()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getPlanType() == null ? other.getPlanType() == null : this.getPlanType().equals(other.getPlanType()))
            && (this.getPoundage() == null ? other.getPoundage() == null : this.getPoundage().equals(other.getPoundage()))
            && (this.getStageCount() == null ? other.getStageCount() == null : this.getStageCount().equals(other.getStageCount()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getBegDate() == null) ? 0 : getBegDate().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getPlanType() == null) ? 0 : getPlanType().hashCode());
        result = prime * result + ((getPoundage() == null) ? 0 : getPoundage().hashCode());
        result = prime * result + ((getStageCount() == null) ? 0 : getStageCount().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}