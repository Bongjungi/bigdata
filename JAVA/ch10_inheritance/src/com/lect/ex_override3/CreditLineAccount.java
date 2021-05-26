package com.lect.ex_override3;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine; //private long creditLine에 주입한 변수 creditLine을 넣어라.
	}

	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	@Override
	public void pay(String cardNo, int amount) {
		if (getCardNo().equals(cardNo)) {
			if(getBalance()>=amount) {
				setBalance(getBalance()-amount);
				System.out.printf("%s(%s)님 %d원 지불하여 잔액%d\n",getOwnerName(),getAccountNo(),amount,getBalance());
			}else if (getBalance()+creditLine >= amount) {
				creditLine = creditLine+ getBalance()-amount;
				setBalance(0);
				System.out.printf("%s님 잔액 %d 현재 한도액 %d\n", getOwnerName(),getBalance(), creditLine);
			} else
				System.out.printf("%s님 현재 한도 %d으로 한도 초과됨\n", getOwnerName(), creditLine);
		} else {
			System.out.println("올바른 카드번호를 입력하세요.");
		}

	}
}
