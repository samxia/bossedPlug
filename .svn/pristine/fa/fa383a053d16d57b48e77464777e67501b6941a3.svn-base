package com.xym.bossed.shiro.ipSecurity;

import java.util.Date;
import java.util.List;

public class HostBean {
	private String ip;
	private List<TryUserBean> userList;
	private Date firstFailureTime;
	private int failureTimesCount;
	private boolean permanentForbidden;


	public boolean isPermanentForbidden() {
		return permanentForbidden;
	}

	public void setPermanentForbidden(boolean permanentForbidden) {
		this.permanentForbidden = permanentForbidden;
	}

	public List<TryUserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<TryUserBean> userList) {
		this.userList = userList;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getFirstFailureTime() {
		return firstFailureTime;
	}

	public void setFirstFailureTime(Date firstFailureTime) {
		this.firstFailureTime = firstFailureTime;
	}

	public int getFailureTimesCount() {
		return failureTimesCount;
	}

	public void setFailureTimesCount(int failureTimesCount) {
		this.failureTimesCount = failureTimesCount;
	}



}
