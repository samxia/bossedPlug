var enableOnCheckForGridRole=true;
function onClickRowForGridUser(rowIndex,rowData)
{
	disableCheckEventForGridRole();
	
	var name=rowData.userName;
	// alert(name);
	// http://127.0.0.1:8080/shirodemo/auth/user/list?getRolesByName=a
	$.ajax({
		url: "user/list",
		type:'post',
		data:{getRolesByName:name},
		success:function(data,textStatus,jqXHR )
		{
			// alert(data);
			var user=$.evalJSON(data);
			// alert(user.roleList.length);
			changeRoleUIByUser(user);
			enableCheckEventForGridRole();
		}
		// context: document.body
		});
	
	
	
}
function changeRoleUIByUser(user)
{
	// set roleUI title
	$('#div_role .panel-title').text("Roles for: "+user.userName);
	// set perm UI title
	$('#div_perm .panel-title').text("Permissions for user: "+user.userName);
	
	// clear selections
	$('#dg_role').datagrid('clearSelections');
	$('#dg_perm').datagrid('clearSelections');
	
	// get all rows from role datagrid.
	var role_rows=$('#dg_role').datagrid('getRows');
	
	var roles=user.roleList;
	for(var i=0;i<roles.length;i++)
	{
		checkPermsByRole(roles[i]);
		
		rName=roles[i].roleName;
		// compare the role name
		for(var j=0;j<role_rows.length;j++)
		{
			row=role_rows[j];
			roleName=row.roleName;
			if(rName==roleName)
			{
				// if eq,check the row
				$('#dg_role').datagrid('checkRow',$('#dg_role').datagrid('getRowIndex',row));
				
			}
		}
	}
}
function checkPermsByRole(role,checkOrUncheck)
{
	// get all perms from permission datagrid
	var perm_rows=$('#dg_perm').datagrid('getRows');
	
	var perms=role.permissionList;
	for(var i=0;i<perms.length;i++)
	{
		var perm=perms[i];
		var permName=perm.permissionName;
		
		// compare the perm name
		for(var j=0;j<perm_rows.length;j++)
		{
			var perm_row=perm_rows[j];
			permName_ui=perm_row.permissionName;
			if(permName==permName_ui)
			{
				// if eq,check the row
				if(checkOrUncheck=="uncheck")
				{
					$('#dg_perm').datagrid('uncheckRow',$('#dg_perm').datagrid('getRowIndex',perm_row));
				}
				else
				{
					$('#dg_perm').datagrid('checkRow',$('#dg_perm').datagrid('getRowIndex',perm_row));
				}
			}
		}
	}
}
function onCheckForGridRole(rowIndex,rowData,checkOrUnCheck)
{
	if(enableOnCheckForGridRole==false)
	{//in case,when select user,run twice onCheck event for gridRole
		return;
	}
	var role_id=rowData.id;
	var role_name=rowData.roleName;
	
	// http://127.0.0.1:8080/shirodemo/auth/permission/list?getPermissionsByRoleId=1
	$.ajax({
		url: "permission/list",
		type:'post',
		data:{getPermissionsByRoleId:role_id},
		success:function(data,textStatus,jqXHR )
		{
			var role=$.evalJSON(data);

			// set perm UI title
			$('#div_perm .panel-title').text("Permissions for role: "+role_name+"-["+role.permissionList.length+"]");
			
			// var row=$('#dg_role').datagrid('selectRow',rowIndex);
			
			
			// clear selections
			//$('#dg_perm').datagrid('clearSelections');
			if(checkOrUnCheck=="uncheck")
			{
				checkPermsByRole(role,"uncheck");
			}
			else{
				checkPermsByRole(role,"check");
			}
			
		}
		});
	
}
function onUnCheckForGridRole(rowIndex,rowData)
{
	onCheckForGridRole(rowIndex,rowData,"uncheck");
}
function enableCheckEventForGridRole()
{
	enableOnCheckForGridRole=true;
	
}
function disableCheckEventForGridRole()
{
	enableOnCheckForGridRole=false;
}
/*
 * function checkBoxFormatter(value,row,index){ if(row.checked){ return '<input
 * type="checkbox" name="DataGridCheckbox" checked="checked">'; } else{ return '<input
 * type="checkbox" name="DataGridCheckbox">'; }
 *  }
 */