package com.xym.bossed.shiro.ipSecurity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author xyg If login attampted times is over 5 times for one ip adrress, then
 *         forbidden the ip address login within half hour.
 * 
 */
public class IPStrategy implements IPStrategyInterface{
	private static final int MAX_FAILURE_TIMES=8;
	private static Map<String, HostBean> ipMap = new HashMap<String, HostBean>();

	// add failure attampt login to static map
	/* (non-Javadoc)
	 * @see com.xym.bossed.shiro.ipSecurity.IPStrategyInterface#addFailureAttampt(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public  void addFailureAttampt(String ip, String userName,
			String password, String failReason) {
		HostBean hb = null;
		if (!ipMap.containsKey(ip)) {
			hb = new HostBean();
			hb.setIp(ip);
			hb.setFailureTimesCount(1);
			hb.setFirstFailureTime(getNow());
			hb.setPermanentForbidden(false);
		} else {
			hb = (HostBean) ipMap.get(ip);
			//in case record the attampt more,after reaching the peak.
			if(hb.getFailureTimesCount()>MAX_FAILURE_TIMES+3)
			{
				return;
			}
			hb.setFailureTimesCount(hb.getFailureTimesCount() + 1);
		}
		addHostBean2IPMap(userName, password, failReason, hb);
		ipMap.put(ip, hb);
	}

	// check if this ip allow login
	/* (non-Javadoc)
	 * @see com.xym.bossed.shiro.ipSecurity.IPStrategyInterface#checkLoginIP(java.lang.String)
	 */
	@Override
	public  boolean checkLoginIP(String ip) {
		Object obj = ipMap.get(ip);
		// no record,pass
		if (obj == null) {
			return true;
		}
		// check if is permanently forbidden
		HostBean hb = (HostBean) obj;
		if (hb.isPermanentForbidden()) {
			return false;
		}
		// check if the first attampt login over half hour from now
		Date date1 = hb.getFirstFailureTime();
		// add half hour to date1
		date1.setTime(((date1.getTime() / 1000) + 60 * 30) * 1000);

		/**
		 * compare to now, if lower than now after adding 30min, says has overed
		 * half hour than now,can remove,pass
		 **/
		if (date1.compareTo(getNow()) == -1) {
			unlockIP(ip);
			return true;
		}
		/**
		 * if greater than now after adding 30min, says the record still
		 * validate,next,check the failure count
		 */
		if (hb.getFailureTimesCount() > MAX_FAILURE_TIMES) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.xym.bossed.shiro.ipSecurity.IPStrategyInterface#printIPStrategyTable()
	 */
	@Override
	public  String printIPStrategyTable() {
		Set<String> set_key = ipMap.keySet();
		Iterator it=set_key.iterator();
		StringBuffer sb=new StringBuffer();
		sb.append("<table border=1>");
		sb.append("<tr><td>IP</td><td>FailureTimesCount</td><td>FirstFailureTime</td><td>TryUser</td></tr>");
		while(it.hasNext())
		{
			sb.append("<tr>");
			sb.append("<td>");
			String key=(String) it.next();
			sb.append(key).append("</td>");
			
			HostBean hb=(HostBean)ipMap.get(key);
			sb.append("<td>").append(hb.getFailureTimesCount()).append("</td>");
			sb.append("<td>").append(hb.getFirstFailureTime()).append("</td>");
			sb.append("<td><table border=1>");
			sb.append("<tr><td>name</td><td>pwd</td><td>time</td><td>FailReason</td></tr>");
			List<TryUserBean> list=hb.getUserList();
			for(int i=0;i<list.size();i++)
			{   sb.append("<tr>");
				TryUserBean ub=list.get(i);
				sb.append("<td>").append(ub.getUserName()).append("</td>");
				sb.append("<td>").append(ub.getPassword()).append("</td>");
				sb.append("<td>").append(ub.getTryTime()).append("</td>");
				sb.append("<td>").append(ub.getFailReason()).append("</td>");
				sb.append("</tr>");
			}
			
			sb.append("</table></td>");
			
			 sb.append("</tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.xym.bossed.shiro.ipSecurity.IPStrategyInterface#unlockIP(java.lang.String)
	 */
	@Override
	public  void unlockIP(String ip) {
		ipMap.remove(ip);
	}

	/* (non-Javadoc)
	 * @see com.xym.bossed.shiro.ipSecurity.IPStrategyInterface#unlockAll()
	 */
	@Override
	public  void unlockAll() {
		ipMap.clear();
	}

	/* (non-Javadoc)
	 * @see com.xym.bossed.shiro.ipSecurity.IPStrategyInterface#permanetForbiddenIP(java.lang.String)
	 */
	@Override
	public  void permanetForbiddenIP(String ip) {

		HostBean hb = null;
		if (!ipMap.containsKey(ip)) {
			hb = new HostBean();
			hb.setIp(ip);
		} else {
			hb = (HostBean) ipMap.get(ip);
		}
		hb.setPermanentForbidden(true);
		ipMap.put(ip, hb);
	}

	private  void addHostBean2IPMap(String userName, String password,
			String failReason, HostBean hb) {
		ArrayList<TryUserBean> list=null;
		
		TryUserBean tub = new TryUserBean();
		tub.setUserName(userName);
		tub.setPassword(password);
		tub.setTryTime(getNow());
		tub.setFailReason(failReason);
		
		if(hb.getUserList()==null)
		{
			list = new ArrayList<TryUserBean>();
		}
		else
		{
			list = (ArrayList<TryUserBean>) hb.getUserList();
		}
		// if the tryUserList over 20,set it to zero,in case too large
		if (list.size() > 20) {
			list.clear();
		}		
		list.add(tub);
		hb.setUserList(list);
	}

	private  Date getNow() {
		Date rt = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(new Date());

		try {
			rt = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rt;
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = format.parse("2014-03-07 18:00:29");
		String str1 = format.format(date1);

		// add half hour to date1
		date1.setTime(((date1.getTime() / 1000) + 60 * 30) * 1000);

		Date date2 = new IPStrategy().getNow();
		System.out.println(date1);
	}
}
