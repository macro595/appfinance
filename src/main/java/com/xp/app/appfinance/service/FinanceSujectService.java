package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.FinanceSujectAO;
import com.xp.app.appfinance.dao.gen.FinanceSujectGeneratedMapper;
import com.xp.app.appfinance.entity.gen.FinanceSujectCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class FinanceSujectService extends AbstractBaseAOService<FinanceSujectAO, FinanceSujectCriteria> implements IFinanceSujectService {

    private static Logger LOG = LoggerFactory.getLogger(FinanceSujectService.class);

    @Resource
    private FinanceSujectGeneratedMapper financeSujectGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<FinanceSujectAO, FinanceSujectCriteria> getGeneratedMapper() {
        return financeSujectGeneratedMapper;
    }

}
