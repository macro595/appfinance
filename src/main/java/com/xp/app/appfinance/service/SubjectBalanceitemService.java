
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.SubjectBalanceitemAO;
import com.xp.app.appfinance.dao.gen.SubjectBalanceitemGeneratedMapper;
import com.xp.app.appfinance.entity.gen.SubjectBalanceitemCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class SubjectBalanceitemService extends AbstractBaseAOService<SubjectBalanceitemAO, SubjectBalanceitemCriteria> implements ISubjectBalanceitemService {

    private static Logger LOG = LoggerFactory.getLogger(SubjectBalanceitemService.class);

    @Resource
    private SubjectBalanceitemGeneratedMapper subjectBalanceitemGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<SubjectBalanceitemAO, SubjectBalanceitemCriteria> getGeneratedMapper() {
        return subjectBalanceitemGeneratedMapper;
    }

}
