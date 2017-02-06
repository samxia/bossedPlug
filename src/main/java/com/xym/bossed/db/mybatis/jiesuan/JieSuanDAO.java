package com.xym.bossed.db.mybatis.jiesuan;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;

public class JieSuanDAO {
	public List<JieSuan> getAllJieSuan() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<JieSuan> list = null;
		try {
			JieSuanMapper mapper = session.getMapper(JieSuanMapper.class);
			list = mapper.selectByExample(new JieSuanExample());
		} finally {
			session.close();
		}
		return list;
	}
	public static void main(String[] args)
	{
		JieSuanDAO dao=new JieSuanDAO();
		System.out.println(dao.getAllJieSuan().size());
	}
}
