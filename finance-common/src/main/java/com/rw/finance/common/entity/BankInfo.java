package com.rw.finance.common.entity;

import java.io.Serializable;

public class BankInfo implements Serializable {
    private Long bankId;

    private String abbreviation;

    private String bankCode;

    private String bankLogo;

    private String BankName;

    private String cardBins;

    private String cardColor;

    private String bankExtra;

    private static final long serialVersionUID = 1L;

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String bankLogo) {
        this.bankLogo = bankLogo;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public String getCardBins() {
        return cardBins;
    }

    public void setCardBins(String cardBins) {
        this.cardBins = cardBins;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getBankExtra() {
        return bankExtra;
    }

    public void setBankExtra(String bankExtra) {
        this.bankExtra = bankExtra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bankId=").append(bankId);
        sb.append(", abbreviation=").append(abbreviation);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", bankLogo=").append(bankLogo);
        sb.append(", BankName=").append(BankName);
        sb.append(", cardBins=").append(cardBins);
        sb.append(", cardColor=").append(cardColor);
        sb.append(", bankExtra=").append(bankExtra);
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
        BankInfo other = (BankInfo) that;
        return (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
            && (this.getAbbreviation() == null ? other.getAbbreviation() == null : this.getAbbreviation().equals(other.getAbbreviation()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getBankLogo() == null ? other.getBankLogo() == null : this.getBankLogo().equals(other.getBankLogo()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getCardBins() == null ? other.getCardBins() == null : this.getCardBins().equals(other.getCardBins()))
            && (this.getCardColor() == null ? other.getCardColor() == null : this.getCardColor().equals(other.getCardColor()))
            && (this.getBankExtra() == null ? other.getBankExtra() == null : this.getBankExtra().equals(other.getBankExtra()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getAbbreviation() == null) ? 0 : getAbbreviation().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getBankLogo() == null) ? 0 : getBankLogo().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getCardBins() == null) ? 0 : getCardBins().hashCode());
        result = prime * result + ((getCardColor() == null) ? 0 : getCardColor().hashCode());
        result = prime * result + ((getBankExtra() == null) ? 0 : getBankExtra().hashCode());
        return result;
    }
}