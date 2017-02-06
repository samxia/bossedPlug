package com.xym.bossed.servlet.picture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.apache.log4j.Logger;

import com.xym.bossed.db.mybatis.picture.Picture;
import com.xym.bossed.service.PictureService;

public class PictureList extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 487929629362659631L;
	Logger log = Logger.getLogger(PictureList.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String ownerId = request.getParameter("owner_id");
		if (ownerId == null || ownerId.isEmpty()) {
			log.warn("Parameter 'owner_id'  is empty.");
			return;
		}

		PictureService ps = new PictureService();
		List<Picture> list = ps.getPicturesByOwnerIdInDB(ownerId);
		// {"image":"../js/pikachoose-4.5.0/3.jpg","caption":"You can use any type of html you want with PikaChoose","title":"Image 3"}
		JSONArray ja = new JSONArray();

		List<PikachooseData> list_pd = new ArrayList<PikachooseData>();
		for (int i = 0; i < list.size(); i++) {

			PikachooseData pd = new PikachooseData();
			Picture pic = list.get(i);
			pd.setCaption(pic.getMemo());
			pd.setImage(".." + pic.getPath());
			pd.setTitle(pic.getPath());
			pd.setLink(".." + pic.getPath());

			list_pd.add(pd);
		}
		ja = ja.fromObject(list_pd);
		response.getWriter().println(ja);
	}

	public class PikachooseData {
		private String image;
		private String caption;
		private String title;
		private String link;

		
		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getCaption() {
			return caption;
		}

		public void setCaption(String caption) {
			this.caption = caption;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}
}
