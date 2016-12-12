package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.AccountBalanceItemAO;
import com.xp.app.appfinance.dao.gen.AccountBalanceItemGeneratedMapper;
import com.xp.app.appfinance.entity.gen.AccountBalanceItemCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class AccountBalanceItemService extends AbstractBaseAOService<AccountBalanceItemAO, AccountBalanceItemCriteria> implements IAccountBalanceItemService {

    private static Logger LOG = LoggerFactory.getLogger(AccountBalanceItemService.class);

    @Resource
    private AccountBalanceItemGeneratedMapper accountBalanceItemGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<AccountBalanceItemAO, AccountBalanceItemCriteria> getGeneratedMapper() {
        return accountBalanceItemGeneratedMapper;
    }

}
