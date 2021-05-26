package com.lect.ex_final;

public class TestMain {
	public static void main(String[] args) {
		Animal animal =new Animal();
		animal.running();
		animal.running();
		animal.stop();
		Animal dog= new Dog(); //dog - Dog값을 따르는 Animal형 변수
		dog.running();
		dog.running();
		dog.stop();
		
	}
}
