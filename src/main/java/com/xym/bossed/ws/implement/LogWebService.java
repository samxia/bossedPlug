package com.xym.bossed.ws.implement;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.xym.bossed.db.mybatis.log.Log;
import com.xym.bossed.service.LogService;
import com.xym.bossed.ws.interfaces.ILogWebService;

@WebService(endpointInterface = "com.xym.bossed.ws.interfaces.ILogWebService", serviceName = "LogService")
public class LogWebService implements ILogWebService {

	@Override
	public List<Log> getLogListByStartDate(Date date) {
		LogService ls = new LogService();
		return ls.getLogListByStartDate(date);
	}

	public List<Log> getLogListByStartDateAndChannel(Date date, String channel) {
		LogService ls = new LogService();
		return ls.getLogListByStartDateAndChannel(date, channel);
	}

	@Override
	public List<Log> getCallerLogListByStartDateAndEndDate(Date startDate,
			Date endDate, String... callerNumbers) {
		LogService ls = new LogService();
		
		return ls.getCallerLogListByStartDateAndEndDate(startDate, endDate, callerNumbers);
	}
}
