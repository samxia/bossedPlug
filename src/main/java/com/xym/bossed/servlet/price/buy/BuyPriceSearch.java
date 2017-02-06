package com.xym.bossed.servlet.price.buy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyPriceSearch extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2217748406336127662L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		//[buy,sale]
		String priceType=request.getParameter("type");
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
