package com.rw.finance.common.entity;

import java.io.Serializable;

public class AgentCard implements Serializable {
    private Long agentCardId;

    private String abbreviation;

    private Long AgentId;

    private Long bankId;

    private String BankName;

    private String cardHolder;

    private String cardNo;

    private String city;

    private String createTime;

    private Integer isdel;

    private String mobile;

    private String province;

    private String updateTime;

    private static final long serialVersionUID = 1L;

    public Long getAgentCardId() {
        return agentCardId;
    }

    public void setAgentCardId(Long agentCardId) {
        this.agentCardId = agentCardId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getAgentId() {
        return AgentId;
    }

    public void setAgentId(Long AgentId) {
        this.AgentId = AgentId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
        sb.append(", agentCardId=").append(agentCardId);
        sb.append(", abbreviation=").append(abbreviation);
        sb.append(", AgentId=").append(AgentId);
        sb.append(", bankId=").append(bankId);
        sb.append(", BankName=").append(BankName);
        sb.append(", cardHolder=").append(cardHolder);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", city=").append(city);
        sb.append(", createTime=").append(createTime);
        sb.append(", isdel=").append(isdel);
        sb.append(", mobile=").append(mobile);
        sb.append(", province=").append(province);
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
        AgentCard other = (AgentCard) that;
        return (this.getAgentCardId() == null ? other.getAgentCardId() == null : this.getAgentCardId().equals(other.getAgentCardId()))
            && (this.getAbbreviation() == null ? other.getAbbreviation() == null : this.getAbbreviation().equals(other.getAbbreviation()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getCardHolder() == null ? other.getCardHolder() == null : this.getCardHolder().equals(other.getCardHolder()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAgentCardId() == null) ? 0 : getAgentCardId().hashCode());
        result = prime * result + ((getAbbreviation() == null) ? 0 : getAbbreviation().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getCardHolder() == null) ? 0 : getCardHolder().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}