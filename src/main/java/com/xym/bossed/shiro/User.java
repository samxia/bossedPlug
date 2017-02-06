package com.xym.bossed.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5743859171321619662L;
	private int id;
	private String userName;
	private String password;
	private List<Role> roleList;

	public User() {

	}

	public User(String userName, String password, List<Role> roleList) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setRoleList(roleList);
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<String> getRoleNameList() {
		List<String> rnList = new ArrayList<String>();

		if(roleList==null) return null;
		for (int i = 0; i < roleList.size(); i++) {
			rnList.add(roleList.get(i).getRoleName());
		}
		return rnList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
