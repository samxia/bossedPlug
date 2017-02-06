package com.xym.bossed.db.mybatis.price;

import java.util.List;

public interface PriceMapper {
	public List<PriceRefer> selectPriceReferForSale(String kehuNo, String partsNo,
			String cangkDm);

	public List<PriceRefer> selectPriceReferForBuy(String gysNo, String partsNo,
			String cangkDm);
	

}
