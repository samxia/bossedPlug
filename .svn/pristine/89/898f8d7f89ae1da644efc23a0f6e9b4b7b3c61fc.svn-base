package com.xym.bossed.servlet.auth;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.shiro.Permission;
import com.xym.bossed.shiro.UserService;

/**
 * Servlet implementation class PermUpdate
 */
public class PermUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	/*	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");*/

		Permission perm = this.wireParam(request);

		UserService us = new UserService();
		JSONObject jo = new JSONObject();

		Permission pms = us.getPermissionByName(perm);
		if (pms != null) {
			//if it is this permission,then skip.
			if (pms.getId() != perm.getId()) {
				jo.put("errorMsg",
						"Permission name [" + pms.getPermissionName()
								+ "] has existed.");
				response.getWriter().println(jo.toString());
				return;
			}
		}
		us.updatePermission(perm);
		jo.put("result", "success");
		response.getWriter().println(jo.toString());

	}

	private Permission wireParam(HttpServletRequest request) {
		/**
		 * handle the request parameter.
		 */
		Enumeration enu = request.getParameterNames();
		/**
		 * wired para into kehu object
		 */
		Permission perm = new Permission();
		while (enu.hasMoreElements()) {
			String param = String.valueOf(enu.nextElement());
			String val = request.getParameter(param);

			if (val != null && !val.trim().isEmpty()) {
				/**
				 * String name = ¡°yaronspace¡±; name =
				 * name.substring(0,1).toUpperCase() + name.substring(1);
				 */
				// System.out.println(param+":"+val);
				try {
					perm.getClass()
							.getMethod(
									"set" + param.substring(0, 1).toUpperCase()
											+ param.substring(1),
									new Class[] { String.class })
							.invoke(perm, request.getParameter(param));
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println(kh.getKehuNo());
			}
		}
		return perm;
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
