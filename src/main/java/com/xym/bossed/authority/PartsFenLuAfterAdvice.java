package com.xym.bossed.authority;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.aop.AfterReturningAdvice;

import com.xym.bossed.db.mybatis.parts.fenlu.PartsFenLu;

public class PartsFenLuAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		//System.out.println("method name:"+method.getName());
		if(returnValue!=null)
		{
			List<PartsFenLu> list=(List<PartsFenLu>)returnValue;
			IAuthority ia=new AuthorityShiroImpl();
			boolean price=ia.isPermission(ia.QueryKuCunAveragePrice);
			boolean jine=ia.isPermission(ia.QueryKuCunAmount);
			boolean currentKC=ia.isPermission(ia.QueryKuCunCureentKuCun);
			boolean avliableKC=ia.isPermission(ia.QueryKuCunAvaliableKuCun);
			boolean min=ia.isPermission(ia.QeuryKuCunMin);
			boolean max=ia.isPermission(ia.QueryKuCunMax);
			boolean alarm=ia.isPermission(ia.QueryKuCunAlarm);
			
			for(int i=0;i<list.size();i++)
			{
				PartsFenLu fl =(PartsFenLu)list.get(i);
				
				if(!price)fl.setJiagJp(BigDecimal.valueOf(-1));
				if(!jine)fl.setPeijJe(BigDecimal.valueOf(-1));
				if(!currentKC)fl.setPeijKc(BigDecimal.valueOf(-1));
				if(!avliableKC)fl.setCanuseSl(BigDecimal.valueOf(-1));
				if(!min)fl.setKucXx(BigDecimal.valueOf(-1));
				if(!max)fl.setKucSx(BigDecimal.valueOf(-1));
				if(!alarm)fl.setJinhSl(BigDecimal.valueOf(-1));
			}
			//System.out.println(list.size());
		}
		
	}
}
