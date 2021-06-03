package com.lect.ex_override3;

public class Account {
	private String accountNo,ownerName;
	private int balance;
	public Account() {};
	public Account(String accountNo, String ownerName) {
		this.accountNo=accountNo;
		this.ownerName=ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposit(int amount) {
		balance+=amount;
		System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ�%d\n",ownerName,accountNo,amount,balance);
	}
	public void withdraw(int amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ�%d\n",ownerName,accountNo,amount,balance);
		}else {
			System.out.printf("%s(%s)��  �ܾ�%d������ %d�� ���� �Ұ�\n",ownerName,accountNo,balance,amount);
		}
	}
	@Override
	public String toString() {
		return String.format("%s(%s)���� �ܾ��� %d",ownerName,accountNo,balance);
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
