package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgentAccountExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public AgentAccountExample() {
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

        public Criteria andActivateShareRateIsNull() {
            addCriterion("activate_share_rate is null");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateIsNotNull() {
            addCriterion("activate_share_rate is not null");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateEqualTo(Double value) {
            addCriterion("activate_share_rate =", value, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateNotEqualTo(Double value) {
            addCriterion("activate_share_rate <>", value, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateGreaterThan(Double value) {
            addCriterion("activate_share_rate >", value, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateGreaterThanOrEqualTo(Double value) {
            addCriterion("activate_share_rate >=", value, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateLessThan(Double value) {
            addCriterion("activate_share_rate <", value, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateLessThanOrEqualTo(Double value) {
            addCriterion("activate_share_rate <=", value, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateIn(List<Double> values) {
            addCriterion("activate_share_rate in", values, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateNotIn(List<Double> values) {
            addCriterion("activate_share_rate not in", values, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateBetween(Double value1, Double value2) {
            addCriterion("activate_share_rate between", value1, value2, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andActivateShareRateNotBetween(Double value1, Double value2) {
            addCriterion("activate_share_rate not between", value1, value2, "ActivateShareRate");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Long value) {
            addCriterion("agent_id =", value, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Long value) {
            addCriterion("agent_id <>", value, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Long value) {
            addCriterion("agent_id >", value, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("agent_id >=", value, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Long value) {
            addCriterion("agent_id <", value, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Long value) {
            addCriterion("agent_id <=", value, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Long> values) {
            addCriterion("agent_id in", values, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Long> values) {
            addCriterion("agent_id not in", values, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Long value1, Long value2) {
            addCriterion("agent_id between", value1, value2, "AgentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Long value1, Long value2) {
            addCriterion("agent_id not between", value1, value2, "AgentId");
            return (Criteria) this;
        }

        public Criteria andCashIncomeIsNull() {
            addCriterion("cash_income is null");
            return (Criteria) this;
        }

        public Criteria andCashIncomeIsNotNull() {
            addCriterion("cash_income is not null");
            return (Criteria) this;
        }

        public Criteria andCashIncomeEqualTo(Double value) {
            addCriterion("cash_income =", value, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeNotEqualTo(Double value) {
            addCriterion("cash_income <>", value, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeGreaterThan(Double value) {
            addCriterion("cash_income >", value, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("cash_income >=", value, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeLessThan(Double value) {
            addCriterion("cash_income <", value, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeLessThanOrEqualTo(Double value) {
            addCriterion("cash_income <=", value, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeIn(List<Double> values) {
            addCriterion("cash_income in", values, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeNotIn(List<Double> values) {
            addCriterion("cash_income not in", values, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeBetween(Double value1, Double value2) {
            addCriterion("cash_income between", value1, value2, "cashIncome");
            return (Criteria) this;
        }

        public Criteria andCashIncomeNotBetween(Double value1, Double value2) {
            addCriterion("cash_income not between", value1, value2, "cashIncome");
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

        public Criteria andRepayIncomeIsNull() {
            addCriterion("repay_income is null");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeIsNotNull() {
            addCriterion("repay_income is not null");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeEqualTo(Double value) {
            addCriterion("repay_income =", value, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeNotEqualTo(Double value) {
            addCriterion("repay_income <>", value, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeGreaterThan(Double value) {
            addCriterion("repay_income >", value, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("repay_income >=", value, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeLessThan(Double value) {
            addCriterion("repay_income <", value, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeLessThanOrEqualTo(Double value) {
            addCriterion("repay_income <=", value, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeIn(List<Double> values) {
            addCriterion("repay_income in", values, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeNotIn(List<Double> values) {
            addCriterion("repay_income not in", values, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeBetween(Double value1, Double value2) {
            addCriterion("repay_income between", value1, value2, "repayIncome");
            return (Criteria) this;
        }

        public Criteria andRepayIncomeNotBetween(Double value1, Double value2) {
            addCriterion("repay_income not between", value1, value2, "repayIncome");
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

        public Criteria andSettleCircleIsNull() {
            addCriterion("settle_circle is null");
            return (Criteria) this;
        }

        public Criteria andSettleCircleIsNotNull() {
            addCriterion("settle_circle is not null");
            return (Criteria) this;
        }

        public Criteria andSettleCircleEqualTo(Integer value) {
            addCriterion("settle_circle =", value, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleNotEqualTo(Integer value) {
            addCriterion("settle_circle <>", value, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleGreaterThan(Integer value) {
            addCriterion("settle_circle >", value, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleGreaterThanOrEqualTo(Integer value) {
            addCriterion("settle_circle >=", value, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleLessThan(Integer value) {
            addCriterion("settle_circle <", value, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleLessThanOrEqualTo(Integer value) {
            addCriterion("settle_circle <=", value, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleIn(List<Integer> values) {
            addCriterion("settle_circle in", values, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleNotIn(List<Integer> values) {
            addCriterion("settle_circle not in", values, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleBetween(Integer value1, Integer value2) {
            addCriterion("settle_circle between", value1, value2, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleCircleNotBetween(Integer value1, Integer value2) {
            addCriterion("settle_circle not between", value1, value2, "settleCircle");
            return (Criteria) this;
        }

        public Criteria andSettleRateIsNull() {
            addCriterion("settle_rate is null");
            return (Criteria) this;
        }

        public Criteria andSettleRateIsNotNull() {
            addCriterion("settle_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSettleRateEqualTo(Double value) {
            addCriterion("settle_rate =", value, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateNotEqualTo(Double value) {
            addCriterion("settle_rate <>", value, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateGreaterThan(Double value) {
            addCriterion("settle_rate >", value, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateGreaterThanOrEqualTo(Double value) {
            addCriterion("settle_rate >=", value, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateLessThan(Double value) {
            addCriterion("settle_rate <", value, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateLessThanOrEqualTo(Double value) {
            addCriterion("settle_rate <=", value, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateIn(List<Double> values) {
            addCriterion("settle_rate in", values, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateNotIn(List<Double> values) {
            addCriterion("settle_rate not in", values, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateBetween(Double value1, Double value2) {
            addCriterion("settle_rate between", value1, value2, "settleRate");
            return (Criteria) this;
        }

        public Criteria andSettleRateNotBetween(Double value1, Double value2) {
            addCriterion("settle_rate not between", value1, value2, "settleRate");
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

        public Criteria andUserRateIsNull() {
            addCriterion("user_rate is null");
            return (Criteria) this;
        }

        public Criteria andUserRateIsNotNull() {
            addCriterion("user_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUserRateEqualTo(Double value) {
            addCriterion("user_rate =", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateNotEqualTo(Double value) {
            addCriterion("user_rate <>", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateGreaterThan(Double value) {
            addCriterion("user_rate >", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateGreaterThanOrEqualTo(Double value) {
            addCriterion("user_rate >=", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateLessThan(Double value) {
            addCriterion("user_rate <", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateLessThanOrEqualTo(Double value) {
            addCriterion("user_rate <=", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateIn(List<Double> values) {
            addCriterion("user_rate in", values, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateNotIn(List<Double> values) {
            addCriterion("user_rate not in", values, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateBetween(Double value1, Double value2) {
            addCriterion("user_rate between", value1, value2, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateNotBetween(Double value1, Double value2) {
            addCriterion("user_rate not between", value1, value2, "userRate");
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
            addCriterion("borrow_share_rate =", value, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateNotEqualTo(Double value) {
            addCriterion("borrow_share_rate <>", value, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateGreaterThan(Double value) {
            addCriterion("borrow_share_rate >", value, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_share_rate >=", value, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateLessThan(Double value) {
            addCriterion("borrow_share_rate <", value, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateLessThanOrEqualTo(Double value) {
            addCriterion("borrow_share_rate <=", value, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateIn(List<Double> values) {
            addCriterion("borrow_share_rate in", values, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateNotIn(List<Double> values) {
            addCriterion("borrow_share_rate not in", values, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateBetween(Double value1, Double value2) {
            addCriterion("borrow_share_rate between", value1, value2, "BorrowShareRate");
            return (Criteria) this;
        }

        public Criteria andBorrowShareRateNotBetween(Double value1, Double value2) {
            addCriterion("borrow_share_rate not between", value1, value2, "BorrowShareRate");
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