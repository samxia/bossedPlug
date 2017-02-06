package com.xym.bossed.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xym.bossed.db.mybatis.realm.RealmDAO;

public class UserService {
	public User getUserByName(String userName) {
		return new RealmDAO().selectUserByName(userName);
	}

	public List<User> getAllUser() {
		return new RealmDAO().selectAllUser();
	}

	public List<Role> getAllRole() {
		return new RealmDAO().selectAllRole();
	}

	public List<Permission> getAllPermission() {
		return new RealmDAO().selectAllPermission();
	}

	public List<Permission> getPermissionsByRoleId(int id) {
		return new RealmDAO().selectPermissionsForRole(id);
	}

	public int insertRole(Role role) {
		return new RealmDAO().insertRole(role);
	}

	public int deleteRole(Role role) {
		return new RealmDAO().deleteRole(role);
	}

	public Role getRoleByName(Role role) {
		return new RealmDAO().selectRoleByName(role);
	}

	public List<User> getUsersByRole(Role role) {
		return new RealmDAO().selectUsersByRole(role);
	}

	public int updateRole(Role role) {
		return new RealmDAO().updateRole(role);
	}

	public int insertPermission(Permission perm) {
		return new RealmDAO().insertPerm(perm);
	}

	public int updatePermission(Permission perm) {
		return new RealmDAO().updatePerm(perm);
	}

	public int deletePermission(Permission perm) {
		return new RealmDAO().deletePerm(perm);
	}

	public Permission getPermissionByName(Permission perm) {
		return new RealmDAO().selectPermissionByName(perm);
	}

	public List<Role> getRolesByPermission(Permission perm) {
		return new RealmDAO().selectRolesByPermission(perm);
	}

	public List<Role> getRolesByUser(User user) {
		return new RealmDAO().selectRolesByUser(user);
	}

	public int insertRolesOfUser(User user, Role role) {
		Map map = new HashMap();
		map.put("user_id", user.getId());
		map.put("role_id", role.getId());
		return new RealmDAO().insertRelationBetweenUserAndRole(map);
	}

	public int deleteRolesOfUser(User user, Role role) {
		Map map = new HashMap();
		map.put("user_id", user.getId());
		map.put("role_id", role.getId());
		return new RealmDAO().deleteRelationBetweenUserAndRole(map);
	}

	public int insertPermissionsOfRole(Role role, Permission perm) {
		Map map = new HashMap();
		map.put("role_id", role.getId());
		map.put("permission_id", perm.getId());
		return new RealmDAO().insertRelationBetweenRoleAndPermission(map);
	}

	public int deletePermissionsOfRole(Role role, Permission perm) {
		Map map = new HashMap();
		map.put("role_id", role.getId());
		map.put("permission_id", perm.getId());
		return new RealmDAO().deleteRelationBetweenRoleAndPermission(map);
	}
}
