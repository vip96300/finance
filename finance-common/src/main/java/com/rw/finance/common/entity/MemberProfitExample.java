package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberProfitExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public MemberProfitExample() {
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

        public Criteria andPofitIdIsNull() {
            addCriterion("pofit_id is null");
            return (Criteria) this;
        }

        public Criteria andPofitIdIsNotNull() {
            addCriterion("pofit_id is not null");
            return (Criteria) this;
        }

        public Criteria andPofitIdEqualTo(Long value) {
            addCriterion("pofit_id =", value, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdNotEqualTo(Long value) {
            addCriterion("pofit_id <>", value, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdGreaterThan(Long value) {
            addCriterion("pofit_id >", value, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pofit_id >=", value, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdLessThan(Long value) {
            addCriterion("pofit_id <", value, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdLessThanOrEqualTo(Long value) {
            addCriterion("pofit_id <=", value, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdIn(List<Long> values) {
            addCriterion("pofit_id in", values, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdNotIn(List<Long> values) {
            addCriterion("pofit_id not in", values, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdBetween(Long value1, Long value2) {
            addCriterion("pofit_id between", value1, value2, "pofitId");
            return (Criteria) this;
        }

        public Criteria andPofitIdNotBetween(Long value1, Long value2) {
            addCriterion("pofit_id not between", value1, value2, "pofitId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBizAmountIsNull() {
            addCriterion("biz_amount is null");
            return (Criteria) this;
        }

        public Criteria andBizAmountIsNotNull() {
            addCriterion("biz_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBizAmountEqualTo(Double value) {
            addCriterion("biz_amount =", value, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountNotEqualTo(Double value) {
            addCriterion("biz_amount <>", value, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountGreaterThan(Double value) {
            addCriterion("biz_amount >", value, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("biz_amount >=", value, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountLessThan(Double value) {
            addCriterion("biz_amount <", value, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountLessThanOrEqualTo(Double value) {
            addCriterion("biz_amount <=", value, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountIn(List<Double> values) {
            addCriterion("biz_amount in", values, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountNotIn(List<Double> values) {
            addCriterion("biz_amount not in", values, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountBetween(Double value1, Double value2) {
            addCriterion("biz_amount between", value1, value2, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizAmountNotBetween(Double value1, Double value2) {
            addCriterion("biz_amount not between", value1, value2, "bizAmount");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("biz_type is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(Integer value) {
            addCriterion("biz_type =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(Integer value) {
            addCriterion("biz_type <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(Integer value) {
            addCriterion("biz_type >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("biz_type >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(Integer value) {
            addCriterion("biz_type <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(Integer value) {
            addCriterion("biz_type <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<Integer> values) {
            addCriterion("biz_type in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<Integer> values) {
            addCriterion("biz_type not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(Integer value1, Integer value2) {
            addCriterion("biz_type between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("biz_type not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andProMemberIdIsNull() {
            addCriterion("pro_member_id is null");
            return (Criteria) this;
        }

        public Criteria andProMemberIdIsNotNull() {
            addCriterion("pro_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andProMemberIdEqualTo(Long value) {
            addCriterion("pro_member_id =", value, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdNotEqualTo(Long value) {
            addCriterion("pro_member_id <>", value, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdGreaterThan(Long value) {
            addCriterion("pro_member_id >", value, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pro_member_id >=", value, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdLessThan(Long value) {
            addCriterion("pro_member_id <", value, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("pro_member_id <=", value, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdIn(List<Long> values) {
            addCriterion("pro_member_id in", values, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdNotIn(List<Long> values) {
            addCriterion("pro_member_id not in", values, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdBetween(Long value1, Long value2) {
            addCriterion("pro_member_id between", value1, value2, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("pro_member_id not between", value1, value2, "proMemberId");
            return (Criteria) this;
        }

        public Criteria andProTelephoneIsNull() {
            addCriterion("pro_telephone is null");
            return (Criteria) this;
        }

        public Criteria andProTelephoneIsNotNull() {
            addCriterion("pro_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andProTelephoneEqualTo(String value) {
            addCriterion("pro_telephone =", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneNotEqualTo(String value) {
            addCriterion("pro_telephone <>", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneGreaterThan(String value) {
            addCriterion("pro_telephone >", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("pro_telephone >=", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneLessThan(String value) {
            addCriterion("pro_telephone <", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneLessThanOrEqualTo(String value) {
            addCriterion("pro_telephone <=", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneLike(String value) {
            addCriterion("pro_telephone like", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneNotLike(String value) {
            addCriterion("pro_telephone not like", value, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneIn(List<String> values) {
            addCriterion("pro_telephone in", values, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneNotIn(List<String> values) {
            addCriterion("pro_telephone not in", values, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneBetween(String value1, String value2) {
            addCriterion("pro_telephone between", value1, value2, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andProTelephoneNotBetween(String value1, String value2) {
            addCriterion("pro_telephone not between", value1, value2, "proTelephone");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "TradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "TradeNo");
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