package com.lect.ex01;

public class TestMain {
	public static void main(String[] args) {
		Actor actor= new Actor("�ں���");
		actor.outFire();
		actor.saveMan();
		actor.canCatchCriminal();
		actor.canSearch();
		actor.makePizza();
		actor.makeSpaghetti();
		System.out.println("----------------");
		IFireFighter park1= new Actor("�ҹ��");
		park1.outFire();
		park1.saveMan();
	}
}
