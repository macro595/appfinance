package com.xp.app.appfinance.entity.gen;

import java.io.Serializable;

public class BABudgetDetail implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_business_activity_budget_detial.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_business_activity_budget_detial.yusuan_id
     *
     * @mbggenerated
     */
    private String yusuanId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_business_activity_budget_detial.MONTH
     *
     * @mbggenerated
     */
    private String month;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_business_activity_budget_detial.value
     *
     * @mbggenerated
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_business_activity_budget_detial.actual
     *
     * @mbggenerated
     */
    private String actual;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_business_activity_budget_detial.cur_month_account
     *
     * @mbggenerated
     */
    private String curMonthAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_business_activity_budget_detial
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_business_activity_budget_detial.id
     *
     * @return the value of t_business_activity_budget_detial.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_business_activity_budget_detial.id
     *
     * @param id the value for t_business_activity_budget_detial.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_business_activity_budget_detial.yusuan_id
     *
     * @return the value of t_business_activity_budget_detial.yusuan_id
     *
     * @mbggenerated
     */
    public String getYusuanId() {
        return yusuanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_business_activity_budget_detial.yusuan_id
     *
     * @param yusuanId the value for t_business_activity_budget_detial.yusuan_id
     *
     * @mbggenerated
     */
    public void setYusuanId(String yusuanId) {
        this.yusuanId = yusuanId == null ? null : yusuanId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_business_activity_budget_detial.MONTH
     *
     * @return the value of t_business_activity_budget_detial.MONTH
     *
     * @mbggenerated
     */
    public String getMonth() {
        return month;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_business_activity_budget_detial.MONTH
     *
     * @param month the value for t_business_activity_budget_detial.MONTH
     *
     * @mbggenerated
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_business_activity_budget_detial.value
     *
     * @return the value of t_business_activity_budget_detial.value
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_business_activity_budget_detial.value
     *
     * @param value the value for t_business_activity_budget_detial.value
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_business_activity_budget_detial.actual
     *
     * @return the value of t_business_activity_budget_detial.actual
     *
     * @mbggenerated
     */
    public String getActual() {
        return actual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_business_activity_budget_detial.actual
     *
     * @param actual the value for t_business_activity_budget_detial.actual
     *
     * @mbggenerated
     */
    public void setActual(String actual) {
        this.actual = actual == null ? null : actual.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_business_activity_budget_detial.cur_month_account
     *
     * @return the value of t_business_activity_budget_detial.cur_month_account
     *
     * @mbggenerated
     */
    public String getCurMonthAccount() {
        return curMonthAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_business_activity_budget_detial.cur_month_account
     *
     * @param curMonthAccount the value for t_business_activity_budget_detial.cur_month_account
     *
     * @mbggenerated
     */
    public void setCurMonthAccount(String curMonthAccount) {
        this.curMonthAccount = curMonthAccount == null ? null : curMonthAccount.trim();
    }
}