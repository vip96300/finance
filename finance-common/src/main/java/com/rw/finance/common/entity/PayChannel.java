package com.rw.finance.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PayChannel implements Serializable {
    private Long channelId;
    @JsonIgnore
    private String channel;
    @JsonIgnore
    private String createTime;

    private String depict;
    @JsonIgnore
    private Integer isEnable;

    private String name;

    private Double maxAmount;

    private Double minAmount;

    private Integer backMode;
    @JsonIgnore
    private Integer isDef;

    private Set<MemberLevel> memberLevels=new HashSet<MemberLevel>();

    private static final long serialVersionUID = 1L;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getBackMode() {
        return backMode;
    }

    public void setBackMode(Integer backMode) {
        this.backMode = backMode;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public Set<MemberLevel> getMemberLevels() {
        return memberLevels;
    }

    public void setMemberLevels(Set<MemberLevel> memberLevels) {
        this.memberLevels = memberLevels;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelId=").append(channelId);
        sb.append(", channel=").append(channel);
        sb.append(", createTime=").append(createTime);
        sb.append(", depict=").append(depict);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", name=").append(name);
        sb.append(", maxAmount=").append(maxAmount);
        sb.append(", minAmount=").append(minAmount);
        sb.append(", backMode=").append(backMode);
        sb.append(", isDef=").append(isDef);
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
        PayChannel other = (PayChannel) that;
        return (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDepict() == null ? other.getDepict() == null : this.getDepict().equals(other.getDepict()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMaxAmount() == null ? other.getMaxAmount() == null : this.getMaxAmount().equals(other.getMaxAmount()))
            && (this.getMinAmount() == null ? other.getMinAmount() == null : this.getMinAmount().equals(other.getMinAmount()))
            && (this.getBackMode() == null ? other.getBackMode() == null : this.getBackMode().equals(other.getBackMode()))
            && (this.getIsDef() == null ? other.getIsDef() == null : this.getIsDef().equals(other.getIsDef()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDepict() == null) ? 0 : getDepict().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMaxAmount() == null) ? 0 : getMaxAmount().hashCode());
        result = prime * result + ((getMinAmount() == null) ? 0 : getMinAmount().hashCode());
        result = prime * result + ((getBackMode() == null) ? 0 : getBackMode().hashCode());
        result = prime * result + ((getIsDef() == null) ? 0 : getIsDef().hashCode());
        return result;
    }
}