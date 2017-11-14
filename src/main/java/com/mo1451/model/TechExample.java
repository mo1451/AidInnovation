package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class TechExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TechExample() {
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

        public Criteria andA1IsNull() {
            addCriterion("a1 is null");
            return (Criteria) this;
        }

        public Criteria andA1IsNotNull() {
            addCriterion("a1 is not null");
            return (Criteria) this;
        }

        public Criteria andA1EqualTo(String value) {
            addCriterion("a1 =", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotEqualTo(String value) {
            addCriterion("a1 <>", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThan(String value) {
            addCriterion("a1 >", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1GreaterThanOrEqualTo(String value) {
            addCriterion("a1 >=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThan(String value) {
            addCriterion("a1 <", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1LessThanOrEqualTo(String value) {
            addCriterion("a1 <=", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1Like(String value) {
            addCriterion("a1 like", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotLike(String value) {
            addCriterion("a1 not like", value, "a1");
            return (Criteria) this;
        }

        public Criteria andA1In(List<String> values) {
            addCriterion("a1 in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotIn(List<String> values) {
            addCriterion("a1 not in", values, "a1");
            return (Criteria) this;
        }

        public Criteria andA1Between(String value1, String value2) {
            addCriterion("a1 between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA1NotBetween(String value1, String value2) {
            addCriterion("a1 not between", value1, value2, "a1");
            return (Criteria) this;
        }

        public Criteria andA2IsNull() {
            addCriterion("a2 is null");
            return (Criteria) this;
        }

        public Criteria andA2IsNotNull() {
            addCriterion("a2 is not null");
            return (Criteria) this;
        }

        public Criteria andA2EqualTo(String value) {
            addCriterion("a2 =", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotEqualTo(String value) {
            addCriterion("a2 <>", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThan(String value) {
            addCriterion("a2 >", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThanOrEqualTo(String value) {
            addCriterion("a2 >=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThan(String value) {
            addCriterion("a2 <", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThanOrEqualTo(String value) {
            addCriterion("a2 <=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Like(String value) {
            addCriterion("a2 like", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotLike(String value) {
            addCriterion("a2 not like", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2In(List<String> values) {
            addCriterion("a2 in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotIn(List<String> values) {
            addCriterion("a2 not in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Between(String value1, String value2) {
            addCriterion("a2 between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotBetween(String value1, String value2) {
            addCriterion("a2 not between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andB1IsNull() {
            addCriterion("b1 is null");
            return (Criteria) this;
        }

        public Criteria andB1IsNotNull() {
            addCriterion("b1 is not null");
            return (Criteria) this;
        }

        public Criteria andB1EqualTo(String value) {
            addCriterion("b1 =", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotEqualTo(String value) {
            addCriterion("b1 <>", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1GreaterThan(String value) {
            addCriterion("b1 >", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1GreaterThanOrEqualTo(String value) {
            addCriterion("b1 >=", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1LessThan(String value) {
            addCriterion("b1 <", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1LessThanOrEqualTo(String value) {
            addCriterion("b1 <=", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1Like(String value) {
            addCriterion("b1 like", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotLike(String value) {
            addCriterion("b1 not like", value, "b1");
            return (Criteria) this;
        }

        public Criteria andB1In(List<String> values) {
            addCriterion("b1 in", values, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotIn(List<String> values) {
            addCriterion("b1 not in", values, "b1");
            return (Criteria) this;
        }

        public Criteria andB1Between(String value1, String value2) {
            addCriterion("b1 between", value1, value2, "b1");
            return (Criteria) this;
        }

        public Criteria andB1NotBetween(String value1, String value2) {
            addCriterion("b1 not between", value1, value2, "b1");
            return (Criteria) this;
        }

        public Criteria andB2IsNull() {
            addCriterion("b2 is null");
            return (Criteria) this;
        }

        public Criteria andB2IsNotNull() {
            addCriterion("b2 is not null");
            return (Criteria) this;
        }

        public Criteria andB2EqualTo(String value) {
            addCriterion("b2 =", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotEqualTo(String value) {
            addCriterion("b2 <>", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2GreaterThan(String value) {
            addCriterion("b2 >", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2GreaterThanOrEqualTo(String value) {
            addCriterion("b2 >=", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2LessThan(String value) {
            addCriterion("b2 <", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2LessThanOrEqualTo(String value) {
            addCriterion("b2 <=", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2Like(String value) {
            addCriterion("b2 like", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotLike(String value) {
            addCriterion("b2 not like", value, "b2");
            return (Criteria) this;
        }

        public Criteria andB2In(List<String> values) {
            addCriterion("b2 in", values, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotIn(List<String> values) {
            addCriterion("b2 not in", values, "b2");
            return (Criteria) this;
        }

        public Criteria andB2Between(String value1, String value2) {
            addCriterion("b2 between", value1, value2, "b2");
            return (Criteria) this;
        }

        public Criteria andB2NotBetween(String value1, String value2) {
            addCriterion("b2 not between", value1, value2, "b2");
            return (Criteria) this;
        }

        public Criteria andC1IsNull() {
            addCriterion("c1 is null");
            return (Criteria) this;
        }

        public Criteria andC1IsNotNull() {
            addCriterion("c1 is not null");
            return (Criteria) this;
        }

        public Criteria andC1EqualTo(String value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(String value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(String value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(String value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(String value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(String value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Like(String value) {
            addCriterion("c1 like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotLike(String value) {
            addCriterion("c1 not like", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<String> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<String> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(String value1, String value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(String value1, String value2) {
            addCriterion("c1 not between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC2IsNull() {
            addCriterion("c2 is null");
            return (Criteria) this;
        }

        public Criteria andC2IsNotNull() {
            addCriterion("c2 is not null");
            return (Criteria) this;
        }

        public Criteria andC2EqualTo(String value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(String value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(String value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(String value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(String value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(String value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Like(String value) {
            addCriterion("c2 like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotLike(String value) {
            addCriterion("c2 not like", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<String> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<String> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(String value1, String value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(String value1, String value2) {
            addCriterion("c2 not between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andTechConIsNull() {
            addCriterion("tech_con is null");
            return (Criteria) this;
        }

        public Criteria andTechConIsNotNull() {
            addCriterion("tech_con is not null");
            return (Criteria) this;
        }

        public Criteria andTechConEqualTo(Integer value) {
            addCriterion("tech_con =", value, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConNotEqualTo(Integer value) {
            addCriterion("tech_con <>", value, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConGreaterThan(Integer value) {
            addCriterion("tech_con >", value, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConGreaterThanOrEqualTo(Integer value) {
            addCriterion("tech_con >=", value, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConLessThan(Integer value) {
            addCriterion("tech_con <", value, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConLessThanOrEqualTo(Integer value) {
            addCriterion("tech_con <=", value, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConIn(List<Integer> values) {
            addCriterion("tech_con in", values, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConNotIn(List<Integer> values) {
            addCriterion("tech_con not in", values, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConBetween(Integer value1, Integer value2) {
            addCriterion("tech_con between", value1, value2, "techCon");
            return (Criteria) this;
        }

        public Criteria andTechConNotBetween(Integer value1, Integer value2) {
            addCriterion("tech_con not between", value1, value2, "techCon");
            return (Criteria) this;
        }

        public Criteria andCom1IsNull() {
            addCriterion("com1 is null");
            return (Criteria) this;
        }

        public Criteria andCom1IsNotNull() {
            addCriterion("com1 is not null");
            return (Criteria) this;
        }

        public Criteria andCom1EqualTo(String value) {
            addCriterion("com1 =", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1NotEqualTo(String value) {
            addCriterion("com1 <>", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1GreaterThan(String value) {
            addCriterion("com1 >", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1GreaterThanOrEqualTo(String value) {
            addCriterion("com1 >=", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1LessThan(String value) {
            addCriterion("com1 <", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1LessThanOrEqualTo(String value) {
            addCriterion("com1 <=", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1Like(String value) {
            addCriterion("com1 like", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1NotLike(String value) {
            addCriterion("com1 not like", value, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1In(List<String> values) {
            addCriterion("com1 in", values, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1NotIn(List<String> values) {
            addCriterion("com1 not in", values, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1Between(String value1, String value2) {
            addCriterion("com1 between", value1, value2, "com1");
            return (Criteria) this;
        }

        public Criteria andCom1NotBetween(String value1, String value2) {
            addCriterion("com1 not between", value1, value2, "com1");
            return (Criteria) this;
        }

        public Criteria andCom2IsNull() {
            addCriterion("com2 is null");
            return (Criteria) this;
        }

        public Criteria andCom2IsNotNull() {
            addCriterion("com2 is not null");
            return (Criteria) this;
        }

        public Criteria andCom2EqualTo(String value) {
            addCriterion("com2 =", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2NotEqualTo(String value) {
            addCriterion("com2 <>", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2GreaterThan(String value) {
            addCriterion("com2 >", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2GreaterThanOrEqualTo(String value) {
            addCriterion("com2 >=", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2LessThan(String value) {
            addCriterion("com2 <", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2LessThanOrEqualTo(String value) {
            addCriterion("com2 <=", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2Like(String value) {
            addCriterion("com2 like", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2NotLike(String value) {
            addCriterion("com2 not like", value, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2In(List<String> values) {
            addCriterion("com2 in", values, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2NotIn(List<String> values) {
            addCriterion("com2 not in", values, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2Between(String value1, String value2) {
            addCriterion("com2 between", value1, value2, "com2");
            return (Criteria) this;
        }

        public Criteria andCom2NotBetween(String value1, String value2) {
            addCriterion("com2 not between", value1, value2, "com2");
            return (Criteria) this;
        }

        public Criteria andCom3IsNull() {
            addCriterion("com3 is null");
            return (Criteria) this;
        }

        public Criteria andCom3IsNotNull() {
            addCriterion("com3 is not null");
            return (Criteria) this;
        }

        public Criteria andCom3EqualTo(String value) {
            addCriterion("com3 =", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3NotEqualTo(String value) {
            addCriterion("com3 <>", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3GreaterThan(String value) {
            addCriterion("com3 >", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3GreaterThanOrEqualTo(String value) {
            addCriterion("com3 >=", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3LessThan(String value) {
            addCriterion("com3 <", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3LessThanOrEqualTo(String value) {
            addCriterion("com3 <=", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3Like(String value) {
            addCriterion("com3 like", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3NotLike(String value) {
            addCriterion("com3 not like", value, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3In(List<String> values) {
            addCriterion("com3 in", values, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3NotIn(List<String> values) {
            addCriterion("com3 not in", values, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3Between(String value1, String value2) {
            addCriterion("com3 between", value1, value2, "com3");
            return (Criteria) this;
        }

        public Criteria andCom3NotBetween(String value1, String value2) {
            addCriterion("com3 not between", value1, value2, "com3");
            return (Criteria) this;
        }

        public Criteria andImproveIsNull() {
            addCriterion("improve is null");
            return (Criteria) this;
        }

        public Criteria andImproveIsNotNull() {
            addCriterion("improve is not null");
            return (Criteria) this;
        }

        public Criteria andImproveEqualTo(Integer value) {
            addCriterion("improve =", value, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveNotEqualTo(Integer value) {
            addCriterion("improve <>", value, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveGreaterThan(Integer value) {
            addCriterion("improve >", value, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveGreaterThanOrEqualTo(Integer value) {
            addCriterion("improve >=", value, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveLessThan(Integer value) {
            addCriterion("improve <", value, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveLessThanOrEqualTo(Integer value) {
            addCriterion("improve <=", value, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveIn(List<Integer> values) {
            addCriterion("improve in", values, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveNotIn(List<Integer> values) {
            addCriterion("improve not in", values, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveBetween(Integer value1, Integer value2) {
            addCriterion("improve between", value1, value2, "improve");
            return (Criteria) this;
        }

        public Criteria andImproveNotBetween(Integer value1, Integer value2) {
            addCriterion("improve not between", value1, value2, "improve");
            return (Criteria) this;
        }

        public Criteria andWorseIsNull() {
            addCriterion("worse is null");
            return (Criteria) this;
        }

        public Criteria andWorseIsNotNull() {
            addCriterion("worse is not null");
            return (Criteria) this;
        }

        public Criteria andWorseEqualTo(Integer value) {
            addCriterion("worse =", value, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseNotEqualTo(Integer value) {
            addCriterion("worse <>", value, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseGreaterThan(Integer value) {
            addCriterion("worse >", value, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseGreaterThanOrEqualTo(Integer value) {
            addCriterion("worse >=", value, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseLessThan(Integer value) {
            addCriterion("worse <", value, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseLessThanOrEqualTo(Integer value) {
            addCriterion("worse <=", value, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseIn(List<Integer> values) {
            addCriterion("worse in", values, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseNotIn(List<Integer> values) {
            addCriterion("worse not in", values, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseBetween(Integer value1, Integer value2) {
            addCriterion("worse between", value1, value2, "worse");
            return (Criteria) this;
        }

        public Criteria andWorseNotBetween(Integer value1, Integer value2) {
            addCriterion("worse not between", value1, value2, "worse");
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