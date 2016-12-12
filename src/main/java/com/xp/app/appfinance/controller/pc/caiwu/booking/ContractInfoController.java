package com.xp.app.appfinance.controller.pc.caiwu.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xp.app.appfinance.appobject.ContractInfoAO;
import com.xp.app.appfinance.appobject.ContractItemAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.ContractInfoCriteria;
import com.xp.app.appfinance.entity.gen.ContractItemCriteria;
import com.xp.app.appfinance.service.IContractInfoService;
import com.xp.app.appfinance.service.IContractItemService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * ContractInfo控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/contractinfo")
public class ContractInfoController {
	
	@Resource
	IContractInfoService contractInfoService;
	
	@Resource
	IContractItemService contractItemService;

    private static Logger LOG = LoggerFactory.getLogger(ContractInfoController.class);

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getHello(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
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
        ContractInfoAO fsa = new ContractInfoAO();
        contractInfoService.saveOrUpdate(fsa);
        return "redirect:/pc/contractinfo/showform/" + fsa.getId();
    }  
    
    @RequestMapping(value = "/showform/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView showform(@PathVariable String id , Model model, HttpServletRequest request) {
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前时间传到前端
    	model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
    	//将当前运用名称传到前端
    	ServiceResult<ContractInfoAO> dataAO = contractInfoService.getById(id);
    	
    	model.addAttribute("dataAO", dataAO.getData());
    	ContractItemCriteria cic = new ContractItemCriteria();
    	cic.createCriteria().andContractInfoIdEqualTo(id);
    	ServiceResult<List<ContractItemAO>> dataList = contractItemService.selectByCriteria(cic);
    	if(dataList!=null && dataList.getData()!=null && dataList.getData().size()>0){
    		model.addAttribute("dataList", dataList.getData());
    	}else{
    		model.addAttribute("dataList", new ArrayList());
    	}
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject(model);
    	mv.setViewName(MVCViewName.APP_APPFINANCE_PC_BOOKING_SHOUZHIBOOKINGFORM.toString());
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
        ContractInfoCriteria cc = new ContractInfoCriteria();
        ServiceResult<List<ContractInfoAO>> list = contractInfoService.selectByCriteria(cc);
        if(list!=null&& list.getData()!=null&& list.getData().size()>0){
        	model.addAttribute("datalist", list.getData());
        }else{
        	model.addAttribute("datalist", new ArrayList());
        }
        
        mv.addObject(model);
        mv.setViewName(MVCViewName.APP_APPFINANCE_PC_BOOKING_SHOUZHIBOOKING.toString());
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
    public Object submitAJAXForm(@Valid ContractInfoAO source,Model model, HttpServletRequest request) {
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
    public String submitForm(@Valid ContractInfoAO source,Model model, HttpServletRequest request) {
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前时间传到前端
    	model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
    	contractInfoService.saveOrUpdate(source);
    	
    	return "redirect:/pc/contractinfo/list";
    }
    
    
    /**
     *异步提交表单
     **/
     @RequestMapping(value = "/saveitem", method = { RequestMethod.GET, RequestMethod.POST })
     @ResponseBody
     public Object saveitem(@Valid ContractItemAO source,Model model, HttpServletRequest request) {
         LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
         LOG.info("SessionId %s", request.getSession().getId());
         //将当前时间传到前端
         model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
 		ServiceResult<Object> ret = new ServiceResult<Object>();
 		contractItemService.saveOrUpdate(source);
        return ret;
     }
}
