package com.xym.bossed.service;

import java.util.Date;
import java.util.List;

import com.xym.bossed.db.mybatis.log.Log;
import com.xym.bossed.db.mybatis.log.LogDAO;
import com.xym.bossed.db.mybatis.log.LogExample;
import com.xym.bossed.security.SecurityService;

public class LogService {

	public int createLog(Log log) {
		return new LogDAO().insertSelective(log);
	}

	public List<Log> getLogListByStartDate(Date date) {
		LogDAO dao = new LogDAO();
		LogExample e = new LogExample();
		e.or().andTimeGreaterThan(date);
		return dao.selectByExample(e);
	}

	public List<Log> getLogListByStartDateAndChannel(Date date, String channel) {
		LogDAO dao = new LogDAO();
		LogExample e = new LogExample();
		e.or().andTimeGreaterThan(date).andChannelEqualTo(channel);
		e.setOrderByClause("time");
		return dao.selectByExample(e);
	}

	/*
	 * channel:caller
	 * czy:86109618
	 * action:caller_in
	 * time:now
	 * content:
	 * result:
	 * */
	public int createCallerLog(String callerNumber,String content)
	{
		return 0;
	}
	public List<Log> getCallerLogListByStartDateAndEndDate(Date startDate,
			Date endDate, String... callerNumbers) {
		   LogDAO dao=new LogDAO();
		   LogExample e = new LogExample();
		   
		   e.or().andTimeBetween(startDate,endDate).andChannelEqualTo("caller");
		   e.setOrderByClause("time");
		   
		  return dao.selectByExample(e);

	}
}
