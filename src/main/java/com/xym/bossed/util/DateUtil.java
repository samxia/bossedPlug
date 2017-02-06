package com.xym.bossed.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date long2Date(long val) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date(val)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	public static String getNow()
	{
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date d =new Date();
		 String dd =format.format(d); 
		 return dd;
	}
	public static void main(String[] args)
	{
		System.out.println(DateUtil.getNow());
	}
}
