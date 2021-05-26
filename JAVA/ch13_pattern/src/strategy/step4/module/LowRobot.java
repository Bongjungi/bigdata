package strategy.step4.module;

import strategy.step4.component.FlyNo;
import strategy.step4.component.KnifeNo;
import strategy.step4.component.MissileNo;

public class LowRobot extends Robot {
	
	public LowRobot() {
		setFly(new FlyNo()); 
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	

	

}
