package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberLevelExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public MemberLevelExample() {
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

        public Criteria andLevelIdIsNull() {
            addCriterion("level_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNotNull() {
            addCriterion("level_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelIdEqualTo(Long value) {
            addCriterion("level_id =", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotEqualTo(Long value) {
            addCriterion("level_id <>", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThan(Long value) {
            addCriterion("level_id >", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("level_id >=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThan(Long value) {
            addCriterion("level_id <", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThanOrEqualTo(Long value) {
            addCriterion("level_id <=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIn(List<Long> values) {
            addCriterion("level_id in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotIn(List<Long> values) {
            addCriterion("level_id not in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdBetween(Long value1, Long value2) {
            addCriterion("level_id between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotBetween(Long value1, Long value2) {
            addCriterion("level_id not between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andBorrowRateIsNull() {
            addCriterion("borrow_rate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowRateIsNotNull() {
            addCriterion("borrow_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowRateEqualTo(Double value) {
            addCriterion("borrow_rate =", value, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateNotEqualTo(Double value) {
            addCriterion("borrow_rate <>", value, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateGreaterThan(Double value) {
            addCriterion("borrow_rate >", value, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_rate >=", value, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateLessThan(Double value) {
            addCriterion("borrow_rate <", value, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateLessThanOrEqualTo(Double value) {
            addCriterion("borrow_rate <=", value, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateIn(List<Double> values) {
            addCriterion("borrow_rate in", values, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateNotIn(List<Double> values) {
            addCriterion("borrow_rate not in", values, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateBetween(Double value1, Double value2) {
            addCriterion("borrow_rate between", value1, value2, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andBorrowRateNotBetween(Double value1, Double value2) {
            addCriterion("borrow_rate not between", value1, value2, "borrowRate");
            return (Criteria) this;
        }

        public Criteria andCashRateIsNull() {
            addCriterion("cash_rate is null");
            return (Criteria) this;
        }

        public Criteria andCashRateIsNotNull() {
            addCriterion("cash_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCashRateEqualTo(Double value) {
            addCriterion("cash_rate =", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateNotEqualTo(Double value) {
            addCriterion("cash_rate <>", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateGreaterThan(Double value) {
            addCriterion("cash_rate >", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateGreaterThanOrEqualTo(Double value) {
            addCriterion("cash_rate >=", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateLessThan(Double value) {
            addCriterion("cash_rate <", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateLessThanOrEqualTo(Double value) {
            addCriterion("cash_rate <=", value, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateIn(List<Double> values) {
            addCriterion("cash_rate in", values, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateNotIn(List<Double> values) {
            addCriterion("cash_rate not in", values, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateBetween(Double value1, Double value2) {
            addCriterion("cash_rate between", value1, value2, "cashRate");
            return (Criteria) this;
        }

        public Criteria andCashRateNotBetween(Double value1, Double value2) {
            addCriterion("cash_rate not between", value1, value2, "cashRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateIsNull() {
            addCriterion("repay_rate is null");
            return (Criteria) this;
        }

        public Criteria andRepayRateIsNotNull() {
            addCriterion("repay_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRepayRateEqualTo(Double value) {
            addCriterion("repay_rate =", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotEqualTo(Double value) {
            addCriterion("repay_rate <>", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateGreaterThan(Double value) {
            addCriterion("repay_rate >", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateGreaterThanOrEqualTo(Double value) {
            addCriterion("repay_rate >=", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateLessThan(Double value) {
            addCriterion("repay_rate <", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateLessThanOrEqualTo(Double value) {
            addCriterion("repay_rate <=", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateIn(List<Double> values) {
            addCriterion("repay_rate in", values, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotIn(List<Double> values) {
            addCriterion("repay_rate not in", values, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateBetween(Double value1, Double value2) {
            addCriterion("repay_rate between", value1, value2, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotBetween(Double value1, Double value2) {
            addCriterion("repay_rate not between", value1, value2, "repayRate");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageIsNull() {
            addCriterion("borrow_poundage is null");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageIsNotNull() {
            addCriterion("borrow_poundage is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageEqualTo(Double value) {
            addCriterion("borrow_poundage =", value, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageNotEqualTo(Double value) {
            addCriterion("borrow_poundage <>", value, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageGreaterThan(Double value) {
            addCriterion("borrow_poundage >", value, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_poundage >=", value, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageLessThan(Double value) {
            addCriterion("borrow_poundage <", value, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageLessThanOrEqualTo(Double value) {
            addCriterion("borrow_poundage <=", value, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageIn(List<Double> values) {
            addCriterion("borrow_poundage in", values, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageNotIn(List<Double> values) {
            addCriterion("borrow_poundage not in", values, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageBetween(Double value1, Double value2) {
            addCriterion("borrow_poundage between", value1, value2, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andBorrowPoundageNotBetween(Double value1, Double value2) {
            addCriterion("borrow_poundage not between", value1, value2, "borrowPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageIsNull() {
            addCriterion("cash_poundage is null");
            return (Criteria) this;
        }

        public Criteria andCashPoundageIsNotNull() {
            addCriterion("cash_poundage is not null");
            return (Criteria) this;
        }

        public Criteria andCashPoundageEqualTo(Double value) {
            addCriterion("cash_poundage =", value, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageNotEqualTo(Double value) {
            addCriterion("cash_poundage <>", value, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageGreaterThan(Double value) {
            addCriterion("cash_poundage >", value, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageGreaterThanOrEqualTo(Double value) {
            addCriterion("cash_poundage >=", value, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageLessThan(Double value) {
            addCriterion("cash_poundage <", value, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageLessThanOrEqualTo(Double value) {
            addCriterion("cash_poundage <=", value, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageIn(List<Double> values) {
            addCriterion("cash_poundage in", values, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageNotIn(List<Double> values) {
            addCriterion("cash_poundage not in", values, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageBetween(Double value1, Double value2) {
            addCriterion("cash_poundage between", value1, value2, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andCashPoundageNotBetween(Double value1, Double value2) {
            addCriterion("cash_poundage not between", value1, value2, "cashPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageIsNull() {
            addCriterion("repay_poundage is null");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageIsNotNull() {
            addCriterion("repay_poundage is not null");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageEqualTo(Double value) {
            addCriterion("repay_poundage =", value, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageNotEqualTo(Double value) {
            addCriterion("repay_poundage <>", value, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageGreaterThan(Double value) {
            addCriterion("repay_poundage >", value, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageGreaterThanOrEqualTo(Double value) {
            addCriterion("repay_poundage >=", value, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageLessThan(Double value) {
            addCriterion("repay_poundage <", value, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageLessThanOrEqualTo(Double value) {
            addCriterion("repay_poundage <=", value, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageIn(List<Double> values) {
            addCriterion("repay_poundage in", values, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageNotIn(List<Double> values) {
            addCriterion("repay_poundage not in", values, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageBetween(Double value1, Double value2) {
            addCriterion("repay_poundage between", value1, value2, "repayPoundage");
            return (Criteria) this;
        }

        public Criteria andRepayPoundageNotBetween(Double value1, Double value2) {
            addCriterion("repay_poundage not between", value1, value2, "repayPoundage");
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