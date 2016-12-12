/*
 * Copyright (c) 2012, chzh.xiao technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.xp.app.appfinance.common;

/**
 * 视图名枚举，请使用当前目录的GenerateMVCViewName类自动更新本枚举类。 <br/> <br/> 枚举条目定义规则如下: <br/> 视图名：/framework/common/view.ftl ===》
 * FRAMEWORK_COMMON_VIEW("/framework/common/view") <br/> <br/> <b>注意:</b> 如果视图名包含<b>'-'</b>, 那么该字符自动忽略。例如： <br/>
 * 视图名：/framework/common/xxx-view.ftl ===》 FRAMEWORK_COMMON_XXXVIEW("/framework/common/xxx-view")
 *
 * @author Yuanjun.Li
 * @author Liyuan Li
 *
 */
public enum MVCViewName {

	// @#############
	APP_APPFINANCE_PC_BABUDGET_BABCONFIGFORM("/app/appfinance/pc/babudget/babConfigForm"),
	APP_APPFINANCE_PC_BABUDGET_BABUDGET("/app/appfinance/pc/babudget/baBudget"),
	APP_APPFINANCE_PC_BABUDGET_BABUDGETFORYEAR("/app/appfinance/pc/babudget/babudgetforyear"),
	APP_APPFINANCE_PC_BASIC_HANITEMINFO("/app/appfinance/pc/basic/haniteminfo"),
	APP_APPFINANCE_PC_BASIC_HOMEPAGE("/app/appfinance/pc/basic/homepage"),
	APP_APPFINANCE_PC_BASIC_IMPORTINFO("/app/appfinance/pc/basic/importInfo"),
	APP_APPFINANCE_PC_BASIC_LOGIN("/app/appfinance/pc/basic/login"),
	APP_APPFINANCE_PC_BOOKING_SHOUZHIBOOKING("/app/appfinance/pc/booking/shouzhibooking"),
	APP_APPFINANCE_PC_BOOKING_SHOUZHIBOOKINGFORM("/app/appfinance/pc/booking/shouzhibookingform"),
	APP_APPFINANCE_PC_COMMON_BASEPAGE("/app/appfinance/pc/common/basePage"),
	APP_APPFINANCE_PC_COMMON_LEFTMENU("/app/appfinance/pc/common/leftMenu"),
	APP_APPFINANCE_PC_COMMON_TOPHEADER("/app/appfinance/pc/common/topHeader"),
	APP_APPFINANCE_PC_COMMON_UTIL_COMPONENTMACRO("/app/appfinance/pc/common/util/componentMacro"),
	APP_APPFINANCE_PC_COMMON_UTIL_STATICMACRO("/app/appfinance/pc/common/util/staticMacro"),
	APP_APPFINANCE_PC_IBSUMMARY_IBSCONFIGFORM("/app/appfinance/pc/IBSummary/IBSConfigForm"),
	APP_APPFINANCE_PC_IBSUMMARY_IBSLIST("/app/appfinance/pc/IBSummary/IBSList"),
	APP_APPFINANCE_PC_PRODUCTION_PRODUCTIONLIST("/app/appfinance/pc/production/ProductionList"),
	APP_APPFINANCE_PC_PRODUCTION_PROMONTHCONFIGFORM("/app/appfinance/pc/production/proMonthConfigForm"),
	APP_APPFINANCE_PC_PRODUCTION_PROYEARCONFIGFORM("/app/appfinance/pc/production/proYearConfigForm"),
	APP_APPFINANCE_PC_PRODUCTION_PYEARLIST("/app/appfinance/pc/production/PYearList"),
	APP_APPFINANCE_PC_PROFIT_PROFITBUDGET("/app/appfinance/pc/profit/profitBudget"),
	APP_APPFINANCE_PC_PROFIT_PROFITBUDGETFORYEAR("/app/appfinance/pc/profit/profitBudgetForYear"),
	APP_APPFINANCE_PC_YUSUANZHIXING_CAIWUSHOUZHI("/app/appfinance/pc/yusuanzhixing/caiwuShouzhi"),
	APP_APPFINANCE_PC_YUSUANZHIXING_CAIWUSHOUZHIFORYEAR("/app/appfinance/pc/yusuanzhixing/caiwuShouzhiforyear"),
	APP_APPFINANCE_PC_YUSUANZHIXING_FILTER("/app/appfinance/pc/yusuanzhixing/filter"),
	APP_APPFINANCE_PC_YUSUANZHIXING_SUBJECTCONFIG("/app/appfinance/pc/yusuanzhixing/subjectConfig"),
	APP_APPFINANCE_PC_YUSUANZHIXING_SUBJECTCONFIGFORM("/app/appfinance/pc/yusuanzhixing/subjectConfigForm"),
	APP_APPFINANCE_PC_YUSUANZHIXING_TWACCOUNT("/app/appfinance/pc/yusuanzhixing/twAccount"),
	ERROR_500("/error/500");
// @#############
    
    
    // 成员变量
    private String viewName;

    // 构造方法
    private MVCViewName(String viewName) {
        this.viewName = viewName;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.viewName;
    }
}
