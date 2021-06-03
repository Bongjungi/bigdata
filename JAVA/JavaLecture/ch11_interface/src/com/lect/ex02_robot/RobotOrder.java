package com.lect.ex02_robot;

public class RobotOrder {
	public void action(Robot r) { //r의 현재 상태 Robot에는 아무것도 없다. 함수 적용을 위해 다른 상태로 변환시켜 주어야 한다. 그래서 instanceof를 사용한다. 
		if(r instanceof DanceRobot) { // instanceof - r의 형태가 DanceRobot인가.
			DanceRobot dr = (DanceRobot)r;
			dr.dance();
		
		}else if(r instanceof SingRobot) {
			SingRobot sr = (SingRobot)r;
			sr.sing();
		}else if(r instanceof DrawRobot) {
//			DrawRobot dr = (DrawRobot)r;
//			dr.draw();
			((DrawRobot) r).draw();
		}else {
			System.out.println("아무것도 못하는 로봇입니다.");
		}
	}
}
