package com.rw.finance.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rw.finance.common.constants.MemberCardConstatns;
import com.rw.finance.common.utils.BankUtils;
import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class MemberCard implements Serializable {

    public MemberCard(){}
    /**
     * 借记卡
     * @param memberid
     * @param bankid
     * @param RealName
     * @param cardno
     * @param bankcode
     * @param BankName
     * @param banklogo
     * @param cardcolor
     */
    public MemberCard(long memberid,String IdNumber,long bankid,String RealName,
                      String cardno,String mobile,String bankcode,String BankName,
                      String abbreviation,String banklogo,String cardcolor,String bankextra){
        this.memberId=memberid;
        this.IdNumber=IdNumber;
        this.bankId=bankid;
        this.RealName=RealName;
        this.cardNo=cardno;
        this.mobile=mobile;
        this.authCode="000";
        this.bankCode=bankcode;
        this.BankName=BankName;
        this.bankLogo=banklogo;
        this.cardColor=cardcolor;
        this.type= MemberCardConstatns.Type.TYPE1.getType();
        this.status=MemberCardConstatns.Status.STATUS0.getStatus();
        this.updateTime= DateUtils.getTimeStr(new Date());
        this.createTime=DateUtils.getTimeStr(new Date());
        this.isDel=0;
        com.rw.finance.common.utils.BankUtils.BankInfo bankInfo= BankUtils.getBankInfo(cardno);
        if(bankInfo.getError_code()==0){
            this.province=bankInfo.getResult().getProvince();
            this.city=bankInfo.getResult().getCity();
        }
        this.abbreviation=abbreviation;
        this.bankExtra=bankextra;
    }

    /**
     * 贷记卡
     * @param memberid
     * @param IdNumber
     * @param bankid
     * @param cardno
     * @param RealName
     * @param expirydate
     * @param authcode
     * @param billdate
     * @param repaydate
     * @param mobile
     * @param bankcode
     * @param BankName
     * @param banklogo
     * @param bankcolor
     */
    public MemberCard(long memberid,String IdNumber,long bankid,String cardno,
                      String RealName,String expirydate,String authcode,String billdate,
                      String repaydate,String mobile,String bankcode,String BankName,String abbreviation,
                      String banklogo,String cardcolor,String bankextra){
        this.memberId=memberid;
        this.IdNumber=IdNumber;
        this.bankId=bankid;
        this.cardNo=cardno;
        this.RealName=RealName;
        this.expiryDate=expirydate;
        this.authCode=authcode;
        this.billDate=billdate;
        this.repayDate=repaydate;
        this.mobile=mobile;
        this.bankCode=bankcode;
        this.BankName=BankName;
        this.bankLogo=banklogo;
        this.cardColor=cardcolor;
        this.type=MemberCardConstatns.Type.TYPE2.getType();
        this.status=MemberCardConstatns.Status.STATUS0.getStatus();
        this.updateTime=DateUtils.getTimeStr(new Date());
        this.createTime=DateUtils.getTimeStr(new Date());
        this.isDel=0;
        this.isDef=0;
        com.rw.finance.common.utils.BankUtils.BankInfo bankInfo=BankUtils.getBankInfo(cardno);
        if(bankInfo.getError_code()==0){
            this.province=bankInfo.getResult().getProvince();
            this.city=bankInfo.getResult().getCity();
        }
        this.abbreviation=abbreviation;
        this.bankExtra=bankextra;
    }

    private Long cardId;
    @JsonIgnore
    private String abbreviation;
    @JsonIgnore
    private String authCode;
    @JsonIgnore
    private String bankCode;

    private Long bankId;

    private String bankLogo;

    private String BankName;

    private String billDate;

    private String cardColor;

    private String cardNo;
    @JsonIgnore
    private String cardPath;
    @JsonIgnore
    private String city;
    @JsonIgnore
    private String createTime;
    @JsonIgnore
    private String expiryDate;
    @JsonIgnore
    private String IdNumber;

    private Integer isDef;
    @JsonIgnore
    private Integer isDel;
    @JsonIgnore
    private Long memberId;
    @JsonIgnore
    private String mobile;
    @JsonIgnore
    private String province;

    private String RealName;

    private String repayDate;
    @JsonIgnore
    private Integer status;

    private Integer type;
    @JsonIgnore
    private String updateTime;

    private String bankExtra;

    /**
     * 今天至账单日天数
     */
    private int toBillDate;
    /**
     * 今天至还款日天数
     */
    private int toRepayDate;

    private static final long serialVersionUID = 1L;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
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

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String IdNumber) {
        this.IdNumber = IdNumber;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String RealName) {
        this.RealName = RealName;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBankExtra() {
        return bankExtra;
    }

    public void setBankExtra(String bankExtra) {
        this.bankExtra = bankExtra;
    }

    public int getToBillDate() {
        return toBillDate;
    }

    public void setToBillDate(int toBillDate) {
        this.toBillDate = toBillDate;
    }

    public int getToRepayDate() {
        return toRepayDate;
    }

    public void setToRepayDate(int toRepayDate) {
        this.toRepayDate = toRepayDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cardId=").append(cardId);
        sb.append(", abbreviation=").append(abbreviation);
        sb.append(", authCode=").append(authCode);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", bankId=").append(bankId);
        sb.append(", bankLogo=").append(bankLogo);
        sb.append(", BankName=").append(BankName);
        sb.append(", billDate=").append(billDate);
        sb.append(", cardColor=").append(cardColor);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", cardPath=").append(cardPath);
        sb.append(", city=").append(city);
        sb.append(", createTime=").append(createTime);
        sb.append(", expiryDate=").append(expiryDate);
        sb.append(", IdNumber=").append(IdNumber);
        sb.append(", isDef=").append(isDef);
        sb.append(", isDel=").append(isDel);
        sb.append(", memberId=").append(memberId);
        sb.append(", mobile=").append(mobile);
        sb.append(", province=").append(province);
        sb.append(", RealName=").append(RealName);
        sb.append(", repayDate=").append(repayDate);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", updateTime=").append(updateTime);
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
        MemberCard other = (MemberCard) that;
        return (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getAbbreviation() == null ? other.getAbbreviation() == null : this.getAbbreviation().equals(other.getAbbreviation()))
            && (this.getAuthCode() == null ? other.getAuthCode() == null : this.getAuthCode().equals(other.getAuthCode()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getBankId() == null ? other.getBankId() == null : this.getBankId().equals(other.getBankId()))
            && (this.getBankLogo() == null ? other.getBankLogo() == null : this.getBankLogo().equals(other.getBankLogo()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBillDate() == null ? other.getBillDate() == null : this.getBillDate().equals(other.getBillDate()))
            && (this.getCardColor() == null ? other.getCardColor() == null : this.getCardColor().equals(other.getCardColor()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getCardPath() == null ? other.getCardPath() == null : this.getCardPath().equals(other.getCardPath()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getExpiryDate() == null ? other.getExpiryDate() == null : this.getExpiryDate().equals(other.getExpiryDate()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getIsDef() == null ? other.getIsDef() == null : this.getIsDef().equals(other.getIsDef()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getRepayDate() == null ? other.getRepayDate() == null : this.getRepayDate().equals(other.getRepayDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getBankExtra() == null ? other.getBankExtra() == null : this.getBankExtra().equals(other.getBankExtra()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getAbbreviation() == null) ? 0 : getAbbreviation().hashCode());
        result = prime * result + ((getAuthCode() == null) ? 0 : getAuthCode().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getBankId() == null) ? 0 : getBankId().hashCode());
        result = prime * result + ((getBankLogo() == null) ? 0 : getBankLogo().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBillDate() == null) ? 0 : getBillDate().hashCode());
        result = prime * result + ((getCardColor() == null) ? 0 : getCardColor().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCardPath() == null) ? 0 : getCardPath().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getExpiryDate() == null) ? 0 : getExpiryDate().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getIsDef() == null) ? 0 : getIsDef().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getRepayDate() == null) ? 0 : getRepayDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBankExtra() == null) ? 0 : getBankExtra().hashCode());
        return result;
    }
}