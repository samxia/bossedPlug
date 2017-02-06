<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系人详细信息</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/easyui/datagrid-bufferview.js"></script>
<script type="text/javascript" src="../js/util/jquery.json.2.4.js"></script>
<script type="text/javascript" src="../js/contact/update.js"></script>
</head>
<body onload="onLoad()">
	<div class="easyui-panel" title="供应商" style="width: 800px" data-options="iconCls:'icon-search',tools:'#tt'">
		<div style="padding: 1px 0 10px 60px">
			<form id="ff" method="post" action="update">
				<div class="easyui-panel" title="基本信息" style="width: 700px">
					<table>
						<tr>
							<td>编号:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuNo" readonly="readonly"></input></td>
							<td>类别:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehulbMc" readonly="readonly" id="id_show_kehulbMc"></input></td>
							<td>省市:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuSs" readonly="readonly"></input></td>
						</tr>
						<tr>
							<td>名称:</td>
							<td colspan="3"><input class="easyui-validatebox"
								type="text" name="kehuMc" data-options="required:true"
								style="width: 300px" readonly="readonly" ></input></td>
							<td>联系人:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuXm" readonly="readonly"></input></td>
						</tr>
					</table>
				</div>
				<div class="easyui-panel" title="通讯信息" style="width: 700px">
					<table>
						<tr>
							<td>邮编:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuYb" readonly="readonly"></input></td>
							<td>手机:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuSj" readonly="readonly"></input></td>
							<td>地址:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuDz" readonly="readonly"></input></td>
						</tr>
						<tr>
							<td>电话:</td>
							<td colspan="3"><input class="easyui-validatebox"
								type="text" name="kehuDh" style="width: 300px" readonly="readonly"></input></td>
							<td>传真:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuCz" readonly="readonly"></input></td>
						</tr>
						<tr>
							<td>网址:</td>
							<td colspan="3"><input class="easyui-validatebox"
								type="text" name="kehuHt" style="width: 300px" readonly="readonly"></input></td>
							<td>邮箱:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuEm" readonly="readonly"></input></td>
						</tr>
					</table>
				</div>
				<div class="easyui-panel" title="经营信息" style="width: 700px">
					<table>
						<tr>
							<td>全称:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuQc" style="width: 300px" readonly="readonly"></input> </td>
							<td>法人代表:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuFr" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>银行:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuYh" style="width: 300px" readonly="readonly"/></td>
							<td>开户帐号:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuZh" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>税号:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuSh" style="width: 300px" readonly="readonly"/></td>
							<td>开票地址:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuDx" readonly="readonly"/></td>
						</tr>
					</table>
				</div>
				<div class="easyui-panel" title="扩展属性" style="width: 700px">
					<table>
						<tr>
							<td>应付款余额:</td>
							<td><input class="easyui-validatebox" type="text" name="" readonly="readonly"/></td>
							<td>应收票余额:</td>
							<td><input class="easyui-validatebox" type="text" name="" readonly="readonly"/></td>
						</tr>
						<tr>
							<td>是否禁用:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuIsopen" readonly="readonly"/></td>
							<td>备注:</td>
							<td><input class="easyui-validatebox" type="text"
								name="kehuBz" style="width: 300px" readonly="readonly"/></td>
						</tr>
					</table>
				</div>
				<input name="kehulbMc" type="hidden" id="id_kehulbMc"/>
				<input name="kehulbDm" type="hidden" id="id_kehulbDm"/>
				<input name="kehuXz" type="hidden" id="id_kehuXz"/>
			</form>
		</div>
		<div style="text-align: center; padding: 5px" hidden="true" id="div_save">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">更新</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="onLoad()">重置</a>
		</div>
	</div>
	<div id="tt" >
		<shiro:hasPermission name="contacts:update">
			<a href="javascript:void(0)" class="icon-edit" onclick="javascript:edit()"></a>
		</shiro:hasPermission>
		<!-- <a href="javascript:void(0)" class="icon-help" onclick="javascript:alert('help')"></a> -->
	</div>

	<script type="text/javascript">
	 function showKehuWindow(kehuNo)
	 	{
			$('#win_detail').window('open');
			$("#iframe_detail").attr("src","detail_kehu.html?kehuNo="+kehuNo);
		}
	function onLoad()
	{
		loadRemote();
	}
	function loadRemote(){
		var kehuNo=GetQueryString("kehuNo");
		 $('#ff').form('load', 'detail?kehuNo='+kehuNo);
		 }
	function GetQueryString(name) {
		   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
		   var r = location.search.substr(1).match(reg);
		   if (r!=null) return (r[2]); return null;
		}
	</script>
</body>
</html>