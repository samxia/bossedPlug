package com.xym.bossed.shiro.captcha;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import org.apache.shiro.web.util.WebUtils;

import com.xym.bossed.shiro.ipSecurity.IPStrategy;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {
	static Logger log = Logger.getLogger(CaptchaFormAuthenticationFilter.class);
	
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {

		return captchaParam;

	}

	protected String getCaptcha(ServletRequest request) {

		return WebUtils.getCleanParam(request, getCaptchaParam());

	}

	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {

		String username = getUsername(request);

		String password = getPassword(request);

		String captcha = getCaptcha(request);

		boolean rememberMe = isRememberMe(request);

		String host = getHost(request);

		return new CaptchaUsernamePasswordToken(username, password, rememberMe,
				host, captcha);

	}
/**
 * override 
 */
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		
		log.debug("onLoginFailure:"+e.getMessage());
		
		//login failed,add 1 to ipstrategy record.
		CaptchaUsernamePasswordToken uToken = (CaptchaUsernamePasswordToken) token;
		new IPStrategy().addFailureAttampt(uToken.getHost(), uToken.getUsername(), uToken.getPassword()==null?"":uToken.getPassword().toString(),e.getMessage());
		
		super.onLoginFailure(token, e, request, response);
		// login failed, let request continue back to the login page:
		return true;
	}

}
