<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/demo/demo.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
	function utilGetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = location.search.substr(1).match(reg);
		if (r != null)
			return (r[2]);
		return null;
	}
	$(document).ready(function() {
		var msg = utilGetQueryString("msg");
		if (msg != null) {
			$('#msg').html("<font color='red'>" + decodeURI(msg) + "</font>");
		}
	});
	function reloadCaptcha(){
          var verify=document.getElementById('code');
          verify.setAttribute('src','<%=request.getContextPath()%>/captcha?it='
				+ Math.random());
	}
</script>
<%
	Object obj = request
			.getAttribute(org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	boolean flag = false;
	String msg = "";
	if (obj != null) {
		if ("org.apache.shiro.authc.UnknownAccountException"
				.equals(obj))
			//msg = "未知帐号错误！";
			  msg="用户或密码错误！";
		else if ("org.apache.shiro.authc.IncorrectCredentialsException"
				.equals(obj))
			//msg = "密码错误！";
			 msg="用户或密码错误！";
		else if ("com.wearereading.example.shiro.IncorrectCaptchaException"
				.equals(obj))
			msg = "验证码错误！";
		else if ("org.apache.shiro.authc.AuthenticationException"
				.equals(obj))
			msg = "认证失败！";
		else if ("com.xym.bossed.shiro.captcha.IncorrectCaptchaException"
				.equals(obj))
			msg = "验证码错误";
		else if ("com.xym.bossed.shiro.ipSecurity.IPStrategyException".equals(obj))
			msg = "违反ip策略,请不要再尝试，并联系管理员。";
		flag = !"".equals(msg);
	}
	if (flag) {
		out.print(msg);
		/*   Integer count = (Integer)request.getSession().getAttribute(SessionKey.LOGIN_FAILED_COUNT );
		 if( count ==null )
		  count = Integer.valueOf(0);
		  count++;
		  request.getSession().setAttribute(SessionKey.LOGIN_FAILED_COUNT, count ); */
	} else {

		// out.println(request.get);
		/*  Enumeration<String> attrs=request.getAttributeNames();
		 
		 while(attrs.hasMoreElements())
		 {
		   String attr=attrs.nextElement();
		   out.println(attr);
		 }
		 */
	}
%>
<body>
	<% 
			  String ip=request.getRemoteAddr();
			 if((ip.startsWith("192.")||ip.startsWith("10.")))
			 {
	%>
	<div id="msg"></div>
	<div class="easyui-panel" title="登录"
		style="width:500px; padding: 10px;" id="div_login" data-options="footer:'#ft'">
		<!-- <form action="../servlet/login" method="post"> -->
		<form action="<%=request.getContextPath()%>/login/login.jsp"
			method="post">
			<table>
				<tr>
					<td>Username:</td><td><input type="text" name="username" data-options="required:true" class="easyui-validatebox"/></td>
				</tr>
				<tr>
					<td>Password:</td><td> <input type="password" name="password" data-options="required:true" class="easyui-validatebox"/></td>
				</tr>
				<tr>
					<td>验证码:</td><td><input type="text" 	name="captcha" data-options="required:true" class="easyui-validatebox"/></td>
				</tr>
				  <tr>
			    	<td> <img src="<%=request.getContextPath()%>/captcha" id="code"
				onclick="reloadCaptcha()" style="cursor: pointer;" alt="看不清楚,换一张"></td>
				   <td><a href="javascript:reloadCaptcha()">看不清楚,换一张</a></td>
			      </tr>
			    <tr>
			    	<td> <input type="checkbox" name="rememberMe" value="true" />Remember Me? </td>
			    	<td><button type="submit">Login</button></td>
			    </tr>
			</table>
		</form>
		
	</div>
   <% 
				 }
			 else
			 {
				 %>
				 <div>内部系统，不对外提供服务。</div>
				 <%
			 }
				 
	%>
   	
    <div id="ft" style="padding:5px;">
            <%
            //  String ip=request.getRemoteAddr();
            if((ip.startsWith("192.")||ip.startsWith("10.")))
            {
            	out.print("<a href='../autologin' style='font-size:x-large;'>内网自动登录</a>");
            }
            %>
        	 
    </div>
</body>
</html>