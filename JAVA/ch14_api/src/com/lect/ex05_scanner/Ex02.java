package com.lect.ex05_scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ּ� �Է�: ");
		//scanner.nextLine(); �̰� ������ ó�� �Է��� �� ��������.
		String add = scanner.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ�:"+add);
		System.out.println("�̸��� �Է��ϼ���:");
		String name = scanner.nextLine();
		System.out.println("�Է��Ͻ� �̸���: "+name);
		scanner.close();
	}
}
