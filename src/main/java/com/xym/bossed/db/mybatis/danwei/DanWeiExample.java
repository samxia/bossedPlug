package com.xym.bossed.db.mybatis.danwei;

import java.util.ArrayList;
import java.util.List;

public class DanWeiExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public DanWeiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
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

        public Criteria andLcMcIsNull() {
            addCriterion("lc_mc is null");
            return (Criteria) this;
        }

        public Criteria andLcMcIsNotNull() {
            addCriterion("lc_mc is not null");
            return (Criteria) this;
        }

        public Criteria andLcMcEqualTo(String value) {
            addCriterion("lc_mc =", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcNotEqualTo(String value) {
            addCriterion("lc_mc <>", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcGreaterThan(String value) {
            addCriterion("lc_mc >", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcGreaterThanOrEqualTo(String value) {
            addCriterion("lc_mc >=", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcLessThan(String value) {
            addCriterion("lc_mc <", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcLessThanOrEqualTo(String value) {
            addCriterion("lc_mc <=", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcLike(String value) {
            addCriterion("lc_mc like", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcNotLike(String value) {
            addCriterion("lc_mc not like", value, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcIn(List<String> values) {
            addCriterion("lc_mc in", values, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcNotIn(List<String> values) {
            addCriterion("lc_mc not in", values, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcBetween(String value1, String value2) {
            addCriterion("lc_mc between", value1, value2, "lcMc");
            return (Criteria) this;
        }

        public Criteria andLcMcNotBetween(String value1, String value2) {
            addCriterion("lc_mc not between", value1, value2, "lcMc");
            return (Criteria) this;
        }

        public Criteria andRecoNoIsNull() {
            addCriterion("reco_no is null");
            return (Criteria) this;
        }

        public Criteria andRecoNoIsNotNull() {
            addCriterion("reco_no is not null");
            return (Criteria) this;
        }

        public Criteria andRecoNoEqualTo(Integer value) {
            addCriterion("reco_no =", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoNotEqualTo(Integer value) {
            addCriterion("reco_no <>", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoGreaterThan(Integer value) {
            addCriterion("reco_no >", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("reco_no >=", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoLessThan(Integer value) {
            addCriterion("reco_no <", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoLessThanOrEqualTo(Integer value) {
            addCriterion("reco_no <=", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoIn(List<Integer> values) {
            addCriterion("reco_no in", values, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoNotIn(List<Integer> values) {
            addCriterion("reco_no not in", values, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoBetween(Integer value1, Integer value2) {
            addCriterion("reco_no between", value1, value2, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoNotBetween(Integer value1, Integer value2) {
            addCriterion("reco_no not between", value1, value2, "recoNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sm_danwlc
     *
     * @mbggenerated do_not_delete_during_merge Mon Apr 21 17:52:08 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sm_danwlc
     *
     * @mbggenerated Mon Apr 21 17:52:08 CST 2014
     */
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