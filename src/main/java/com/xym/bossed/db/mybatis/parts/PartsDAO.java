package com.xym.bossed.db.mybatis.parts;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.db.mybatis.kehu.KehuMapper;

public class PartsDAO implements PartsMapper {

	@Override
	public int countByExample(PartsExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PartsExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String peijNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Parts record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Parts record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Parts> selectByExample(PartsExample example) {
		SqlSession session = SQLFactory.getFactory().openSession();
		List<Parts> list = null;
		try {
			PartsMapper mapper = session.getMapper(PartsMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Parts selectByPrimaryKey(String peijNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") Parts record,
			@Param("example") PartsExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") Parts record,
			@Param("example") PartsExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Parts record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Parts record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		PartsDAO dao=new PartsDAO();
		PartsExample pe=new PartsExample();
		pe.or().andPeijPyLike("");
		System.out.println(dao.selectByExample(pe).size());
	}
}
