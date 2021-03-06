package com.xp.app.appfinance.appobject;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.xp.app.appfinance.entity.gen.FinanceSuject;

/**
 * 应用对象 - FinanceSuject.
 *
 * <p>
 * 该类于 2016-08-22 17:40:01 首次生成，后由开发手工维护。
 * </p>
 *
 * @author <a href="mailto:DL88250@gmail.com">Liang Ding</a>
 * @version 1.0.0.0, Aug 22, 2016
 */
@JsonSerialize(include = Inclusion.NON_EMPTY)
public final class FinanceSujectAO extends FinanceSuject implements Serializable {

	public List hnaList;
    /**
     * 默认的序列化 id.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

	/**
	 * @return the hnaList
	 */
	public List getHnaList() {
		return hnaList;
	}

	/**
	 * @param hnaList the hnaList to set
	 */
	public void setHnaList(List hnaList) {
		this.hnaList = hnaList;
	}
    
    
}
