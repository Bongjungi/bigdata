package com.lect.ex2_dataInputStreamDataOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_productWrite {
	public static void main(String[] args) {
		OutputStream os =null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			os= new FileOutputStream("txtFile/dataFile3.dat",true);
			dos = new DataOutputStream(os);
			do {
				System.out.println("재고데이터 입력하시겠습니까?(Y|N)");
				String put = scanner.nextLine();
				if(put.equalsIgnoreCase("n")) {
					break;
				}else if(put.equalsIgnoreCase("y")) {
					System.out.println("물건명을 입력해주세요. : ");
					String name = scanner.nextLine();
					dos.writeUTF(name);
					System.out.println("가격을 입력해주세요. : ");
					int price = scanner.nextInt();
					dos.writeInt(price);
					
					System.out.println("개수를 입력해주세요. : ");
					int ps  = scanner.nextInt();
					dos.writeInt(ps);
					scanner.nextLine();
				}else {
					System.out.println("Y 또는 N을 입력해주세요.");
				}
			}while(true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos!=null) {dos.close();}
				if(os!=null) {os.close();}
			}catch(Exception e) {
				
			}
		}scanner.close();
		
	}
}
