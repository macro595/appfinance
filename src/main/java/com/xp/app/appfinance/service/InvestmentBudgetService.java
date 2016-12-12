
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.InvestmentBudgetAO;
import com.xp.app.appfinance.dao.gen.InvestmentBudgetGeneratedMapper;
import com.xp.app.appfinance.entity.gen.InvestmentBudgetCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class InvestmentBudgetService extends AbstractBaseAOService<InvestmentBudgetAO, InvestmentBudgetCriteria> implements IInvestmentBudgetService {

    private static Logger LOG = LoggerFactory.getLogger(InvestmentBudgetService.class);

    @Resource
    private InvestmentBudgetGeneratedMapper investmentBudgetGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<InvestmentBudgetAO, InvestmentBudgetCriteria> getGeneratedMapper() {
        return investmentBudgetGeneratedMapper;
    }

}
