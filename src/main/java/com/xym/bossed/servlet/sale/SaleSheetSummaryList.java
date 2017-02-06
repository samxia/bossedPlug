package com.xym.bossed.servlet.sale;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.sale.SaleSheetSummary;
import com.xym.bossed.interfaces.ISaleService;
import com.xym.bossed.service.SaleService;
import com.xym.bossed.util.SpringUtil;

public class SaleSheetSummaryList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		ISaleService iss=(ISaleService)SpringUtil.getBean("saleService");
		List<SaleSheetSummary> list=iss.getAllSaleSheetSummary();
		//List<SaleSheetSummary> list = new SaleService().getAllSaleSheetSummary();
		JSONObject jo = new JSONObject();
		jo.put("total", list.size());
		jo.put("rows", list);

		response.getWriter().println(jo.toString());

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
