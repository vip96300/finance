package com.rw.finance.common.entity;

import com.rw.finance.common.constants.Constants;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.Md5Util;

import java.io.Serializable;
import java.util.Date;

public class MemberInfo implements Serializable {
    public MemberInfo(){}

    public MemberInfo(String realName,String telephone,String password,String payPwd,String registerIp){
        this.realName=realName;
        this.telephone=telephone;
        this.password= Md5Util.md5(password);
        this.payPwd=payPwd;
        this.registerIp=registerIp;
        this.level= MemberInfoConstants.Level.LEVEL_0;
        this.isReal=0;
        this.idType=MemberInfoConstants.IdType.IDTYPE1.getIdType();
        this.status=MemberInfoConstants.Status.STATUS1.getStatus();
        this.registerTime= DateUtils.getTimeStr(new Date());
        this.lastLoginTime=DateUtils.getTimeStr(new Date());
    }
    /**
     * 实名认证参数传入
     */
    public void isReal(String realName,String idNumber,String idPath,String idobverse,String idreverse,String realcardpath){
        this.realName=realName;
        this.idNumber=idNumber;
        this.idPath=idPath;
        this.idObverse=idobverse;
        this.idReverse=idreverse;
        this.isReal= Constants.YN.Y.getValue();
        this.isRealTime=DateUtils.getTimeStr(new Date());
        this.realCardPath=realcardpath;
    }

    private Long memberId;

    /**
     * 三方通道分配的唯一编号
     *
     * @mbg.generated
     */
    private String memberToken;

    private String activeTime;

    private Long agentId;

    private String headPath;

    private String idNumber;

    private String idObverse;

    private String idPath;

    private String idReverse;

    private Integer idType;

    private Integer isReal;

    private String isRealTime;

    private String lastLoginTime;

    private Integer level;

    private String nickName;

    private Long parentId;

    private String password;

    private String payPwd;

    private String realName;

    private String registerIp;

    private String registerTime;

    private Integer status;

    private String telephone;

    private String realCardPath;

    private String levelTime;

    private static final long serialVersionUID = 1L;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberToken() {
        return memberToken;
    }

    public void setMemberToken(String memberToken) {
        this.memberToken = memberToken;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setidNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdObverse() {
        return idObverse;
    }

    public void setIdObverse(String idObverse) {
        this.idObverse = idObverse;
    }

    public String getIdPath() {
        return idPath;
    }

    public void setIdPath(String idPath) {
        this.idPath = idPath;
    }

    public String getIdReverse() {
        return idReverse;
    }

    public void setIdReverse(String idReverse) {
        this.idReverse = idReverse;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getIsReal() {
        return isReal;
    }

    public void setIsReal(Integer isReal) {
        this.isReal = isReal;
    }

    public String getIsRealTime() {
        return isRealTime;
    }

    public void setIsRealTime(String isRealTime) {
        this.isRealTime = isRealTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setrealName(String realName) {
        this.realName = realName;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRealCardPath() {
        return realCardPath;
    }

    public void setRealCardPath(String realCardPath) {
        this.realCardPath = realCardPath;
    }

    public String getLevelTime() {
        return levelTime;
    }

    public void setLevelTime(String levelTime) {
        this.levelTime = levelTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberId=").append(memberId);
        sb.append(", memberToken=").append(memberToken);
        sb.append(", activeTime=").append(activeTime);
        sb.append(", agentId=").append(agentId);
        sb.append(", headPath=").append(headPath);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", idObverse=").append(idObverse);
        sb.append(", idPath=").append(idPath);
        sb.append(", idReverse=").append(idReverse);
        sb.append(", idType=").append(idType);
        sb.append(", isReal=").append(isReal);
        sb.append(", isRealTime=").append(isRealTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", level=").append(level);
        sb.append(", nickName=").append(nickName);
        sb.append(", parentId=").append(parentId);
        sb.append(", password=").append(password);
        sb.append(", payPwd=").append(payPwd);
        sb.append(", realName=").append(realName);
        sb.append(", registerIp=").append(registerIp);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", status=").append(status);
        sb.append(", telephone=").append(telephone);
        sb.append(", realCardPath=").append(realCardPath);
        sb.append(", levelTime=").append(levelTime);
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
        MemberInfo other = (MemberInfo) that;
        return (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMemberToken() == null ? other.getMemberToken() == null : this.getMemberToken().equals(other.getMemberToken()))
            && (this.getActiveTime() == null ? other.getActiveTime() == null : this.getActiveTime().equals(other.getActiveTime()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getHeadPath() == null ? other.getHeadPath() == null : this.getHeadPath().equals(other.getHeadPath()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getIdObverse() == null ? other.getIdObverse() == null : this.getIdObverse().equals(other.getIdObverse()))
            && (this.getIdPath() == null ? other.getIdPath() == null : this.getIdPath().equals(other.getIdPath()))
            && (this.getIdReverse() == null ? other.getIdReverse() == null : this.getIdReverse().equals(other.getIdReverse()))
            && (this.getIdType() == null ? other.getIdType() == null : this.getIdType().equals(other.getIdType()))
            && (this.getIsReal() == null ? other.getIsReal() == null : this.getIsReal().equals(other.getIsReal()))
            && (this.getIsRealTime() == null ? other.getIsRealTime() == null : this.getIsRealTime().equals(other.getIsRealTime()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPayPwd() == null ? other.getPayPwd() == null : this.getPayPwd().equals(other.getPayPwd()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getRegisterIp() == null ? other.getRegisterIp() == null : this.getRegisterIp().equals(other.getRegisterIp()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getRealCardPath() == null ? other.getRealCardPath() == null : this.getRealCardPath().equals(other.getRealCardPath()))
            && (this.getLevelTime() == null ? other.getLevelTime() == null : this.getLevelTime().equals(other.getLevelTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMemberToken() == null) ? 0 : getMemberToken().hashCode());
        result = prime * result + ((getActiveTime() == null) ? 0 : getActiveTime().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getHeadPath() == null) ? 0 : getHeadPath().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getIdObverse() == null) ? 0 : getIdObverse().hashCode());
        result = prime * result + ((getIdPath() == null) ? 0 : getIdPath().hashCode());
        result = prime * result + ((getIdReverse() == null) ? 0 : getIdReverse().hashCode());
        result = prime * result + ((getIdType() == null) ? 0 : getIdType().hashCode());
        result = prime * result + ((getIsReal() == null) ? 0 : getIsReal().hashCode());
        result = prime * result + ((getIsRealTime() == null) ? 0 : getIsRealTime().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPayPwd() == null) ? 0 : getPayPwd().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getRegisterIp() == null) ? 0 : getRegisterIp().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getRealCardPath() == null) ? 0 : getRealCardPath().hashCode());
        result = prime * result + ((getLevelTime() == null) ? 0 : getLevelTime().hashCode());
        return result;
    }
}