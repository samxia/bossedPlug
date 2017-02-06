package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.parts.Parts;
import com.xym.bossed.db.mybatis.parts.PartsDAO;
import com.xym.bossed.db.mybatis.parts.PartsExample;
import com.xym.bossed.db.mybatis.parts.PartsExample.Criteria;
import com.xym.bossed.interfaces.IPartsService;

public class PartsService implements IPartsService {
	/* (non-Javadoc)
	 * @see com.xym.bossed.service.IPartsService#getPartsByCriteria(com.xym.bossed.db.mybatis.parts.Parts)
	 */
	@Override
	public List<Parts> getPartsByCriteria(Parts parts) {
		String peijMc = parts.getPeijMc();
		String peijCx = parts.getPeijCx();
		String peijTh = parts.getPeijTh();
		String peijNo=parts.getPeijNo();
		
		PartsExample pe = new PartsExample();
		
		if(peijNo != null && peijNo.trim().isEmpty() == false)
		{
			pe.and().andPeijNoLike("%"+peijNo+"%");
		}
		if (peijMc != null && peijMc.trim().isEmpty() == false) {
			
			pe.and().andPeijPyLike("%" + peijMc + "%").andPeijMcLike("%" + peijMc + "%");
		}
		if (peijCx != null && peijCx.trim().isEmpty() == false) {
			pe.and().andPeijCxpyLike("%" + peijCx + "%").andPeijCxLike("%" + peijCx + "%");
		}
		if (peijTh != null && peijTh.trim().isEmpty() == false) {
			pe.and().andPeijThLike("%" + peijTh + "%");
		}
		PartsDAO dao = new PartsDAO();
		return dao.selectByExample(pe);
	}

	public static void main(String[] args) {
		IPartsService ps = new PartsService();
		Parts parts = new Parts();
		parts.setPeijMc("lhqp");
		parts.setPeijCx("380");
		//parts.setPeijTh("350");
		List<Parts> list = ps.getPartsByCriteria(parts);
		System.out.println(list.size());
	}
}
