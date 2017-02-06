var SummarySelector={
		createNew:function(){
			var summarySelector={};
			summarySelector.init=function(){
				summarySelector.bindEvent();
				summarySelector.regKeyEvent();
			};
			summarySelector.bindEvent=function(){
				// In the sale list open window, cancle button
				$('#open_cancle').bind('click', function() {
					$('#win_open_sale_sheet').window('close');
				});
				//open button
				$('#open_ok').unbind('click');
				$('#open_ok').bind('click', function() {
					openSaleSheetSummaryItem();
				});
			};
			summarySelector.regKeyEvent=function(){
				$('#win_open_sale_sheet').keypress(function(e){
					
				});
			};
			return summarySelector;
		}
		
		
};