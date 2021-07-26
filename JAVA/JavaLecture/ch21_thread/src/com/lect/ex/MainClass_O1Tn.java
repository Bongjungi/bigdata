package com.lect.ex;

public class MainClass_O1Tn {
	public static void main(String[] args) {
		ThreadTest ts = new ThreadTest();
		Thread td0 = new Thread(ts, "A");
		Thread td1 = new Thread(ts, "B");
		td0.start();
		td1.start();
		System.out.println(Thread.currentThread().getName());
		
	}
}
