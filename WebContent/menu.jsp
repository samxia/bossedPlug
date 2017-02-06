<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" type="text/css"
	href="js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/util/jquery.json.2.4.js"></script>
</head>
<body onload="onLoad()" >
	<div id="unlogin" >
		<a href="#" class="easyui-linkbutton"  onclick="parent.login()">login</a>
	</div>
	<div id="logined">
		<div id="welcome" >
			<a href="#" class="easyui-linkbutton"  data-options="plain:true" onclick="parent.logout()">注销 操作员:<label id="name"></label></a>
			<shiro:hasRole name="boss">  
				<a id="a_fapiao" href="#" class="easyui-linkbutton"  data-options="plain:true" onclick="changeFrameSrc('发票管理','fapiao')">发票管理</a>
			</shiro:hasRole>
			
			<a id="a_contacts" href="#" class="easyui-linkbutton"   data-options="plain:true" onclick="changeFrameSrc('联系人','contacts')">联系人</a>
			
			<shiro:hasRole name="boss">  
				<a id="a_auth" href="auth/" class="easyui-linkbutton"   data-options="plain:true" target="_blank">权限设置</a>
			</shiro:hasRole>
		</div>
		
	</div>
	<script type="text/javascript">
      function onLoad()
      {
    	  $.ajax({
    		  url:"s/status",
    		  success: processLoginStatus,
    		  dataType: "json"
    		});
      }
      function processLoginStatus(data)
      {
          var name=data.userName;
          if(name=="anonymousUser")//un-login
          {
             
              $("#logined").hide();
          }
          else//have logined
           {
        	  $("#unlogin").hide();
        	  $("#name").html(name);
        	  setAuthority(data.authorities);
            }
         // alert(data.userName);
      }
      function changeFrameSrc(title,url)
      {
    	  
      	//$("#iframe_main",parent.document.body).attr("src",url);
    	  parent.addPanel(title,url);
    	  parent.window.scroll(0,0);
      }
      function setAuthority(au)
      {
    	  $("#authority",parent.document.body).html(au);//this element on the parent page
      }
	</script>
</body>
</html>