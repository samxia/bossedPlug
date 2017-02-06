package com.xym.bossed.servlet.sale;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.interfaces.ISaleService;
import com.xym.bossed.service.SaleService;
import com.xym.bossed.util.DateUtil;

public class NewDanHao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2223196826570861896L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		ISaleService iss=new SaleService();
		String danhao=iss.createNewDanHao();
		
		JSONObject jo=new JSONObject();
		jo.put("danHao", danhao);
		jo.put("date",DateUtil.getNow());
		
		response.getWriter().println(jo.toString());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
