package com.lect.ex3_momChild;

public class ChildPouchTest {
	public static void main(String[] args) {
		ChildPouch child1=new ChildPouch("첫째똘만이");
		ChildPouch child2=new ChildPouch("둘째갑돌이");
		ChildPouch child3=new ChildPouch("셋째똘순이");
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		System.out.println(ChildPouch.momPouch.money); // momPouch는 child1,2,3가 아닌 ChildPouch에 들어있다.
	}
}
