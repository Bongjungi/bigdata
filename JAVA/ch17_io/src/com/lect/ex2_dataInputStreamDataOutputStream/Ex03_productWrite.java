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
				System.out.println("������� �Է��Ͻðڽ��ϱ�?(Y|N)");
				String put = scanner.nextLine();
				if(put.equalsIgnoreCase("n")) {
					break;
				}else if(put.equalsIgnoreCase("y")) {
					System.out.println("���Ǹ��� �Է����ּ���. : ");
					String name = scanner.nextLine();
					dos.writeUTF(name);
					System.out.println("������ �Է����ּ���. : ");
					int price = scanner.nextInt();
					dos.writeInt(price);
					
					System.out.println("������ �Է����ּ���. : ");
					int ps  = scanner.nextInt();
					dos.writeInt(ps);
					scanner.nextLine();
				}else {
					System.out.println("Y �Ǵ� N�� �Է����ּ���.");
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
