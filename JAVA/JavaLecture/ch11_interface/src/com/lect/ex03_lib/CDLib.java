package com.lect.ex03_lib;

public class CDLib extends CDInfo implements ILendable {
	private String borrower,checkoutdate;
	private byte state;
	public CDLib(String cdNo,String cdTitle,String bookNo) {
		super(cdNo,cdTitle,bookNo);
	}
	@Override
	public void checkOut(String borrower, String checkoutdate) {
		if(state!=STATE_NORMAL) {
			System.out.println("����Ұ����̿���");
			return;
		}
		this.borrower=borrower;
		this.checkoutdate=checkoutdate;
		state=STATE_BORROWED;
		System.out.println(getCdTitle()+"����Ǿ����ϴ�.");

	}

	@Override
	public void checkIn() {
		if(state!=STATE_BORROWED) {
			System.out.println("���� �����̿���");
			return;
		}
		borrower=null;
		checkoutdate=null;
		state=STATE_NORMAL;
		System.out.println(getCdTitle()+"�ݳ��Ǿ����ϴ�.");

	}
	public String toString() {
		String result = getCdTitle();
//		result += state==STATE_NORMAL?"���Ⱑ��":"������";
		if(state ==STATE_NORMAL) {
			result+=" ���Ⱑ��";	
		}else if(state==STATE_BORROWED) {
			result+=" ������";
		}else {
			result+="��������(�̻����)";
		}
		return result;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public String getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}

}
