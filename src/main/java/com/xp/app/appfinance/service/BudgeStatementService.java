
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.BudgeStatementAO;
import com.xp.app.appfinance.dao.gen.BudgeStatementGeneratedMapper;
import com.xp.app.appfinance.entity.gen.BudgeStatementCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class BudgeStatementService extends AbstractBaseAOService<BudgeStatementAO, BudgeStatementCriteria> implements IBudgeStatementService {

    private static Logger LOG = LoggerFactory.getLogger(BudgeStatementService.class);

    @Resource
    private BudgeStatementGeneratedMapper budgeStatementMapper;

    @Override
    protected BaseGeneratedMapper<BudgeStatementAO, BudgeStatementCriteria> getGeneratedMapper() {
        return budgeStatementMapper;
    }

}
