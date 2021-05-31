package com.lect.ex5_printWriter;

import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.OutputStream;
import java.io.PrintWriter;
//import java.io.Writer;
//printwriter는 혼자 써도 되고, output이나 writer의 보조로 써도 된다. \n다음줄로 가라 \r처음으로가라
public class Ex01 {
	public static void main(String[] args) {
//		OutputStream outputStream =null;
//		Writer writer =null;
		PrintWriter printWriter = null;
		try {
//			outputStream = new FileOutputStream("txtFile/outTest.txt");
//			printWriter = new PrintWriter(outputStream);
			
//			writer = new FileWriter("txtFile/outTest.txt");
//			printWriter = new PrintWriter(writer);
			
			printWriter = new PrintWriter("txtFile/outTest.txt");
			
			printWriter.print("안녕하세요\n반갑습니다.\n");
			printWriter.printf("%5s %3d %3d %5.1f\n","홍길동",100,99,99.5);
			printWriter.printf("%5s %3d %3d %5.1f\n","제갈공명",100,99,99.5);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		
		} finally {
			if(printWriter!=null) printWriter.close();
//			if(outputStream!=null)
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					System.out.println(e.getMessage());
//				}
		}
		
		
	}
}
