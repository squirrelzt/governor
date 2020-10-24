package com.governer.domain.po;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BatchJobTemplatePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BatchJobTemplatePOExample() {
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

        public Criteria andJobApplicationNameIsNull() {
            addCriterion("job_application_name is null");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameIsNotNull() {
            addCriterion("job_application_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameEqualTo(String value) {
            addCriterion("job_application_name =", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameNotEqualTo(String value) {
            addCriterion("job_application_name <>", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameGreaterThan(String value) {
            addCriterion("job_application_name >", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_application_name >=", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameLessThan(String value) {
            addCriterion("job_application_name <", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameLessThanOrEqualTo(String value) {
            addCriterion("job_application_name <=", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameLike(String value) {
            addCriterion("job_application_name like", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameNotLike(String value) {
            addCriterion("job_application_name not like", value, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameIn(List<String> values) {
            addCriterion("job_application_name in", values, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameNotIn(List<String> values) {
            addCriterion("job_application_name not in", values, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameBetween(String value1, String value2) {
            addCriterion("job_application_name between", value1, value2, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andJobApplicationNameNotBetween(String value1, String value2) {
            addCriterion("job_application_name not between", value1, value2, "jobApplicationName");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameIsNull() {
            addCriterion("remote_job_name is null");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameIsNotNull() {
            addCriterion("remote_job_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameEqualTo(String value) {
            addCriterion("remote_job_name =", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameNotEqualTo(String value) {
            addCriterion("remote_job_name <>", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameGreaterThan(String value) {
            addCriterion("remote_job_name >", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("remote_job_name >=", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameLessThan(String value) {
            addCriterion("remote_job_name <", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameLessThanOrEqualTo(String value) {
            addCriterion("remote_job_name <=", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameLike(String value) {
            addCriterion("remote_job_name like", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameNotLike(String value) {
            addCriterion("remote_job_name not like", value, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameIn(List<String> values) {
            addCriterion("remote_job_name in", values, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameNotIn(List<String> values) {
            addCriterion("remote_job_name not in", values, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameBetween(String value1, String value2) {
            addCriterion("remote_job_name between", value1, value2, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andRemoteJobNameNotBetween(String value1, String value2) {
            addCriterion("remote_job_name not between", value1, value2, "remoteJobName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameIsNull() {
            addCriterion("file_template_name is null");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameIsNotNull() {
            addCriterion("file_template_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameEqualTo(String value) {
            addCriterion("file_template_name =", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameNotEqualTo(String value) {
            addCriterion("file_template_name <>", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameGreaterThan(String value) {
            addCriterion("file_template_name >", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_template_name >=", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameLessThan(String value) {
            addCriterion("file_template_name <", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("file_template_name <=", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameLike(String value) {
            addCriterion("file_template_name like", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameNotLike(String value) {
            addCriterion("file_template_name not like", value, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameIn(List<String> values) {
            addCriterion("file_template_name in", values, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameNotIn(List<String> values) {
            addCriterion("file_template_name not in", values, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameBetween(String value1, String value2) {
            addCriterion("file_template_name between", value1, value2, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andFileTemplateNameNotBetween(String value1, String value2) {
            addCriterion("file_template_name not between", value1, value2, "fileTemplateName");
            return (Criteria) this;
        }

        public Criteria andShardingRuleIsNull() {
            addCriterion("sharding_rule is null");
            return (Criteria) this;
        }

        public Criteria andShardingRuleIsNotNull() {
            addCriterion("sharding_rule is not null");
            return (Criteria) this;
        }

        public Criteria andShardingRuleEqualTo(String value) {
            addCriterion("sharding_rule =", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleNotEqualTo(String value) {
            addCriterion("sharding_rule <>", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleGreaterThan(String value) {
            addCriterion("sharding_rule >", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleGreaterThanOrEqualTo(String value) {
            addCriterion("sharding_rule >=", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleLessThan(String value) {
            addCriterion("sharding_rule <", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleLessThanOrEqualTo(String value) {
            addCriterion("sharding_rule <=", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleLike(String value) {
            addCriterion("sharding_rule like", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleNotLike(String value) {
            addCriterion("sharding_rule not like", value, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleIn(List<String> values) {
            addCriterion("sharding_rule in", values, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleNotIn(List<String> values) {
            addCriterion("sharding_rule not in", values, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleBetween(String value1, String value2) {
            addCriterion("sharding_rule between", value1, value2, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andShardingRuleNotBetween(String value1, String value2) {
            addCriterion("sharding_rule not between", value1, value2, "shardingRule");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumIsNull() {
            addCriterion("transactions_submit_num is null");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumIsNotNull() {
            addCriterion("transactions_submit_num is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumEqualTo(Long value) {
            addCriterion("transactions_submit_num =", value, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumNotEqualTo(Long value) {
            addCriterion("transactions_submit_num <>", value, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumGreaterThan(Long value) {
            addCriterion("transactions_submit_num >", value, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumGreaterThanOrEqualTo(Long value) {
            addCriterion("transactions_submit_num >=", value, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumLessThan(Long value) {
            addCriterion("transactions_submit_num <", value, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumLessThanOrEqualTo(Long value) {
            addCriterion("transactions_submit_num <=", value, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumIn(List<Long> values) {
            addCriterion("transactions_submit_num in", values, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumNotIn(List<Long> values) {
            addCriterion("transactions_submit_num not in", values, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumBetween(Long value1, Long value2) {
            addCriterion("transactions_submit_num between", value1, value2, "transactionsSubmitNum");
            return (Criteria) this;
        }

        public Criteria andTransactionsSubmitNumNotBetween(Long value1, Long value2) {
            addCriterion("transactions_submit_num not between", value1, value2, "transactionsSubmitNum");
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

        public Criteria andMaxParallNumEqualTo(Short value) {
            addCriterion("max_parall_num =", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumNotEqualTo(Short value) {
            addCriterion("max_parall_num <>", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumGreaterThan(Short value) {
            addCriterion("max_parall_num >", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumGreaterThanOrEqualTo(Short value) {
            addCriterion("max_parall_num >=", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumLessThan(Short value) {
            addCriterion("max_parall_num <", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumLessThanOrEqualTo(Short value) {
            addCriterion("max_parall_num <=", value, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumIn(List<Short> values) {
            addCriterion("max_parall_num in", values, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumNotIn(List<Short> values) {
            addCriterion("max_parall_num not in", values, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumBetween(Short value1, Short value2) {
            addCriterion("max_parall_num between", value1, value2, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andMaxParallNumNotBetween(Short value1, Short value2) {
            addCriterion("max_parall_num not between", value1, value2, "maxParallNum");
            return (Criteria) this;
        }

        public Criteria andIsSkipIsNull() {
            addCriterion("is_skip is null");
            return (Criteria) this;
        }

        public Criteria andIsSkipIsNotNull() {
            addCriterion("is_skip is not null");
            return (Criteria) this;
        }

        public Criteria andIsSkipEqualTo(Short value) {
            addCriterion("is_skip =", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotEqualTo(Short value) {
            addCriterion("is_skip <>", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipGreaterThan(Short value) {
            addCriterion("is_skip >", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipGreaterThanOrEqualTo(Short value) {
            addCriterion("is_skip >=", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipLessThan(Short value) {
            addCriterion("is_skip <", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipLessThanOrEqualTo(Short value) {
            addCriterion("is_skip <=", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipIn(List<Short> values) {
            addCriterion("is_skip in", values, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotIn(List<Short> values) {
            addCriterion("is_skip not in", values, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipBetween(Short value1, Short value2) {
            addCriterion("is_skip between", value1, value2, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotBetween(Short value1, Short value2) {
            addCriterion("is_skip not between", value1, value2, "isSkip");
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

        public Criteria andIsRepeatEqualTo(Short value) {
            addCriterion("is_repeat =", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotEqualTo(Short value) {
            addCriterion("is_repeat <>", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatGreaterThan(Short value) {
            addCriterion("is_repeat >", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatGreaterThanOrEqualTo(Short value) {
            addCriterion("is_repeat >=", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatLessThan(Short value) {
            addCriterion("is_repeat <", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatLessThanOrEqualTo(Short value) {
            addCriterion("is_repeat <=", value, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatIn(List<Short> values) {
            addCriterion("is_repeat in", values, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotIn(List<Short> values) {
            addCriterion("is_repeat not in", values, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatBetween(Short value1, Short value2) {
            addCriterion("is_repeat between", value1, value2, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsRepeatNotBetween(Short value1, Short value2) {
            addCriterion("is_repeat not between", value1, value2, "isRepeat");
            return (Criteria) this;
        }

        public Criteria andIsResultIsNull() {
            addCriterion("is_result is null");
            return (Criteria) this;
        }

        public Criteria andIsResultIsNotNull() {
            addCriterion("is_result is not null");
            return (Criteria) this;
        }

        public Criteria andIsResultEqualTo(Short value) {
            addCriterion("is_result =", value, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultNotEqualTo(Short value) {
            addCriterion("is_result <>", value, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultGreaterThan(Short value) {
            addCriterion("is_result >", value, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultGreaterThanOrEqualTo(Short value) {
            addCriterion("is_result >=", value, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultLessThan(Short value) {
            addCriterion("is_result <", value, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultLessThanOrEqualTo(Short value) {
            addCriterion("is_result <=", value, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultIn(List<Short> values) {
            addCriterion("is_result in", values, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultNotIn(List<Short> values) {
            addCriterion("is_result not in", values, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultBetween(Short value1, Short value2) {
            addCriterion("is_result between", value1, value2, "isResult");
            return (Criteria) this;
        }

        public Criteria andIsResultNotBetween(Short value1, Short value2) {
            addCriterion("is_result not between", value1, value2, "isResult");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIsNull() {
            addCriterion("retry_time is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIsNotNull() {
            addCriterion("retry_time is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimeEqualTo(Long value) {
            addCriterion("retry_time =", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeNotEqualTo(Long value) {
            addCriterion("retry_time <>", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeGreaterThan(Long value) {
            addCriterion("retry_time >", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("retry_time >=", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeLessThan(Long value) {
            addCriterion("retry_time <", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeLessThanOrEqualTo(Long value) {
            addCriterion("retry_time <=", value, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeIn(List<Long> values) {
            addCriterion("retry_time in", values, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeNotIn(List<Long> values) {
            addCriterion("retry_time not in", values, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeBetween(Long value1, Long value2) {
            addCriterion("retry_time between", value1, value2, "retryTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimeNotBetween(Long value1, Long value2) {
            addCriterion("retry_time not between", value1, value2, "retryTime");
            return (Criteria) this;
        }

        public Criteria andJobParamIsNull() {
            addCriterion("job_param is null");
            return (Criteria) this;
        }

        public Criteria andJobParamIsNotNull() {
            addCriterion("job_param is not null");
            return (Criteria) this;
        }

        public Criteria andJobParamEqualTo(String value) {
            addCriterion("job_param =", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotEqualTo(String value) {
            addCriterion("job_param <>", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamGreaterThan(String value) {
            addCriterion("job_param >", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamGreaterThanOrEqualTo(String value) {
            addCriterion("job_param >=", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamLessThan(String value) {
            addCriterion("job_param <", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamLessThanOrEqualTo(String value) {
            addCriterion("job_param <=", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamLike(String value) {
            addCriterion("job_param like", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotLike(String value) {
            addCriterion("job_param not like", value, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamIn(List<String> values) {
            addCriterion("job_param in", values, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotIn(List<String> values) {
            addCriterion("job_param not in", values, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamBetween(String value1, String value2) {
            addCriterion("job_param between", value1, value2, "jobParam");
            return (Criteria) this;
        }

        public Criteria andJobParamNotBetween(String value1, String value2) {
            addCriterion("job_param not between", value1, value2, "jobParam");
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