/*
 * Copyright (c) 2012, chzh.xiao Co., Ltd.
 *
 * All rights reserved.
 */
package com.xp.app.appfinance.controller.pc.caiwu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xp.app.appfinance.appobject.AccountBalanceItemAO;
import com.xp.app.appfinance.appobject.FinanceSujectAO;
import com.xp.app.appfinance.appobject.SubjectBalanceitemAO;
import com.xp.app.appfinance.appobject.SubjectRelationAccountAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.AccountBalanceItemCriteria;
import com.xp.app.appfinance.entity.gen.FinanceSujectCriteria;
import com.xp.app.appfinance.entity.gen.SubjectBalanceitemCriteria;
import com.xp.app.appfinance.entity.gen.SubjectRelationAccountCriteria;
import com.xp.app.appfinance.service.IAccountBalanceItemService;
import com.xp.app.appfinance.service.IFinanceSujectService;
import com.xp.app.appfinance.service.ISubjectBalanceitemService;
import com.xp.app.appfinance.service.ISubjectRelationAccountService;
import com.xp.app.appfinance.util.Constant;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * FinanceSuject控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/financesuject")
public class FinanceSujectController {
	
	@Resource
	IFinanceSujectService financeSujectService;
	
	@Resource
	IAccountBalanceItemService accountBalanceItemService;
	
	@Resource
	ISubjectRelationAccountService subjectRelationAccountService;
	
	@Resource
	ISubjectBalanceitemService subjectBalanceitemService;

    private static Logger LOG = LoggerFactory.getLogger(FinanceSujectController.class);

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getHello(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        
        
        FinanceSujectCriteria fsc = new FinanceSujectCriteria();
        fsc.createCriteria().andStatusEqualTo(Constant.DATA_VALID);
        ServiceResult<List<FinanceSujectAO>> datalist = financeSujectService.selectByCriteria(fsc);
        if(datalist!=null&& datalist.getData()!=null&& datalist.getData().size()>0){
        	model.addAttribute("datalist", datalist.getData());
        }else{
        	model.addAttribute("datalist", new ArrayList());
        }
        
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        mv.setViewName(MVCViewName.APP_APPFINANCE_PC_YUSUANZHIXING_SUBJECTCONFIG.toString());
        return mv;
    }
    
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        FinanceSujectAO fsa = new FinanceSujectAO();
        fsa.setStatus(Constant.DATA_INVALID);
        financeSujectService.saveOrUpdate(fsa);
        return "redirect:/pc/financesuject/showform/" + fsa.getId();
    }  
    
    @RequestMapping(value = "/showform/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView showform(@PathVariable String id , Model model, HttpServletRequest request) {
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前时间传到前端
    	model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
    	//将当前运用名称传到前端
    	ServiceResult<FinanceSujectAO> dataAO = financeSujectService.getById(id);
    	
    	model.addAttribute("dataAO", dataAO.getData());
    	
    	if(StringUtils.isNotBlank(dataAO.getData().getSubjectCode())){
    		SubjectBalanceitemCriteria sac = new SubjectBalanceitemCriteria();
        	sac.createCriteria().andSubjectCodeEqualTo(dataAO.getData().getSubjectCode());
        	ServiceResult<List<SubjectBalanceitemAO>> itemList = subjectBalanceitemService.selectByCriteria(sac);
        	if(itemList != null && itemList.getData()!=null && itemList.getData().size() > 0 ) {
        		model.addAttribute("itemList", itemList.getData());
        	}else{
        		model.addAttribute("itemList", new ArrayList());
        	}
    	}else{
    		model.addAttribute("itemList", new ArrayList());
    	}
    	
    	AccountBalanceItemCriteria abic = new AccountBalanceItemCriteria();
    	ServiceResult<List<AccountBalanceItemAO>> itemtreelist = accountBalanceItemService.selectByCriteria(abic);
    	if(itemtreelist != null && itemtreelist.getData()!=null && itemtreelist.getData().size() > 0 ) {
    		model.addAttribute("itemtreelist", itemtreelist.getData());
    	}else{
    		model.addAttribute("itemtreelist", new ArrayList());
    	}
    	
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject(model);
    	mv.setViewName(MVCViewName.APP_APPFINANCE_PC_YUSUANZHIXING_SUBJECTCONFIGFORM.toString());
    	return mv;
    }  
    
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView list(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    @RequestMapping(value = "/view/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView viewById(@PathVariable String dataId,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    
    @RequestMapping(value = "/update/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView updateById(@PathVariable String dataId,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    @RequestMapping(value = "/delete/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView deleteById(@PathVariable String dataId,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    /**
    *异步提交表单
    **/
    @RequestMapping(value = "/submitAJAXForm", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object submitAJAXForm(@Valid FinanceSujectAO source,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		ServiceResult<Object> ret = new ServiceResult<Object>();

        return ret;
    }
    
    /**
     *同步提交表单
     **/
    @RequestMapping(value = "/submitForm", method = { RequestMethod.GET, RequestMethod.POST })
    public String submitForm(@Valid FinanceSujectAO source,Model model, HttpServletRequest request) {
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前时间传到前端
    	model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
    	ServiceResult<Object> ret = new ServiceResult<Object>();
    	if("".equals(source.getSubjectCode())){
    		source.setSubjectCode(getNewMaxSubjectCode());
    	}
    	financeSujectService.saveOrUpdate(source);
    	
    	//先删除所有此指标关系
    	SubjectRelationAccountCriteria sac = new SubjectRelationAccountCriteria();
    	sac.createCriteria().andSubjectItemEqualTo(source.getSubjectCode());
    	subjectRelationAccountService.deleteByCriteria(sac);
    	
    	List<String> list = source.getHnaList();
    	if(list!=null && list.size()>0){
    		for(String itemcode : list){
    			SubjectRelationAccountAO temp = new SubjectRelationAccountAO();
    			temp.setAccountCourseTypeCode(itemcode);
    			temp.setSubjectItem(source.getSubjectCode());
    			subjectRelationAccountService.saveOrUpdate(temp);
    		}
    	}
    	
    	return "redirect:/pc/financesuject";
    }
    
 	public String getNewMaxSubjectCode(){
 		FinanceSujectCriteria mc = new FinanceSujectCriteria();
    	mc.createCriteria();
    	mc.setOrderByClause("subject_code desc");
    	ServiceResult<List<FinanceSujectAO>> list = financeSujectService.selectByCriteria(mc);
    	if(list != null && list.getData()!=null && list.getData().size() > 0 ) {
    		String maxCode = list.getData().get(0).getSubjectCode();
    		maxCode = maxCode.replace("S=", "");
    		maxCode = "S=" + (new Integer(maxCode) + 1);
    		return maxCode;
    	}else{
    		return "S=100000";
    	}
    }
}
