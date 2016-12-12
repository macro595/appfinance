<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min",
"/styles/form"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "利润预算表(年度)">
<input type="hidden" id="group" value="report"/>
<input type="hidden" id="item" value="yearForProfitBudget_menu"/>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                        <i class="fa fa-wrench"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">

            <div class="table-responsive">
                <div class="col-sm-12 m-b-xs">
              		  选择全部 ：
                    <div data-toggle="buttons" class="btn-group">
         			<label class="btn btn-sm btn-white <#if 'cur'=='${(selectYear)!}'>active</#if>"> <input type="radio" id="option_cur" name="year" value="cur" onchange="filer()"> 当前 </label> 
                    <#if yearList?? && yearList?size gt 0>
                    <#list yearList as item>
                    <label class="btn btn-sm btn-white <#if '${(item)!}'=='${(selectYear)!}'>active</#if>"> <input type="radio" onchange="filer()" id="option_${(item)!}" name="year" value="${(item)!}"> ${(item)!} </label>
                    </#list>  
                    </#if>  
                    </div>
                </div>
                <div class="col-sm-12 m-b-xs">
                	选择月份 ：
                    <div data-toggle="buttons" class="btn-group">
                    	<label class="btn btn-sm btn-white <#if '01'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="01" onchange="filer()"> 一月 </label>
                    	<label class="btn btn-sm btn-white <#if '02'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="02" onchange="filer()"> 二月 </label>
                    	<label class="btn btn-sm btn-white <#if '03'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="03" onchange="filer()"> 三月 </label>
                    	<label class="btn btn-sm btn-white <#if '04'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="04" onchange="filer()"> 四月 </label>
                    	<label class="btn btn-sm btn-white <#if '05'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="05" onchange="filer()"> 五月 </label>
                    	<label class="btn btn-sm btn-white <#if '06'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="06" onchange="filer()"> 六月 </label>
                    	<label class="btn btn-sm btn-white <#if '07'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="07" onchange="filer()"> 七月 </label>
                    	<label class="btn btn-sm btn-white <#if '08'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="08" onchange="filer()"> 八月 </label>
                    	<label class="btn btn-sm btn-white <#if '09'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="09" onchange="filer()"> 九月 </label>
                    	<label class="btn btn-sm btn-white <#if '10'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="10" onchange="filer()"> 十月 </label>
                    	<label class="btn btn-sm btn-white <#if '11'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="11" onchange="filer()"> 十一月 </label>
                    	<label class="btn btn-sm btn-white <#if '12'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="12" onchange="filer()"> 十二月 </label>
                    </div>
                </div>
            <table class="table table-striped table-bordered table-hover dataTables-example" >
            <thead>
            	<tr>
	                <th style="text-align:center;">指标名称<br/>Index</th>
	                <th style="text-align:center;">本年累计完成</th>
	                <th style="text-align:center;">当期累计预算<br/>Cumulative</th>
	                <th style="text-align:center;" class="phone,hide">完成当期预算%<br/>Completion ratio</th>
	                <th style="text-align:center;" class="phone,hide">上年同期<br/>Last year data</th>
	                <th style="text-align:center;" class="phone,hide">增减比例%<br/>Change in %</th>	
	                <th style="text-align:center;" class="phone,hide">年度预算<br/>Annual budget</th>
	                <th style="text-align:center;" class="phone,hide">完成年度预算%<br/>Completion ratio of annual budget</th>	                                
	            </tr>
            </thead>
            <tbody>           
           	 	<tr class="gradeX" id="">
	                <td class="label_fir">一、营业收入</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "营业收入" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list> 
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>               
	            </tr>
           	 	<tr class="gradeX" id="">
	                <td class="label_thr">减：营业成本</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "营业成本" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   	                                                 
	            </tr>
           	 	<tr class="gradeX" id="">
	                <td class="label_four">营业税金及附加</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "营业税金及附加" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>	       
           	 	<tr class="gradeX" id="ranyou">
	                <td class="label_four">销售费用</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "销售费用" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                             
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="huoyou">
	                <td class="label_four"> 管理费用</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "管理费用" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="weixiu">
	                <td class="label_four">财务费用</td>
	                <#if datalist?? && datalist?size gt 0> 
 					<#list datalist as data>
	                <#if "财务费用" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                               
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="daili">
	                <td class="label_four">资产减值损失</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "资产减值损失" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                              
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="peixun">
	                <td class="label_thr">加：公允价值变动收益（损失以“－”号表示）</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "公允价值变动收益" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="peican">
	                <td class="label_four">其中：对联营企业和合营企业的投资收益 </td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "对联营企业和合营企业的投资收益" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                             
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="qitayewushouru">
	                <td class="label_first">二、营业利润（亏损以“－”号表示）</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "营业利润" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX" id="yingyewaishouru">
	                <td class="label_thr">加：营业外收入</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "营业外收入" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                               
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>	            
           	 	<tr class="gradeX">
	                <td class="label_four">其中：补贴收入</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "补贴收入" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                               
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">减：营业外支出</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "营业外支出" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_four">其中：非流动资产处置损失</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "非流动资产处置损失" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>		                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_fir"> 三、利润总额（亏损以“－”号表示）</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "利润总额" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>		                                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   	
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">减：所得税</td>
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "所得税" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                	                
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_fir"> 四、净利润（亏损以“－”号表示）</td>	             
	                <#if datalist?? && datalist?size gt 0>
 					<#list datalist as data>
	                <#if "净利润" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>	              
	                <#break>
	                </#if>
	                <#if "${(data_index+1)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>	                               
	                <#else>
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>   
	            </tr>
            </tbody>
            <tfoot>
            	<tr>
	                <th style="text-align:center;">指标名称<br/>Index</th>
	                <th style="text-align:center;">本年累计完成</th>
	                <th style="text-align:center;">当期累计预算<br/>Cumulative</th>
	                <th style="text-align:center;" class="phone,hide">完成当期预算%<br/>Completion ratio</th>
	                <th style="text-align:center;" class="phone,hide">上年同期<br/>Last year data</th>
	                <th style="text-align:center;" class="phone,hide">增减比例%<br/>Change in %</th>	
	                <th style="text-align:center;" class="phone,hide">年度预算<br/>Annual budget</th>
	                <th style="text-align:center;" class="phone,hide">完成年度预算%<br/>Completion ratio of annual budget</th>	                                
	            </tr>
            </tfoot>
            </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
    	$('.dataTables-example').DataTable({
            dom: '<"html5buttons"B>lTfgitp',
            pageLength:50,
            "ordering": false,
            buttons: [
                { extend: 'copy'},
                {extend: 'csv'},
                {extend: 'excel', title: 'ExampleFile'},
                {extend: 'pdf', title: 'ExampleFile'},

                {extend: 'print',
                 customize: function (win){
                        $(win.document.body).addClass('white-bg');
                        $(win.document.body).css('font-size', '10px');

                        $(win.document.body).find('table')
                                .addClass('compact')
                                .css('font-size', 'inherit');
                }
                }
            ]
        });            
    }); 
    function filer(){
    	var year = $(".active").find("input[name='year']").val();
    	var month = $(".active").find("input[name='month']").val();
    	window.location.href = "${servePath}/pc/report/yearForProfitBudget/"+year + "/" + month;
    } 
     
</script>
</@common>