package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class PhysicalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhysicalExample() {
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

        public Criteria andTxt1IsNull() {
            addCriterion("txt1 is null");
            return (Criteria) this;
        }

        public Criteria andTxt1IsNotNull() {
            addCriterion("txt1 is not null");
            return (Criteria) this;
        }

        public Criteria andTxt1EqualTo(String value) {
            addCriterion("txt1 =", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1NotEqualTo(String value) {
            addCriterion("txt1 <>", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1GreaterThan(String value) {
            addCriterion("txt1 >", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1GreaterThanOrEqualTo(String value) {
            addCriterion("txt1 >=", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1LessThan(String value) {
            addCriterion("txt1 <", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1LessThanOrEqualTo(String value) {
            addCriterion("txt1 <=", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1Like(String value) {
            addCriterion("txt1 like", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1NotLike(String value) {
            addCriterion("txt1 not like", value, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1In(List<String> values) {
            addCriterion("txt1 in", values, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1NotIn(List<String> values) {
            addCriterion("txt1 not in", values, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1Between(String value1, String value2) {
            addCriterion("txt1 between", value1, value2, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt1NotBetween(String value1, String value2) {
            addCriterion("txt1 not between", value1, value2, "txt1");
            return (Criteria) this;
        }

        public Criteria andTxt2IsNull() {
            addCriterion("txt2 is null");
            return (Criteria) this;
        }

        public Criteria andTxt2IsNotNull() {
            addCriterion("txt2 is not null");
            return (Criteria) this;
        }

        public Criteria andTxt2EqualTo(String value) {
            addCriterion("txt2 =", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2NotEqualTo(String value) {
            addCriterion("txt2 <>", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2GreaterThan(String value) {
            addCriterion("txt2 >", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2GreaterThanOrEqualTo(String value) {
            addCriterion("txt2 >=", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2LessThan(String value) {
            addCriterion("txt2 <", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2LessThanOrEqualTo(String value) {
            addCriterion("txt2 <=", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2Like(String value) {
            addCriterion("txt2 like", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2NotLike(String value) {
            addCriterion("txt2 not like", value, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2In(List<String> values) {
            addCriterion("txt2 in", values, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2NotIn(List<String> values) {
            addCriterion("txt2 not in", values, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2Between(String value1, String value2) {
            addCriterion("txt2 between", value1, value2, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt2NotBetween(String value1, String value2) {
            addCriterion("txt2 not between", value1, value2, "txt2");
            return (Criteria) this;
        }

        public Criteria andTxt3IsNull() {
            addCriterion("txt3 is null");
            return (Criteria) this;
        }

        public Criteria andTxt3IsNotNull() {
            addCriterion("txt3 is not null");
            return (Criteria) this;
        }

        public Criteria andTxt3EqualTo(String value) {
            addCriterion("txt3 =", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3NotEqualTo(String value) {
            addCriterion("txt3 <>", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3GreaterThan(String value) {
            addCriterion("txt3 >", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3GreaterThanOrEqualTo(String value) {
            addCriterion("txt3 >=", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3LessThan(String value) {
            addCriterion("txt3 <", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3LessThanOrEqualTo(String value) {
            addCriterion("txt3 <=", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3Like(String value) {
            addCriterion("txt3 like", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3NotLike(String value) {
            addCriterion("txt3 not like", value, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3In(List<String> values) {
            addCriterion("txt3 in", values, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3NotIn(List<String> values) {
            addCriterion("txt3 not in", values, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3Between(String value1, String value2) {
            addCriterion("txt3 between", value1, value2, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt3NotBetween(String value1, String value2) {
            addCriterion("txt3 not between", value1, value2, "txt3");
            return (Criteria) this;
        }

        public Criteria andTxt4IsNull() {
            addCriterion("txt4 is null");
            return (Criteria) this;
        }

        public Criteria andTxt4IsNotNull() {
            addCriterion("txt4 is not null");
            return (Criteria) this;
        }

        public Criteria andTxt4EqualTo(String value) {
            addCriterion("txt4 =", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4NotEqualTo(String value) {
            addCriterion("txt4 <>", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4GreaterThan(String value) {
            addCriterion("txt4 >", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4GreaterThanOrEqualTo(String value) {
            addCriterion("txt4 >=", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4LessThan(String value) {
            addCriterion("txt4 <", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4LessThanOrEqualTo(String value) {
            addCriterion("txt4 <=", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4Like(String value) {
            addCriterion("txt4 like", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4NotLike(String value) {
            addCriterion("txt4 not like", value, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4In(List<String> values) {
            addCriterion("txt4 in", values, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4NotIn(List<String> values) {
            addCriterion("txt4 not in", values, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4Between(String value1, String value2) {
            addCriterion("txt4 between", value1, value2, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt4NotBetween(String value1, String value2) {
            addCriterion("txt4 not between", value1, value2, "txt4");
            return (Criteria) this;
        }

        public Criteria andTxt5IsNull() {
            addCriterion("txt5 is null");
            return (Criteria) this;
        }

        public Criteria andTxt5IsNotNull() {
            addCriterion("txt5 is not null");
            return (Criteria) this;
        }

        public Criteria andTxt5EqualTo(String value) {
            addCriterion("txt5 =", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5NotEqualTo(String value) {
            addCriterion("txt5 <>", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5GreaterThan(String value) {
            addCriterion("txt5 >", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5GreaterThanOrEqualTo(String value) {
            addCriterion("txt5 >=", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5LessThan(String value) {
            addCriterion("txt5 <", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5LessThanOrEqualTo(String value) {
            addCriterion("txt5 <=", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5Like(String value) {
            addCriterion("txt5 like", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5NotLike(String value) {
            addCriterion("txt5 not like", value, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5In(List<String> values) {
            addCriterion("txt5 in", values, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5NotIn(List<String> values) {
            addCriterion("txt5 not in", values, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5Between(String value1, String value2) {
            addCriterion("txt5 between", value1, value2, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt5NotBetween(String value1, String value2) {
            addCriterion("txt5 not between", value1, value2, "txt5");
            return (Criteria) this;
        }

        public Criteria andTxt6IsNull() {
            addCriterion("txt6 is null");
            return (Criteria) this;
        }

        public Criteria andTxt6IsNotNull() {
            addCriterion("txt6 is not null");
            return (Criteria) this;
        }

        public Criteria andTxt6EqualTo(String value) {
            addCriterion("txt6 =", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6NotEqualTo(String value) {
            addCriterion("txt6 <>", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6GreaterThan(String value) {
            addCriterion("txt6 >", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6GreaterThanOrEqualTo(String value) {
            addCriterion("txt6 >=", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6LessThan(String value) {
            addCriterion("txt6 <", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6LessThanOrEqualTo(String value) {
            addCriterion("txt6 <=", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6Like(String value) {
            addCriterion("txt6 like", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6NotLike(String value) {
            addCriterion("txt6 not like", value, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6In(List<String> values) {
            addCriterion("txt6 in", values, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6NotIn(List<String> values) {
            addCriterion("txt6 not in", values, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6Between(String value1, String value2) {
            addCriterion("txt6 between", value1, value2, "txt6");
            return (Criteria) this;
        }

        public Criteria andTxt6NotBetween(String value1, String value2) {
            addCriterion("txt6 not between", value1, value2, "txt6");
            return (Criteria) this;
        }

        public Criteria andSpaceIsNull() {
            addCriterion("space is null");
            return (Criteria) this;
        }

        public Criteria andSpaceIsNotNull() {
            addCriterion("space is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceEqualTo(String value) {
            addCriterion("space =", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotEqualTo(String value) {
            addCriterion("space <>", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThan(String value) {
            addCriterion("space >", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("space >=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThan(String value) {
            addCriterion("space <", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThanOrEqualTo(String value) {
            addCriterion("space <=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLike(String value) {
            addCriterion("space like", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotLike(String value) {
            addCriterion("space not like", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceIn(List<String> values) {
            addCriterion("space in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotIn(List<String> values) {
            addCriterion("space not in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceBetween(String value1, String value2) {
            addCriterion("space between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotBetween(String value1, String value2) {
            addCriterion("space not between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andTimIsNull() {
            addCriterion("tim is null");
            return (Criteria) this;
        }

        public Criteria andTimIsNotNull() {
            addCriterion("tim is not null");
            return (Criteria) this;
        }

        public Criteria andTimEqualTo(String value) {
            addCriterion("tim =", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotEqualTo(String value) {
            addCriterion("tim <>", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimGreaterThan(String value) {
            addCriterion("tim >", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimGreaterThanOrEqualTo(String value) {
            addCriterion("tim >=", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimLessThan(String value) {
            addCriterion("tim <", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimLessThanOrEqualTo(String value) {
            addCriterion("tim <=", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimLike(String value) {
            addCriterion("tim like", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotLike(String value) {
            addCriterion("tim not like", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimIn(List<String> values) {
            addCriterion("tim in", values, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotIn(List<String> values) {
            addCriterion("tim not in", values, "tim");
            return (Criteria) this;
        }

        public Criteria andTimBetween(String value1, String value2) {
            addCriterion("tim between", value1, value2, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotBetween(String value1, String value2) {
            addCriterion("tim not between", value1, value2, "tim");
            return (Criteria) this;
        }

        public Criteria andCondIsNull() {
            addCriterion("cond is null");
            return (Criteria) this;
        }

        public Criteria andCondIsNotNull() {
            addCriterion("cond is not null");
            return (Criteria) this;
        }

        public Criteria andCondEqualTo(String value) {
            addCriterion("cond =", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondNotEqualTo(String value) {
            addCriterion("cond <>", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondGreaterThan(String value) {
            addCriterion("cond >", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondGreaterThanOrEqualTo(String value) {
            addCriterion("cond >=", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondLessThan(String value) {
            addCriterion("cond <", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondLessThanOrEqualTo(String value) {
            addCriterion("cond <=", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondLike(String value) {
            addCriterion("cond like", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondNotLike(String value) {
            addCriterion("cond not like", value, "cond");
            return (Criteria) this;
        }

        public Criteria andCondIn(List<String> values) {
            addCriterion("cond in", values, "cond");
            return (Criteria) this;
        }

        public Criteria andCondNotIn(List<String> values) {
            addCriterion("cond not in", values, "cond");
            return (Criteria) this;
        }

        public Criteria andCondBetween(String value1, String value2) {
            addCriterion("cond between", value1, value2, "cond");
            return (Criteria) this;
        }

        public Criteria andCondNotBetween(String value1, String value2) {
            addCriterion("cond not between", value1, value2, "cond");
            return (Criteria) this;
        }

        public Criteria andWholeIsNull() {
            addCriterion("whole is null");
            return (Criteria) this;
        }

        public Criteria andWholeIsNotNull() {
            addCriterion("whole is not null");
            return (Criteria) this;
        }

        public Criteria andWholeEqualTo(String value) {
            addCriterion("whole =", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeNotEqualTo(String value) {
            addCriterion("whole <>", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeGreaterThan(String value) {
            addCriterion("whole >", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeGreaterThanOrEqualTo(String value) {
            addCriterion("whole >=", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeLessThan(String value) {
            addCriterion("whole <", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeLessThanOrEqualTo(String value) {
            addCriterion("whole <=", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeLike(String value) {
            addCriterion("whole like", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeNotLike(String value) {
            addCriterion("whole not like", value, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeIn(List<String> values) {
            addCriterion("whole in", values, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeNotIn(List<String> values) {
            addCriterion("whole not in", values, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeBetween(String value1, String value2) {
            addCriterion("whole between", value1, value2, "whole");
            return (Criteria) this;
        }

        public Criteria andWholeNotBetween(String value1, String value2) {
            addCriterion("whole not between", value1, value2, "whole");
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