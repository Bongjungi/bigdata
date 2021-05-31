package com.lect.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//inputoutput - 1byte단위 이미지동영상 등 데이터용
//ReaderWriter - 2byte단위 문자열용




//1. 파일을 연다(스트림객체 생성) 2. 데이터를 읽는다(1바이트 단위로 읽을 예정) 3. 파일을 닫는다.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try{
			is = new FileInputStream("txtFile/inTest.txt");//(1)
			//(2) 1byte씩 반복적으로 읽는다.
			while(true){
				int i = is.read(); //1byte씩 읽기
				if(i==-1)break; //파일이 끝인지 여부  //읽을게 없으면 -1이 된다.
				System.out.print((char)i+"("+i+")");
			}	
			System.out.println("DONE");
		}catch(FileNotFoundException e) {
			System.out.println("파일 못 찾음 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 못 읽음 " + e.getMessage());
		}finally {
			try {
				if(is!=null) {is.close();}//(3)
			} catch (IOException e) {
				
			}
		}
	}
}

