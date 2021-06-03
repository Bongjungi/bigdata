package strategy.step3;

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
	}
}
