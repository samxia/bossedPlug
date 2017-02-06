package com.xym.bossed.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CSV2JSON {

	public JSONArray change(File csvFile) throws IOException {
		csvFile = new File("C:\\Users\\xyg\\Desktop\\fpsj220106723176704.csv");
		@SuppressWarnings("resource")
		BufferedReader bufferedreader = new BufferedReader(new FileReader(
				csvFile));
		String str_line;
		JSONArray jsonArray = new JSONArray();
		ArrayList<String> list_key = new ArrayList<String>();// Store title for
														// josnarray use
		int lineNo = 0;
		while ((str_line = bufferedreader.readLine()) != null) {

			JSONObject jo=new JSONObject();
			String[] row = str_line.split(",");
			for (int i = 0; i < row.length; i++) {
				if (lineNo == 0) {
					list_key.add(row[i]);// add title
				} else {
                   jo.put(list_key.get(i),row[i]);
				}
			}
            if(lineNo>0)
            {
            	jsonArray.add(jo);
            }
			lineNo++;

		}
		return jsonArray;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new CSV2JSON().change(null).toString());

	}

}
