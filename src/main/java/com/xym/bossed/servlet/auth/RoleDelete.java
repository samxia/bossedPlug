package com.xym.bossed.servlet.auth;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.shiro.Permission;
import com.xym.bossed.shiro.Role;
import com.xym.bossed.shiro.User;
import com.xym.bossed.shiro.UserService;

/**
 * Servlet implementation class RoleDelete
 */
public class RoleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleDelete() {
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

		Role role = this.wireParam(request);
		JSONObject jo = new JSONObject();

		UserService us = new UserService();
		//check if exists related permissions
		List<Permission> permList=us.getPermissionsByRoleId(role.getId());
		if(permList.size()!=0)
		{
			String msg = "Before delete, release below relation - permission: [";
			for(Permission perm:permList)
			{
				msg=msg+" "+perm.getPermissionName();
			}
			jo.put("errorMsg", msg+"] relate to role:"+role.getRoleName());
			response.getWriter().println(jo.toString());
			return;
		}
		//check if exists related users
		List<User> userList = us.getUsersByRole(role);
		if (userList.size() != 0) {
			String msg = "Before delete, release below relation - user: [";
			for (User user : userList) {
				msg = msg + " " + user.getUserName();
			}
			jo.put("errorMsg", msg+"] belong to role:"+role.getRoleName());
			response.getWriter().println(jo.toString());
			return;
		}
		us.deleteRole(role);
		jo.put("result", "success");
		response.getWriter().println(jo.toString());
	}

	private Role wireParam(HttpServletRequest request) {
		/**
		 * handle the request parameter.
		 */
		Enumeration enu = request.getParameterNames();
		/**
		 * wired para into kehu object
		 */
		Role role = new Role();
		while (enu.hasMoreElements()) {
			String param = String.valueOf(enu.nextElement());
			String val = request.getParameter(param);

			if (val != null && !val.trim().isEmpty()) {
				/**
				 * String name = ˇ°yaronspaceˇ±; name =
				 * name.substring(0,1).toUpperCase() + name.substring(1);
				 */
				// System.out.println(param+":"+val);
				try {

					role.getClass()
							.getMethod(
									"set" + param.substring(0, 1).toUpperCase()
											+ param.substring(1),
									new Class[] { String.class })
							.invoke(role, request.getParameter(param));

				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println(kh.getKehuNo());
			}
		}
		return role;
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
