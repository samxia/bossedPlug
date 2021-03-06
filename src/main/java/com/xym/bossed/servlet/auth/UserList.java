package com.xym.bossed.servlet.auth;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.xym.bossed.shiro.Role;
import com.xym.bossed.shiro.User;
import com.xym.bossed.shiro.UserService;

/**
 * Servlet implementation class UserList
 */
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserList.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	//	log.debug("doGet() characterEncodeing:"+request.getCharacterEncoding());
		response.setContentType("text/html;charset=GB2312");
		response.setCharacterEncoding("GB2312");
		JSONObject jo = new JSONObject();

		if (request.getParameter("getRolesByName") != null) {
			String name = request.getParameter("getRolesByName");
		//	log.debug("doGet() userName:" + name);
			User user = new UserService().getUserByName(name);

			if(user!=null) {user.setPassword("*");}
			jo = JSONObject.fromObject(user);
			// jo.put("user", user);
		} else if (request.getParameter("getUsersByRoleId") != null) {
			String roleId = request.getParameter("getUsersByRoleId");
			Role role = new Role();
			role.setId(Integer.valueOf(roleId));
			List<User> userList = new UserService().getUsersByRole(role);
			jo.put("users", userList);
		} else {
			List<User> userList = new UserService().getAllUser();
			jo.put("total", userList.size());
			jo.put("rows", userList);
		}
		response.getWriter().println(jo.toString());
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
