package com.lect.ex_final;

public class TestMain {
	public static void main(String[] args) {
		Animal animal =new Animal();
		animal.running();
		animal.running();
		animal.stop();
		Animal dog= new Dog(); //dog - Dog���� ������ Animal�� ����
		dog.running();
		dog.running();
		dog.stop();
		
	}
}
