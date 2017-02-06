package com.xym.bossed.shiro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Login.class);

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String rememberMe = request.getParameter("rememberMe");

		log.debug("usreName:"+username);
		// System.out.println(rememberMe);
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(rememberMe != null ? true : false);
		Subject currentUser = SecurityUtils.getSubject();

		System.out.println("refer:"+request.getHeader("Referer"));
		
		try {
			currentUser.login(token);
		} catch (Exception exception) {
			//response.getWriter().println("Incorrect username or password.");
			response.sendRedirect("../login/?msg=Incorrect username or password.");//redirect to the login page
			return;
		}
		response.getWriter().println("login ok");
		// System.out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
