var url;
function newPermission()
{
	$('#dialog_new_perm').dialog('open').dialog('setTitle','New Permission');
	$('#form_new_perm').form('clear');
	url="permission/create";
}
function savePermission()
{
	$('#form_new_perm').form('submit', {
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
				$('#dialog_new_perm').dialog('close'); // close the dialog
				$('#dg_perm').datagrid('reload'); // reload the role data
			}
		}
	});
}
function editPermission()
{
	var row=$('#dg_perm').datagrid('getSelected');
	if(row==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a perm first.'
		});
		return;
	}
	$('#dialog_new_perm').dialog('open').dialog('setTitle','Edit Permission');
	$('#form_new_perm').form('load',row);
	url="permission/update";
}
function deletePermission()
{
	var row=$('#dg_perm').datagrid('getSelected');
	if(row==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a perm first.'
		});
		return;
	}
	var pName=row.permissionName;
	if(!confirm('Are you sure to delete Permission:[ '+pName+' ]?'))
	{
		return;
	}
	
	$.ajax({
		url: "permission/delete",
		type:'post',
		data:{id:row.id,
			permissionName:pName
		},
		success:function(data,textStatus,jqXHR )
		{
			/**
			 * In case,login time out,login page show.
			 * If return login page, usually start with char '<',so check it first.
			 */
			if(data.indexOf("<")==2)
			{
				//alert(data);
			    /*$('#win').window({
			    	title:"Log in",
			        width:600,
			        height:400,
			        modal:true
			        });
			    $('#win').html(data);*/
				top.location.href="../login/login.jsp";
				return;
			}
			
			var result=eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				$.messager.show({
					title : 'Info',
					msg : 'Delete Permission:['+pName+'] done.'
				});
				$('#dg_perm').datagrid('reload'); // reload the role data
			}
		},
		 complete: function(XMLHttpRequest, textStatus) {
              //this; // ���ñ���AJAX����ʱ���ݵ�options����
			var status=XMLHttpRequest.status;
			if(401==status)
			{
				/*$.messager.show({
					title : 'Info',
					msg : 'No permission to delete.'
				});*/
				$.messager.alert("Info", "No permission to delete.");
			}
          }
		});
}
function onOpenForPermissionDialog()
{
	$('#groupName').combobox('reload');
}
function collapseGroupForPerm(target)
{
	var val=$(target).text();
	if(val=="Collapse")
	{
		$('#dg_perm').propertygrid("collapseGroup");
		$(target).linkbutton({text:'Expand'});
	}
	else
	{
		$('#dg_perm').propertygrid("expandGroup");
		$(target).linkbutton({text:'Collapse'});
	}
	
}