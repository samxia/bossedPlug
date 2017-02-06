package com.xym.bossed.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.xym.bossed.db.mybatis.price.PriceDAO;
import com.xym.bossed.db.mybatis.price.PriceRefer;
import com.xym.bossed.db.mybatis.procedure.PriceBean;
import com.xym.bossed.db.mybatis.procedure.ProcedureDAO;
import com.xym.bossed.interfaces.IPriceService;

public class PriceService implements IPriceService {
	
	public List<PriceRefer> getPriceReferForSale(String kehuNo, String partsNo,
			String cangkDm) {
		return new PriceDAO().selectPriceReferForSale(kehuNo, partsNo, cangkDm);
	}

	public List<PriceRefer> getPriceReferForBuy(String gysNo, String partsNo,
			String cangkDm) {
		return new PriceDAO().selectPriceReferForBuy(gysNo, partsNo, cangkDm);
	}

	/**
	 * --1: 各仓库汇总平均价
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getAvaregePriceForAllCangKu(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPeijNo(peijNo);
		pb.setPriceCode(1);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --2: 本仓库平均价
	 * 
	 * @param peijNo
	 * @param cangkDm
	 * @return
	 */
	public BigDecimal getAvaregePriceForSpecificCangKu(String peijNo,
			String cangKuDm) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(2);
		pb.setCangKuDm(cangKuDm);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --11:该客户历史结算价
	 * 
	 * @param kehuNo
	 * @param peijNo
	 * @return
	 */
	public PriceBean getLastTimePriceForSpecificKeHu(String kehuNo,
			String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(11);
		pb.setKehuNo(kehuNo);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);

		return this.trunReturnedMap2PriceBean(map);
		// return null;
	}

	/**
	 * --12:最早的销售价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getEarliestPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(12);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --13:最近的销售价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getLastTimeSalePrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(13);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --14:历史最高售价
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getHighestSalePrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(14);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --15:历史最低售价
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getLowestSalePrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(15);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --16:一级销价
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getFirstSalePrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(16);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --17:二级销价
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getSecondSalePrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(17);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --18:三级销价
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getThirdSalePrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(18);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --21:该供应商历史结算价
	 * 
	 * @param peijNo
	 * @param supplierNo
	 * @return
	 */
	public PriceBean getLastTimePriceForSpecificSupplier(String peijNo,
			String supplierNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(21);
		pb.setPeijNo(peijNo);
		pb.setKehuNo(supplierNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --22:最早进货价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getEaliestBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(22);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --23:最近进货价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getLastBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(23);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --24:历史最高进价
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getHighestBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(24);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --25:历史最低进价
	 * 
	 * @param peijNo
	 * @return
	 */
	public PriceBean getLowestBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(25);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return this.trunReturnedMap2PriceBean(map);
	}

	/**
	 * --26:进货价格1
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getFirstBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(26);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --27:进货价格2
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getSecondBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(27);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * --28:进货价格3
	 * 
	 * @param peijNo
	 * @return
	 */
	public BigDecimal getThirdBuyPrice(String peijNo) {
		ProcedureDAO dao = new ProcedureDAO();
		PriceBean pb = new PriceBean();
		pb.setPriceCode(28);
		pb.setPeijNo(peijNo);
		Map<String, Object> map = dao.getPriceByProcudure(pb);
		return (BigDecimal) map.get("price");
	}

	/**
	 * turn the returned map to priceBean
	 * 
	 * @param map
	 * @return
	 */
	public PriceBean trunReturnedMap2PriceBean(Map map) {
		PriceBean pb = new PriceBean();
		pb.setKehuNo((String) map.get("kehuNo"));
		pb.setPrice((BigDecimal) map.get("price"));
		pb.setYeWuDanHao((String) map.get("yeWuDanHao"));
		// pb.setYeWuDate((Date) map.get("yeWuDate"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		if (map.get("yeWuDate") instanceof Date) {

			Date tmp = (java.util.Date) map.get("yeWuDate");
			// Calendar ca=Calendar.getInstance();
			if (tmp != null) {
				pb.setYeWuDate(sdf.format(tmp));
			}
		} else {
			pb.setYeWuDate((String) map.get("yeWuDate"));
		}

		return pb;
	}

	public static void main(String[] args) {
		IPriceService ps = new PriceService();
		PriceBean pb = ps.getLastTimePriceForSpecificKeHu("KGRKH",
				"CYLHQP-1060-275J-10Y-YZBP");
		System.out.println(pb.getPrice() + "--" + pb.getYeWuDanHao() + "--"
				+ pb.getYeWuDate() + "--" + pb.getKehuNo());
		System.out.println(JSONObject.fromObject(pb).toString());

	}

}
