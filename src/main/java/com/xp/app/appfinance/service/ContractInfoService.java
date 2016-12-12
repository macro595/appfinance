package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.ContractInfoAO;
import com.xp.app.appfinance.dao.gen.ContractInfoGeneratedMapper;
import com.xp.app.appfinance.entity.gen.ContractInfoCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class ContractInfoService extends AbstractBaseAOService<ContractInfoAO, ContractInfoCriteria> implements IContractInfoService {

    private static Logger LOG = LoggerFactory.getLogger(ContractInfoService.class);

    @Resource
    private ContractInfoGeneratedMapper contractInfoGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ContractInfoAO, ContractInfoCriteria> getGeneratedMapper() {
        return contractInfoGeneratedMapper;
    }

}
