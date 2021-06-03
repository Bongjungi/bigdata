package com.lect.ex7_test;

import java.text.SimpleDateFormat;
import java.util.Date;
//main�Լ����� scanner�� ����� �ǵ�, main�Լ��� �ƴ� ����� Ŭ�������� scanner�� ����� ������ 'Ŭ�������� close�� �ϸ� �ȵȴ�' main�� scanner�� �۵����� �ʴ´�.- �����غ����� ���µ�.....
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
		String result = String.format("\"%s\"(%s), %s��", bookTitle,bookNo, writer);
		if(state ==STATE_NORMAL) {
			result+=" ���Ⱑ��";	
		}else if(state==STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E����");
			result+=" ����("+sdf.format(checkoutDate)+") ��";
		}
		return result;
	}
	@Override
	public void checkIn() throws Exception {
		if(state!=STATE_BORROWED) {
			throw new Exception("�������� ���� �����Դϴ�.");
		}
		long diff = (new Date()).getTime()-checkoutDate.getTime();
		long day = diff/(24*60*60*1000);
		borrower=null;
		checkoutDate=null;
		state=STATE_NORMAL;
		if(day>14) {
			System.out.println("��ü�� ���� 100�� �ΰ��մϴ�.");
			System.out.printf("���ž� �� ��ü��� %d��\n",(day-14)*100);
		}else {
			System.out.println("\""+bookTitle+"\"��(��)  �ڹݳ��ڵǾ����ϴ�.");
		}
	}

	@Override
	public void checkOut(String borrower) throws Exception {
		if(state!=STATE_NORMAL) {
			throw new Exception("�������� �����Դϴ�.");
		}
		this.borrower=borrower;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		String date=sdf.format(checkoutDate);
		state=STATE_BORROWED;
		System.out.println("\""+bookTitle+"\"��(��)  �ڴ���ڵǾ����ϴ�.");
		System.out.println("[������]"+borrower);
		System.out.println("[������]"+date);

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
