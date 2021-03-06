package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.sale.PartsItem;
import com.xym.bossed.db.mybatis.sale.SaleDAO;
import com.xym.bossed.db.mybatis.sale.SaleSheetSummary;
import com.xym.bossed.interfaces.ISaleService;
import com.xym.bossed.security.SecurityService;

public class SaleService implements ISaleService  {
	/* (non-Javadoc)
	 * @see com.xym.bossed.service.ISaleService#getAllSaleSheetSummary()
	 */
	@Override
	public List<SaleSheetSummary> getAllSaleSheetSummary()
	{
		return new SaleDAO().getAllSaleSheetSummary();
	}
	/* (non-Javadoc)
	 * @see com.xym.bossed.service.ISaleService#getSaleSheetSummaryByDanHao(java.lang.String)
	 */
	@Override
	public SaleSheetSummary getSaleSheetSummaryByDanHao(String danHao)
	{
		return new SaleDAO().getSaleSheetSummaryByDanHao(danHao);
	}
	/* (non-Javadoc)
	 * @see com.xym.bossed.service.ISaleService#getTempPartsItemByDanHao(java.lang.String)
	 */
	@Override
	public List<PartsItem> getTempPartsItemByDanHao(String danHao)
	{
		SaleDAO dao=new SaleDAO();
		dao.updateTempPartsItemFlagSLToZeroIfNullByDanHao(danHao);
		return dao.getTempPartsItemByDanHao(danHao);
	}
	@Override
	public String createNewDanHao() {
		DanhaoService dhs=new DanhaoService();
		return dhs.createNewDanhao(3001, new SecurityService().getCurrentUsername());
	}
	@Override
	public int zuoFeiSaleSheet(String danhao) {
		SaleDAO dao=new SaleDAO();
		return dao.deleteSaleSheetByDanHao(danhao);
	}
}
