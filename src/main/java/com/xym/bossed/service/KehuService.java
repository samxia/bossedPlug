package com.xym.bossed.service;

import java.io.File;
import java.util.List;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.db.mybatis.kehu.KehuDAO;
import com.xym.bossed.db.mybatis.kehu.KehuExample;
import com.xym.bossed.db.mybatis.kehu.KehuExample.Criteria;
import com.xym.bossed.db.mybatis.kehu.KehuExample.Criterion;
import com.xym.bossed.interfaces.IKehuService;

public class KehuService implements IKehuService {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xym.bossed.service.IKehuService#getKehuNoByKehuSh(java.lang.String)
	 */
	@Override
	public String getKehuNoByKehuSh(String kehuSh) {
		KehuDAO dao = new KehuDAO();
		KehuExample e = new KehuExample();
		e.or().andKehuShEqualTo(kehuSh);
		List<Kehu> list = dao.selectByExample(e);
		for (int i = 0; i < list.size(); i++) {
			Kehu kehu = list.get(i);
			return kehu.getKehuNo();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xym.bossed.service.IKehuService#existKehuNo(java.lang.String)
	 */
	@Override
	public boolean existKehuNo(String kehuNo) {
		KehuDAO dao = new KehuDAO();
		KehuExample e = new KehuExample();
		e.or().andKehuNoEqualTo(kehuNo);
		if (dao.countByExample(e) > 0) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * get kehu by kehu xingzhi
	 *   【 博士德中使用（ 1-客户 2-供应商）】
	 */
	public List<Kehu> geKehuBykehuXz(Short kehuXingZhing) {
		KehuDAO dao = new KehuDAO();
		KehuExample e = new KehuExample();
		e.or().andKehuXzEqualTo(kehuXingZhing);
		return dao.selectByExample(e);
	}

	@Override
	public List<Kehu> getKehuByKehuMcOrKehuDh(String mingchengOrDianhua,
			Kehu kehu) {
		KehuDAO dao = new KehuDAO();
		KehuExample e = new KehuExample();
		e.setKehu(kehu);
		this.makeCriteriaForKehuMcOrKehuDh(e, mingchengOrDianhua);

		return dao.selectByExample(e);
	}

	@Override
	public List<Kehu> getKehuByKehuMcOrKehuDhOnPagination(
			String mingchengOrDianhua, int page, int rows) {
		KehuDAO dao = new KehuDAO();
		KehuExample e = new KehuExample();
		this.makeCriteriaForKehuMcOrKehuDh(e, mingchengOrDianhua);
		e.setPage(page);
		e.setRows(rows);
		return dao.selectByExampleOnPagination(e);
	}

	/*
	 * public List<Kehu> getKehuByKehuMcOrKehuDhOnPagination( String
	 * mingchengOrDianhua, int page, int rows,String order,String sort) {
	 * KehuDAO dao = new KehuDAO(); KehuExample e = new KehuExample();
	 * this.makeCriteriaForKehuMcOrKehuDh(e, mingchengOrDianhua);
	 * e.setOrderByClause(); e.setPage(page); e.setRows(rows); return
	 * dao.selectByExampleOnPagination(e); }
	 */
	private void makeCriteriaForKehuMcOrKehuDh(KehuExample e,
			String mingchengOrDianhua) {
		if (mingchengOrDianhua.trim().isEmpty()) {
			return;
		}
		e.or().andKehuNoLike("%" + mingchengOrDianhua + "%");// 编号
		e.or().andKehuMcLike("%" + mingchengOrDianhua + "%");// 名称
		e.or().andKehuDpLike("%" + mingchengOrDianhua + "%");// 名称短拼
		e.or().andKehuDhLike("%" + mingchengOrDianhua + "%");// 电话
		e.or().andKehuSjLike("%" + mingchengOrDianhua + "%");// 手机
		e.or().andKehuCzLike("%" + mingchengOrDianhua + "%");// 传真
		e.or().andKehuBzLike("%" + mingchengOrDianhua + "%");// 备注
		e.or().andKehuXmLike("%" + mingchengOrDianhua + "%");// 联系人姓名
		e.or().andKehuLpLike("%" + mingchengOrDianhua + "%");// 联系人拼音
	}

	@Override
	public Kehu getKehuByKehuNo(String kehuNo) {
		KehuDAO kd = new KehuDAO();
		return kd.selectByPrimaryKey(kehuNo);
	}

	@Override
	public List<Kehu> getKehuByTelNo(String telNo) {
		KehuDAO dao = new KehuDAO();
		KehuExample e = new KehuExample();
		e.or().andKehuDhLike("%" + telNo + "%");// 电话
		e.or().andKehuSjLike("%" + telNo + "%");// 手机
		e.or().andKehuCzLike("%" + telNo + "%");// 传真
		return dao.selectByExample(e);
	}

	@Override
	public int saveKehu(Kehu kehu) {
		KehuDAO dao = new KehuDAO();
		return dao.insertSelective(kehu);
	}

	@Override
	public int deleteKehuByKehuNo(String kehuNo) {
		int rv = this.checkBeforeDeleteKehu(kehuNo);// check before delete
		if (rv != 0) {
			return rv;
		}
		KehuDAO dao = new KehuDAO();
		int r = dao.deleteByPrimaryKey(kehuNo);
		return r;
	}

	public int checkBeforeDeleteKehu(String kehuNo) {
		ProcedureService ps = new ProcedureService();
		// 1102 为check删除客户代码
		return ps.checkBeforeDelete(kehuNo, 1102);
	}

	@Override
	public int updateKehuByKehuNo(Kehu kehu) {
		KehuDAO kd = new KehuDAO();
		return kd.updateByPrimaryKeySelective(kehu);
	}

}
