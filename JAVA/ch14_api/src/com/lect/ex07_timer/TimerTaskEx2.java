package com.lect.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask {

	@Override
	public void run() {
		System.out.println("작업2 : 1초 후에 한번씩 수행될 예정인 TimerTask ※ ");
	}
}
