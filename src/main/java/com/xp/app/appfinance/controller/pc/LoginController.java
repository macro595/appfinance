/*
 * Copyright (c) 2012-2013, chzh.xiao technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.xp.app.appfinance.controller.pc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.util.Constant;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
/**
 * Hello控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/login")
public class LoginController {

    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String hello(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        return MVCViewName.APP_APPFINANCE_PC_BASIC_LOGIN.toString();
    }
    @RequestMapping(value = "login")
	public @ResponseBody Object login(final Model model, HttpSession session, HttpServletRequest request) {
//		String xLoginCode = request.getParameter("xLoginCode");
//		String password = request.getParameter("password");
		ServiceResult<String> result = new ServiceResult<String>();
//		LdapRemoteHelper lr = new LdapRemoteHelper();
//
//		 boolean x = lr.authenticate(xLoginCode, password);
//
//		// 临时演示用
//		//boolean x = false;
//		UserCriteria uc = new UserCriteria();
//		uc.createCriteria().andXLoginCodeEqualTo(xLoginCode);
//		ServiceResult<List<UserAO>> uList = userService.selectByCriteria(uc);
//		if (uList != null && uList.getData() != null && uList.getData().size() > 0) {
//			x = true;
//		}
//
//		if (x) {
//			UserAO u = userService.getUserByXLoginCode(xLoginCode);
//			WebUtils.setSessionAttribute(request, Constants.SESSION_CURRENT_USER, u);
//			WebUtils.setSessionAttribute(request, Constants.DEFAULT_LANGUAGE, "_en");
//			result.setSucceed(true);
//			// 拥有管理员权限
//			if ("1".equals(u.getRole())) {
//				result.setData("/homepage.do");
//			} else {
//				result.setData("/homepageforUser.do");
//			}
//
//		} else {
//			result.setData("账号或密码错误！");
//			result.setSucceed(false);
//		}

		return result;
	}
    
    @RequestMapping(value = "logout", method = { RequestMethod.GET, RequestMethod.POST })
    public String logout(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前运用名称传到前端
    	request.getSession().removeAttribute(Constant.SESSION_CURRENT_USER);
        
    	return MVCViewName.APP_APPFINANCE_PC_BASIC_LOGIN.toString();
    }
}
