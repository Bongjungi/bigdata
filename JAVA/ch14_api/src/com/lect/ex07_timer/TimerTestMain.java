package com.lect.ex07_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); //true - ���α׷��� ���� ���� ���� �����϶�. false�� ������ �����Ѵ�.
		TimerTask ex1 = new TimerTaskEx1();
		TimerTask ex2 = new TimerTaskEx2();
		timer.schedule(ex1, 2000);//2000ms=2s�Ŀ� ����
		timer.schedule(ex2,500,1000);//0.5���Ŀ� 1�ʸ��� ����
		Thread.sleep(10000); //10�ʴ�� - ���ܰ� �߻��� �� �־ ��������. �׷��� �����Ŵ�.(10�� ���� �߰ǵ� �����߻��ؼ� ������ �ڰų��ϸ� ����������)
		System.out.println("����");
			
	}
}
