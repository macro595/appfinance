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
				<form method="get" class="form-horizontal" id="iform"  accept-charset="utf-8" action="${servePath}/pc/babudget/submitForm">
					<input type="hidden" id="id" name="id" value="${(bABudget.id)!}"/>					
					<input type="hidden" id="did" name="did" value="${(detail.id)!}"/>
					<div class="hr-line-dashed"></div>

					<div class="form-group">
						<label class="col-sm-2 control-label">年度</label>
						<div class="col-sm-10">
						    <select class="form-control main m-b yearNum" id="yearNum" name="yearNum">
						    <option  value="">--请选择年度--</option>
						    <#if yearList?? && yearList?size gt 0>	
                            <#list yearList as item>
                                <option <#if "${(item)!}" == "${(bABudget.yearNum)!}"> selected="true"</#if> value="${(item)!}">${(item)!}</option>                  
                        	</#list>
                        	</#if>
                        	</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">月份</label>
						<div class="col-sm-10">
						    <select class="form-control sub m-b month" id="month" name="month">
                                <option  value="">--请选择月份--</option>						    
                                <option <#if "01" == "${(detail.month)!}"> selected="true"</#if> value="01">01</option> 
                                <option <#if "02" == "${(detail.month)!}"> selected="true"</#if> value="02">02</option>
                                <option <#if "03" == "${(detail.month)!}"> selected="true"</#if> value="03">03</option>
                                <option <#if "04" == "${(detail.month)!}"> selected="true"</#if> value="04">04</option>
                                <option <#if "05" == "${(detail.month)!}"> selected="true"</#if> value="05">05</option>
                                <option <#if "06" == "${(detail.month)!}"> selected="true"</#if> value="06">06</option>
                                <option <#if "07" == "${(detail.month)!}"> selected="true"</#if> value="07">07</option>
                                <option <#if "08" == "${(detail.month)!}"> selected="true"</#if> value="08">08</option>
                                <option <#if "09" == "${(detail.month)!}"> selected="true"</#if> value="09">09</option>
                                <option <#if "10" == "${(detail.month)!}"> selected="true"</#if> value="10">10</option>
                                <option <#if "11" == "${(detail.month)!}"> selected="true"</#if> value="11">11</option>
                                <option <#if "12" == "${(detail.month)!}"> selected="true"</#if> value="12">12</option>                 
                        	</select>
						</div>
					</div>
															
					<div class="form-group">
						<label class="col-sm-2 control-label">指标名称</label>
						<div class="col-sm-10">
						    <select class="form-control m-b main subjectName" id="subjectName" name="subjectName">				    
                                <option value="">--请选择所添加指标名称--</option>                  
						    <#if itemList?? && itemList?size gt 0>	
                            <#list itemList as item>
                                <option <#if "${(item.subjectName)!}" == "${(bABudget.subjectName)!}"> selected="true"</#if>   value="${(item.subjectName)!}">${(item.subjectName)!}</option>                  
                        	</#list>
                        	</#if> 	
                        	</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">本月实际(单位:万元)</label>
						<div class="col-sm-10">
							<input id="actual" type="text" placeholder="本月实际" class="form-control"
								required="true" name ="actual" value="${(detail.actual)!}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">本月预算(单位:万元)</label>
						<div class="col-sm-10">
							<input id="value" type="text" placeholder="本月预算" class="form-control"
								required="true" name ="value" value="${(detail.value)!}">
						</div>
					</div>					
					<div class="form-group">
						<label class="col-sm-2 control-label">本年累计完成(单位:万元)</label>
						<div class="col-sm-10">
							<input id="curMonthAccount" type="text" placeholder="本年累计完成" class="form-control"
								required="true" name ="curMonthAccount" value="${(detail.curMonthAccount)!}">
						</div>
					</div>		
					<div class="form-group">
						<label class="col-sm-2 control-label">年度预算(单位:万元)</label>
						<div class="col-sm-10">
							<input id="yearYusuan" type="text" placeholder="年度预算" class="form-control"
								required="true" name ="yearYusuan" value="${(bABudget.yearYusuan)!}">
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
        var id,subjectName,yearNum,month;
                
		$(".main").change(function(){
		  id = $("#id").val();
		  subjectName = $("#subjectName").val();
    	  yearNum = $("#yearNum").val();
    	  month = $("#month").val();    	  
    	  if(yearNum !== "" && subjectName !== ""){	
 		   		getObject(subjectName,yearNum); 		   
 		  }
       });
		$(".sub").change(function(){
		  id = $("#id").val();
		  subjectName = $("#subjectName").val();
    	  yearNum = $("#yearNum").val();
    	  month = $("#month").val();    	  
    	  if(yearNum !== "" && subjectName !== ""){	
    	  	if(month !== ""){
 		   		getDObject(subjectName,yearNum,month); 
 		   		}		   
 		  }
       });       
    });
	function goback(){
		window.location.href="${servePath}/pc/ibsummary/list/cur/cur";
	}
	
	function saveform(){
		var subjectName,yearNum,month,actual,value,yearYusuan,curMonthAccount;
		subjectName = $("#subjectName").val();
    	yearNum = $("#yearNum").val();
    	month = $("#month").val();
    	curMonthAccount = $("#curMonthAccount").val();
    	value = $("#value").val();
    	actual = $("#actual").val();
    	yearYusuan = $("#yearYusuan").val();
    	if(value == "" || value == null){alert("请录入完整表单数据");return false;}    	
    	if(subjectName == "" || subjectName == null){alert("请录入完整表单数据");return false;}
    	if(yearNum == "" || yearNum == null){alert("请录入完整表单数据");return false;}
    	if(month == "" || month == null){alert("请录入完整表单数据");return false;}
    	if(actual == "" || actual == null){alert("请录入完整表单数据");return false;}
    	if(curMonthAccount == "" || curMonthAccount == null){alert("请录入完整表单数据");return false;}
    	if(yearYusuan == "" || yearYusuan == null){alert("请录入完整表单数据");return false;}	
 		$("form").submit();	
	   } 
    function getObject(subjectName,yearNum){
    	$.ajax(
			{
				url : webCfg.servePath + "/pc/babudget/Object/"+subjectName+"/"+yearNum,
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				if(data !== null){
                    $("#id").val(data.id); 				
	    	        $("#yearYusuan").val(data.yearYusuan);	    	        
	    	        }
			}).fail(function(jqXHR, error) {
				alert("error！");
		});  	
    }	
    function getDObject(subjectName,yearNum,month){
    	$.ajax(
			{
				url : webCfg.servePath + "/pc/babudget/getDObject/"+subjectName+"/"+yearNum+"/"+month,
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				if(data.id !== null){
                    $("#did").val(data.id); 				
	    	        $("#actual").val(data.actual);
	    	        $("#curMonthAccount").val(data.curMonthAccount);
	    	        $("#value").val(data.value);	     	        
	    	        }
			}).fail(function(jqXHR, error) {
				alert("error！");
		});  	
    }	    	   
</script>
</@common>