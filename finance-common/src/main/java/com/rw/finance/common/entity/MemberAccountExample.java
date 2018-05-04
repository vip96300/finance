package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberAccountExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public MemberAccountExample() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andCashTotalIsNull() {
            addCriterion("cash_total is null");
            return (Criteria) this;
        }

        public Criteria andCashTotalIsNotNull() {
            addCriterion("cash_total is not null");
            return (Criteria) this;
        }

        public Criteria andCashTotalEqualTo(Double value) {
            addCriterion("cash_total =", value, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalNotEqualTo(Double value) {
            addCriterion("cash_total <>", value, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalGreaterThan(Double value) {
            addCriterion("cash_total >", value, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("cash_total >=", value, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalLessThan(Double value) {
            addCriterion("cash_total <", value, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalLessThanOrEqualTo(Double value) {
            addCriterion("cash_total <=", value, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalIn(List<Double> values) {
            addCriterion("cash_total in", values, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalNotIn(List<Double> values) {
            addCriterion("cash_total not in", values, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalBetween(Double value1, Double value2) {
            addCriterion("cash_total between", value1, value2, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andCashTotalNotBetween(Double value1, Double value2) {
            addCriterion("cash_total not between", value1, value2, "cashTotal");
            return (Criteria) this;
        }

        public Criteria andLockBalanceIsNull() {
            addCriterion("lock_balance is null");
            return (Criteria) this;
        }

        public Criteria andLockBalanceIsNotNull() {
            addCriterion("lock_balance is not null");
            return (Criteria) this;
        }

        public Criteria andLockBalanceEqualTo(Double value) {
            addCriterion("lock_balance =", value, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceNotEqualTo(Double value) {
            addCriterion("lock_balance <>", value, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceGreaterThan(Double value) {
            addCriterion("lock_balance >", value, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("lock_balance >=", value, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceLessThan(Double value) {
            addCriterion("lock_balance <", value, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceLessThanOrEqualTo(Double value) {
            addCriterion("lock_balance <=", value, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceIn(List<Double> values) {
            addCriterion("lock_balance in", values, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceNotIn(List<Double> values) {
            addCriterion("lock_balance not in", values, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceBetween(Double value1, Double value2) {
            addCriterion("lock_balance between", value1, value2, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andLockBalanceNotBetween(Double value1, Double value2) {
            addCriterion("lock_balance not between", value1, value2, "LockBalance");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
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

        public Criteria andRepayTotalIsNull() {
            addCriterion("repay_total is null");
            return (Criteria) this;
        }

        public Criteria andRepayTotalIsNotNull() {
            addCriterion("repay_total is not null");
            return (Criteria) this;
        }

        public Criteria andRepayTotalEqualTo(Double value) {
            addCriterion("repay_total =", value, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalNotEqualTo(Double value) {
            addCriterion("repay_total <>", value, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalGreaterThan(Double value) {
            addCriterion("repay_total >", value, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("repay_total >=", value, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalLessThan(Double value) {
            addCriterion("repay_total <", value, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalLessThanOrEqualTo(Double value) {
            addCriterion("repay_total <=", value, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalIn(List<Double> values) {
            addCriterion("repay_total in", values, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalNotIn(List<Double> values) {
            addCriterion("repay_total not in", values, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalBetween(Double value1, Double value2) {
            addCriterion("repay_total between", value1, value2, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andRepayTotalNotBetween(Double value1, Double value2) {
            addCriterion("repay_total not between", value1, value2, "repayTotal");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceIsNull() {
            addCriterion("usable_balance is null");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceIsNotNull() {
            addCriterion("usable_balance is not null");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceEqualTo(Double value) {
            addCriterion("usable_balance =", value, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceNotEqualTo(Double value) {
            addCriterion("usable_balance <>", value, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceGreaterThan(Double value) {
            addCriterion("usable_balance >", value, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("usable_balance >=", value, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceLessThan(Double value) {
            addCriterion("usable_balance <", value, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceLessThanOrEqualTo(Double value) {
            addCriterion("usable_balance <=", value, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceIn(List<Double> values) {
            addCriterion("usable_balance in", values, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceNotIn(List<Double> values) {
            addCriterion("usable_balance not in", values, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceBetween(Double value1, Double value2) {
            addCriterion("usable_balance between", value1, value2, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andUsableBalanceNotBetween(Double value1, Double value2) {
            addCriterion("usable_balance not between", value1, value2, "UsableBalance");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalIsNull() {
            addCriterion("borrow_total is null");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalIsNotNull() {
            addCriterion("borrow_total is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalEqualTo(Double value) {
            addCriterion("borrow_total =", value, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalNotEqualTo(Double value) {
            addCriterion("borrow_total <>", value, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalGreaterThan(Double value) {
            addCriterion("borrow_total >", value, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_total >=", value, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalLessThan(Double value) {
            addCriterion("borrow_total <", value, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalLessThanOrEqualTo(Double value) {
            addCriterion("borrow_total <=", value, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalIn(List<Double> values) {
            addCriterion("borrow_total in", values, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalNotIn(List<Double> values) {
            addCriterion("borrow_total not in", values, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalBetween(Double value1, Double value2) {
            addCriterion("borrow_total between", value1, value2, "borrowTotal");
            return (Criteria) this;
        }

        public Criteria andBorrowTotalNotBetween(Double value1, Double value2) {
            addCriterion("borrow_total not between", value1, value2, "borrowTotal");
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