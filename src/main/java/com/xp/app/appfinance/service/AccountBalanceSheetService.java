/*
 * Copyright (c) 2012-2013, chzh.xiao Co., Ltd.
 * 
 * All rights reserved.
 */
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.AccountBalanceSheetAO;
import com.xp.app.appfinance.dao.gen.AccountBalanceSheetGeneratedMapper;
import com.xp.app.appfinance.entity.gen.AccountBalanceSheetCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class AccountBalanceSheetService extends AbstractBaseAOService<AccountBalanceSheetAO, AccountBalanceSheetCriteria> implements IAccountBalanceSheetService {

    private static Logger LOG = LoggerFactory.getLogger(AccountBalanceSheetService.class);

    @Resource
    private AccountBalanceSheetGeneratedMapper accountBalanceSheetGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<AccountBalanceSheetAO, AccountBalanceSheetCriteria> getGeneratedMapper() {
        return accountBalanceSheetGeneratedMapper;
    }

}
