package com.lect.ex01;

public class TestMain {
	public static void main(String[] args) {
		Actor actor= new Actor("박보검");
		actor.outFire();
		actor.saveMan();
		actor.canCatchCriminal();
		actor.canSearch();
		actor.makePizza();
		actor.makeSpaghetti();
		System.out.println("----------------");
		IFireFighter park1= new Actor("소방관");
		park1.outFire();
		park1.saveMan();
	}
}
