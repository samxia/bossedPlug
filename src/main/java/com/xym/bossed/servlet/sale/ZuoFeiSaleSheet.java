package com.xym.bossed.servlet.sale;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.xym.bossed.interfaces.ISaleService;
import com.xym.bossed.service.SaleService;

public class ZuoFeiSaleSheet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3660905701198637560L;
	static Logger log = Logger.getLogger(ZuoFeiSaleSheet.class); 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		String danHao=request.getParameter("danHao");
		if(danHao==null||danHao.trim().isEmpty())
		{
			return;
		}
		log.debug("zuofeidanhao:"+danHao);
		ISaleService iss=new SaleService();
		response.getWriter().println(iss.zuoFeiSaleSheet(danHao.trim()));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
