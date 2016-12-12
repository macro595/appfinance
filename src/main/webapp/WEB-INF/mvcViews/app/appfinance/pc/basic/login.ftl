<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>祥鹏财务报表系统 | 登陆</title>

	<link href="${staticServePath}/app/lib/css/bootstrap.min.css" rel="stylesheet">
    <link href="${staticServePath}/app/lib/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="${staticServePath}/app/lib/css/animate.css" rel="stylesheet">
    <link href="${staticServePath}/app/lib/css/style.css" rel="stylesheet">
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

            </div>
            <h3>Welcome to 财务报表系统</h3>
            <form class="m-t" role="form" action="index.html">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Username" required="" id="name">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" id="password" required="">
                </div>
                <button type="button" class="btn btn-primary block full-width m-b" onclick="dologin()">登陆</button>
            </form>
        </div>
    </div>

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
	function dologin(){
		$.ajax(
			{
				url : "${servePath}/pc/login/pcDoLogin",
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				data : {"loginName" : $("#name").val(),"password" : $("#password").val()}
			}).done(
			function(data) {
				if(data.succeed){
					window.location.href="${servePath}" + data.data;
				}else{
					alert(data.msg);
				}
			}).fail(function(jqXHR, error) {
				alert("error！");
	});
	}
</script>
</body>
</html>
