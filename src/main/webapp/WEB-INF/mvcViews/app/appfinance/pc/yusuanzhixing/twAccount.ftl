<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "基础数据导入">
<input type="hidden" id="group" value="report"/>
<input type="hidden" id="item" value="twAccount_menu"/>
<div class="row">
	<div class="col-lg-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>月度成本情况</h5>
            </div>
            <div class="ibox-content">
                <div>
                    <canvas id="barChart" ></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>十二大成本分布</h5>
            </div>
            <div class="ibox-content">
                <div>
                    <canvas id="radarChart"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                        <i class="fa fa-wrench"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">

                <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover dataTables-example" >
            <thead>
            	<tr>
	                <th>序号</th>
	                <th>项目</th>
	                <th>月度</th>
	                <th>月度（本期借方-本位币）</th>
	                <th>月度累计（期末余额-本位币）</th>
	            </tr>
            </thead>
            <tbody>
            <#list datalist as data>
	            <tr class="gradeX">
	                <td>${(data_index+1)!}</td>
	                <td>${(data.subjectName)!}</td>
	                <td>${(data.month)!}</td>
	                <td>${(data.chengben)!}</td>
	                <td class="center">${(data.monthTotal)!}</td>
	            </tr>
            </#list>
            </tbody>
            <tfoot>
            <tr>
                <th>序号</th>
                <th>项目</th>
                <th>月度</th>
                <th>月度（本期借方-本位币）</th>
                <th>月度累计（期末余额-本位币）</th>
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
    	fnclickGetMonth("05");
    
        var barData = {
        labels: ["1月", "2月", "3月", "4月", "5月", "6月", "7月"],
        datasets: [
            {
                label: "月度成本情况",
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,0.8)",
                highlightFill: "rgba(220,220,220,0.75)",
                highlightStroke: "rgba(220,220,220,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "年度累计成本",
                fillColor: "rgba(26,179,148,0.5)",
                strokeColor: "rgba(26,179,148,0.8)",
                highlightFill: "rgba(26,179,148,0.75)",
                highlightStroke: "rgba(26,179,148,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };

    var barOptions = {
        scaleBeginAtZero: true,
        scaleShowGridLines: true,
        scaleGridLineColor: "rgba(0,0,0,.05)",
        scaleGridLineWidth: 1,
        barShowStroke: true,
        barStrokeWidth: 2,
        barValueSpacing: 5,
        barDatasetSpacing: 1,
        responsive: true,
        tooltipEvents: ["mousemove", "touchstart", "touchmove", "mouseout","click"],
        customClickEvent:function(barsArray){
        	fnclickGetMonth("04");
        },
        onAnimationComplete: function () {
        }
    }

    var ctx = document.getElementById("barChart").getContext("2d");
    var myNewChart = new Chart(ctx).Bar(barData, barOptions);
    
    });

    function fnclickGetMonth(month){
    	$.ajax(
			{
				url : webCfg.servePath + "/pc/report/fntwGetMonth/" + month,
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8"
			}).done(
			function(data) {
				var html ="";
			    
				var dataList = [];
		    	for(var i = 0 ; i < data.data.length ; i++){
	    			var param = data.data[i].chengben;
			        dataList[dataList.length] = param;
			        
			        //更新下方列表
			        html = 	html + '<tr class="gradeX">'+
			                '<td>'+ (i+1) +'</td>'+
			                '<td>'+ data.data[i].subjectName +'</td>'+
			                '<td>'+ data.data[i].month +'</td>'+
			                '<td>'+ data.data[i].chengben +'</td>'+
			                '<td class="center">'+ data.data[i].monthTotal +'</td>'+
	           				'</tr>';
		    	}
		    	
		    	$("table tbody").html(html);
			
			    var radarData = {
			        labels: ["人力资源成本", 
			        		"税金及民建", 
			        		"管理费用", 
			        		"航材维修成本", 
			        		"航油成本", 
			        		"营业外支出", 
			        		"财务费用",
			        		"起降成本",
			        		"辅助运营成本",
			        		"配餐及机供品",
			        		"销售费用",
			        		"飞机拥有成本"
			        		],
			        datasets: [
			            {
			                label: "My Second dataset",
			                fillColor: "rgba(26,179,148,0.2)",
			                strokeColor: "rgba(26,179,148,1)",
			                pointColor: "rgba(26,179,148,1)",
			                pointStrokeColor: "#fff",
			                pointHighlightFill: "#fff",
			                pointHighlightStroke: "rgba(151,187,205,1)",
			                data: dataList
			            }
			        ]
			    };
			    
			
			    var radarOptions = {
			        scaleShowLine: true,
			        angleShowLineOut: true,
			        scaleBeginAtZero: true,
			        angleLineColor: "rgba(0,0,0,.1)",
			        angleLineWidth: 1,
			        pointLabelFontFamily: "'Arial'",
			        pointLabelFontStyle: "normal",
			        pointLabelFontSize: 10,
			        pointLabelFontColor: "#666",
			        pointDot: true,
			        pointDotRadius: 3,
			        pointDotStrokeWidth: 1,
			        pointHitDetectionRadius: 20,
			        datasetStroke: true,
			        datasetStrokeWidth: 2,
			        datasetFill: true,
			        responsive: true,
			    }
			
			    var ctx = document.getElementById("radarChart").getContext("2d");
			    var myNewChart = new Chart(ctx).Radar(radarData, radarOptions);
			}).fail(function(jqXHR, error) {
				alert("error！");
		});
    	
    }
</script>
</@common>