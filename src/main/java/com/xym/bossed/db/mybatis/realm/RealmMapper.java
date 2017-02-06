package com.xym.bossed.db.mybatis.realm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xym.bossed.shiro.Permission;
import com.xym.bossed.shiro.Role;
import com.xym.bossed.shiro.User;

public interface RealmMapper {
	User selectUserByName(String Name);

	List<User> selectAllUser();

	List<Role> selectAllRole();

	List<Permission> selectAllPermission();

	List<String> selectDistinctGroupNameForPermission();

	List<Permission> selectPermissionsForRole(int id);

	int insertRole(Role role);

	int updateRole(Role role);

	int deleteRole(Role role);

	Role selectRoleByName(Role role);

	List<User> selectUsersByRole(Role role);

	int insertPerm(Permission perm);

	int updatePerm(Permission perm);

	int deletePerm(Permission perm);

	Permission selectPermissionByName(Permission perm);

	List<Role> selectRolesByPermission(Permission perm);

	List<Role> selectRolesByUser(User user);

	int insertRelationBetweenUserAndRole(Map<String, Integer> map);

	int deleteRelationBetweenUserAndRole(Map<String, Integer> map);

	int insertRelationBetweenRoleAndPermission(Map<String, Integer> map);

	int deleteRelationBetweenRoleAndPermission(Map<String, Integer> map);
}
