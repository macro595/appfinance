package com.xp.app.appfinance.entity.gen;

import java.io.Serializable;

public class PDDetail extends PDDetailKey implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.pamount
     *
     * @mbggenerated
     */
    private String pamount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.subjec_parent_code
     *
     * @mbggenerated
     */
    private String subjecParentCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.subject_code
     *
     * @mbggenerated
     */
    private String subjectCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.subject_name
     *
     * @mbggenerated
     */
    private String subjectName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.subject_unit
     *
     * @mbggenerated
     */
    private String subjectUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.value
     *
     * @mbggenerated
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.actual
     *
     * @mbggenerated
     */
    private String actual;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.Cumulative_budget
     *
     * @mbggenerated
     */
    private String cumulativeBudget;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_production_dataprediction_detail.Cumulative_actual
     *
     * @mbggenerated
     */
    private String cumulativeActual;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_production_dataprediction_detail
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.id
     *
     * @return the value of t_production_dataprediction_detail.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.id
     *
     * @param id the value for t_production_dataprediction_detail.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.pamount
     *
     * @return the value of t_production_dataprediction_detail.pamount
     *
     * @mbggenerated
     */
    public String getPamount() {
        return pamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.pamount
     *
     * @param pamount the value for t_production_dataprediction_detail.pamount
     *
     * @mbggenerated
     */
    public void setPamount(String pamount) {
        this.pamount = pamount == null ? null : pamount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.subjec_parent_code
     *
     * @return the value of t_production_dataprediction_detail.subjec_parent_code
     *
     * @mbggenerated
     */
    public String getSubjecParentCode() {
        return subjecParentCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.subjec_parent_code
     *
     * @param subjecParentCode the value for t_production_dataprediction_detail.subjec_parent_code
     *
     * @mbggenerated
     */
    public void setSubjecParentCode(String subjecParentCode) {
        this.subjecParentCode = subjecParentCode == null ? null : subjecParentCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.subject_code
     *
     * @return the value of t_production_dataprediction_detail.subject_code
     *
     * @mbggenerated
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.subject_code
     *
     * @param subjectCode the value for t_production_dataprediction_detail.subject_code
     *
     * @mbggenerated
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode == null ? null : subjectCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.subject_name
     *
     * @return the value of t_production_dataprediction_detail.subject_name
     *
     * @mbggenerated
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.subject_name
     *
     * @param subjectName the value for t_production_dataprediction_detail.subject_name
     *
     * @mbggenerated
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.subject_unit
     *
     * @return the value of t_production_dataprediction_detail.subject_unit
     *
     * @mbggenerated
     */
    public String getSubjectUnit() {
        return subjectUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.subject_unit
     *
     * @param subjectUnit the value for t_production_dataprediction_detail.subject_unit
     *
     * @mbggenerated
     */
    public void setSubjectUnit(String subjectUnit) {
        this.subjectUnit = subjectUnit == null ? null : subjectUnit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.value
     *
     * @return the value of t_production_dataprediction_detail.value
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.value
     *
     * @param value the value for t_production_dataprediction_detail.value
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.actual
     *
     * @return the value of t_production_dataprediction_detail.actual
     *
     * @mbggenerated
     */
    public String getActual() {
        return actual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.actual
     *
     * @param actual the value for t_production_dataprediction_detail.actual
     *
     * @mbggenerated
     */
    public void setActual(String actual) {
        this.actual = actual == null ? null : actual.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.Cumulative_budget
     *
     * @return the value of t_production_dataprediction_detail.Cumulative_budget
     *
     * @mbggenerated
     */
    public String getCumulativeBudget() {
        return cumulativeBudget;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.Cumulative_budget
     *
     * @param cumulativeBudget the value for t_production_dataprediction_detail.Cumulative_budget
     *
     * @mbggenerated
     */
    public void setCumulativeBudget(String cumulativeBudget) {
        this.cumulativeBudget = cumulativeBudget == null ? null : cumulativeBudget.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_production_dataprediction_detail.Cumulative_actual
     *
     * @return the value of t_production_dataprediction_detail.Cumulative_actual
     *
     * @mbggenerated
     */
    public String getCumulativeActual() {
        return cumulativeActual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_production_dataprediction_detail.Cumulative_actual
     *
     * @param cumulativeActual the value for t_production_dataprediction_detail.Cumulative_actual
     *
     * @mbggenerated
     */
    public void setCumulativeActual(String cumulativeActual) {
        this.cumulativeActual = cumulativeActual == null ? null : cumulativeActual.trim();
    }
}