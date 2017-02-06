package com.xym.bossed.shiro.ipSecurity;

import java.util.Date;

public class TryUserBean {
	private String userName;
	private String password;
	private Date tryTime;
    private String failReason;
    
    
	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public Date getTryTime() {
		return tryTime;
	}

	public void setTryTime(Date tryTime) {
		this.tryTime = tryTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
