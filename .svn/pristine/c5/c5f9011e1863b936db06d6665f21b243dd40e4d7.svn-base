package com.xym.bossed.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		Date dt_kp = new SimpleDateFormat("yyyy-MM-dd").parse("2013-04-06");
		Date dt_start = new SimpleDateFormat("yyyy-MM-dd").parse("2013-03-01");
		Date dt_end = new SimpleDateFormat("yyyy-MM-dd").parse("2013-04-01");

		System.out.println(new TestDate().between(dt_kp,dt_start,dt_end));
	}

	public boolean between(Date dt,Date start, Date end) {
		
		if(dt.compareTo(start)==1 && dt.compareTo(end)==-1)
		{
			return true;
		}
		
		return false;
	}
}
