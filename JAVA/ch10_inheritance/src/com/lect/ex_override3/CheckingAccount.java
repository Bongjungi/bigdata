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
		//if(this.cardNo==cardNo) { ==�� ���� ���� ���ϴµ� String���� �ּҰ� ����ִ�.
		if(this.cardNo.equals(cardNo)) {
			if(getBalance()>=amount) {
				setBalance(getBalance()-amount);
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ�%d\n",getOwnerName(),getAccountNo(),amount,getBalance());
			}else
				System.out.printf("%s(%s)��  �ܾ�%d������ %d�� ���� �Ұ�\n",getOwnerName(),getAccountNo(),getBalance(),amount);
		}else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
}
