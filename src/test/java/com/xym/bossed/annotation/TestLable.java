package com.xym.bossed.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestLable {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws SecurityException,
			ClassNotFoundException {
		// Method[] methods =
		// Class.forName("com.xym.bossed.db.mybatis.kehu.Kehu").getDeclaredMethods();
		Field[] fileds = Class.forName("com.xym.bossed.db.mybatis.kehu.Kehu")
				.getDeclaredFields();
		for(Field field:fileds)
		{
			System.out.println(field.getName());
			Annotation[] annotations=field.getAnnotations();
			System.out.println(annotations.length);
			for(Annotation annotation:annotations)
			{
				
				System.out.println(annotation.annotationType().getSimpleName());
			}
		}
		System.out.println(fileds.length);
		//Annotation[] annotations;

		/*
		 * for (Method method : methods) {
		 * 
		 * annotations = method.getAnnotations();
		 * 
		 * for (Annotation annotation : annotations) {
		 * 
		 * System.out.println(method.getName() + " : "
		 * 
		 * + annotation.annotationType().getName());
		 * 
		 * }
		 */
	}

}
