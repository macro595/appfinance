<#include "../common/basePage.ftl">
<@addCSS [
]/>

<@addJS [
]/>
<@common "基础数据导入">
<input type="hidden" id="group" value="import"/>
<input type="hidden" id="item" value="${(importPath)!}_menu"/>
 <div class="row">
    <div class="col-lg-12 animated fadeInRight">
	    <div class="mail-box-header">
	        <h2 id="organCfginfo">
	           	 数据导入
	        </h2>
	    </div>
        <div class="ibox-content">
            <form action="${servePath}/pc/fileinfo/${(importPath)!}" enctype="multipart/form-data" method="post">
         		<div class="form-group" id="data_1">
					<label class="col-sm-12 control-label">请按模板要求上传数据：</label>
                </div>
            	<div class="form-group" id="data_1">
                    <div class="col-sm-12" style="height:200px;">
                    	<div id="parentdiv" class="fa fa-sign-in big-icon" style="border:1px #e7eaec solid; padding:0px 20px"></div>
                    	<div id="uploaddiv" style=""></div>
                    	<input type="file" id="file" name="file" style="height:160px;width:180px;position:relative;top:-160px;opacity:0" accept=".xls,.xlsx">
                    </div>
                </div>
                
                <div class="form-group"><label class="col-sm-2 control-label">选择年度</label>
                        <div class="col-sm-10">
                        	<select class="form-control m-b" id="yearnum" name="yearnum" required="">
                                <option value="2015">2015年</option>
                                <option value="2016">2016年</option>
                                <option value="2017">2017年</option>
                                <option value="2018">2018年</option>
                                <option value="2019">2019年</option>
                                <option value="2020">2020年</option>
                        	</select>
                        </div>
                    </div>
		        <button class="btn btn-primary btn-lg" data-toggle="modal" 
		   			data-target="#myModal" style="submit" >开始导入</button>
     		</form>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div id="zhediv" style="overflow:hidden;padding-left:50%;padding-top:10%;">
		<h4 style="color:#fff">
	       	数据提交中......
	    </h4>
		<image src="${staticServePath}/app/lib/css/plugins/blueimp/img/loading.gif" style="width:100px;height:100px">
	</div>
</div>
<script>
	$("#zhediv").height(document.body.clientHeight);
	$("#zhediv").width(document.body.clientWidth);
	$("#file").change(function(){
		function getFileName(o){
		    var pos=o.lastIndexOf("\\");
		    return o.substring(pos+1);  
		}
		var fileName = getFileName($(this).val());
		if(fileName!=""){
			$("#parentdiv").removeClass("fa-sign-in");
			$("#parentdiv").addClass("fa-file-excel-o");
		}else{
			$("#parentdiv").removeClass("fa-file-excel-o");
			$("#parentdiv").addClass("fa-sign-in");
		}
		$("#uploaddiv").html(fileName);
	})
</script>
</@common>