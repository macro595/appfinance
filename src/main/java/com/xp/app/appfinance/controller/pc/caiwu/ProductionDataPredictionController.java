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

import com.xp.app.appfinance.appobject.BABudgetDetailAO;
import com.xp.app.appfinance.appobject.InvestmentBudgetAO;
import com.xp.app.appfinance.appobject.PDDetailAO;
import com.xp.app.appfinance.appobject.ProducDataAO;
import com.xp.app.appfinance.appobject.SubjectDictionaryAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.InvestmentBudgetCriteria;
import com.xp.app.appfinance.entity.gen.PDDetailCriteria;
import com.xp.app.appfinance.entity.gen.ProducDataCriteria;
import com.xp.app.appfinance.entity.gen.SubjectDictionaryCriteria;
import com.xp.app.appfinance.service.IPDDetailService;
import com.xp.app.appfinance.service.IProducDataService;
import com.xp.app.appfinance.service.ISubjectDictionaryService;
import com.xp.app.appfinance.service.PDDetialService;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * @author jianwei.li
 * 
 */
@Controller
@RequestMapping(value = "/pc/production")
public class ProductionDataPredictionController {

	private static Logger LOG = LoggerFactory
			.getLogger(ProductionDataPredictionController.class);

	@Resource
	ISubjectDictionaryService subjectDictionaryService;

	@Resource
	IPDDetailService pDDetailService;

	@Resource
	IProducDataService producDataService;

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
		PDDetailCriteria pddc = new PDDetailCriteria();
		PDDetailCriteria prepddc = new PDDetailCriteria();
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		if ("cur".equals(year)) {
			year = String.valueOf(DateTimeUtils.getYear(new Date()) + "");
			month = String.valueOf(DateTimeUtils.getMonth(new Date()) + "");
			pddc.createCriteria().andYearNumEqualTo(year)
					.andMonthEqualTo(month);
			prepddc.createCriteria()
					.andYearNumEqualTo(year)
					.andMonthEqualTo(
							String.valueOf(Integer.parseInt(month) - 1).trim());
		} else {
			pddc.createCriteria().andYearNumEqualTo(year)
					.andMonthEqualTo(month);
			prepddc.createCriteria()
					.andYearNumEqualTo(year)
					.andMonthEqualTo(
							String.valueOf(Integer.parseInt(month) - 1).trim());
		}
		pddc.setOrderByClause("ptype,month");
		prepddc.setOrderByClause("ptype,month");
		ServiceResult<List<PDDetailAO>> pddlist = pDDetailService
				.selectByCriteria(pddc);
		ServiceResult<List<PDDetailAO>> prepddlist = pDDetailService
				.selectByCriteria(prepddc);
		if (pddlist != null && pddlist.getData() != null
				&& pddlist.getData().size() > 0) {
			model.addAttribute("pddlist", pddlist.getData());
		} else {
			model.addAttribute("pddlist", new ArrayList());
		}
		if (prepddlist != null && prepddlist.getData() != null
				&& prepddlist.getData().size() > 0) {
			model.addAttribute("prepddlist", prepddlist.getData());
		} else {
			model.addAttribute("prepddlist", new ArrayList());
		}
		model.addAttribute("yearList", yearList);
		model.addAttribute("selectYear", year);
		model.addAttribute("selectMonth", month);
		return MVCViewName.APP_APPFINANCE_PC_PRODUCTION_PRODUCTIONLIST
				.toString();
	}

	@RequestMapping(value = "listforyear/{year}/{month}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String listforyear(@PathVariable String year,
			@PathVariable String month, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		ProducDataCriteria prdc = new ProducDataCriteria();
		PDDetailCriteria prepddc = new PDDetailCriteria();
		PDDetailCriteria curpddc = new PDDetailCriteria();
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		int curYear = DateTimeUtils.getYear(new Date());
		List yearList = new ArrayList();
		for (int i = 0; i < 5; i++) {
			yearList.add(curYear);
			curYear = curYear - 1;
		}
		if ("cur".equals(year)) {
			year = String.valueOf(DateTimeUtils.getYear(new Date()) + "");
			month = String.valueOf(DateTimeUtils.getMonth(new Date()) + "");
			prdc.createCriteria().andYearNumEqualTo(year.trim());
			prepddc.createCriteria()
					.andYearNumEqualTo(
							String.valueOf(Integer.parseInt(year.trim()) - 1))
					.andMonthEqualTo(month);
			curpddc.createCriteria().andYearNumEqualTo(year.trim())
					.andMonthEqualTo(month.trim());
		} else {
			prdc.createCriteria().andYearNumEqualTo(year.trim());
			prepddc.createCriteria()
					.andYearNumEqualTo(
							String.valueOf(Integer.parseInt(year.trim()) - 1))
					.andMonthEqualTo(month.trim());
			curpddc.createCriteria().andYearNumEqualTo(year.trim())
					.andMonthEqualTo(month.trim());
		}
		prdc.setOrderByClause("ptype");
		prepddc.setOrderByClause("ptype,month");
		curpddc.setOrderByClause("ptype,month");
		ServiceResult<List<PDDetailAO>> prepddlist = pDDetailService
				.selectByCriteria(prepddc);
		ServiceResult<List<PDDetailAO>> curpddlist = pDDetailService
				.selectByCriteria(curpddc);
		ServiceResult<List<ProducDataAO>> prdlist = producDataService
				.selectByCriteria(prdc);
		if (curpddlist != null && curpddlist.getData() != null
				&& curpddlist.getData().size() > 0) {
			model.addAttribute("curpddlist", curpddlist.getData());
		} else {
			model.addAttribute("curpddlist", new ArrayList());
		}
		if (prdlist != null && prdlist.getData() != null
				&& prdlist.getData().size() > 0) {
			model.addAttribute("prdlist", prdlist.getData());
		} else {
			model.addAttribute("prdlist", new ArrayList());
		}
		if (prepddlist != null && prepddlist.getData() != null
				&& prepddlist.getData().size() > 0) {
			model.addAttribute("prepddlist", prepddlist.getData());
		} else {
			model.addAttribute("prepddlist", new ArrayList());
		}
		model.addAttribute("yearList", yearList);
		model.addAttribute("selectYear", year);
		model.addAttribute("selectMonth", month);
		return MVCViewName.APP_APPFINANCE_PC_PRODUCTION_PYEARLIST.toString();
	}

	@RequestMapping(value = "/addofmonth", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String add(Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "生产数据指标" + "%");
		ServiceResult<List<SubjectDictionaryAO>> itemList = subjectDictionaryService
				.selectByCriteria(sdc);
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		SubjectDictionaryCriteria sdt = new SubjectDictionaryCriteria();
		sdt.createCriteria().andSubjectTypeLike("%" + "ptype" + "%");
		ServiceResult<List<SubjectDictionaryAO>> planList = subjectDictionaryService
				.selectByCriteria(sdt);
		if (planList != null && planList.getData() != null
				&& planList.getData().size() > 0) {
			model.addAttribute("planList", planList.getData());
		} else {
			model.addAttribute("planList", new ArrayList());
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
		return MVCViewName.APP_APPFINANCE_PC_PRODUCTION_PROMONTHCONFIGFORM
				.toString();
	}

	@RequestMapping(value = "/addofyear", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addofyear(Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "生产数据指标" + "%");
		ServiceResult<List<SubjectDictionaryAO>> itemList = subjectDictionaryService
				.selectByCriteria(sdc);
		// 将当前时间传到前端
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		SubjectDictionaryCriteria sdt = new SubjectDictionaryCriteria();
		sdt.createCriteria().andSubjectTypeLike("%" + "ptype" + "%");
		ServiceResult<List<SubjectDictionaryAO>> planList = subjectDictionaryService
				.selectByCriteria(sdt);
		if (planList != null && planList.getData() != null
				&& planList.getData().size() > 0) {
			model.addAttribute("planList", planList.getData());
		} else {
			model.addAttribute("planList", new ArrayList());
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
		return MVCViewName.APP_APPFINANCE_PC_PRODUCTION_PROYEARCONFIGFORM
				.toString();
	}

	@RequestMapping(value = "/getObject/{yearNum}/{month}/{subjectParentName}/{ptype}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getObject(@PathVariable String subjectParentName,
			@PathVariable String yearNum, @PathVariable String month,
			@PathVariable String ptype, Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		subjectParentName = subjectParentName.substring(0,
				subjectParentName.indexOf(",")).trim();
		System.out.println(subjectParentName);
		ServiceResult<List> ret = new ServiceResult<List>();
		PDDetailCriteria pbd = new PDDetailCriteria();
		if (ptype.equals("航空运输业人均收入,万元") || ptype.equals("航空运输业人均利润,万元")) {
			pbd.createCriteria()
					.andSubjectParentNameEqualTo(subjectParentName.trim())
					.andYearNumEqualTo(yearNum).andMonthEqualTo(month);
		} else {
			pbd.createCriteria()
					.andSubjectParentNameEqualTo(subjectParentName.trim())
					.andYearNumEqualTo(yearNum.trim())
					.andMonthEqualTo(month.trim())
					.andPtypeEqualTo(ptype.trim());
		}
		ServiceResult<List<PDDetailAO>> datalist = pDDetailService
				.selectByCriteria(pbd);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			return datalist.getData().get(0);
		} else {
			return ret;
		}
	}

	@RequestMapping(value = "/getYObject/{subjectName}/{yearNum}/{ptype}", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getYObject(@PathVariable String subjectName,
			@PathVariable String yearNum, @PathVariable String ptype, Model model, HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		ServiceResult<List> ret = new ServiceResult<List>();
		ProducDataCriteria prdc = new ProducDataCriteria();
		if (ptype.equals("航空运输业人均收入") || ptype.equals("航空运输业人均利润")) {
			prdc.createCriteria()
					.andSubjectNameEqualTo(subjectName.trim())
					.andYearNumEqualTo(yearNum);
		} else {
			prdc.createCriteria()
					.andSubjectNameEqualTo(subjectName.trim())
					.andYearNumEqualTo(yearNum.trim())
					.andPtypeEqualTo(ptype.trim());
		}
		ServiceResult<List<ProducDataAO>> datalist = producDataService
				.selectByCriteria(prdc);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			return datalist.getData().get(0);
		} else {
			return ret;
		}
	}	
	
	/**
	 * 同步提交表单
	 **/
	@RequestMapping(value = "/submitForm", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String submitForm(@Valid PDDetailAO pdd, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(
				new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		if (pdd.getSubjectParentName().trim().equals("航空运输业人均收入,万元")
				|| pdd.getSubjectParentName().trim().equals("航空运输业人均利润,万元")) {
			pdd.setPtype("");
		}
		String subjectParentName = pdd.getSubjectParentName()
				.substring(0, pdd.getSubjectParentName().indexOf(",")).trim();
		pdd.setSubjectParentName(subjectParentName);
		PDDetailCriteria pbd = new PDDetailCriteria();
		pbd.createCriteria().andSubjectParentNameEqualTo(subjectParentName)
				.andYearNumEqualTo(pdd.getYearNum())
				.andPtypeEqualTo(pdd.getPtype().trim())
				.andMonthEqualTo(pdd.getMonth().trim()).andIdIsNotNull();
		ServiceResult<List<PDDetailAO>> datalist = pDDetailService
				.selectByCriteria(pbd);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			pdd.setId(datalist.getData().get(0).getId());
		}
		pDDetailService.saveOrUpdate(pdd);
		return "redirect:/pc/production/listformonth/" + pdd.getYearNum() + "/"
				+ pdd.getMonth();
	}

	/**
	 * 同步提交表单
	 **/
	@RequestMapping(value = "/subyearForm", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String submityearForm(@Valid ProducDataAO prd, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(
				new Date(), DateTimeUtils.FORMAT_YMD_HMS));
		if (prd.getSubjectName().trim().equals("航空运输业人均收入")
				|| prd.getSubjectName().trim().equals("航空运输业人均利润")) {
			prd.setPtype("");
		}
		ProducDataCriteria prdc = new ProducDataCriteria();
		prdc.createCriteria().andSubjectNameEqualTo(prd.getSubjectName().trim())
				.andYearNumEqualTo(prd.getYearNum())
				.andPtypeEqualTo(prd.getPtype().trim()).andIdIsNotNull();
		ServiceResult<List<ProducDataAO>> datalist = producDataService
				.selectByCriteria(prdc);
		if (datalist != null && datalist.getData() != null
				&& datalist.getData().size() > 0) {
			prd.setId(datalist.getData().get(0).getId());
		}
		producDataService.saveOrUpdate(prd);
		return "redirect:/pc/production/listforyear/" + prd.getYearNum() + "/"
				+ String.valueOf(DateTimeUtils.getMonth(new Date()));
	}

	@RequestMapping(value = "/showform/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView showform(@PathVariable String id, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		ServiceResult<PDDetailAO> dataAO = pDDetailService.getById(id);
		model.addAttribute("dataAO", dataAO.getData());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "生产数据指标" + "%");
		ServiceResult<List<SubjectDictionaryAO>> itemList = subjectDictionaryService
				.selectByCriteria(sdc);
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		// 将当前时间传到前端
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		SubjectDictionaryCriteria sdt = new SubjectDictionaryCriteria();
		sdt.createCriteria().andSubjectTypeLike("%" + "ptype" + "%");
		ServiceResult<List<SubjectDictionaryAO>> planList = subjectDictionaryService
				.selectByCriteria(sdt);
		if (planList != null && planList.getData() != null
				&& planList.getData().size() > 0) {
			model.addAttribute("planList", planList.getData());
		} else {
			model.addAttribute("planList", new ArrayList());
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
		mv.setViewName(MVCViewName.APP_APPFINANCE_PC_PRODUCTION_PROMONTHCONFIGFORM
				.toString());
		return mv;
	}
	
	@RequestMapping(value = "/showyform/{id}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView showyform(@PathVariable String id, Model model,
			HttpServletRequest request) {
		LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),
				request.getHeader("user-agent"));
		LOG.info("SessionId %s", request.getSession().getId());
		// 将当前时间传到前端
		ServiceResult<ProducDataAO> dataAO = producDataService.getById(id);
		model.addAttribute("dataAO", dataAO.getData());
		SubjectDictionaryCriteria sdc = new SubjectDictionaryCriteria();
		sdc.createCriteria().andSubjectTypeLike("%" + "生产数据指标" + "%");
		ServiceResult<List<SubjectDictionaryAO>> itemList = subjectDictionaryService
				.selectByCriteria(sdc);
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		// 将当前时间传到前端
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		if (itemList != null && itemList.getData() != null
				&& itemList.getData().size() > 0) {
			model.addAttribute("itemList", itemList.getData());
		} else {
			model.addAttribute("itemList", new ArrayList());
		}
		SubjectDictionaryCriteria sdt = new SubjectDictionaryCriteria();
		sdt.createCriteria().andSubjectTypeLike("%" + "ptype" + "%");
		ServiceResult<List<SubjectDictionaryAO>> planList = subjectDictionaryService
				.selectByCriteria(sdt);
		if (planList != null && planList.getData() != null
				&& planList.getData().size() > 0) {
			model.addAttribute("planList", planList.getData());
		} else {
			model.addAttribute("planList", new ArrayList());
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
		mv.setViewName(MVCViewName.APP_APPFINANCE_PC_PRODUCTION_PROYEARCONFIGFORM
				.toString());
		return mv;
	}	
}
