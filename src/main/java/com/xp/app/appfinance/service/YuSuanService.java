
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.YuSuanAO;
import com.xp.app.appfinance.dao.gen.YuSuanGeneratedMapper;
import com.xp.app.appfinance.entity.gen.YuSuanCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class YuSuanService extends AbstractBaseAOService<YuSuanAO, YuSuanCriteria> implements IYuSuanService {

    private static Logger LOG = LoggerFactory.getLogger(YuSuanService.class);

    @Resource
    private YuSuanGeneratedMapper yuSuanGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<YuSuanAO, YuSuanCriteria> getGeneratedMapper() {
        return yuSuanGeneratedMapper;
    }

}
