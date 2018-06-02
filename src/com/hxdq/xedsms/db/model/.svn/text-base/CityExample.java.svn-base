package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Example;
import java.util.ArrayList;
import java.util.List;

public class CityExample extends Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityExample() {
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

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityZcodeIsNull() {
            addCriterion("city_zcode is null");
            return (Criteria) this;
        }

        public Criteria andCityZcodeIsNotNull() {
            addCriterion("city_zcode is not null");
            return (Criteria) this;
        }

        public Criteria andCityZcodeEqualTo(String value) {
            addCriterion("city_zcode =", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeNotEqualTo(String value) {
            addCriterion("city_zcode <>", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeGreaterThan(String value) {
            addCriterion("city_zcode >", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_zcode >=", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeLessThan(String value) {
            addCriterion("city_zcode <", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeLessThanOrEqualTo(String value) {
            addCriterion("city_zcode <=", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeLike(String value) {
            addCriterion("city_zcode like", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeNotLike(String value) {
            addCriterion("city_zcode not like", value, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeIn(List<String> values) {
            addCriterion("city_zcode in", values, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeNotIn(List<String> values) {
            addCriterion("city_zcode not in", values, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeBetween(String value1, String value2) {
            addCriterion("city_zcode between", value1, value2, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityZcodeNotBetween(String value1, String value2) {
            addCriterion("city_zcode not between", value1, value2, "cityZcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeIsNull() {
            addCriterion("city_pcode is null");
            return (Criteria) this;
        }

        public Criteria andCityPcodeIsNotNull() {
            addCriterion("city_pcode is not null");
            return (Criteria) this;
        }

        public Criteria andCityPcodeEqualTo(String value) {
            addCriterion("city_pcode =", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeNotEqualTo(String value) {
            addCriterion("city_pcode <>", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeGreaterThan(String value) {
            addCriterion("city_pcode >", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_pcode >=", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeLessThan(String value) {
            addCriterion("city_pcode <", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeLessThanOrEqualTo(String value) {
            addCriterion("city_pcode <=", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeLike(String value) {
            addCriterion("city_pcode like", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeNotLike(String value) {
            addCriterion("city_pcode not like", value, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeIn(List<String> values) {
            addCriterion("city_pcode in", values, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeNotIn(List<String> values) {
            addCriterion("city_pcode not in", values, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeBetween(String value1, String value2) {
            addCriterion("city_pcode between", value1, value2, "cityPcode");
            return (Criteria) this;
        }

        public Criteria andCityPcodeNotBetween(String value1, String value2) {
            addCriterion("city_pcode not between", value1, value2, "cityPcode");
            return (Criteria) this;
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

        public Criteria andCityPyIsNull() {
            addCriterion("city_py is null");
            return (Criteria) this;
        }

        public Criteria andCityPyIsNotNull() {
            addCriterion("city_py is not null");
            return (Criteria) this;
        }

        public Criteria andCityPyEqualTo(String value) {
            addCriterion("city_py =", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotEqualTo(String value) {
            addCriterion("city_py <>", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyGreaterThan(String value) {
            addCriterion("city_py >", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyGreaterThanOrEqualTo(String value) {
            addCriterion("city_py >=", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyLessThan(String value) {
            addCriterion("city_py <", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyLessThanOrEqualTo(String value) {
            addCriterion("city_py <=", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyLike(String value) {
            addCriterion("city_py like", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotLike(String value) {
            addCriterion("city_py not like", value, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyIn(List<String> values) {
            addCriterion("city_py in", values, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotIn(List<String> values) {
            addCriterion("city_py not in", values, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyBetween(String value1, String value2) {
            addCriterion("city_py between", value1, value2, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityPyNotBetween(String value1, String value2) {
            addCriterion("city_py not between", value1, value2, "cityPy");
            return (Criteria) this;
        }

        public Criteria andCityZmIsNull() {
            addCriterion("city_zm is null");
            return (Criteria) this;
        }

        public Criteria andCityZmIsNotNull() {
            addCriterion("city_zm is not null");
            return (Criteria) this;
        }

        public Criteria andCityZmEqualTo(String value) {
            addCriterion("city_zm =", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmNotEqualTo(String value) {
            addCriterion("city_zm <>", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmGreaterThan(String value) {
            addCriterion("city_zm >", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmGreaterThanOrEqualTo(String value) {
            addCriterion("city_zm >=", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmLessThan(String value) {
            addCriterion("city_zm <", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmLessThanOrEqualTo(String value) {
            addCriterion("city_zm <=", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmLike(String value) {
            addCriterion("city_zm like", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmNotLike(String value) {
            addCriterion("city_zm not like", value, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmIn(List<String> values) {
            addCriterion("city_zm in", values, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmNotIn(List<String> values) {
            addCriterion("city_zm not in", values, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmBetween(String value1, String value2) {
            addCriterion("city_zm between", value1, value2, "cityZm");
            return (Criteria) this;
        }

        public Criteria andCityZmNotBetween(String value1, String value2) {
            addCriterion("city_zm not between", value1, value2, "cityZm");
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