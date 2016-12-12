package com.xp.app.appfinance.appobject;

import java.io.Serializable;
import com.xp.app.appfinance.entity.gen.SubjectBalanceitem;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * 应用对象 - SubjectBalanceitem.
 *
 * <p>
 * 该类于 2016-10-10 14:00:29 首次生成，后由开发手工维护。
 * </p>
 *
 * @author <a href="mailto:DL88250@gmail.com">Liang Ding</a>
 * @version 1.0.0.0, Oct 10, 2016
 */
@JsonSerialize(include = Inclusion.NON_EMPTY)
public final class SubjectBalanceitemAO extends SubjectBalanceitem implements Serializable {

    /**
     * 默认的序列化 id.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
