package com.lect.ex2_dataInputStreamDataOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex04_productList {
	public static void main(String[] args) {
		InputStream is = null;
		DataInputStream dis = null;
		ArrayList<Product> array = new ArrayList<Product>();
		try {
			is=new FileInputStream("txtFile/dataFile3.dat");
			dis=new DataInputStream(is);
			while(true) {
			Product product = new Product();
				product.setName(dis.readUTF());
				product.setPrice(dis.readInt());
				product.setPs(dis.readInt());
				array.add(product);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다.");
		} finally {
			try {
				if(dis!=null) {
					dis.close();
				}
				if(is!=null) {
					is.close();
					
				}
			}catch(Exception e) {
				
			}
		}
		for(int i=0; i<array.size(); i++) {
			System.out.println(array.get(i));
		}
		
	}
}
