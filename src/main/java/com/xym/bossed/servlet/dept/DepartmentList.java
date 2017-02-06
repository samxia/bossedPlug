package com.xym.bossed.servlet.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.xym.bossed.db.mybatis.dept.Department;
import com.xym.bossed.service.DepartmentService;

public class DepartmentList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 970129965491461026L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");

		List<Department> list = new DepartmentService().getAllDepartment();
		response.getWriter().println(JSONArray.fromObject(list).toString());

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
