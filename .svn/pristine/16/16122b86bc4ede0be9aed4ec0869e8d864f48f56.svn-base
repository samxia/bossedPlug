package com.xym.bossed.db.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SQLFactory {
	private static final Logger log = Logger.getLogger(SQLFactory.class);

	public static SqlSessionFactory getFactory() {
		String resource = "MybatisMapperConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			log.fatal(e.getMessage());
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		return factory;
	}
}
