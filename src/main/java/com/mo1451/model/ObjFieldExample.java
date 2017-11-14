package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class ObjFieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjFieldExample() {
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

        public Criteria andNode1IsNull() {
            addCriterion("node1 is null");
            return (Criteria) this;
        }

        public Criteria andNode1IsNotNull() {
            addCriterion("node1 is not null");
            return (Criteria) this;
        }

        public Criteria andNode1EqualTo(String value) {
            addCriterion("node1 =", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotEqualTo(String value) {
            addCriterion("node1 <>", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1GreaterThan(String value) {
            addCriterion("node1 >", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1GreaterThanOrEqualTo(String value) {
            addCriterion("node1 >=", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1LessThan(String value) {
            addCriterion("node1 <", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1LessThanOrEqualTo(String value) {
            addCriterion("node1 <=", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1Like(String value) {
            addCriterion("node1 like", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotLike(String value) {
            addCriterion("node1 not like", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1In(List<String> values) {
            addCriterion("node1 in", values, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotIn(List<String> values) {
            addCriterion("node1 not in", values, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1Between(String value1, String value2) {
            addCriterion("node1 between", value1, value2, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotBetween(String value1, String value2) {
            addCriterion("node1 not between", value1, value2, "node1");
            return (Criteria) this;
        }

        public Criteria andNode2IsNull() {
            addCriterion("node2 is null");
            return (Criteria) this;
        }

        public Criteria andNode2IsNotNull() {
            addCriterion("node2 is not null");
            return (Criteria) this;
        }

        public Criteria andNode2EqualTo(String value) {
            addCriterion("node2 =", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotEqualTo(String value) {
            addCriterion("node2 <>", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2GreaterThan(String value) {
            addCriterion("node2 >", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2GreaterThanOrEqualTo(String value) {
            addCriterion("node2 >=", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2LessThan(String value) {
            addCriterion("node2 <", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2LessThanOrEqualTo(String value) {
            addCriterion("node2 <=", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2Like(String value) {
            addCriterion("node2 like", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotLike(String value) {
            addCriterion("node2 not like", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2In(List<String> values) {
            addCriterion("node2 in", values, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotIn(List<String> values) {
            addCriterion("node2 not in", values, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2Between(String value1, String value2) {
            addCriterion("node2 between", value1, value2, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotBetween(String value1, String value2) {
            addCriterion("node2 not between", value1, value2, "node2");
            return (Criteria) this;
        }

        public Criteria andNode3IsNull() {
            addCriterion("node3 is null");
            return (Criteria) this;
        }

        public Criteria andNode3IsNotNull() {
            addCriterion("node3 is not null");
            return (Criteria) this;
        }

        public Criteria andNode3EqualTo(String value) {
            addCriterion("node3 =", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotEqualTo(String value) {
            addCriterion("node3 <>", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3GreaterThan(String value) {
            addCriterion("node3 >", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3GreaterThanOrEqualTo(String value) {
            addCriterion("node3 >=", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3LessThan(String value) {
            addCriterion("node3 <", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3LessThanOrEqualTo(String value) {
            addCriterion("node3 <=", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3Like(String value) {
            addCriterion("node3 like", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotLike(String value) {
            addCriterion("node3 not like", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3In(List<String> values) {
            addCriterion("node3 in", values, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotIn(List<String> values) {
            addCriterion("node3 not in", values, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3Between(String value1, String value2) {
            addCriterion("node3 between", value1, value2, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotBetween(String value1, String value2) {
            addCriterion("node3 not between", value1, value2, "node3");
            return (Criteria) this;
        }

        public Criteria andNode4IsNull() {
            addCriterion("node4 is null");
            return (Criteria) this;
        }

        public Criteria andNode4IsNotNull() {
            addCriterion("node4 is not null");
            return (Criteria) this;
        }

        public Criteria andNode4EqualTo(String value) {
            addCriterion("node4 =", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotEqualTo(String value) {
            addCriterion("node4 <>", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4GreaterThan(String value) {
            addCriterion("node4 >", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4GreaterThanOrEqualTo(String value) {
            addCriterion("node4 >=", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4LessThan(String value) {
            addCriterion("node4 <", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4LessThanOrEqualTo(String value) {
            addCriterion("node4 <=", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4Like(String value) {
            addCriterion("node4 like", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotLike(String value) {
            addCriterion("node4 not like", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4In(List<String> values) {
            addCriterion("node4 in", values, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotIn(List<String> values) {
            addCriterion("node4 not in", values, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4Between(String value1, String value2) {
            addCriterion("node4 between", value1, value2, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotBetween(String value1, String value2) {
            addCriterion("node4 not between", value1, value2, "node4");
            return (Criteria) this;
        }

        public Criteria andTxtIsNull() {
            addCriterion("txt is null");
            return (Criteria) this;
        }

        public Criteria andTxtIsNotNull() {
            addCriterion("txt is not null");
            return (Criteria) this;
        }

        public Criteria andTxtEqualTo(String value) {
            addCriterion("txt =", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtNotEqualTo(String value) {
            addCriterion("txt <>", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtGreaterThan(String value) {
            addCriterion("txt >", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtGreaterThanOrEqualTo(String value) {
            addCriterion("txt >=", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtLessThan(String value) {
            addCriterion("txt <", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtLessThanOrEqualTo(String value) {
            addCriterion("txt <=", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtLike(String value) {
            addCriterion("txt like", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtNotLike(String value) {
            addCriterion("txt not like", value, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtIn(List<String> values) {
            addCriterion("txt in", values, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtNotIn(List<String> values) {
            addCriterion("txt not in", values, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtBetween(String value1, String value2) {
            addCriterion("txt between", value1, value2, "txt");
            return (Criteria) this;
        }

        public Criteria andTxtNotBetween(String value1, String value2) {
            addCriterion("txt not between", value1, value2, "txt");
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