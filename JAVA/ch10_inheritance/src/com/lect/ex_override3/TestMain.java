package com.lect.ex_override3;

public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-1111","ȫ�浿");
		Account a4 =new Account("111-1111","ȫ�浿");
		CheckingAccount a2 = new CheckingAccount("222-2222", "������", 2000, "1234-1234-1234-1323");
		CheckingAccount a3 = new CreditLineAccount("333-2222", "������", 2000, "1234-1234-1234-9999", 10000);
		a1.deposit(3000);
		a2.withdraw(200);
		a3.deposit(3000);
		System.out.println(a1);
		a2.pay("1234-1234-1234-1323", 200);
		a3.pay("1234-1234-1234-1323", 5000);
		a3.pay("1234-1234-1234-9999", 6000);
		
		
		
		
		int i=10,j=10;
		if(i==j) {
			System.out.println("i��j�� ����.");
		}
		System.out.println((a1.equals(a4))?"a1�� a2�� ��ü�� ����.":"a1�� a4�� ��ü�� �ٸ���.");
	}
}
