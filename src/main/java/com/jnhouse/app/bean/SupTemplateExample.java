package com.jnhouse.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupTemplateExample() {
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

        public Criteria andMenu_titleIsNull() {
            addCriterion("menu_title is null");
            return (Criteria) this;
        }

        public Criteria andMenu_titleIsNotNull() {
            addCriterion("menu_title is not null");
            return (Criteria) this;
        }

        public Criteria andMenu_titleEqualTo(String value) {
            addCriterion("menu_title =", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleNotEqualTo(String value) {
            addCriterion("menu_title <>", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleGreaterThan(String value) {
            addCriterion("menu_title >", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleGreaterThanOrEqualTo(String value) {
            addCriterion("menu_title >=", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleLessThan(String value) {
            addCriterion("menu_title <", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleLessThanOrEqualTo(String value) {
            addCriterion("menu_title <=", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleLike(String value) {
            addCriterion("menu_title like", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleNotLike(String value) {
            addCriterion("menu_title not like", value, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleIn(List<String> values) {
            addCriterion("menu_title in", values, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleNotIn(List<String> values) {
            addCriterion("menu_title not in", values, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleBetween(String value1, String value2) {
            addCriterion("menu_title between", value1, value2, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_titleNotBetween(String value1, String value2) {
            addCriterion("menu_title not between", value1, value2, "menu_title");
            return (Criteria) this;
        }

        public Criteria andMenu_levelIsNull() {
            addCriterion("menu_level is null");
            return (Criteria) this;
        }

        public Criteria andMenu_levelIsNotNull() {
            addCriterion("menu_level is not null");
            return (Criteria) this;
        }

        public Criteria andMenu_levelEqualTo(Integer value) {
            addCriterion("menu_level =", value, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelNotEqualTo(Integer value) {
            addCriterion("menu_level <>", value, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelGreaterThan(Integer value) {
            addCriterion("menu_level >", value, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_level >=", value, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelLessThan(Integer value) {
            addCriterion("menu_level <", value, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelLessThanOrEqualTo(Integer value) {
            addCriterion("menu_level <=", value, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelIn(List<Integer> values) {
            addCriterion("menu_level in", values, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelNotIn(List<Integer> values) {
            addCriterion("menu_level not in", values, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelBetween(Integer value1, Integer value2) {
            addCriterion("menu_level between", value1, value2, "menu_level");
            return (Criteria) this;
        }

        public Criteria andMenu_levelNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_level not between", value1, value2, "menu_level");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "is_delete");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeLessThan(Date value) {
            addCriterion("updated_time <", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updated_time");
            return (Criteria) this;
        }

        public Criteria andUpdated_timeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updated_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_timeEqualTo(Date value) {
            addCriterion("created_time =", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeGreaterThan(Date value) {
            addCriterion("created_time >", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeLessThan(Date value) {
            addCriterion("created_time <", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIn(List<Date> values) {
            addCriterion("created_time in", values, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "created_time");
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