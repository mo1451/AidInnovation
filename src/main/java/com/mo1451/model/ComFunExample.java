package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class ComFunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComFunExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPrenameIsNull() {
            addCriterion("prename is null");
            return (Criteria) this;
        }

        public Criteria andPrenameIsNotNull() {
            addCriterion("prename is not null");
            return (Criteria) this;
        }

        public Criteria andPrenameEqualTo(String value) {
            addCriterion("prename =", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameNotEqualTo(String value) {
            addCriterion("prename <>", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameGreaterThan(String value) {
            addCriterion("prename >", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameGreaterThanOrEqualTo(String value) {
            addCriterion("prename >=", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameLessThan(String value) {
            addCriterion("prename <", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameLessThanOrEqualTo(String value) {
            addCriterion("prename <=", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameLike(String value) {
            addCriterion("prename like", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameNotLike(String value) {
            addCriterion("prename not like", value, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameIn(List<String> values) {
            addCriterion("prename in", values, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameNotIn(List<String> values) {
            addCriterion("prename not in", values, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameBetween(String value1, String value2) {
            addCriterion("prename between", value1, value2, "prename");
            return (Criteria) this;
        }

        public Criteria andPrenameNotBetween(String value1, String value2) {
            addCriterion("prename not between", value1, value2, "prename");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNull() {
            addCriterion("function is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNotNull() {
            addCriterion("function is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionEqualTo(String value) {
            addCriterion("function =", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotEqualTo(String value) {
            addCriterion("function <>", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThan(String value) {
            addCriterion("function >", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("function >=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThan(String value) {
            addCriterion("function <", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThanOrEqualTo(String value) {
            addCriterion("function <=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLike(String value) {
            addCriterion("function like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotLike(String value) {
            addCriterion("function not like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionIn(List<String> values) {
            addCriterion("function in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotIn(List<String> values) {
            addCriterion("function not in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionBetween(String value1, String value2) {
            addCriterion("function between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotBetween(String value1, String value2) {
            addCriterion("function not between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andAfternameIsNull() {
            addCriterion("aftername is null");
            return (Criteria) this;
        }

        public Criteria andAfternameIsNotNull() {
            addCriterion("aftername is not null");
            return (Criteria) this;
        }

        public Criteria andAfternameEqualTo(String value) {
            addCriterion("aftername =", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameNotEqualTo(String value) {
            addCriterion("aftername <>", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameGreaterThan(String value) {
            addCriterion("aftername >", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameGreaterThanOrEqualTo(String value) {
            addCriterion("aftername >=", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameLessThan(String value) {
            addCriterion("aftername <", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameLessThanOrEqualTo(String value) {
            addCriterion("aftername <=", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameLike(String value) {
            addCriterion("aftername like", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameNotLike(String value) {
            addCriterion("aftername not like", value, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameIn(List<String> values) {
            addCriterion("aftername in", values, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameNotIn(List<String> values) {
            addCriterion("aftername not in", values, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameBetween(String value1, String value2) {
            addCriterion("aftername between", value1, value2, "aftername");
            return (Criteria) this;
        }

        public Criteria andAfternameNotBetween(String value1, String value2) {
            addCriterion("aftername not between", value1, value2, "aftername");
            return (Criteria) this;
        }

        public Criteria andParaIsNull() {
            addCriterion("para is null");
            return (Criteria) this;
        }

        public Criteria andParaIsNotNull() {
            addCriterion("para is not null");
            return (Criteria) this;
        }

        public Criteria andParaEqualTo(String value) {
            addCriterion("para =", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotEqualTo(String value) {
            addCriterion("para <>", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaGreaterThan(String value) {
            addCriterion("para >", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaGreaterThanOrEqualTo(String value) {
            addCriterion("para >=", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLessThan(String value) {
            addCriterion("para <", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLessThanOrEqualTo(String value) {
            addCriterion("para <=", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaLike(String value) {
            addCriterion("para like", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotLike(String value) {
            addCriterion("para not like", value, "para");
            return (Criteria) this;
        }

        public Criteria andParaIn(List<String> values) {
            addCriterion("para in", values, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotIn(List<String> values) {
            addCriterion("para not in", values, "para");
            return (Criteria) this;
        }

        public Criteria andParaBetween(String value1, String value2) {
            addCriterion("para between", value1, value2, "para");
            return (Criteria) this;
        }

        public Criteria andParaNotBetween(String value1, String value2) {
            addCriterion("para not between", value1, value2, "para");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andWordidIsNull() {
            addCriterion("wordid is null");
            return (Criteria) this;
        }

        public Criteria andWordidIsNotNull() {
            addCriterion("wordid is not null");
            return (Criteria) this;
        }

        public Criteria andWordidEqualTo(Integer value) {
            addCriterion("wordid =", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidNotEqualTo(Integer value) {
            addCriterion("wordid <>", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidGreaterThan(Integer value) {
            addCriterion("wordid >", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wordid >=", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidLessThan(Integer value) {
            addCriterion("wordid <", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidLessThanOrEqualTo(Integer value) {
            addCriterion("wordid <=", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidIn(List<Integer> values) {
            addCriterion("wordid in", values, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidNotIn(List<Integer> values) {
            addCriterion("wordid not in", values, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidBetween(Integer value1, Integer value2) {
            addCriterion("wordid between", value1, value2, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidNotBetween(Integer value1, Integer value2) {
            addCriterion("wordid not between", value1, value2, "wordid");
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