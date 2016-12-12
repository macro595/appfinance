
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.BABudgetAO;
import com.xp.app.appfinance.appobject.YuSuanAO;
import com.xp.app.appfinance.dao.gen.BABudgetGeneratedMapper;
import com.xp.app.appfinance.dao.gen.YuSuanGeneratedMapper;
import com.xp.app.appfinance.entity.gen.BABudgetCriteria;
import com.xp.app.appfinance.entity.gen.YuSuanCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class BABudgetService extends AbstractBaseAOService<BABudgetAO, BABudgetCriteria> implements IBABudgetService {

    private static Logger LOG = LoggerFactory.getLogger(BABudgetService.class);

    @Resource
    private BABudgetGeneratedMapper bABudgetGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<BABudgetAO, BABudgetCriteria> getGeneratedMapper() {
        return bABudgetGeneratedMapper;
    }

}
