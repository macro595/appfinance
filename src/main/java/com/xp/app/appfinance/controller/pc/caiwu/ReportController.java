/**
 * 
 */package com.xp.app.appfinance.controller.pc.caiwu;/** * @author  作者 E-mail: * @date 创建时间：2016年8月31日 下午3:07:17 * @version 1.0 * @parameter  * @since  * @return  */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xp.app.appfinance.appobject.BudgeStatementAO;
import com.xp.app.appfinance.appobject.ReportBudgeStatementAO;
import com.xp.app.appfinance.appobject.ReportCaiwushouzhiAO;
import com.xp.app.appfinance.appobject.TwAccountAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.controller.pc.LoginController;
import com.xp.app.appfinance.entity.gen.BudgeStatementCriteria;
import com.xp.app.appfinance.entity.gen.ReportBudgeStatementCriteria;
import com.xp.app.appfinance.entity.gen.ReportCaiwushouzhiCriteria;
import com.xp.app.appfinance.entity.gen.TwAccountCriteria;
import com.xp.app.appfinance.service.IBudgeStatementService;
import com.xp.app.appfinance.service.IReportBStatementService;
import com.xp.app.appfinance.service.IReportCaiwushouzhiService;
import com.xp.app.appfinance.service.IShouzhiShijiService;
import com.xp.app.appfinance.service.ITwAccountService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
* @author chzh.xiao
*
*/
@Controller
@RequestMapping(value = "/pc/report")
public class ReportController {
	
	@Resource
	ITwAccountService twAccountService;
	
	@Resource
	IShouzhiShijiService shouzhiShijiService;	

	@Resource
	IBudgeStatementService budgeStatementService;	

	@Resource
	IReportBStatementService reportBStatementService;	
	
	@Resource
	IReportCaiwushouzhiService reportCaiwushouzhiService;
	
	private static Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
    @RequestMapping(value = "twAccount", method = { RequestMethod.GET, RequestMethod.POST })
    public String twAccount(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<List<TwAccountAO>> datalist = twAccountService.selectByCriteria(new TwAccountCriteria());
        if(datalist !=null && datalist.getData() !=null && datalist.getData().size() > 0 ){
        	model.addAttribute("datalist", datalist.getData());
        }else{
        	model.addAttribute("datalist", new ArrayList());
        }
        //将当前运用名称传到前端
        return MVCViewName.APP_APPFINANCE_PC_YUSUANZHIXING_TWACCOUNT.toString();
    }
    
    @RequestMapping(value = "caiwushouzhi/{year}/{month}", method = { RequestMethod.GET, RequestMethod.POST })
    public String caiwushouzhi(@PathVariable String year , @PathVariable String month , Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	ReportCaiwushouzhiCriteria ssc = new ReportCaiwushouzhiCriteria();
    	
    	if("cur".equals(year)){
    		ssc.createCriteria().andMonthEqualTo(DateTimeUtils.getMonth(new Date())+"").andYearNumEqualTo(DateTimeUtils.getYear(new Date())+"").andYusuanTypeEqualTo("shouzhi");
    		model.addAttribute("selectMonth", DateTimeUtils.getMonth(new Date())+"");
    		model.addAttribute("selectYear", DateTimeUtils.getYear(new Date())+"");
    	}else{
    		ssc.createCriteria().andMonthEqualTo(month).andYearNumEqualTo(year).andYusuanTypeEqualTo("shouzhi");
    		model.addAttribute("selectMonth", month);
    		model.addAttribute("selectYear", year);
    	}
    	ssc.setOrderByClause("month,sort");
    	ServiceResult<List<ReportCaiwushouzhiAO>> datalist = reportCaiwushouzhiService.selectByCriteria(ssc);
    	if(datalist !=null && datalist.getData() !=null && datalist.getData().size() > 0 ){
    		model.addAttribute("datalist", datalist.getData());
    	}else{
    		model.addAttribute("datalist", new ArrayList());
    	}
    	
    	//获取前5年数据
    	int curYear = DateTimeUtils.getYear(new Date());
    	List yearList = new ArrayList();
    	for(int i = 0 ; i < 5 ; i++){
    		yearList.add(curYear);
    		curYear = curYear - 1;
    	}
    	model.addAttribute("yearList", yearList);
    	
    	//将当前运用名称传到前端
    	
    	return MVCViewName.APP_APPFINANCE_PC_YUSUANZHIXING_CAIWUSHOUZHI.toString();
    }
    
    @RequestMapping(value = "caiwushouzhiforyear/{year}/{month}", method = { RequestMethod.GET, RequestMethod.POST })
    public String caiwushouzhiforyear(@PathVariable String year , @PathVariable String month , Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	ReportCaiwushouzhiCriteria ssc = new ReportCaiwushouzhiCriteria();
    	
    	if("cur".equals(year)){
    		ssc.createCriteria().andMonthEqualTo(DateTimeUtils.getMonth(new Date())+"").andYearNumEqualTo(DateTimeUtils.getYear(new Date())+"").andYusuanTypeEqualTo("shouzhi");
    		model.addAttribute("selectMonth", DateTimeUtils.getMonth(new Date())+"");
    		model.addAttribute("selectYear", DateTimeUtils.getYear(new Date())+"");
    	}else{
    		ssc.createCriteria().andMonthEqualTo(month).andYearNumEqualTo(year).andYusuanTypeEqualTo("shouzhi");
    		model.addAttribute("selectMonth", month);
    		model.addAttribute("selectYear", year);
    	}
    	ssc.setOrderByClause("month,sort");
    	ServiceResult<List<ReportCaiwushouzhiAO>> datalist = reportCaiwushouzhiService.selectByCriteria(ssc);
    	if(datalist !=null && datalist.getData() !=null && datalist.getData().size() > 0 ){
    		model.addAttribute("datalist", datalist.getData());
    	}else{
    		model.addAttribute("datalist", new ArrayList());
    	}
    	
    	//获取前5年数据
    	int curYear = DateTimeUtils.getYear(new Date());
    	List yearList = new ArrayList();
    	for(int i = 0 ; i < 5 ; i++){
    		yearList.add(curYear);
    		curYear = curYear - 1;
    	}
    	model.addAttribute("yearList", yearList);
    	
    	//将当前运用名称传到前端
    	
    	return MVCViewName.APP_APPFINANCE_PC_YUSUANZHIXING_CAIWUSHOUZHIFORYEAR.toString();
    }

    @RequestMapping(value = "profitBudgetForMonth/{year}/{month}", method = { RequestMethod.GET, RequestMethod.POST })
    public String profitBudget(@PathVariable String year , @PathVariable String month , Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	ReportBudgeStatementCriteria rbsc = new ReportBudgeStatementCriteria();
    	if("cur".equals(year)){
    	   	rbsc.createCriteria().andYearNumEqualTo(year).andMonthEqualTo(month);    		model.addAttribute("selectMonth", DateTimeUtils.getMonth(new Date())+"");
    		model.addAttribute("selectMonth", DateTimeUtils.getMonth(new Date())+"");
    		model.addAttribute("selectYear", DateTimeUtils.getYear(new Date())+"");
    	}else{
    	   	rbsc.createCriteria().andYearNumEqualTo(year).andMonthEqualTo(month);    		model.addAttribute("selectMonth", month);
    		model.addAttribute("selectMonth", month);
    		model.addAttribute("selectYear", year);
    	}
    	rbsc.setOrderByClause("month,sort");
    	ServiceResult<List<ReportBudgeStatementAO>> datalist = reportBStatementService.selectByCriteria(rbsc);
    	if(datalist !=null && datalist.getData() !=null && datalist.getData().size() > 0 ){
    		model.addAttribute("datalist", datalist.getData());
    	}else{
    		model.addAttribute("datalist", new ArrayList());
    	}  
    	//获取前5年数据
    	int curYear = DateTimeUtils.getYear(new Date());
    	List yearList = new ArrayList();
    	for(int i = 0 ; i < 5 ; i++){
    		yearList.add(curYear);
    		curYear = curYear - 1;
    	}
    	model.addAttribute("yearList", yearList);    	
    	//将当前运用名称传到前端
    	return MVCViewName.APP_APPFINANCE_PC_PROFIT_PROFITBUDGET.toString();
    }    
    
    @RequestMapping(value = "yearForProfitBudget/{year}/{month}", method = { RequestMethod.GET, RequestMethod.POST })
    public String profitBudgetForYear(@PathVariable String year ,@PathVariable String month , Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("text/html;charset=utf-8"); 
    	
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	ReportBudgeStatementCriteria rbsc = new ReportBudgeStatementCriteria();
    	if("cur".equals(year)){
    	   	rbsc.createCriteria().andYearNumEqualTo(year).andMonthEqualTo(month);    		model.addAttribute("selectMonth", DateTimeUtils.getMonth(new Date())+"");
    		model.addAttribute("selectMonth", DateTimeUtils.getMonth(new Date())+"");
    		model.addAttribute("selectYear", DateTimeUtils.getYear(new Date())+"");
    	}else{
    	   	rbsc.createCriteria().andYearNumEqualTo(year).andMonthEqualTo(month);    		model.addAttribute("selectMonth", month);
    		model.addAttribute("selectMonth", month);
    		model.addAttribute("selectYear", year);
    	}
    	rbsc.setOrderByClause("month,sort");
    	ServiceResult<List<ReportBudgeStatementAO>> datalist = reportBStatementService.selectByCriteria(rbsc);
    	if(datalist !=null && datalist.getData() !=null && datalist.getData().size() > 0 ){
    		model.addAttribute("datalist", datalist.getData());
    	}else{
    		model.addAttribute("datalist", new ArrayList());
    	}  
    	//获取前5年数据
    	int curYear = DateTimeUtils.getYear(new Date());
    	List yearList = new ArrayList();
    	for(int i = 0 ; i < 5 ; i++){
    		yearList.add(curYear);
    		curYear = curYear - 1;
    	}
    	model.addAttribute("yearList", yearList);   
    	//将当前运用名称传到前端
    	return MVCViewName.APP_APPFINANCE_PC_PROFIT_PROFITBUDGETFORYEAR.toString();
    }   
    
    @RequestMapping(value = "/fntwGetMonth/{month}", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object fntwGetMonth(@PathVariable String month,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		ServiceResult<List> ret = new ServiceResult<List>();
		TwAccountCriteria tac = new TwAccountCriteria();
		tac.createCriteria().andMonthEqualTo(month);
		ServiceResult<List<TwAccountAO>> datalist = twAccountService.selectByCriteria(tac);
        if(datalist !=null && datalist.getData() !=null && datalist.getData().size() > 0 ){
        	return datalist;
        }else{
        	return ret;
        }
    }
}
