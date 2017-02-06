package com.xym.bossed.service;

import java.util.Iterator;
import java.util.List;

import com.xym.bossed.db.mybatis.kehu.Kehu;
import com.xym.bossed.interfaces.IKehuService;

public class TestKehuService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestKehuService().testGetKehuByKehuMcOrKehuDh();
		//System.out.println("teset");
	}

	public void testGetKehuByKehuMcOrKehuDh() {
		IKehuService ks = new KehuService();
		Kehu kh = new Kehu();
		// kh.setKehuXz((short) 0);
		List<Kehu> l = ks.getKehuByKehuMcOrKehuDh("jzwl", kh);
		System.out.println(l.size());
		Iterator i = l.iterator();
		while (i.hasNext()) {
			Kehu k = (Kehu) i.next();
			System.out.println(k.getKehuMc()+":"+k.getPicCount());
		}

	}

	/*
	 * public void testUpdateKehuByKehuNo() { IKehuService ks = new
	 * KehuService(); Kehu kh = new Kehu(); kh.setKehuNo("aaa3");
	 * kh.setKehuXz((short) 1); System.out.println(ks.updateKehuByKehuNo(kh));
	 * 
	 * }
	 */

	public void testGetKehuByKehuMcOrKehuDhOnPagination() {
		IKehuService ks = new KehuService();
		List<Kehu> l = ks.getKehuByKehuMcOrKehuDhOnPagination("fdj", 2, 5);
		Iterator i = l.iterator();
		while (i.hasNext()) {
			Kehu k = (Kehu) i.next();
			System.out.println(k.getKehuMc());
		}

	}

	public void testGetKehuNoByKehuSh() {
		IKehuService ks = new KehuService();

		System.out.println(ks.getKehuNoByKehuSh("220106606092819"));

	}

	public void testGetKehuByKehuNo() {
		IKehuService ks = new KehuService();
		Kehu kh = ks.getKehuByKehuNo("JLBSLJPC");
		if (kh != null) {
			System.out.println(kh.getKehuMc());
		}
	}

	/*
	 * public void testSaveKehu() { KehuService ks = new KehuService(); Kehu kh
	 * = new Kehu(); kh.setKehuNo("ABCD"); kh.setKehuMc("中发科技");
	 * kh.setKehuXm("夏悦铭1"); // start save if (kh.getKehuMc() != null) {
	 * kh.setKehuDp(PinYin.getPinYinHeadChar(kh.getKehuMc())); } if
	 * (kh.getKehuXm() != null) {
	 * kh.setKehuLp(PinYin.getPinYinHeadChar(kh.getKehuXm())); }
	 * kh.setKehuDj(new Date()); kh.setKehuXz((short) 1);// 3 is not a bossed
	 * xingzhi. int rst = ks.saveKehu(kh); System.out.println(rst); }
	 */

}
