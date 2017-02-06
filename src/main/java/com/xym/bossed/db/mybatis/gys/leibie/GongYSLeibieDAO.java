package com.xym.bossed.db.mybatis.gys.leibie;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.xym.bossed.db.mybatis.SQLFactory;
import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibie;
import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibieDAO;
import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibieMapper;

public class GongYSLeibieDAO implements GongYSLeibieMapper {

	@Override
	public int countByExample(GongYSLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(GongYSLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String kehulbDm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GongYSLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(GongYSLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GongYSLeibie> selectByExample(GongYSLeibieExample example) {
		List<GongYSLeibie> list = null;
		SqlSession session = SQLFactory.getFactory().openSession();
		try {
			GongYSLeibieMapper mapper = session
					.getMapper(GongYSLeibieMapper.class);
			list = mapper.selectByExample(example);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public GongYSLeibie selectByPrimaryKey(String kehulbDm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") GongYSLeibie record,
			@Param("example") GongYSLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") GongYSLeibie record,
			@Param("example") GongYSLeibieExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(GongYSLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(GongYSLeibie record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
