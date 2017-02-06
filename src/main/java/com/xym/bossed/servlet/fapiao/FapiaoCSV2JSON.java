package com.xym.bossed.servlet.fapiao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.servlet.fapiao.FapiaoSearch.Footer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FapiaoCSV2JSON extends HttpServlet {
	private File fileUploadPath;

	public void init(ServletConfig config) {
		fileUploadPath = new File(config.getServletContext().getInitParameter(
				"upload_path"));
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String str_startDate = request.getParameter("date_start");
		String str_endDate = request.getParameter("date_end");
		String str_fileName = request.getParameter("str_fileName");

		if (str_fileName == null || str_fileName.isEmpty()) {
			return;
		}

		JSONArray ja = this.csv2json(new File(fileUploadPath.getAbsolutePath() + fileUploadPath.separator + str_fileName));
		JSONArray ja_filtered = new JSONArray();
		if (str_startDate != null && str_endDate != null) {
			Date start = null, end = null;
			try {
				start = new SimpleDateFormat("yyyy-MM-dd").parse(str_startDate);
				end = new SimpleDateFormat("yyyy-MM-dd").parse(str_endDate);
			} catch (ParseException e) {

				e.printStackTrace();
			}

			for (int i = 0; i < ja.size(); i++) {
				JSONObject jsonObject = (JSONObject) ja.get(i);
				String str_kpDate = (String) jsonObject.get("kaipRq");
				Date date_kp = null;
				try {
					date_kp = new SimpleDateFormat("yyyy-MM-dd")
							.parse(str_kpDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// 比较日期
				if (date_kp.compareTo(start) == 1
						&& date_kp.compareTo(end) == -1) {
					// System.out.println(start.toLocaleString() + ">" +
					// date_kp.toLocaleString() + ">" + end.toLocaleString());
					ja_filtered.add(jsonObject);
				}

			}
			ja = ja_filtered;
		}

		JSONObject jo = new JSONObject();
		jo.put("total", ja.size());
		jo.put("rows", ja);

		JSONArray jfooter = new JSONArray();
		Footer footer = new Footer();
		footer.setKaipFpno("记录数：" + ja.size());
		jfooter.add(footer);

		jo.put("footer", jfooter);
		response.getWriter().println(jo.toString());
	}

	private JSONArray csv2json(File csvFile) throws IOException {
		// csvFile = new
		// File("C:\\Users\\xyg\\Desktop\\fpsj220106723176704.csv");
		@SuppressWarnings("resource")
		BufferedReader bufferedreader = new BufferedReader(new FileReader(
				csvFile));
		String str_line;
		JSONArray jsonArray = new JSONArray();

		ArrayList<String> list_key = new ArrayList<String>();// Store title for
														// josnarray use
		int lineNo = 0;
		while ((str_line = bufferedreader.readLine()) != null) {

			JSONObject jo = new JSONObject();
			String[] row = str_line.split(",");
			for (int i = 0; i < row.length; i++) {
				if (lineNo == 0) {
					row[i] = row[i].replace("\"", "");
					row[i] = row[i].replace("发票代码", "fapiao_daima");
					row[i] = row[i].replace("发票号码", "kaipFpno");
					row[i] = row[i].replace("开票日期", "kaipRq");
					row[i] = row[i].replace("发票状态", "kaipValidity");
					row[i] = row[i].replace("购方识别号", "kehuSh");
					row[i] = row[i].replace("购方名称", "kehuMc");
					row[i] = row[i].replace("金额合计", "kaipDfje");
					row[i] = row[i].replace("开票人", "kaipCzy");
					row[i] = row[i].replace("收款人", "shoukuanren");
					row[i] = row[i].replace("行业", "hangye");
					list_key.add(row[i]);// add title
				} else {
					row[i] = row[i].replace("\'", "");
					row[i] = row[i].replace("\"", "");
					jo.put(list_key.get(i), row[i]);
				}
			}
			if (lineNo > 0) {
				jsonArray.add(jo);
			}
			lineNo++;

		}
		return jsonArray;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
