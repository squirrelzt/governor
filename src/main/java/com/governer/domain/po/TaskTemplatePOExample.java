package com.governer.domain.po;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskTemplatePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskTemplatePOExample() {
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
        protected List<Criterion> createStampCriteria;

        protected List<Criterion> lastModStampCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
            createStampCriteria = new ArrayList<>();
            lastModStampCriteria = new ArrayList<>();
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

        public boolean isValid() {
            return criteria.size() > 0
                || createStampCriteria.size() > 0
                || lastModStampCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(createStampCriteria);
                allCriteria.addAll(lastModStampCriteria);
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskParamIsNull() {
            addCriterion("task_param is null");
            return (Criteria) this;
        }

        public Criteria andTaskParamIsNotNull() {
            addCriterion("task_param is not null");
            return (Criteria) this;
        }

        public Criteria andTaskParamEqualTo(String value) {
            addCriterion("task_param =", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamNotEqualTo(String value) {
            addCriterion("task_param <>", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamGreaterThan(String value) {
            addCriterion("task_param >", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamGreaterThanOrEqualTo(String value) {
            addCriterion("task_param >=", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamLessThan(String value) {
            addCriterion("task_param <", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamLessThanOrEqualTo(String value) {
            addCriterion("task_param <=", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamLike(String value) {
            addCriterion("task_param like", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamNotLike(String value) {
            addCriterion("task_param not like", value, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamIn(List<String> values) {
            addCriterion("task_param in", values, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamNotIn(List<String> values) {
            addCriterion("task_param not in", values, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamBetween(String value1, String value2) {
            addCriterion("task_param between", value1, value2, "taskParam");
            return (Criteria) this;
        }

        public Criteria andTaskParamNotBetween(String value1, String value2) {
            addCriterion("task_param not between", value1, value2, "taskParam");
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

        public Criteria andMaxParallNumIsNull() {
            addCriterion("max_parall_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumIsNotNull() {
            addCriterion("max_parall_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumEqualTo(Integer value) {
            addCriterion("max_parall_num =", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumNotEqualTo(Integer value) {
            addCriterion("max_parall_num <>", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumGreaterThan(Integer value) {
            addCriterion("max_parall_num >", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_parall_num >=", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumLessThan(Integer value) {
            addCriterion("max_parall_num <", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumLessThanOrEqualTo(Integer value) {
            addCriterion("max_parall_num <=", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumIn(List<Integer> values) {
            addCriterion("max_parall_num in", values, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumNotIn(List<Integer> values) {
            addCriterion("max_parall_num not in", values, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumBetween(Integer value1, Integer value2) {
            addCriterion("max_parall_num between", value1, value2, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumNotBetween(Integer value1, Integer value2) {
            addCriterion("max_parall_num not between", value1, value2, "maxParallNum");
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

        public Criteria andIsRunIsNull() {
            addCriterion("is_run is null");
            return (Criteria) this;
        }

        public Criteria andIsRunIsNotNull() {
            addCriterion("is_run is not null");
            return (Criteria) this;
        }

        public Criteria andIsRunEqualTo(Integer value) {
            addCriterion("is_run =", value, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunNotEqualTo(Integer value) {
            addCriterion("is_run <>", value, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunGreaterThan(Integer value) {
            addCriterion("is_run >", value, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_run >=", value, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunLessThan(Integer value) {
            addCriterion("is_run <", value, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunLessThanOrEqualTo(Integer value) {
            addCriterion("is_run <=", value, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunIn(List<Integer> values) {
            addCriterion("is_run in", values, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunNotIn(List<Integer> values) {
            addCriterion("is_run not in", values, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunBetween(Integer value1, Integer value2) {
            addCriterion("is_run between", value1, value2, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRunNotBetween(Integer value1, Integer value2) {
            addCriterion("is_run not between", value1, value2, "isRun");
            return (Criteria) this;
        }

        public Criteria andIsRepeatIsNull() {
            addCriterion("is_repeat is null");
            return (Criteria) this;
        }

        public Criteria andIsRepeatIsNotNull() {
            addCriterion("is_repeat is not null");
            return (Criteria) this;
        }

        public Criteria andIsRepeatEqualTo(Integer value) {
            addCriterion("is_repeat =", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotEqualTo(Integer value) {
            addCriterion("is_repeat <>", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatGreaterThan(Integer value) {
            addCriterion("is_repeat >", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_repeat >=", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatLessThan(Integer value) {
            addCriterion("is_repeat <", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatLessThanOrEqualTo(Integer value) {
            addCriterion("is_repeat <=", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatIn(List<Integer> values) {
            addCriterion("is_repeat in", values, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotIn(List<Integer> values) {
            addCriterion("is_repeat not in", values, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatBetween(Integer value1, Integer value2) {
            addCriterion("is_repeat between", value1, value2, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotBetween(Integer value1, Integer value2) {
            addCriterion("is_repeat not between", value1, value2, "isRepeat");
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

        public Criteria andTimeoutIsNull() {
            addCriterion("timeout is null");
            return (Criteria) this;
        }

        public Criteria andTimeoutIsNotNull() {
            addCriterion("timeout is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoutEqualTo(Long value) {
            addCriterion("timeout =", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutNotEqualTo(Long value) {
            addCriterion("timeout <>", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutGreaterThan(Long value) {
            addCriterion("timeout >", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutGreaterThanOrEqualTo(Long value) {
            addCriterion("timeout >=", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutLessThan(Long value) {
            addCriterion("timeout <", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutLessThanOrEqualTo(Long value) {
            addCriterion("timeout <=", value, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutIn(List<Long> values) {
            addCriterion("timeout in", values, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutNotIn(List<Long> values) {
            addCriterion("timeout not in", values, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutBetween(Long value1, Long value2) {
            addCriterion("timeout between", value1, value2, "timeout");
            return (Criteria) this;
        }

        public Criteria andTimeoutNotBetween(Long value1, Long value2) {
            addCriterion("timeout not between", value1, value2, "timeout");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityIsNull() {
            addCriterion("task_priority is null");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityIsNotNull() {
            addCriterion("task_priority is not null");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityEqualTo(Integer value) {
            addCriterion("task_priority =", value, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityNotEqualTo(Integer value) {
            addCriterion("task_priority <>", value, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityGreaterThan(Integer value) {
            addCriterion("task_priority >", value, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_priority >=", value, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityLessThan(Integer value) {
            addCriterion("task_priority <", value, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("task_priority <=", value, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityIn(List<Integer> values) {
            addCriterion("task_priority in", values, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityNotIn(List<Integer> values) {
            addCriterion("task_priority not in", values, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityBetween(Integer value1, Integer value2) {
            addCriterion("task_priority between", value1, value2, "taskPriority");
            return (Criteria) this;
        }

        public Criteria andTaskPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("task_priority not between", value1, value2, "taskPriority");
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