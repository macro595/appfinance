<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min",
"/styles/form"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "财务收支预算">
<input type="hidden" id="group" value="report"/>
<input type="hidden" id="item" value="yearcaiwushouzhi_menu"/>
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
              		  选择年份 ：
                    <div data-toggle="buttons" class="btn-group">
                    	<#list yearList as yearDate>
                    	<label class="btn btn-sm btn-white <#if '${(yearDate)!}'=='${(selectYear)!}'>active</#if>"> <input type="radio" id="option_all" name="year" value="${(yearDate)!}" onchange="filer()">${(yearDate)!} </label>
                    	</#list>
                    </div>
                </div>
                <div class="col-sm-12 m-b-xs">
                	选择月度 ：
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
	                <th style="min-width:250px">指标名称<br/>Index</th>
	                <th class="phone,hide">本年累计完成<br/>Cumulative </th>
	                <th class="phone,hide">当期累计预算<br/>Cumulative budget</th>
	                <th class="phone,hide">完成当期预算%<br/>Completion ratio</th>
	                <th class="phone,hide">上年同期<br/>Last year data</th>
	                <th class="phone,hide">增减比例%<br/>Change in %</th>
	                <th class="phone,hide">年度预算<br/>Annual budget</th>
	                <th class="phone,hide">完成年度预算%<br/>Completion ratio of annual budget</th>
	            </tr>
            </thead>
            <tbody>
            <#if (datalist?size>0) >
           	 	<tr class="gradeX" id="">
	                <td class="label_first">一、总收入</td>
	                <#list datalist as data>
	                <#if "总收入" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>
	                <#break>
	                </#if>
	                <#if "${(data_index)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>
	            </tr>
           	 	<tr class="gradeX" >
	                <td class="label_sec">营业收入</td>
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
	                <#if "${(data_index)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>
	            </tr>
           	 	<tr class="gradeX" id="zhuyingshouru">
	                <td class="label_sec">主营业务收入</td>
	                <#list datalist as data>
	                <#if "主营业务收入" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>
	                <#break>
	                </#if>
	                <#if "${(data_index)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>
	            </tr>
           	 	<tr class="gradeX" id="keyun">
	                <td class="label_four">其中：客运收入</td>
	                <#list datalist as data>
	                <#if "客运收入" == "${(data.subjectName)!}">
	                <td >${(data.monthTotal)!}</td>
	                <td class="center">${(data.yusuanMonthAccount)!}</td>
	                <td class="center">${(data.accountYusuanshijiBi)!}%</td>
	                <td class="center">${(data.preyearMonthTotal)!}</td>
	                <td class="center">${(data.yearHuanBi)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">${(data.wanchengBi)!}%</td>
	                <#break>
	                </#if>
	                <#if "${(data_index)!}"=="${(datalist?size)!}">
	                <td>-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                <td class="center">-</td>
	                </#if>
	                </#list>
	            </tr>
           	 	<tr class="gradeX" id="ranyou">
	                <td class="label_four">其中：燃油附加费收入</td>
	                <#list datalist as data>
	                <#if "燃油附加费收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="huoyou">
	                <td class="label_four">货邮收入</td>
	                <#list datalist as data>
	                <#if "货邮收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="weixiu">
	                <td class="label_four">维修收入</td>
	                <#list datalist as data>
	                <#if "维修收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="daili">
	                <td class="label_four">代理收入</td>
	                <#list datalist as data>
	                <#if "代理收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="peixun">
	                <td class="label_four">培训收入</td>
	                <#list datalist as data>
	                <#if "培训收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="peican">
	                <td class="label_four">配餐收入</td>
	                <#list datalist as data>
	                <#if "配餐收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="qitayewushouru">
	                <td class="label_thr">(二)其他业务收入</td>
	                <#list datalist as data>
	                <#if "其他业务收入" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX" id="yingyewaishouru">
	                <td class="label_sec">营业外收入</td>
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
	            </tr>
	            
           	 	<tr class="gradeX">
	                <td class="label_first">二、总成本</td>
	                <#list datalist as data>
	                <#if "总成本" == "${(data.subjectName)!}">
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">生产运营成本</td>
	                <#list datalist as data>
	                <#if "生产运营成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">其中：航油（燃油）成本</td>
	                <#list datalist as data>
	                <#if "航油成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">飞机（船舶）租金</td>
	                <#list datalist as data>
	                <#if "飞机租金" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">航材成本</td>
	                <#list datalist as data>
	                <#if "航材成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">维修成本</td>
	                <#list datalist as data>
	                <#if "维修成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">起降服务费</td>
	                <#list datalist as data>
	                <#if "起降服务费" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">配餐及机供品</td>
	                <#list datalist as data>
	                <#if "配餐及机供品" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">  港口使用</td>
	                <#list datalist as data>
	                <#if "港口使用" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">  物流代理成本</td>
	                <#list datalist as data>
	                <#if "物流代理成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">  项目成本</td>
	                <#list datalist as data>
	                <#if "项目成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">  商品购进成本</td>
	                <#list datalist as data>
	                <#if "商品购进成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_thr">  其他成本</td>
	                <#list datalist as data>
	                <#if "其他成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">       折旧及摊销</td>
	                <#list datalist as data>
	                <#if "折旧及摊销" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">销售类费用</td>
	                <#list datalist as data>
	                <#if "销售类费用" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">管理类费用</td>
	                <#list datalist as data>
	                <#if "管理类费用" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">财务费用</td>
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">人工成本</td>
	                <#list datalist as data>
	                <#if "人工成本" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">税金</td>
	                <#list datalist as data>
	                <#if "税金" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">营业外支出</td>
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_sec">其他</td>
	                <#list datalist as data>
	                <#if "其他" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_fir"> 三、投资收益</td>
	                <#list datalist as data>
	                <#if "投资收益" == "${(data.subjectName)!}">
	                 
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_fir"> 四、公允价值变动收益</td>
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
	            </tr>
           	 	<tr class="gradeX">
	                <td class="label_fir"> 五、净利润</td>
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
	            </tr>
            </tbody>
            </#if>
            
            <tfoot>
           <tr>
	                <th style="min-width:200px">指标名称<br/>Index</th>
	                <th class="phone,hide">本年累计完成<br/>Cumulative </th>
	                <th class="phone,hide">当期累计预算<br/>Cumulative budget</th>
	                <th class="phone,hide">完成当期预算%<br/>Completion ratio</th>
	                <th class="phone,hide">上年同期<br/>Last year data</th>
	                <th class="phone,hide">增减比例%<br/>Change in %</th>
	                <th class="phone,hide">年度预算<br/>Annual budget</th>
	                <th class="phone,hide">完成年度预算%<br/>Completion ratio of annual budget</th>
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
        $(".dataTables_length").hide();
        $(".pagination").hide();
        $(".dataTables_info").hide();
    });
    
    function filer(){
    	var year = $(".btn-group .active").find("input[name='year']").val();
    	var month = $(".btn-group .active").find("input[name='month']").val();
    	window.location.href = "${servePath}/pc/report/caiwushouzhiforyear/"+year + "/" + month;
    }
    
</script>
</@common>