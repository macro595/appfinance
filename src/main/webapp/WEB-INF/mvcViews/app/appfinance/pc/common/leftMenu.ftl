<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element"> <span>
                	 <img alt="image" class="" style="width:100px" src="${staticServePath}/images/logo.gif" />
                     </span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                    <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">财务报表系统</strong>
                     </span> </span> </a>
                    
                </div>
                <div class="logo-element">
                   	 财
                </div>
            </li>
            
            <li id="taizhang">
                <a href="${servePath}/pc/contractinfo/list"><i class="fa fa-database"></i> <span class="nav-label">收付款台账</span></span></a>
            </li>
            <li id="report">
                <a href="javascript:void(0)"><i class="fa fa-database"></i> <span class="nav-label">预算执行</span><span class="fa arrow"></span></span></a>
                <ul class="nav nav-second-level collapse">
                    <li id="twAccount_menu"><a href="${servePath}/pc/report/twAccount">十二大成本</a></li>
                    <li id="caiwushouzhi_menu"><a href="${servePath}/pc/report/caiwushouzhi/cur/cur">财务收支-月度</a></li>
                    <li id="yearcaiwushouzhi_menu"><a href="${servePath}/pc/report/caiwushouzhiforyear/cur/cur">财务收支-年度累计</a></li>
                    <li id="profitBudget_menu"><a href="${servePath}/pc/report/profitBudgetForMonth/cur/cur">利润预算-月度</a></li>
                    <li id="yearForProfitBudget_menu"><a href="${servePath}/pc/report/yearForProfitBudget/cur/cur">利润预算-年度累计</a></li>
                    <li id="ibsummaryList_menu"><a href="${servePath}/pc/ibsummary/list/cur/cur">投资预算汇总表</a></li>                       
                    <li id="babudgetList_month_menu"><a href="${servePath}/pc/babudget/listformonth/cur/cur">业务活动费预算表(月度)</a></li>                       
                    <li id="babudgetList_menu"><a href="${servePath}/pc/babudget/listforyear/cur/cur">业务活动费预算表(年度)</a></li> 
                    <li id="productionList_month_menu"><a href="${servePath}/pc/production/listformonth/cur/cur">生产数据预估(月度)</a></li>                       
                    <li id="productionList_menu"><a href="${servePath}/pc/production/listforyear/cur/cur">生产数据预估(年度)</a></li>                                                             
                </ul>
            </li>
            <li id="import">
                <a href="javascript:void(0)"><i class="fa fa-database"></i> <span class="nav-label">基础数据导入</span><span class="fa arrow"></span></span></a>
                <ul class="nav nav-second-level collapse">
                    <li id="importHNAData_menu"><a href="${servePath}/pc/fileinfo/importBasicInfo/importHNAData">HNA总帐科目余额表导入</a></li>
                    <li id="importBookingData_menu"><a href="${servePath}/pc/fileinfo/importBasicInfo/importBookingData">收付款台账数据导入</a></li>
                    <li id="importyusuanData_menu"><a href="${servePath}/pc/fileinfo/importBasicInfo/importyusuanData">年度预算导入</a></li>
                    <li id="accountbalancesheet_menu"><a href="${servePath}/pc/accountbalancesheet">原始数据</a></li>
                </ul>
            </li>
            <li id="config">
                <a href="javascript:void(0)"><i class="fa fa-database"></i> <span class="nav-label">配置</span><span class="fa arrow"></span></span></a>
                <ul class="nav nav-second-level collapse">
                    <li id="zhibiao_menu"><a href="${servePath}/pc/financesuject">指标配置</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>