package com.lect.ex01_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		do {
			System.out.println("��ȭ��ȣ�� �Է��Ͻÿ�: ");
			String tel = sc.next();
			if(tel.equalsIgnoreCase("x")) {
				System.out.println("����");
				break;
			}
			System.out.println(tel);
			for(int i=1;i<tel.length();i+=2) {
				System.out.print(tel.charAt(i));
			}
//			for(int i=0 ; i<tel.length() ; i++) {
//				if(i%2 !=0) {
//					System.out.print(tel.charAt(i));
//				}else {
//					System.out.print(' ');
//				}
//			}
			System.out.println();
			for(int j=tel.length()-1;j>=0;j--) {
				System.out.print(tel.charAt(j));
			}
			System.out.println();
			System.out.println(tel.substring(0, tel.indexOf("-")));//��ȭ��ȣ ���ڸ�
			System.out.println(tel.substring(tel.lastIndexOf("-")+1));//��ȭ��ȣ ���ڸ�
		}while(true);
		sc.close();
		
	}
}
