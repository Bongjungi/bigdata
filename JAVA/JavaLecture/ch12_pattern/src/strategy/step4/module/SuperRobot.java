package strategy.step4.module;

import strategy.step4.component.FlyYes;
import strategy.step4.component.KnifeLazerYes;
import strategy.step4.component.MissileYes;

public class SuperRobot extends Robot {
	public SuperRobot() {
		setFly(new FlyYes());
		//setFly(new FlyYes());로 대체 가능 물론 settergetter 필요. 
		setMissile(new MissileYes());
		setKnife(new KnifeLazerYes());
	}
	

}
