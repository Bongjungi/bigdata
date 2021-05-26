package com.lect.ex7_test;

public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;
	public void checkIn() throws Exception;
	public void checkOut(String borrower) throws Exception;
}
