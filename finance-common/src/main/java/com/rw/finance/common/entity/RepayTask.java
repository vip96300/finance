package com.rw.finance.common.entity;

import com.rw.finance.common.constants.RepayTaskConstants;
import com.rw.finance.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class RepayTask implements Serializable {

    public RepayTask(){}

    public RepayTask(long planid,int batch,long memberid,double taskAmount,double actualAmount,int TaskType,double poundage,int currentStage,String executeTime){
        this.planId=planid;
        this.batch=batch;
        this.memberId=memberid;
        this.taskAmount=taskAmount;
        this.actualAmount=actualAmount;
        this.TaskType=TaskType;
        this.poundage=poundage;
        this.currentStage=currentStage;
        this.executeTime=executeTime;
        this.status= RepayTaskConstants.Status.STATUS0.getStatus();
        this.createTime= DateUtils.getTimeStr(new Date());
    }

    private Long taskId;

    private Double actualAmount;

    private Integer batch;

    private String createTime;

    private Integer currentStage;

    private String executeTime;

    private Long memberId;

    private Long planId;

    private Double poundage;

    private Integer status;

    private Double taskAmount;

    private Integer TaskType;

    private static final long serialVersionUID = 1L;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(Integer currentStage) {
        this.currentStage = currentStage;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Double getPoundage() {
        return poundage;
    }

    public void setPoundage(Double poundage) {
        this.poundage = poundage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTaskAmount() {
        return taskAmount;
    }

    public void setTaskAmount(Double taskAmount) {
        this.taskAmount = taskAmount;
    }

    public Integer getTaskType() {
        return TaskType;
    }

    public void setTaskType(Integer TaskType) {
        this.TaskType = TaskType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", actualAmount=").append(actualAmount);
        sb.append(", batch=").append(batch);
        sb.append(", createTime=").append(createTime);
        sb.append(", currentStage=").append(currentStage);
        sb.append(", executeTime=").append(executeTime);
        sb.append(", memberId=").append(memberId);
        sb.append(", planId=").append(planId);
        sb.append(", poundage=").append(poundage);
        sb.append(", status=").append(status);
        sb.append(", taskAmount=").append(taskAmount);
        sb.append(", TaskType=").append(TaskType);
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
        RepayTask other = (RepayTask) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getActualAmount() == null ? other.getActualAmount() == null : this.getActualAmount().equals(other.getActualAmount()))
            && (this.getBatch() == null ? other.getBatch() == null : this.getBatch().equals(other.getBatch()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCurrentStage() == null ? other.getCurrentStage() == null : this.getCurrentStage().equals(other.getCurrentStage()))
            && (this.getExecuteTime() == null ? other.getExecuteTime() == null : this.getExecuteTime().equals(other.getExecuteTime()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getPoundage() == null ? other.getPoundage() == null : this.getPoundage().equals(other.getPoundage()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTaskAmount() == null ? other.getTaskAmount() == null : this.getTaskAmount().equals(other.getTaskAmount()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getActualAmount() == null) ? 0 : getActualAmount().hashCode());
        result = prime * result + ((getBatch() == null) ? 0 : getBatch().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCurrentStage() == null) ? 0 : getCurrentStage().hashCode());
        result = prime * result + ((getExecuteTime() == null) ? 0 : getExecuteTime().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getPoundage() == null) ? 0 : getPoundage().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTaskAmount() == null) ? 0 : getTaskAmount().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        return result;
    }
}