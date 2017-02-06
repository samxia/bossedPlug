package com.xym.bossed.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;



import com.xym.bossed.interfaces.ISecurityService;

public class SecurityService implements ISecurityService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xym.bossed.security.ISecurityService#getCurrentUsername()
	 */
	@Override
	public String getCurrentUsername() {
		// comment to disable spring security
		/*
		 * Object principal = SecurityContextHolder.getContext()
		 * .getAuthentication().getPrincipal(); String username = null; if
		 * (principal instanceof UserDetails) { username = ((UserDetails)
		 * principal).getUsername(); } else { username = principal.toString(); }
		 * return username;
		 */
		Subject currentUser=SecurityUtils.getSubject();
		
		if(currentUser==null) return "anonymousUser";
		if(currentUser.getPrincipal()==null) return "anonymousUser";
		return currentUser.getPrincipal().toString();
	}

	public String getCurrentAuthorities() {
		Subject currentUser =
			    SecurityUtils.getSubject();
		return null;
	}
}
