<#include "../common/basePage.ftl">
<@addCSS [
"/styles/easyTree",
"/styles/bigautocomplete"
]/>

<@addJS [
"/scripts/easyTree",
"/scripts/bigautocomplete"
]/>
<@common "生产数据月度指标配置">
<div class="row">
	<div class="col-lg-12">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="dropdown-toggle" data-toggle="dropdown"
						href="form_basic.html#"> 
					</a>
					<a class="close-link" onclick="goback()"> <i class="fa fa-times"></i>
					</a>
				</div>
			</div>
			<div class="ibox-content">
				<input type="hidden" id="subModule" value="financesuject"/>
				<form method="get" class="form-horizontal" id="iform"  accept-charset="utf-8" action="${servePath}/pc/production/submitForm">
					<input type="hidden" id="id" name="id" value=""/>
					<input type="hidden" id="subjectUnit" name="subjectUnit" value=""/>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<label class="col-sm-2 control-label">年度</label>
						<div class="col-sm-10">
						    <select class="form-control main m-b yearNum" id="yearNum" name="yearNum">
						    <option  value="">--请选择年度--</option>
						    <#if yearList?? && yearList?size gt 0>	
                            <#list yearList as item>
                                <option <#if "${(item)!}" == "${(dataAO.yearNum)!}"> selected="true"</#if> value="${(item)!}">${(item)!}</option>                  
                        	</#list>
                        	</#if>
                        	</select>
						</div>
					</div>					
					<div class="form-group">
						<label class="col-sm-2 control-label">月份</label>
						<div class="col-sm-10">
						    <select class="form-control main sub m-b month" id="month" name="month">
                                <option  value="">--请选择月份--</option>						    
                                <option <#if "1" == "${(dataAO.month)!}"> selected="true"</#if> value="1">01</option> 
                                <option <#if "2" == "${(dataAO.month)!}"> selected="true"</#if> value="2">02</option>
                                <option <#if "3" == "${(dataAO.month)!}"> selected="true"</#if> value="3">03</option>
                                <option <#if "4" == "${(dataAO.month)!}"> selected="true"</#if> value="4">04</option>
                                <option <#if "5" == "${(dataAO.month)!}"> selected="true"</#if> value="5">05</option>
                                <option <#if "6" == "${(dataAO.month)!}"> selected="true"</#if> value="6">06</option>
                                <option <#if "7" == "${(dataAO.month)!}"> selected="true"</#if> value="7">07</option>
                                <option <#if "8" == "${(dataAO.month)!}"> selected="true"</#if> value="8">08</option>
                                <option <#if "9" == "${(dataAO.month)!}"> selected="true"</#if> value="9">09</option>
                                <option <#if "10" == "${(dataAO.month)!}"> selected="true"</#if> value="10">10</option>
                                <option <#if "11" == "${(dataAO.month)!}"> selected="true"</#if> value="11">11</option>
                                <option <#if "12" == "${(dataAO.month)!}"> selected="true"</#if> value="12">12</option>                 
                        	</select>
						</div>
					</div>					
					<div class="form-group">
						<label class="col-sm-2 control-label">飞机类型</label>
						<div class="col-sm-10">
						    <select class="form-control m-b main ptype" id="ptype" name="ptype">				    
                                <option value="">--请选择飞机类型--</option>                  
						    <#if planList?? && planList?size gt 0>	
                            <#list planList as item>
                                <option <#if "${(item.subjectName)!}" == "${(dataAO.ptype)!}"> selected="true"</#if>     value="${(item.subjectName)!}">${(item.subjectName)!}</option>                  
                        	</#list>
                        	</#if> 	
                        	</select>
						</div>
					</div>					
					<div class="form-group">
						<label class="col-sm-2 control-label">指标名称</label>
						<div class="col-sm-10">
						    <select class="form-control m-b main subjectParentName" id="subjectParentName" name="subjectParentName">				    
                                <option value="">--请选择所添加指标名称--</option>                  
						    <#if itemList?? && itemList?size gt 0>	
                            <#list itemList as item>
                                <option <#if "${(item.subjectName)!}" == "${(dataAO.subjectParentName)!}"> selected="true"</#if>   value="${(item.subjectName)!},${(item.unit)!}">${(item.subjectName)!}(单位:${(item.unit)!})</option>
                        	</#list>
                        	</#if> 	
                        	</select>
						</div>
					</div>															
					
					<div class="form-group">
						<label class="col-sm-2 control-label">本月实际</label>
						<div class="col-sm-10">
							<input id="actual" type="text" placeholder="本月实际" class="form-control"
								required="true" name ="actual" value="${(dataAO.actual)!}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">本月预算</label>
						<div class="col-sm-10">
							<input id="value" type="text" placeholder="本月预算" class="form-control"
								required="true" name ="value" value="${(dataAO.value)!}">
						</div>
					</div>					
					<div class="form-group">
						<label class="col-sm-2 control-label">本年累计完成</label>
						<div class="col-sm-10">
							<input id="cumulativeActual" type="text" placeholder="本年累计完成" class="form-control"
								required="true" name ="cumulativeActual" value="${(dataAO.cumulativeActual)!}">
						</div>
					</div>		

					<div class="form-group">
						<label class="col-sm-2 control-label">当期累计预算</label>
						<div class="col-sm-10">
							<input id="cumulativeBudget" type="text" placeholder="本年累计完成" class="form-control"
								required="true" name ="cumulativeBudget" value="${(dataAO.cumulativeBudget)!}">
						</div>
					</div>

					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<div class="col-sm-4 col-sm-offset-2">
							<button class="btn btn-white" type="button" onclick="goback()">取消</button>
							<a href="javascript:void(0)" class="btn btn-primary" onclick="saveform()">保存</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
    $(document).ready(function(){	
        var id,subjectParentName,yearNum,month,ptype,subjectUnit;                
		$(".main").change(function(){
		  id = $("#id").val();
		  ptype = $("#ptype").val();
		  subjectParentName = $("#subjectParentName").val();
    	  yearNum = $("#yearNum").val();
    	  month = $("#month").val();    	  
    	  if(yearNum !== "" && month !== ""){	
    	    if((subjectParentName == "航空运输业人均收入,万元") || (subjectParentName == "航空运输业人均利润,万元")){
 		   		ptype = subjectParentName;
 		   		getObject(yearNum,month,subjectParentName,ptype); 	
 		   		}
    	  	if(ptype !== "" && subjectParentName !== ""){
 		   		getObject(yearNum,month,subjectParentName,ptype); 	
 		   		}	   
 		  }
       }); 
       $(".subjectParentName").change(function(){
        	var start,end,subjectName;
        	subjectName = $("#subjectParentName").val().trim();
       		start = subjectName.indexOf(",")+1;
       		end = subjectName.length;
       		$("#subjectUnit").val(subjectName.substring(start,end));
       });     
    });
	function goback(){
		window.location.href="${servePath}/pc/production/listformonth/cur/cur";
	}
	
	function saveform(){
		var subjectParentName,yearNum,month,ptype,actual,value,cumulativeBudget,cumulativeActual;
		subjectParentName = $("#subjectParentName").val();
    	yearNum = $("#yearNum").val();
    	month = $("#month").val();
    	ptype = $("#ptype").val();
    	actual = $("#actual").val();
    	value = $("#value").val();
    	cumulativeBudget = $("#cumulativeBudget").val();
    	cumulativeActual = $("#cumulativeActual").val(); 
    	if((subjectParentName == "航空运输业人均收入,万元") || (subjectParentName == "航空运输业人均利润,万元")){
				if(yearNum == "" || yearNum == null){alert("请录入完整表单数据");return false;}
    			if(month == "" || month == null){alert("请录入完整表单数据");return false;}
    			if(actual == "" || actual == null){alert("请录入完整表单数据");return false;}
    			if(value == "" || value == null){alert("请录入完整表单数据");return false;}	
 				if(cumulativeBudget == "" || cumulativeBudget == null){alert("请录入完整表单数据");return false;}
    			if(cumulativeActual == "" || cumulativeActual == null){alert("请录入完整表单数据");return false;}
 				$("form").submit();	    	   	
    	   	}
    	if(ptype == "" || ptype == null){alert("请录入完整表单数据");return false;}
    	if(subjectParentName == "" || subjectParentName == null){alert("请录入完整表单数据");return false;}
    	if(yearNum == "" || yearNum == null){alert("请录入完整表单数据");return false;}
    	if(month == "" || month == null){alert("请录入完整表单数据");return false;}
    	if(actual == "" || actual == null){alert("请录入完整表单数据");return false;}
    	if(value == "" || value == null){alert("请录入完整表单数据");return false;}	
 		if(cumulativeBudget == "" || cumulativeBudget == null){alert("请录入完整表单数据");return false;}
    	if(cumulativeActual == "" || cumulativeActual == null){alert("请录入完整表单数据");return false;}
 		$("form").submit();	
	   } 
    function getObject(yearNum,month,subjectParentName,ptype){
    	$.ajax(
			{
				url : webCfg.servePath + "/pc/production/getObject/"+yearNum+"/"+month+"/"+subjectParentName+"/"+ptype,
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				if(data !== null){
                    $("#id").val(data.id); 				
	    	        $("#actual").val(data.actual);
	    	        $("#value").val(data.value);
	    	        $("#cumulativeBudget").val(data.cumulativeBudget);
	    	        $("#cumulativeActual").val(data.cumulativeActual);	    	        
	    	        }
			}).fail(function(jqXHR, error) {
				alert("error！");
		});  	
    }		    	   
</script>
</@common>