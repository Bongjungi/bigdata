package com.lect.ex4_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Customer> hashmap = new HashMap<String, Customer>();
		
		do{
			String join = null;
			System.out.println("ȸ������ �Ͻðڽ��ϱ�?[�� : Y |�ƴϿ� : N]");
			join = scanner.nextLine();
			if(join.equalsIgnoreCase("N")) {
				if(hashmap.isEmpty()) {
					System.out.println("���������� �����մϴ�.");
				}
				Iterator<String> iterator = hashmap.keySet().iterator();
				while(iterator.hasNext()) {
					String key = iterator.next();
					System.out.println(hashmap.get(key));
				}
				break;
			}else if(join.equalsIgnoreCase("Y")) {
				Customer customer = new Customer();
				System.out.println("�̸��� �Է��� �ּ��� : ");
				String n = scanner.nextLine();
				customer.setName(n);
				System.out.println("��ȭ��ȣ�� �Է��� �ּ��� : ");
				String t = scanner.nextLine();
				customer.setTel(t);
				System.out.println("�ּҸ� �Է��� �ּ��� : ");
				String a = scanner.nextLine();
				customer.setAddress(a);
				hashmap.put(t, customer);
				
			}else {
				System.out.println("Y �Ǵ� N�� �Է����ּ���.");
			}
		}while(true);
		
		scanner.close();
	}
}
