<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%@ page import="org.apache.shiro.SecurityUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
<style type="text/css">
.searchbox{
	margin-bottom: -15px;
}
.searchbox .searchbox-text{
	font-size:20px;
}
</style>
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/datagrid-bufferview.js"></script>
<script type="text/javascript" src="../js/contact/list_tree.js"></script>
</head>
<body>
<div style="display:none;"> 
	<input type="hidden" id="id_perms_contacts_create" value=<%=SecurityUtils.getSubject().isPermitted("contacts:create")%>>
</div>
<div id="id_layout" class="easyui-layout" style="width:650px;" data-options="fit:true">
	<!-- <div data-options="region:'west',split:false" style="width:150px;">
 	<ul id="id_tree" class="easyui-tree" data-options="lines:true,animate:true,onSelect:onSelectFromTree,onContextMenu:onContextMenuFromTree,url:'category/tree'" >  
    </ul>  
	</div>   -->
    <div data-options="region:'center'" style="width:100%;">
    	<div>
		<table id="dg" class="easyui-datagrid" title="联系人"
			style="width:640px; height:560px"
			data-options="view:bufferview,singleSelect:true,collapsible:false,url:'list',
		fitColumns:false,rownumbers:true,showFooter:true,remoteSort:false,toolbar: '#toolbar',
		pageSize:30,onDblClickRow:onDblClickRow,rowStyler:rowStyler,onRowContextMenu:onRowContextMenu">
			<thead>
				<tr>
					<!-- 编码kehuNo 名称kehuMc 电话kehuDh 联系人kehuXm 手机kehuSj
				 传真kehuCz 备注kehuBz 全称kehuQc 税号kehuSh 禁用kehuIsopen   -->
				    <th data-options="field:'picCount',width:30,formatter:picCountFormatter" sortable="true">图片</th>
					<th data-options="field:'kehuNo',width:100,hidden:true" sortable="true">编码</th>
					<th data-options="field:'kehuMc',width:140,halign:'center'" sortable="true">名称</th>
					<th data-options="field:'kehuDh',width:250,halign:'center'" sortable="true">电话</th>
					<th data-options="field:'kehuSj',width:100,halign:'center'" sortable="true">手机</th>
					<th data-options="field:'kehuBz',width:200" sortable="true">备注</th>
					<th data-options="field:'kehuXm',width:100,hidden:true" sortable="true">联系人</th>
					<th data-options="field:'kehuCz',width:100,hidden:true" sortable="true">传真</th>
					<th data-options="field:'kehuQc',width:100,hidden:true" sortable="true">全称</th>
					<th data-options="field:'kehuSh',width:100,hidden:true" sortable="true">税号</th>
					<th data-options="field:'kehuIsopen',width:50,hidden:true" sortable="true">禁用</th>
					<th data-options="field:'kehulbDm',width:50,hidden:true" sortable="true">代码</th>
					<th data-options="field:'kehulbMc',width:50,hidden:true" sortable="true">类别</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar" style="height: 40px">
			<input class="easyui-searchbox"
				data-options="prompt:'名称、电话、手机、传真、备注，然后回车或(Alt+s)',searcher:doSearch,height:40,width:200"
				 id="search_box"></input>
				 
				<a href="#"	class="easyui-linkbutton" onclick="doSearch($('#search_box').searchbox('textbox')[0].value)">
				查询(<U>S</U>) 
				</a>
				<a href="#"	class="easyui-linkbutton" data-options="plain:true" onclick="setValForGroupbutton(0)">
					<input type="radio" name="kehuxz" id="check_all" value="0" checked="checked">全部(<U>A</U>)</input>
				</a>
				<a href="#"	class="easyui-linkbutton" data-options="plain:true" onclick="setValForGroupbutton(1)">
				 <input type="radio" name="kehuxz" id="check_kehu" value="1">客户(<U>K</U>)</input>
				 </a>
				 <a href="#"	class="easyui-linkbutton" data-options="plain:true" onclick="setValForGroupbutton(2)">
				<input type="radio" name="kehuxz" id="check_gy" value="2">供应商(<U>G</U>)</input>
				</a>
				<a href="#"	class="easyui-linkbutton" data-options="plain:true" onclick="setValForGroupbutton(3)">
				<input type="radio" name="kehuxz" id="check_rest" value="3">博士德以外(<U>Q</U>)</input>
				</a>
			
		</div>
	</div>
	<div>
		<div id="win_detail" class="easyui-window" title="联系人" style="width:650px;height:550px"  
		       data-options="iconCls:'icon-search',modal:true,closed:true,onClose:onClose_win_detail,minimizable:false,resizable:false,maximizable:false,draggable:true,collapsible:false">  
		 <iframe id="iframe_detail" src="" width="100%"
				height="100%" marginheight="0" marginwidth="0" scrolling="no"
				frameborder="no" align="middle"></iframe>
		</div>  
	    
	</div>
	<div>
	 <div id="id_menu" class="easyui-menu" style="width:120px;">
		<div onclick="javascript:deleteKehu()">删除</div>
		<div>
		   <span>转到</span>
		   <div style="width:150px;">  
               <div onclick="javascript:changeKehuXz(1)">客户</div>
               <div onclick="javascript:changeKehuXz(2)">供应商</div>
               <div onclick="javascript:changeKehuXz(3)">博士德外</div>
           </div>  
		</div>
		<div class="menu-sep"></div>
		<div>Exit</div>
	 </div>
	
	</div>
    </div>  
</div>
	
	<script type="text/javascript">
	function showSearchCritiral(critial)
	{
		var pn=$('#dg').datagrid("getPanel");
		pn.panel("setTitle",critial);
	}
	function generateChangeXzMenu()//生成转换性质子菜单
	{
		var row=$('#dg').datagrid('getSelected');
		if(row==null)return;
		
		var item = $('#id_menu').menu('findItem', '转换到');  // find 'Open' item
		var kehuXz=row.kehuXz;
		if(kehuXz==1 || kehuXz==2)//1-客户，2-供应商
		{
			disableMenu("客户");
			disableMenu("供应商");
			enableMenu("博士德外");
			return;
		}
		if(kehuXz==3)//3-博士德外
		{
			enableMenu("客户");
			enableMenu("供应商");
			disableMenu("博士德外");
			return;
		}
	}
	function disableMenu(lable)
	{
		var item = $('#id_menu').menu('findItem',lable);
		 $('#id_menu').menu('disableItem',item.target);
	}
	function enableMenu(lable)
	{
		var item = $('#id_menu').menu('findItem',lable);
		 $('#id_menu').menu('enableItem',item.target);
	}
	function changeKehuXz(newXz)//改变客户性质
	{
         if(newXz==3)return;//for safe. before acl is ok.
		
		var row=$('#dg').datagrid('getSelected');
		if(row==null)return;
		var kehuNo=row.kehuNo;
	 	$.messager.confirm('更改性质','确认要改变客户:'+kehuNo+' 的性质吗?',function(r){  
		    if (r){
		    	$.ajax({
		    		type: 'POST',
		    		url: 'update',
		    		data: {'kehuNo':kehuNo,kehuXz:newXz},
		    		dataType:'JSON',
		    		 success: function(result){
                          if(result==1)
                            {
                        	  $.messager.alert("转换成功","请刷新",'info'); 
                              }
                           
			    		 }
			    	});
			     }}); 
	}
	function deleteKehu()
	{
		var data=$('#dg').datagrid('getSelected');
		if(data==null)return;
		
		$.messager.confirm('删除','确认删除联系人<br>【编码:'+data.kehuNo+"<br>名称:"+data.kehuMc+'】吗?',function(r){  
		    if (r){  
		    	$.ajax({
		    		  type: 'POST',
		    		  url: 'delete',
		    		  data: {'kehuNo':data.kehuNo},
		    		  success: function(result){
                            var rst=result.result;
                            if(rst=="success")
                             {
                            	$('#dg').datagrid('deleteRow',$('#dg').datagrid('getRowIndex',data));
                            	$.messager.alert('成功删除:'+data.kehuMc,"已删除",'info'); 
                            	
                                //alert("o");
                             }
                            else
                               {
                            	$.messager.alert('无法删除:'+data.kehuMc,rst,'info');  
                               }
			    		  },
		    		  dataType:'JSON'
		    		});
		    }  
		});  
	}
	/**
	a-97,k-107,g-103,q-113
	*/
	function rowStyler(index,row)
	{
		if(row.kehuXz==1)
		{
			 return 'color:#000088;';
		}
		if(row.kehuXz==2)
		{
			 return 'color:#008800;';
		}
		if(row.kehuXz==3)
		{
			 //return 'color:#F00000;';
		}
	}
	function onClose_win_detail()
	{
		$("#iframe_detail").attr("src","");
	}
	function onDblClickRow(rowIndex,rowData)
	{
		
		//alert(rowData.kehuNo);
		
		if(rowData.kehuXz==2)
		{
			$('#win_detail').window('open');
			//$("#iframe_detail").attr("src","detail_gys.html?kehuNo="+rowData.kehuNo);
			$("#iframe_detail").attr("src","detail_gys.jsp?kehuNo="+rowData.kehuNo);
			return;
		}
		//if(rowData.kehuXz==1)
	//	{
			$('#win_detail').window('open');
			//$("#iframe_detail").attr("src","detail_kehu.html?kehuNo="+rowData.kehuNo);
            $("#iframe_detail").attr("src","detail_kehu.jsp?kehuNo="+rowData.kehuNo);
			//style.zIndex
			
			
			
      		  return;
	//	}
		
		
	}
	$(document).keypress(function(e){
		//alert(e.which);
        if(e.ctrlKey && e.which == 13) {  
                 //alert("You clicked Ctrl+Enter");
        } else if (e.shiftKey && e.which==13) {
                //alert("You clicked Shift+Enter"); 
       }  else if (e.altKey && e.which==65) {
               // alert("You clicked Alt+A"); 
       } else if(e.altKey && e.which==115){
    	   $('#search_box').searchbox('textbox')[0].focus();
    	   doSearch($('#search_box').searchbox('textbox')[0].value);//Alt+s
           e.preventDefault();  
           e.stopPropagation();
           } 
       else if(e.altKey && e.which==97)//a
       {
    	   setValForGroupbutton(0);
        }
       else if(e.altKey && e.which==107)//k
       {
    	   setValForGroupbutton(1);
        }
       else if(e.altKey && e.which==103)//g
       {
    	   setValForGroupbutton(2);
        }
       else if(e.altKey && e.which==113)//q
       {
    	   setValForGroupbutton(3);
        }
       })
       
       function setValForGroupbutton(indexValue)
       {
		 $('input:radio').each(function(index,domEle){

		    if(index==indexValue)
			    {
		    	domEle.checked=true;
		    	doSearch($('#search_box').searchbox('textbox')[0].value);
                     return;
			    }

		});
		
	   }
       function doSearch(value,category){
			if (value=="") return false;
		/*     $('#dg').datagrid('load', {  
		    	mc:value
		    });   */ 

		    if(value.indexOf("可搜索")!=-1)
			{
		    	showSearchCritiral("请输入查询条件");
				return;
			}
			
		    var kehuxz=$("input[name='kehuxz']:checked").val();
//显示搜索条件
		    var critiral="查询条件-名称:[" + value + "]&nbsp;&nbsp;性质:[";
		    switch(kehuxz)
		    {
		    case "0":
		    	critiral=critiral+"全部"
			 	break;
		    case "1":
		    	critiral=critiral+"博士德-客户"
			 	break;
		    case "2":
		    	critiral=critiral+"博士德-供应商"
			 	break;
		    case "3":
		    	critiral=critiral+"非博士德联系人"
			 	break;
		    }
		    if(category!=""&&$('#id_tree').tree('getSelected')!=null)
			{
		    	critiral=critiral+"]&nbsp;&nbsp;类别：["+$('#id_tree').tree('getSelected').text;
			}

		    
			    
		    showSearchCritiral(critiral+"]");
		    //submit
			$.ajax({
				url: 'list',
				type: 'POST',
				data:{
					mc:value,
					kehuxz:kehuxz,
					category:category
					},
				dataType: 'json',
				timeout: 100000,
				error: function(p){
					/* $.messager.confirm('Error:'+p,'刷新此页面？',function(r){  
					    if (r){  
					    	self.location.reload();  
					    }  
					});  */ 
					self.location.reload();//if error，refresh this page
					},
				success: function(result){
					
					 $('#dg').datagrid('loadData',result);
					if(result.total==0)
					{
						 $.messager.show({
							 title:'查询完毕',
							 msg:'未查询到符合条件的结果。',
							 timeout:1000,
							 showType:'fade',
							 style:{
								 right:'',
								 bottom:''
								 }
							 });
					}
                     }
				});
			}
      function onRowContextMenu(e, rowIndex, rowData)
      {
    	  e.preventDefault();
    	  $('#id_menu').menu('show', {
    	  left: e.pageX,
    	  top: e.pageY
    	  });
    	  generateChangeXzMenu();
      }
     function picCountFormatter(value,row,index)
     {
         //In case the total row show "undefined"
         if(value==undefined)
         {
             return "";
         }
         
         var folderName="contacts_"+row.kehulbDm;

         //if has creating pic role,show this; else "".
          var picCreateUrl="";
          if($("#id_perms_contacts_create").val()=="true")
          {
        	  picCreateUrl="<a href='#' onclick='showPicCreatewindow(\""+row.kehuNo+"\",\""+folderName+"\")'>+</a>";
        
          }

          if(value==0)
         {
             return picCreateUrl;
         }
         var picShowUrl="<a href='#' onclick='showPicWindow(\""+row.kehuNo+"\")'>"+value+"</a>";
         return picCreateUrl+"&nbsp;&nbsp;&nbsp;"+picShowUrl;
     }
     function showPicWindow(kehuNo)
     {
    	 $('#win_detail').window('open');
		 $("#iframe_detail").attr("src","../picture/view.html?owner_id="+kehuNo);
     }
     function showPicCreatewindow(kehuNo,folderName)
     {
    	 $('#win_detail').window('open');
    	 //picture/upload.html?owner_id=jplhqp-380-&owner_name=kucun
		 $("#iframe_detail").attr("src","../picture/upload.html?owner_id="+kehuNo+"&owner_name="+folderName);
     }
	</script>
</body>
</html>