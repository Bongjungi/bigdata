package strategy.step3;

public class SuperRobot extends Robot {

	@Override
	public void actionFly() {
		System.out.println("날 수 있다.");

	}

	@Override
	public void actionMissile() {
		System.out.println("쏠 수 있다.");

	}

	@Override
	public void actionKnife() {
		System.out.println("레이저 검 사용한다.");

	}

}
