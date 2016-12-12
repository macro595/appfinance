<#include "./util/staticMacro.ftl">

<#macro common title>
	<!DOCTYPE html>	
	<html>
	<#setting number_format="0.#####">
	<#setting time_format="HH:mm:ss"> 
	    <head>
	    	<meta charset="utf-8">
   			<meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <title>${title}</title>
	        <@block name="meta">
				<#include "meta.html">
    		</@block> 
    		
    		<@block name="commonCSS">
			<link href="${staticServePath}/app/lib/css/bootstrap.min.css" rel="stylesheet">
		    <link href="${staticServePath}/app/lib/font-awesome/css/font-awesome.css" rel="stylesheet">
		
		    <link href="${staticServePath}/app/lib/css/animate.css" rel="stylesheet">
		    <link href="${staticServePath}/app/lib/css/style.css" rel="stylesheet">
    		</@block> 
    		
	        <@genCSS/>
    <!-- Mainly scripts -->
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/jquery-2.1.1.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/bootstrap.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/inspinia.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/plugins/pace/pace.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${staticServePath}/app/lib/js/plugins/iCheck/icheck.min.js"></script>
			
			<script>
			      webCfg = {
				      staticServePath: "${staticServePath}",
				      fileServePath: "${(fileServePath)!}",
				      servePath: "${servePath}",
				      commonPath : "${(commonPath)!}"
			      };
			</script>
	    </head>
	    <body class="fixed-navigation">
	    	<#include "./leftMenu.ftl">
	        <div id="page-wrapper" class="gray-bg sidebar-content">
			<div class="row border-bottom">
		        <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
		        <div class="navbar-header">
		            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="javascript:void(0)"><i class="fa fa-bars"></i> </a>
		        </div>
		            <ul class="nav navbar-top-links navbar-right">
		                <li>
		                    <span class="m-r-sm text-muted welcome-message">Welcome :  ${(currentUser.name)!}</span>
		                </li>
		
		                <li>
		                    <a href="${servePath}/pc/login/logout">
		                        <i class="fa fa-sign-out"></i> 退出
		                    </a>
		                </li>
		            </ul>
		        </nav>
	        </div>
	        <div class=" wrapper-content">
				<#nested/>
				<div class="footer">
		            <div class="pull-right">
		                	技术支持： 信息规划中心
		            </div>
		            <div>
		                <strong>Copyright</strong> 创发部信息规划中心 &copy; 2012-2016 
		            </div>
		        </div>
			</div>
		</div>
	        <@genJS/>
	        <#if javascript??>
	         	${javascript}
	        </#if>
	        <script>
			      function initmenu(){
			      
			      	var group= $("#group").val();
			      	var item= $("#item").val();
			      	$("#"+group).addClass("active");
			      	$("#"+item).addClass("active");
			      }
			      initmenu();
			</script>
	    </body>
	</html>
</#macro>