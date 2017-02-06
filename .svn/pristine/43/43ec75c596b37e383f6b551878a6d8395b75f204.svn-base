package com.xym.bossed.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMovefile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(TestMovefile.moveFile(new File("G:\\2013_09_10\\IMg_0001.jpg"), "G:\\recycled"));

	}

	public static boolean moveFile(File srcFile, String destPath) {
		// Destination directory
		File dir = new File(destPath);

		// Move file to new directory
		boolean success = srcFile.renameTo(new File(dir, srcFile.getName()+new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date())));

		return success;
	}

}
