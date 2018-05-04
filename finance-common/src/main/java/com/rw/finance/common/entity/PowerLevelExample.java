package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PowerLevelExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public PowerLevelExample() {
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

        public Criteria andActiveLimitIsNull() {
            addCriterion("active_limit is null");
            return (Criteria) this;
        }

        public Criteria andActiveLimitIsNotNull() {
            addCriterion("active_limit is not null");
            return (Criteria) this;
        }

        public Criteria andActiveLimitEqualTo(Integer value) {
            addCriterion("active_limit =", value, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitNotEqualTo(Integer value) {
            addCriterion("active_limit <>", value, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitGreaterThan(Integer value) {
            addCriterion("active_limit >", value, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_limit >=", value, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitLessThan(Integer value) {
            addCriterion("active_limit <", value, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitLessThanOrEqualTo(Integer value) {
            addCriterion("active_limit <=", value, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitIn(List<Integer> values) {
            addCriterion("active_limit in", values, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitNotIn(List<Integer> values) {
            addCriterion("active_limit not in", values, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitBetween(Integer value1, Integer value2) {
            addCriterion("active_limit between", value1, value2, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andActiveLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("active_limit not between", value1, value2, "activeLimit");
            return (Criteria) this;
        }

        public Criteria andDataPowerIsNull() {
            addCriterion("data_power is null");
            return (Criteria) this;
        }

        public Criteria andDataPowerIsNotNull() {
            addCriterion("data_power is not null");
            return (Criteria) this;
        }

        public Criteria andDataPowerEqualTo(Integer value) {
            addCriterion("data_power =", value, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerNotEqualTo(Integer value) {
            addCriterion("data_power <>", value, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerGreaterThan(Integer value) {
            addCriterion("data_power >", value, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_power >=", value, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerLessThan(Integer value) {
            addCriterion("data_power <", value, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerLessThanOrEqualTo(Integer value) {
            addCriterion("data_power <=", value, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerIn(List<Integer> values) {
            addCriterion("data_power in", values, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerNotIn(List<Integer> values) {
            addCriterion("data_power not in", values, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerBetween(Integer value1, Integer value2) {
            addCriterion("data_power between", value1, value2, "dataPower");
            return (Criteria) this;
        }

        public Criteria andDataPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("data_power not between", value1, value2, "dataPower");
            return (Criteria) this;
        }

        public Criteria andLevelNameIsNull() {
            addCriterion("level_name is null");
            return (Criteria) this;
        }

        public Criteria andLevelNameIsNotNull() {
            addCriterion("level_name is not null");
            return (Criteria) this;
        }

        public Criteria andLevelNameEqualTo(String value) {
            addCriterion("level_name =", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotEqualTo(String value) {
            addCriterion("level_name <>", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameGreaterThan(String value) {
            addCriterion("level_name >", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("level_name >=", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameLessThan(String value) {
            addCriterion("level_name <", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameLessThanOrEqualTo(String value) {
            addCriterion("level_name <=", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameLike(String value) {
            addCriterion("level_name like", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotLike(String value) {
            addCriterion("level_name not like", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameIn(List<String> values) {
            addCriterion("level_name in", values, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotIn(List<String> values) {
            addCriterion("level_name not in", values, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameBetween(String value1, String value2) {
            addCriterion("level_name between", value1, value2, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotBetween(String value1, String value2) {
            addCriterion("level_name not between", value1, value2, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelObjectIsNull() {
            addCriterion("level_object is null");
            return (Criteria) this;
        }

        public Criteria andLevelObjectIsNotNull() {
            addCriterion("level_object is not null");
            return (Criteria) this;
        }

        public Criteria andLevelObjectEqualTo(Integer value) {
            addCriterion("level_object =", value, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectNotEqualTo(Integer value) {
            addCriterion("level_object <>", value, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectGreaterThan(Integer value) {
            addCriterion("level_object >", value, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_object >=", value, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectLessThan(Integer value) {
            addCriterion("level_object <", value, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectLessThanOrEqualTo(Integer value) {
            addCriterion("level_object <=", value, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectIn(List<Integer> values) {
            addCriterion("level_object in", values, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectNotIn(List<Integer> values) {
            addCriterion("level_object not in", values, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectBetween(Integer value1, Integer value2) {
            addCriterion("level_object between", value1, value2, "levelObject");
            return (Criteria) this;
        }

        public Criteria andLevelObjectNotBetween(Integer value1, Integer value2) {
            addCriterion("level_object not between", value1, value2, "levelObject");
            return (Criteria) this;
        }

        public Criteria andSettleRatioIsNull() {
            addCriterion("settle_ratio is null");
            return (Criteria) this;
        }

        public Criteria andSettleRatioIsNotNull() {
            addCriterion("settle_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andSettleRatioEqualTo(Integer value) {
            addCriterion("settle_ratio =", value, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioNotEqualTo(Integer value) {
            addCriterion("settle_ratio <>", value, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioGreaterThan(Integer value) {
            addCriterion("settle_ratio >", value, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("settle_ratio >=", value, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioLessThan(Integer value) {
            addCriterion("settle_ratio <", value, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioLessThanOrEqualTo(Integer value) {
            addCriterion("settle_ratio <=", value, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioIn(List<Integer> values) {
            addCriterion("settle_ratio in", values, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioNotIn(List<Integer> values) {
            addCriterion("settle_ratio not in", values, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioBetween(Integer value1, Integer value2) {
            addCriterion("settle_ratio between", value1, value2, "settleRatio");
            return (Criteria) this;
        }

        public Criteria andSettleRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("settle_ratio not between", value1, value2, "settleRatio");
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