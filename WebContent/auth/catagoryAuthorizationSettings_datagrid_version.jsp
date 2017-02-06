<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Data Level Policy Settings for contacts</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<style type="text/css">
#div_role,#div_panel,#toolbar_for_layout{
	float: left;
	margin-right: 20px;
}
</style>
<link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/util/jquery.json.2.4.js"></script>
<script type="text/javascript" src="../js/auth/contactsCategoryAuthSettings.js"></script>
</head>
<body>
<jsp:include page="header.jsp" flush="true" /><hr>
<div id="div_role">
			<table id="dg_role" class="easyui-datagrid" title="Role"
				style="width: 300px; height: 500px"
				data-options="singleSelect:true,collapsible:false,url:'role/list',
		fitColumns:false,rownumbers:true,showFooter:true,remoteSort:false,onClickRow:onClickRowForGridRoleCAS">
				<thead>
					<tr>
						<th data-options="field:'checked',checkbox:true"></th>
						<th data-options="field:'id',width:30,hidden:false">id</th>
						<th data-options="field:'roleName',width:80" sortable="true">RoleName</th>
						<th data-options="field:'memo',width:80">memo</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="div_panel">
		 <table id="dg_category" class="easyui-datagrid" title="勾选即为访问排除的【联系人】类别" 
		 data-options="remoteSort:false,fitColumns:false,rownumbers:true,url:'contacts/categoryList',toolbar:'#toolbar_category'"
		  style="width:510px;height:500px;padding:10px;">
		 	<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'rowId',width:80">RoleId</th>
						<th data-options="field:'categoryName',width:200"
							sortable="true">CategoryName</th>
						<th data-options="field:'memo',width:140">memo</th>
					</tr>
			</thead>
		 </table>
		</div>
		<div id="toolbar_category" style="height: 24px">
		  <div id="toolbar_for_layout">
			<a href="javascript:void(0)" class="easyui-linkbutton"	iconCls="icon-save" onclick="saveExcludedCategory()">Save</a>
		  </div>
		  <div id="dg_category_title"></div>
		 	
		</div>
</body>
</html>