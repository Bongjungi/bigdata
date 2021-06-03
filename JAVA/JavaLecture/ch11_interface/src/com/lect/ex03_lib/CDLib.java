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
			System.out.println("대출불가능이에요");
			return;
		}
		this.borrower=borrower;
		this.checkoutdate=checkoutdate;
		state=STATE_BORROWED;
		System.out.println(getCdTitle()+"대출되었습니다.");

	}

	@Override
	public void checkIn() {
		if(state!=STATE_BORROWED) {
			System.out.println("대출 가능이에요");
			return;
		}
		borrower=null;
		checkoutdate=null;
		state=STATE_NORMAL;
		System.out.println(getCdTitle()+"반납되었습니다.");

	}
	public String toString() {
		String result = getCdTitle();
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
