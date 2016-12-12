function saveForm(){
	var data = getFormData();
	$.ajax(
			{
				url : webCfg.servePath + "/pc/" + $("#subModule").val() +"/submitAJAXForm",
				type : "POST",
				async:false,
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				data : data
			}).done(
			function(data) {
				alert("保存成功！");
				$("#imageSubmit").click();
			}).fail(function(jqXHR, error) {
				alert("error！");
	});
	
}
// 提交表单时获取数据
// 只有打开过的界面数据会被提交
var getFormData = function() {
	return serializeForm(document.getElementById("iform"));
};
//序列化表单
function serializeForm(whichForm) {
	var parts = {};
	var field = null;
	for ( var i = 0, len = whichForm.elements.length; i < len; i++) {
		field = whichForm.elements[i];
		if(field.id==""){
			continue;
		}
		switch (field.type) {
		case "select-one":
		case "select-multipe":
			for ( var j = 0, optLen = field.options.length; j < optLen; j++) {
				var option = field.options[j];

				if (option.selected) {
					var optValue = "";
					if (option.hasAttribute) {
						optValue = (option.hasAttribute("value") ? option.value
								: option.text);
					} else {
						optValue = (option.attributes["value"].specified ? option.value
								: option.text);
					}
					parts[encodeURIComponent(field.id)] = optValue;
					// parts.push("\"" +encodeURIComponent(field.id) + "\":\"" +
					// optValue+ "\"");
				}
			}
			break;
		case undefined:
		case "file":
		case "submit":
		case "reset":
		case "button":
			break;
		case "radio":
			if(field.checked == true){
			$(field).val("1");
		}
		if (field.checked == false) {
			$(field).val("0");
		}
		case "checkbox":
		if(field.checked == true){
			$(field).val("1");
		}
		if (field.checked == false) {
			$(field).val("0");
		}
		default:
			parts[encodeURIComponent(field.id)] = field.value;
			// parts.push("\"" + encodeURIComponent(field.id) + "\":\"" +
			// field.value + "\"" );
		}
	}

	return parts;
}

