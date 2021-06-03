package com.lect.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//1.������ ����. 2.�����͸� ����. 3.������ �ݴ´�.
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os=null;
		try {
			os= new FileOutputStream("txtFile/outTest.txt"); //(1)������ ������ �ڵ����� ���������. �׷��� ������ �ڵ����� �� ���������.
			byte[] bs = {'H','H','H','H','H','\r','H','h'};
//			for(int i=0;i<bs.length;i++) {//(2)
//				os.write(bs[i]);
//			}
			os.write(bs);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(os!=null) {
				try {
					os.close();//(3)
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
