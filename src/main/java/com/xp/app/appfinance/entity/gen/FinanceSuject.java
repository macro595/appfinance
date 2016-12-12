package com.xp.app.appfinance.entity.gen;

import java.io.Serializable;

public class FinanceSuject implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.subject_name
     *
     * @mbggenerated
     */
    private String subjectName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.subject_code
     *
     * @mbggenerated
     */
    private String subjectCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.subject_parent_code
     *
     * @mbggenerated
     */
    private String subjectParentCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.subject_parent_name
     *
     * @mbggenerated
     */
    private String subjectParentName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.subject_type
     *
     * @mbggenerated
     */
    private String subjectType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_finance_suject.sort
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_finance_suject
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.id
     *
     * @return the value of t_finance_suject.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.id
     *
     * @param id the value for t_finance_suject.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.subject_name
     *
     * @return the value of t_finance_suject.subject_name
     *
     * @mbggenerated
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.subject_name
     *
     * @param subjectName the value for t_finance_suject.subject_name
     *
     * @mbggenerated
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.subject_code
     *
     * @return the value of t_finance_suject.subject_code
     *
     * @mbggenerated
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.subject_code
     *
     * @param subjectCode the value for t_finance_suject.subject_code
     *
     * @mbggenerated
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode == null ? null : subjectCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.subject_parent_code
     *
     * @return the value of t_finance_suject.subject_parent_code
     *
     * @mbggenerated
     */
    public String getSubjectParentCode() {
        return subjectParentCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.subject_parent_code
     *
     * @param subjectParentCode the value for t_finance_suject.subject_parent_code
     *
     * @mbggenerated
     */
    public void setSubjectParentCode(String subjectParentCode) {
        this.subjectParentCode = subjectParentCode == null ? null : subjectParentCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.subject_parent_name
     *
     * @return the value of t_finance_suject.subject_parent_name
     *
     * @mbggenerated
     */
    public String getSubjectParentName() {
        return subjectParentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.subject_parent_name
     *
     * @param subjectParentName the value for t_finance_suject.subject_parent_name
     *
     * @mbggenerated
     */
    public void setSubjectParentName(String subjectParentName) {
        this.subjectParentName = subjectParentName == null ? null : subjectParentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.status
     *
     * @return the value of t_finance_suject.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.status
     *
     * @param status the value for t_finance_suject.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.subject_type
     *
     * @return the value of t_finance_suject.subject_type
     *
     * @mbggenerated
     */
    public String getSubjectType() {
        return subjectType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.subject_type
     *
     * @param subjectType the value for t_finance_suject.subject_type
     *
     * @mbggenerated
     */
    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_finance_suject.sort
     *
     * @return the value of t_finance_suject.sort
     *
     * @mbggenerated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_finance_suject.sort
     *
     * @param sort the value for t_finance_suject.sort
     *
     * @mbggenerated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}