var CustomerSelector={
		createNew:function(){
			var cSelector={};
			
			cSelector.init=function(){
				$('#button_customer_selecter_close').bind('click',function(){
					$('#win_customer_selector').window('close');
				});
				$('#button_customer_search').bind('click',function(){
					cSelector.search();
				});
				$('#button_customer_selecter_select').bind('click',function(){
					cSelector.select();
				});
				$('#button_customer_clear').bind('click',function(){
					cSelector.clear();
				});
				cSelector.regEvent();
			};
			//when the input filed is changed,search auto
			cSelector.onChangeForInput=function(target)
			{
				if($(target).val().length>1)
				{
					cSelector.search();
				}
			};
			cSelector.onOpenForWindow=function()
			{
				$('#name').focus();
			};
			cSelector.clear=function(){
				$('#name').val("");
			};
			cSelector.search=function(){
				var name=$('#name').val();
				if(name.length==0)
				{
					return;
				}
				$('#datagrid_customer_list').datagrid('loading');
				
				$.ajax({
					url:'../contacts/list',
					type:'post',
					data:{kehuxz:1,mc:name},
					dataType:'json',
					timeout:10000,
					success:function(result){
						$('#datagrid_customer_list').datagrid('loaded');
						$('#datagrid_customer_list').datagrid('loadData',result);
					}
				});
			};
			cSelector.select=function(){
				var row=$('#datagrid_customer_list').datagrid('getSelected'); 
				if(row==null)
				{
					$.messager.show({
						title:'客户选择',
						msg:'请先选择一个客户。',
						timeout:3000,
						showType:'slide'
					});
					return;
				}
				var no=row.kehuNo;
				var mc=row.kehuMc;
				var xm=row.kehuXm;
				var dh=row.kehuDh;
				$('#sale_sheet_kehuNo').val(no);
				$('#sale_sheet_lxr').val(xm);
				$('#sale_sheet_name').val(mc);
				$('#sale_sheet_tel').val(dh);
				$('#win_customer_selector').window('close');
			};
			cSelector.regEvent=function()
			{
				$('#win_customer_selector').keypress(function(e){
					//console.log('keyCode='+e.keyCode);
					//console.log('which='+e.which);
					//Alt+s
					if(e.altKey && e.which==115){
						cSelector.search();
						e.preventDefault();  
						e.stopPropagation();
					}else if(e.altKey&&e.which==110){//Alt+n
						$('#name').focus();
						e.preventDefault();  
						e.stopPropagation();
					}else if(e.altKey&&e.which==99){//Alt+c
						cSelector.clear();
						e.preventDefault();  
						e.stopPropagation();
					}else if(e.keyCode==27){//Esc,close window
						   $('#win_customer_selector').window('close');
					}
					
				});
				
			};
			return cSelector;
		}
};