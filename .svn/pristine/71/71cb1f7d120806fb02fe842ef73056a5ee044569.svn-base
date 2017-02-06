package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.parts.fenlu.PartsFenLu;
import com.xym.bossed.db.mybatis.parts.fenlu.PartsFenLuDAO;
import com.xym.bossed.db.mybatis.parts.fenlu.PartsFenLuExample;
import com.xym.bossed.interfaces.IPartsFenLuService;

public class PartsFenLuService implements IPartsFenLuService {
	/* (non-Javadoc)
	 * @see com.xym.bossed.service.IPartsFenLuService#getFenLuByPartsNo(java.lang.String)
	 */
	@Override
	public List<PartsFenLu> getFenLuByPartsNo(String partsNo) {
		return new PartsFenLuDAO().selectByPartsNo(partsNo);
	}
	public static void main(String[] args)
	{
		IPartsFenLuService ps=new PartsFenLuService();
		System.out.println(ps.getFenLuByPartsNo("JYX-JX0818-CJ").size());
	}
}
