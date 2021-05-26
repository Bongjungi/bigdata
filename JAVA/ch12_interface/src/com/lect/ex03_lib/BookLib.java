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
			System.out.println("대출중인 도서입니다.");
			return;
		}
		this.borrower=borrower;
		this.checkoutdate=checkoutdate;
		state=STATE_BORROWED;
		System.out.println(getBookTitle()+"대출 완료");
	}

	@Override
	public void checkIn() {
		if(state!=STATE_BORROWED) {
			System.out.println("대출 중인 도서가 아닙니다.");
			return;
		}
		state=STATE_NORMAL;
		System.out.println(getBookTitle()+"반납 완료");
	}
	public String toString() {
		String result = String.format("%s, %s저", getBookTitle(), getWriter());
//		result += state==STATE_NORMAL?"대출가능":"대출중";
		if(state ==STATE_NORMAL) {
			result+=" 대출가능";	
		}else if(state==STATE_BORROWED) {
			result+=" 대출중";
		}else {
			result+="직원문의(이상상태)";
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
