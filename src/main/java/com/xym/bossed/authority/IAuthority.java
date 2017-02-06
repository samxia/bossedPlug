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
	//���ֿ����ƽ����
	String QueryPriceReferAvaragePriceForAllCangKu="QueryPriceReferAvaragePriceForAllCangKu";
	//���ֿ�ƽ����
	String QueryPriceReferAvaragePriceForTheCangKu="QueryPriceReferAvaragePriceForTheCangKu";
	//�ÿͻ���ʷ�����
	String QueryPriceReferLastPriceForTheCustomer="QueryPriceReferLastPriceForTheCustomer";
	///���һ�����ۼ۸�
	String QueryPriceReferLastSalePrice="QueryPriceReferLastSalePrice";
	//��ʷ����ۼ�
	String QueryPriceReferHighestSalePrice="QueryPriceReferHighestSalePrice";
	//��ʷ����ۼ�
	String QueryPriceReferLowestSalePrice="QueryPriceReferLowestSalePrice";
	//�ù�Ӧ����ʷ�����
	String QueryPriceReferLastPriceForTheGongYingShang="QueryPriceReferLastPriceForTheGongYingShang";
	//�����ִ��������֮����
	String QueryPriceReferEarliestBuyPriceForTheCangKu="QueryPriceReferEarliestBuyPriceForTheCangKu";
	//���һ�ν����۸�
	String QueryPriceReferLastBuyPrice="QueryPriceReferLastBuyPrice";
	//��ʷ��߽���
	String QueryPriceReferHighestBuyPrice="QueryPriceReferHighestBuyPrice";
	//��ʷ��ͽ���
	String QueryPriceReferLowestBuyPrice="QueryPriceReferLowestBuyPrice";
	
	boolean isPermission(String PermissionString);
}