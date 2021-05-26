package com.lect.ex_override3;

public class CheckingAccount extends Account {
	private String cardNo;
	public CheckingAccount(String accountNo,String ownerName,String cardNo) {
		super(accountNo,ownerName);
		this.cardNo=cardNo;			
	}
	public CheckingAccount(String accountNo,String ownerName,int balance,String cardNo) {
		super(accountNo,ownerName,balance);
		this.cardNo=cardNo;
	}
	
	public void pay(String cardNo,int amount) {
		//if(this.cardNo==cardNo) { ==을 쓰면 값을 비교하는데 String에는 주소가 들어있다.
		if(this.cardNo.equals(cardNo)) {
			if(getBalance()>=amount) {
				setBalance(getBalance()-amount);
				System.out.printf("%s(%s)님 %d원 지불하여 잔액%d\n",getOwnerName(),getAccountNo(),amount,getBalance());
			}else
				System.out.printf("%s(%s)님  잔액%d원으로 %d원 지불 불가\n",getOwnerName(),getAccountNo(),getBalance(),amount);
		}else {
			System.out.println("올바른 카드번호를 입력하세요.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
}
