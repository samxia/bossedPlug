package com.xym.bossed.servlet.price.sale;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.price.PriceRefer;
import com.xym.bossed.db.mybatis.procedure.PriceBean;
import com.xym.bossed.interfaces.IPriceService;
import com.xym.bossed.service.PriceService;
import com.xym.bossed.util.SpringUtil;

public class SalePriceRefer extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4836568502141204579L;
	private static Logger log= Logger.getLogger(SalePriceRefer.class);
	/**
	 * 
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		String kehuNo = request.getParameter("kehuNo");
		String partsNo = request.getParameter("partsNo");
		String cangkDm = request.getParameter("cangkDm");

		log.debug("kehuNo:"+kehuNo+"--partsNo:"+partsNo+"--cangkDm:"+cangkDm);
		
		if (kehuNo == null || kehuNo.trim().isEmpty() || partsNo == null
				|| partsNo.trim().isEmpty() || cangkDm == null
				|| cangkDm.trim().isEmpty()) {
			return;
		}
		//IPriceService ips = new PriceService();
		IPriceService ips=(IPriceService) SpringUtil.getBean("priceService");
		List<PriceRefer> list = ips.getPriceReferForSale(kehuNo, partsNo,
				cangkDm);
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
