package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Example;
import java.util.ArrayList;
import java.util.List;

public class UsageinfoExample extends Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsageinfoExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andUsageIdIsNull() {
            addCriterion("usage_id is null");
            return (Criteria) this;
        }

        public Criteria andUsageIdIsNotNull() {
            addCriterion("usage_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsageIdEqualTo(Integer value) {
            addCriterion("usage_id =", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotEqualTo(Integer value) {
            addCriterion("usage_id <>", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdGreaterThan(Integer value) {
            addCriterion("usage_id >", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("usage_id >=", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdLessThan(Integer value) {
            addCriterion("usage_id <", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdLessThanOrEqualTo(Integer value) {
            addCriterion("usage_id <=", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdIn(List<Integer> values) {
            addCriterion("usage_id in", values, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotIn(List<Integer> values) {
            addCriterion("usage_id not in", values, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdBetween(Integer value1, Integer value2) {
            addCriterion("usage_id between", value1, value2, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("usage_id not between", value1, value2, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageNameIsNull() {
            addCriterion("usage_name is null");
            return (Criteria) this;
        }

        public Criteria andUsageNameIsNotNull() {
            addCriterion("usage_name is not null");
            return (Criteria) this;
        }

        public Criteria andUsageNameEqualTo(String value) {
            addCriterion("usage_name =", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameNotEqualTo(String value) {
            addCriterion("usage_name <>", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameGreaterThan(String value) {
            addCriterion("usage_name >", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameGreaterThanOrEqualTo(String value) {
            addCriterion("usage_name >=", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameLessThan(String value) {
            addCriterion("usage_name <", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameLessThanOrEqualTo(String value) {
            addCriterion("usage_name <=", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameLike(String value) {
            addCriterion("usage_name like", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameNotLike(String value) {
            addCriterion("usage_name not like", value, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameIn(List<String> values) {
            addCriterion("usage_name in", values, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameNotIn(List<String> values) {
            addCriterion("usage_name not in", values, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameBetween(String value1, String value2) {
            addCriterion("usage_name between", value1, value2, "usageName");
            return (Criteria) this;
        }

        public Criteria andUsageNameNotBetween(String value1, String value2) {
            addCriterion("usage_name not between", value1, value2, "usageName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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