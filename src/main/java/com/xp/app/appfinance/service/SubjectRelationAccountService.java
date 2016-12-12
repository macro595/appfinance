
package com.xp.app.appfinance.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.SubjectRelationAccountAO;
import com.xp.app.appfinance.dao.gen.SubjectRelationAccountGeneratedMapper;
import com.xp.app.appfinance.entity.gen.SubjectRelationAccountCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class SubjectRelationAccountService extends AbstractBaseAOService<SubjectRelationAccountAO, SubjectRelationAccountCriteria> implements ISubjectRelationAccountService {

    private static Logger LOG = LoggerFactory.getLogger(SubjectRelationAccountService.class);

    @Resource
    private SubjectRelationAccountGeneratedMapper subjectRelationAccountGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<SubjectRelationAccountAO, SubjectRelationAccountCriteria> getGeneratedMapper() {
        return subjectRelationAccountGeneratedMapper;
    }

}
