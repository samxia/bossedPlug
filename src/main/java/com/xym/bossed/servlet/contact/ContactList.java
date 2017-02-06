package com.xym.bossed.servlet.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.service.KehuService;
import com.xym.bossed.servlet.fapiao.FapiaoSearch.Footer;

public class ContactList extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String mc = request.getParameter("mc");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");
		String kehuxz = request.getParameter("kehuxz");
		String category=request.getParameter("category");

		if (mc == null || mc.isEmpty()) {
			return;
		}

		KehuService ks = new KehuService();
		
		//set 客户性质
		Kehu kehu = new Kehu();
		if (kehuxz != null && !kehuxz.isEmpty()) {
			Short short_kehuxz = Short.valueOf(kehuxz);
			// if kehuxz eques 0, leave it null.
			if (short_kehuxz != 0) {
				kehu.setKehuXz(short_kehuxz);
			}

		}
		//set 类别代码
		if(category!=null && !category.trim().isEmpty())
		{
			kehu.setKehulbDm(category+"%");
		}
		
		List<Kehu> list = null;
		if (page == null || page.isEmpty() || rows == null || rows.isEmpty()) {
			list = ks.getKehuByKehuMcOrKehuDh(mc, kehu);
		} else {
			list = ks.getKehuByKehuMcOrKehuDhOnPagination(mc,
					Integer.valueOf(page), Integer.valueOf(rows));
		}

		JSONObject jo = new JSONObject();
		jo.put("total", list.size());
		jo.put("rows", list);

		// make footer
		List<Footer> lf = new ArrayList<com.xym.bossed.servlet.contact.ContactList.Footer>();
		Footer footer = new Footer();
		footer.setKehuBz("（记录数" + list.size() + ")");
		lf.add(footer);

		jo.put("footer", lf);

		response.getWriter().println(jo.toString());
	}

	public class Footer {
		private String kehuMc = "合计：";
		private String kehuBz;// 共？条记录

		public String getKehuMc() {
			return kehuMc;
		}

		public void setKehuMc(String kehuMc) {
			this.kehuMc = kehuMc;
		}

		public String getKehuBz() {
			return kehuBz;
		}

		public void setKehuBz(String kehuBz) {
			this.kehuBz = kehuBz;
		}

	}
}
