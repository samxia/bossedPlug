package com.xym.bossed.authority;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.xym.bossed.db.mybatis.price.PriceRefer;

public class PriceReferAfterAdvice implements AfterReturningAdvice {

	private static Logger log=Logger.getLogger(PriceReferAfterAdvice.class);
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		if (returnValue != null && method.getName().equals("getPriceReferForSale")) {
			this.checkPriceReferForSale(returnValue);
		}
	}

	private void checkPriceReferForSale(Object returnValue) {
		List<PriceRefer> list = (List<PriceRefer>) returnValue;
		IAuthority ia = new AuthorityShiroImpl();
		boolean buyprice1 = ia.isPermission(ia.QueryPriceReferBuyPrice1);
		boolean buyprice2 = ia.isPermission(ia.QueryPriceReferBuyPrice2);
		boolean buyprice3 = ia.isPermission(ia.QueryPriceReferBuyPrice3);
		boolean saleprice1 = ia.isPermission(ia.QueryPriceReferSalePrice1);
		boolean saleprice2 = ia.isPermission(ia.QueryPriceReferSalePrice2);
		boolean saleprice3 = ia.isPermission(ia.QueryPriceReferSalePrice3);
		boolean avgpriceforAllCK = ia
				.isPermission(ia.QueryPriceReferAvaragePriceForAllCangKu);
		boolean avgpriceforTheCK = ia
				.isPermission(ia.QueryPriceReferAvaragePriceForTheCangKu);
		boolean lastPriceForTheCustomer = ia
				.isPermission(ia.QueryPriceReferLastPriceForTheCustomer);
		boolean lastSalePrice = ia
				.isPermission(ia.QueryPriceReferLastSalePrice);
		boolean highestSalePrice = ia
				.isPermission(ia.QueryPriceReferHighestSalePrice);
		boolean lowestSalePrice = ia
				.isPermission(ia.QueryPriceReferLowestSalePrice);
		boolean lastPriceForTheGYS = ia
				.isPermission(ia.QueryPriceReferLastPriceForTheGongYingShang);
		boolean earliestBuyPriceForTheCangKu = ia
				.isPermission(ia.QueryPriceReferEarliestBuyPriceForTheCangKu);
		boolean lastBuyPrice = ia.isPermission(ia.QueryPriceReferLastBuyPrice);
		boolean highestBuyPrice = ia
				.isPermission(ia.QueryPriceReferHighestBuyPrice);
		boolean lowestBuyPrice = ia
				.isPermission(ia.QueryPriceReferLowestBuyPrice);
		
		List<PriceRefer> toBeDelete=new ArrayList();
		
		for (int i = 0; i < list.size(); i++) {
			PriceRefer pr = list.get(i);
			int id = pr.getId();
			switch (id) {
			case 1:
				if (!saleprice1) {
					//list.remove(i);
					toBeDelete.add(pr);
				}
				break;
			case 2:
				if (!saleprice2) {
					toBeDelete.add(pr);
				}
				break;
			case 3:
				if (!saleprice3) {
					toBeDelete.add(pr);
				}
				break;
			case 4:
				if (!buyprice1) {
					toBeDelete.add(pr);
				}
				break;
			case 5:
				if (!buyprice2) {
					toBeDelete.add(pr);
				}
				break;
			case 6:
				if (!buyprice3) {
					toBeDelete.add(pr);
				}
				break;
			case 7:
				if (!avgpriceforTheCK) {
					toBeDelete.add(pr);
				}
				break;
			case 8:
				if (!avgpriceforAllCK) {
					toBeDelete.add(pr);
				}
				break;
			case 9:
				if (!earliestBuyPriceForTheCangKu) {
					toBeDelete.add(pr);
				}
				break;
			case 10:
				if (!lastBuyPrice) {
					toBeDelete.add(pr);
				}
				break;
			case 11:
				if (!lastSalePrice) {
					toBeDelete.add(pr);
				}
				break;
			case 12:
				if (!highestSalePrice) {
					toBeDelete.add(pr);
				}
				break;
			case 13:
				if (!lowestSalePrice) {
					toBeDelete.add(pr);
				}
				break;
			case 14:
				if (!lastPriceForTheCustomer) {
					toBeDelete.add(pr);
				}
				break;
			}
			
		}
		for(int j=0;j<toBeDelete.size();j++)
		{
			PriceRefer pr=toBeDelete.get(j);
			//log.debug("remove:"+pr.getPriceDesc());
			list.remove(pr);
		}

	}
}
