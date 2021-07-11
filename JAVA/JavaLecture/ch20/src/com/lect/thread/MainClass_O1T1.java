package com.lect.thread;
//testNum °øÀ¯X
public class MainClass_O1T1 {
	public static void main(String[] args) {
		ThreadTest ts0 = new ThreadTest();
		ThreadTest ts1 = new ThreadTest();
		Thread td0 = new Thread(ts0, "A");
		Thread td1 = new Thread(ts1, "B");
		td0.start();
		td1.start();
		System.out.println(Thread.currentThread().getName());
		
	}
}
