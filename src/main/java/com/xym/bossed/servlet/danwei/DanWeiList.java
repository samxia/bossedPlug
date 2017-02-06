package com.xym.bossed.servlet.danwei;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.xym.bossed.service.DanWeiService;

public class DanWeiList extends HttpServlet {
	private static final long serialVersionUID = 1064488512883023923L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");

		DanWeiService dws = new DanWeiService();
		response.getWriter().println(JSONArray.fromObject(dws.getAllDanWei()).toString());

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
