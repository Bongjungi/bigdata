package com.lect.ex01_string;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("ȫ�浿","010-9999-1234","05-22"),
				new Friend("������","010-9999-1111","04-22"),
				new Friend("������","010-9876-1111","05-24")};
		Scanner scanner= new Scanner(System.in);

		do {
			int k=0;
			System.out.print("�˻��� ��ȭ��ȣ ���ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�): ");
			String num=scanner.next();
			if(num.equalsIgnoreCase("x")) {
				break;
			}
			for(Friend friend : friends) {
				if(friend.getPhone().substring(friend.getPhone().lastIndexOf("-")+1).equals(num)) {
					System.out.println(friend);
				}else {
					k++;
				}
			}
			if(k==friends.length) {
				System.out.println("�ش� ��ȭ��ȣ�� ģ���� �����ϴ�.");
			}
		}while(true);
		scanner.close();
	}
}
