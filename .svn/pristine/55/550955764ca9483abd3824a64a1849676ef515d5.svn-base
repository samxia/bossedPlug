package com.xym.bossed.util.clone;

import java.lang.reflect.Method;

public class TestClone {

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {

		BeanA ba = new BeanA();
		ba.setStr1("a");
		ba.setStr2("b");

		Method[] m = ba.getClass().getMethods();
       for(int i=0;i<m.length;i++)
       {
    	   System.out.println(m[i].getName());
       }
	}
}
