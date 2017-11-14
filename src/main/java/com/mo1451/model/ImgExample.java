package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class ImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImgExample() {
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

        public Criteria andDescImgIsNull() {
            addCriterion("desc_img is null");
            return (Criteria) this;
        }

        public Criteria andDescImgIsNotNull() {
            addCriterion("desc_img is not null");
            return (Criteria) this;
        }

        public Criteria andDescImgEqualTo(String value) {
            addCriterion("desc_img =", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgNotEqualTo(String value) {
            addCriterion("desc_img <>", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgGreaterThan(String value) {
            addCriterion("desc_img >", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgGreaterThanOrEqualTo(String value) {
            addCriterion("desc_img >=", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgLessThan(String value) {
            addCriterion("desc_img <", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgLessThanOrEqualTo(String value) {
            addCriterion("desc_img <=", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgLike(String value) {
            addCriterion("desc_img like", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgNotLike(String value) {
            addCriterion("desc_img not like", value, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgIn(List<String> values) {
            addCriterion("desc_img in", values, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgNotIn(List<String> values) {
            addCriterion("desc_img not in", values, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgBetween(String value1, String value2) {
            addCriterion("desc_img between", value1, value2, "descImg");
            return (Criteria) this;
        }

        public Criteria andDescImgNotBetween(String value1, String value2) {
            addCriterion("desc_img not between", value1, value2, "descImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgIsNull() {
            addCriterion("prin_img is null");
            return (Criteria) this;
        }

        public Criteria andPrinImgIsNotNull() {
            addCriterion("prin_img is not null");
            return (Criteria) this;
        }

        public Criteria andPrinImgEqualTo(String value) {
            addCriterion("prin_img =", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgNotEqualTo(String value) {
            addCriterion("prin_img <>", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgGreaterThan(String value) {
            addCriterion("prin_img >", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgGreaterThanOrEqualTo(String value) {
            addCriterion("prin_img >=", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgLessThan(String value) {
            addCriterion("prin_img <", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgLessThanOrEqualTo(String value) {
            addCriterion("prin_img <=", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgLike(String value) {
            addCriterion("prin_img like", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgNotLike(String value) {
            addCriterion("prin_img not like", value, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgIn(List<String> values) {
            addCriterion("prin_img in", values, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgNotIn(List<String> values) {
            addCriterion("prin_img not in", values, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgBetween(String value1, String value2) {
            addCriterion("prin_img between", value1, value2, "prinImg");
            return (Criteria) this;
        }

        public Criteria andPrinImgNotBetween(String value1, String value2) {
            addCriterion("prin_img not between", value1, value2, "prinImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgIsNull() {
            addCriterion("caul_img is null");
            return (Criteria) this;
        }

        public Criteria andCaulImgIsNotNull() {
            addCriterion("caul_img is not null");
            return (Criteria) this;
        }

        public Criteria andCaulImgEqualTo(String value) {
            addCriterion("caul_img =", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgNotEqualTo(String value) {
            addCriterion("caul_img <>", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgGreaterThan(String value) {
            addCriterion("caul_img >", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgGreaterThanOrEqualTo(String value) {
            addCriterion("caul_img >=", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgLessThan(String value) {
            addCriterion("caul_img <", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgLessThanOrEqualTo(String value) {
            addCriterion("caul_img <=", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgLike(String value) {
            addCriterion("caul_img like", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgNotLike(String value) {
            addCriterion("caul_img not like", value, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgIn(List<String> values) {
            addCriterion("caul_img in", values, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgNotIn(List<String> values) {
            addCriterion("caul_img not in", values, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgBetween(String value1, String value2) {
            addCriterion("caul_img between", value1, value2, "caulImg");
            return (Criteria) this;
        }

        public Criteria andCaulImgNotBetween(String value1, String value2) {
            addCriterion("caul_img not between", value1, value2, "caulImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgIsNull() {
            addCriterion("life_img is null");
            return (Criteria) this;
        }

        public Criteria andLifeImgIsNotNull() {
            addCriterion("life_img is not null");
            return (Criteria) this;
        }

        public Criteria andLifeImgEqualTo(String value) {
            addCriterion("life_img =", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgNotEqualTo(String value) {
            addCriterion("life_img <>", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgGreaterThan(String value) {
            addCriterion("life_img >", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgGreaterThanOrEqualTo(String value) {
            addCriterion("life_img >=", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgLessThan(String value) {
            addCriterion("life_img <", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgLessThanOrEqualTo(String value) {
            addCriterion("life_img <=", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgLike(String value) {
            addCriterion("life_img like", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgNotLike(String value) {
            addCriterion("life_img not like", value, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgIn(List<String> values) {
            addCriterion("life_img in", values, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgNotIn(List<String> values) {
            addCriterion("life_img not in", values, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgBetween(String value1, String value2) {
            addCriterion("life_img between", value1, value2, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andLifeImgNotBetween(String value1, String value2) {
            addCriterion("life_img not between", value1, value2, "lifeImg");
            return (Criteria) this;
        }

        public Criteria andFunImgIsNull() {
            addCriterion("fun_img is null");
            return (Criteria) this;
        }

        public Criteria andFunImgIsNotNull() {
            addCriterion("fun_img is not null");
            return (Criteria) this;
        }

        public Criteria andFunImgEqualTo(String value) {
            addCriterion("fun_img =", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgNotEqualTo(String value) {
            addCriterion("fun_img <>", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgGreaterThan(String value) {
            addCriterion("fun_img >", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgGreaterThanOrEqualTo(String value) {
            addCriterion("fun_img >=", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgLessThan(String value) {
            addCriterion("fun_img <", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgLessThanOrEqualTo(String value) {
            addCriterion("fun_img <=", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgLike(String value) {
            addCriterion("fun_img like", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgNotLike(String value) {
            addCriterion("fun_img not like", value, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgIn(List<String> values) {
            addCriterion("fun_img in", values, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgNotIn(List<String> values) {
            addCriterion("fun_img not in", values, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgBetween(String value1, String value2) {
            addCriterion("fun_img between", value1, value2, "funImg");
            return (Criteria) this;
        }

        public Criteria andFunImgNotBetween(String value1, String value2) {
            addCriterion("fun_img not between", value1, value2, "funImg");
            return (Criteria) this;
        }

        public Criteria andObjectImg0IsNull() {
            addCriterion("object_img0 is null");
            return (Criteria) this;
        }

        public Criteria andObjectImg0IsNotNull() {
            addCriterion("object_img0 is not null");
            return (Criteria) this;
        }

        public Criteria andObjectImg0EqualTo(String value) {
            addCriterion("object_img0 =", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0NotEqualTo(String value) {
            addCriterion("object_img0 <>", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0GreaterThan(String value) {
            addCriterion("object_img0 >", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0GreaterThanOrEqualTo(String value) {
            addCriterion("object_img0 >=", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0LessThan(String value) {
            addCriterion("object_img0 <", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0LessThanOrEqualTo(String value) {
            addCriterion("object_img0 <=", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0Like(String value) {
            addCriterion("object_img0 like", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0NotLike(String value) {
            addCriterion("object_img0 not like", value, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0In(List<String> values) {
            addCriterion("object_img0 in", values, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0NotIn(List<String> values) {
            addCriterion("object_img0 not in", values, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0Between(String value1, String value2) {
            addCriterion("object_img0 between", value1, value2, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg0NotBetween(String value1, String value2) {
            addCriterion("object_img0 not between", value1, value2, "objectImg0");
            return (Criteria) this;
        }

        public Criteria andObjectImg1IsNull() {
            addCriterion("object_img1 is null");
            return (Criteria) this;
        }

        public Criteria andObjectImg1IsNotNull() {
            addCriterion("object_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andObjectImg1EqualTo(String value) {
            addCriterion("object_img1 =", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1NotEqualTo(String value) {
            addCriterion("object_img1 <>", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1GreaterThan(String value) {
            addCriterion("object_img1 >", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1GreaterThanOrEqualTo(String value) {
            addCriterion("object_img1 >=", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1LessThan(String value) {
            addCriterion("object_img1 <", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1LessThanOrEqualTo(String value) {
            addCriterion("object_img1 <=", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1Like(String value) {
            addCriterion("object_img1 like", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1NotLike(String value) {
            addCriterion("object_img1 not like", value, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1In(List<String> values) {
            addCriterion("object_img1 in", values, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1NotIn(List<String> values) {
            addCriterion("object_img1 not in", values, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1Between(String value1, String value2) {
            addCriterion("object_img1 between", value1, value2, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg1NotBetween(String value1, String value2) {
            addCriterion("object_img1 not between", value1, value2, "objectImg1");
            return (Criteria) this;
        }

        public Criteria andObjectImg2IsNull() {
            addCriterion("object_img2 is null");
            return (Criteria) this;
        }

        public Criteria andObjectImg2IsNotNull() {
            addCriterion("object_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andObjectImg2EqualTo(String value) {
            addCriterion("object_img2 =", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2NotEqualTo(String value) {
            addCriterion("object_img2 <>", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2GreaterThan(String value) {
            addCriterion("object_img2 >", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2GreaterThanOrEqualTo(String value) {
            addCriterion("object_img2 >=", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2LessThan(String value) {
            addCriterion("object_img2 <", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2LessThanOrEqualTo(String value) {
            addCriterion("object_img2 <=", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2Like(String value) {
            addCriterion("object_img2 like", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2NotLike(String value) {
            addCriterion("object_img2 not like", value, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2In(List<String> values) {
            addCriterion("object_img2 in", values, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2NotIn(List<String> values) {
            addCriterion("object_img2 not in", values, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2Between(String value1, String value2) {
            addCriterion("object_img2 between", value1, value2, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg2NotBetween(String value1, String value2) {
            addCriterion("object_img2 not between", value1, value2, "objectImg2");
            return (Criteria) this;
        }

        public Criteria andObjectImg3IsNull() {
            addCriterion("object_img3 is null");
            return (Criteria) this;
        }

        public Criteria andObjectImg3IsNotNull() {
            addCriterion("object_img3 is not null");
            return (Criteria) this;
        }

        public Criteria andObjectImg3EqualTo(String value) {
            addCriterion("object_img3 =", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3NotEqualTo(String value) {
            addCriterion("object_img3 <>", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3GreaterThan(String value) {
            addCriterion("object_img3 >", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3GreaterThanOrEqualTo(String value) {
            addCriterion("object_img3 >=", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3LessThan(String value) {
            addCriterion("object_img3 <", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3LessThanOrEqualTo(String value) {
            addCriterion("object_img3 <=", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3Like(String value) {
            addCriterion("object_img3 like", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3NotLike(String value) {
            addCriterion("object_img3 not like", value, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3In(List<String> values) {
            addCriterion("object_img3 in", values, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3NotIn(List<String> values) {
            addCriterion("object_img3 not in", values, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3Between(String value1, String value2) {
            addCriterion("object_img3 between", value1, value2, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andObjectImg3NotBetween(String value1, String value2) {
            addCriterion("object_img3 not between", value1, value2, "objectImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg0IsNull() {
            addCriterion("summer_img0 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg0IsNotNull() {
            addCriterion("summer_img0 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg0EqualTo(String value) {
            addCriterion("summer_img0 =", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0NotEqualTo(String value) {
            addCriterion("summer_img0 <>", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0GreaterThan(String value) {
            addCriterion("summer_img0 >", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img0 >=", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0LessThan(String value) {
            addCriterion("summer_img0 <", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0LessThanOrEqualTo(String value) {
            addCriterion("summer_img0 <=", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0Like(String value) {
            addCriterion("summer_img0 like", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0NotLike(String value) {
            addCriterion("summer_img0 not like", value, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0In(List<String> values) {
            addCriterion("summer_img0 in", values, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0NotIn(List<String> values) {
            addCriterion("summer_img0 not in", values, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0Between(String value1, String value2) {
            addCriterion("summer_img0 between", value1, value2, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg0NotBetween(String value1, String value2) {
            addCriterion("summer_img0 not between", value1, value2, "summerImg0");
            return (Criteria) this;
        }

        public Criteria andSummerImg1IsNull() {
            addCriterion("summer_img1 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg1IsNotNull() {
            addCriterion("summer_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg1EqualTo(String value) {
            addCriterion("summer_img1 =", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1NotEqualTo(String value) {
            addCriterion("summer_img1 <>", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1GreaterThan(String value) {
            addCriterion("summer_img1 >", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img1 >=", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1LessThan(String value) {
            addCriterion("summer_img1 <", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1LessThanOrEqualTo(String value) {
            addCriterion("summer_img1 <=", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1Like(String value) {
            addCriterion("summer_img1 like", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1NotLike(String value) {
            addCriterion("summer_img1 not like", value, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1In(List<String> values) {
            addCriterion("summer_img1 in", values, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1NotIn(List<String> values) {
            addCriterion("summer_img1 not in", values, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1Between(String value1, String value2) {
            addCriterion("summer_img1 between", value1, value2, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg1NotBetween(String value1, String value2) {
            addCriterion("summer_img1 not between", value1, value2, "summerImg1");
            return (Criteria) this;
        }

        public Criteria andSummerImg2IsNull() {
            addCriterion("summer_img2 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg2IsNotNull() {
            addCriterion("summer_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg2EqualTo(String value) {
            addCriterion("summer_img2 =", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2NotEqualTo(String value) {
            addCriterion("summer_img2 <>", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2GreaterThan(String value) {
            addCriterion("summer_img2 >", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img2 >=", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2LessThan(String value) {
            addCriterion("summer_img2 <", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2LessThanOrEqualTo(String value) {
            addCriterion("summer_img2 <=", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2Like(String value) {
            addCriterion("summer_img2 like", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2NotLike(String value) {
            addCriterion("summer_img2 not like", value, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2In(List<String> values) {
            addCriterion("summer_img2 in", values, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2NotIn(List<String> values) {
            addCriterion("summer_img2 not in", values, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2Between(String value1, String value2) {
            addCriterion("summer_img2 between", value1, value2, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg2NotBetween(String value1, String value2) {
            addCriterion("summer_img2 not between", value1, value2, "summerImg2");
            return (Criteria) this;
        }

        public Criteria andSummerImg3IsNull() {
            addCriterion("summer_img3 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg3IsNotNull() {
            addCriterion("summer_img3 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg3EqualTo(String value) {
            addCriterion("summer_img3 =", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3NotEqualTo(String value) {
            addCriterion("summer_img3 <>", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3GreaterThan(String value) {
            addCriterion("summer_img3 >", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img3 >=", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3LessThan(String value) {
            addCriterion("summer_img3 <", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3LessThanOrEqualTo(String value) {
            addCriterion("summer_img3 <=", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3Like(String value) {
            addCriterion("summer_img3 like", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3NotLike(String value) {
            addCriterion("summer_img3 not like", value, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3In(List<String> values) {
            addCriterion("summer_img3 in", values, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3NotIn(List<String> values) {
            addCriterion("summer_img3 not in", values, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3Between(String value1, String value2) {
            addCriterion("summer_img3 between", value1, value2, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg3NotBetween(String value1, String value2) {
            addCriterion("summer_img3 not between", value1, value2, "summerImg3");
            return (Criteria) this;
        }

        public Criteria andSummerImg4IsNull() {
            addCriterion("summer_img4 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg4IsNotNull() {
            addCriterion("summer_img4 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg4EqualTo(String value) {
            addCriterion("summer_img4 =", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4NotEqualTo(String value) {
            addCriterion("summer_img4 <>", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4GreaterThan(String value) {
            addCriterion("summer_img4 >", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img4 >=", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4LessThan(String value) {
            addCriterion("summer_img4 <", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4LessThanOrEqualTo(String value) {
            addCriterion("summer_img4 <=", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4Like(String value) {
            addCriterion("summer_img4 like", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4NotLike(String value) {
            addCriterion("summer_img4 not like", value, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4In(List<String> values) {
            addCriterion("summer_img4 in", values, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4NotIn(List<String> values) {
            addCriterion("summer_img4 not in", values, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4Between(String value1, String value2) {
            addCriterion("summer_img4 between", value1, value2, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg4NotBetween(String value1, String value2) {
            addCriterion("summer_img4 not between", value1, value2, "summerImg4");
            return (Criteria) this;
        }

        public Criteria andSummerImg5IsNull() {
            addCriterion("summer_img5 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg5IsNotNull() {
            addCriterion("summer_img5 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg5EqualTo(String value) {
            addCriterion("summer_img5 =", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5NotEqualTo(String value) {
            addCriterion("summer_img5 <>", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5GreaterThan(String value) {
            addCriterion("summer_img5 >", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img5 >=", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5LessThan(String value) {
            addCriterion("summer_img5 <", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5LessThanOrEqualTo(String value) {
            addCriterion("summer_img5 <=", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5Like(String value) {
            addCriterion("summer_img5 like", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5NotLike(String value) {
            addCriterion("summer_img5 not like", value, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5In(List<String> values) {
            addCriterion("summer_img5 in", values, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5NotIn(List<String> values) {
            addCriterion("summer_img5 not in", values, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5Between(String value1, String value2) {
            addCriterion("summer_img5 between", value1, value2, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg5NotBetween(String value1, String value2) {
            addCriterion("summer_img5 not between", value1, value2, "summerImg5");
            return (Criteria) this;
        }

        public Criteria andSummerImg6IsNull() {
            addCriterion("summer_img6 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg6IsNotNull() {
            addCriterion("summer_img6 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg6EqualTo(String value) {
            addCriterion("summer_img6 =", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6NotEqualTo(String value) {
            addCriterion("summer_img6 <>", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6GreaterThan(String value) {
            addCriterion("summer_img6 >", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img6 >=", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6LessThan(String value) {
            addCriterion("summer_img6 <", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6LessThanOrEqualTo(String value) {
            addCriterion("summer_img6 <=", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6Like(String value) {
            addCriterion("summer_img6 like", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6NotLike(String value) {
            addCriterion("summer_img6 not like", value, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6In(List<String> values) {
            addCriterion("summer_img6 in", values, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6NotIn(List<String> values) {
            addCriterion("summer_img6 not in", values, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6Between(String value1, String value2) {
            addCriterion("summer_img6 between", value1, value2, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg6NotBetween(String value1, String value2) {
            addCriterion("summer_img6 not between", value1, value2, "summerImg6");
            return (Criteria) this;
        }

        public Criteria andSummerImg7IsNull() {
            addCriterion("summer_img7 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg7IsNotNull() {
            addCriterion("summer_img7 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg7EqualTo(String value) {
            addCriterion("summer_img7 =", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7NotEqualTo(String value) {
            addCriterion("summer_img7 <>", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7GreaterThan(String value) {
            addCriterion("summer_img7 >", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img7 >=", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7LessThan(String value) {
            addCriterion("summer_img7 <", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7LessThanOrEqualTo(String value) {
            addCriterion("summer_img7 <=", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7Like(String value) {
            addCriterion("summer_img7 like", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7NotLike(String value) {
            addCriterion("summer_img7 not like", value, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7In(List<String> values) {
            addCriterion("summer_img7 in", values, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7NotIn(List<String> values) {
            addCriterion("summer_img7 not in", values, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7Between(String value1, String value2) {
            addCriterion("summer_img7 between", value1, value2, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg7NotBetween(String value1, String value2) {
            addCriterion("summer_img7 not between", value1, value2, "summerImg7");
            return (Criteria) this;
        }

        public Criteria andSummerImg8IsNull() {
            addCriterion("summer_img8 is null");
            return (Criteria) this;
        }

        public Criteria andSummerImg8IsNotNull() {
            addCriterion("summer_img8 is not null");
            return (Criteria) this;
        }

        public Criteria andSummerImg8EqualTo(String value) {
            addCriterion("summer_img8 =", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8NotEqualTo(String value) {
            addCriterion("summer_img8 <>", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8GreaterThan(String value) {
            addCriterion("summer_img8 >", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8GreaterThanOrEqualTo(String value) {
            addCriterion("summer_img8 >=", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8LessThan(String value) {
            addCriterion("summer_img8 <", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8LessThanOrEqualTo(String value) {
            addCriterion("summer_img8 <=", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8Like(String value) {
            addCriterion("summer_img8 like", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8NotLike(String value) {
            addCriterion("summer_img8 not like", value, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8In(List<String> values) {
            addCriterion("summer_img8 in", values, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8NotIn(List<String> values) {
            addCriterion("summer_img8 not in", values, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8Between(String value1, String value2) {
            addCriterion("summer_img8 between", value1, value2, "summerImg8");
            return (Criteria) this;
        }

        public Criteria andSummerImg8NotBetween(String value1, String value2) {
            addCriterion("summer_img8 not between", value1, value2, "summerImg8");
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