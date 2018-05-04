package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgentTypeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AgentTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Long value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Long value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Long value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Long value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Long> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Long> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Long value1, Long value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateIsNull() {
            addCriterion("activate_share_rate is null");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateIsNotNull() {
            addCriterion("activate_share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateEqualTo(Double value) {
            addCriterion("activate_share_rate =", value, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateNotEqualTo(Double value) {
            addCriterion("activate_share_rate <>", value, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateGreaterThan(Double value) {
            addCriterion("activate_share_rate >", value, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateGreaterThanOrEqualTo(Double value) {
            addCriterion("activate_share_rate >=", value, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateLessThan(Double value) {
            addCriterion("activate_share_rate <", value, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateLessThanOrEqualTo(Double value) {
            addCriterion("activate_share_rate <=", value, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateIn(List<Double> values) {
            addCriterion("activate_share_rate in", values, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateNotIn(List<Double> values) {
            addCriterion("activate_share_rate not in", values, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateBetween(Double value1, Double value2) {
            addCriterion("activate_share_rate between", value1, value2, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateNotBetween(Double value1, Double value2) {
            addCriterion("activate_share_rate not between", value1, value2, "activateShareRate");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNull() {
            addCriterion("agent_level is null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNotNull() {
            addCriterion("agent_level is not null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelEqualTo(Integer value) {
            addCriterion("agent_level =", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotEqualTo(Integer value) {
            addCriterion("agent_level <>", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThan(Integer value) {
            addCriterion("agent_level >", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_level >=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThan(Integer value) {
            addCriterion("agent_level <", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("agent_level <=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIn(List<Integer> values) {
            addCriterion("agent_level in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotIn(List<Integer> values) {
            addCriterion("agent_level not in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelBetween(Integer value1, Integer value2) {
            addCriterion("agent_level between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_level not between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateIsNull() {
            addCriterion("borrow_share_rate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateIsNotNull() {
            addCriterion("borrow_share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateEqualTo(Double value) {
            addCriterion("borrow_share_rate =", value, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateNotEqualTo(Double value) {
            addCriterion("borrow_share_rate <>", value, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateGreaterThan(Double value) {
            addCriterion("borrow_share_rate >", value, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_share_rate >=", value, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateLessThan(Double value) {
            addCriterion("borrow_share_rate <", value, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateLessThanOrEqualTo(Double value) {
            addCriterion("borrow_share_rate <=", value, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateIn(List<Double> values) {
            addCriterion("borrow_share_rate in", values, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateNotIn(List<Double> values) {
            addCriterion("borrow_share_rate not in", values, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateBetween(Double value1, Double value2) {
            addCriterion("borrow_share_rate between", value1, value2, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateNotBetween(Double value1, Double value2) {
            addCriterion("borrow_share_rate not between", value1, value2, "borrowShareRate");
            return (Criteria) this;
        }

        public Criteria andJoinCostIsNull() {
            addCriterion("join_cost is null");
            return (Criteria) this;
        }

        public Criteria andJoinCostIsNotNull() {
            addCriterion("join_cost is not null");
            return (Criteria) this;
        }

        public Criteria andJoinCostEqualTo(Double value) {
            addCriterion("join_cost =", value, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostNotEqualTo(Double value) {
            addCriterion("join_cost <>", value, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostGreaterThan(Double value) {
            addCriterion("join_cost >", value, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostGreaterThanOrEqualTo(Double value) {
            addCriterion("join_cost >=", value, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostLessThan(Double value) {
            addCriterion("join_cost <", value, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostLessThanOrEqualTo(Double value) {
            addCriterion("join_cost <=", value, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostIn(List<Double> values) {
            addCriterion("join_cost in", values, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostNotIn(List<Double> values) {
            addCriterion("join_cost not in", values, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostBetween(Double value1, Double value2) {
            addCriterion("join_cost between", value1, value2, "joinCost");
            return (Criteria) this;
        }

        public Criteria andJoinCostNotBetween(Double value1, Double value2) {
            addCriterion("join_cost not between", value1, value2, "joinCost");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateIsNull() {
            addCriterion("repay_share_rate is null");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateIsNotNull() {
            addCriterion("repay_share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateEqualTo(Double value) {
            addCriterion("repay_share_rate =", value, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateNotEqualTo(Double value) {
            addCriterion("repay_share_rate <>", value, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateGreaterThan(Double value) {
            addCriterion("repay_share_rate >", value, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateGreaterThanOrEqualTo(Double value) {
            addCriterion("repay_share_rate >=", value, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateLessThan(Double value) {
            addCriterion("repay_share_rate <", value, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateLessThanOrEqualTo(Double value) {
            addCriterion("repay_share_rate <=", value, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateIn(List<Double> values) {
            addCriterion("repay_share_rate in", values, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateNotIn(List<Double> values) {
            addCriterion("repay_share_rate not in", values, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateBetween(Double value1, Double value2) {
            addCriterion("repay_share_rate between", value1, value2, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andRepayShareRateNotBetween(Double value1, Double value2) {
            addCriterion("repay_share_rate not between", value1, value2, "repayShareRate");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}