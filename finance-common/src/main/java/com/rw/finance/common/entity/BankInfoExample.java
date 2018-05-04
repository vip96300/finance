package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankInfoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public BankInfoExample() {
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

        public Criteria andBankIdIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBankIdIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankIdEqualTo(Long value) {
            addCriterion("bank_id =", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotEqualTo(Long value) {
            addCriterion("bank_id <>", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThan(Long value) {
            addCriterion("bank_id >", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bank_id >=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThan(Long value) {
            addCriterion("bank_id <", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdLessThanOrEqualTo(Long value) {
            addCriterion("bank_id <=", value, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdIn(List<Long> values) {
            addCriterion("bank_id in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotIn(List<Long> values) {
            addCriterion("bank_id not in", values, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdBetween(Long value1, Long value2) {
            addCriterion("bank_id between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andBankIdNotBetween(Long value1, Long value2) {
            addCriterion("bank_id not between", value1, value2, "bankId");
            return (Criteria) this;
        }

        public Criteria andAbbreviationIsNull() {
            addCriterion("abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andAbbreviationIsNotNull() {
            addCriterion("abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andAbbreviationEqualTo(String value) {
            addCriterion("abbreviation =", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotEqualTo(String value) {
            addCriterion("abbreviation <>", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationGreaterThan(String value) {
            addCriterion("abbreviation >", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("abbreviation >=", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationLessThan(String value) {
            addCriterion("abbreviation <", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("abbreviation <=", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationLike(String value) {
            addCriterion("abbreviation like", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotLike(String value) {
            addCriterion("abbreviation not like", value, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationIn(List<String> values) {
            addCriterion("abbreviation in", values, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotIn(List<String> values) {
            addCriterion("abbreviation not in", values, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationBetween(String value1, String value2) {
            addCriterion("abbreviation between", value1, value2, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andAbbreviationNotBetween(String value1, String value2) {
            addCriterion("abbreviation not between", value1, value2, "abbreviation");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("bank_code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("bank_code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("bank_code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("bank_code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("bank_code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("bank_code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("bank_code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("bank_code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("bank_code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("bank_code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("bank_code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankLogoIsNull() {
            addCriterion("bank_logo is null");
            return (Criteria) this;
        }

        public Criteria andBankLogoIsNotNull() {
            addCriterion("bank_logo is not null");
            return (Criteria) this;
        }

        public Criteria andBankLogoEqualTo(String value) {
            addCriterion("bank_logo =", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoNotEqualTo(String value) {
            addCriterion("bank_logo <>", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoGreaterThan(String value) {
            addCriterion("bank_logo >", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_logo >=", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoLessThan(String value) {
            addCriterion("bank_logo <", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoLessThanOrEqualTo(String value) {
            addCriterion("bank_logo <=", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoLike(String value) {
            addCriterion("bank_logo like", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoNotLike(String value) {
            addCriterion("bank_logo not like", value, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoIn(List<String> values) {
            addCriterion("bank_logo in", values, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoNotIn(List<String> values) {
            addCriterion("bank_logo not in", values, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoBetween(String value1, String value2) {
            addCriterion("bank_logo between", value1, value2, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankLogoNotBetween(String value1, String value2) {
            addCriterion("bank_logo not between", value1, value2, "bankLogo");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "BankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "BankName");
            return (Criteria) this;
        }

        public Criteria andCardBinsIsNull() {
            addCriterion("card_bins is null");
            return (Criteria) this;
        }

        public Criteria andCardBinsIsNotNull() {
            addCriterion("card_bins is not null");
            return (Criteria) this;
        }

        public Criteria andCardBinsEqualTo(String value) {
            addCriterion("card_bins =", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsNotEqualTo(String value) {
            addCriterion("card_bins <>", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsGreaterThan(String value) {
            addCriterion("card_bins >", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsGreaterThanOrEqualTo(String value) {
            addCriterion("card_bins >=", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsLessThan(String value) {
            addCriterion("card_bins <", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsLessThanOrEqualTo(String value) {
            addCriterion("card_bins <=", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsLike(String value) {
            addCriterion("card_bins like", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsNotLike(String value) {
            addCriterion("card_bins not like", value, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsIn(List<String> values) {
            addCriterion("card_bins in", values, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsNotIn(List<String> values) {
            addCriterion("card_bins not in", values, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsBetween(String value1, String value2) {
            addCriterion("card_bins between", value1, value2, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardBinsNotBetween(String value1, String value2) {
            addCriterion("card_bins not between", value1, value2, "cardBins");
            return (Criteria) this;
        }

        public Criteria andCardColorIsNull() {
            addCriterion("card_color is null");
            return (Criteria) this;
        }

        public Criteria andCardColorIsNotNull() {
            addCriterion("card_color is not null");
            return (Criteria) this;
        }

        public Criteria andCardColorEqualTo(String value) {
            addCriterion("card_color =", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorNotEqualTo(String value) {
            addCriterion("card_color <>", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorGreaterThan(String value) {
            addCriterion("card_color >", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorGreaterThanOrEqualTo(String value) {
            addCriterion("card_color >=", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorLessThan(String value) {
            addCriterion("card_color <", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorLessThanOrEqualTo(String value) {
            addCriterion("card_color <=", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorLike(String value) {
            addCriterion("card_color like", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorNotLike(String value) {
            addCriterion("card_color not like", value, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorIn(List<String> values) {
            addCriterion("card_color in", values, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorNotIn(List<String> values) {
            addCriterion("card_color not in", values, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorBetween(String value1, String value2) {
            addCriterion("card_color between", value1, value2, "cardColor");
            return (Criteria) this;
        }

        public Criteria andCardColorNotBetween(String value1, String value2) {
            addCriterion("card_color not between", value1, value2, "cardColor");
            return (Criteria) this;
        }

        public Criteria andBankExtraIsNull() {
            addCriterion("bank_extra is null");
            return (Criteria) this;
        }

        public Criteria andBankExtraIsNotNull() {
            addCriterion("bank_extra is not null");
            return (Criteria) this;
        }

        public Criteria andBankExtraEqualTo(String value) {
            addCriterion("bank_extra =", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraNotEqualTo(String value) {
            addCriterion("bank_extra <>", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraGreaterThan(String value) {
            addCriterion("bank_extra >", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraGreaterThanOrEqualTo(String value) {
            addCriterion("bank_extra >=", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraLessThan(String value) {
            addCriterion("bank_extra <", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraLessThanOrEqualTo(String value) {
            addCriterion("bank_extra <=", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraLike(String value) {
            addCriterion("bank_extra like", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraNotLike(String value) {
            addCriterion("bank_extra not like", value, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraIn(List<String> values) {
            addCriterion("bank_extra in", values, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraNotIn(List<String> values) {
            addCriterion("bank_extra not in", values, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraBetween(String value1, String value2) {
            addCriterion("bank_extra between", value1, value2, "bankExtra");
            return (Criteria) this;
        }

        public Criteria andBankExtraNotBetween(String value1, String value2) {
            addCriterion("bank_extra not between", value1, value2, "bankExtra");
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