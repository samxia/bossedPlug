function onClickRowForGridRoleCAS(rowIndex,rowData)
{
	var role_id=rowData.id;
	
	$.ajax({
		url: "contacts/getExcludeCategoryByRoleId",
		type:'post',
		data:{role_id:role_id},
		success:function(data,textStatus,jqXHR )
		{
			// alert(data);
			var excludedCategories=$.evalJSON(data);
			changeCategoryUIByExcludedCategories(excludedCategories);
			//enableCheckEventForGridRole();
		}
		// context: document.body
		});
	
	
}
function changeCategoryUIByExcludedCategories(excludedCategories)
{
	// clear selections
	$('#dg_category').datagrid('clearSelections');
	
	// set categoryUI title
	//$('#div_panel .panel-title').text("["+excludedCategories.rows.length + "] rows should be checked(EXCLUDED)");
	$('#dg_category_title').html("[<font color=red>"+excludedCategories.rows.length + "</font>] rows should be checked(<font color=red>EXCLUDED</font>)");
	//alert(excludedCategories.rows.length);
	
	
	for(var i=0;i<excludedCategories.rows.length;i++)
	{
		var excludedCategory=excludedCategories.rows[i];
		checkCategoryByExcludedCategory(excludedCategory);
		//alert(excludedCategory.categoryName);
	}
}
function checkCategoryByExcludedCategory(excludedCategory)
{
	// get all rows from category datagrid.
	var category_rows=$('#dg_category').datagrid('getRows');
	
	var excludedCategoryName=excludedCategory.categoryName;
	
	for(var i=0;i<category_rows.length;i++)
	{
		var row=category_rows[i];
		var categoryName=row.categoryName;
		if(excludedCategoryName==categoryName)
		{
			//alert("checked.");
			$('#dg_category').datagrid('checkRow',i);
			return;
		}
	}
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
	
}