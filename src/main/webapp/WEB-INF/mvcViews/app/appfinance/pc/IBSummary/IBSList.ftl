<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "投资预算汇总表">
<input type="hidden" id="group" value="report"/>
<input type="hidden" id="item" value="ibsummaryList_menu"/>
<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
				<a href="javascript:void(0)" class="btn btn-primary" onclick="create()">新建</a>
                
                <div class="table-responsive">
                <div class="col-sm-12 m-b-xs">
              		  选择年份 ：
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
	                <th>指标名称(单位:万元)<br/>Index</th>
	                <th>月份</th>
	                <th>本月实际<br/>Monthly actual data</th>
	                <th style="text-align:center;">本年累计完成</th>
	                <th style="text-align:center;" class="phone,hide">年度预算<br/>Annual budget</th>	                
	                <th style="text-align:center;" class="phone,hide">完成比例<br/>Completion ratio</th>		            
	            </tr>
            </thead>
            <tbody>
            <#assign x=0.00001>
            <#assign y=0.00001>
            <#assign z=0.00001>
            <#assign a= "">
            <#assign b= "">             
            <#if datalist?? && datalist?size gt 0>                      	
            	<#list datalist as data> 
            	<#assign b= a>
            	<#assign a =a + data.subjectName+data.yearNum>                     
	            <tr class="gradeX"> 
	            	<#if data.monthAccount?? && data.monthAccount != "">	            	
	            		<#assign x=(x?number)+(data.monthAccount?number) />
	            	</#if> 
	            	<#if data.curMonthAccount?? && data.curMonthAccount != "">
	            		<#assign y=(y?number)+(data.curMonthAccount?number)/>
	            	</#if> 
	            	<#if data.yearYusuan?? && data.yearYusuan != "">
	            	<#if b?contains(data.subjectName+data.yearNum)>
	            	        <#assign z=(z?number) />
	            	<#else>
	                 		<#assign z=(z?number)+(data.yearYusuan?number)/> 
	            	</#if>
	            	</#if>                
	                <td><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.subjectName)!}</a></td>
	                <td >${(data.month)!}</td>	             
	                <td >${(data.monthAccount)!}</td>
	                <td class="center">${(data.curMonthAccount)!}</td>
	                <td class="center">${(data.yearYusuan)!}</td>
	                <td class="center">
	                <#if data.curMonthAccount?? && data.yearYusuan??>
	                	<#if data.yearYusuan != "" && (data.yearYusuan?number) != 0>${((data.curMonthAccount?number)/(data.yearYusuan?number))?string. percent!}</#if>
	                </#if>
	                </td>	                             
	            </tr>    	            	
	         	</#list>       
	         <tr class="gradeX">
	                <td>合计 </td>
	                <td name="heji" id="heji"></td>
	                <td>${(x)?string("0.00")!}</td>
	                <td>${(y)?string("0.00")!}</td>	     
	                <td>${(z)?string("0.00")!}</td>	 
	                <td>${((((y?string("0.00"))?number)/(z?number))?string.percent)!}</td>		                          
	         </tr> 
	         </#if>  	                                	            	            	                        
            </tbody>
            <tfoot>
            	<tr>
	                <th>指标名称(单位:万元)<br/>Index</th>
	                <th>月份</th>
	                <th>本月实际<br/>Monthly actual data</th>
	                <th style="text-align:center;">本年累计完成</th>
	                <th style="text-align:center;" class="phone,hide">年度预算<br/>Annual budget</th>	                
	                <th style="text-align:center;" class="phone,hide">完成比例<br/>Completion ratio</th>		            
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
    	var mon = $(".active").find("input[name='month']").val();
    	if(mon == "all"){
    		mon = "全年合计";
    	}
    	$("#heji").html(mon);    
    	$('.dataTables-example').DataTable({
            dom: '<"html5buttons"B>lTfgitp',
            pageLength:50,
            "ordering": false,
            buttons: [
                {extend: 'copy'},
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
    
    function showform(id){
    	window.location.href="${servePath}/pc/ibsummary/showform/" + id;
    }
    
    function create(){
    	window.location.href="${servePath}/pc/ibsummary/add/";
    }
    function filer(){
    	var year =  $(".active").find("input[name='year']").val();
    	var month = $(".active").find("input[name='month']").val();
    	window.location.href = "${servePath}/pc/ibsummary/list/"+year + "/" + month;
    }        	
</script>
</@common>