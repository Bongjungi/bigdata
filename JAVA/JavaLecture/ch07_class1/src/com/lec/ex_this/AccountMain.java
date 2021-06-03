package com.lec.ex_this;



public class AccountMain {
	public static void main(String[] args) {
		ExAccount hong = new ExAccount("110-1","È«±æµ¿",10000);
		ExAccount hong1 = new ExAccount("110-1","È«ÀÏ");
		ExAccount hong2 = new ExAccount();
		hong2.setAccountNo("110-9");
		hong2.setOwnerName("½Å±æµ¿");
		hong.deposit(10000);
		hong.info();
		hong1.withdraw(1);
		hong1.info();
		hong2.deposit(10000);
		hong2.withdraw(2000);
		hong2.info();
		
		
	}

}
