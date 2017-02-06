package com.xym.bossed.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.apache.log4j.Logger;

public class DBRealm extends AuthorizingRealm {

	static Logger log = Logger.getLogger(DBRealm.class);

	@Override
	/**
	 * permission
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		String userName = (String) principals.fromRealm(this.getName())
				.iterator().next();
		User user = new UserService().getUserByName(userName);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRoles(user.getRoleNameList());
			for (Role role : user.getRoleList()) {
				info.addStringPermissions(role.getPermissionNameList());
			}
			return info;
		} else {
			return null;
		}
	}

	@Override
	/**
	 * login
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		log.debug("doGetAuthenticationInfo() userName:"+uToken.getUsername());
		User user = new UserService().getUserByName(uToken.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getUserName(),
					user.getPassword(), getName());
		}
		return null;
	}

	// for testing this
	public static void main(String[] args) {
		DBRealm realm = new DBRealm();
		UsernamePasswordToken upt = new UsernamePasswordToken();
		upt.setUsername("a");
		upt.setPassword("a".toCharArray());

		AuthenticationInfo info = realm.doGetAuthenticationInfo(upt);
		if (info != null) {
			PrincipalCollection pc = info.getPrincipals();

			System.out.println(pc.getPrimaryPrincipal());
		} else {
			System.out.println("return null");
		}

	}
}
