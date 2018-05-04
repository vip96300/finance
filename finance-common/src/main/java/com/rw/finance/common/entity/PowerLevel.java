package com.rw.finance.common.entity;

import java.io.Serializable;

public class PowerLevel implements Serializable {
    private Long levelId;

    private Integer activeLimit;

    private Integer dataPower;

    private String levelName;

    private Integer levelObject;

    private Integer settleRatio;

    private static final long serialVersionUID = 1L;

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Integer getActiveLimit() {
        return activeLimit;
    }

    public void setActiveLimit(Integer activeLimit) {
        this.activeLimit = activeLimit;
    }

    public Integer getDataPower() {
        return dataPower;
    }

    public void setDataPower(Integer dataPower) {
        this.dataPower = dataPower;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelObject() {
        return levelObject;
    }

    public void setLevelObject(Integer levelObject) {
        this.levelObject = levelObject;
    }

    public Integer getSettleRatio() {
        return settleRatio;
    }

    public void setSettleRatio(Integer settleRatio) {
        this.settleRatio = settleRatio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", levelId=").append(levelId);
        sb.append(", activeLimit=").append(activeLimit);
        sb.append(", dataPower=").append(dataPower);
        sb.append(", levelName=").append(levelName);
        sb.append(", levelObject=").append(levelObject);
        sb.append(", settleRatio=").append(settleRatio);
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
        PowerLevel other = (PowerLevel) that;
        return (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
            && (this.getActiveLimit() == null ? other.getActiveLimit() == null : this.getActiveLimit().equals(other.getActiveLimit()))
            && (this.getDataPower() == null ? other.getDataPower() == null : this.getDataPower().equals(other.getDataPower()))
            && (this.getLevelName() == null ? other.getLevelName() == null : this.getLevelName().equals(other.getLevelName()))
            && (this.getLevelObject() == null ? other.getLevelObject() == null : this.getLevelObject().equals(other.getLevelObject()))
            && (this.getSettleRatio() == null ? other.getSettleRatio() == null : this.getSettleRatio().equals(other.getSettleRatio()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getActiveLimit() == null) ? 0 : getActiveLimit().hashCode());
        result = prime * result + ((getDataPower() == null) ? 0 : getDataPower().hashCode());
        result = prime * result + ((getLevelName() == null) ? 0 : getLevelName().hashCode());
        result = prime * result + ((getLevelObject() == null) ? 0 : getLevelObject().hashCode());
        result = prime * result + ((getSettleRatio() == null) ? 0 : getSettleRatio().hashCode());
        return result;
    }
}