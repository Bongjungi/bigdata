package com.lect.ex;

public class MainClass_syn {
	public static void main(String[] args) {
		ThreadTest_syn ts = new ThreadTest_syn();
		Thread td0 = new Thread(ts, "A");
		Thread td1 = new Thread(ts, "B");
		td0.start();
		td1.start();
		System.out.println(Thread.currentThread().getName());
	}
}
