package com.xym.bossed.db.mybatis.fapiao.leixing;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.fapiao.FaPiao;
import com.xym.bossed.db.mybatis.fapiao.FaPiaoMapper;

public class LeiXingDAO implements LeiXingMapper {

	@Override
	public List<FaPiaoLeiXing> getAllLeiXing() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<FaPiaoLeiXing> list = null;
		try {
			LeiXingMapper mapper = session.getMapper(LeiXingMapper.class);
			list = mapper.getAllLeiXing();
		} finally {
			session.close();
		}
		return list;
	}

	public static void main(String[] args) {
		LeiXingDAO lxdao = new LeiXingDAO();
		System.out.print(lxdao.getAllLeiXing().size());
	}
}
