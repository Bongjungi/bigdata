package com.lect.ex5_newException;



public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("110-1","È«±æµ¿",10000);
		Account hong1 = new Account("110-1","È«ÀÏ");
		Account hong2 = new Account();
		hong2.setAccountNo("110-9");
		hong2.setOwnerName("½Å±æµ¿");
		hong.deposit(10000);
		try {
			hong.withdraw(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		hong2.deposit(10000);
		try {
			hong1.withdraw(200000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hong);
		System.out.println(hong1);
		System.out.println(hong2);
	}
}
