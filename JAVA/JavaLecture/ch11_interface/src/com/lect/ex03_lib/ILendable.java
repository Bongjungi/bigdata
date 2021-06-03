package com.lect.ex03_lib;

public interface ILendable {
	public byte STATE_BORROWED=1;
	public byte STATE_NORMAL=0;
	public void checkOut(String borrower, String checkoutdate);
	public void checkIn();
	public String toString();
	
	
}
