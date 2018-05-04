package com.rw.finance.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class SystemSetting implements Serializable {

    @JsonIgnore
    private Long dictId;
    @JsonIgnore
    private String createTime;

    private String dictKey;

    private String dictVal;
    @JsonIgnore
    private Integer isApp;
    @JsonIgnore
    private String remark;
    @JsonIgnore
    private Integer sort;
    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private String updateTime;

    private static final long serialVersionUID = 1L;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictVal() {
        return dictVal;
    }

    public void setDictVal(String dictVal) {
        this.dictVal = dictVal;
    }

    public Integer getIsApp() {
        return isApp;
    }

    public void setIsApp(Integer isApp) {
        this.isApp = isApp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictId=").append(dictId);
        sb.append(", createTime=").append(createTime);
        sb.append(", dictKey=").append(dictKey);
        sb.append(", dictVal=").append(dictVal);
        sb.append(", isApp=").append(isApp);
        sb.append(", remark=").append(remark);
        sb.append(", sort=").append(sort);
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
        SystemSetting other = (SystemSetting) that;
        return (this.getDictId() == null ? other.getDictId() == null : this.getDictId().equals(other.getDictId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDictKey() == null ? other.getDictKey() == null : this.getDictKey().equals(other.getDictKey()))
            && (this.getDictVal() == null ? other.getDictVal() == null : this.getDictVal().equals(other.getDictVal()))
            && (this.getIsApp() == null ? other.getIsApp() == null : this.getIsApp().equals(other.getIsApp()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictId() == null) ? 0 : getDictId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDictKey() == null) ? 0 : getDictKey().hashCode());
        result = prime * result + ((getDictVal() == null) ? 0 : getDictVal().hashCode());
        result = prime * result + ((getIsApp() == null) ? 0 : getIsApp().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}