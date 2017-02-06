/**
 * global varibles
 */
var SaleItemUI = DgSaleItemUI.createNew();// ui_dg_sale_item.js
var PartsSelector = PartsSelector.createNew();// ui_parts_selector.js
var SummarySelector=SummarySelector.createNew();//summary_selector.js
var CustomerSelector=CustomerSelector.createNew();//customer_selector.js
var DataSale = SaleData.createNew();// data.js
var ReferPrice=PriceRefer.createNew();//price_refer.js
var DanWeiData;// global var
DataSale.getAllDanwei();// get all danwei data
var CurrentTarget;
var CurrentRowIndex;
var Temp;

function bindClickEvent() {
	// New,click new button,enable the workspace
	bindClickForNewButton();
	// Destory,click destory button,disable the workspace
	
	// Open
	bindClickForOpenButton();
	
	// Customer selector
	
	
	// Add parts button, id----button_add_parts
	

	//save button
	

	//when danwei combobox lost focus,hide the danwei combobox div
	$('#div_danwei [type=text]').mouseleave(function(){$(div_danwei).hide();});
}
function bindClickForOpenButton()
{
	unbindClickForOpenButton();
	$('#open').bind('click', function() {
		openSaleSheetSummaryWin();
	});
}
function unbindClickForOpenButton()
{
	$('#open').unbind('click');
}
function bindClickForCustomerSelectorButton()
{
	 unbindClickForCustomerSelectorButton();
	$('#button_customer_selector').bind('click', function() {
		openCustomerSelectorWindow();
	});
}
function unbindClickForCustomerSelectorButton()
{
	$('#button_customer_selector').unbind('click');
}
function bindClickForAddPartsButton()
{
	unbindClickForAddPartsButton();
	$('#button_add_parts').bind('click', function() {
		$('#win_parts_selector').window('open');
	});
}
function unbindClickForAddPartsButton()
{
	$('#button_add_parts').unbind('click');
}
function bindClickForSaveButton()
{
	unbindClickForSaveButton();
	$('#save').bind('click', function() {
		DataSale.save();
		$('#div_new a').linkbutton('enable');
		bindClickForNewButton();
		bindClickForOpenButton();
	});
}
function unbindClickForSaveButton()
{
	$('#save').unbind('click');
}
function bindClickForDestoryButton()
{
	unbindClickForDestoryButton();
	$('#destory').bind('click', function() {
		destorySaleSheet();

	});
}
function unbindClickForDestoryButton()
{
	$('#destory').unbind('click');
}
function bindClickForNewButton()
{
	unbindClickForNewButton();
	$('#new').bind('click', function() {
		newSaleSheet();
	});
}
function unbindClickForNewButton()
{
	$('#new').unbind('click');
}
/**
 * While page show,add a new row
 */
$(function() {
	// $('#datagird_sale_item').edatagrid('addRow');
	addNewRow();
	disableWorkspace();
});
/**
 *document ready
 */
$(document).ready(function(){
	//Bind click event to button
	bindClickEvent();
	//init parts selector window
	PartsSelector.init();
	//init summary list selector window
	SummarySelector.init();
	//init customer selector window
	CustomerSelector.init();
	//init price selector window
	ReferPrice.init();
	//
	SaleItemUI.init();
	
	// Regist key event
	// reg keypress for div div_sale_sheet_workspace
	$('#div_sale_sheet_workspace').keypress(function(e){
		console.log('keyCode='+e.keyCode);
		console.log('which='+e.which);
		//Alt+s
		if(e.keyCode==37){//press left key
		   $(e.target).parents('td').eq(1).prev().find(
			'.datagrid-editable-input').first().focus();
		   //alert(e.which);
	   } else if(e.keyCode==39){// press right key,move right
		   $(e.target).parents('td').eq(1).next().find(
			'.datagrid-editable-input').first().focus();
	   }else if(e.keyCode==38){// press up key ,move to up
		   moveUp(e);
	   }else if(e.keyCode==40){//press down key,add a new row
		   moveDownOrAddNewRow(e);
	   }else if(e.ctrlKey&&e.keyCode==46){//press ctrl+del
		   deleteRow(e);
	   }
		
	});
});

/**
 * Delete row
 */
function deleteRow(event) {
	// Alway left one row
	if ($('#datagird_sale_item').datagrid('getRows').length == 1) {
		return;
	}

	var row_index = getFocusedRowIndex(event);
	// if no focus on the datagrid,return.
	if (row_index == -1) {
		return;
	}
	// $.messager.confirm("请确认","确认删除这条记录吗？",function(r){
	// if (r){
	$('#datagird_sale_item').datagrid('deleteRow', row_index);
	// }
	// });
	SaleItemUI.caculateFooter();
}
/**
 * add a new row,then focus on the '配件名称' filed。
 */
function addNewRow() {
	// append a new row
	$('#datagird_sale_item').datagrid('appendRow', {});

	// begin edit the new row
	var row_count = $('#datagird_sale_item').datagrid('getRows').length;
	$('#datagird_sale_item').datagrid('selectRow', row_count - 1);
	$('#datagird_sale_item').datagrid('beginEdit', row_count - 1);

	//focus on the new row's mingCheng col
	var editor_bianMa=$('#datagird_sale_item').datagrid('getEditor', {index:row_count - 1,field:'bianMa'});
	editor_bianMa.target.focus();
	
	SaleItemUI.setEditingForCaculation(row_count - 1);

	// focus to the name field
	// var editors =
	// $('#datagird_sale_item').datagrid('getEditors',row_count-1);
	// editors[1].target.focus();

	/*
	 * $('#datagird_sale_item').edatagrid('addRow'); var editors =
	 * $('#datagird_sale_item').datagrid('getEditors',
	 * $('#datagird_sale_item').datagrid('getRows').length-1);
	 * editors[1].target.focus();
	 */

}
/**
 * move up in datagrid
 */
function moveUp(event) {

	// move up
	var fieldName = $(event.target).parents('td').eq(1).attr("field");
	$(event.target).parents('tr').eq(1).prev().find(
			"[field='" + fieldName + "']").first().find(
			".datagrid-editable-input").first().focus();

	// check if the last row is valid,if not and no data in last row,del it.
	var row_count = $('#datagird_sale_item').datagrid('getRows').length;
	if ($('#datagird_sale_item').datagrid('validateRow', row_count - 1) == false) {
		$('#datagird_sale_item').datagrid('deleteRow', row_count - 1);
	}

	/*
	 * var row_selected=$('#datagird_sale_item').datagrid('getSelected');
	 * if(row_selected==null) {return;} var
	 * row_index=$('#datagird_sale_item').datagrid('getRowIndex',row_selected);
	 * if(row_index!=0) { //move to up
	 * $('#datagird_sale_item').datagrid('selectRow',row_index-1); }
	 */
}
/**
 * move down in datagrid,if is the last row,add a new row.
 */
function moveDownOrAddNewRow(event) {
	// get the index of focused row.
	var current_row_index = $(event.target).parents('tr').eq(1).index();

	// if get to the last row,add a new row.
	var row_count = $('#datagird_sale_item').datagrid('getRows').length;
	if (current_row_index + 1 == row_count) {
		// if the last row validate failed,just return.
		if ($('#datagird_sale_item').datagrid('validateRow', row_count - 1) == false) {
			return;
		}
		addNewRow();
		return;
	}

	// move to next row
	var fieldName = $(event.target).parents('td').eq(1).attr("field");
	$(event.target).parents('tr').eq(1).next().find(
			"[field='" + fieldName + "']").first().find(
			".datagrid-editable-input").first().focus();

	/*
	 * //if no row selected,return; var
	 * row_selected=$('#datagird_sale_item').datagrid('getSelected');
	 * if(row_selected==null) {return;}
	 * 
	 * var
	 * row_index=$('#datagird_sale_item').datagrid('getRowIndex',row_selected);
	 * var dg_rows=$('#datagird_sale_item').datagrid('getRows'); var
	 * row_count=dg_rows.length;
	 * 
	 * //check if the selected row is the last row,if yes,add a new row
	 * if(row_index+1==row_count) {
	 * //$('#datagird_sale_item').edatagrid('addRow'); addNewRow(); } else {
	 * //move to next row
	 * $('#datagird_sale_item').datagrid('selectRow',row_index+1); }
	 */
}

function disableWorkspace() {
	// div_work,div_sale_sheet_info,div_sale_sheet_credit,div_sale_sheet_cutomer,div_sale_sheet_invoice
	// div_sale_sheet_workspace,div_sale_sheet_operator
	$('#div_sale_sheet_workspace :input').attr("disabled", true);
	$('#div_sale_sheet_operator :input').attr("disabled", true);

	$('#div_new a').linkbutton('enable');

	$('#div_work a').linkbutton('disable');
	
	unbindClickForCustomerSelectorButton();
	unbindClickForDestoryButton();
	unbindClickForAddPartsButton();
	unbindClickForSaveButton();
	// $('#div_work a').unbind('click');

}
function enableWorkspace() {

	$('#div_sale_sheet_workspace :input').removeAttr("disabled");
	$('#div_sale_sheet_operator  :input').removeAttr("disabled");

	$('#div_work a').linkbutton('enable');

	$('#div_new a').linkbutton('disable');

	bindClickForSaveButton();
	bindClickForDestoryButton();
	bindClickForAddPartsButton();
	bindClickForCustomerSelectorButton();
	
	addNewRow();
}
/**
 * 作废
 */
function destorySaleSheet() {
	var danhao=$('#sale_sheet_dan_hao').val();
	
	if(!confirm("确定作废销售单："+danhao+"吗？"))
	{
		return;
	}
	
	DataSale.zuofeiSaleSheet(danhao);
	
	clearUI();
	disableWorkspace();
	bindClickForNewButton();
	bindClickForOpenButton();
}
function clearUI() {
	// clear input
	$('#div_sale_sheet_workspace').find(':input').val("");
	$('#div_sale_sheet_operator').find(':input').val("");
	$('#datagird_sale_item').datagrid('loadData',
			jQuery.parseJSON('{"total":0,"rows":[]}'));
}
/**
 * click open button in main page
 */
function openSaleSheetSummaryWin() {
	DataSale.fillSaleSheetSummary2Datagrid();
	// SaleData.createNew();
	$('#win_open_sale_sheet').window('open');
	
	
}
function onClickRowForSheetOpenListDatagrid(rowIndex, rowData) {
	$('#danhao').val(rowData.danhao);
}
// open sale sheet by danHao
function openSaleSheetSummaryItem() {
	var row = $('#datagrid_sheet_open_list').datagrid('getSelected');
	if (row == null) {
		alert("请选择销售单");
		return;
	}
	enableWorkspace();

	DataSale.openSaleSheetItem(row.danhao, row.kehuNo);
	$('#win_open_sale_sheet').window('close');
}
/**
 * click 'New' button
 */
function newSaleSheet() {

	clearUI();
	enableWorkspace();
	unbindClickForNewButton();
	unbindClickForOpenButton();
	DataSale.newSaleSheet();
}
/**
 * get focused row index by event like 'click'
 * 
 * @param event
 * @returns
 */
function getFocusedRowIndex(event) {
	// get the index of focused row in sale sheet item datagrid.
	return $(event.target).parents('tr').eq(1).index();
}

/***
 * select danwei from danwei list container
 */
function selectDanWei(target)
{
	//show danwei combobox by the target position
	$(div_danwei).css({position: "absolute"});
	$(div_danwei).css("left",$(target).offset().left);
	$(div_danwei).css("top",$(target).offset().top+$(target).outerHeight());

	//set combobox value 
	$('#combobox_danwei').combobox('setValue', $(target).val());
	
	//show the combobox
	$(div_danwei).show();
//	$("#div_danwei").find('.combo-text').first().focus();
	//set value for global var for memory the current danwei input field.
	CurrentTarget=target;
	
	//alert($(target).offset().left);
	// alert($(target).val());
}
function onSelectForDanWeiCombox(record)
{
	$(CurrentTarget).val(record.lcMc);
	$(div_danwei).hide();
}
/**
 * Press enter key in danwei field
 * @param event
 * @param target
 */
function enterForDanWei(event,target)
{
	//Press enter key
	var key=event.keyCode;
	//console.log(key);
	if(key==13)
	{
		//alert($(target).val());
		selectDanWei(target);
	}
}
/**
 * Press enter key in customer bianMa field
 * @param event
 * @param target
 */
function enterForKehuNo(event,target)
{
	if(event.keyCode==13)
	{
		openCustomerSelectorWindow();
	}
}

/**
 * Press enter key for mingcheng field.
 * @param event
 * @param target
 */
function enterForMingcheng(event,target){
	
	//dblclick
	if(event instanceof  MouseEvent)
	{
		openPartsSelectorWindowAndSearch(target);
		PartsSelector.search();
		return;
	}
	//alert(event);
	//Press enter key
	var key=event.keyCode;
	//console.log(key);
	if(key==13)
	{
		openPartsSelectorWindowAndSearch(target);
		var fieldName=getFieldNameByTarget(target);
		if(fieldName=='bianMa')
		{
			PartsSelector.search();
		}
	}
}

function getFieldNameByTarget(target)
{
	return $(target).parents("td").eq(1).attr('field');
}
//open parts selector window and search
function openPartsSelectorWindowAndSearch(target)
{
	//alert($(target).val());
	var row_index=$(target).parents(".datagrid-row").eq(0).attr('datagrid-row-index');
	//for setting data by current Row Index from parts selector 
	CurrentRowIndex=row_index;
	
	//open parts selector window
	$('#win_parts_selector').window('open');
	$("#peijMc").val( $($('#datagird_sale_item').datagrid('getEditor', {index:CurrentRowIndex,field:'mingCheng'}).target).val());
	$("#peijTh").val( $($('#datagird_sale_item').datagrid('getEditor', {index:CurrentRowIndex,field:'tuHao'}).target).val());
	$("#peijNo").val( $($('#datagird_sale_item').datagrid('getEditor', {index:CurrentRowIndex,field:'bianMa'}).target).val());
	$("#peijCx").val( $($('#datagird_sale_item').datagrid('getEditor', {index:CurrentRowIndex,field:'cheXing'}).target).val());
	
	
}
/**
 * open customer selector window and search
 */
function openCustomerSelectorWindow()
{
	$('#name').val($('#sale_sheet_kehuNo').val());
	$('#win_customer_selector').window('open');
	CustomerSelector.search();
}