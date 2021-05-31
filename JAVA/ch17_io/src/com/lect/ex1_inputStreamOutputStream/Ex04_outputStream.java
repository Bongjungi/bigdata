package com.lect.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os=null;
		try {
			os= new FileOutputStream("txtFile/outTest.txt",true);//true:±âÁ¸ ÆÄÀÏ¿¡ append, false(±âº»°ª):±âÁ¸ ÆÄÀÏ¿¡ µ¤¾î¾¸.
			String str = "\nÇÑ±Û\nÄíÄíÄíÄíÄíÄíÄíÄíÄíÄí";
			byte[] bs = str.getBytes();
			os.write(bs);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(os!=null) {try {
				os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			}
		
		}
	}
}
