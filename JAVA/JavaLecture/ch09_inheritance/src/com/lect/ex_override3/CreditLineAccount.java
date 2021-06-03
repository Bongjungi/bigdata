package com.lect.ex_override3;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine; //private long creditLine�� ������ ���� creditLine�� �־��.
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
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ�%d\n",getOwnerName(),getAccountNo(),amount,getBalance());
			}else if (getBalance()+creditLine >= amount) {
				creditLine = creditLine+ getBalance()-amount;
				setBalance(0);
				System.out.printf("%s�� �ܾ� %d ���� �ѵ��� %d\n", getOwnerName(),getBalance(), creditLine);
			} else
				System.out.printf("%s�� ���� �ѵ� %d���� �ѵ� �ʰ���\n", getOwnerName(), creditLine);
		} else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���.");
		}

	}
}
