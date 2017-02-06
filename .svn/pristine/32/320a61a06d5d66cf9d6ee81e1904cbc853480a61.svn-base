package com.xym.bossed.servlet.contact.category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.xym.bossed.web.jeasyui.TreeData;

public class CategoryTree extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		if (id == null || id.trim().isEmpty()) {
			TreeData td_bossed = new TreeData("bossed", "博士德");

			TreeData td_kehu = new TreeData("kehu", "客户");
			td_kehu.setState("closed");

			TreeData td_gys = new TreeData("gys", "供应商");
			td_gys.setState("closed");

			TreeData td_unbossed = new TreeData("unbossed", "非博士德");
			td_unbossed.setState("closed");

			List<TreeData> list_bossed_child = new ArrayList<TreeData>();
			list_bossed_child.add(td_kehu);
			list_bossed_child.add(td_gys);

			td_bossed.setChildren(list_bossed_child);

			JSONArray ja = new JSONArray();
			ja.add(td_unbossed);
			ja.add(td_bossed);
			

			response.getWriter().println(ja.toString());
			return;
		}
		if (id.equals("kehu")) {
			response.sendRedirect("../kehu/category/search");
			return;
		}
		if (id.equals("gys")) {
			response.sendRedirect("../gys/category/search");
			return;
		}
		if (id.equals("unbossed")) {
			response.sendRedirect("list");
			return;
		}

	}
}
