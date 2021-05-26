package com.lect.ex03_lib;

public class BookLib extends BookInfo implements ILendable {
	private String borrower, checkoutdate;
	private byte state;
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo,bookTitle,writer);
	}
	@Override
	public void checkOut(String borrower, String checkoutdate) {
		if(state!=STATE_NORMAL) {
			System.out.println("�������� �����Դϴ�.");
			return;
		}
		this.borrower=borrower;
		this.checkoutdate=checkoutdate;
		state=STATE_BORROWED;
		System.out.println(getBookTitle()+"���� �Ϸ�");
	}

	@Override
	public void checkIn() {
		if(state!=STATE_BORROWED) {
			System.out.println("���� ���� ������ �ƴմϴ�.");
			return;
		}
		state=STATE_NORMAL;
		System.out.println(getBookTitle()+"�ݳ� �Ϸ�");
	}
	public String toString() {
		String result = String.format("%s, %s��", getBookTitle(), getWriter());
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
