package com.xym.bossed.authority;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;


public class AuthorityShiroImpl implements IAuthority {


	@Override
	public boolean isPermission(String perm) {
		Subject currentUser =
			    SecurityUtils.getSubject();
		return currentUser.isPermitted(perm);
	}


}
