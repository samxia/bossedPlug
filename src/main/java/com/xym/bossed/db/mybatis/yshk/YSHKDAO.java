package com.xym.bossed.db.mybatis.yshk;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.db.mybatis.sale.PartsItem;
import com.xym.bossed.db.mybatis.sale.SaleMapper;

public class YSHKDAO implements YSHKMapper {

	@Override
	public YingShouHuoKuanBean getYSHKByKehuNo(String kehuNo) {
		SqlSession session = SQLFactory.getFactory().openSession();
		YingShouHuoKuanBean yshk = null;
		try {
			YSHKMapper mapper = session.getMapper(YSHKMapper.class);
			yshk = mapper.getYSHKByKehuNo(kehuNo);
		} finally {
			session.close();
		}
		return yshk;
	}
	public static void main(String[] args)
	{
		YSHKDAO dao=new YSHKDAO();
		YingShouHuoKuanBean yshk=dao.getYSHKByKehuNo("Kgrkh");
		System.out.println(yshk.getYshQM());
	}

}
