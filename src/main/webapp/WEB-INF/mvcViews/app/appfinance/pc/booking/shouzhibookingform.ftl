<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/datapicker/datepicker3",
"/styles/easyTree",
"/app/lib/css/plugins/dataTables/datatables.min",
"/styles/bigautocomplete"
]/>

<@addJS [
"/app/lib/js/plugins/datapicker/bootstrap-datepicker",
"/app/lib/js/plugins/datapicker/bootstrap-datepicker.zh-CN",
"/scripts/easyTree",
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/jeditable/jquery.jeditable",

"/scripts/bigautocomplete"
]/>
<@common "收付款明细">

<!-- 模态框（Modal） -->
<div class="modal fade" id="addItemModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" >
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	收付款记录
            </h4>
         </div>
         <div class="modal-body" style="height:auto">
         	<input type="hidden" id	= "modelusercode"/>
           	<div class="form-group">
				<label class="col-sm-3 control-label">记录类型</label>
				<div class="col-sm-9">
					<select class="form-control m-b" id="itemType" name="itemType">
                        <option value="1" >收款记录</option>
						<option value="0" >应收（提前一周短信提醒）</option>
                	</select>
				</div>
			</div>
           	<div class="form-group" style="padding-top:35px">
				<label class="col-sm-3 control-label">时间</label>
				<div class="col-sm-9 input-group date" style="padding-right:15px">
					<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					<input id="dateLineStr"  type="text" placeholder="时间" class="form-control"
					 name ="dateLineStr" value="">
				</div>
			</div>
			
           	<div class="form-group"  >
				<label class="col-sm-3 control-label">金额(万元)</label>
				<div class="col-sm-9">
					<input id="yingshou" type="text" placeholder="金额（万元）" class="form-control"
						 name ="yingshou" value="">
				</div>
			</div>
           	<div class="form-group"  style="padding-top:35px">
			</div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">取消
            </button>
            <button type="button" class="btn btn-primary" onclick="saveitem()">
              	 保存
            </button>
         </div>
      </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<div class="row">
	<input type="hidden" id="group" value="config"/>
	<input type="hidden" id="item" value="zhibiao_menu"/>
	<div class="col-lg-12">
		<form method="get" class="form-horizontal" id="iform" accept-charset="utf-8" action="${servePath}/pc/contractinfo/submitForm">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<div class="ibox-tools">
					<button class="btn btn-white" type="button" onclick="goback()">取消</button>
					<button class="btn btn-primary" type="submit" >保存</button>
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="dropdown-toggle" data-toggle="dropdown"
						href="form_basic.html#"> 
					</a>
				</div>
			</div>
					
			<div class="ibox-content">
				<input type="hidden" id="subModule" value="contractinfo"/>
				
					<input type="hidden" id="id" name="id" value="${(dataAO.id)!}"/>
					<div class="form-group">
						<label class="col-sm-2 control-label">合同名称</label>
						<div class="col-sm-10">
							<input id="subjectName" type="text" placeholder="合同名称" class="form-control"
								required="" name ="contractName" value="${(dataAO.contractName)!}">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">合同类型</label>
                        <div class="col-sm-4 " >
                        	<select class="form-control m-b" id="type" name="type">
                                <option value="包机"  
						     	 	 <#if "${(dataAO.type)!}" == "包机"> selected="true" </#if>>包机</option>
                                <option value="保险"  
						     	 	 <#if "${(dataAO.type)!}" == "保险"> selected="true" </#if>>保险</option>
                                <option value="代理人合同"  
						     	 	 <#if "${(dataAO.type)!}" == "代理人合同"> selected="true" </#if>>代理人合同</option>
                                <option value="房屋租赁"  
						     	 	 <#if "${(dataAO.type)!}" == "房屋租赁"> selected="true" </#if>>房屋租赁</option>
                                <option value="辅营项目"  
						     	 	 <#if "${(dataAO.type)!}" == "辅营项目"> selected="true" </#if>>辅营项目</option>
                                <option value="柜台服务"  
						     	 	 <#if "${(dataAO.type)!}" == "柜台服务"> selected="true" </#if>>柜台服务</option>
                                <option value="航机媒体"  
						     	 	 <#if "${(dataAO.type)!}" == "航机媒体"> selected="true" </#if>>航机媒体</option>
                                <option value="机场补贴"  
						     	 	 <#if "${(dataAO.type)!}" == "机场补贴"> selected="true" </#if>>机场补贴</option>
                                <option value="特业培训"  
						     	 	 <#if "${(dataAO.type)!}" == "特业培训"> selected="true" </#if>>特业培训</option>
                                <option value="系统配置"  
						     	 	 <#if "${(dataAO.type)!}" == "系统配置"> selected="true" </#if>>系统配置</option>
                        	</select>
                        </div>
						<label class="col-sm-2 control-label">签约时间</label>
						<div class="col-sm-4 input-group date" style="padding-right:15px">
							<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
							<input id="subjectName"  type="text" placeholder="签约时间" class="form-control"
								required="" name ="qianyueDate" value="${(dataAO.qianyueDate)!}">
						</div>
					</div>
                    
                    <div class="form-group" id="data_5">
						<label class="col-sm-2 control-label">合同编号</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="合同编号" class="form-control"
								 name ="contractNum" value="${(dataAO.contractNum)!}">
						</div>
                        <label class="col-sm-2 control-label">合同有效期</label>
                        <div class="input-daterange input-group col-sm-4 control-label"  style="padding-right:15px" id="datepicker">
                            <input type="text" class="input-sm form-control" style="left:15px" name="start" value="2016-11-10"/>
                            <span class="input-group-addon">一</span>
                            <input type="text" class="input-sm form-control" name="end" value="2016-11-10" />
                        </div>
                    </div>
                    
                    <div class="form-group">
						<label class="col-sm-2 control-label">签约部门</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="签约部门" class="form-control"
								 name ="deptName" value="${(dataAO.deptName)!}">
						</div>
						
						<label class="col-sm-2 control-label">联系人</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="联系人" class="form-control"
								name ="contactsName" value="${(dataAO.contactsName)!}">
						</div>
					</div>
					
                    <div class="form-group">
						<label class="col-sm-2 control-label">对方公司名</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="对方公司名" class="form-control"
								 name ="companyName" value="${(dataAO.companyName)!}">
						</div>
						
						<label class="col-sm-2 control-label">合同项目</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="合同项目" class="form-control"
								 name ="contractItem" value="${(dataAO.contractItem)!}">
						</div>
					</div>
					
                    <div class="form-group">
						<label class="col-sm-2 control-label">合同金额</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="合同金额" class="form-control"
								required="" name ="contractMoney" value="${(dataAO.contractMoney)!}">
						</div>
						
						<label class="col-sm-2 control-label">结算周期</label>
						<div class="col-sm-4">
							<input id="subjectName" type="text" placeholder="结算周期" class="form-control"
								name ="contractPeriod" value="${(dataAO.contractPeriod)!}">
						</div>
					</div>
                    <div class="form-group">
						<label class="col-sm-2 control-label">备注</label>
						<div class="col-sm-10">
							<input id="subjectName" type="text" placeholder="备注" class="form-control"
								 name ="descComment" value="${(dataAO.descComment)!}">
						</div>
						
					</div>
					
                    
					<div class="form-group">
						<label class="col-sm-2 control-label">是否完结</label>
                        <div class="col-sm-10">
                        	<select class="form-control m-b" id="status" name="status">
                                <option value="1"  
						     	 	 <#if "${(dataAO.status)!}" == "1"> selected="true" </#if>>完结</option>
								 <option value="0"  
						     	 	 <#if "${(dataAO.status)!}" == "0"> selected="true" </#if>>履行中</option>
                        	</select>
                        </div>
                    </div>
					
				<div class="ibox-content">
            <div class="">
            </form>
            
            <a onclick="addItemModal();" href="javascript:void(0);" class="btn btn-primary ">Add a new row</a>
            </div>
            <table class="table table-striped table-bordered table-hover " id="editable" >
            <thead>
            <tr>
                <th>类型</th>
                <th>时间</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
            </tr>
            </thead>
            <tbody>
            <tr class="gradeX">
                <td>Trident</td>
                <td>Internet
                    Explorer 4.0
                </td>
                <td>Win 95+</td>
                <td class="center">4</td>
                <td class="center">X</td>
            </tr>
            
            </tbody>
            <tfoot>
            <tr>
                <th>Rendering engine</th>
                <th>Browser</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
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
		$('.input-group.date').datepicker({
			language: 'zh-CN',
			todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            format: 'yyyy-mm-dd',
            autoclose: true
        });
        
        $('#data_5 .input-daterange').datepicker({
            language: 'zh-CN',
			todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            format: 'yyyy-mm-dd',
            autoclose: true
        });
        
		$('#editable').DataTable({
                dom: '<"html5buttons"B>lTfgitp',
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

	function goback(){
		window.location.href="${servePath}/pc/financesuject";
	}
	
	function deleteItem(obj){
		$(obj).parent().parent().remove();
	}
	
	function addItemModal(){
		$("#addItemModal").modal("show");
	}
	
	function saveitem(){
		$("#addItemModal").modal("hide");
		var data = {
			itemType :$("#itemType").val(),
			dateLineStr :$("#dateLineStr").val(),
			yingshou :$("#yingshou").val()
		}
		
		$.ajax(
			{
				url : webCfg.servePath + "/pc/contractinfo/saveitem",
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				data : data
			}).done(
			function(data) {
			 	$("#itemType").val("");
				$("#dateLineStr").val("");
				$("#yingshou").val("");
			}).fail(function(jqXHR, error) {
				alert("error！");
		}); 
	}
</script>
</@common>