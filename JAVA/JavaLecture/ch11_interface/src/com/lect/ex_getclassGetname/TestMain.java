package com.lect.ex_getclassGetname;

public class TestMain {
	public static void main(String[] args) {
		IToy[] toy = {new Pooh(),new Mazinger(),new AirPlain()};
		for(IToy a : toy) {
			System.out.println(a.getClass().getName());
			System.out.println(a);
		}
		
	}
}
