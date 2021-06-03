package com.lect.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is=null;
		try {
			is= new FileInputStream("txtFile/inTest.txt");
			byte[] bs = new byte[10];
			while(true) {
				int readByteCount = is.read(bs); // readByteCount -- 10(bs)->10(bs)->4(�ܿ�)->-1(����)
												//is.read(bs,1,4) - 10���߿� 1���� 4������ �����Ͷ�
				if(readByteCount==-1) {
					break;
				}
				for(byte b : bs) {
					System.out.print((char)b);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}
}

