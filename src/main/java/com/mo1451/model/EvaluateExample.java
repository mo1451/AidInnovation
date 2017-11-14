package com.mo1451.model;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

        public Criteria andComplexIsNull() {
            addCriterion("complex is null");
            return (Criteria) this;
        }

        public Criteria andComplexIsNotNull() {
            addCriterion("complex is not null");
            return (Criteria) this;
        }

        public Criteria andComplexEqualTo(Integer value) {
            addCriterion("complex =", value, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexNotEqualTo(Integer value) {
            addCriterion("complex <>", value, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexGreaterThan(Integer value) {
            addCriterion("complex >", value, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexGreaterThanOrEqualTo(Integer value) {
            addCriterion("complex >=", value, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexLessThan(Integer value) {
            addCriterion("complex <", value, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexLessThanOrEqualTo(Integer value) {
            addCriterion("complex <=", value, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexIn(List<Integer> values) {
            addCriterion("complex in", values, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexNotIn(List<Integer> values) {
            addCriterion("complex not in", values, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexBetween(Integer value1, Integer value2) {
            addCriterion("complex between", value1, value2, "complex");
            return (Criteria) this;
        }

        public Criteria andComplexNotBetween(Integer value1, Integer value2) {
            addCriterion("complex not between", value1, value2, "complex");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Integer value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Integer value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Integer value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Integer value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Integer value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Integer> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Integer> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Integer value1, Integer value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Integer value1, Integer value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andSimIsNull() {
            addCriterion("sim is null");
            return (Criteria) this;
        }

        public Criteria andSimIsNotNull() {
            addCriterion("sim is not null");
            return (Criteria) this;
        }

        public Criteria andSimEqualTo(Integer value) {
            addCriterion("sim =", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotEqualTo(Integer value) {
            addCriterion("sim <>", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimGreaterThan(Integer value) {
            addCriterion("sim >", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimGreaterThanOrEqualTo(Integer value) {
            addCriterion("sim >=", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimLessThan(Integer value) {
            addCriterion("sim <", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimLessThanOrEqualTo(Integer value) {
            addCriterion("sim <=", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimIn(List<Integer> values) {
            addCriterion("sim in", values, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotIn(List<Integer> values) {
            addCriterion("sim not in", values, "sim");
            return (Criteria) this;
        }

        public Criteria andSimBetween(Integer value1, Integer value2) {
            addCriterion("sim between", value1, value2, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotBetween(Integer value1, Integer value2) {
            addCriterion("sim not between", value1, value2, "sim");
            return (Criteria) this;
        }

        public Criteria andIntellIsNull() {
            addCriterion("intell is null");
            return (Criteria) this;
        }

        public Criteria andIntellIsNotNull() {
            addCriterion("intell is not null");
            return (Criteria) this;
        }

        public Criteria andIntellEqualTo(Integer value) {
            addCriterion("intell =", value, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellNotEqualTo(Integer value) {
            addCriterion("intell <>", value, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellGreaterThan(Integer value) {
            addCriterion("intell >", value, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellGreaterThanOrEqualTo(Integer value) {
            addCriterion("intell >=", value, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellLessThan(Integer value) {
            addCriterion("intell <", value, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellLessThanOrEqualTo(Integer value) {
            addCriterion("intell <=", value, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellIn(List<Integer> values) {
            addCriterion("intell in", values, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellNotIn(List<Integer> values) {
            addCriterion("intell not in", values, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellBetween(Integer value1, Integer value2) {
            addCriterion("intell between", value1, value2, "intell");
            return (Criteria) this;
        }

        public Criteria andIntellNotBetween(Integer value1, Integer value2) {
            addCriterion("intell not between", value1, value2, "intell");
            return (Criteria) this;
        }

        public Criteria andEquipIsNull() {
            addCriterion("equip is null");
            return (Criteria) this;
        }

        public Criteria andEquipIsNotNull() {
            addCriterion("equip is not null");
            return (Criteria) this;
        }

        public Criteria andEquipEqualTo(Integer value) {
            addCriterion("equip =", value, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipNotEqualTo(Integer value) {
            addCriterion("equip <>", value, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipGreaterThan(Integer value) {
            addCriterion("equip >", value, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipGreaterThanOrEqualTo(Integer value) {
            addCriterion("equip >=", value, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipLessThan(Integer value) {
            addCriterion("equip <", value, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipLessThanOrEqualTo(Integer value) {
            addCriterion("equip <=", value, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipIn(List<Integer> values) {
            addCriterion("equip in", values, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipNotIn(List<Integer> values) {
            addCriterion("equip not in", values, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipBetween(Integer value1, Integer value2) {
            addCriterion("equip between", value1, value2, "equip");
            return (Criteria) this;
        }

        public Criteria andEquipNotBetween(Integer value1, Integer value2) {
            addCriterion("equip not between", value1, value2, "equip");
            return (Criteria) this;
        }

        public Criteria andFeasiIsNull() {
            addCriterion("feasi is null");
            return (Criteria) this;
        }

        public Criteria andFeasiIsNotNull() {
            addCriterion("feasi is not null");
            return (Criteria) this;
        }

        public Criteria andFeasiEqualTo(Integer value) {
            addCriterion("feasi =", value, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiNotEqualTo(Integer value) {
            addCriterion("feasi <>", value, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiGreaterThan(Integer value) {
            addCriterion("feasi >", value, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiGreaterThanOrEqualTo(Integer value) {
            addCriterion("feasi >=", value, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiLessThan(Integer value) {
            addCriterion("feasi <", value, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiLessThanOrEqualTo(Integer value) {
            addCriterion("feasi <=", value, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiIn(List<Integer> values) {
            addCriterion("feasi in", values, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiNotIn(List<Integer> values) {
            addCriterion("feasi not in", values, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiBetween(Integer value1, Integer value2) {
            addCriterion("feasi between", value1, value2, "feasi");
            return (Criteria) this;
        }

        public Criteria andFeasiNotBetween(Integer value1, Integer value2) {
            addCriterion("feasi not between", value1, value2, "feasi");
            return (Criteria) this;
        }

        public Criteria andSoluidIsNull() {
            addCriterion("soluid is null");
            return (Criteria) this;
        }

        public Criteria andSoluidIsNotNull() {
            addCriterion("soluid is not null");
            return (Criteria) this;
        }

        public Criteria andSoluidEqualTo(Integer value) {
            addCriterion("soluid =", value, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidNotEqualTo(Integer value) {
            addCriterion("soluid <>", value, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidGreaterThan(Integer value) {
            addCriterion("soluid >", value, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidGreaterThanOrEqualTo(Integer value) {
            addCriterion("soluid >=", value, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidLessThan(Integer value) {
            addCriterion("soluid <", value, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidLessThanOrEqualTo(Integer value) {
            addCriterion("soluid <=", value, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidIn(List<Integer> values) {
            addCriterion("soluid in", values, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidNotIn(List<Integer> values) {
            addCriterion("soluid not in", values, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidBetween(Integer value1, Integer value2) {
            addCriterion("soluid between", value1, value2, "soluid");
            return (Criteria) this;
        }

        public Criteria andSoluidNotBetween(Integer value1, Integer value2) {
            addCriterion("soluid not between", value1, value2, "soluid");
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