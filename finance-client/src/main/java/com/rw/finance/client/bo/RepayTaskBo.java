package com.rw.finance.client.bo;

/**
 * @Author huanghongfei
 * @Description repay task 业务对象
 * @Date Create in 10:39 2018/4/20
 */
public class RepayTaskBo {

    /**
     * 还款任务投递消息对象
     */
    public class Message{
        public Message(long planId,long taskId){
            this.planId=planId;
            this.taskId=taskId;
        }
        /**
         * 计划编号
         */
        private long planId;
        /**
         * 任务编号
         */
        private long taskId;

        public long getPlanId() {
            return planId;
        }

        public void setPlanId(long planId) {
            this.planId = planId;
        }

        public long getTaskId() {
            return taskId;
        }

        public void setTaskId(long taskId) {
            this.taskId = taskId;
        }
    }
}
