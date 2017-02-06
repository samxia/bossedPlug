package com.xym.bossed.servlet.picture;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.db.mybatis.log.Log;
import com.xym.bossed.security.SecurityService;
import com.xym.bossed.service.LogService;
import com.xym.bossed.service.PictureService;

public class PictureDelete extends HttpServlet {

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

		String path = request.getParameter("path");
		if (path == null || path.isEmpty()) {
			return;
		}
		PictureService ps = new PictureService();

		if (ps.getPicturesByPathInDB(path).size() == 0) {
			response.getWriter().println(
					"Fail:No such File [" + path + "] in DB.");
			return;
		}

		// del picture from server
		String str_real_path = request.getRealPath("/");
		File file = new File(str_real_path + path);

		if (!this.moveFile(file, str_real_path + "/picture/files/recycled/")) {
			response.getWriter().println(
					"Fail:Recycle File [" + path + "] failed.");
			return;
		}

		/*
		 * if (!file.delete()) { response.getWriter().println(
		 * "Fail:Delete File [" + path + "] failed."); return; }
		 */
		LogService logService = new LogService();
		/*
		 * logService.createLog(new Log("web_picture", new SecurityService()
		 * .getCurrentUsername(), "deleteFile", null, str_real_path + path,
		 * "success"));
		 */
		logService.createLog(new Log("web_picture", new SecurityService()
				.getCurrentUsername(), "deleteFile", null, str_real_path
				+ path, "success"));

		// del picture from database

		ps.deletePictureByPathInDB(path);
		response.getWriter().println(
				"Success:Recycle File [" + path + "] successed.");
	}

	private boolean moveFile(File srcFile, String destPath) {

		// Destination directory
		File dir = new File(destPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// Move file to new directory
		boolean success = srcFile.renameTo(new File(dir, srcFile.getName()
				.replace(
						".",
						new SimpleDateFormat("_yyyyMMdd_HHmmss.")
								.format(new Date()))));

		return success;
	}

}
