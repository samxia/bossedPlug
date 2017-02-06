var PriceRefer={
		createNew:function(){
			var pRefer={};
			pRefer.callbackSetPrice=function(){};
			
			pRefer.init=function(){
				pRefer.regEvent();
				//when press up and down key,select the row
				$("#datagrid_price").datagrid({}).datagrid("keyUpAndDown");
				
			};
			pRefer.open=function(kehuNo,partsNo,cangkDm,target,callbackFunctionSetPrice){
				
				pRefer.callbackSetPrice=callbackFunctionSetPrice;
				
				$.ajax({
					async:false,
					url: '../price/sale/pricerefer',
					data:{kehuNo:kehuNo,partsNo:partsNo,cangkDm:cangkDm},
					type: 'POST',
					dataType: 'json',
					timeout: 300000,
					success: function(result){
						//Temp=result;
						
						
						$('#datagrid_price').datagrid('loadData',result);
						
						
						$('#win_price').css({position: "absolute"});
						$('#win_price').css("left",$(target).offset().left);
						$('#win_price').css("top",$(target).offset().top+$(target).outerHeight());
						
						$('#win_price').panel('open');
						
						$('#datagrid_price').datagrid('selectRow',0);
						$('#datagrid_price').datagrid('getPanel').panel('panel').focus();
					}
					
				});
				
			};
		    pRefer.setPriceForCallback=function(){
		    	var row=$('#datagrid_price').datagrid('getSelected');
		    	if(row==null)
		    	{
		    		return;
		    	}
		    	//alert(row.jiag);
		    	pRefer.callbackSetPrice(row.jiag);
		    	pRefer.close();
		    };
			pRefer.close=function(){
				$('#win_price').panel('close');
			};
			pRefer.regEvent=function(){
				$('#datagrid_price').datagrid('getPanel').panel('panel').keypress(function(e){
					//console.log('keyCode='+e.keyCode);
					//console.log('which='+e.which);
					
					if(e.keyCode==27){//Esc,close window
						pRefer.close();
						e.preventDefault();  
						e.stopPropagation();
						}else if(e.keyCode==13&&e.which==13){
							pRefer.setPriceForCallback();
							e.preventDefault();  
							e.stopPropagation();
						}
					
				});
			};
			return pRefer;
		}
};