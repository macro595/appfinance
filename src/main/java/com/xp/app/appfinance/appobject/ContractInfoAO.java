package com.xp.app.appfinance.appobject;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.xp.app.appfinance.entity.gen.ContractInfo;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * 应用对象 - ContractInfo.
 *
 * <p>
 * 该类于 2016-09-13 15:54:30 首次生成，后由开发手工维护。
 * </p>
 *
 * @author <a href="mailto:DL88250@gmail.com">Liang Ding</a>
 * @version 1.0.0.0, Sep 13, 2016
 */
@JsonSerialize(include = Inclusion.NON_EMPTY)
public final class ContractInfoAO extends ContractInfo implements Serializable {

    /**
     * 默认的序列化 id.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    public String getContractStartDateStr(){
    	return DateTimeUtils.formateDateToStr(this.getContractStartDate(), DateTimeUtils.FORMAT_YMD);
    }
    
    public void setContractStartDateStr(String contractStartDateStr){
    	this.setContractStartDate(DateTimeUtils.parseStrToDate(contractStartDateStr, DateTimeUtils.FORMAT_YMD));
    }
    
    public String getContractEndDateStr(){
    	return DateTimeUtils.formateDateToStr(this.getContractEndDate(), DateTimeUtils.FORMAT_YMD);
    }
    
    public void setContractEndDateStr(String contractEndDateStr){
    	this.setContractEndDate(DateTimeUtils.parseStrToDate(contractEndDateStr, DateTimeUtils.FORMAT_YMD));
    }
    
}
