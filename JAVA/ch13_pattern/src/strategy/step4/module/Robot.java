package strategy.step4.module;

import strategy.step4.component.FlyImpl;
import strategy.step4.component.KnifeImpl;
import strategy.step4.component.MissileImpl;

public class Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	public void shape() {
		System.out.println(getClass().getName()+"�� ��, �ٸ�, �Ӹ�, �������� �̷���� �ִ�.");
	}
	public void actionWalk() {
		System.out.println("���� �� �ִ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ִ�.");
	}
	public void actionFly() {
		fly.fly();}
	public void actionMissile() {
		missile.Missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	public FlyImpl getFly() {
		return fly;
	}
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}
	public MissileImpl getMissile() {
		return missile;
	}
	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}
	public KnifeImpl getKnife() {
		return knife;
	}
	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
	
}
