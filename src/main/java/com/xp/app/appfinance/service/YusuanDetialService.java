
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.YusuanDetialAO;
import com.xp.app.appfinance.dao.gen.YusuanDetialGeneratedMapper;
import com.xp.app.appfinance.entity.gen.YusuanDetialCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class YusuanDetialService extends AbstractBaseAOService<YusuanDetialAO, YusuanDetialCriteria> implements IYusuanDetialService {

    private static Logger LOG = LoggerFactory.getLogger(YusuanDetialService.class);

    @Resource
    private YusuanDetialGeneratedMapper yusuanDetialGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<YusuanDetialAO, YusuanDetialCriteria> getGeneratedMapper() {
        return yusuanDetialGeneratedMapper;
    }

}
