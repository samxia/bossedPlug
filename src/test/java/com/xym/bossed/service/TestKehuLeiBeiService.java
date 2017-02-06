package com.xym.bossed.service;

import java.util.List;

import com.xym.bossed.db.mybatis.kehu.leibie.KehuLeibie;

public class TestKehuLeiBeiService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestKehuLeiBeiService().testGetAllLeibie();

	}

	public void testGetAllLeibie() {
		KehuLeibieService ks =new KehuLeibieService ();
		List<KehuLeibie> list=ks.getAllLeibie();
		//System.out.println(list.size());
		System.out.println(ks.makeTreeData(list).toString());
	}
}
