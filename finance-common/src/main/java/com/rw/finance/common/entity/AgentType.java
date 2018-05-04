package com.rw.finance.common.entity;

import java.io.Serializable;

public class AgentType implements Serializable {
    private Long typeId;

    private Double activateShareRate;

    private Integer agentLevel;

    private Double borrowShareRate;

    private Double joinCost;

    private Double repayShareRate;

    private String typeName;

    private String updateTime;

    private static final long serialVersionUID = 1L;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Double getActivateShareRate() {
        return activateShareRate;
    }

    public void setActivateShareRate(Double activateShareRate) {
        this.activateShareRate = activateShareRate;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public Double getBorrowShareRate() {
        return borrowShareRate;
    }

    public void setBorrowShareRate(Double borrowShareRate) {
        this.borrowShareRate = borrowShareRate;
    }

    public Double getJoinCost() {
        return joinCost;
    }

    public void setJoinCost(Double joinCost) {
        this.joinCost = joinCost;
    }

    public Double getRepayShareRate() {
        return repayShareRate;
    }

    public void setRepayShareRate(Double repayShareRate) {
        this.repayShareRate = repayShareRate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", activateShareRate=").append(activateShareRate);
        sb.append(", agentLevel=").append(agentLevel);
        sb.append(", borrowShareRate=").append(borrowShareRate);
        sb.append(", joinCost=").append(joinCost);
        sb.append(", repayShareRate=").append(repayShareRate);
        sb.append(", typeName=").append(typeName);
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
        AgentType other = (AgentType) that;
        return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getActivateShareRate() == null ? other.getActivateShareRate() == null : this.getActivateShareRate().equals(other.getActivateShareRate()))
            && (this.getAgentLevel() == null ? other.getAgentLevel() == null : this.getAgentLevel().equals(other.getAgentLevel()))
            && (this.getBorrowShareRate() == null ? other.getBorrowShareRate() == null : this.getBorrowShareRate().equals(other.getBorrowShareRate()))
            && (this.getJoinCost() == null ? other.getJoinCost() == null : this.getJoinCost().equals(other.getJoinCost()))
            && (this.getRepayShareRate() == null ? other.getRepayShareRate() == null : this.getRepayShareRate().equals(other.getRepayShareRate()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getActivateShareRate() == null) ? 0 : getActivateShareRate().hashCode());
        result = prime * result + ((getAgentLevel() == null) ? 0 : getAgentLevel().hashCode());
        result = prime * result + ((getBorrowShareRate() == null) ? 0 : getBorrowShareRate().hashCode());
        result = prime * result + ((getJoinCost() == null) ? 0 : getJoinCost().hashCode());
        result = prime * result + ((getRepayShareRate() == null) ? 0 : getRepayShareRate().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}