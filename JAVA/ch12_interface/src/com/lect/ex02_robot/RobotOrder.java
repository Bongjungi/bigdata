package com.lect.ex02_robot;

public class RobotOrder {
	public void action(Robot r) { //r�� ���� ���� Robot���� �ƹ��͵� ����. �Լ� ������ ���� �ٸ� ���·� ��ȯ���� �־�� �Ѵ�. �׷��� instanceof�� ����Ѵ�. 
		if(r instanceof DanceRobot) { // instanceof - r�� ���°� DanceRobot�ΰ�.
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
			System.out.println("�ƹ��͵� ���ϴ� �κ��Դϴ�.");
		}
	}
}
