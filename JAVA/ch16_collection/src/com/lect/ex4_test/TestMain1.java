package com.lect.ex4_test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> array= new ArrayList<Customer>();
		
		do{
			String join = null;
			System.out.println("ȸ������ �Ͻðڽ��ϱ�?[�� : Y |�ƴϿ� : N]");
			try{
				join = scanner.nextLine();
			}catch(Exception e) {
				System.out.println("Y �Ǵ� N�� �Է����ּ���."); 
			}
			if(join.equalsIgnoreCase("N")) {
				if(array.isEmpty()) {
					System.out.println("���������� �����մϴ�.");
				}
				for(int i=0; i<array.size(); i++) {
					System.out.println(array.get(i));
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
				array.add(customer);
				
			}else {
				System.out.println("Y �Ǵ� N�� �Է����ּ���.");
			}
		}while(true);
		
		scanner.close();
	}
}
