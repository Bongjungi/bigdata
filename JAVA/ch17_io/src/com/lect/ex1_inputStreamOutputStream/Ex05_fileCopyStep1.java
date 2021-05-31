package com.lect.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is=null;
		OutputStream os =null;
		try {
			is= new FileInputStream("D:/Bigdata/다운로드.jpg");
			os= new FileOutputStream("D:/Bigdata/다운로드_copyed.jpg");
			int cnt = 0;
			while(true) {
				cnt++;
				int i=is.read();
				if(i==-1) {
					break;
				}
				os.write(i);
			}
			System.out.println(cnt+"번 while문 실행");
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
