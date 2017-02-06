package com.xym.bossed.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class CaptchaGeneration {
	public String getCaptcha(BufferedImage  bi) {
		int width = bi.getWidth();
		int height = bi.getHeight();
		if (width <= 0)
			width = 60;
		if (height <= 0)
			height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 设定背景色
		// g.setColor(new Color(0xDCDCDC));
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 画边框
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, width - 1, height - 1);
		// 取随机产生的认证码
		String strEnsure = "";
		// 4代表4位验证码,如果要生成更多位的认证码,则加大数值
		for (int i = 0; i < 4; ++i) {
			strEnsure += mapTable[(int) (mapTable.length * Math.random())];
		}

		// put the captcha to session
		// request.getSession().setAttribute(ShiroSessionKey.CAPTCHA,
		// strEnsure);
		// 　　将认证码显示到图像中,如果要生成更多位的认证码,增加drawString语句
		// g.setColor(mapColor[(int) (mapColor.length * Math.random())]);
		g.setColor(Color.BLUE);
		g.setFont(new Font(mapFont[(int) (mapFont.length * Math.random())],
				Font.PLAIN, 22));
		Random rand = new Random();
		int str_x_1 = rand.nextInt(width / 2);
		int str_x_2 = str_x_1 + 9 + rand.nextInt(3);
		int str_x_3 = str_x_2 + 9 + rand.nextInt(3);
		int str_x_4 = str_x_3 + 9 + rand.nextInt(3);
		// first
		String str = strEnsure.substring(0, 1);
		g.drawString(str, str_x_1, 16 + rand.nextInt(3));
		// second
		str = strEnsure.substring(1, 2);
		g.setFont(new Font(mapFont[(int) (mapFont.length * Math.random())],
				Font.PLAIN, 22));
		g.drawString(str, str_x_2, 16 + rand.nextInt(6));

		// 3rd
		str = strEnsure.substring(2, 3);
		g.setFont(new Font(mapFont[(int) (mapFont.length * Math.random())],
				Font.PLAIN, 22));
		g.drawString(str, str_x_3, 17 + rand.nextInt(4));
		// 4th
		str = strEnsure.substring(3, 4);
		// g.setColor(mapColor[(int) (mapColor.length * Math.random())]);
		g.setFont(new Font(mapFont[(int) (mapFont.length * Math.random())],
				Font.PLAIN, 22));
		g.drawString(str, str_x_4, 16 + rand.nextInt(4));

		// draw a line
		int x1 = rand.nextInt(width) / 2;
		int x2 = rand.nextInt(width);
		int y1 = rand.nextInt(height) / 2;
		int y2 = rand.nextInt(height);
		// g.setColor(mapColor[(int) (mapColor.length * Math.random())]);
		g.drawLine(x1, y1, x2, y2);
		/*
		 * //g.setColor(mapColor[(int) (mapColor.length * Math.random())]);
		 * //g.drawOval(rand.nextInt(width) / 2, rand.nextInt(height) / 2,
		 * rand.nextInt(width), rand.nextInt(height));
		 */
		// g.drawRect(rand.nextInt(width) / 2, rand.nextInt(height) / 2,
		// rand.nextInt(width), rand.nextInt(height));
		// 随机产生10个干扰点
		/*
		 * for (int i = 0; i < 30; i++) { int x = rand.nextInt(width); int y =
		 * rand.nextInt(height); g.setColor(mapColor[(int) (mapColor.length *
		 * Math.random())]); g.drawOval(x, y, 1, 1); }
		 */
		// 释放图形上下文
		g.dispose();

		image = twistImage(image);
		bi.setData(image.getData());
	/*	try {
			// 输出图像到页面
			ImageIO.write(image, "JPEG", output);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return strEnsure;
	}

	private String mapFont[] = { Font.MONOSPACED, Font.SANS_SERIF, Font.SERIF,
			"Atlantic Inline" };
	private char mapTable[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'h', 'i', 'j',
			'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', '2', '3', '4', '5', '6', '7', '8', 'A', 'B', 'C', 'D', 'E',
			'F', 'H', 'J', 'K', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };
	private Color mapColor[] = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.RED };

	/**
	 * 
	 * @Description:正弦曲线Wave扭曲图片
	 * @since 1.0.0
	 * @Date:2012-3-1 下午12:49:47
	 * @return BufferedImage
	 */
	private BufferedImage twistImage(BufferedImage buffImg) {
		Random random = new Random();
		double dMultValue = random.nextInt(7) + 3;// 波形的幅度倍数，越大扭曲的程序越高，一般为3
		double dPhase = random.nextInt(6);// 波形的起始相位，取值区间（0-2＊PI）

		BufferedImage destBi = new BufferedImage(buffImg.getWidth(),
				buffImg.getHeight(), BufferedImage.TYPE_INT_RGB);

		Graphics g = destBi.getGraphics();
		// 设定背景色
		// g.setColor(new Color(0xDCDCDC));
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, buffImg.getWidth(), buffImg.getHeight());
		g.dispose();

		for (int i = 0; i < destBi.getWidth(); i++) {
			for (int j = 0; j < destBi.getHeight(); j++) {
				int nOldX = getXPosition4Twist(dPhase, dMultValue,
						destBi.getHeight(), i, j);
				int nOldY = j;
				if (nOldX >= 0 && nOldX < destBi.getWidth() && nOldY >= 0
						&& nOldY < destBi.getHeight()) {
					destBi.setRGB(nOldX, nOldY, buffImg.getRGB(i, j));
				}
			}
		}
		return destBi;
	}

	/**
	 * 
	 * @Description:获取扭曲后的x轴位置
	 * @since 1.0.0
	 * @Date:2012-3-1 下午3:17:53
	 * @param dPhase
	 * @param dMultValue
	 * @param height
	 * @param xPosition
	 * @param yPosition
	 * @return int
	 */
	private int getXPosition4Twist(double dPhase, double dMultValue,
			int height, int xPosition, int yPosition) {
		double PI = 3.1415926535897932384626433832799; // 此值越大，扭曲程度越大
		double dx = (double) (PI * yPosition) / height + dPhase;
		double dy = Math.sin(dx);
		return xPosition + (int) (dy * dMultValue);
	}

}
