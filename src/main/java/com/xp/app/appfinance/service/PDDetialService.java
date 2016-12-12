
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.PDDetailAO;
import com.xp.app.appfinance.dao.gen.PDDetailGeneratedMapper;
import com.xp.app.appfinance.entity.gen.PDDetailCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class PDDetialService extends AbstractBaseAOService<PDDetailAO, PDDetailCriteria> implements IPDDetailService {

    private static Logger LOG = LoggerFactory.getLogger(PDDetialService.class);

    @Resource
    private PDDetailGeneratedMapper pDDetailGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<PDDetailAO, PDDetailCriteria> getGeneratedMapper() {
        return pDDetailGeneratedMapper;
    }

}
