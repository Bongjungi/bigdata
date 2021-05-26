package com.lect.ex02_robot;

public class TestMain {
	public static void main(String[] args) {
		RobotOrder order = new RobotOrder();
		DanceRobot danceRobot = new DanceRobot();
		DrawRobot drawRobot = new DrawRobot();
		SingRobot singRobot = new SingRobot();
		order.action(danceRobot);
		order.action(drawRobot);
		order.action(singRobot);
		Robot[] robot = {danceRobot, drawRobot, singRobot};
		for(Robot t : robot) {
			order.action(t);
		}
		System.out.println(danceRobot instanceof DanceRobot);
	}
}
