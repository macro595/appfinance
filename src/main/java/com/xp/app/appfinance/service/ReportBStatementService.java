
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.ReportBudgeStatementAO;
import com.xp.app.appfinance.appobject.ReportCaiwushouzhiAO;
import com.xp.app.appfinance.dao.gen.ReportBudgeStatementGeneratedMapper;
import com.xp.app.appfinance.dao.gen.ReportCaiwushouzhiGeneratedMapper;
import com.xp.app.appfinance.entity.gen.ReportBudgeStatementCriteria;
import com.xp.app.appfinance.entity.gen.ReportCaiwushouzhiCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class ReportBStatementService extends AbstractBaseAOService<ReportBudgeStatementAO, ReportBudgeStatementCriteria> implements IReportBStatementService {

    private static Logger LOG = LoggerFactory.getLogger(ReportBStatementService.class);

    @Resource
    private ReportBudgeStatementGeneratedMapper reportBudgeStatementGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ReportBudgeStatementAO, ReportBudgeStatementCriteria> getGeneratedMapper() {
        return reportBudgeStatementGeneratedMapper;
    }

}
