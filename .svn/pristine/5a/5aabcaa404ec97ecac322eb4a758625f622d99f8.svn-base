package com.xym.bossed.db.mybatis.kehu;

public class TestKehuDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KehuDAO dao=new KehuDAO();
		KehuExample ke=new KehuExample();
		ke.or().andKehuDpLike("%syjb%");
		System.out.println(dao.countByExample(ke));

	}

}
