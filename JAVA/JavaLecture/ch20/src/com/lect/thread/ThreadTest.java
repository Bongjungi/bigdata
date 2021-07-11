package com.lect.thread;

public class ThreadTest extends Thread { //implements Runnableµµ °°À½
	
	public int testNum = 0;
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i =0 ; i<10; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("================================");
				testNum++;
			}
			System.out.println("name : " + Thread.currentThread().getName()+ ", testNum = "+testNum);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
