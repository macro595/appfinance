<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min",
"/app/lib/css/plugins/footable/footable.core",
"/styles/easyTree",
"/app/lib/css/plugins/dropzone/basic"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/bootstrap-modal",
"/scripts/easyTree",
"/app/lib/js/plugins/footable/footable.all.min"
"/app/lib/js/plugins/iCheck/icheck.min"
]/>
<@common "HNA总账科目余额表类型">
<input type="hidden" id="group" value="import"/>
<input type="hidden" id="item" value="accountbalancesheet_menu"/>
 <div class="row">
    <div class="col-lg-4">
        <div class="easy-tree " ></div>
    </div>
    <div class="col-lg-8 animated fadeInRight">
    	<div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>数据信息</h5>

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
                <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                    <thead>
                    <tr>
	                    <th>会计科目描述</th>
	                    <th>币种</th>
	                    <th>期初余额(本位币)</th>
	                    <th>本期借方(本位币)</th>
	                    <th>本期贷方(本位币)</th>
	                    <th>期末余额(本位币)</th>
	                    <th>年月</th>
	                </tr>
                    </thead>
                    <tbody id="memberListarea">
                	
                	</tbody>
                    <tfoot>
                    <tr>
                        <td colspan="8">
                            <ul class="pagination pull-right"></ul>
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div id="zhediv" style="overflow:hidden;padding-left:50%;padding-top:10%;">
		<h4 style="color:#fff">
	       	数据获取中......
	    </h4>
		<image src="${staticServePath}/app/lib/css/plugins/blueimp/img/loading.gif" style="width:100px;height:100px">
	</div>
</div>

<script>
	$("#zhediv").height(document.body.clientHeight);
	$("#zhediv").width(document.body.clientWidth);
	
     $(document).ready(function(){
      	initOrganTree();
     });
     
     function loading(itemCode){
      	$("#myModal").modal("show");
      	refreshMemberInfo(itemCode);
      	$("#myModal").modal("hide");
     }
	 
	 function refreshMemberInfo(itemCode){
	 	$.ajax(
			{
				url : webCfg.servePath + "/pc/accountbalancesheet/getHNADataByItemCode/" + itemCode,
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				if(data==null || data =="" || typeof(data) =="undefined"){
					return;
				}
				var html = "";
				function stringChange(str){
					if(str==null ||str=="null"|| str=="undefined"){
						return "";
					}else{
						return str;
					}
				}
				for(var i = 0 ;i < data.data.length;i++){
					html = html + '<tr class="gradeX" >'
                                    +'<td>' + stringChange(data.data[i].accountantCourseDesc)+'</a></td>'
                                    +'<td>' + stringChange(data.data[i].currency) +'</td>'
                                    +'<td>' + parseInt(stringChange(data.data[i].qichuYue)).toFixed(2)+'</td>'
                                    +'<td>' + parseInt(stringChange(data.data[i].benqiJiefang)).toFixed(2)+'</td>'
                                    +'<td>' + parseInt(stringChange(data.data[i].benqiDaifang)).toFixed(2)+'</td>'
                                    +'<td>' + parseInt(stringChange(data.data[i].qimoYue)).toFixed(2)+'</td>'
                                    +'<td>' + stringChange(data.data[i].month)+'</td>'
                                +'</tr>';
				}
				$("#memberListarea").html(html);
			}).fail(function(jqXHR, error) {
				alert("error！");
		});
	 }
	 
	 function initOrganTree(){
	 	$.ajax(
			{
				url : webCfg.servePath + "/pc/accountbalancesheet/initItemTree/",
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				var menulist = eval("("+data.data+")");
				var showlist = showallnew(menulist);
			    //$("#nestable").append(showlist);
			    
				function showallnew(menu_list) {
					var html = ''
						+'<div class="sidebar-collapse" style="height:700px;overflow-y:auto;">'
						+'<ul class="" >';
					for (var menu in menu_list) {
						html = html +'<li data-code="' + menu_list[menu].id +'">';
						if(menu_list[menu].children!=undefined){
							html = html + '<a href="javascript:void(0)"><i class="fa fa-sitemap"></i> <span class="nav-label">' + menu_list[menu].name +
								'</span></a>';
							html = html + ' <ul class="">'
							html = html + getNodeLeaf(menu_list[menu].children);
							html = html + '</ul>';
						}else{
							html = html + '<a href="javascript:void(0)" data-type="leafNode" ><i class="fa fa-sitemap"></i> <span class="nav-label">' + menu_list[menu].name + 
							'</span></span></a>';
						}
						html = html + '</li>';
					}
					html = html + '</ul></div>';
					return html;
				}
				
				function getNodeLeaf(menu_list) {
					var html = "";
					for (var menu in menu_list) {
						if(menu_list[menu].children!=undefined){
							html = html + '<li data-code="' + menu_list[menu].id +'"><a href="javascript:void(0)"><i class="fa fa-sitemap"></i> <span class="nav-label">' + menu_list[menu].name +
							'</span><span class="fa arrow"></span></a>';
							html = html + ' <ul class="">'
							html = html + getNodeLeaf(menu_list[menu].children);
							html = html + '</ul></li>';
						}else{
							html = html + '<li  data-code="' + menu_list[menu].id +'"><a href="javascript:void(0)" data-type="leafNode" ><i class="fa fa-sitemap"></i> <span class="nav-label">' + menu_list[menu].name + 
							'</span></span></a></li>';
						}
					}
					return html;
				}
			    
			    $(".easy-tree").append(showlist);
			    $('.easy-tree').EasyTree({
					addable: false,
					editable: false,
					deletable: false
				});
			}).fail(function(jqXHR, error) {
				alert("error！");
		});
	 }
	 
	 
	 
</script></@common>