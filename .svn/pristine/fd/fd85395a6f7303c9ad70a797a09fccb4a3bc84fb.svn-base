package com.xym.bossed.servlet.price.sale;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.procedure.PriceBean;
import com.xym.bossed.service.PriceService;

public class SalePriceSearch extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4836568502141204579L;

	/**
	 * 
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");

		String priceCode = request.getParameter("priceCode");
		String peijNo = request.getParameter("peijNo");
		if (priceCode == null || priceCode.trim().isEmpty() || peijNo == null
				|| peijNo.trim().isEmpty()) {
			return;
		}
		int code = Integer.valueOf(priceCode);
		PriceService ps = new PriceService();
		// --11:该客户历史结算价
		if (code == 11) {
			String kehuNo = request.getParameter("kehuNo");
			if (kehuNo == null || kehuNo.trim().isEmpty()) {
				return;
			}
			PriceBean pb = ps.getLastTimePriceForSpecificKeHu(kehuNo, peijNo);
			response.getWriter().println(JSONObject.fromObject(pb).toString());
			return;
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
