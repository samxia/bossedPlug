package com.xym.bossed.db.mybatis.contact.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.fapiao.FaPiaoMapper;

public class ContactCategoryDAO implements ContactCategoryMapper {

	@Override
	public int countByExample(ContactCategoryExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = -1;
		try {
			ContactCategoryMapper mapper = session
					.getMapper(ContactCategoryMapper.class);
			rv = mapper.countByExample(example);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int deleteByExample(ContactCategoryExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = -1;
		try {
			ContactCategoryMapper mapper = session
					.getMapper(ContactCategoryMapper.class);
			rv = mapper.deleteByExample(example);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int insert(ContactCategory record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ContactCategory record) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = -1;
		try {
			ContactCategoryMapper mapper = session
					.getMapper(ContactCategoryMapper.class);
			rv = mapper.insertSelective(record);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public List<ContactCategory> selectByExample(ContactCategoryExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<ContactCategory> list = null;
		try {
			ContactCategoryMapper mapper = session
					.getMapper(ContactCategoryMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(
			@Param("record") ContactCategory record,
			@Param("example") ContactCategoryExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int rv = -1;
		try {
			ContactCategoryMapper mapper = session
					.getMapper(ContactCategoryMapper.class);
			rv = mapper.updateByExampleSelective(record, example);
			session.commit();
		} finally {
			session.close();
		}
		return rv;
	}

	@Override
	public int updateByExample(@Param("record") ContactCategory record,
			@Param("example") ContactCategoryExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countContactByCategory(ContactCategory record) {
		SqlSession session = SQLFactory.getFactory().openSession();
		int returnvalue=-1;
		try {
			ContactCategoryMapper mapper = session
					.getMapper(ContactCategoryMapper.class);
			returnvalue = mapper.countContactByCategory(record);
		} finally {
			session.close();
		}
		return returnvalue;
	}



}
