package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderCountExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public OrderCountExample() {
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

        public Criteria andCountIdIsNull() {
            addCriterion("count_id is null");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNotNull() {
            addCriterion("count_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountIdEqualTo(Long value) {
            addCriterion("count_id =", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotEqualTo(Long value) {
            addCriterion("count_id <>", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThan(Long value) {
            addCriterion("count_id >", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("count_id >=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThan(Long value) {
            addCriterion("count_id <", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThanOrEqualTo(Long value) {
            addCriterion("count_id <=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdIn(List<Long> values) {
            addCriterion("count_id in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotIn(List<Long> values) {
            addCriterion("count_id not in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdBetween(Long value1, Long value2) {
            addCriterion("count_id between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotBetween(Long value1, Long value2) {
            addCriterion("count_id not between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalIsNull() {
            addCriterion("agent_profit_total is null");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalIsNotNull() {
            addCriterion("agent_profit_total is not null");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalEqualTo(Double value) {
            addCriterion("agent_profit_total =", value, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalNotEqualTo(Double value) {
            addCriterion("agent_profit_total <>", value, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalGreaterThan(Double value) {
            addCriterion("agent_profit_total >", value, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("agent_profit_total >=", value, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalLessThan(Double value) {
            addCriterion("agent_profit_total <", value, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalLessThanOrEqualTo(Double value) {
            addCriterion("agent_profit_total <=", value, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalIn(List<Double> values) {
            addCriterion("agent_profit_total in", values, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalNotIn(List<Double> values) {
            addCriterion("agent_profit_total not in", values, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalBetween(Double value1, Double value2) {
            addCriterion("agent_profit_total between", value1, value2, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andAgentProfitTotalNotBetween(Double value1, Double value2) {
            addCriterion("agent_profit_total not between", value1, value2, "agentProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalIsNull() {
            addCriterion("company_profit_total is null");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalIsNotNull() {
            addCriterion("company_profit_total is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalEqualTo(Double value) {
            addCriterion("company_profit_total =", value, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalNotEqualTo(Double value) {
            addCriterion("company_profit_total <>", value, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalGreaterThan(Double value) {
            addCriterion("company_profit_total >", value, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("company_profit_total >=", value, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalLessThan(Double value) {
            addCriterion("company_profit_total <", value, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalLessThanOrEqualTo(Double value) {
            addCriterion("company_profit_total <=", value, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalIn(List<Double> values) {
            addCriterion("company_profit_total in", values, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalNotIn(List<Double> values) {
            addCriterion("company_profit_total not in", values, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalBetween(Double value1, Double value2) {
            addCriterion("company_profit_total between", value1, value2, "companyProfitTotal");
            return (Criteria) this;
        }

        public Criteria andCompanyProfitTotalNotBetween(Double value1, Double value2) {
            addCriterion("company_profit_total not between", value1, value2, "companyProfitTotal");
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

        public Criteria andMemberProfitTotalIsNull() {
            addCriterion("member_profit_total is null");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalIsNotNull() {
            addCriterion("member_profit_total is not null");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalEqualTo(Double value) {
            addCriterion("member_profit_total =", value, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalNotEqualTo(Double value) {
            addCriterion("member_profit_total <>", value, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalGreaterThan(Double value) {
            addCriterion("member_profit_total >", value, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("member_profit_total >=", value, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalLessThan(Double value) {
            addCriterion("member_profit_total <", value, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalLessThanOrEqualTo(Double value) {
            addCriterion("member_profit_total <=", value, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalIn(List<Double> values) {
            addCriterion("member_profit_total in", values, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalNotIn(List<Double> values) {
            addCriterion("member_profit_total not in", values, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalBetween(Double value1, Double value2) {
            addCriterion("member_profit_total between", value1, value2, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andMemberProfitTotalNotBetween(Double value1, Double value2) {
            addCriterion("member_profit_total not between", value1, value2, "memberProfitTotal");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(Double value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(Double value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(Double value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(Double value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(Double value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<Double> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<Double> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(Double value1, Double value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(Double value1, Double value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
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

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
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