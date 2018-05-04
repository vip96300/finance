package com.rw.finance.common.entity;

import com.rw.finance.common.constants.OrderInfoConstants;
import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class OrderInfo implements Serializable {

    public OrderInfo() {
    }

    /**
     * @param UserId
     * @param TradeNo
     * @param OrderAmount
     * @param RealAmount
     * @param channelid
     * @param outrradeno
     * @param type
     * @param remark
     * @param details
     */
    public OrderInfo(long UserId,String userName, String TradeNo, double OrderAmount, double RealAmount, long channelid, String
            outrradeno, int type, String remark, String details) {
        this.UserId = UserId;
        this.userName=userName;
        this.TradeNo = TradeNo;
        this.OrderAmount = OrderAmount;
        this.RealAmount = RealAmount;
        this.channelId = channelid;
        this.outTradeNo = outrradeno;
        this.type = type;
        this.status = OrderInfoConstants.Status.STATUS0.getStatus();
        this.remark = remark;
        this.details = details;
        this.updateTime = DateUtils.getTimeStr(new Date());
        this.createTime = DateUtils.getTimeStr(new Date());
    }

    private Long OrderId;

    private String createTime;

    private String details;

    private Double OrderAmount;

    private String outTradeNo;

    private Double RealAmount;

    private String remark;

    private Integer status;

    private String TradeNo;

    private Integer type;

    private String updateTime;

    private Long UserId;

    private Long channelId;

    private String userName;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(Double OrderAmount) {
        this.OrderAmount = OrderAmount;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Double getRealAmount() {
        return RealAmount;
    }

    public void setRealAmount(Double RealAmount) {
        this.RealAmount = RealAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTradeNo() {
        return TradeNo;
    }

    public void setTradeNo(String TradeNo) {
        this.TradeNo = TradeNo;
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

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", OrderId=").append(OrderId);
        sb.append(", createTime=").append(createTime);
        sb.append(", details=").append(details);
        sb.append(", OrderAmount=").append(OrderAmount);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", RealAmount=").append(RealAmount);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", TradeNo=").append(TradeNo);
        sb.append(", type=").append(type);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", UserId=").append(UserId);
        sb.append(", channelId=").append(channelId);
        sb.append(", userName=").append(userName);
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
        OrderInfo other = (OrderInfo) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getRealAmount() == null ? other.getRealAmount() == null : this.getRealAmount().equals(other.getRealAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getRealAmount() == null) ? 0 : getRealAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        return result;
    }
}