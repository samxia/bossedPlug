package com.xym.bossed.servlet.fapiao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.fapiao.FaPiao;
import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.interfaces.IFapiaoService;
import com.xym.bossed.service.FaPiaoService;
import com.xym.bossed.service.KehuService;
import com.xym.bossed.servlet.fapiao.FapiaoCSV2JSON.Footer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FapiaoSaveList extends HttpServlet {

	private static final long serialVersionUID = -5073091845137448221L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String str_fp_list = request.getParameter("fapiao_list");

		if (str_fp_list == null || str_fp_list.isEmpty()) {
			return;
		}
		// System.out.println(str_fp_list);
		JSONArray ja = new JSONArray().fromObject(str_fp_list);// 将参数值字符串json转为java
																// json对象
		List<FaPiao> lp = this.json2Java(ja);

		JSONArray ja_return = new JSONArray();
		IFapiaoService fps = new FaPiaoService();
		for (int i = 0; i < lp.size(); i++) {
			StringBuffer sb = new StringBuffer();
			FaPiao fp = lp.get(i);

			/*
			 * sb.append(fp.getKaipRq()).append("-").append(fp.getKaipFpno())
			 * .append("-").append(fp.getKehuNo()).append("-")
			 * .append(fp.getKaipZy()).append("-")
			 * .append(fp.getKehu().getKehuMc()).append("-")
			 * .append(fp.getKaipValidity()); System.out.println(sb.toString());
			 */
			CSVFapiao cfp = this.copyAttr(fp);// for returning json to fill csv
												// datagrid

			// cfp.setSave_Return_Value(3);
			cfp.setSave_Return_Value(fps.saveFapiao(fp, "xym_web"));
			ja_return.add(cfp);
		}
		/**
		 * return json
		 */
		JSONObject jo_return = new JSONObject();
		jo_return.put("total", ja_return.size());
		jo_return.put("rows", ja_return);

		JSONArray jfooter = new JSONArray();
		Footer footer = new Footer();
		footer.setKaipFpno("记录数：" + ja_return.size());
		jfooter.add(footer);

		jo_return.put("footer", jfooter);
		response.getWriter().println(jo_return.toString());
	}

	/**
	 * 
	 * @author xyg For returning csv fapiao json to fill the datagrid,extends
	 *         FaPiao class and create this csvFapiao class.
	 */
	private CSVFapiao copyAttr(FaPiao fp) {
		CSVFapiao cf = new CSVFapiao();
		cf.setKaipFpno(fp.getKaipFpno());
		cf.setKaipRq(fp.getKaipRq());
		cf.setKaipValidity(fp.getKaipValidity());
		cf.setKaipDfje(fp.getKaipDfje());
		cf.setKaipCzy(fp.getKaipCzy());

		cf.setKehuSh(fp.getKehu().getKehuSh());
		cf.setKehuMc(fp.getKehu().getKehuMc());
		return cf;
	}

	public class CSVFapiao extends FaPiao {
		private String fapiao_daima;
		private String kehuSh;
		private String kehuMc;
		private String shoukuanren;

		public String getShoukuanren() {
			return shoukuanren;
		}

		public void setShoukuanren(String shoukuanren) {
			this.shoukuanren = shoukuanren;
		}

		public String getFapiao_daima() {
			return fapiao_daima;
		}

		public void setFapiao_daima(String fapiao_daima) {
			this.fapiao_daima = fapiao_daima;
		}

		public String getKehuSh() {
			return kehuSh;
		}

		public void setKehuSh(String kehuSh) {
			this.kehuSh = kehuSh;
		}

		public String getKehuMc() {
			return kehuMc;
		}

		public void setKehuMc(String kehuMc) {
			this.kehuMc = kehuMc;
		}

	}

	private List<FaPiao> json2Java(JSONArray ja) {
		ArrayList<FaPiao> list = new ArrayList<FaPiao>();

		for (int i = 0; i < ja.size(); i++) {
			Object obj = ja.get(i);
			JSONObject jo = new JSONObject().fromObject(obj);
			FaPiao fp = new FaPiao();

			/**
			 * [{"fapiao_daima":"122011270303","kaipFpno":"02330341","kaipRq":
			 * "2013-03-29"
			 * ,"kaipValidity":"正常","kehuSh":"220181050548859","kehuMc"
			 * :"吉林建兴物流有限公司"
			 * ,"kaipDfje":"3000.00","kaipCzy":"夏悦铭","shoukuanren":""
			 * ,"hangye":"商业"
			 * },{"fapiao_daima":"122011270303","kaipFpno":"02330342"
			 * ,"kaipRq":"2013-03-29"
			 * ,"kaipValidity":"正常","kehuSh":"220181050548859"
			 * ,"kehuMc":"吉林建兴物流有限公司"
			 * ,"kaipDfje":"696.00","kaipCzy":"夏悦铭","shoukuanren"
			 * :"","hangye":"商业"}]
			 */
			fp.setKaipFpno(jo.getString("kaipFpno"));
			try {
				fp.setKaipRq(new SimpleDateFormat("yyyy-MM-dd").parse(jo
						.getString("kaipRq")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			fp.setKaipValidity(jo.getString("kaipValidity").equals("正常") ? true
					: false);

			Kehu kehu = new Kehu();
			kehu.setKehuSh(jo.getString("kehuSh"));
			kehu.setKehuMc(jo.getString("kehuMc"));
			fp.setKehu(kehu);

			/**
			 * 根据客户税号查找客户编号，
			 * 
			 */
			String kehuNo = new KehuService().getKehuNoByKehuSh(jo
					.getString("kehuSh"));

			/**
			 * 如无税号对应的客户编号，则按个人客户录入,并在摘要中显示客户名称。
			 */
			if (kehuNo == null) {
				fp.setKehuNo("KGRKH");
				fp.setKaipZy(jo.getString("kehuMc"));
			} else {
				fp.setKehuNo(kehuNo);
			}

			fp.setKaipDfje(BigDecimal.valueOf(jo.getLong("kaipDfje")));
			fp.setKaipCzy(jo.getString("kaipCzy"));

			/* if 发票状态为作废，set 金额为1 and append the orial amount to zhaiyao*/
			if (!fp.getKaipValidity()) {
				fp.setKaipZy(fp.getKaipZy()+"-作废金额："+fp.getKaipDfje());//将金额加入摘要
				fp.setKaipDfje(BigDecimal.valueOf(1));//将开票金额设为1
			}
			list.add(fp);
		}
		return list;
	}

	public class Footer {
		private String fapiao_daima = "合计";
		private String kaipFpno;// 记录数
		private String kaipDfje;// 金额共计

		public String getFapiao_daima() {
			return fapiao_daima;
		}

		public void setFapiao_daima(String fapiao_daima) {
			this.fapiao_daima = fapiao_daima;
		}

		public String getKaipFpno() {
			return kaipFpno;
		}

		public void setKaipFpno(String kaipFpno) {
			this.kaipFpno = kaipFpno;
		}

		public String getKaipDfje() {
			return kaipDfje;
		}

		public void setKaipDfje(String kaipDfje) {
			this.kaipDfje = kaipDfje;
		}

	}
}
