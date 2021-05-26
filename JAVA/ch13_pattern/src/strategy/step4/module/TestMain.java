package strategy.step4.module;

import strategy.step4.component.FlyHigh;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new LowRobot()};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
			robot.actionRun();
			robot.actionWalk();
		}
		robots[0].setFly(new FlyHigh());
	}
}
