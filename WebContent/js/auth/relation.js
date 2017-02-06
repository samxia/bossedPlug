function saveRelationBetweenUserAndRole()
{
	var user=$('#dg_user').datagrid('getSelected');
	if(user==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a user first.'
		});
		return;
	}
	var userName=user.userName;
	var checked=$('#dg_role').datagrid('getChecked');
	//alert(checked.length);
	/*for(var i=0;i<checked.length;i++)
	{
		var row=checked[i];
		//alert(row.roleName);
	}*/
	if(!confirm('Are you sure update the role for [ '+userName+' ]?'))
	{
		return;
	}
	
	$.ajax({
		url: "rolesOfUser/save",
		type:'post',
		data:{user:$.toJSON(user),
			roles:$.toJSON(checked)
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
					msg : 'Save ok.'
				});
			}
		}
		});
	
}
function saveRelationBetweenRoleAndPermission()
{
	var role=$('#dg_role').datagrid('getChecked');
	//alert(role.length);
	if(role.length==0)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a role first.'
		});
		return;
	}
	if(role.length>1)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select one role once when update perms of role.'
		});
		return;
	}
	
	role=$('#dg_role').datagrid('getSelected');
	var checked=$('#dg_perm').datagrid('getChecked');
	if(!confirm('Are you sure update permissions for [ '+role.roleName+']?'))
	{
		return;
	}
	$.ajax({
		url: "permissionsOfRole/save",
		type:'post',
		data:{role:$.toJSON(role),
			permissions:$.toJSON(checked)
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
					msg : 'Save ok'
				});
			}
		}
		});
	
}