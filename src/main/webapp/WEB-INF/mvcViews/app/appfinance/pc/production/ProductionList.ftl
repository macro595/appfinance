<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "生产数据预估表(月度)">
<input type="hidden" id="group" value="report"/>
<input type="hidden" id="item" value="productionList_month_menu"/>
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
                    	<label class="btn btn-sm btn-white <#if '1'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="1" onchange="filer()"> 一月 </label>
                    	<label class="btn btn-sm btn-white <#if '2'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="2" onchange="filer()"> 二月 </label>
                    	<label class="btn btn-sm btn-white <#if '3'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="3" onchange="filer()"> 三月 </label>
                    	<label class="btn btn-sm btn-white <#if '4'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="4" onchange="filer()"> 四月 </label>
                    	<label class="btn btn-sm btn-white <#if '5'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="5" onchange="filer()"> 五月 </label>
                    	<label class="btn btn-sm btn-white <#if '6'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="6" onchange="filer()"> 六月 </label>
                    	<label class="btn btn-sm btn-white <#if '7'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="7" onchange="filer()"> 七月 </label>
                    	<label class="btn btn-sm btn-white <#if '8'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="8" onchange="filer()"> 八月 </label>
                    	<label class="btn btn-sm btn-white <#if '9'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="9" onchange="filer()"> 九月 </label>
                    	<label class="btn btn-sm btn-white <#if '10'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="10" onchange="filer()"> 十月 </label>
                    	<label class="btn btn-sm btn-white <#if '11'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="11" onchange="filer()"> 十一月 </label>
                    	<label class="btn btn-sm btn-white <#if '12'=='${(selectMonth)!}'>active</#if>"> <input type="radio" id="option_all" name="month" value="12" onchange="filer()"> 十二月 </label>
                    </div>
                </div>
            <table class="table table-striped table-bordered table-hover dataTables-example" >
            <thead>
            	<tr>
	                <th style="text-align:center;">指标名称(单位:万元)<br/>Index</th>
	                <th style="text-align:center;">月份</th>
	                <th style="text-align:center;">单位<br/>Unit</th>	                
	                <th style="text-align:center;">本月实际<br/>Monthly actual data</th>
	                <th style="text-align:center;">本月预算<br/>Monthly budget</th>
	                <th style="text-align:center;" class="phone,hide">完成预算%<br/>Annual budget</th>	                
	                <th style="text-align:center;" class="phone,hide">上月实际<br/>actual last month</th>		            
	                <th style="text-align:center;" class="phone,hide">增减比例%<br/>Change in</th>		            
	            </tr>
            </thead>
            <tbody> 
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "期末在册飞机" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">期末在册飞机</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">架</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	            	                                            	                                	            	            	                        
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "平均在册飞机" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">平均在册飞机</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">架</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "可提供日历座位" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">可提供日历座位</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">个</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "ASK" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">ASK</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">可用万座公里</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "周转量" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">周转量</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万吨公里</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "旅客运输量" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">旅客运输量</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万人次</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "货邮运输量" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">货邮运输量</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">吨</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "飞行小时" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">飞行小时</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">小时</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "飞行班次" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">飞行班次</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">班次</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>                        
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "客座率" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">客座率</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">%</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "日利用率" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">日利用率</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">小时</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	            
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "含附加费小时收入" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">含附加费小时收入</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "不含附加费小时收入" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">不含附加费小时收入</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "含附加费运输收入" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">含附加费运输收入</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	                        
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "不含附加费运输收入" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">不含附加费运输收入</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "小时完全成本" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="">
	            	<td style="text-align:center;"><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.ptype)!}</a></td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">小时完全成本</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "航空运输业人均收入" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="" style="display:none">
	            	<td style="text-align:center;">${(data.subjectParentName)!}</td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>  
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">航空运输业人均收入 </th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>	            
            	<#if pddlist?? && pddlist?size gt 0>
            	<#assign a=0>
            	<#assign b=0> 
            	<#assign c=0>            	
            	<#assign d=0>           	
	            <#list pddlist as data>
	            <#assign e=0>
	            <#if "航空运输业人均利润" == data.subjectParentName>	            
	            <#if data.actual?? && data.actual != "">	            	
	            	    <#assign a=(a?number)+(data.actual?number) />
	            </#if> 
	            <#if data.value?? && data.value != "">
	            		<#assign b=(b?number)+(data.value?number)/>
	            </#if>	  
	            <#assign d=(data.month)/>          
	            <tr class="gradeX" id="" style="display:none">
	            	<td style="text-align:center;">${(data.subjectParentName)!}</td>
	                <td style="text-align:center;">${(data.month)!}</td>	                       	                
	                <td style="text-align:center;">${(data.subjectUnit)!}</td>
	                <td style="text-align:center;">${(data.actual?number)!}</td>   
	                <td style="text-align:center;">${(data.value?number)!}</td>   
	                <td style="text-align:center;"><#if data.value?? && data.value?number gt 0>${(((data.actual?number)/(data.value?number)*100))?string('0.00')!}%</#if></td>           
	                <#if prepddlist?? && prepddlist?size gt 0>
	            	<#list prepddlist as temp>	            	
	            	<#if temp.subjectParentName == data.subjectParentName && temp.ptype == data.ptype>           	            	
	            	<#if temp.actual?? && temp.actual != "">	            	
	            		<#assign c=(c?number)+(temp.actual?number)/>
	            	</#if> 	
	            	<#assign e=1> 
	            	<td style="text-align:center;"><#if temp.actual??>${(temp.actual?number)!}</#if></td>   
	                <td style="text-align:center;"><#if temp.actual?? && temp.actual?number gt 0>${((((data.actual?number)/(temp.actual?number))-1)*100)?string('0.00')!}%</#if></td>		              		              	                
	                </#if> 
	                </#list>
	          	    </#if> 
	          	    <#if e==0>	            	
	            		<td style="text-align:center;">-</td>
	                	<td style="text-align:center;">-</td>
	            	</#if>     	                                                    
	            </tr>
	            </#if> 
	            </#list>         
	            </#if>
            	<tr>
	                <th style="text-align:center;">航空运输业人均利润</th>
	                <th style="text-align:center;"><#if d?? && d?number gt 0>${(d)!}<#else>-</#if></th>
	                <th style="text-align:center;">万元</th>	                
	                <th style="text-align:center;"><#if a?? && a?number gt 0>${(a)!}</#if></th>
	                <th style="text-align:center;"><#if b?? && b?number gt 0>${(b)!}</#if></th>
	                <th style="text-align:center;" class="phone,hide"><#if a?? && b??><#if (a?number gt 0) && (b?number gt 0)>${(((a?number)/(b?number))*100)?string('0.00')!}%</#if><#else>-</#if></th>	                
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${(c)!}<#else>-</#if></th>		            
	                <th style="text-align:center;" class="phone,hide"><#if c?? && c?number gt 0>${((((a?number)/(c?number))-1)*100)?string('0.00')!}%<#else>-</#if></th>		            
	            </tr>
            </tbody>
            <tfoot>
            	<tr>
	                <th style="text-align:center;">指标名称(单位:万元)<br/>Index</th>
	                <th style="text-align:center;">月份</th>
	                <th style="text-align:center;">单位<br/>Unit</th>	                
	                <th style="text-align:center;">本月实际<br/>Monthly actual data</th>
	                <th style="text-align:center;">本月预算<br/>Monthly budget</th>
	                <th style="text-align:center;" class="phone,hide">完成预算%<br/>Annual budget</th>	                
	                <th style="text-align:center;" class="phone,hide">上月实际<br/>actual last month</th>		            
	                <th style="text-align:center;" class="phone,hide">增减比例%<br/>Change in</th>		            
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
    	window.location.href="${servePath}/pc/production/showform/" + id;
    }
    
    function create(){
    	window.location.href="${servePath}/pc/production/addofmonth/";
    }
    function filer(){
    	var year =  $(".active").find("input[name='year']").val();
    	var month = $(".active").find("input[name='month']").val();
    	window.location.href = "${servePath}/pc/production/listformonth/"+year + "/" + month;
    }        	
</script>
</@common>