package com.xym.bossed.util;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;


public class Base64Util {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Base64 base64 = new Base64();
		String str_base64="iVBORw0KGgoAAAANSUhEUgAAAoAAAAHgCAYAAAA10dzkAAAgAElEQVR4Xu3d+19UR5oHYGnwBqgo3pIYzcXEbGacmb38///BXj+z2UzGzcUkJpF4QUQQBHb21HlhzqEbuovkE4p6+oft0HR1Vz3v0fnua51zpu7fv79zyoMAAQIECBAgQKAagSkBsJpaWygBAgQIECBAoBEQAB0IBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoKbrkECBAgQIAAAQHQMUCAAAECBAgQqExAAKys4JZLgAABAgQIEBAAHQMECBAgQIAAgcoEBMDKCm65BAgQIECAAAEB0DFAgAABAgQIEKhMQACsrOCWS4AAAQIECBAQAB0DBAgQIECAAIHKBATAygpuuQQIECBAgAABAdAxQIAAAQIECBCoTEAArKzglkuAAAECBAgQEAAdAwQIECBAgACBygQEwMoK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";
		byte[] b=base64.decodeBase64(str_base64);
		try {
			FileOutputStream fw=new FileOutputStream("g:\\test.png");
			fw.write(b);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}