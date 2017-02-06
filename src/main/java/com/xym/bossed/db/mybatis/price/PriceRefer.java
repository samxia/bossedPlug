package com.xym.bossed.db.mybatis.price;

import java.math.BigDecimal;

public class PriceRefer {

	// select xiao_id as id,price_desc,jiag,yewu_dh,yewu_rq from info_price
	// where 1<0
	private int id;
	private String priceDesc, yewuDh, yewuRq;
	private BigDecimal jiag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriceDesc() {
		return priceDesc;
	}

	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public String getYewuDh() {
		return yewuDh;
	}

	public void setYewuDh(String yewuDh) {
		this.yewuDh = yewuDh;
	}

	public String getYewuRq() {
		return yewuRq;
	}

	public void setYewuRq(String yewuRq) {
		this.yewuRq = yewuRq;
	}

	public BigDecimal getJiag() {
		return jiag;
	}

	public void setJiag(BigDecimal jiag) {
		this.jiag = jiag;
	}

}
