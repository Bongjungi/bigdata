package com.lec.ex4_bank;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account(String accountNo, String ownerName, int balance) { //오른쪽 마우스 > source > generate constructor using field
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
	public Account() {}; //오른쪽 마우스 > source> generate constructor using superclass
	
	
	public void deposit(int money) {
		this.balance+=money;
	}
	public void withdraw(int money) {
		if(this.balance>=money) {
			this.balance-=money;
		}else {
			System.out.println("잔액이 부족합니다.ㅠㅠ");
		}
	}
	public void info() {
		System.out.printf("계좌번호는 %s, 예금주는 %s, 잔액은 %d입니다.\n",this.getAccontNo(),this.getOwnerName(),this.getBalance());
	}
	
	
	//오른쪽 마우스 > source > generate settergetter 클릭 끝ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	public void setAccountNo(String accountNo) { //SetA 입력후 ctrl+ space 자동완성, sysout ctrl +space랑 비슷하다.
		this.accountNo=accountNo;                
		// accountNo를 입력하면 함수 내의 accountNo를 먼저 인식하고 그 다음 클래스 내의 accountNo를 인식한다. 
		                                            // 그러므로 클래스의 accountNo를 사용하려면 this를 적어준다. 
	}
	public String getAccontNo() {//SetG 컨트롤스페이스
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
