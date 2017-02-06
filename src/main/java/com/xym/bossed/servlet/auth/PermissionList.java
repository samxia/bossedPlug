package com.xym.bossed.servlet.auth;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.shiro.Permission;
import com.xym.bossed.shiro.Role;
import com.xym.bossed.shiro.User;
import com.xym.bossed.shiro.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class PermissionList
 */
public class PermissionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermissionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject jo = new JSONObject();

		String str_role_id = request.getParameter("getPermissionsByRoleId");
		if (str_role_id == null) {
			List<Permission> permissionList = new UserService()
					.getAllPermission();
			jo.put("total", permissionList.size());
			jo.put("rows", permissionList);

		} else {
			int role_id = Integer.parseInt(str_role_id);
			List<Permission> permissionList = new UserService()
			.getPermissionsByRoleId(role_id);
			Role role=new Role(role_id,"",permissionList);
			jo=JSONObject.fromObject(role);
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
