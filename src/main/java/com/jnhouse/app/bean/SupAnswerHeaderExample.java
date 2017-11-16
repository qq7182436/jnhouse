package com.jnhouse.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SupAnswerHeaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupAnswerHeaderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andTemplate_idIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_idEqualTo(Integer value) {
            addCriterion("template_id =", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotEqualTo(Integer value) {
            addCriterion("template_id <>", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idGreaterThan(Integer value) {
            addCriterion("template_id >", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("template_id >=", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLessThan(Integer value) {
            addCriterion("template_id <", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLessThanOrEqualTo(Integer value) {
            addCriterion("template_id <=", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIn(List<Integer> values) {
            addCriterion("template_id in", values, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotIn(List<Integer> values) {
            addCriterion("template_id not in", values, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idBetween(Integer value1, Integer value2) {
            addCriterion("template_id between", value1, value2, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotBetween(Integer value1, Integer value2) {
            addCriterion("template_id not between", value1, value2, "template_id");
            return (Criteria) this;
        }

        public Criteria andCheck_dateIsNull() {
            addCriterion("check_date is null");
            return (Criteria) this;
        }

        public Criteria andCheck_dateIsNotNull() {
            addCriterion("check_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_dateEqualTo(Date value) {
            addCriterionForJDBCDate("check_date =", value, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateNotEqualTo(Date value) {
            addCriterionForJDBCDate("check_date <>", value, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateGreaterThan(Date value) {
            addCriterionForJDBCDate("check_date >", value, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("check_date >=", value, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateLessThan(Date value) {
            addCriterionForJDBCDate("check_date <", value, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("check_date <=", value, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateIn(List<Date> values) {
            addCriterionForJDBCDate("check_date in", values, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateNotIn(List<Date> values) {
            addCriterionForJDBCDate("check_date not in", values, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("check_date between", value1, value2, "check_date");
            return (Criteria) this;
        }

        public Criteria andCheck_dateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("check_date not between", value1, value2, "check_date");
            return (Criteria) this;
        }

        public Criteria andStore_idIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStore_idIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStore_idEqualTo(Integer value) {
            addCriterion("store_id =", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idGreaterThan(Integer value) {
            addCriterion("store_id >", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idLessThan(Integer value) {
            addCriterion("store_id <", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idIn(List<Integer> values) {
            addCriterion("store_id in", values, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_aroundIsNull() {
            addCriterion("store_around is null");
            return (Criteria) this;
        }

        public Criteria andStore_aroundIsNotNull() {
            addCriterion("store_around is not null");
            return (Criteria) this;
        }

        public Criteria andStore_aroundEqualTo(String value) {
            addCriterion("store_around =", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundNotEqualTo(String value) {
            addCriterion("store_around <>", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundGreaterThan(String value) {
            addCriterion("store_around >", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundGreaterThanOrEqualTo(String value) {
            addCriterion("store_around >=", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundLessThan(String value) {
            addCriterion("store_around <", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundLessThanOrEqualTo(String value) {
            addCriterion("store_around <=", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundLike(String value) {
            addCriterion("store_around like", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundNotLike(String value) {
            addCriterion("store_around not like", value, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundIn(List<String> values) {
            addCriterion("store_around in", values, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundNotIn(List<String> values) {
            addCriterion("store_around not in", values, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundBetween(String value1, String value2) {
            addCriterion("store_around between", value1, value2, "store_around");
            return (Criteria) this;
        }

        public Criteria andStore_aroundNotBetween(String value1, String value2) {
            addCriterion("store_around not between", value1, value2, "store_around");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStart_timeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStart_timeEqualTo(String value) {
            addCriterion("start_time =", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThan(String value) {
            addCriterion("start_time >", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThan(String value) {
            addCriterion("start_time <", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeLike(String value) {
            addCriterion("start_time like", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotLike(String value) {
            addCriterion("start_time not like", value, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeIn(List<String> values) {
            addCriterion("start_time in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andStart_timeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "start_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(String value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(String value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(String value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLike(String value) {
            addCriterion("end_time like", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotLike(String value) {
            addCriterion("end_time not like", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<String> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andBroker_numIsNull() {
            addCriterion("broker_num is null");
            return (Criteria) this;
        }

        public Criteria andBroker_numIsNotNull() {
            addCriterion("broker_num is not null");
            return (Criteria) this;
        }

        public Criteria andBroker_numEqualTo(Integer value) {
            addCriterion("broker_num =", value, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numNotEqualTo(Integer value) {
            addCriterion("broker_num <>", value, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numGreaterThan(Integer value) {
            addCriterion("broker_num >", value, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_num >=", value, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numLessThan(Integer value) {
            addCriterion("broker_num <", value, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numLessThanOrEqualTo(Integer value) {
            addCriterion("broker_num <=", value, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numIn(List<Integer> values) {
            addCriterion("broker_num in", values, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numNotIn(List<Integer> values) {
            addCriterion("broker_num not in", values, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numBetween(Integer value1, Integer value2) {
            addCriterion("broker_num between", value1, value2, "broker_num");
            return (Criteria) this;
        }

        public Criteria andBroker_numNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_num not between", value1, value2, "broker_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numIsNull() {
            addCriterion("customer_num is null");
            return (Criteria) this;
        }

        public Criteria andCustomer_numIsNotNull() {
            addCriterion("customer_num is not null");
            return (Criteria) this;
        }

        public Criteria andCustomer_numEqualTo(Integer value) {
            addCriterion("customer_num =", value, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numNotEqualTo(Integer value) {
            addCriterion("customer_num <>", value, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numGreaterThan(Integer value) {
            addCriterion("customer_num >", value, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_num >=", value, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numLessThan(Integer value) {
            addCriterion("customer_num <", value, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numLessThanOrEqualTo(Integer value) {
            addCriterion("customer_num <=", value, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numIn(List<Integer> values) {
            addCriterion("customer_num in", values, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numNotIn(List<Integer> values) {
            addCriterion("customer_num not in", values, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numBetween(Integer value1, Integer value2) {
            addCriterion("customer_num between", value1, value2, "customer_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_numNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_num not between", value1, value2, "customer_num");
            return (Criteria) this;
        }

        public Criteria andDocking_manIsNull() {
            addCriterion("docking_man is null");
            return (Criteria) this;
        }

        public Criteria andDocking_manIsNotNull() {
            addCriterion("docking_man is not null");
            return (Criteria) this;
        }

        public Criteria andDocking_manEqualTo(String value) {
            addCriterion("docking_man =", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manNotEqualTo(String value) {
            addCriterion("docking_man <>", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manGreaterThan(String value) {
            addCriterion("docking_man >", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manGreaterThanOrEqualTo(String value) {
            addCriterion("docking_man >=", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manLessThan(String value) {
            addCriterion("docking_man <", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manLessThanOrEqualTo(String value) {
            addCriterion("docking_man <=", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manLike(String value) {
            addCriterion("docking_man like", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manNotLike(String value) {
            addCriterion("docking_man not like", value, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manIn(List<String> values) {
            addCriterion("docking_man in", values, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manNotIn(List<String> values) {
            addCriterion("docking_man not in", values, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manBetween(String value1, String value2) {
            addCriterion("docking_man between", value1, value2, "docking_man");
            return (Criteria) this;
        }

        public Criteria andDocking_manNotBetween(String value1, String value2) {
            addCriterion("docking_man not between", value1, value2, "docking_man");
            return (Criteria) this;
        }

        public Criteria andRecordingIsNull() {
            addCriterion("recording is null");
            return (Criteria) this;
        }

        public Criteria andRecordingIsNotNull() {
            addCriterion("recording is not null");
            return (Criteria) this;
        }

        public Criteria andRecordingEqualTo(String value) {
            addCriterion("recording =", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotEqualTo(String value) {
            addCriterion("recording <>", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingGreaterThan(String value) {
            addCriterion("recording >", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingGreaterThanOrEqualTo(String value) {
            addCriterion("recording >=", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingLessThan(String value) {
            addCriterion("recording <", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingLessThanOrEqualTo(String value) {
            addCriterion("recording <=", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingLike(String value) {
            addCriterion("recording like", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotLike(String value) {
            addCriterion("recording not like", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingIn(List<String> values) {
            addCriterion("recording in", values, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotIn(List<String> values) {
            addCriterion("recording not in", values, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingBetween(String value1, String value2) {
            addCriterion("recording between", value1, value2, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotBetween(String value1, String value2) {
            addCriterion("recording not between", value1, value2, "recording");
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