package com.lect.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

//1.Ű����κ��� ����� �����̸��� �Է¹޽��ϴ�. (a.txt -> txtFile/a.txt)
//2.����ϰ��� �ϴ� ������ ���δ����� �ݺ������� �޽��ϴ�.(��, ������ ������ ������ x)
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer =null;
		String outMsg;
		System.out.println("���� �̸��� �Է����ּ��� : ");
		String filename=scanner.nextLine();
		try {
			writer = new FileWriter("txtFile/"+filename);
			while(true) {
				System.out.println("����ϰ��� �ϴ� ������ �Է����ּ��� : ");
				outMsg=scanner.nextLine();
				if(outMsg.equalsIgnoreCase("x")){
					break;
				}else {
					writer.write(outMsg+"\r\n");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		scanner.close();
	}
		
	
}

