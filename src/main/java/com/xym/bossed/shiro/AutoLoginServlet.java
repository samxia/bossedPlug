package com.xym.bossed.shiro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.xym.bossed.shiro.captcha.CaptchaUsernamePasswordToken;

public class AutoLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8456603496745055646L;

	private static Logger log = Logger.getLogger(AutoLoginServlet.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		 //System.out.println(request.getRemoteAddr());
		 /**
		  * only work for local net
		  */
		 String ip=request.getRemoteAddr();
		 if(!(ip.startsWith("127.")||ip.startsWith("192.")||ip.startsWith("10.")))
		 {
			 log.warn("Trying to access AutoLogin Servler IP:"+ip);
			 return;
		 }
		
		Subject subject = SecurityUtils.getSubject();
		
        
         
		if (!subject.isAuthenticated()
				&& request.getAttribute("username") == null) {
			User user = new UserService().getUserByName("ҵ��Ա1");
			String password = user.getPassword();
			//System.out.println(user.getUserName() + "---" + user.getPassword());
			CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
					user.getUserName(), password, true, "AUTO_LOGIN_HOST",
					"AUTO_LOGIN_CAPTCHA");
			subject.login(token);// ��¼
			response.sendRedirect(request.getContextPath());
			return;
		}
		else
		{
		    response.getWriter().println("�û���"+subject.getPrincipal().toString()+
		    		"���Ѿ���¼������<a href='logout'>ע��</a>����ʹ�ñ����ܡ�<a href='javascript:history.go(-1);'>����</a>");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/*
	 * 
	 * Subject subject = SecurityUtils.getSubject();
	 * 
	 * 
	 * if (!subject.isAuthenticated()&&request.getAttribute("username")==null) {
	 * User user = new UserService().getUserByName("ҵ��Ա1"); String password =
	 * user.getPassword();
	 * System.out.println(user.getUserName()+"---"+user.getPassword());
	 * CaptchaUsernamePasswordToken token = new
	 * CaptchaUsernamePasswordToken(user.getUserName(),
	 * password,true,"AUTO_LOGIN_HOST","AUTO_LOGIN_CAPTCHA");
	 * subject.login(token);//��¼
	 * request.getRequestDispatcher("/").forward(request, response); return; }
	 * //System.out.println(subject.isAuthenticated());
	 */

}