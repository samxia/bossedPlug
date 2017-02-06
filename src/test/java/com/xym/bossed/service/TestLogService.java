package com.xym.bossed.service;

import java.sql.Date;
import java.util.List;

import com.xym.bossed.db.mybatis.log.Log;

public class TestLogService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestLogService().testGetLogListByStartDateAndChannel();
	}

	public void testCreateLog() {
		LogService ls = new LogService();
		Log log = new Log("web_picture", "xym", "createFile", null,
				"something.jpg", "success");

		ls.createLog(log);
	}

	public void testGetLogListByStartDateAndChannel() {
		LogService ls = new LogService();
		List<Log> list=ls.getLogListByStartDateAndChannel(Date.valueOf("1997-01-01"), "web_picture");
		for(int i=0;i<list.size();i++)
		{
			Log log=list.get(i);
			System.out.println(log.getTime()+log.getAction());
			
		}
	}
}
