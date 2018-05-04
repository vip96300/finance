package com.rw.finance.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberInfoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    private Integer limit;

    private Integer offset;

    public MemberInfoExample() {
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

        public Criteria andActiveTimeIsNull() {
            addCriterion("active_time is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("active_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(String value) {
            addCriterion("active_time =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(String value) {
            addCriterion("active_time <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(String value) {
            addCriterion("active_time >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("active_time >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(String value) {
            addCriterion("active_time <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(String value) {
            addCriterion("active_time <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLike(String value) {
            addCriterion("active_time like", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotLike(String value) {
            addCriterion("active_time not like", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<String> values) {
            addCriterion("active_time in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<String> values) {
            addCriterion("active_time not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(String value1, String value2) {
            addCriterion("active_time between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(String value1, String value2) {
            addCriterion("active_time not between", value1, value2, "activeTime");
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

        public Criteria andHeadPathIsNull() {
            addCriterion("head_path is null");
            return (Criteria) this;
        }

        public Criteria andHeadPathIsNotNull() {
            addCriterion("head_path is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPathEqualTo(String value) {
            addCriterion("head_path =", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotEqualTo(String value) {
            addCriterion("head_path <>", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathGreaterThan(String value) {
            addCriterion("head_path >", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathGreaterThanOrEqualTo(String value) {
            addCriterion("head_path >=", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLessThan(String value) {
            addCriterion("head_path <", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLessThanOrEqualTo(String value) {
            addCriterion("head_path <=", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLike(String value) {
            addCriterion("head_path like", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotLike(String value) {
            addCriterion("head_path not like", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathIn(List<String> values) {
            addCriterion("head_path in", values, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotIn(List<String> values) {
            addCriterion("head_path not in", values, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathBetween(String value1, String value2) {
            addCriterion("head_path between", value1, value2, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotBetween(String value1, String value2) {
            addCriterion("head_path not between", value1, value2, "headPath");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "IdNumber");
            return (Criteria) this;
        }

        public Criteria andIdObverseIsNull() {
            addCriterion("id_obverse is null");
            return (Criteria) this;
        }

        public Criteria andIdObverseIsNotNull() {
            addCriterion("id_obverse is not null");
            return (Criteria) this;
        }

        public Criteria andIdObverseEqualTo(String value) {
            addCriterion("id_obverse =", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotEqualTo(String value) {
            addCriterion("id_obverse <>", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseGreaterThan(String value) {
            addCriterion("id_obverse >", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseGreaterThanOrEqualTo(String value) {
            addCriterion("id_obverse >=", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseLessThan(String value) {
            addCriterion("id_obverse <", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseLessThanOrEqualTo(String value) {
            addCriterion("id_obverse <=", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseLike(String value) {
            addCriterion("id_obverse like", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotLike(String value) {
            addCriterion("id_obverse not like", value, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseIn(List<String> values) {
            addCriterion("id_obverse in", values, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotIn(List<String> values) {
            addCriterion("id_obverse not in", values, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseBetween(String value1, String value2) {
            addCriterion("id_obverse between", value1, value2, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdObverseNotBetween(String value1, String value2) {
            addCriterion("id_obverse not between", value1, value2, "idObverse");
            return (Criteria) this;
        }

        public Criteria andIdPathIsNull() {
            addCriterion("id_path is null");
            return (Criteria) this;
        }

        public Criteria andIdPathIsNotNull() {
            addCriterion("id_path is not null");
            return (Criteria) this;
        }

        public Criteria andIdPathEqualTo(String value) {
            addCriterion("id_path =", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathNotEqualTo(String value) {
            addCriterion("id_path <>", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathGreaterThan(String value) {
            addCriterion("id_path >", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathGreaterThanOrEqualTo(String value) {
            addCriterion("id_path >=", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathLessThan(String value) {
            addCriterion("id_path <", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathLessThanOrEqualTo(String value) {
            addCriterion("id_path <=", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathLike(String value) {
            addCriterion("id_path like", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathNotLike(String value) {
            addCriterion("id_path not like", value, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathIn(List<String> values) {
            addCriterion("id_path in", values, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathNotIn(List<String> values) {
            addCriterion("id_path not in", values, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathBetween(String value1, String value2) {
            addCriterion("id_path between", value1, value2, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdPathNotBetween(String value1, String value2) {
            addCriterion("id_path not between", value1, value2, "idPath");
            return (Criteria) this;
        }

        public Criteria andIdReverseIsNull() {
            addCriterion("id_reverse is null");
            return (Criteria) this;
        }

        public Criteria andIdReverseIsNotNull() {
            addCriterion("id_reverse is not null");
            return (Criteria) this;
        }

        public Criteria andIdReverseEqualTo(String value) {
            addCriterion("id_reverse =", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseNotEqualTo(String value) {
            addCriterion("id_reverse <>", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseGreaterThan(String value) {
            addCriterion("id_reverse >", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseGreaterThanOrEqualTo(String value) {
            addCriterion("id_reverse >=", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseLessThan(String value) {
            addCriterion("id_reverse <", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseLessThanOrEqualTo(String value) {
            addCriterion("id_reverse <=", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseLike(String value) {
            addCriterion("id_reverse like", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseNotLike(String value) {
            addCriterion("id_reverse not like", value, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseIn(List<String> values) {
            addCriterion("id_reverse in", values, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseNotIn(List<String> values) {
            addCriterion("id_reverse not in", values, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseBetween(String value1, String value2) {
            addCriterion("id_reverse between", value1, value2, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdReverseNotBetween(String value1, String value2) {
            addCriterion("id_reverse not between", value1, value2, "idReverse");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(Integer value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(Integer value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(Integer value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(Integer value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<Integer> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<Integer> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(Integer value1, Integer value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIsRealIsNull() {
            addCriterion("is_real is null");
            return (Criteria) this;
        }

        public Criteria andIsRealIsNotNull() {
            addCriterion("is_real is not null");
            return (Criteria) this;
        }

        public Criteria andIsRealEqualTo(Integer value) {
            addCriterion("is_real =", value, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealNotEqualTo(Integer value) {
            addCriterion("is_real <>", value, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealGreaterThan(Integer value) {
            addCriterion("is_real >", value, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_real >=", value, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealLessThan(Integer value) {
            addCriterion("is_real <", value, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealLessThanOrEqualTo(Integer value) {
            addCriterion("is_real <=", value, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealIn(List<Integer> values) {
            addCriterion("is_real in", values, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealNotIn(List<Integer> values) {
            addCriterion("is_real not in", values, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealBetween(Integer value1, Integer value2) {
            addCriterion("is_real between", value1, value2, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealNotBetween(Integer value1, Integer value2) {
            addCriterion("is_real not between", value1, value2, "isReal");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeIsNull() {
            addCriterion("is_real_time is null");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeIsNotNull() {
            addCriterion("is_real_time is not null");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeEqualTo(String value) {
            addCriterion("is_real_time =", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeNotEqualTo(String value) {
            addCriterion("is_real_time <>", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeGreaterThan(String value) {
            addCriterion("is_real_time >", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("is_real_time >=", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeLessThan(String value) {
            addCriterion("is_real_time <", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeLessThanOrEqualTo(String value) {
            addCriterion("is_real_time <=", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeLike(String value) {
            addCriterion("is_real_time like", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeNotLike(String value) {
            addCriterion("is_real_time not like", value, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeIn(List<String> values) {
            addCriterion("is_real_time in", values, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeNotIn(List<String> values) {
            addCriterion("is_real_time not in", values, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeBetween(String value1, String value2) {
            addCriterion("is_real_time between", value1, value2, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andIsRealTimeNotBetween(String value1, String value2) {
            addCriterion("is_real_time not between", value1, value2, "isRealTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(String value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(String value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(String value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(String value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(String value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLike(String value) {
            addCriterion("last_login_time like", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotLike(String value) {
            addCriterion("last_login_time not like", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<String> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<String> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(String value1, String value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(String value1, String value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
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

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "ParentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "ParentId");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPayPwdIsNull() {
            addCriterion("pay_pwd is null");
            return (Criteria) this;
        }

        public Criteria andPayPwdIsNotNull() {
            addCriterion("pay_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPayPwdEqualTo(String value) {
            addCriterion("pay_pwd =", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotEqualTo(String value) {
            addCriterion("pay_pwd <>", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdGreaterThan(String value) {
            addCriterion("pay_pwd >", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_pwd >=", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdLessThan(String value) {
            addCriterion("pay_pwd <", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdLessThanOrEqualTo(String value) {
            addCriterion("pay_pwd <=", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdLike(String value) {
            addCriterion("pay_pwd like", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotLike(String value) {
            addCriterion("pay_pwd not like", value, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdIn(List<String> values) {
            addCriterion("pay_pwd in", values, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotIn(List<String> values) {
            addCriterion("pay_pwd not in", values, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdBetween(String value1, String value2) {
            addCriterion("pay_pwd between", value1, value2, "payPwd");
            return (Criteria) this;
        }

        public Criteria andPayPwdNotBetween(String value1, String value2) {
            addCriterion("pay_pwd not between", value1, value2, "payPwd");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "RealName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "RealName");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIsNull() {
            addCriterion("register_ip is null");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIsNotNull() {
            addCriterion("register_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterIpEqualTo(String value) {
            addCriterion("register_ip =", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotEqualTo(String value) {
            addCriterion("register_ip <>", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpGreaterThan(String value) {
            addCriterion("register_ip >", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpGreaterThanOrEqualTo(String value) {
            addCriterion("register_ip >=", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLessThan(String value) {
            addCriterion("register_ip <", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLessThanOrEqualTo(String value) {
            addCriterion("register_ip <=", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpLike(String value) {
            addCriterion("register_ip like", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotLike(String value) {
            addCriterion("register_ip not like", value, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpIn(List<String> values) {
            addCriterion("register_ip in", values, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotIn(List<String> values) {
            addCriterion("register_ip not in", values, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpBetween(String value1, String value2) {
            addCriterion("register_ip between", value1, value2, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterIpNotBetween(String value1, String value2) {
            addCriterion("register_ip not between", value1, value2, "registerIp");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(String value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(String value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(String value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(String value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(String value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(String value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLike(String value) {
            addCriterion("register_time like", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotLike(String value) {
            addCriterion("register_time not like", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<String> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<String> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(String value1, String value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(String value1, String value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andRealCardPathIsNull() {
            addCriterion("real_card_path is null");
            return (Criteria) this;
        }

        public Criteria andRealCardPathIsNotNull() {
            addCriterion("real_card_path is not null");
            return (Criteria) this;
        }

        public Criteria andRealCardPathEqualTo(String value) {
            addCriterion("real_card_path =", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathNotEqualTo(String value) {
            addCriterion("real_card_path <>", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathGreaterThan(String value) {
            addCriterion("real_card_path >", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathGreaterThanOrEqualTo(String value) {
            addCriterion("real_card_path >=", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathLessThan(String value) {
            addCriterion("real_card_path <", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathLessThanOrEqualTo(String value) {
            addCriterion("real_card_path <=", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathLike(String value) {
            addCriterion("real_card_path like", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathNotLike(String value) {
            addCriterion("real_card_path not like", value, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathIn(List<String> values) {
            addCriterion("real_card_path in", values, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathNotIn(List<String> values) {
            addCriterion("real_card_path not in", values, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathBetween(String value1, String value2) {
            addCriterion("real_card_path between", value1, value2, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andRealCardPathNotBetween(String value1, String value2) {
            addCriterion("real_card_path not between", value1, value2, "realCardPath");
            return (Criteria) this;
        }

        public Criteria andLevelTimeIsNull() {
            addCriterion("level_time is null");
            return (Criteria) this;
        }

        public Criteria andLevelTimeIsNotNull() {
            addCriterion("level_time is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTimeEqualTo(String value) {
            addCriterion("level_time =", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeNotEqualTo(String value) {
            addCriterion("level_time <>", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeGreaterThan(String value) {
            addCriterion("level_time >", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("level_time >=", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeLessThan(String value) {
            addCriterion("level_time <", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeLessThanOrEqualTo(String value) {
            addCriterion("level_time <=", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeLike(String value) {
            addCriterion("level_time like", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeNotLike(String value) {
            addCriterion("level_time not like", value, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeIn(List<String> values) {
            addCriterion("level_time in", values, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeNotIn(List<String> values) {
            addCriterion("level_time not in", values, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeBetween(String value1, String value2) {
            addCriterion("level_time between", value1, value2, "levelTime");
            return (Criteria) this;
        }

        public Criteria andLevelTimeNotBetween(String value1, String value2) {
            addCriterion("level_time not between", value1, value2, "levelTime");
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