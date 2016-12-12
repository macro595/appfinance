<#include "../common/basePage.ftl">
<@addCSS [
"/styles/easyTree",
"/styles/bigautocomplete"
]/>

<@addJS [
"/scripts/easyTree",
"/scripts/bigautocomplete"
]/>
<@common "业务活动指标配置">
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
				<form method="get" class="form-horizontal" id="iform"  accept-charset="utf-8" action="${servePath}/pc/production/subyearForm">
					<input type="hidden" id="id" name="id" value="${(dataAO.id)!}"/>					
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
						<label class="col-sm-2 control-label">指标名称</label>
						<div class="col-sm-10">
						    <select class="form-control main m-b subjectName" id="subjectName" name="subjectName">				    
                                <option value="">--请选择所添加指标名称--</option>                  
						    <#if itemList?? && itemList?size gt 0>	
                            <#list itemList as item>
                                <option <#if "${(item.subjectName)!}" == "${(dataAO.subjectName)!}"> selected="true"</#if>   value="${(item.subjectName)!}">${(item.subjectName)!}</option>                  
                        	</#list>
                        	</#if> 	
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
						<label class="col-sm-2 control-label">年度预算(单位:万元)</label>
						<div class="col-sm-10">
							<input id="yearYusuan" type="text" placeholder="年度预算" class="form-control"
								required="true" name ="yearYusuan" value="${(dataAO.yearYusuan)!}">
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
        var id,subjectName,yearNum,ptype;             
		$(".main").change(function(){
		  subjectName = $("#subjectName").val();
    	  yearNum = $("#yearNum").val();
    	  ptype = $("#ptype").val();    	  
    	  if(subjectName !== "" && yearNum !== ""){	
    	  	if((subjectName == "航空运输业人均收入") || (subjectName == "航空运输业人均利润")){
 		   		ptype = subjectName;
 		   		getYObject(subjectName,yearNum,ptype); 	
 		   		}
 		   	if(ptype !== ""){	
 		   		getYObject(subjectName,yearNum,ptype); 		
 		   		}   
 		  }
       });
      
    });
	function goback(){
		window.location.href="${servePath}/pc/production/listforyear/cur/cur";
	}
	
	function saveform(){
	var subjectName,yearNum,ptype,yearYusuan;
		subjectName = $("#subjectName").val();
    	yearNum = $("#yearNum").val();
    	ptype = $("#ptype").val();
    	yearYusuan = $("#yearYusuan").val();
    	if((subjectName == "航空运输业人均收入") || (subjectName == "航空运输业人均利润")){
    		if(yearNum == "" || yearNum == null){alert("请录入完整表单数据");return false;}
    		if(yearYusuan == "" || yearYusuan == null){alert("请录入完整表单数据");return false;}	
 			$("form").submit();	
    	}
    	if(ptype == "" || ptype == null){alert("请录入完整表单数据");return false;}
    	if(subjectName == "" || subjectName == null){alert("请录入完整表单数据");return false;}
    	if(yearNum == "" || yearNum == null){alert("请录入完整表单数据");return false;}
    	if(yearYusuan == "" || yearYusuan == null){alert("请录入完整表单数据");return false;}	
 		$("form").submit();	
	   } 

    function getYObject(subjectName,yearNum,ptype){
    	$.ajax(
			{
				url : webCfg.servePath + "/pc/production/getYObject/"+subjectName+"/"+yearNum+"/"+ptype,
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				if(data !== null){
	    	        $("#yearYusuan").val(data.yearYusuan);
	    	        }
			}).fail(function(jqXHR, error) {
				alert("error！");
		});  	
    }	    	   
</script>
</@common>