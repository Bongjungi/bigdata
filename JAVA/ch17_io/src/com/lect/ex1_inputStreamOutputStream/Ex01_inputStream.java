package com.lect.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//inputoutput - 1byte���� �̹��������� �� �����Ϳ�
//ReaderWriter - 2byte���� ���ڿ���




//1. ������ ����(��Ʈ����ü ����) 2. �����͸� �д´�(1����Ʈ ������ ���� ����) 3. ������ �ݴ´�.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try{
			is = new FileInputStream("txtFile/inTest.txt");//(1)
			//(2) 1byte�� �ݺ������� �д´�.
			while(true){
				int i = is.read(); //1byte�� �б�
				if(i==-1)break; //������ ������ ����  //������ ������ -1�� �ȴ�.
				System.out.print((char)i+"("+i+")");
			}	
			System.out.println("DONE");
		}catch(FileNotFoundException e) {
			System.out.println("���� �� ã�� " + e.getMessage());
		} catch (IOException e) {
			System.out.println("���� �� ���� " + e.getMessage());
		}finally {
			try {
				if(is!=null) {is.close();}//(3)
			} catch (IOException e) {
				
			}
		}
	}
}

