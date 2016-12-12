
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.PDDetailAO;
import com.xp.app.appfinance.appobject.ProducDataAO;
import com.xp.app.appfinance.dao.gen.ProducDataGeneratedMapper;
import com.xp.app.appfinance.entity.gen.PDDetailCriteria;
import com.xp.app.appfinance.entity.gen.ProducDataCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class ProducDataService extends AbstractBaseAOService<ProducDataAO, ProducDataCriteria> implements IProducDataService {

    private static Logger LOG = LoggerFactory.getLogger(ProducDataService.class);

    @Resource
    private ProducDataGeneratedMapper producDataGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ProducDataAO, ProducDataCriteria> getGeneratedMapper() {
        return producDataGeneratedMapper;
    }

}
