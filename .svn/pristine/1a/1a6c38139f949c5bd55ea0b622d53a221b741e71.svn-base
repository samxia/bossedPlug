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
#div_role,#div_excludedCategory,#div_button_save,#div_button_move{
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
				style="width: 340px; height: 500px"
				data-options="singleSelect:true,collapsible:false,url:'role/list',
		fitColumns:false,rownumbers:true,showFooter:true,remoteSort:false,onClickRow:onClickRowForGridRoleCAS">
				<thead>
					<tr>
						<th data-options="field:'checked',checkbox:true"></th>
						<th data-options="field:'id',width:28,hidden:false">id</th>
						<th data-options="field:'roleName',width:120" sortable="true">RoleName</th>
						<th data-options="field:'memo',width:130">memo</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="div_excludedCategory">
		 <table id="dg_category" class="easyui-datagrid" title="访问排除的【联系人】类别" 
		 data-options="singleSelect:true,url:'contacts/getExcludeCategoryByRoleId',
		 remoteSort:false,fitColumns:false,rownumbers:true,toolbar:'#toolbar_category'"
		  style="width:350px;height:500px;padding:10px;">
		 	<thead>
					<tr>
					   <th data-options="field:'roleId',width:40"
							sortable="false">roleId</th>
						<th data-options="field:'categoryCode',width:100"
							sortable="true" hidden="true">CategoryCode</th>
						<th data-options="field:'categoryName',width:160"
							sortable="true">CategoryName</th>
						<th data-options="field:'memo',width:100">memo</th>
					</tr>
			</thead>
		 </table>
		</div>
		<div id="div_button_move" style="width: 50px; height:500px;padding-top:180PX">
			 <a href="javascript:void(0)" class="easyui-linkbutton"	iconCls="icon-right-arrow" onclick="addExcludedCategory()"></a>
			 <a href="javascript:void(0)" class="easyui-linkbutton"	iconCls="icon-left-arrow" onclick="removeExcludedCategory()" style="margin-top: 50px"></a>
		</div>
		<div id="div_panel" class="easyui-panel" title="【联系人】类别" style="width: 400px; height:500px">
	       <ul id="tree_category" class="easyui-tree" 
	       data-options="url:'../contacts/category/tree',onlyLeafCheck:false,cascadeCheck:false,method:'get',animate:true,checkbox:true"></ul>
		</div>
		<div id="toolbar_category" style="height: 24px">
		    <div id="div_button_save">
			   <a href="javascript:void(0)" class="easyui-linkbutton"	iconCls="icon-save" onclick="saveExcludedCategory()">Save</a>
			</div>
			<div id="div_label_category"></div>
		</div>
</body>
</html>