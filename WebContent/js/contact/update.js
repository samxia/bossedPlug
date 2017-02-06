function edit() {
	// cacel the readonly attr to false
	$('input').each(function(index) {
		if ($(this).attr('name') != 'kehuNo') {
			$(this).attr({
				'readonly' : !$(this).attr('readonly')
			});
		}
	});
	// show save and reset button
	$('#div_save').attr('hidden', !$('#div_save').attr('hidden'));

	// create a combotree
	if (typeof ($('#id_show_kehulbMc').attr("flag")) == "undefined") {
		$('#id_show_kehulbMc').attr("flag", true);// set a flag for double
													// load

		$('#id_show_kehulbMc').attr("name", "");

		switch($('#id_kehuXz')[0].value)
		{
		case "1":
			$('#id_show_kehulbMc').combotree({
				url :'kehu/category/search',
				onSelect : onSelectFromTree
			});
		break;
		case "2":
			$('#id_show_kehulbMc').combotree({
				url :'gys/category/search',
				onSelect : onSelectFromTree
			});
		break;
		default:
			$('#id_show_kehulbMc').combotree({
				url :'category/list',
				onSelect : onSelectFromTree
			});
		break;
		}
	/*	$('#id_show_kehulbMc').combotree({
			url : $('#id_kehuXz')[0].value==1?'kehu/category/search':'category/list',
			onSelect : onSelectFromTree
		});*/
		
	}

	// switch the combotree readonly
	if ($('#id_show_kehulbMc').attr("readonly") == "readonly") {
		$('#id_show_kehulbMc').combotree("readonly", true);
	} else {
		$('#id_show_kehulbMc').combotree("readonly", false);
	}

}

function onSelectFromTree(node) {
	$('#id_kehulbDm')[0].value = node.id;
	$('#id_kehulbMc')[0].value = node.text;
}
function submitForm() {
	$.messager.progress();
	$('#ff').form('submit', {
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (!isValid) {
				$.messager.progress('close'); // hide progress bar while the
												// form is invalid
			}
			return isValid; // return false will stop the form submission
		},
		success : function(data) {
			$.messager.progress('close'); // hide progress bar while submit
											// successfully
			if (data.indexOf("请输入用户名和密码") > -1)// 未登录
			{
				self.location.reload();
				return;
			}
			if (data.indexOf("Fail") > -1)// 如果返回Fail
			{
				var json_data = $.secureEvalJSON(data);
				// $.messager.alert('Info', json_data.Fail, 'info');
				$.messager.alert('Info', json_data.Fail, 'info');
				return;
			}

			if (data.indexOf("success") > -1)// 如果返回success
			{
				// showKehuWindow($.secureEvalJSON(data).success);
				$.messager.alert('联系人', "更新成功", 'info');

			}

		}
	});
}