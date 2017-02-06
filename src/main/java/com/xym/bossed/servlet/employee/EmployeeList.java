package com.xym.bossed.servlet.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.service.EmployeeService;

import net.sf.json.JSONArray;

public class EmployeeList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5877229448684040775L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		String deptName=request.getParameter("deptName");
		if(deptName==null||deptName.trim().isEmpty())
		{
			return;
		}
		if(deptName.equalsIgnoreCase("all"))
		{
			response.getWriter().println(JSONArray.fromObject(new EmployeeService().getAllEmploee()));
			return;
		}
		//System.out.println(deptName);
		response.getWriter().println(JSONArray.fromObject(new EmployeeService().getEmployeesByDepartment(deptName)));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
