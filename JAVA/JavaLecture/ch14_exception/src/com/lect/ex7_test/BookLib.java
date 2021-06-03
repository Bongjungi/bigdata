package com.lect.ex7_test;

import java.text.SimpleDateFormat;
import java.util.Date;
//main함수에서 scanner를 사용할 건데, main함수가 아닌 사용할 클래스에서 scanner를 사용한 다음에 '클래스에서 close를 하면 안된다' main의 scanner가 작동하지 않는다.- 시험해본적은 없는데.....
public class BookLib implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkoutDate;
	private byte state;
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	@Override
	public String toString() {
		String result = String.format("\"%s\"(%s), %s著", bookTitle,bookNo, writer);
		if(state ==STATE_NORMAL) {
			result+=" 대출가능";	
		}else if(state==STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E요일");
			result+=" 대출("+sdf.format(checkoutDate)+") 중";
		}
		return result;
	}
	@Override
	public void checkIn() throws Exception {
		if(state!=STATE_BORROWED) {
			throw new Exception("대출하지 않은 도서입니다.");
		}
		long diff = (new Date()).getTime()-checkoutDate.getTime();
		long day = diff/(24*60*60*1000);
		borrower=null;
		checkoutDate=null;
		state=STATE_NORMAL;
		if(day>14) {
			System.out.println("연체료 일일 100원 부가합니다.");
			System.out.printf("내셔야 할 연체료는 %d원\n",(day-14)*100);
		}else {
			System.out.println("\""+bookTitle+"\"이(가)  ★반납★되었습니다.");
		}
	}

	@Override
	public void checkOut(String borrower) throws Exception {
		if(state!=STATE_NORMAL) {
			throw new Exception("대출중인 도서입니다.");
		}
		this.borrower=borrower;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		String date=sdf.format(checkoutDate);
		state=STATE_BORROWED;
		System.out.println("\""+bookTitle+"\"이(가)  ★대출★되었습니다.");
		System.out.println("[대출인]"+borrower);
		System.out.println("[대출일]"+date);

	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	

}
