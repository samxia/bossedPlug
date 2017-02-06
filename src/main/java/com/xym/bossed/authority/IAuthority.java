package com.xym.bossed.authority;

public interface IAuthority {
	String QueryKuCunBuyPrice1="data:kucun:query:buyprice1";
	String QueryKuCunBuyPrice2="data:kucun:query:buyprice2";
	String QueryKuCunBuyPrice3="data:kucun:query:buyprice3";
	String QueryKuCunAveragePrice="data:kucun:query:averageprice";
	String QueryKuCunAvaliableKuCun="data:kucun:query:aviliableKucun";
	String QueryKuCunCureentKuCun="data:kucun:query:currentKucun";
	String QueryKuCunAmount="data:kucun:query:amount";
	String QueryKuCunAlarm="data:kucun:query:kucunAlarm";
	String QueryKuCunMax="data:kucun:query:kucunMax";
	String QeuryKuCunMin="data:kucun:query:kucunMin";
	
	String QueryPriceReferBuyPrice1="data:query:price:buyprice1";
	String QueryPriceReferBuyPrice2="data:query:price:buyprice2";
	String QueryPriceReferBuyPrice3="data:query:price:buyprice3";
	String QueryPriceReferSalePrice1="data:query:price:saleprice1";
	String QueryPriceReferSalePrice2="data:query:price:saleprice2";
	String QueryPriceReferSalePrice3="data:query:price:saleprice3";
	//各仓库汇总平均价
	String QueryPriceReferAvaragePriceForAllCangKu="QueryPriceReferAvaragePriceForAllCangKu";
	//本仓库平均价
	String QueryPriceReferAvaragePriceForTheCangKu="QueryPriceReferAvaragePriceForTheCangKu";
	//该客户历史结算价
	String QueryPriceReferLastPriceForTheCustomer="QueryPriceReferLastPriceForTheCustomer";
	///最近一次销售价格
	String QueryPriceReferLastSalePrice="QueryPriceReferLastSalePrice";
	//历史最高售价
	String QueryPriceReferHighestSalePrice="QueryPriceReferHighestSalePrice";
	//历史最低售价
	String QueryPriceReferLowestSalePrice="QueryPriceReferLowestSalePrice";
	//该供应商历史结算价
	String QueryPriceReferLastPriceForTheGongYingShang="QueryPriceReferLastPriceForTheGongYingShang";
	//本仓现存最早进货之进价
	String QueryPriceReferEarliestBuyPriceForTheCangKu="QueryPriceReferEarliestBuyPriceForTheCangKu";
	//最近一次进货价格
	String QueryPriceReferLastBuyPrice="QueryPriceReferLastBuyPrice";
	//历史最高进价
	String QueryPriceReferHighestBuyPrice="QueryPriceReferHighestBuyPrice";
	//历史最低进价
	String QueryPriceReferLowestBuyPrice="QueryPriceReferLowestBuyPrice";
	
	boolean isPermission(String PermissionString);
}
