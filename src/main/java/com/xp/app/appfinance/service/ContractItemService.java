
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.ContractItemAO;
import com.xp.app.appfinance.dao.gen.ContractItemGeneratedMapper;
import com.xp.app.appfinance.entity.gen.ContractItemCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class ContractItemService extends AbstractBaseAOService<ContractItemAO, ContractItemCriteria> implements IContractItemService {

    private static Logger LOG = LoggerFactory.getLogger(ContractItemService.class);

    @Resource
    private ContractItemGeneratedMapper contractItemGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ContractItemAO, ContractItemCriteria> getGeneratedMapper() {
        return contractItemGeneratedMapper;
    }

}
