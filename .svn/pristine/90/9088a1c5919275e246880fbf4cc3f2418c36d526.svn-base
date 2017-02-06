package com.xym.bossed.shiro;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.SessionKey;

public class ShiroSessionKey implements SessionKey{

	public static final String CAPTCHA="captchar";
	public static final String LOGIN_FAILED_COUNT="loginFailedCount";
	@Override
	public Serializable getSessionId() {
		// TODO Auto-generated method stub
		return SecurityUtils.getSubject().getSession().getId();
	}

}
