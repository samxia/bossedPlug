package com.xym.bossed.servlet.captcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.xym.bossed.util.CaptchaGeneration;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xym.bossed.shiro.ShiroSessionKey;

public class CaptchaCreate extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CaptchaGeneration cap = new CaptchaGeneration();
		BufferedImage bi = new BufferedImage(140, 30,
				BufferedImage.TYPE_INT_RGB);
		String captcha = cap.getCaptcha(bi);
		
		// put the captcha to session
		request.getSession().setAttribute(ShiroSessionKey.CAPTCHA,captcha);

		ImageIO.write(bi, "JPEG", response.getOutputStream());
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
