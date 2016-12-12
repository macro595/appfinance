package com.xp.app.appfinance.entity.gen;

import com.yuanxin.framework.mybatis.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountBalanceSheetCriteria implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    protected Page page;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public AccountBalanceSheetCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public void setOredCriteria(List<Criteria> oredCriteria) {
        this.oredCriteria = oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
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
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public Page getPage() {
        return page;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescIsNull() {
            addCriterion("accountant_course_desc is null");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescIsNotNull() {
            addCriterion("accountant_course_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescEqualTo(String value) {
            addCriterion("accountant_course_desc =", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescNotEqualTo(String value) {
            addCriterion("accountant_course_desc <>", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescGreaterThan(String value) {
            addCriterion("accountant_course_desc >", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescGreaterThanOrEqualTo(String value) {
            addCriterion("accountant_course_desc >=", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescLessThan(String value) {
            addCriterion("accountant_course_desc <", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescLessThanOrEqualTo(String value) {
            addCriterion("accountant_course_desc <=", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescLike(String value) {
            addCriterion("accountant_course_desc like", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescNotLike(String value) {
            addCriterion("accountant_course_desc not like", value, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescIn(List<String> values) {
            addCriterion("accountant_course_desc in", values, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescNotIn(List<String> values) {
            addCriterion("accountant_course_desc not in", values, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescBetween(String value1, String value2) {
            addCriterion("accountant_course_desc between", value1, value2, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseDescNotBetween(String value1, String value2) {
            addCriterion("accountant_course_desc not between", value1, value2, "accountantCourseDesc");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andQichuYueIsNull() {
            addCriterion("qichu_yue is null");
            return (Criteria) this;
        }

        public Criteria andQichuYueIsNotNull() {
            addCriterion("qichu_yue is not null");
            return (Criteria) this;
        }

        public Criteria andQichuYueEqualTo(String value) {
            addCriterion("qichu_yue =", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueNotEqualTo(String value) {
            addCriterion("qichu_yue <>", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueGreaterThan(String value) {
            addCriterion("qichu_yue >", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueGreaterThanOrEqualTo(String value) {
            addCriterion("qichu_yue >=", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueLessThan(String value) {
            addCriterion("qichu_yue <", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueLessThanOrEqualTo(String value) {
            addCriterion("qichu_yue <=", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueLike(String value) {
            addCriterion("qichu_yue like", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueNotLike(String value) {
            addCriterion("qichu_yue not like", value, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueIn(List<String> values) {
            addCriterion("qichu_yue in", values, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueNotIn(List<String> values) {
            addCriterion("qichu_yue not in", values, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueBetween(String value1, String value2) {
            addCriterion("qichu_yue between", value1, value2, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andQichuYueNotBetween(String value1, String value2) {
            addCriterion("qichu_yue not between", value1, value2, "qichuYue");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangIsNull() {
            addCriterion("benqi_jiefang is null");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangIsNotNull() {
            addCriterion("benqi_jiefang is not null");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangEqualTo(String value) {
            addCriterion("benqi_jiefang =", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangNotEqualTo(String value) {
            addCriterion("benqi_jiefang <>", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangGreaterThan(String value) {
            addCriterion("benqi_jiefang >", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangGreaterThanOrEqualTo(String value) {
            addCriterion("benqi_jiefang >=", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangLessThan(String value) {
            addCriterion("benqi_jiefang <", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangLessThanOrEqualTo(String value) {
            addCriterion("benqi_jiefang <=", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangLike(String value) {
            addCriterion("benqi_jiefang like", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangNotLike(String value) {
            addCriterion("benqi_jiefang not like", value, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangIn(List<String> values) {
            addCriterion("benqi_jiefang in", values, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangNotIn(List<String> values) {
            addCriterion("benqi_jiefang not in", values, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangBetween(String value1, String value2) {
            addCriterion("benqi_jiefang between", value1, value2, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiJiefangNotBetween(String value1, String value2) {
            addCriterion("benqi_jiefang not between", value1, value2, "benqiJiefang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangIsNull() {
            addCriterion("benqi_daifang is null");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangIsNotNull() {
            addCriterion("benqi_daifang is not null");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangEqualTo(String value) {
            addCriterion("benqi_daifang =", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangNotEqualTo(String value) {
            addCriterion("benqi_daifang <>", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangGreaterThan(String value) {
            addCriterion("benqi_daifang >", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangGreaterThanOrEqualTo(String value) {
            addCriterion("benqi_daifang >=", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangLessThan(String value) {
            addCriterion("benqi_daifang <", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangLessThanOrEqualTo(String value) {
            addCriterion("benqi_daifang <=", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangLike(String value) {
            addCriterion("benqi_daifang like", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangNotLike(String value) {
            addCriterion("benqi_daifang not like", value, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangIn(List<String> values) {
            addCriterion("benqi_daifang in", values, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangNotIn(List<String> values) {
            addCriterion("benqi_daifang not in", values, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangBetween(String value1, String value2) {
            addCriterion("benqi_daifang between", value1, value2, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andBenqiDaifangNotBetween(String value1, String value2) {
            addCriterion("benqi_daifang not between", value1, value2, "benqiDaifang");
            return (Criteria) this;
        }

        public Criteria andQimoYueIsNull() {
            addCriterion("qimo_yue is null");
            return (Criteria) this;
        }

        public Criteria andQimoYueIsNotNull() {
            addCriterion("qimo_yue is not null");
            return (Criteria) this;
        }

        public Criteria andQimoYueEqualTo(String value) {
            addCriterion("qimo_yue =", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueNotEqualTo(String value) {
            addCriterion("qimo_yue <>", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueGreaterThan(String value) {
            addCriterion("qimo_yue >", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueGreaterThanOrEqualTo(String value) {
            addCriterion("qimo_yue >=", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueLessThan(String value) {
            addCriterion("qimo_yue <", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueLessThanOrEqualTo(String value) {
            addCriterion("qimo_yue <=", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueLike(String value) {
            addCriterion("qimo_yue like", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueNotLike(String value) {
            addCriterion("qimo_yue not like", value, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueIn(List<String> values) {
            addCriterion("qimo_yue in", values, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueNotIn(List<String> values) {
            addCriterion("qimo_yue not in", values, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueBetween(String value1, String value2) {
            addCriterion("qimo_yue between", value1, value2, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andQimoYueNotBetween(String value1, String value2) {
            addCriterion("qimo_yue not between", value1, value2, "qimoYue");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseIsNull() {
            addCriterion("accountant_course is null");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseIsNotNull() {
            addCriterion("accountant_course is not null");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseEqualTo(String value) {
            addCriterion("accountant_course =", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseNotEqualTo(String value) {
            addCriterion("accountant_course <>", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseGreaterThan(String value) {
            addCriterion("accountant_course >", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseGreaterThanOrEqualTo(String value) {
            addCriterion("accountant_course >=", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseLessThan(String value) {
            addCriterion("accountant_course <", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseLessThanOrEqualTo(String value) {
            addCriterion("accountant_course <=", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseLike(String value) {
            addCriterion("accountant_course like", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseNotLike(String value) {
            addCriterion("accountant_course not like", value, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseIn(List<String> values) {
            addCriterion("accountant_course in", values, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseNotIn(List<String> values) {
            addCriterion("accountant_course not in", values, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseBetween(String value1, String value2) {
            addCriterion("accountant_course between", value1, value2, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andAccountantCourseNotBetween(String value1, String value2) {
            addCriterion("accountant_course not between", value1, value2, "accountantCourse");
            return (Criteria) this;
        }

        public Criteria andYearNumIsNull() {
            addCriterion("year_num is null");
            return (Criteria) this;
        }

        public Criteria andYearNumIsNotNull() {
            addCriterion("year_num is not null");
            return (Criteria) this;
        }

        public Criteria andYearNumEqualTo(String value) {
            addCriterion("year_num =", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumNotEqualTo(String value) {
            addCriterion("year_num <>", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumGreaterThan(String value) {
            addCriterion("year_num >", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumGreaterThanOrEqualTo(String value) {
            addCriterion("year_num >=", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumLessThan(String value) {
            addCriterion("year_num <", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumLessThanOrEqualTo(String value) {
            addCriterion("year_num <=", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumLike(String value) {
            addCriterion("year_num like", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumNotLike(String value) {
            addCriterion("year_num not like", value, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumIn(List<String> values) {
            addCriterion("year_num in", values, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumNotIn(List<String> values) {
            addCriterion("year_num not in", values, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumBetween(String value1, String value2) {
            addCriterion("year_num between", value1, value2, "yearNum");
            return (Criteria) this;
        }

        public Criteria andYearNumNotBetween(String value1, String value2) {
            addCriterion("year_num not between", value1, value2, "yearNum");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_account_balance_sheet
     *
     * @mbggenerated
     */
    public static class Criterion implements Serializable {
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