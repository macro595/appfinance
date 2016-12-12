
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.ShouzhiShijiAO;
import com.xp.app.appfinance.dao.gen.ShouzhiShijiGeneratedMapper;
import com.xp.app.appfinance.entity.gen.ShouzhiShijiCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class ShouzhiShijiService extends AbstractBaseAOService<ShouzhiShijiAO, ShouzhiShijiCriteria> implements IShouzhiShijiService {

    private static Logger LOG = LoggerFactory.getLogger(ShouzhiShijiService.class);

    @Resource
    private ShouzhiShijiGeneratedMapper shouzhiShijiGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ShouzhiShijiAO, ShouzhiShijiCriteria> getGeneratedMapper() {
        return shouzhiShijiGeneratedMapper;
    }

}
