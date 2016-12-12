/*
 * Copyright (c) 2012-2013, chxiao Co., Ltd.
 * 
 * All rights reserved.
 */
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.TwAccountAO;
import com.xp.app.appfinance.dao.gen.TwAccountGeneratedMapper;
import com.xp.app.appfinance.entity.gen.TwAccountCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class TwAccountService extends AbstractBaseAOService<TwAccountAO, TwAccountCriteria> implements ITwAccountService {

    private static Logger LOG = LoggerFactory.getLogger(TwAccountService.class);

    @Resource
    private TwAccountGeneratedMapper twAccountGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<TwAccountAO, TwAccountCriteria> getGeneratedMapper() {
        return twAccountGeneratedMapper;
    }

}
