package com.lect.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("쿠쿠");
		Timer timer = new Timer(true); //true - 프로그램이 구동 중일 때만 실행하라. false면 영원히 실행한다.
		TimerTask ex1 = new TimerTaskEx1();
		TimerTask ex2 = new TimerTaskEx2();
		timer.schedule(ex1, 2000);//2000ms=2s후에 실행
		timer.schedule(ex2,500,1000);//0.5초후에 1초마다 실행
		Thread.sleep(10000); //10초대기 - 예외가 발생할 수 있어서 에러난다. 그래서 던질거다.(10초 동안 잘건데 오류발생해서 영원히 자거나하면 던져버려라)
		System.out.println("히히");
			
	}
}
