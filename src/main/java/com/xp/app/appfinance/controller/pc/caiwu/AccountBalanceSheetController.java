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

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xp.app.appfinance.appobject.AccountBalanceItemAO;
import com.xp.app.appfinance.appobject.AccountBalanceSheetAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.AccountBalanceItemCriteria;
import com.xp.app.appfinance.entity.gen.AccountBalanceSheetCriteria;
import com.xp.app.appfinance.service.IAccountBalanceItemService;
import com.xp.app.appfinance.service.IAccountBalanceSheetService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * AccountBalanceSheet控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/accountbalancesheet")
public class AccountBalanceSheetController {
	
	@Resource
	IAccountBalanceItemService accountBalanceItemService;
	
	@Resource
	IAccountBalanceSheetService accountBalanceSheetService;

    private static Logger LOG = LoggerFactory.getLogger(AccountBalanceSheetController.class);

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getHello(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        mv.setViewName(MVCViewName.APP_APPFINANCE_PC_BASIC_HANITEMINFO.toString());
        return mv;
    }
    
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView add(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
        
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
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
    public Object submitAJAXForm(@Valid AccountBalanceSheetAO source,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		ServiceResult<Object> ret = new ServiceResult<Object>();

        return ret;
    }
    
    @RequestMapping(value = "initItemTree", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object initOrgTree(Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		// 将当前运用名称传到前端
		long date1 = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		ServiceResult<Object> ret = new ServiceResult<Object>();
		try {
			AccountBalanceItemCriteria oc = new AccountBalanceItemCriteria();
			
			oc.or().andParentCodeIsNull();
			oc.or().andParentCodeEqualTo("");

			oc.setOrderByClause("root_code");
			ServiceResult<List<AccountBalanceItemAO>> orgrotlist = accountBalanceItemService.selectByCriteria(oc);
			List treeList = new ArrayList();
			if (orgrotlist != null && orgrotlist.getData() != null && orgrotlist.getData().size() > 0) {
				for (AccountBalanceItemAO rootNode : orgrotlist.getData()) {
					TreeNodeBean root = new TreeNodeBean();
					root.setId(rootNode.getItemCode());
					root.setName(rootNode.getItemName());
					root.setParentCode("");
					List leafList = getLeafNode(rootNode.getItemCode(), new ArrayList());

					root.setChildren(leafList);
					treeList.add(root);
				}
				
				Object o = mapper.writeValueAsString(treeList).replaceAll(",\"children\":\\[\\]", "");
				ret.setData(o);
			} else {
				ret.setData(mapper.writeValueAsString(new ArrayList()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long date2 = System.currentTimeMillis();
		System.out.println(date2 - date1);
		return ret;
	}

	public List getLeafNode(String code, List leafNodeList) {
		AccountBalanceItemCriteria oc = new AccountBalanceItemCriteria();
		oc.createCriteria().andParentCodeEqualTo(code);
		ServiceResult<List<AccountBalanceItemAO>> orgleaflist = accountBalanceItemService.selectByCriteria(oc);

		if (orgleaflist != null && orgleaflist.getData() != null && orgleaflist.getData().size() > 0) {
			for (AccountBalanceItemAO leafNode : orgleaflist.getData()) {
				TreeNodeBean node = new TreeNodeBean();
				node.setId(leafNode.getItemCode());
				node.setName(leafNode.getItemName());
				node.setParentCode(code);
				List leafList = getLeafNode(leafNode.getItemCode(), new ArrayList());
				node.setChildren(leafList);
				leafNodeList.add(node);
			}
		} else {
			return new ArrayList();
		}
		return leafNodeList;
	}
	
	@RequestMapping(value = "/getHNADataByItemCode/{itemCode}", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public Object getHNADataByItemCode(@PathVariable String itemCode, Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		long date1 = System.currentTimeMillis();
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		ServiceResult<Object> ret = new ServiceResult<Object>();
		AccountBalanceSheetCriteria omec = new AccountBalanceSheetCriteria();
		omec.createCriteria().andAccountantCourseLike("%" + itemCode + "%");

		ServiceResult<List<AccountBalanceSheetAO>> memberlist = accountBalanceSheetService.selectByCriteria(omec);
		if (memberlist != null && memberlist.getData() != null && memberlist.getData().size() > 0) {
			ret.setData(memberlist.getData());
		} else {
			ret.setData(new ArrayList());
		}
		long date2 = System.currentTimeMillis();
		System.out.println(date2 - date1);
		return ret;
	}
}
