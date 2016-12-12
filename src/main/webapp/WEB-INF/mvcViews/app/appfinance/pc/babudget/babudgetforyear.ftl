<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min",
"/styles/form"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "业务活动费预算表(年度)">
<input type="hidden" id="group" value="report"/>
<input type="hidden" id="item" value="babudgetList_menu"/>
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
                    	<label class="btn btn-sm btn-white <#if 'all'=='${(selectYear)!}'>active</#if>"> <input type="radio" id="option_cur" name="year" value="cur" onchange="filer()"> 当前 </label>
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
	                <th style="text-align:center;">指标名称(单位：万元)<br/>Index</th>
	                <th style="text-align:center;">月度</th>
	                <th style="text-align:center;">本年累计完成<br/>Monthly actual data</th>
	                <th style="text-align:center;" class="phone,hide">年度预算<br/>Monthly budget</th>
	                <th style="text-align:center;"  class="phone,hide">完成年度预算%<br/>Completion ratio</th>
	            </tr>
            </thead>
            <tbody>           
            <#assign x=0>
            <#assign y=0>            
           	<#if babudgetlist?? && babudgetlist?size gt 0>
 			<#list babudgetlist as data>
 			<#if babudgetlist?? && babudgetlist?size gt 0>
	        <#list babudgetdlist as list>
			<tr class="gradeX" id="">
			<#if data.id == list.yusuanId>
	            <#if list.actual?? && list.actual != "">	            	
	            		<#assign x=(x?number)+(list.curMonthAccount?number) />
	            </#if> 
	            <#if list.value?? && list.value != "">
	            		<#assign y=(y?number)+(data.yearYusuan?number)/>
	            </#if>			
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}','${(list.id)!}')" >${(data.subjectName)!}</a></td> 
	                <td style="text-align:center;">${(selectMonth)!}</td>	                
					<td style="text-align:center;">${(list.curMonthAccount?number)?string("0.00")!}</td>					
	                <td style="text-align:center;">${(data.yearYusuan?number)?string("0.00")!}</td>   
	                <td style="text-align:center;"><#if data.yearYusuan?? && data.yearYusuan?number gt 0>${(((list.curMonthAccount?number)/(data.yearYusuan?number))*100)?string('0.00')!}%</#if></td>  	  	                                                          
	            </tr>
	        </#if> 	                           
	        </#list>         
	        </#if>
	        </#list>         
	        </#if>		        	                
		         <tr class="gradeX" id="ranyou">
		                <td style="text-align:center;">业务活动费合计 </td>
		                <td style="text-align:center;" name="heji" id="heji">${(selectMonth)!}</td>
		                <td style="text-align:center;"><#if x?number gt 0>${(x)?string("0.00")!}</#if></td>
		                <td style="text-align:center;"><#if y?number gt 0>${(y)?string("0.00")!}</#if></td>	     
		                <td style="text-align:center;"><#if (x?number gt 0) && (y?number gt 0)>${((((x?number)/(y?number))*100)?string('0.00'))!}%</#if></td>	 
		         </tr> 	            
            </tbody>
            <tfoot>
            	<tr>
	                <th style="text-align:center;">指标名称(单位：万元)<br/>Index</th>
	                <th style="text-align:center;">月度</th>
	                <th style="text-align:center;">本年累计完成<br/>Monthly actual data</th>
	                <th style="text-align:center;" class="phone,hide">年度预算<br/>Monthly budget</th>
	                <th style="text-align:center;"  class="phone,hide">完成年度预算%<br/>Completion ratio</th>
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
        var excelFile = document.title + "-"+ $(".active").find("input[name='year']").val() + "-" + $(".active").find("input[name='month']").val();
    	$('.dataTables-example').DataTable({
            dom: '<"html5buttons"B>lTfgitp',
            pageLength:50,
            "ordering": false,
            buttons: [
                { extend: 'copy'},
                {extend: 'csv'},
                {extend: 'excel', title: excelFile},
                {extend: 'pdf', title: excelFile},
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
    	window.location.href = "${servePath}/pc/babudget/listforyear/"+year + "/" + month;
    } 
    function showform(id,did){
    	window.location.href="${servePath}/pc/babudget/showform/" + id+ "/" + did;
    }        
</script>
</@common>