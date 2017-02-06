function onClickRowForGridRoleCAS(rowIndex,rowData)
{
	var role_id=rowData.id;
	
	$('#dg_category').datagrid('load',{
		role_id: role_id
	});
	
    $('#div_label_category').html("<h2 style='color:red'>"+rowData.roleName+"</h2>");
	/*$.ajax({
		url: "contacts/getExcludeCategoryByRoleId",
		type:'post',
		data:{role_id:role_id},
		success:function(data,textStatus,jqXHR )
		{
			// alert(data);
			var excludedCategories=$.evalJSON(data);


		}
		// context: document.body
		});*/
	
	
}
function addExcludedCategory()
{
	//check if select corresponding role
	var role=$('#dg_role').datagrid('getSelected');
	if(role==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a role first before add.'
		});
		return;
	}
	//check if select tree's nodes
	var nodes = $('#tree_category').tree('getChecked');
	for(var i=0;i<nodes.length;i++)
	{
		var node=nodes[i];
		addNewRowToExcludedCategoryDataGrid(role.id,node.text,node.id);
	}
		
	
}
function addNewRowToExcludedCategoryDataGrid(roleId,categoryName,categoryCode)
{
	var rows=$('#dg_category').datagrid('getRows');
	for(var i=0;i<rows.length;i++)
	{
		var row=rows[i];
		var excludedCateName=row.categoryName;
		if(excludedCateName==categoryName)
		{
			alert("Has existed category:"+categoryName+" in excluded category grid.");
			return;
		}
	}
	$('#dg_category').datagrid('appendRow',{
		roleId:roleId,
		categoryCode:categoryCode,
		categoryName: categoryName,
		memo: ""
	});
}
function removeExcludedCategory()
{
	var exCate=$('#dg_category').datagrid('getSelected');
	if(exCate==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a ExcludedCategory first before remove.'
		});
		return;
	}
	//deleteRow
	$('#dg_category').datagrid('deleteRow',$('#dg_category').datagrid('getRowIndex',exCate));
}

function saveExcludedCategory()
{
	//First,check if there is selection in datagrid Role.
	var role=$('#dg_role').datagrid('getSelected');
	if(role==null)
	{
		$.messager.show({
			title : 'Info',
			msg : 'Please select a role first before save.'
		});
		return;
	}
	
	///auth/contacts/excludedCategorySave
	$.ajax({
		url: "contacts/excludedCategorySave",
		type:'post',
		data:{role:$.toJSON(role),
			excludedCategory:$.toJSON($('#dg_category').datagrid('getRows'))
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