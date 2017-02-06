package com.xym.bossed.db.mybatis.auth.contacts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;


public class ExcludedContactsDAO implements ExcludedContactsMapper {
	public List<String> getAllContactsCatagory() {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<String> list = null;
		try {
			ExcludedContactsMapper mapper = session
					.getMapper(ExcludedContactsMapper.class);
			list = mapper.getAllContactsCatagory();
		} finally {
			session.close();
		}
		return list;
	}
	@Override
	public List<ExcludedContactsCategory> getExcludedContactsCategoryByRoleId(
			int role_id) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<ExcludedContactsCategory> list = null;
		try {
			ExcludedContactsMapper mapper = session
					.getMapper(ExcludedContactsMapper.class);
			list = mapper.getExcludedContactsCategoryByRoleId(role_id);
		} finally {
			session.close();
		}
		return list;
	}
	public static void main(String[] args)
	{
		ExcludedContactsDAO ecd=new ExcludedContactsDAO();
		List<String> list=ecd.getAllContactsCatagory();
		for(int i=0;i<list.size();i++)
		{
		 System.out.println(list.get(i));
		}
	}
	@Override
	public int insertExcludedContactsCategory(ExcludedContactsCategory ecc) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv=-1;
		try {
			ExcludedContactsMapper mapper = session
					.getMapper(ExcludedContactsMapper.class);
			rv = mapper.insertExcludedContactsCategory(ecc);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}
	@Override
	public int deleteExcludedContactsCategory(ExcludedContactsCategory ecc) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv=-1;
		try {
			ExcludedContactsMapper mapper = session
					.getMapper(ExcludedContactsMapper.class);
			rv = mapper.deleteExcludedContactsCategory(ecc);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

}
