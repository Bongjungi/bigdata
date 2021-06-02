package com.lect.ex01_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		do {
			System.out.println("전화번호를 입력하시오: ");
			String tel = sc.next();
			if(tel.equalsIgnoreCase("x")) {
				System.out.println("종료");
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
			System.out.println(tel.substring(0, tel.indexOf("-")));//전화번호 앞자리
			System.out.println(tel.substring(tel.lastIndexOf("-")+1));//전화번호 뒷자리
		}while(true);
		sc.close();
		
	}
}
