package com.xym.bossed.db.mybatis.realm;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.shiro.Permission;
import com.xym.bossed.shiro.Role;
import com.xym.bossed.shiro.User;

public class RealmDAO implements RealmMapper {

	public User selectUserByName(String Name) {
		SqlSession session = com.xym.bossed.db.mybatis.SQLFactory.getFactory()
				.openSession();
		User user = null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			user = rm.selectUserByName(Name);
		} finally {
			session.close();
		}

		return user;
	}

	public List<User> selectAllUser() {
		SqlSession session = com.xym.bossed.db.mybatis.SQLFactory.getFactory()
				.openSession();
		List<User> userList = null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			userList = rm.selectAllUser();
		} finally {
			session.close();
		}
		return userList;
	}

	public List<Role> selectAllRole() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Role> roleList = null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			roleList = rm.selectAllRole();
		} finally {
			session.close();
		}
		return roleList;
	}

	public List<Permission> selectAllPermission() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Permission> permissionList = null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			permissionList = rm.selectAllPermission();
		} finally {
			session.close();
		}
		return permissionList;
	}

	public List<Permission> selectPermissionsForRole(int id) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Permission> permissionList = null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			permissionList = rm.selectPermissionsForRole(id);
		} finally {
			session.close();
		}
		return permissionList;
	}

	public int insertRole(Role role) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rv = rm.insertRole(role);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	public int updateRole(Role role) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rv = rm.updateRole(role);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	public int deleteRole(Role role) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt=0;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rt=rm.deleteRole(role);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}

	public Role selectRoleByName(Role role) {
		SqlSession session = SQLFactory.getFactory().openSession();
		Role rt=null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rt=rm.selectRoleByName(role);
		} finally {
			session.close();
		}
		return rt;
	}
	public List<User> selectUsersByRole(Role role) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<User> userList=null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			userList=rm.selectUsersByRole(role);
		} finally {
			session.close();
		}
		return userList;
	}
	public int insertPerm(Permission perm) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rv = rm.insertPerm(perm);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	public int updatePerm(Permission perm) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rv = rm.updatePerm(perm);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	public int deletePerm(Permission perm) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = 0;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rv = rm.deletePerm(perm);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}
	public Permission selectPermissionByName(Permission perm) {
		SqlSession session = SQLFactory.getFactory().openSession();
		Permission rv;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rv = rm.selectPermissionByName(perm);
		} finally {
			session.close();
		}
		return rv;
	}

	public List<Role> selectRolesByPermission(Permission perm) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Role> list;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			list = rm.selectRolesByPermission(perm);
		} finally {
			session.close();
		}
		return list;
	}
	public List<Role> selectRolesByUser(User user) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Role> list;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			list = rm.selectRolesByUser(user);
		} finally {
			session.close();
		}
		return list;
	}
	public int insertRelationBetweenUserAndRole(Map<String, Integer> map) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rt = rm.insertRelationBetweenUserAndRole(map);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}

	public int deleteRelationBetweenUserAndRole(Map<String, Integer> map) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rt = rm.deleteRelationBetweenUserAndRole(map);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}
	public int insertRelationBetweenRoleAndPermission(Map<String, Integer> map) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rt = rm.insertRelationBetweenRoleAndPermission(map);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}

	public int deleteRelationBetweenRoleAndPermission(Map<String, Integer> map) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rt;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			rt = rm.deleteRelationBetweenRoleAndPermission(map);
			session.commit();
		} finally {
			session.close();
		}
		return rt;
	}
	@Override
	public List<String> selectDistinctGroupNameForPermission() {
		SqlSession session = com.xym.bossed.db.mybatis.SQLFactory.getFactory()
				.openSession();
		List<String> list=null;
		try {
			RealmMapper rm = session.getMapper(RealmMapper.class);
			list = rm.selectDistinctGroupNameForPermission();
		} finally {
			session.close();
		}
		return list;
	}
	public static void main(String[] args) {
		RealmDAO dao = new RealmDAO();
		Role role=new Role();
		role.setId(1);
		
		List<String> lu=dao.selectDistinctGroupNameForPermission();
		for(int i=0;i<lu.size();i++)
		{
			System.out.println(lu.get(i));
		}
		
	}

	


}
