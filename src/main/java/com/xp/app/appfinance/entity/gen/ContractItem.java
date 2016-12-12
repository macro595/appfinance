package com.xp.app.appfinance.entity.gen;

import java.io.Serializable;
import java.util.Date;

public class ContractItem implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contract_item.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contract_item.date_line
     *
     * @mbggenerated
     */
    private Date dateLine;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contract_item.yingshou
     *
     * @mbggenerated
     */
    private String yingshou;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contract_item.item_type
     *
     * @mbggenerated
     */
    private String itemType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contract_item.create_date
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_contract_item.contract_info_id
     *
     * @mbggenerated
     */
    private String contractInfoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_contract_item
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contract_item.id
     *
     * @return the value of t_contract_item.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contract_item.id
     *
     * @param id the value for t_contract_item.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contract_item.date_line
     *
     * @return the value of t_contract_item.date_line
     *
     * @mbggenerated
     */
    public Date getDateLine() {
        return dateLine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contract_item.date_line
     *
     * @param dateLine the value for t_contract_item.date_line
     *
     * @mbggenerated
     */
    public void setDateLine(Date dateLine) {
        this.dateLine = dateLine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contract_item.yingshou
     *
     * @return the value of t_contract_item.yingshou
     *
     * @mbggenerated
     */
    public String getYingshou() {
        return yingshou;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contract_item.yingshou
     *
     * @param yingshou the value for t_contract_item.yingshou
     *
     * @mbggenerated
     */
    public void setYingshou(String yingshou) {
        this.yingshou = yingshou == null ? null : yingshou.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contract_item.item_type
     *
     * @return the value of t_contract_item.item_type
     *
     * @mbggenerated
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contract_item.item_type
     *
     * @param itemType the value for t_contract_item.item_type
     *
     * @mbggenerated
     */
    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contract_item.create_date
     *
     * @return the value of t_contract_item.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contract_item.create_date
     *
     * @param createDate the value for t_contract_item.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_contract_item.contract_info_id
     *
     * @return the value of t_contract_item.contract_info_id
     *
     * @mbggenerated
     */
    public String getContractInfoId() {
        return contractInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_contract_item.contract_info_id
     *
     * @param contractInfoId the value for t_contract_item.contract_info_id
     *
     * @mbggenerated
     */
    public void setContractInfoId(String contractInfoId) {
        this.contractInfoId = contractInfoId == null ? null : contractInfoId.trim();
    }
}