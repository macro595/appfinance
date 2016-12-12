package com.xp.app.appfinance.entity.gen;

import com.yuanxin.framework.mybatis.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractItemCriteria implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    protected Page page;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public ContractItemCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public void setOredCriteria(List<Criteria> oredCriteria) {
        this.oredCriteria = oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
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
     * This method corresponds to the database table t_contract_item
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
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
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
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public void setPage(Page page) {
        this.page=page;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    public Page getPage() {
        return page;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_contract_item
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

        public Criteria andDateLineIsNull() {
            addCriterion("date_line is null");
            return (Criteria) this;
        }

        public Criteria andDateLineIsNotNull() {
            addCriterion("date_line is not null");
            return (Criteria) this;
        }

        public Criteria andDateLineEqualTo(Date value) {
            addCriterion("date_line =", value, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineNotEqualTo(Date value) {
            addCriterion("date_line <>", value, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineGreaterThan(Date value) {
            addCriterion("date_line >", value, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineGreaterThanOrEqualTo(Date value) {
            addCriterion("date_line >=", value, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineLessThan(Date value) {
            addCriterion("date_line <", value, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineLessThanOrEqualTo(Date value) {
            addCriterion("date_line <=", value, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineIn(List<Date> values) {
            addCriterion("date_line in", values, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineNotIn(List<Date> values) {
            addCriterion("date_line not in", values, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineBetween(Date value1, Date value2) {
            addCriterion("date_line between", value1, value2, "dateLine");
            return (Criteria) this;
        }

        public Criteria andDateLineNotBetween(Date value1, Date value2) {
            addCriterion("date_line not between", value1, value2, "dateLine");
            return (Criteria) this;
        }

        public Criteria andYingshouIsNull() {
            addCriterion("yingshou is null");
            return (Criteria) this;
        }

        public Criteria andYingshouIsNotNull() {
            addCriterion("yingshou is not null");
            return (Criteria) this;
        }

        public Criteria andYingshouEqualTo(String value) {
            addCriterion("yingshou =", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouNotEqualTo(String value) {
            addCriterion("yingshou <>", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouGreaterThan(String value) {
            addCriterion("yingshou >", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouGreaterThanOrEqualTo(String value) {
            addCriterion("yingshou >=", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouLessThan(String value) {
            addCriterion("yingshou <", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouLessThanOrEqualTo(String value) {
            addCriterion("yingshou <=", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouLike(String value) {
            addCriterion("yingshou like", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouNotLike(String value) {
            addCriterion("yingshou not like", value, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouIn(List<String> values) {
            addCriterion("yingshou in", values, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouNotIn(List<String> values) {
            addCriterion("yingshou not in", values, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouBetween(String value1, String value2) {
            addCriterion("yingshou between", value1, value2, "yingshou");
            return (Criteria) this;
        }

        public Criteria andYingshouNotBetween(String value1, String value2) {
            addCriterion("yingshou not between", value1, value2, "yingshou");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("item_type like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("item_type not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
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

        public Criteria andContractInfoIdIsNull() {
            addCriterion("contract_info_id is null");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdIsNotNull() {
            addCriterion("contract_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdEqualTo(String value) {
            addCriterion("contract_info_id =", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdNotEqualTo(String value) {
            addCriterion("contract_info_id <>", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdGreaterThan(String value) {
            addCriterion("contract_info_id >", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_info_id >=", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdLessThan(String value) {
            addCriterion("contract_info_id <", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdLessThanOrEqualTo(String value) {
            addCriterion("contract_info_id <=", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdLike(String value) {
            addCriterion("contract_info_id like", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdNotLike(String value) {
            addCriterion("contract_info_id not like", value, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdIn(List<String> values) {
            addCriterion("contract_info_id in", values, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdNotIn(List<String> values) {
            addCriterion("contract_info_id not in", values, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdBetween(String value1, String value2) {
            addCriterion("contract_info_id between", value1, value2, "contractInfoId");
            return (Criteria) this;
        }

        public Criteria andContractInfoIdNotBetween(String value1, String value2) {
            addCriterion("contract_info_id not between", value1, value2, "contractInfoId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_contract_item
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
     * This class corresponds to the database table t_contract_item
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