package com.lect.ex2_dataInputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_dataOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			os= new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(os);
			dos.writeUTF("홍길동"); //스트링값 저장
			dos.writeInt(2); //int값 저장
			dos.writeDouble(95.9);//double값 저장
			
			dos.writeUTF("홍길동"); //처음 설정한 순서 중요. 처음에 스트링 인트 더블순으로 설정했으니 이대로 
			dos.writeInt(2); //
			dos.writeDouble(95.9);
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) {dos.close();}
				if(os!=null) {os.close();}
			}catch(Exception e) {
				
			}
		}
	}
}
