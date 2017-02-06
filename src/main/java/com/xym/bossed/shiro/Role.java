package com.xym.bossed.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2754749989298156213L;
	/**
	 * 
	 */
	private int id;
	private String roleName;
	private List<Permission> permissionList;
	private String memo;

	public Role() {
	}

	public Role(int id, String roleName, List<Permission> perms) {
		this.setId(id);
		this.setRoleName(roleName);
		this.setPermissionList(perms);
	}

	public List<String> getPermissionNameList() {
		List<String> pnList = new ArrayList<String>();

		if (permissionList == null)
			return null;
		for (int i = 0; i < permissionList.size(); i++) {
			pnList.add(permissionList.get(i).getPermissionName());
		}
		return pnList;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId(String id) {
		this.id = Integer.valueOf(id);
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
