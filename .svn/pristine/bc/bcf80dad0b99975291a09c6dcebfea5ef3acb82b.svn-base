package com.xym.bossed.shiro.ipSecurity;

public interface IPStrategyInterface {

	public abstract void addFailureAttampt(String ip, String userName,
			String password, String failReason);

	public abstract boolean checkLoginIP(String ip);

	public abstract String printIPStrategyTable();

	public abstract void unlockIP(String ip);

	public abstract void unlockAll();

	public abstract void permanetForbiddenIP(String ip);

}