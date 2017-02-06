package com.xym.bossed.db.mybatis.fapiao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FaPiaoExample {
    
    protected String orderByClause;

    
    protected boolean distinct;

    
    protected List<Criteria> oredCriteria;

    
    public FaPiaoExample() {
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

        public Criteria andRecoNoIsNull() {
            addCriterion("reco_no is null");
            return (Criteria) this;
        }

        public Criteria andRecoNoIsNotNull() {
            addCriterion("reco_no is not null");
            return (Criteria) this;
        }

        public Criteria andRecoNoEqualTo(Long value) {
            addCriterion("reco_no =", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoNotEqualTo(Long value) {
            addCriterion("reco_no <>", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoGreaterThan(Long value) {
            addCriterion("reco_no >", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoGreaterThanOrEqualTo(Long value) {
            addCriterion("reco_no >=", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoLessThan(Long value) {
            addCriterion("reco_no <", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoLessThanOrEqualTo(Long value) {
            addCriterion("reco_no <=", value, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoIn(List<Long> values) {
            addCriterion("reco_no in", values, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoNotIn(List<Long> values) {
            addCriterion("reco_no not in", values, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoBetween(Long value1, Long value2) {
            addCriterion("reco_no between", value1, value2, "recoNo");
            return (Criteria) this;
        }

        public Criteria andRecoNoNotBetween(Long value1, Long value2) {
            addCriterion("reco_no not between", value1, value2, "recoNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoIsNull() {
            addCriterion("kaip_no is null");
            return (Criteria) this;
        }

        public Criteria andKaipNoIsNotNull() {
            addCriterion("kaip_no is not null");
            return (Criteria) this;
        }

        public Criteria andKaipNoEqualTo(String value) {
            addCriterion("kaip_no =", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoNotEqualTo(String value) {
            addCriterion("kaip_no <>", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoGreaterThan(String value) {
            addCriterion("kaip_no >", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_no >=", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoLessThan(String value) {
            addCriterion("kaip_no <", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoLessThanOrEqualTo(String value) {
            addCriterion("kaip_no <=", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoLike(String value) {
            addCriterion("kaip_no like", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoNotLike(String value) {
            addCriterion("kaip_no not like", value, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoIn(List<String> values) {
            addCriterion("kaip_no in", values, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoNotIn(List<String> values) {
            addCriterion("kaip_no not in", values, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoBetween(String value1, String value2) {
            addCriterion("kaip_no between", value1, value2, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKaipNoNotBetween(String value1, String value2) {
            addCriterion("kaip_no not between", value1, value2, "kaipNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoIsNull() {
            addCriterion("kehu_no is null");
            return (Criteria) this;
        }

        public Criteria andKehuNoIsNotNull() {
            addCriterion("kehu_no is not null");
            return (Criteria) this;
        }

        public Criteria andKehuNoEqualTo(String value) {
            addCriterion("kehu_no =", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoNotEqualTo(String value) {
            addCriterion("kehu_no <>", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoGreaterThan(String value) {
            addCriterion("kehu_no >", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoGreaterThanOrEqualTo(String value) {
            addCriterion("kehu_no >=", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoLessThan(String value) {
            addCriterion("kehu_no <", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoLessThanOrEqualTo(String value) {
            addCriterion("kehu_no <=", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoLike(String value) {
            addCriterion("kehu_no like", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoNotLike(String value) {
            addCriterion("kehu_no not like", value, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoIn(List<String> values) {
            addCriterion("kehu_no in", values, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoNotIn(List<String> values) {
            addCriterion("kehu_no not in", values, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoBetween(String value1, String value2) {
            addCriterion("kehu_no between", value1, value2, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKehuNoNotBetween(String value1, String value2) {
            addCriterion("kehu_no not between", value1, value2, "kehuNo");
            return (Criteria) this;
        }

        public Criteria andKaipRqIsNull() {
            addCriterion("kaip_rq is null");
            return (Criteria) this;
        }

        public Criteria andKaipRqIsNotNull() {
            addCriterion("kaip_rq is not null");
            return (Criteria) this;
        }

        public Criteria andKaipRqEqualTo(Date value) {
            addCriterion("kaip_rq =", value, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqNotEqualTo(Date value) {
            addCriterion("kaip_rq <>", value, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqGreaterThan(Date value) {
            addCriterion("kaip_rq >", value, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqGreaterThanOrEqualTo(Date value) {
            addCriterion("kaip_rq >=", value, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqLessThan(Date value) {
            addCriterion("kaip_rq <", value, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqLessThanOrEqualTo(Date value) {
            addCriterion("kaip_rq <=", value, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqIn(List<Date> values) {
            addCriterion("kaip_rq in", values, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqNotIn(List<Date> values) {
            addCriterion("kaip_rq not in", values, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqBetween(Date value1, Date value2) {
            addCriterion("kaip_rq between", value1, value2, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipRqNotBetween(Date value1, Date value2) {
            addCriterion("kaip_rq not between", value1, value2, "kaipRq");
            return (Criteria) this;
        }

        public Criteria andKaipZyIsNull() {
            addCriterion("kaip_zy is null");
            return (Criteria) this;
        }

        public Criteria andKaipZyIsNotNull() {
            addCriterion("kaip_zy is not null");
            return (Criteria) this;
        }

        public Criteria andKaipZyEqualTo(String value) {
            addCriterion("kaip_zy =", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyNotEqualTo(String value) {
            addCriterion("kaip_zy <>", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyGreaterThan(String value) {
            addCriterion("kaip_zy >", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_zy >=", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyLessThan(String value) {
            addCriterion("kaip_zy <", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyLessThanOrEqualTo(String value) {
            addCriterion("kaip_zy <=", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyLike(String value) {
            addCriterion("kaip_zy like", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyNotLike(String value) {
            addCriterion("kaip_zy not like", value, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyIn(List<String> values) {
            addCriterion("kaip_zy in", values, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyNotIn(List<String> values) {
            addCriterion("kaip_zy not in", values, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyBetween(String value1, String value2) {
            addCriterion("kaip_zy between", value1, value2, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipZyNotBetween(String value1, String value2) {
            addCriterion("kaip_zy not between", value1, value2, "kaipZy");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcIsNull() {
            addCriterion("kaip_fpmc is null");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcIsNotNull() {
            addCriterion("kaip_fpmc is not null");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcEqualTo(String value) {
            addCriterion("kaip_fpmc =", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcNotEqualTo(String value) {
            addCriterion("kaip_fpmc <>", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcGreaterThan(String value) {
            addCriterion("kaip_fpmc >", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_fpmc >=", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcLessThan(String value) {
            addCriterion("kaip_fpmc <", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcLessThanOrEqualTo(String value) {
            addCriterion("kaip_fpmc <=", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcLike(String value) {
            addCriterion("kaip_fpmc like", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcNotLike(String value) {
            addCriterion("kaip_fpmc not like", value, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcIn(List<String> values) {
            addCriterion("kaip_fpmc in", values, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcNotIn(List<String> values) {
            addCriterion("kaip_fpmc not in", values, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcBetween(String value1, String value2) {
            addCriterion("kaip_fpmc between", value1, value2, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpmcNotBetween(String value1, String value2) {
            addCriterion("kaip_fpmc not between", value1, value2, "kaipFpmc");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoIsNull() {
            addCriterion("kaip_fpno is null");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoIsNotNull() {
            addCriterion("kaip_fpno is not null");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoEqualTo(String value) {
            addCriterion("kaip_fpno =", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoNotEqualTo(String value) {
            addCriterion("kaip_fpno <>", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoGreaterThan(String value) {
            addCriterion("kaip_fpno >", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_fpno >=", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoLessThan(String value) {
            addCriterion("kaip_fpno <", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoLessThanOrEqualTo(String value) {
            addCriterion("kaip_fpno <=", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoLike(String value) {
            addCriterion("kaip_fpno like", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoNotLike(String value) {
            addCriterion("kaip_fpno not like", value, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoIn(List<String> values) {
            addCriterion("kaip_fpno in", values, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoNotIn(List<String> values) {
            addCriterion("kaip_fpno not in", values, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoBetween(String value1, String value2) {
            addCriterion("kaip_fpno between", value1, value2, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipFpnoNotBetween(String value1, String value2) {
            addCriterion("kaip_fpno not between", value1, value2, "kaipFpno");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeIsNull() {
            addCriterion("kaip_jfje is null");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeIsNotNull() {
            addCriterion("kaip_jfje is not null");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeEqualTo(BigDecimal value) {
            addCriterion("kaip_jfje =", value, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeNotEqualTo(BigDecimal value) {
            addCriterion("kaip_jfje <>", value, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeGreaterThan(BigDecimal value) {
            addCriterion("kaip_jfje >", value, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_jfje >=", value, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeLessThan(BigDecimal value) {
            addCriterion("kaip_jfje <", value, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_jfje <=", value, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeIn(List<BigDecimal> values) {
            addCriterion("kaip_jfje in", values, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeNotIn(List<BigDecimal> values) {
            addCriterion("kaip_jfje not in", values, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_jfje between", value1, value2, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_jfje not between", value1, value2, "kaipJfje");
            return (Criteria) this;
        }

        public Criteria andKaipJfseIsNull() {
            addCriterion("kaip_jfse is null");
            return (Criteria) this;
        }

        public Criteria andKaipJfseIsNotNull() {
            addCriterion("kaip_jfse is not null");
            return (Criteria) this;
        }

        public Criteria andKaipJfseEqualTo(BigDecimal value) {
            addCriterion("kaip_jfse =", value, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseNotEqualTo(BigDecimal value) {
            addCriterion("kaip_jfse <>", value, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseGreaterThan(BigDecimal value) {
            addCriterion("kaip_jfse >", value, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_jfse >=", value, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseLessThan(BigDecimal value) {
            addCriterion("kaip_jfse <", value, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_jfse <=", value, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseIn(List<BigDecimal> values) {
            addCriterion("kaip_jfse in", values, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseNotIn(List<BigDecimal> values) {
            addCriterion("kaip_jfse not in", values, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_jfse between", value1, value2, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipJfseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_jfse not between", value1, value2, "kaipJfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeIsNull() {
            addCriterion("kaip_dfje is null");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeIsNotNull() {
            addCriterion("kaip_dfje is not null");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeEqualTo(BigDecimal value) {
            addCriterion("kaip_dfje =", value, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeNotEqualTo(BigDecimal value) {
            addCriterion("kaip_dfje <>", value, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeGreaterThan(BigDecimal value) {
            addCriterion("kaip_dfje >", value, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_dfje >=", value, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeLessThan(BigDecimal value) {
            addCriterion("kaip_dfje <", value, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_dfje <=", value, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeIn(List<BigDecimal> values) {
            addCriterion("kaip_dfje in", values, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeNotIn(List<BigDecimal> values) {
            addCriterion("kaip_dfje not in", values, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_dfje between", value1, value2, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_dfje not between", value1, value2, "kaipDfje");
            return (Criteria) this;
        }

        public Criteria andKaipDfseIsNull() {
            addCriterion("kaip_dfse is null");
            return (Criteria) this;
        }

        public Criteria andKaipDfseIsNotNull() {
            addCriterion("kaip_dfse is not null");
            return (Criteria) this;
        }

        public Criteria andKaipDfseEqualTo(BigDecimal value) {
            addCriterion("kaip_dfse =", value, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseNotEqualTo(BigDecimal value) {
            addCriterion("kaip_dfse <>", value, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseGreaterThan(BigDecimal value) {
            addCriterion("kaip_dfse >", value, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_dfse >=", value, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseLessThan(BigDecimal value) {
            addCriterion("kaip_dfse <", value, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_dfse <=", value, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseIn(List<BigDecimal> values) {
            addCriterion("kaip_dfse in", values, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseNotIn(List<BigDecimal> values) {
            addCriterion("kaip_dfse not in", values, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_dfse between", value1, value2, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipDfseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_dfse not between", value1, value2, "kaipDfse");
            return (Criteria) this;
        }

        public Criteria andKaipYujeIsNull() {
            addCriterion("kaip_yuje is null");
            return (Criteria) this;
        }

        public Criteria andKaipYujeIsNotNull() {
            addCriterion("kaip_yuje is not null");
            return (Criteria) this;
        }

        public Criteria andKaipYujeEqualTo(BigDecimal value) {
            addCriterion("kaip_yuje =", value, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeNotEqualTo(BigDecimal value) {
            addCriterion("kaip_yuje <>", value, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeGreaterThan(BigDecimal value) {
            addCriterion("kaip_yuje >", value, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_yuje >=", value, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeLessThan(BigDecimal value) {
            addCriterion("kaip_yuje <", value, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_yuje <=", value, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeIn(List<BigDecimal> values) {
            addCriterion("kaip_yuje in", values, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeNotIn(List<BigDecimal> values) {
            addCriterion("kaip_yuje not in", values, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_yuje between", value1, value2, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYujeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_yuje not between", value1, value2, "kaipYuje");
            return (Criteria) this;
        }

        public Criteria andKaipYuseIsNull() {
            addCriterion("kaip_yuse is null");
            return (Criteria) this;
        }

        public Criteria andKaipYuseIsNotNull() {
            addCriterion("kaip_yuse is not null");
            return (Criteria) this;
        }

        public Criteria andKaipYuseEqualTo(BigDecimal value) {
            addCriterion("kaip_yuse =", value, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseNotEqualTo(BigDecimal value) {
            addCriterion("kaip_yuse <>", value, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseGreaterThan(BigDecimal value) {
            addCriterion("kaip_yuse >", value, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_yuse >=", value, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseLessThan(BigDecimal value) {
            addCriterion("kaip_yuse <", value, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_yuse <=", value, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseIn(List<BigDecimal> values) {
            addCriterion("kaip_yuse in", values, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseNotIn(List<BigDecimal> values) {
            addCriterion("kaip_yuse not in", values, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_yuse between", value1, value2, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipYuseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_yuse not between", value1, value2, "kaipYuse");
            return (Criteria) this;
        }

        public Criteria andKaipValidityIsNull() {
            addCriterion("kaip_validity is null");
            return (Criteria) this;
        }

        public Criteria andKaipValidityIsNotNull() {
            addCriterion("kaip_validity is not null");
            return (Criteria) this;
        }

        public Criteria andKaipValidityEqualTo(Boolean value) {
            addCriterion("kaip_validity =", value, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityNotEqualTo(Boolean value) {
            addCriterion("kaip_validity <>", value, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityGreaterThan(Boolean value) {
            addCriterion("kaip_validity >", value, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityGreaterThanOrEqualTo(Boolean value) {
            addCriterion("kaip_validity >=", value, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityLessThan(Boolean value) {
            addCriterion("kaip_validity <", value, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityLessThanOrEqualTo(Boolean value) {
            addCriterion("kaip_validity <=", value, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityIn(List<Boolean> values) {
            addCriterion("kaip_validity in", values, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityNotIn(List<Boolean> values) {
            addCriterion("kaip_validity not in", values, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityBetween(Boolean value1, Boolean value2) {
            addCriterion("kaip_validity between", value1, value2, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipValidityNotBetween(Boolean value1, Boolean value2) {
            addCriterion("kaip_validity not between", value1, value2, "kaipValidity");
            return (Criteria) this;
        }

        public Criteria andKaipXzIsNull() {
            addCriterion("kaip_xz is null");
            return (Criteria) this;
        }

        public Criteria andKaipXzIsNotNull() {
            addCriterion("kaip_xz is not null");
            return (Criteria) this;
        }

        public Criteria andKaipXzEqualTo(Integer value) {
            addCriterion("kaip_xz =", value, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzNotEqualTo(Integer value) {
            addCriterion("kaip_xz <>", value, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzGreaterThan(Integer value) {
            addCriterion("kaip_xz >", value, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzGreaterThanOrEqualTo(Integer value) {
            addCriterion("kaip_xz >=", value, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzLessThan(Integer value) {
            addCriterion("kaip_xz <", value, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzLessThanOrEqualTo(Integer value) {
            addCriterion("kaip_xz <=", value, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzIn(List<Integer> values) {
            addCriterion("kaip_xz in", values, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzNotIn(List<Integer> values) {
            addCriterion("kaip_xz not in", values, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzBetween(Integer value1, Integer value2) {
            addCriterion("kaip_xz between", value1, value2, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipXzNotBetween(Integer value1, Integer value2) {
            addCriterion("kaip_xz not between", value1, value2, "kaipXz");
            return (Criteria) this;
        }

        public Criteria andKaipJbIsNull() {
            addCriterion("kaip_jb is null");
            return (Criteria) this;
        }

        public Criteria andKaipJbIsNotNull() {
            addCriterion("kaip_jb is not null");
            return (Criteria) this;
        }

        public Criteria andKaipJbEqualTo(String value) {
            addCriterion("kaip_jb =", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbNotEqualTo(String value) {
            addCriterion("kaip_jb <>", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbGreaterThan(String value) {
            addCriterion("kaip_jb >", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_jb >=", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbLessThan(String value) {
            addCriterion("kaip_jb <", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbLessThanOrEqualTo(String value) {
            addCriterion("kaip_jb <=", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbLike(String value) {
            addCriterion("kaip_jb like", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbNotLike(String value) {
            addCriterion("kaip_jb not like", value, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbIn(List<String> values) {
            addCriterion("kaip_jb in", values, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbNotIn(List<String> values) {
            addCriterion("kaip_jb not in", values, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbBetween(String value1, String value2) {
            addCriterion("kaip_jb between", value1, value2, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipJbNotBetween(String value1, String value2) {
            addCriterion("kaip_jb not between", value1, value2, "kaipJb");
            return (Criteria) this;
        }

        public Criteria andKaipCzyIsNull() {
            addCriterion("kaip_czy is null");
            return (Criteria) this;
        }

        public Criteria andKaipCzyIsNotNull() {
            addCriterion("kaip_czy is not null");
            return (Criteria) this;
        }

        public Criteria andKaipCzyEqualTo(String value) {
            addCriterion("kaip_czy =", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyNotEqualTo(String value) {
            addCriterion("kaip_czy <>", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyGreaterThan(String value) {
            addCriterion("kaip_czy >", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_czy >=", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyLessThan(String value) {
            addCriterion("kaip_czy <", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyLessThanOrEqualTo(String value) {
            addCriterion("kaip_czy <=", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyLike(String value) {
            addCriterion("kaip_czy like", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyNotLike(String value) {
            addCriterion("kaip_czy not like", value, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyIn(List<String> values) {
            addCriterion("kaip_czy in", values, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyNotIn(List<String> values) {
            addCriterion("kaip_czy not in", values, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyBetween(String value1, String value2) {
            addCriterion("kaip_czy between", value1, value2, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andKaipCzyNotBetween(String value1, String value2) {
            addCriterion("kaip_czy not between", value1, value2, "kaipCzy");
            return (Criteria) this;
        }

        public Criteria andDeptMcIsNull() {
            addCriterion("dept_mc is null");
            return (Criteria) this;
        }

        public Criteria andDeptMcIsNotNull() {
            addCriterion("dept_mc is not null");
            return (Criteria) this;
        }

        public Criteria andDeptMcEqualTo(String value) {
            addCriterion("dept_mc =", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcNotEqualTo(String value) {
            addCriterion("dept_mc <>", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcGreaterThan(String value) {
            addCriterion("dept_mc >", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcGreaterThanOrEqualTo(String value) {
            addCriterion("dept_mc >=", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcLessThan(String value) {
            addCriterion("dept_mc <", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcLessThanOrEqualTo(String value) {
            addCriterion("dept_mc <=", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcLike(String value) {
            addCriterion("dept_mc like", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcNotLike(String value) {
            addCriterion("dept_mc not like", value, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcIn(List<String> values) {
            addCriterion("dept_mc in", values, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcNotIn(List<String> values) {
            addCriterion("dept_mc not in", values, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcBetween(String value1, String value2) {
            addCriterion("dept_mc between", value1, value2, "deptMc");
            return (Criteria) this;
        }

        public Criteria andDeptMcNotBetween(String value1, String value2) {
            addCriterion("dept_mc not between", value1, value2, "deptMc");
            return (Criteria) this;
        }

        public Criteria andKaipBzIsNull() {
            addCriterion("kaip_bz is null");
            return (Criteria) this;
        }

        public Criteria andKaipBzIsNotNull() {
            addCriterion("kaip_bz is not null");
            return (Criteria) this;
        }

        public Criteria andKaipBzEqualTo(String value) {
            addCriterion("kaip_bz =", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzNotEqualTo(String value) {
            addCriterion("kaip_bz <>", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzGreaterThan(String value) {
            addCriterion("kaip_bz >", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzGreaterThanOrEqualTo(String value) {
            addCriterion("kaip_bz >=", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzLessThan(String value) {
            addCriterion("kaip_bz <", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzLessThanOrEqualTo(String value) {
            addCriterion("kaip_bz <=", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzLike(String value) {
            addCriterion("kaip_bz like", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzNotLike(String value) {
            addCriterion("kaip_bz not like", value, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzIn(List<String> values) {
            addCriterion("kaip_bz in", values, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzNotIn(List<String> values) {
            addCriterion("kaip_bz not in", values, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzBetween(String value1, String value2) {
            addCriterion("kaip_bz between", value1, value2, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipBzNotBetween(String value1, String value2) {
            addCriterion("kaip_bz not between", value1, value2, "kaipBz");
            return (Criteria) this;
        }

        public Criteria andKaipQmIsNull() {
            addCriterion("kaip_qm is null");
            return (Criteria) this;
        }

        public Criteria andKaipQmIsNotNull() {
            addCriterion("kaip_qm is not null");
            return (Criteria) this;
        }

        public Criteria andKaipQmEqualTo(BigDecimal value) {
            addCriterion("kaip_qm =", value, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmNotEqualTo(BigDecimal value) {
            addCriterion("kaip_qm <>", value, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmGreaterThan(BigDecimal value) {
            addCriterion("kaip_qm >", value, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_qm >=", value, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmLessThan(BigDecimal value) {
            addCriterion("kaip_qm <", value, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_qm <=", value, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmIn(List<BigDecimal> values) {
            addCriterion("kaip_qm in", values, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmNotIn(List<BigDecimal> values) {
            addCriterion("kaip_qm not in", values, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_qm between", value1, value2, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipQmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_qm not between", value1, value2, "kaipQm");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeIsNull() {
            addCriterion("kaip_bcje is null");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeIsNotNull() {
            addCriterion("kaip_bcje is not null");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeEqualTo(BigDecimal value) {
            addCriterion("kaip_bcje =", value, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeNotEqualTo(BigDecimal value) {
            addCriterion("kaip_bcje <>", value, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeGreaterThan(BigDecimal value) {
            addCriterion("kaip_bcje >", value, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_bcje >=", value, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeLessThan(BigDecimal value) {
            addCriterion("kaip_bcje <", value, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_bcje <=", value, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeIn(List<BigDecimal> values) {
            addCriterion("kaip_bcje in", values, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeNotIn(List<BigDecimal> values) {
            addCriterion("kaip_bcje not in", values, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_bcje between", value1, value2, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipBcjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_bcje not between", value1, value2, "kaipBcje");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeIsNull() {
            addCriterion("kaip_miankaije is null");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeIsNotNull() {
            addCriterion("kaip_miankaije is not null");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaije =", value, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeNotEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaije <>", value, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeGreaterThan(BigDecimal value) {
            addCriterion("kaip_miankaije >", value, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaije >=", value, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeLessThan(BigDecimal value) {
            addCriterion("kaip_miankaije <", value, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaije <=", value, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeIn(List<BigDecimal> values) {
            addCriterion("kaip_miankaije in", values, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeNotIn(List<BigDecimal> values) {
            addCriterion("kaip_miankaije not in", values, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_miankaije between", value1, value2, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaijeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_miankaije not between", value1, value2, "kaipMiankaije");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseIsNull() {
            addCriterion("kaip_miankaise is null");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseIsNotNull() {
            addCriterion("kaip_miankaise is not null");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaise =", value, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseNotEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaise <>", value, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseGreaterThan(BigDecimal value) {
            addCriterion("kaip_miankaise >", value, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaise >=", value, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseLessThan(BigDecimal value) {
            addCriterion("kaip_miankaise <", value, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kaip_miankaise <=", value, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseIn(List<BigDecimal> values) {
            addCriterion("kaip_miankaise in", values, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseNotIn(List<BigDecimal> values) {
            addCriterion("kaip_miankaise not in", values, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_miankaise between", value1, value2, "kaipMiankaise");
            return (Criteria) this;
        }

        public Criteria andKaipMiankaiseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kaip_miankaise not between", value1, value2, "kaipMiankaise");
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