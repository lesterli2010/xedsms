package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Example;
import java.util.ArrayList;
import java.util.List;

public class ProvinceExample extends Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProvinceExample() {
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

        public Criteria andProvIdIsNull() {
            addCriterion("prov_id is null");
            return (Criteria) this;
        }

        public Criteria andProvIdIsNotNull() {
            addCriterion("prov_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvIdEqualTo(Integer value) {
            addCriterion("prov_id =", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdNotEqualTo(Integer value) {
            addCriterion("prov_id <>", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdGreaterThan(Integer value) {
            addCriterion("prov_id >", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prov_id >=", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdLessThan(Integer value) {
            addCriterion("prov_id <", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdLessThanOrEqualTo(Integer value) {
            addCriterion("prov_id <=", value, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdIn(List<Integer> values) {
            addCriterion("prov_id in", values, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdNotIn(List<Integer> values) {
            addCriterion("prov_id not in", values, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdBetween(Integer value1, Integer value2) {
            addCriterion("prov_id between", value1, value2, "provId");
            return (Criteria) this;
        }

        public Criteria andProvIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prov_id not between", value1, value2, "provId");
            return (Criteria) this;
        }

        public Criteria andProvNameIsNull() {
            addCriterion("prov_name is null");
            return (Criteria) this;
        }

        public Criteria andProvNameIsNotNull() {
            addCriterion("prov_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvNameEqualTo(String value) {
            addCriterion("prov_name =", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotEqualTo(String value) {
            addCriterion("prov_name <>", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameGreaterThan(String value) {
            addCriterion("prov_name >", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameGreaterThanOrEqualTo(String value) {
            addCriterion("prov_name >=", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameLessThan(String value) {
            addCriterion("prov_name <", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameLessThanOrEqualTo(String value) {
            addCriterion("prov_name <=", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameLike(String value) {
            addCriterion("prov_name like", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotLike(String value) {
            addCriterion("prov_name not like", value, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameIn(List<String> values) {
            addCriterion("prov_name in", values, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotIn(List<String> values) {
            addCriterion("prov_name not in", values, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameBetween(String value1, String value2) {
            addCriterion("prov_name between", value1, value2, "provName");
            return (Criteria) this;
        }

        public Criteria andProvNameNotBetween(String value1, String value2) {
            addCriterion("prov_name not between", value1, value2, "provName");
            return (Criteria) this;
        }

        public Criteria andProvPyIsNull() {
            addCriterion("prov_py is null");
            return (Criteria) this;
        }

        public Criteria andProvPyIsNotNull() {
            addCriterion("prov_py is not null");
            return (Criteria) this;
        }

        public Criteria andProvPyEqualTo(String value) {
            addCriterion("prov_py =", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyNotEqualTo(String value) {
            addCriterion("prov_py <>", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyGreaterThan(String value) {
            addCriterion("prov_py >", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyGreaterThanOrEqualTo(String value) {
            addCriterion("prov_py >=", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyLessThan(String value) {
            addCriterion("prov_py <", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyLessThanOrEqualTo(String value) {
            addCriterion("prov_py <=", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyLike(String value) {
            addCriterion("prov_py like", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyNotLike(String value) {
            addCriterion("prov_py not like", value, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyIn(List<String> values) {
            addCriterion("prov_py in", values, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyNotIn(List<String> values) {
            addCriterion("prov_py not in", values, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyBetween(String value1, String value2) {
            addCriterion("prov_py between", value1, value2, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvPyNotBetween(String value1, String value2) {
            addCriterion("prov_py not between", value1, value2, "provPy");
            return (Criteria) this;
        }

        public Criteria andProvZmIsNull() {
            addCriterion("prov_zm is null");
            return (Criteria) this;
        }

        public Criteria andProvZmIsNotNull() {
            addCriterion("prov_zm is not null");
            return (Criteria) this;
        }

        public Criteria andProvZmEqualTo(String value) {
            addCriterion("prov_zm =", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmNotEqualTo(String value) {
            addCriterion("prov_zm <>", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmGreaterThan(String value) {
            addCriterion("prov_zm >", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmGreaterThanOrEqualTo(String value) {
            addCriterion("prov_zm >=", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmLessThan(String value) {
            addCriterion("prov_zm <", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmLessThanOrEqualTo(String value) {
            addCriterion("prov_zm <=", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmLike(String value) {
            addCriterion("prov_zm like", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmNotLike(String value) {
            addCriterion("prov_zm not like", value, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmIn(List<String> values) {
            addCriterion("prov_zm in", values, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmNotIn(List<String> values) {
            addCriterion("prov_zm not in", values, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmBetween(String value1, String value2) {
            addCriterion("prov_zm between", value1, value2, "provZm");
            return (Criteria) this;
        }

        public Criteria andProvZmNotBetween(String value1, String value2) {
            addCriterion("prov_zm not between", value1, value2, "provZm");
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