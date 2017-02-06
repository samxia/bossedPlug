package com.xym.bossed.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.xym.bossed.db.mybatis.price.PriceRefer;
import com.xym.bossed.db.mybatis.procedure.PriceBean;

public interface IPriceService {

	public abstract List<PriceRefer> getPriceReferForSale(String kehuNo,
			String partsNo, String cangkDm);

	public abstract List<PriceRefer> getPriceReferForBuy(String gysNo,
			String partsNo, String cangkDm);

	/**
	 * --1: 各仓库汇总平均价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getAvaregePriceForAllCangKu(String peijNo);

	/**
	 * --2: 本仓库平均价
	 * 
	 * @param peijNo
	 * @param cangkDm
	 * @return
	 */
	public abstract BigDecimal getAvaregePriceForSpecificCangKu(String peijNo,
			String cangKuDm);

	/**
	 * --11:该客户历史结算价
	 * 
	 * @param kehuNo
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getLastTimePriceForSpecificKeHu(String kehuNo,
			String peijNo);

	/**
	 * --12:最早的销售价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getEarliestPrice(String peijNo);

	/**
	 * --13:最近的销售价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getLastTimeSalePrice(String peijNo);

	/**
	 * --14:历史最高售价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getHighestSalePrice(String peijNo);

	/**
	 * --15:历史最低售价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getLowestSalePrice(String peijNo);

	/**
	 * --16:一级销价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getFirstSalePrice(String peijNo);

	/**
	 * --17:二级销价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getSecondSalePrice(String peijNo);

	/**
	 * --18:三级销价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getThirdSalePrice(String peijNo);

	/**
	 * --21:该供应商历史结算价
	 * 
	 * @param peijNo
	 * @param supplierNo
	 * @return
	 */
	public abstract PriceBean getLastTimePriceForSpecificSupplier(
			String peijNo, String supplierNo);

	/**
	 * --22:最早进货价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getEaliestBuyPrice(String peijNo);

	/**
	 * --23:最近进货价格
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getLastBuyPrice(String peijNo);

	/**
	 * --24:历史最高进价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getHighestBuyPrice(String peijNo);

	/**
	 * --25:历史最低进价
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract PriceBean getLowestBuyPrice(String peijNo);

	/**
	 * --26:进货价格1
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getFirstBuyPrice(String peijNo);

	/**
	 * --27:进货价格2
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getSecondBuyPrice(String peijNo);

	/**
	 * --28:进货价格3
	 * 
	 * @param peijNo
	 * @return
	 */
	public abstract BigDecimal getThirdBuyPrice(String peijNo);

	/**
	 * turn the returned map to priceBean
	 * 
	 * @param map
	 * @return
	 */
	public abstract PriceBean trunReturnedMap2PriceBean(Map map);

}