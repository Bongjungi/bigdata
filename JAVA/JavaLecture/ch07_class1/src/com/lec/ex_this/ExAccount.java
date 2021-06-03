package com.lec.ex_this;

public class ExAccount {
	private String accountNo;
	private String ownerName;
	private int balance;
	public ExAccount(String accountNo, String ownerName, int balance) { //������ ���콺 > source > generate constructor using field
		this.accountNo=accountNo;
		this.ownerName=ownerName;
		this.balance=balance;
	}
	public ExAccount(String accountNo, String ownerName) {
		this.accountNo=accountNo;
		this.ownerName=ownerName;
	}
	public ExAccount(String accountNo) {
		this.accountNo=accountNo;
	}
	public ExAccount() {}; //������ ���콺 > source> generate constructor using superclass
	
	
	public void deposit(int money) {
		this.balance+=money;
	}
	public void withdraw(int money) {
		if(this.balance>=money) {
			this.balance-=money;
		}else {
			System.out.println("�ܾ��� �����մϴ�.�Ф�");
		}
	}
	public void info() {
		System.out.printf("���¹�ȣ�� %s, �����ִ� %s, �ܾ��� %d�Դϴ�.\n",this.getAccontNo(),this.getOwnerName(),this.getBalance());
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
