var url;
function newRole()
{
	$('#dialog_new_role').dialog('open').dialog('setTitle','New Role');
	$('#form_new_role').form('clear');
	url="role/create";
}
function editRole()
{
	var row=$('#dg_role').datagrid('getSelected');
	if(row==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a role first.'
		});
		return;
	}
	$('#dialog_new_role').dialog('open').dialog('setTitle','Edit Role');
	$('#form_new_role').form('load',row);
	url="role/update";
}
function saveRole() {
	$('#form_new_role').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				$('#dialog_new_role').dialog('close'); // close the dialog
				$('#dg_role').datagrid('reload'); // reload the role data
			}
		}
	});
}
function deleteRole()
{
	var row=$('#dg_role').datagrid('getSelected');
	if(row==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a role first.'
		});
		return;
	}
	var rName=row.roleName;
	if(!confirm('Are you sure delete Role:[ '+rName+' ]?'))
	{
		return;
	}
	
	$.ajax({
		url: "role/delete",
		type:'post',
		data:{id:row.id,
			roleName:rName
		},
		success:function(data,textStatus,jqXHR )
		{
			var result=eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				$.messager.show({
					title : 'Info',
					msg : 'Delete Role:['+rName+'] done.'
				});
				$('#dg_role').datagrid('reload'); // reload the role data
			}
		}
		});
}
function  onDblClickRowForGridRole(rowIndex, rowData)
{
	var roleName=rowData.roleName;
	var roleId=rowData.id;
	
	 
	$.ajax({
		url: "user/list",
		type:'post',
		data:{getUsersByRoleId:roleId},
		success:function(data,textStatus,jqXHR )
		{
			var result=eval('(' + data + ')');
			var users=result.users;
			var count=users.length;
			var msg=count + " users belong this role goup.<br>";
			for(var i=0;i<count;i++)
			{
				var user=users[i];
				msg=msg+(i+1)+":"+user.userName+"<br>";
			}
			$.messager.alert('Role:'+roleName,msg,'info');
		}
		});
	//$.messager.alert('Warning','The warning message');
}