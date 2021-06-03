package com.lect.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			String str = "안녕하세요\n히히";
			String str1="아무";
			writer.write(str);
			writer.write(str1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}	
	}
}