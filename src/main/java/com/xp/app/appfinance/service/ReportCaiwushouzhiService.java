
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.ReportCaiwushouzhiAO;
import com.xp.app.appfinance.dao.gen.ReportCaiwushouzhiGeneratedMapper;
import com.xp.app.appfinance.entity.gen.ReportCaiwushouzhiCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class ReportCaiwushouzhiService extends AbstractBaseAOService<ReportCaiwushouzhiAO, ReportCaiwushouzhiCriteria> implements IReportCaiwushouzhiService {

    private static Logger LOG = LoggerFactory.getLogger(ReportCaiwushouzhiService.class);

    @Resource
    private ReportCaiwushouzhiGeneratedMapper reportCaiwushouzhiGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ReportCaiwushouzhiAO, ReportCaiwushouzhiCriteria> getGeneratedMapper() {
        return reportCaiwushouzhiGeneratedMapper;
    }

}
