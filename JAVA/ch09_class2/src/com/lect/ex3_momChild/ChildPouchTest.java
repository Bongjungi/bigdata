package com.lect.ex3_momChild;

public class ChildPouchTest {
	public static void main(String[] args) {
		ChildPouch child1=new ChildPouch("ù°�ʸ���");
		ChildPouch child2=new ChildPouch("��°������");
		ChildPouch child3=new ChildPouch("��°�ʼ���");
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		System.out.println(ChildPouch.momPouch.money); // momPouch�� child1,2,3�� �ƴ� ChildPouch�� ����ִ�.
	}
}
