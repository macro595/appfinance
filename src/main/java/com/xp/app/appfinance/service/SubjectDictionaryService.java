
package com.xp.app.appfinance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xp.app.appfinance.appobject.SubjectDictionaryAO;
import com.xp.app.appfinance.dao.gen.SubjectDictionaryGeneratedMapper;
import com.xp.app.appfinance.entity.gen.SubjectDictionaryCriteria;
import com.yuanxin.common.dao.base.BaseGeneratedMapper;
import com.yuanxin.common.service.base.AbstractBaseAOService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;


@Service
public class SubjectDictionaryService extends AbstractBaseAOService<SubjectDictionaryAO, SubjectDictionaryCriteria> implements ISubjectDictionaryService {

    private static Logger LOG = LoggerFactory.getLogger(SubjectDictionaryService.class);

    @Resource
    private SubjectDictionaryGeneratedMapper subjectDictionaryGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<SubjectDictionaryAO, SubjectDictionaryCriteria> getGeneratedMapper() {
        return subjectDictionaryGeneratedMapper;
    }

}
