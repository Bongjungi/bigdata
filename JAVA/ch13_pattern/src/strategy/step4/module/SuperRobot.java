package strategy.step4.module;

import strategy.step4.component.FlyYes;
import strategy.step4.component.KnifeLazerYes;
import strategy.step4.component.MissileYes;

public class SuperRobot extends Robot {
	public SuperRobot() {
		setFly(new FlyYes());
		//setFly(new FlyYes());�� ��ü ���� ���� settergetter �ʿ�. 
		setMissile(new MissileYes());
		setKnife(new KnifeLazerYes());
	}
	

}
