package com.lect.ex01_string;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999","010-8888-8888","010-6547-8888"};
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("ȸ���� ��ȭ��ȣ ���ڸ���?(���� �� x)");
			String searchTel = scanner.next();
			if(searchTel.equalsIgnoreCase("x")) {
				System.out.println("����");
				break;
			}
			int k=0;
			for(String temp : tels) {
				if(temp.substring(temp.lastIndexOf("-")+1).equals(searchTel)) {
					System.out.println(temp);
				}else {
					k++;
				}	
			}
			if(k==tels.length) {
				System.out.println("����");
			}
		}while(true);	
		scanner.close();
	}
}
