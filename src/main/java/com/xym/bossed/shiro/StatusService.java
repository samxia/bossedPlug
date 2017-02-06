package com.xym.bossed.shiro;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class StatusService {
	private static Logger log=Logger.getLogger(StatusService.class);
	
	public String getCurrentUserStatus(HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated())
		{
			return "No login yet.";
		}
		log.debug("getCurrentUserStatus() principal:"+currentUser.getPrincipal());
		return null;
	}
}
