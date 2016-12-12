
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.BABudgetDetailAO;
import com.xp.app.appfinance.dao.gen.BABudgetDetailGeneratedMapper;
import com.xp.app.appfinance.entity.gen.BABudgetDetailCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class DetailOfBABudgetService extends AbstractBaseAOService<BABudgetDetailAO, BABudgetDetailCriteria> implements IDetailOfBABudgetService {

    private static Logger LOG = LoggerFactory.getLogger(DetailOfBABudgetService.class);

    @Resource
    private BABudgetDetailGeneratedMapper bABudgetDetailGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<BABudgetDetailAO, BABudgetDetailCriteria> getGeneratedMapper() {
        return bABudgetDetailGeneratedMapper;
    }

}
