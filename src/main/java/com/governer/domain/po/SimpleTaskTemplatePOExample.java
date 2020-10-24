package com.governer.domain.po;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SimpleTaskTemplatePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SimpleTaskTemplatePOExample() {
        oredCriteria = new ArrayList<>();
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
        protected List<Criterion> lastModStampCriteria;

        protected List<Criterion> createStampCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
            lastModStampCriteria = new ArrayList<>();
            createStampCriteria = new ArrayList<>();
        }

        public List<Criterion> getLastModStampCriteria() {
            return lastModStampCriteria;
        }

        protected void addLastModStampCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            lastModStampCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.LocalDateTimeTypeHandler"));
            allCriteria = null;
        }

        protected void addLastModStampCriterion(String condition, LocalDateTime value1, LocalDateTime value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            lastModStampCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.LocalDateTimeTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getCreateStampCriteria() {
            return createStampCriteria;
        }

        protected void addCreateStampCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            createStampCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.LocalDateTimeTypeHandler"));
            allCriteria = null;
        }

        protected void addCreateStampCriterion(String condition, LocalDateTime value1, LocalDateTime value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            createStampCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.LocalDateTimeTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || lastModStampCriteria.size() > 0
                || createStampCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(lastModStampCriteria);
                allCriteria.addAll(createStampCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIsNull() {
            addCriterion("task_type_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIsNotNull() {
            addCriterion("task_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameEqualTo(String value) {
            addCriterion("task_type_name =", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotEqualTo(String value) {
            addCriterion("task_type_name <>", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameGreaterThan(String value) {
            addCriterion("task_type_name >", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_type_name >=", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLessThan(String value) {
            addCriterion("task_type_name <", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLessThanOrEqualTo(String value) {
            addCriterion("task_type_name <=", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLike(String value) {
            addCriterion("task_type_name like", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotLike(String value) {
            addCriterion("task_type_name not like", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIn(List<String> values) {
            addCriterion("task_type_name in", values, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotIn(List<String> values) {
            addCriterion("task_type_name not in", values, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameBetween(String value1, String value2) {
            addCriterion("task_type_name between", value1, value2, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotBetween(String value1, String value2) {
            addCriterion("task_type_name not between", value1, value2, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNull() {
            addCriterion("job_type is null");
            return (Criteria) this;
        }

        public Criteria andJobTypeIsNotNull() {
            addCriterion("job_type is not null");
            return (Criteria) this;
        }

        public Criteria andJobTypeEqualTo(String value) {
            addCriterion("job_type =", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotEqualTo(String value) {
            addCriterion("job_type <>", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThan(String value) {
            addCriterion("job_type >", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("job_type >=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThan(String value) {
            addCriterion("job_type <", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLessThanOrEqualTo(String value) {
            addCriterion("job_type <=", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeLike(String value) {
            addCriterion("job_type like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotLike(String value) {
            addCriterion("job_type not like", value, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeIn(List<String> values) {
            addCriterion("job_type in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotIn(List<String> values) {
            addCriterion("job_type not in", values, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeBetween(String value1, String value2) {
            addCriterion("job_type between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andJobTypeNotBetween(String value1, String value2) {
            addCriterion("job_type not between", value1, value2, "jobType");
            return (Criteria) this;
        }

        public Criteria andDusListIsNull() {
            addCriterion("dus_list is null");
            return (Criteria) this;
        }

        public Criteria andDusListIsNotNull() {
            addCriterion("dus_list is not null");
            return (Criteria) this;
        }

        public Criteria andDusListEqualTo(String value) {
            addCriterion("dus_list =", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListNotEqualTo(String value) {
            addCriterion("dus_list <>", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListGreaterThan(String value) {
            addCriterion("dus_list >", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListGreaterThanOrEqualTo(String value) {
            addCriterion("dus_list >=", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListLessThan(String value) {
            addCriterion("dus_list <", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListLessThanOrEqualTo(String value) {
            addCriterion("dus_list <=", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListLike(String value) {
            addCriterion("dus_list like", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListNotLike(String value) {
            addCriterion("dus_list not like", value, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListIn(List<String> values) {
            addCriterion("dus_list in", values, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListNotIn(List<String> values) {
            addCriterion("dus_list not in", values, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListBetween(String value1, String value2) {
            addCriterion("dus_list between", value1, value2, "dusList");
            return (Criteria) this;
        }

        public Criteria andDusListNotBetween(String value1, String value2) {
            addCriterion("dus_list not between", value1, value2, "dusList");
            return (Criteria) this;
        }

        public Criteria andServiceListIsNull() {
            addCriterion("service_list is null");
            return (Criteria) this;
        }

        public Criteria andServiceListIsNotNull() {
            addCriterion("service_list is not null");
            return (Criteria) this;
        }

        public Criteria andServiceListEqualTo(String value) {
            addCriterion("service_list =", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListNotEqualTo(String value) {
            addCriterion("service_list <>", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListGreaterThan(String value) {
            addCriterion("service_list >", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListGreaterThanOrEqualTo(String value) {
            addCriterion("service_list >=", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListLessThan(String value) {
            addCriterion("service_list <", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListLessThanOrEqualTo(String value) {
            addCriterion("service_list <=", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListLike(String value) {
            addCriterion("service_list like", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListNotLike(String value) {
            addCriterion("service_list not like", value, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListIn(List<String> values) {
            addCriterion("service_list in", values, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListNotIn(List<String> values) {
            addCriterion("service_list not in", values, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListBetween(String value1, String value2) {
            addCriterion("service_list between", value1, value2, "serviceList");
            return (Criteria) this;
        }

        public Criteria andServiceListNotBetween(String value1, String value2) {
            addCriterion("service_list not between", value1, value2, "serviceList");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLastModStampIsNull() {
            addCriterion("last_mod_stamp is null");
            return (Criteria) this;
        }

        public Criteria andLastModStampIsNotNull() {
            addCriterion("last_mod_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andLastModStampEqualTo(LocalDateTime value) {
            addLastModStampCriterion("last_mod_stamp =", value, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampNotEqualTo(LocalDateTime value) {
            addLastModStampCriterion("last_mod_stamp <>", value, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampGreaterThan(LocalDateTime value) {
            addLastModStampCriterion("last_mod_stamp >", value, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampGreaterThanOrEqualTo(LocalDateTime value) {
            addLastModStampCriterion("last_mod_stamp >=", value, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampLessThan(LocalDateTime value) {
            addLastModStampCriterion("last_mod_stamp <", value, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampLessThanOrEqualTo(LocalDateTime value) {
            addLastModStampCriterion("last_mod_stamp <=", value, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampIn(List<LocalDateTime> values) {
            addLastModStampCriterion("last_mod_stamp in", values, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampNotIn(List<LocalDateTime> values) {
            addLastModStampCriterion("last_mod_stamp not in", values, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampBetween(LocalDateTime value1, LocalDateTime value2) {
            addLastModStampCriterion("last_mod_stamp between", value1, value2, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andLastModStampNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addLastModStampCriterion("last_mod_stamp not between", value1, value2, "lastModStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampIsNull() {
            addCriterion("create_stamp is null");
            return (Criteria) this;
        }

        public Criteria andCreateStampIsNotNull() {
            addCriterion("create_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateStampEqualTo(LocalDateTime value) {
            addCreateStampCriterion("create_stamp =", value, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampNotEqualTo(LocalDateTime value) {
            addCreateStampCriterion("create_stamp <>", value, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampGreaterThan(LocalDateTime value) {
            addCreateStampCriterion("create_stamp >", value, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampGreaterThanOrEqualTo(LocalDateTime value) {
            addCreateStampCriterion("create_stamp >=", value, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampLessThan(LocalDateTime value) {
            addCreateStampCriterion("create_stamp <", value, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampLessThanOrEqualTo(LocalDateTime value) {
            addCreateStampCriterion("create_stamp <=", value, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampIn(List<LocalDateTime> values) {
            addCreateStampCriterion("create_stamp in", values, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampNotIn(List<LocalDateTime> values) {
            addCreateStampCriterion("create_stamp not in", values, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampBetween(LocalDateTime value1, LocalDateTime value2) {
            addCreateStampCriterion("create_stamp between", value1, value2, "createStamp");
            return (Criteria) this;
        }

        public Criteria andCreateStampNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCreateStampCriterion("create_stamp not between", value1, value2, "createStamp");
            return (Criteria) this;
        }

        public Criteria andJobProcessorIsNull() {
            addCriterion("job_processor is null");
            return (Criteria) this;
        }

        public Criteria andJobProcessorIsNotNull() {
            addCriterion("job_processor is not null");
            return (Criteria) this;
        }

        public Criteria andJobProcessorEqualTo(String value) {
            addCriterion("job_processor =", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorNotEqualTo(String value) {
            addCriterion("job_processor <>", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorGreaterThan(String value) {
            addCriterion("job_processor >", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorGreaterThanOrEqualTo(String value) {
            addCriterion("job_processor >=", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorLessThan(String value) {
            addCriterion("job_processor <", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorLessThanOrEqualTo(String value) {
            addCriterion("job_processor <=", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorLike(String value) {
            addCriterion("job_processor like", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorNotLike(String value) {
            addCriterion("job_processor not like", value, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorIn(List<String> values) {
            addCriterion("job_processor in", values, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorNotIn(List<String> values) {
            addCriterion("job_processor not in", values, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorBetween(String value1, String value2) {
            addCriterion("job_processor between", value1, value2, "jobProcessor");
            return (Criteria) this;
        }

        public Criteria andJobProcessorNotBetween(String value1, String value2) {
            addCriterion("job_processor not between", value1, value2, "jobProcessor");
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