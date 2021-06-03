package com.lect.ex5_newException;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account(String accountNo, String ownerName, int balance) { //������ ���콺 > source > generate constructor using field
		this.accountNo=accountNo;
		this.ownerName=ownerName;
		this.balance=balance;
	}
	public Account(String accountNo, String ownerName) {
		this.accountNo=accountNo;
		this.ownerName=ownerName;
	}
	public Account(String accountNo) {
		this.accountNo=accountNo;
	}
	public Account() {}; //������ ���콺 > source> generate constructor using superclass
	
	
	public void deposit(int money) {
		this.balance+=money;
	}
	public void withdraw(int money) throws Exception{
		if(balance>=money) {
			balance-=money;
		}else {
			throw new Exception(money+"�� ����ϱ⿡�� �ܾ�("+balance+")�� �����մϴ�.");//Exception(String message);
		}//Exception�� ���� ���� : 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("���¹�ȣ�� %s, �����ִ� %s, �ܾ��� %d�Դϴ�.\n",getAccontNo(),getOwnerName(),getBalance());
	}
	
	
	//������ ���콺 > source > generate settergetter Ŭ�� ��������������������������������������������������������������
	public void setAccountNo(String accountNo) { //SetA �Է��� ctrl+ space �ڵ��ϼ�, sysout ctrl +space�� ����ϴ�.
		this.accountNo=accountNo;                
		// accountNo�� �Է��ϸ� �Լ� ���� accountNo�� ���� �ν��ϰ� �� ���� Ŭ���� ���� accountNo�� �ν��Ѵ�. 
		                                            // �׷��Ƿ� Ŭ������ accountNo�� ����Ϸ��� this�� �����ش�. 
	}
	public String getAccontNo() {//SetG ��Ʈ�ѽ����̽�
		return accountNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName=ownerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setBalance(int balance) {
		this.balance= balance;
	}
	public int getBalance() {
		return balance;
	}
	
}
