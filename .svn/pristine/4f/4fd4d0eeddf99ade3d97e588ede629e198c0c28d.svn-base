<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE html> 
<html> 
<head>
<meta charset="GB2312"> 
<title>Auth setting</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="../css/auth_index.css">
<style type="text/css">
#div_user,#div_role {
	float: left;
	margin-right: 20px;
}
</style>
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/datagrid-groupview.js"></script>
<script type="text/javascript" src="../js/util/jquery.json.2.4.js"></script>
<script type="text/javascript" src="../js/auth/index.js"></script>
<script type="text/javascript" src="../js/auth/role.js"></script>
<script type="text/javascript" src="../js/auth/perm.js"></script>
<script type="text/javascript" src="../js/auth/relation.js"></script>
</head>
<body>
<jsp:include page="header.jsp" flush="true" /><hr>
	<div>
		<div id="div_user">
			<table id="dg_user" class="easyui-datagrid" title="User"
				style="width: 150px; height: 500px"
				data-options="singleSelect:true,collapsible:false,url:'user/list',
		fitColumns:false,rownumbers:true,showFooter:true,remoteSort:false,onClickRow:onClickRowForGridUser">
				<thead>
					<tr>
						<th data-options="field:'id',width:30,hidden:true" sortable="true">id</th>
						<th data-options="field:'userName',width:80" sortable="true">Name</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="div_role">
			<table id="dg_role" class="easyui-datagrid" title="Role"
				style="width: 300px; height: 500px"
				data-options="singleSelect:false,collapsible:false,url:'role/list',
		fitColumns:false,rownumbers:true,showFooter:true,remoteSort:false,onCheck:onCheckForGridRole,
		onUncheck:onUnCheckForGridRole,	toolbar:'#toolbar_role',onDblClickRow:onDblClickRowForGridRole">
				<thead>
					<tr>
						<th data-options="field:'checked',checkbox:true"></th>
						<th data-options="field:'id',width:30,hidden:false">id</th>
						<th data-options="field:'roleName',width:130" sortable="true">RoleName</th>
						<th data-options="field:'memo',width:80">memo</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="div_perm">
			<table id="dg_perm" class="easyui-datagrid" title="Perms"
				style="width: 500px; height: 500px"
				data-options="singleSelect:false,collapsible:false,url:'permission/list',
		fitColumns:false,rownumbers:true,showFooter:true,remoteSort:false,toolbar:'#toolbar_perm',
		view:groupview,groupField:'groupName',
        groupFormatter:function(value,rows){return value + ' - ' + rows.length + ' ';}">
				<thead>
					<tr>
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:30,hidden:true">id</th>
						<th data-options="field:'memo',width:140">memo</th>
						<th data-options="field:'permissionName',width:280"
							sortable="true">PermsName</th>
						<th data-options="field:'groupName',width:140,hidden:true">group name</th>
						<th data-options="field:'buildin',width:40,hidden:true">build in</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="toolbar_role">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="newRole()">New</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editRole()">Edit</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="deleteRole()">Remove</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-save" plain="true" onclick="saveRelationBetweenUserAndRole()">Save</a>
	</div>
	<div id="dialog_new_role" class="easyui-dialog" data-options="modal:true,closed:true"
		style="width: 600px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#buttons_dialog_new_role">
		<div class="title">Role Information</div>
		<form id="form_new_role" method="post" class="form">
			<div class="form_item">
				<label>Role Name:</label> <input name="roleName"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="form_item">
				<label>Role memo:</label> <input name="memo"
					class="easyui-validatebox" />
			</div>
			<input name="id" type="hidden">
		</form>
	</div>
	<div id="buttons_dialog_new_role">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveRole()">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dialog_new_role').dialog('close')">Cancel</a>
	</div>
	<div id="toolbar_perm">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"
			onclick="newPermission()">New</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true"
			onclick="editPermission()">Edit</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true"
			onclick="deletePermission()">Remove</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-save" plain="true"
			onclick="saveRelationBetweenRoleAndPermission()">Save</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="" data-options="toggle:true"
			onclick="collapseGroupForPerm(this)">Collapse</a>
	</div>
		<div id="dialog_new_perm" class="easyui-dialog"
		data-options="modal:true,closed:true,onOpen:onOpenForPermissionDialog" style="width: 600px;height: 280px;padding: 10px 20px"
		buttons="#buttons_dialog_new_perm">
		<div class="title">Permission Information</div>
		<form id="form_new_perm" method="post" class="form">
		   <div class="form_item">
				<label>Group Name:</label> <input name="groupName" id="groupName"
					class="easyui-combobox" data-options="
					url:'permission/group/list', method:'get',valueField:'groupName',
					 textField:'groupName',panelHeight:'auto'"/>
			</div>
			<div class="form_item">
				<label>Permission Name:</label> <input name="permissionName"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="form_item">
				<label>Permission memo:</label> <input name="memo"
					class="easyui-validatebox" />
			</div>
			<input name="id" type="hidden">
		</form>
	</div>
		<div id="buttons_dialog_new_perm">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savePermission()">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dialog_new_perm').dialog('close')">Cancel</a>
	</div>
	<div id="win"></div>
</body>
</html>