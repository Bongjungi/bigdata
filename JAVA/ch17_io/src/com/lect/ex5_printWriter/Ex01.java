package com.lect.ex5_printWriter;

import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.OutputStream;
import java.io.PrintWriter;
//import java.io.Writer;
//printwriter�� ȥ�� �ᵵ �ǰ�, output�̳� writer�� ������ �ᵵ �ȴ�. \n�����ٷ� ���� \ró�����ΰ���
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
			
			printWriter.print("�ȳ��ϼ���\n�ݰ����ϴ�.\n");
			printWriter.printf("%5s %3d %3d %5.1f\n","ȫ�浿",100,99,99.5);
			printWriter.printf("%5s %3d %3d %5.1f\n","��������",100,99,99.5);
			
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
