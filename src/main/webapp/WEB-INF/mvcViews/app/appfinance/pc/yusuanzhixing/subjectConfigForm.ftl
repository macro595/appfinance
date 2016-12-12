<#include "../common/basePage.ftl">
<@addCSS [
"/styles/easyTree",
"/styles/bigautocomplete"
]/>

<@addJS [
"/scripts/easyTree",
"/scripts/bigautocomplete"
]/>
<@common "指标配置">
<div class="row">
	<input type="hidden" id="group" value="config"/>
	<input type="hidden" id="item" value="zhibiao_menu"/>
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
				<form method="get" class="form-horizontal" id="iform" accept-charset="utf-8" action="${servePath}/pc/financesuject/submitForm">
					<input type="hidden" id="id" name="id" value="${(dataAO.id)!}"/>
					<input type="hidden" id="subjectCode" name="subjectCode" value="${(dataAO.subjectCode)!}"/>
					
					<div class="hr-line-dashed"></div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">指标名称</label>
						<div class="col-sm-10">
							<input id="subjectName" type="text" placeholder="指标名称" class="form-control"
								required="" name ="subjectName" value="${(dataAO.subjectName)!}">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">HNA指标统计对应</label>
						<div class="col-sm-10" >
							<input type="text" id="searchquick" style="margin-bottom:20px;" name="searchquick" autocomplete="off" class="form-control" placeholder="快捷搜索" value="">
							<div style="border:1px dashed #13A3DA" id="itemDiv">
							 <#list itemList as item>
							 	<p>
								 	<span class="label label-warning">
								 		<input type="checkbox" checked id ="hnaList" name="hnaList" style="display:none" value="${(item.allItemCode)!}">
									 	${(item.allItemName)!}
									 	<i class="fa fa-minus" style="margin-left:10px;" onclick="deleteItem(this)"></i>
								 	</span>
							 	</p>
							 </#list>
							 </div>
						</div>
					</div>
					
					<div class="form-group"><label class="col-sm-2 control-label">指标类型</label>
                        <div class="col-sm-10">
                        	<select class="form-control m-b" id="subjectType" name="subjectType">
                                <option value="十二大成本"  
						     	 	 <#if "${(dataAO.subjectType)!}" == "十二大成本"> selected="true" </#if>>十二大成本</option>
								 <option value="财务收支-收入"  
						     	 	 <#if "${(dataAO.subjectType)!}" == "财务收支-收入"> selected="true" </#if>>财务收支-收入</option>
								 <option value="财务收支-成本"  
						     	 	 <#if "${(dataAO.subjectType)!}" == "财务收支-成本"> selected="true" </#if>>财务收支-成本</option>
								 <option value="利润分类表"  
						     	 	 <#if "${(dataAO.subjectType)!}" == "利润分类表"> selected="true" </#if>>利润分类表</option>                       
                        	</select>
                        </div>
                    </div>
                    
                    <div class="form-group">
						<label class="col-sm-2 control-label">指标排序</label>
						<div class="col-sm-10">
							<input id="sort" type="text" placeholder="指标排序" class="form-control"
								required="" name ="sort" value="${(dataAO.sort)!}">
						</div>
					</div>
					
                    
					<div class="form-group"><label class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-10">
                        	<select class="form-control m-b" id="status" name="status">
                                <option value="1"  
						     	 	 <#if "${(dataAO.status)!}" == "1"> selected="true" </#if>>启用</option>
								 <option value="0"  
						     	 	 <#if "${(dataAO.status)!}" == "0"> selected="true" </#if>>停用</option>
                        	</select>
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
		var list = new Array();
		<#list itemtreelist as data>
			list[${data_index}] = {"title":"${data.allItemName}",
						"code":"${data.allItemCode}",
						"shortName" : "${data.itemName}"};
		</#list>
		$("#searchquick").bigAutocomplete({
			width:543,
			data:list,
			callback:function(data){
				$("#searchquick").val("");
				var html = '<p ><span class="label label-warning">'
								+'<input id="hnaList" style="display:none" type="checkbox" name="hnaList" checked value="'+data.code+'">'+data.title
								+'<i class="fa fa-minus" style="margin-left:10px;" onclick="deleteItem(this)"></i></span></p>';
				$("#itemDiv").append(html);
			}
		});
    });

	function goback(){
		window.location.href="${servePath}/pc/financesuject";
	}
	
	function saveform(){
		$("form").submit();
	}
	
	function deleteItem(obj){
		$(obj).parent().parent().remove();
	}
	
</script>
</@common>