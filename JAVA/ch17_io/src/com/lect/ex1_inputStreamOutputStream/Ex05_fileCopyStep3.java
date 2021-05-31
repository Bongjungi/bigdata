package com.lect.ex1_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_fileCopyStep3 {
	public static void main(String[] args) {
		InputStream is=null;
		OutputStream os =null;
		try {
			File file = new File("D:/Bigdata/�ٿ�ε�.jpg");
			
			is= new FileInputStream("D:/Bigdata/�ٿ�ε�.jpg");
			os= new FileOutputStream("D:/Bigdata/�ٿ�ε�_copyed.jpg");
			int cnt = 0;
			while(true) {
				cnt++;
				byte[] bs=new byte[(int)file.length()];
				int readByteCount = is.read(bs);
				if(readByteCount==-1) {break;}
				os.write(bs, 0, readByteCount);
			}
			System.out.println(cnt+"�� while�� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(is!=null) {
					is.close();
				}
				if(os!=null) {
					os.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
}
