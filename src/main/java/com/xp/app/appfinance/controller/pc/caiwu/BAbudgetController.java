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

import com.xp.app.appfinance.appobject.BABudgetAO;
import com.xp.app.appfinance.appobject.BABudgetDetailAO;
import com.xp.app.appfinance.appobject.SubjectDictionaryAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.BABudgetCriteria;
import com.xp.app.appfinance.entity.gen.BABudgetDetailCriteria;
import com.xp.app.appfinance.entity.gen.SubjectDictionaryCriteria;
import com.xp.app.appfinance.service.IBABudgetService;
import com.xp.app.appfinance.service.IDetailOfBABudgetService;
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
@RequestMapping(value = "/pc/babudget")
public class BAbudgetController {

	@Resource
	ISubjectDictionaryService subjectDictionaryService;

	@Resource
	IBABudgetService bABudgetService;

	@Resource
	IDetailOfBABudgetService detailOfBABudgetService;

	private static Logger LOG = LoggerFactory
			.getLogger(BAbudgetController.class);

	@RequestMapping(value = "listformonth/{year}/{month}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String listformonth(@PathVariable String year,
			@PathVariable String month, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		BABudgetCriteria babc = new BABudgetCriteria();
		BABudgetDetailCriteria babd = new BABudgetDetailCriteria();
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		if ("cur".equals(year)) {
			year = String.valueOf(DateTimeUtils.getYear(new Date()));
			month = String.valueOf(DateTimeUtils.getMonth(new Date()));
			babc.createCriteria().andYearNumEqualTo(year);
			babd.createCriteria().andMonthEqualTo(month);
		} else {
			babc.createCriteria().andYearNumEqualTo(year);
			babd.createCriteria().andMonthEqualTo(month);
		}
		ServiceResult<List<BABudgetAO>> babudgetlist = bABudgetService
				.selectByCriteria(babc);
		ServiceResult<List<BABudgetDetailAO>> babudgetdlist = detailOfBABudgetService
				.selectByCriteria(babd);
		model.addAttribute("babudgetlist", babudgetlist.getData());
		model.addAttribute("babudgetdlist", babudgetdlist.getData());
		model.addAttribute("yearList", yearList);
		model.addAttribute("selectYear", year);
		model.addAttribute("selectMonth", month);
		return MVCViewName.APP_APPFINANCE_PC_BABUDGET_BABUDGET.toString();
	}

	@RequestMapping(value = "listforyear/{year}/{month}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String listforyear(@PathVariable String year,
			@PathVariable String month, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		BABudgetCriteria babc = new BABudgetCriteria();
		BABudgetDetailCriteria babd = new BABudgetDetailCriteria();
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		if ("cur".equals(year)) {
			year = String.valueOf(DateTimeUtils.getYear(new Date()));
			month = String.valueOf(DateTimeUtils.getMonth(new Date()));
			babc.createCriteria().andYearNumEqualTo(year);
			babd.createCriteria().andMonthEqualTo(month);
		} else {
			babc.createCriteria().andYearNumEqualTo(year);
			babd.createCriteria().andMonthEqualTo(month);
		}
		ServiceResult<List<BABudgetAO>> babudgetlist = bABudgetService
				.selectByCriteria(babc);
		ServiceResult<List<BABudgetDetailAO>> babudgetdlist = detailOfBABudgetService
				.selectByCriteria(babd);
		model.addAttribute("babudgetlist", babudgetlist.getData());
		model.addAttribute("babudgetdlist", babudgetdlist.getData());
		model.addAttribute("yearList", yearList);
		model.addAttribute("selectYear", year);
		model.addAttribute("selectMonth", month);
		return MVCViewName.APP_APPFINANCE_PC_BABUDGET_BABUDGETFORYEAR
				.toString();
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String add(Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "业务活动费预算表指标" + "%");
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
		return MVCViewName.APP_APPFINANCE_PC_BABUDGET_BABCONFIGFORM.toString();
	}

	/**
	 * 同步提交表单
	 **/
	@SuppressWarnings("unused")
	@RequestMapping(value = "/submitForm", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String submitForm(@Valid BABudgetAO bABudget,
			@Valid BABudgetDetailAO detail, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		BABudgetCriteria babc = new BABudgetCriteria();
		babc.createCriteria().andSubjectNameEqualTo(bABudget.getSubjectName())
				.andYearNumEqualTo(bABudget.getYearNum());
		BABudgetAO bab = bABudgetService.selectByCriteria(babc).getData()
				.get(0);
		BABudgetDetailCriteria babd = new BABudgetDetailCriteria();
		babd.createCriteria().andYusuanIdEqualTo(bab.getId())
				.andMonthEqualTo(detail.getMonth());
		ServiceResult<List<BABudgetDetailAO>> list = detailOfBABudgetService
				.selectByCriteria(babd);
		BABudgetDetailAO dao = new BABudgetDetailAO();
		Boolean result = null;
		if (bab != null) {
			bABudget.setId(bab.getId());
			bABudgetService.saveOrUpdate(bABudget);
			if (list != null && list.getData() != null
					&& list.getData().size() > 0) {
				dao = list.getData().get(0);
				detail.setId(dao.getId());
				detail.setYusuanId(dao.getYusuanId());
				detailOfBABudgetService.saveOrUpdate(detail);
			} else {
				detail.setYusuanId(bABudget.getId());
				detailOfBABudgetService.saveOrUpdate(detail);
			}
		} else {
			result = bABudgetService.saveOrUpdate(bABudget).isSucceed();
			if (result) {
				detail.setYusuanId(bABudget.getId());
				detail.setCurMonthAccount(bABudget.getMonthAccount());
				detailOfBABudgetService.saveOrUpdate(detail);
			}
		}
		// 将当前时间传到前端
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(
				new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		return "redirect:/pc/babudget/listformonth/" + bABudget.getYearNum()
				+ "/" + detail.getMonth();
	}

	@RequestMapping(value = "/showform/{id}/{did}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public ModelAndView showform(@PathVariable String id,
			@PathVariable String did, Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		ServiceResult<BABudgetAO> bABudget = bABudgetService.getById(id);
		ServiceResult<BABudgetDetailAO> detail = detailOfBABudgetService
				.getById(did);
		model.addAttribute("bABudget", bABudget.getData());
		model.addAttribute("detail", detail.getData());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "业务活动费预算表指标" + "%");
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
		mv.setViewName(MVCViewName.APP_APPFINANCE_PC_BABUDGET_BABCONFIGFORM
				.toString());
		return mv;
	}

	@RequestMapping(value = "/getDObject/{subjectName}/{yearNum}/{month}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getObject(@PathVariable String subjectName,
			@PathVariable String yearNum, @PathVariable String month,
			Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(
				new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		ServiceResult<List> ret = new ServiceResult<List>();
		BABudgetCriteria babc = new BABudgetCriteria();
		babc.createCriteria().andSubjectNameEqualTo(subjectName)
				.andYearNumEqualTo(yearNum);
		ServiceResult<List<BABudgetAO>> datalist = bABudgetService
				.selectByCriteria(babc);
		BABudgetDetailCriteria babd = new BABudgetDetailCriteria();
		babd.createCriteria()
				.andYusuanIdEqualTo(datalist.getData().get(0).getId())
				.andMonthEqualTo(month);
		ServiceResult<List<BABudgetDetailAO>> dlist = detailOfBABudgetService
				.selectByCriteria(babd);
		if (dlist != null && datalist.getData() != null
				&& dlist.getData().size() > 0) {
			return dlist.getData().get(0);
		} else {
			return ret;
		}
	}

	@RequestMapping(value = "/Object/{subjectName}/{yearNum}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object Object(@PathVariable String subjectName,
			@PathVariable String yearNum, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		ServiceResult<List> ret = new ServiceResult<List>();
		BABudgetCriteria babc = new BABudgetCriteria();
		babc.createCriteria().andSubjectNameEqualTo(subjectName)
				.andYearNumEqualTo(yearNum);
		ServiceResult<List<BABudgetAO>> datalist = bABudgetService
				.selectByCriteria(babc);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			return datalist.getData().get(0);
		} else {
			return ret;
		}
	}
}
