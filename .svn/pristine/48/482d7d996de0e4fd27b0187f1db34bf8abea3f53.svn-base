<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu for contacts</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function changeFrameSrc(url)
{
	$("#iframe_main",parent.document.body).attr("src",url);
}
</script>
</head>
<body>
	<div style="margin:10px 0;">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="changeFrameSrc('list.html')"
			>联系人查询</a>
	</div>
	
	<shiro:hasPermission name="contacts:create">
		<div style="margin:10px 0;">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'" onclick="changeFrameSrc('create.html')"
				>新建联系人</a>
		</div>
	</shiro:hasPermission>
	
	<shiro:hasPermission name="contacts:category:update">
		<div style="margin:10px 0;">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-tip'" onclick="changeFrameSrc('category')"
				>类别 管理</a>
		</div>
	</shiro:hasPermission>
</body>
</html>