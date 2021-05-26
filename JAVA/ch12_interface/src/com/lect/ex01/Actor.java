package com.lect.ex01;
//하나의 인터페이스로 여러 클래스를 만들수도 있고
//여러개의 인터페이스로 하나의 클래스를 만들수도 있고
//인터페이스로 클래스를 부품화할 수 있다.
public class Actor implements IChef, IFireFighter, IPoliceMan {
	private String name;
	public Actor(String name) {
		this.name=name;
	}
	@Override
	public void canCatchCriminal() {
		System.out.println(name+"은 범인을 잡을 수 있습니다.");
		
	}

	@Override
	public void canSearch() {
		System.out.println(name+"은 물건을 찾을 수 있습니다.");

	}

	@Override
	public void outFire() {
		System.out.println(name+"은 불을 끌 수 있습니다.");

	}

	@Override
	public void saveMan() {
		System.out.println(name+"은 사람을 살릴 수 있습니다.");
	}

	@Override
	public void makePizza() {
		System.out.println(name+"은 피자를 만들 수 있습니다.");

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"은 스파게티를 만들 수 있습니다.");

	}

}
