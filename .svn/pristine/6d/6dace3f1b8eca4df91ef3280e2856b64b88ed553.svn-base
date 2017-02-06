package com.xym.bossed.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 我们在Spring的配置文件中注册一下： <bean id="springUtil"
 * class="org.coderecord.ccms.web.action.util.SpringUtil" />
 * 这样就可以了，Spring把我们需要的东西给我们了。
 * 
 * 我们就可以在需要的地方这样做：
 * 
 * 1 YouClass obj = (YouClass)SpringUtil.getObject("beanid");
 * 
 * 当然，前提是你需要让Spring自动装配哦。
 * 
 * @author xyg
 * 
 */
public class SpringUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringUtil.applicationContext = applicationContext;

	}

	public static Object getBean(String beanName) {
		Object o = null;
		o = applicationContext.getBean(beanName);
		return o;
	}

}
