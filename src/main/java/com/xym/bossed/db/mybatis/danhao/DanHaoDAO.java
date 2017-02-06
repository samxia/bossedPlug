package com.xym.bossed.db.mybatis.danhao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.fapiao.FaPiao;

public class DanHaoDAO {

	public String createNewDanhao(int list_code, String czy) {
		SqlSession session = SQLFactory.getFactory().openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("list_code", list_code);
		param.put("Czy", czy);
		param.put("newlist_no", "");
		try {
		session.selectOne(
					"com.xym.bossed.db.mybatis.danhao.DanHaoMapper.newDanhao",
					param);

		} finally {
			session.close();
		}
		return (String) param.get("newlist_no");
	}

	public int zuofeiDanhao(String danhao,int list_code) {
		
		int rv=0;
		SqlSession session = SQLFactory.getFactory().openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("list_code", list_code);
		param.put("str_danhao", danhao);
		try {
			rv=session.delete("com.xym.bossed.db.mybatis.danhao.DanHaoMapper.zuofeiDanhao",
					param);
		    session.commit();

		} finally {
			session.close();
		}
		return rv;
	}

	public static void main(String[] args) {
		//String rv = new DanHaoDAO().createNewDanhao(5002, "œƒ‘√√˙");//KP20130603_0001
		//System.out.println(rv);
	}

}
