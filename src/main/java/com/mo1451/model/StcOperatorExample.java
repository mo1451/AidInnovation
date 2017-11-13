package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class StcOperatorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StcOperatorExample() {
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

        public Criteria andBigIsNull() {
            addCriterion("big is null");
            return (Criteria) this;
        }

        public Criteria andBigIsNotNull() {
            addCriterion("big is not null");
            return (Criteria) this;
        }

        public Criteria andBigEqualTo(String value) {
            addCriterion("big =", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotEqualTo(String value) {
            addCriterion("big <>", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThan(String value) {
            addCriterion("big >", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigGreaterThanOrEqualTo(String value) {
            addCriterion("big >=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThan(String value) {
            addCriterion("big <", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLessThanOrEqualTo(String value) {
            addCriterion("big <=", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigLike(String value) {
            addCriterion("big like", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotLike(String value) {
            addCriterion("big not like", value, "big");
            return (Criteria) this;
        }

        public Criteria andBigIn(List<String> values) {
            addCriterion("big in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotIn(List<String> values) {
            addCriterion("big not in", values, "big");
            return (Criteria) this;
        }

        public Criteria andBigBetween(String value1, String value2) {
            addCriterion("big between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andBigNotBetween(String value1, String value2) {
            addCriterion("big not between", value1, value2, "big");
            return (Criteria) this;
        }

        public Criteria andSmallIsNull() {
            addCriterion("small is null");
            return (Criteria) this;
        }

        public Criteria andSmallIsNotNull() {
            addCriterion("small is not null");
            return (Criteria) this;
        }

        public Criteria andSmallEqualTo(String value) {
            addCriterion("small =", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotEqualTo(String value) {
            addCriterion("small <>", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallGreaterThan(String value) {
            addCriterion("small >", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallGreaterThanOrEqualTo(String value) {
            addCriterion("small >=", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLessThan(String value) {
            addCriterion("small <", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLessThanOrEqualTo(String value) {
            addCriterion("small <=", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallLike(String value) {
            addCriterion("small like", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotLike(String value) {
            addCriterion("small not like", value, "small");
            return (Criteria) this;
        }

        public Criteria andSmallIn(List<String> values) {
            addCriterion("small in", values, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotIn(List<String> values) {
            addCriterion("small not in", values, "small");
            return (Criteria) this;
        }

        public Criteria andSmallBetween(String value1, String value2) {
            addCriterion("small between", value1, value2, "small");
            return (Criteria) this;
        }

        public Criteria andSmallNotBetween(String value1, String value2) {
            addCriterion("small not between", value1, value2, "small");
            return (Criteria) this;
        }

        public Criteria andShortTimeIsNull() {
            addCriterion("short_time is null");
            return (Criteria) this;
        }

        public Criteria andShortTimeIsNotNull() {
            addCriterion("short_time is not null");
            return (Criteria) this;
        }

        public Criteria andShortTimeEqualTo(String value) {
            addCriterion("short_time =", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeNotEqualTo(String value) {
            addCriterion("short_time <>", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeGreaterThan(String value) {
            addCriterion("short_time >", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeGreaterThanOrEqualTo(String value) {
            addCriterion("short_time >=", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeLessThan(String value) {
            addCriterion("short_time <", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeLessThanOrEqualTo(String value) {
            addCriterion("short_time <=", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeLike(String value) {
            addCriterion("short_time like", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeNotLike(String value) {
            addCriterion("short_time not like", value, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeIn(List<String> values) {
            addCriterion("short_time in", values, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeNotIn(List<String> values) {
            addCriterion("short_time not in", values, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeBetween(String value1, String value2) {
            addCriterion("short_time between", value1, value2, "shortTime");
            return (Criteria) this;
        }

        public Criteria andShortTimeNotBetween(String value1, String value2) {
            addCriterion("short_time not between", value1, value2, "shortTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeIsNull() {
            addCriterion("long_time is null");
            return (Criteria) this;
        }

        public Criteria andLongTimeIsNotNull() {
            addCriterion("long_time is not null");
            return (Criteria) this;
        }

        public Criteria andLongTimeEqualTo(String value) {
            addCriterion("long_time =", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeNotEqualTo(String value) {
            addCriterion("long_time <>", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeGreaterThan(String value) {
            addCriterion("long_time >", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeGreaterThanOrEqualTo(String value) {
            addCriterion("long_time >=", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeLessThan(String value) {
            addCriterion("long_time <", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeLessThanOrEqualTo(String value) {
            addCriterion("long_time <=", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeLike(String value) {
            addCriterion("long_time like", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeNotLike(String value) {
            addCriterion("long_time not like", value, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeIn(List<String> values) {
            addCriterion("long_time in", values, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeNotIn(List<String> values) {
            addCriterion("long_time not in", values, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeBetween(String value1, String value2) {
            addCriterion("long_time between", value1, value2, "longTime");
            return (Criteria) this;
        }

        public Criteria andLongTimeNotBetween(String value1, String value2) {
            addCriterion("long_time not between", value1, value2, "longTime");
            return (Criteria) this;
        }

        public Criteria andExpensiveIsNull() {
            addCriterion("expensive is null");
            return (Criteria) this;
        }

        public Criteria andExpensiveIsNotNull() {
            addCriterion("expensive is not null");
            return (Criteria) this;
        }

        public Criteria andExpensiveEqualTo(String value) {
            addCriterion("expensive =", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveNotEqualTo(String value) {
            addCriterion("expensive <>", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveGreaterThan(String value) {
            addCriterion("expensive >", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveGreaterThanOrEqualTo(String value) {
            addCriterion("expensive >=", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveLessThan(String value) {
            addCriterion("expensive <", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveLessThanOrEqualTo(String value) {
            addCriterion("expensive <=", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveLike(String value) {
            addCriterion("expensive like", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveNotLike(String value) {
            addCriterion("expensive not like", value, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveIn(List<String> values) {
            addCriterion("expensive in", values, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveNotIn(List<String> values) {
            addCriterion("expensive not in", values, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveBetween(String value1, String value2) {
            addCriterion("expensive between", value1, value2, "expensive");
            return (Criteria) this;
        }

        public Criteria andExpensiveNotBetween(String value1, String value2) {
            addCriterion("expensive not between", value1, value2, "expensive");
            return (Criteria) this;
        }

        public Criteria andChipIsNull() {
            addCriterion("chip is null");
            return (Criteria) this;
        }

        public Criteria andChipIsNotNull() {
            addCriterion("chip is not null");
            return (Criteria) this;
        }

        public Criteria andChipEqualTo(String value) {
            addCriterion("chip =", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotEqualTo(String value) {
            addCriterion("chip <>", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipGreaterThan(String value) {
            addCriterion("chip >", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipGreaterThanOrEqualTo(String value) {
            addCriterion("chip >=", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipLessThan(String value) {
            addCriterion("chip <", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipLessThanOrEqualTo(String value) {
            addCriterion("chip <=", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipLike(String value) {
            addCriterion("chip like", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotLike(String value) {
            addCriterion("chip not like", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipIn(List<String> values) {
            addCriterion("chip in", values, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotIn(List<String> values) {
            addCriterion("chip not in", values, "chip");
            return (Criteria) this;
        }

        public Criteria andChipBetween(String value1, String value2) {
            addCriterion("chip between", value1, value2, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotBetween(String value1, String value2) {
            addCriterion("chip not between", value1, value2, "chip");
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