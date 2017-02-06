package com.xym.bossed.interfaces;

import java.util.List;

import com.xym.bossed.db.mybatis.kehu.Kehu;

public interface IKehuService {

	/**
	 * 
	 * @param kehuXingZhing
	 *            -kehu xingzhi 【 博士德中使用（ 1-客户 2-供应商）】
	 * @return
	 */
	public List<Kehu> geKehuBykehuXz(Short kehuXingZhing);

	/**
	 * 
	 * @param kehuSh
	 *            -kehu shuihao
	 * @return
	 */
	public abstract String getKehuNoByKehuSh(String kehuSh);

	public abstract boolean existKehuNo(String kehuNo);

	public List<Kehu> getKehuByKehuMcOrKehuDh(String mingchengOrDianhua,Kehu kehu);
	public List<Kehu> getKehuByKehuMcOrKehuDhOnPagination(String mingchengOrDianhua,int page,int rows);
	public Kehu getKehuByKehuNo(String kehuNo);
	public List<Kehu> getKehuByTelNo(String telNo);
	public int saveKehu(Kehu kehu);
	public int deleteKehuByKehuNo(String kehuNo);
	public int checkBeforeDeleteKehu(String kehuNo);
	public int updateKehuByKehuNo(Kehu kehu); 
	
	
}