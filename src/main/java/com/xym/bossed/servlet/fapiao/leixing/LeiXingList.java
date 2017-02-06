package com.xym.bossed.servlet.fapiao.leixing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.xym.bossed.service.FaPiaoService;

public class LeiXingList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8893562179321988053L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		FaPiaoService fps=new FaPiaoService();
		
		response.getWriter().println(JSONArray.fromObject(fps.getAllLeiXing()).toString());
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
