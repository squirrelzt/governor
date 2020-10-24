package com.governer.domain.po;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimerMExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimerMExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCronIsNull() {
            addCriterion("cron is null");
            return (Criteria) this;
        }

        public Criteria andCronIsNotNull() {
            addCriterion("cron is not null");
            return (Criteria) this;
        }

        public Criteria andCronEqualTo(String value) {
            addCriterion("cron =", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotEqualTo(String value) {
            addCriterion("cron <>", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThan(String value) {
            addCriterion("cron >", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronGreaterThanOrEqualTo(String value) {
            addCriterion("cron >=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThan(String value) {
            addCriterion("cron <", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLessThanOrEqualTo(String value) {
            addCriterion("cron <=", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronLike(String value) {
            addCriterion("cron like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotLike(String value) {
            addCriterion("cron not like", value, "cron");
            return (Criteria) this;
        }

        public Criteria andCronIn(List<String> values) {
            addCriterion("cron in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotIn(List<String> values) {
            addCriterion("cron not in", values, "cron");
            return (Criteria) this;
        }

        public Criteria andCronBetween(String value1, String value2) {
            addCriterion("cron between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andCronNotBetween(String value1, String value2) {
            addCriterion("cron not between", value1, value2, "cron");
            return (Criteria) this;
        }

        public Criteria andJsonIsNull() {
            addCriterion("json is null");
            return (Criteria) this;
        }

        public Criteria andJsonIsNotNull() {
            addCriterion("json is not null");
            return (Criteria) this;
        }

        public Criteria andJsonEqualTo(String value) {
            addCriterion("json =", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotEqualTo(String value) {
            addCriterion("json <>", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonGreaterThan(String value) {
            addCriterion("json >", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonGreaterThanOrEqualTo(String value) {
            addCriterion("json >=", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonLessThan(String value) {
            addCriterion("json <", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonLessThanOrEqualTo(String value) {
            addCriterion("json <=", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonLike(String value) {
            addCriterion("json like", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotLike(String value) {
            addCriterion("json not like", value, "json");
            return (Criteria) this;
        }

        public Criteria andJsonIn(List<String> values) {
            addCriterion("json in", values, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotIn(List<String> values) {
            addCriterion("json not in", values, "json");
            return (Criteria) this;
        }

        public Criteria andJsonBetween(String value1, String value2) {
            addCriterion("json between", value1, value2, "json");
            return (Criteria) this;
        }

        public Criteria andJsonNotBetween(String value1, String value2) {
            addCriterion("json not between", value1, value2, "json");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
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