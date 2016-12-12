<#include "../common/basePage.ftl">
<@addCSS [
"/app/lib/css/plugins/dataTables/datatables.min"
]/>

<@addJS [
"/app/lib/js/plugins/dataTables/datatables.min",
"/app/lib/js/plugins/chartJs/Chart.min"

]/>
<@common "指标配置">
<input type="hidden" id="group" value="config"/>
<input type="hidden" id="item" value="zhibiao_menu"/>
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
            <table class="table table-striped table-bordered table-hover dataTables-example" >
            <thead>
            	<tr>
	                <th>指标名称</th>
	                <th>指标Code</th>
	                <th>指标归属</th>
	            </tr>
            </thead>
            <tbody>
            <#list datalist as data>
	            <tr class="gradeX">
	                <td ><a href="javascript:void(0)" onclick="showform('${(data.id)!}')" >${(data.subjectName)!}</a></td>
	                <td>${(data.subjectCode)!}</td>
	                <td>${(data.subjectType)!}</td>
	            </tr>
            </#list>
            
            </tbody>
            <tfoot>
            <tr>
                <th>指标名称</th>
                <th>指标Code</th>
                <th>指标归属</th>
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
    	$('.dataTables-example').DataTable({
            dom: '<"html5buttons"B>lTfgitp',
            pageLength:50,
            "ordering": false,
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
    
    function showform(id){
    	window.location.href="${servePath}/pc/financesuject/showform/" + id;
    }
    
    function create(){
    	window.location.href="${servePath}/pc/financesuject/add/";
    }
    
    
    	
</script>
</@common>