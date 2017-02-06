package com.xym.bossed.servlet.sale;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.sale.PartsItem;
import com.xym.bossed.service.KehuService;
import com.xym.bossed.service.SaleService;
import com.xym.bossed.service.YSHKService;
import com.xym.bossed.servlet.sale.SaleSheetOpenByDanHao.Footer;

public class SaleSheetOpenByDanHao extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3174712003267516932L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");

		String danHao = request.getParameter("danHao");
		if (danHao == null || danHao.trim().isEmpty()) {
			return;
		}

		String kehuNo = request.getParameter("kehuNo");

		// get temp parts item
		SaleService ss = new SaleService();
		List<PartsItem> list = ss.getTempPartsItemByDanHao(danHao);
		JSONObject jo = new JSONObject();
		jo.put("total", list.size());
		jo.put("rows", list);

		// footer
		List<Footer> footer_list = new ArrayList<Footer>();
		Footer footer = new Footer();
		footer.setBianMa("�ϼƣ�");
		footer.setMingCheng("��¼����" + list.size());
		footer.setShuLiang(0);
		footer.setBuHanShuiJinE(0);
		footer_list.add(footer);
		jo.put("footer", footer_list);

		// get sale sheet summary
		jo.put("summary", ss.getSaleSheetSummaryByDanHao(danHao));

		if (kehuNo != null && !kehuNo.trim().isEmpty()) {
			// get kehu info
			KehuService ks = new KehuService();
			jo.put("kehu", ks.getKehuByKehuNo(kehuNo));

			// get yingshouhuokan info
			YSHKService ys = new YSHKService();
			jo.put("yshk", ys.getYSHKByKehuNo(kehuNo));
		}
		response.getWriter().println(jo.toString());
	}

	public class Footer {
		private String bianMa, mingCheng;
		private int shuLiang, buHanShuiJinE;

		public String getBianMa() {
			return bianMa;
		}

		public void setBianMa(String bianMa) {
			this.bianMa = bianMa;
		}

		public String getMingCheng() {
			return mingCheng;
		}

		public void setMingCheng(String mingCheng) {
			this.mingCheng = mingCheng;
		}

		public int getShuLiang() {
			return shuLiang;
		}

		public void setShuLiang(int i) {
			this.shuLiang = i;
		}

		public int getBuHanShuiJinE() {
			return buHanShuiJinE;
		}

		public void setBuHanShuiJinE(int buHanShuiJinE) {
			this.buHanShuiJinE = buHanShuiJinE;
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
