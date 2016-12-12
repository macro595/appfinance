/*
 * Copyright (c) 2012, CHXIAO Co., Ltd.
 *
 * All rights reserved.
 */
package com.xp.app.appfinance.controller.pc;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xp.app.appfinance.appobject.AccountBalanceItemAO;
import com.xp.app.appfinance.appobject.AccountBalanceSheetAO;
import com.xp.app.appfinance.appobject.ContractInfoAO;
import com.xp.app.appfinance.appobject.FinanceSujectAO;
import com.xp.app.appfinance.appobject.YuSuanAO;
import com.xp.app.appfinance.appobject.YusuanDetialAO;
import com.xp.app.appfinance.common.MVCViewName;
import com.xp.app.appfinance.entity.gen.AccountBalanceItemCriteria;
import com.xp.app.appfinance.entity.gen.FinanceSujectCriteria;
import com.xp.app.appfinance.entity.gen.YuSuanCriteria;
import com.xp.app.appfinance.service.IAccountBalanceItemService;
import com.xp.app.appfinance.service.IAccountBalanceSheetService;
import com.xp.app.appfinance.service.IContractInfoService;
import com.xp.app.appfinance.service.IFinanceSujectService;
import com.xp.app.appfinance.service.IYuSuanService;
import com.xp.app.appfinance.service.IYusuanDetialService;
import com.xp.app.appfinance.util.Constant;
import com.yuanxin.framework.logging.Logger;
import com.yuanxin.framework.logging.LoggerFactory;
import com.yuanxin.framework.service.ServiceResult;
import com.yuanxin.framework.util.DateTimeUtils;

/**
 * FileInfo控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/fileinfo")
public class FileInfoController {
	
	@Resource
	IAccountBalanceSheetService accountBalanceSheetService;
	
	@Resource
	IAccountBalanceItemService accountBalanceItemService;
	
	@Resource
	IContractInfoService contractInfoService;
	
	@Resource
	IYuSuanService yuSuanService;
	
	@Resource
	IYusuanDetialService yusuanDetialService;
	
	@Resource
	IFinanceSujectService financeSujectService;
	
	/**
	 * Excel 2003
	 */
	private final static String XLS = "xls";
	/**
	 * Excel 2007
	 */
	private final static String XLSX = "xlsx";
	/**
	 * 分隔符
	 */
	private final static String SEPARATOR = "|";
	
    private static Logger LOG = LoggerFactory.getLogger(FileInfoController.class);

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
    
    
    @RequestMapping(value = "importBasicInfo/{importPath}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView importBasicInfo(@PathVariable String importPath , Model model, HttpServletRequest request) {
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前时间传到前端
    	model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
    	//将当前运用名称传到前端
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject(model);
    	model.addAttribute("importPath", importPath);
    	mv.setViewName(MVCViewName.APP_APPFINANCE_PC_BASIC_IMPORTINFO.toString());
    	return mv;
    }
    
    @RequestMapping(value = "importBasicInfo/{importPath}/{msg}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView importBasicInfo(@PathVariable String importPath ,@PathVariable String msg , Model model, HttpServletRequest request) {
    	LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
    	LOG.info("SessionId %s", request.getSession().getId());
    	//将当前时间传到前端
    	model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
    	//将当前运用名称传到前端
    	
    	ModelAndView mv = new ModelAndView();
    	mv.addObject(model);
    	model.addAttribute("importPath", importPath);
    	model.addAttribute("msg", msg);
    	mv.setViewName(MVCViewName.APP_APPFINANCE_PC_BASIC_IMPORTINFO.toString());
    	return mv;
    }
    
  	// 财务科目数据导入
  	@RequestMapping(value = "importHNAData")
  	public String importSchoolOrganDetialData(final Model model, HttpSession session, HttpServletRequest request) {
  		byte[] bytes;
  		InputStream is = null;
  		String yearNum = "";
  		try {
  			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
  			List<MultipartFile> filelist = req.getMultiFileMap().get("file");
  			for (MultipartFile f : filelist) {
  				if (!f.isEmpty()) {
  					String fileName = f.getOriginalFilename();
  					String ext = fileName.indexOf(".")>-1?fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()):"";
  					is = f.getInputStream();
  					Workbook workbook = null;
  					
  					if (ext.toLowerCase().equals(XLS)) {
  						workbook = new HSSFWorkbook(is);
  					} else if (ext.toLowerCase().equals(XLSX)) {
  						workbook = new XSSFWorkbook(is);
  					}
  					// get到Sheet对象
  					Sheet sheet = workbook.getSheetAt(0);
  					String month = "";
  					for (Row row : sheet) {
  						if(row.getRowNum() == 4 ){
  							String desc = getCellString(row.getCell(0));
  							if(desc.indexOf("JAN") >= 0){
  								month = "01";
  							}else if(desc.indexOf("FEB") >= 0){
  								month = "02";
  							}else if(desc.indexOf("MAR") >= 0){
  								month = "03";
  							}else if(desc.indexOf("APR") >= 0){
  								month = "04";
  							}else if(desc.indexOf("MAY") >= 0){
  								month = "05";
  							}else if(desc.indexOf("JUN") >= 0){
  								month = "06";
  							}else if(desc.indexOf("JUL") >= 0){
  								month = "07";
  							}else if(desc.indexOf("AUG") >= 0){
  								month = "08";
  							}else if(desc.indexOf("SEP") >= 0){
  								month = "09";
  							}else if(desc.indexOf("OCT") >= 0){
  								month = "10";
  							}else if(desc.indexOf("NOV") >= 0){
  								month = "11";
  							}else if(desc.indexOf("DEC") >= 0){
  								month = "12";
  							}
  							yearNum = "20" + desc.split("-")[1];
  							continue;
  						}
  						
  						if(row.getRowNum() < 8 ){
  							continue;
  						}
  						if(row.getCell(0)==null || "".equals(row.getCell(0).toString())|| !row.getCell(0).toString().startsWith("015.")){
  							break;
  						}
  						System.out.println(row.getRowNum());
  						AccountBalanceSheetAO dataAO = new AccountBalanceSheetAO();
  						
  						String accountantCourse = getCellString(row.getCell(0));
  						String accountantCourseDesc = getCellString(row.getCell(1));
  						
  						AccountBalanceItemAO itemAO = isExistByItemAllName(accountantCourseDesc , accountantCourse);
  						
  						String currency = getCellString(row.getCell(2));
  						//期初余额(本位币)
  						String qichuYue = getNumber(row.getCell(3));
  						//本期借方(本位币)
  						String benqiJiefang = getNumber(row.getCell(4));
  						//本期贷方(本位币)
  						String benqiDaifang = getNumber(row.getCell(5));
  						//期末余额(本位币)
  						String qimoYue = getNumber(row.getCell(6));
  						
  						dataAO.setAccountantCourseDesc(accountantCourseDesc);
  						dataAO.setAccountantCourse(accountantCourse);
  						dataAO.setBenqiDaifang(benqiDaifang);
  						dataAO.setBenqiJiefang(benqiJiefang);
  						dataAO.setCurrency(currency);
  						dataAO.setQichuYue(qichuYue);
  						dataAO.setQimoYue(qimoYue);
  						dataAO.setMonth(month);
  						dataAO.setYearNum(yearNum);
  						dataAO.setCreateDate(new Date());
  						
  						accountBalanceSheetService.saveOrUpdate(dataAO);
  						
  					}
  					is.close();
  				}
  			}
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			return "redirect:/pc/fileinfo/importBasicInfo/importHNAData/fail";
  		}
  		return "redirect:/pc/fileinfo/importBasicInfo/importHNAData";
  	}
 	
 	public String getNumber(Cell numberCell) {
 		DecimalFormat df = new DecimalFormat("0.000000000");
 		String numbervalue = "";
 		if(numberCell ==null || "".equals(numberCell.toString())){
 			return "0.000000000";
 		}
 		if(numberCell.getCellType()== Cell.CELL_TYPE_NUMERIC){
 			numbervalue = df.format(numberCell.getNumericCellValue());
 		}else if(numberCell.getCellType() == Cell.CELL_TYPE_FORMULA){//单元格遇到公式
 			
 			try {
 				numbervalue = df.format(numberCell.getNumericCellValue());
 			} catch (IllegalStateException e) {
 				numbervalue = numberCell.toString();
 			}
 		}else{
 			try {
 				numbervalue = numberCell.toString();
 				if(!StringUtils.isNotBlank(numbervalue)){
 					numbervalue = "0.000000000";
 				}
 			} catch (IllegalStateException e) {
 				if(!StringUtils.isNotBlank(numbervalue)){
 					numbervalue = "0.000000000";
 				}
 			}
 		}
 		return numbervalue;
 	}
 	
 	public Date getCellDate(Cell dateCell) {
 		if (HSSFDateUtil.isCellDateFormatted(dateCell)) {
 			return dateCell.getDateCellValue();
 		}
 		else{
 			return DateTimeUtils.parseStrToDate(dateCell.getStringCellValue(),"yyyy/MM/dd");
 		}
 	}
 	
 	public String getCellString(Cell stringCell) {
 		if (stringCell == null ) {
 			return "";
 		}
 		else{
 			return stringCell.toString();
 		}
 	}
 	
 	//判断科目结构是否存在，若不存在，直接新建,返回最终层级
 	public AccountBalanceItemAO isExistByItemAllName(String itemAllName , String itemAllCode){
 		AccountBalanceItemCriteria abc = new AccountBalanceItemCriteria();
 		abc.createCriteria().andAllItemCodeEqualTo(itemAllCode);
 		ServiceResult<List<AccountBalanceItemAO>> list = accountBalanceItemService.selectByCriteria(abc);
 		
 		//定义科目对象，用于获取最后一次生成后，返回code,result
 		AccountBalanceItemAO result = new AccountBalanceItemAO();
		
 		//如果已经存在，直接返回
 		if(list != null && list.getData()!=null && list.getData().size() > 0 ) {
 			return list.getData().get(0);
 		} else{
 			//如果不存在，则根据结构创建
 			String rootCode = "";
 			String rootName = "";
 			
 			String parentCode = "";
 			String newItemAllCode = "";
 			String newItemAllName = "";
 			List<String> itemCodeList = Arrays.asList(itemAllCode.split("\\."));
 			List<String> itemNameList = Arrays.asList(itemAllName.split("\\."));
 			
 	 		for(int i = 0 ; i < itemCodeList.size() ; i++ ) {
 	 			String itemCode = "";
 	 			for(int j = 0 ; j < i+1 ; j ++){
 	 				if(j==0){
 	 					itemCode = itemCodeList.get(0);
 	 				}else{
 	 					itemCode = itemCode + "." + itemCodeList.get(j);
 	 				}
 	 			}
 	 			String itemName  = itemNameList.get(i);
 	 			AccountBalanceItemCriteria onewc = new AccountBalanceItemCriteria();
 	 			onewc.createCriteria().andItemCodeEqualTo(itemCode);
 	 	 		ServiceResult<List<AccountBalanceItemAO>> newlist = accountBalanceItemService.selectByCriteria(onewc);
 	 	 		
 	 	 		//如果数据不为空，证明存在这个科目，
 	 	 		if(newlist != null && newlist.getData() != null && newlist.getData().size() > 0 ) {
 	 	 			//初始化下一次的父节点
 	 	 			if(i == 0){
 	 	 				rootCode = newlist.getData().get(0).getItemCode();
 	 	 				rootName = newlist.getData().get(0).getItemName();
 	 	 				
 	 	 				parentCode = newlist.getData().get(0).getItemCode();
 	 	 				
 	 	 				newItemAllCode = newlist.getData().get(0).getItemCode();
 	 	 				newItemAllName = newlist.getData().get(0).getItemName();
 	 	 				
 	 	 			}else{
 	 	 				parentCode = newlist.getData().get(0).getItemCode();
 	 	 				
 	 	 				newItemAllCode = newlist.getData().get(0).getItemCode();
 	 	 				newItemAllName = newItemAllName + "." + newlist.getData().get(0).getItemName();
 	 	 			}
 	 	 			//返回结果数据
 	 	 			result = newlist.getData().get(0);
 	 	 		}else{
 	 	 			//如果数据为空，证明不存在这个科目，直接新建
 	 	 			result = new AccountBalanceItemAO();
 	 	 			if("N".equals(itemName)){
 	 	 				continue;
 	 	 			}else{
 	 	 				result.setItemCode(itemCode);
 	 	 	 			result.setItemName(itemName);
 	 	 			}
 	 	 			
 	 	 			if(newItemAllCode.equals("")){
 	 	 				newItemAllName = itemName;
 	 	 				newItemAllCode = itemCode;
 	 	 			}else{
 	 	 				newItemAllName = newItemAllName + "." + itemName;
 	 	 				newItemAllCode = itemCode;
 	 	 			}
 	 	 			result.setAllItemName(newItemAllName);
 	 	 			result.setAllItemCode(newItemAllCode);
 	 	 			result.setParentCode(parentCode);
 	 	 			
 	 	 			result.setRootCode(rootCode);
 	 	 			result.setRootName(rootName);
 	 	 			//返回结果数据
 	 	 			accountBalanceItemService.saveOrUpdate(result);
 	 	 			
 	 	 			//初始化下一次的父节点
 	 	 			parentCode = result.getItemCode();
 	 	 	 		newItemAllCode = result.getAllItemCode();
 	 	 	 		newItemAllName = result.getAllItemName();
 	 	 			
 	 	 			if("".equals(rootCode)) {
 	 	 				rootCode = result.getItemCode();
 	 	 				rootName = result.getItemName();
 	 	 			}
 	 	 		}
 	 		}
 		}
 		return result;
 	}
 	
 // 首付款台账数据导入
   	@RequestMapping(value = "importBookingData")
   	public String importBookingData(final Model model, HttpSession session, HttpServletRequest request) {
   		byte[] bytes;
   		InputStream is = null;
   		try {
   			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
   			List<MultipartFile> filelist = req.getMultiFileMap().get("file");
   			for (MultipartFile f : filelist) {
   				if (!f.isEmpty()) {
   					String fileName = f.getOriginalFilename();
   					String ext = fileName.indexOf(".")>-1?fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()):"";
   					is = f.getInputStream();
   					Workbook workbook = null;
   					
   					if (ext.toLowerCase().equals(XLS)) {
   						workbook = new HSSFWorkbook(is);
   					} else if (ext.toLowerCase().equals(XLSX)) {
   						workbook = new XSSFWorkbook(is);
   					}
   					// get到Sheet对象
   					Sheet sheet = workbook.getSheetAt(0);
   					String month = "";
   					for (Row row : sheet) {
   						if(row.getRowNum() < 3 ){
   							continue;
   						}
   						if(row.getCell(0)==null || "".equals(row.getCell(0).toString())){
   							break;
   						}
   						ContractInfoAO dataAO = new ContractInfoAO();
   						
   						String type = getCellString(row.getCell(1));
   						String contractName = getCellString(row.getCell(2));
   						String contractNum = getCellString(row.getCell(3));
   						String qianyueDate = getCellString(row.getCell(4));
   						String tempStr =getCellString(row.getCell(5));
   								
   						String qianshuType = "";
   						if(tempStr.indexOf("续费自动转续") > 0){
   							qianshuType = "续费自动转续";
   							tempStr = tempStr.replace("续费自动转续", "");
   						}else if(tempStr.indexOf("长期") > 0){
   							qianshuType = "长期";
   							tempStr = tempStr.replace("长期", "");
   						}
   						
   						List list  = Arrays.asList(tempStr.split("-"));
   						
   						Date contractStartDate = DateTimeUtils.parseStrToDate(list.get(0).toString(),"yyyy.MM.dd");
   						Date contractEndDate = null;
   						if(list.size() >= 2 ){
   							contractEndDate = DateTimeUtils.parseStrToDate(list.get(1).toString(),"yyyy.MM.dd");
   						}
   						
   						String deptName = getCellString(row.getCell(6));
   						String contactsName = getCellString(row.getCell(7));
   						String companyName = getCellString(row.getCell(8));
   						String contractItem = getCellString(row.getCell(9));
   						String contractMoney = getCellString(row.getCell(10));
   						String contractPeriod = getCellString(row.getCell(11));
   						String descComment = getCellString(row.getCell(12));
   						
   						dataAO.setCompanyName(companyName);
   						dataAO.setContactsName(contactsName);
   						dataAO.setContractEndDate(contractEndDate);
   						dataAO.setContractItem(contractItem);
   						dataAO.setContractMoney(contractMoney);
   						dataAO.setContractName(contractName);
   						dataAO.setContractNum(contractNum);
   						dataAO.setContractPeriod(contractPeriod);
   						dataAO.setContractStartDate(contractStartDate);
   						dataAO.setDeptName(deptName);
   						dataAO.setDescComment(descComment);
   						dataAO.setQianshuType(qianshuType);
   						dataAO.setQianyueDate(qianyueDate);
   						dataAO.setType(type);
   						
   						contractInfoService.saveOrUpdate(dataAO);
   					}
   					is.close();
   				}
   			}
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			return "redirect:/pc/fileinfo/importBasicInfo/importBookingData/fail";
   		}
   		return "redirect:/pc/fileinfo/importBasicInfo/importBookingData";
   	}
   	
   	// 年度预算数据导入
   	@RequestMapping(value = "importyusuanData")
   	public String importyusuanData(final Model model, HttpSession session, HttpServletRequest request) {
   		byte[] bytes;
   		InputStream is = null;
   		String errorMsg = "";
  		String yearNum = request.getParameter("yearnum");
  		
  		Date currDate = new Date();
   		try {
   			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
   			List<MultipartFile> filelist = req.getMultiFileMap().get("file");
   			for (MultipartFile f : filelist) {
   				if (!f.isEmpty()) {
   					String fileName = f.getOriginalFilename();
   					String ext = fileName.indexOf(".")>-1?fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()):"";
   					is = f.getInputStream();
   					Workbook workbook = null;
   					
   					if (ext.toLowerCase().equals(XLS)) {
   						workbook = new HSSFWorkbook(is);
   					} else if (ext.toLowerCase().equals(XLSX)) {
   						workbook = new XSSFWorkbook(is);
   					}
   					// get到Sheet对象
   					Sheet sheet = workbook.getSheetAt(1);
   					String month = "";
   					for (Row row : sheet) {
   						if(row.getRowNum() < 3 ){
   							continue;
   						}
   						if(row.getCell(0)==null || "".equals(row.getCell(0).toString())){
   							break;
   						}
   						YuSuanAO dataAO = new YuSuanAO();
   						
   						String subjectName = getCellString(row.getCell(0));
   						
   						String subjectCode = "";
   						
   						FinanceSujectCriteria fsc = new FinanceSujectCriteria();
   				        fsc.createCriteria().andStatusEqualTo(Constant.DATA_VALID).andSubjectNameLike("%" + subjectName.trim() + "%").andSubjectTypeLike("财务收支%");
   				        ServiceResult<List<FinanceSujectAO>> datalist = financeSujectService.selectByCriteria(fsc);
   						if(datalist!=null && datalist.getData()!=null && datalist.getData().size()>0){
   							subjectCode = datalist.getData().get(0).getSubjectCode();
   						}else{
   							errorMsg  = errorMsg + ";" + subjectName.trim();
   							continue;
   						}
   						
   						String yearYusuan = getNumber(row.getCell(1));
   						String monthAccount =getNumber(row.getCell(14));
   						
   						dataAO.setMonthAccount(monthAccount);
   						dataAO.setSubjectName(subjectName);
   						dataAO.setSubjectCode(subjectCode);
   						dataAO.setYearNum(yearNum);
   						dataAO.setYearYusuan(yearYusuan);
   						
   						dataAO.setMonthAccount(monthAccount);
   						dataAO.setYusuanType(Constant.YUSUAN_TYPE_SHOUZHI);
   						dataAO.setCreateDate(currDate);
   						dataAO.setValid(Constant.DATA_VALID);
   						dataAO.setSort(row.getRowNum());
   						yuSuanService.saveOrUpdate(dataAO);
   						
   						BigDecimal account = new BigDecimal(0);
   						for(int m = 0 ;m < 12 ; m++){
   							
   							YusuanDetialAO tempYusuanDetial = new YusuanDetialAO();
   							tempYusuanDetial.setMonth((m + 1)<10?"0"+(m + 1):(m + 1)+"");
   							tempYusuanDetial.setYusuanId(dataAO.getId());
   							tempYusuanDetial.setValue(getNumber(row.getCell(m + 2)));
   							//计算当前月累计预算
   							System.out.println(subjectName + "-" + getNumber(row.getCell(m + 2)));
   							account = account.add(new BigDecimal(getNumber(row.getCell(m + 2))));
   							
   							tempYusuanDetial.setCurMonthAccount(account + "");
   	   						yusuanDetialService.saveOrUpdate(tempYusuanDetial);
   						}
   					}
   					
   					// get到Sheet对象
   					sheet = workbook.getSheetAt(2);
   					for (Row row : sheet) {
   						if(row.getRowNum() < 3 ){
   							continue;
   						}
   						if(row.getCell(0)==null || "".equals(row.getCell(0).toString())){
   							break;
   						}
   						YuSuanAO dataAO = new YuSuanAO();
   						String subjectName = getCellString(row.getCell(0));
   						
   						String subjectCode = "";
   						
   						FinanceSujectCriteria fsc = new FinanceSujectCriteria();
   				        fsc.createCriteria().andStatusEqualTo(Constant.DATA_VALID).andSubjectNameLike("%" + subjectName.trim() + "%").andSubjectTypeLike("利润%");
   				        ServiceResult<List<FinanceSujectAO>> datalist = financeSujectService.selectByCriteria(fsc);
   						if(datalist!=null && datalist.getData()!=null && datalist.getData().size()>0){
   							subjectCode = datalist.getData().get(0).getSubjectCode();
   						}else{
   							errorMsg  = errorMsg + ";" + subjectName.trim();
   							continue;
   						}
   						
   						String yearYusuan = getNumber(row.getCell(1));
   						String monthAccount =getNumber(row.getCell(14));
   						
   						dataAO.setMonthAccount(monthAccount);
   						dataAO.setSubjectName(subjectName);
   						dataAO.setSubjectCode(subjectCode);
   						dataAO.setYearNum(yearNum);
   						dataAO.setYearYusuan(yearYusuan);
   						dataAO.setMonthAccount(monthAccount);
   						dataAO.setYusuanType(Constant.YUSUAN_TYPE_LIRUN);
   						dataAO.setCreateDate(currDate);
   						dataAO.setValid(Constant.DATA_VALID);
   						dataAO.setSort(row.getRowNum());
   						
   						yuSuanService.saveOrUpdate(dataAO);
   						for(int m = 0 ;m < 12 ; m++){
   							YusuanDetialAO tempYusuanDetial = new YusuanDetialAO();
   							tempYusuanDetial.setMonth((m + 1)<10?"0"+(m + 1):(m + 1)+"");
   							tempYusuanDetial.setYusuanId(dataAO.getId());
   							tempYusuanDetial.setValue(getNumber(row.getCell(m + 2)));
   	   						yusuanDetialService.saveOrUpdate(tempYusuanDetial);
   						}
   					}
   					
   					is.close();
   				}
   			}
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			return "redirect:/pc/fileinfo/importBasicInfo/importyusuanData/fail";
   		}
		//年度预算,删除以前的年度预算
		YuSuanCriteria ysc = new YuSuanCriteria();
		ysc.createCriteria().andYearNumEqualTo(yearNum).andCreateDateLessThan(currDate);
		ServiceResult<List<YuSuanAO>> list = yuSuanService.selectByCriteria(ysc);
		if(list!=null && list.getData()!=null&& list.getData().size()>0){
			for(YuSuanAO temp : list.getData()){
				temp.setValid(Constant.DATA_INVALID);
				yuSuanService.saveOrUpdate(temp);
			}
		}
		return "redirect:/pc/fileinfo/importBasicInfo/importyusuanData";
   		
   	}
    public String getNumberFromString(String content) {  
        Pattern pattern = Pattern.compile("\\d+");  
        Matcher matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            return matcher.group(0);  
        }  
        return "";  
    }  

}
