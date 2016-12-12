/**
 * 
 */
package com.xp.app.appfinance.controller.pc.caiwu;

/** * @author  作者 E-mail: * @date 创建时间：2016年8月31日 下午3:07:17 * @version 1.0 * @parameter  * @since  * @return  */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xp.app.appfinance.appobject.FinanceSujectAO;
import com.xp.app.appfinance.appobject.InvestmentBudgetAO;
import com.xp.app.appfinance.appobject.SubjectDictionaryAO;
import com.xp.app.appfinance.appobject.SubjectRelationAccountAO;
import com.xp.app.appfinance.appobject.TwAccountAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.InvestmentBudgetCriteria;
import com.xp.app.appfinance.entity.gen.SubjectDictionaryCriteria;
import com.xp.app.appfinance.entity.gen.SubjectRelationAccountCriteria;
import com.xp.app.appfinance.entity.gen.TwAccountCriteria;
import com.xp.app.appfinance.service.IInvestmentBudgetService;
import com.xp.app.appfinance.service.ISubjectDictionaryService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * @author jianwei.li
 * 
 */
@Controller
@RequestMapping(value = "/pc/ibsummary")
public class IBSummaryController {

	private static Logger LOG = LoggerFactory
			.getLogger(IBSummaryController.class);

	@Resource
	ISubjectDictionaryService subjectDictionaryService;

	@Resource
	IInvestmentBudgetService investmentBudgetService;

	@RequestMapping(value = "list/{year}/{month}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String caiwushouzhiforyear(@PathVariable String year,
			@PathVariable String month, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		InvestmentBudgetCriteria ibc = new InvestmentBudgetCriteria();
		if ("cur".equals(year)) {
			year = String.valueOf(DateTimeUtils.getYear(new Date()));
			month = String.valueOf(DateTimeUtils.getMonth(new Date()));
			ibc.createCriteria().andYearNumEqualTo(year).andMonthEqualTo(month);
		}
		if (!"all".equals(year) && !"all".equals(month)) {
			ibc.createCriteria().andYearNumEqualTo(year).andMonthEqualTo(month);
		} else if (!"all".equals(year)) {
			ibc.createCriteria().andYearNumEqualTo(year);
		} else if (!"all".equals(month)) {
			ibc.createCriteria().andMonthEqualTo(month);
		}
		model.addAttribute("selectYear", year);
		model.addAttribute("selectMonth", month);
		model.addAttribute("yearList", yearList);
		ibc.setOrderByClause("year_num,month");
		ServiceResult<List<InvestmentBudgetAO>> datalist = investmentBudgetService
				.selectByCriteria(ibc);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			model.addAttribute("datalist", datalist.getData());
		} else {
			model.addAttribute("datalist", new ArrayList());
		}
		return MVCViewName.APP_APPFINANCE_PC_IBSUMMARY_IBSLIST.toString();
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String add(Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "投资预算汇总表指标" + "%");
		ServiceResult<List<SubjectDictionaryAO>> itemList = subjectDictionaryService
				.selectByCriteria(sdc);
		// 将当前时间传到前端
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		// 获取前5年数据
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		model.addAttribute("yearList", yearList);
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(
				new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		// 将当前运用名称传到前端
		ModelAndView mv = new ModelAndView();
		mv.addObject(model);
		return MVCViewName.APP_APPFINANCE_PC_IBSUMMARY_IBSCONFIGFORM.toString();
	}

	/**
	 * 同步提交表单
	 **/
	@RequestMapping(value = "/submitForm", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String submitForm(@Valid InvestmentBudgetAO ib, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(
				new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		InvestmentBudgetCriteria ibc = new InvestmentBudgetCriteria();
		ibc.createCriteria().andSubjectNameEqualTo(ib.getSubjectName())
				.andYearNumEqualTo(ib.getYearNum()).andIdIsNotNull();
		ServiceResult<List<InvestmentBudgetAO>> datalist = investmentBudgetService
				.selectByCriteria(ibc);
		if (ib.getYearYusuan() != null && (!ib.getYearYusuan().equals("0"))) {
			for (InvestmentBudgetAO ao : datalist.getData()) {
				ao.setYearYusuan(ib.getYearYusuan());
				investmentBudgetService.saveOrUpdate(ao);
			}
		}
		investmentBudgetService.saveOrUpdate(ib);
		return "redirect:/pc/ibsummary/list/" + ib.getYearNum() + "/"
				+ ib.getMonth();
	}

	@RequestMapping(value = "/showform/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView showform(@PathVariable String id, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		ServiceResult<InvestmentBudgetAO> dataAO = investmentBudgetService
				.getById(id);
		model.addAttribute("dataAO", dataAO.getData());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "投资预算汇总表指标" + "%");
		ServiceResult<List<SubjectDictionaryAO>> itemList = subjectDictionaryService
				.selectByCriteria(sdc);
		// 将当前时间传到前端
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		// 获取前5年数据
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		model.addAttribute("yearList", yearList);
		ModelAndView mv = new ModelAndView();
		mv.addObject(model);
		mv.setViewName(MVCViewName.APP_APPFINANCE_PC_IBSUMMARY_IBSCONFIGFORM
				.toString());
		return mv;
	}

	@RequestMapping(value = "/getObject/{subjectName}/{yearNum}/{month}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getObject(@PathVariable String subjectName,
			@PathVariable String yearNum, @PathVariable String month,
			Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		ServiceResult<List> ret = new ServiceResult<List>();
		InvestmentBudgetCriteria ibc = new InvestmentBudgetCriteria();
		ibc.createCriteria().andSubjectNameEqualTo(subjectName.trim())
				.andYearNumEqualTo(yearNum).andMonthEqualTo(month);
		ServiceResult<List<InvestmentBudgetAO>> datalist = investmentBudgetService
				.selectByCriteria(ibc);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			return datalist.getData().get(0);
		} else {
			return ret;
		}
	}
}
