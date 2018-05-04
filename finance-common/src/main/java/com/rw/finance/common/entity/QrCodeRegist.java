package com.rw.finance.common.entity;

import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class QrCodeRegist implements Serializable {

    public QrCodeRegist(){}

    public QrCodeRegist(long memberid,long AgentId,String ipaddr,String useragent){
        this.memberId=memberid;
        this.AgentId=AgentId;
        this.ipAddr=ipaddr;
        this.userAgent=useragent;
        this.createTime= DateUtils.getTimeStr(new Date());
    }

    private Long registId;

    private Long AgentId;

    private String createTime;

    private String ipAddr;

    private Long memberId;

    private String userAgent;

    private static final long serialVersionUID = 1L;

    public Long getRegistId() {
        return registId;
    }

    public void setRegistId(Long registId) {
        this.registId = registId;
    }

    public Long getAgentId() {
        return AgentId;
    }

    public void setAgentId(Long AgentId) {
        this.AgentId = AgentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registId=").append(registId);
        sb.append(", AgentId=").append(AgentId);
        sb.append(", createTime=").append(createTime);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", memberId=").append(memberId);
        sb.append(", userAgent=").append(userAgent);
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
        QrCodeRegist other = (QrCodeRegist) that;
        return (this.getRegistId() == null ? other.getRegistId() == null : this.getRegistId().equals(other.getRegistId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIpAddr() == null ? other.getIpAddr() == null : this.getIpAddr().equals(other.getIpAddr()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getUserAgent() == null ? other.getUserAgent() == null : this.getUserAgent().equals(other.getUserAgent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegistId() == null) ? 0 : getRegistId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIpAddr() == null) ? 0 : getIpAddr().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getUserAgent() == null) ? 0 : getUserAgent().hashCode());
        return result;
    }
}