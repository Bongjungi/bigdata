package com.lect.ex_constructor;

public class TestMain {
	public static void main(String[] args) {
		SuperIJ sup= new SuperIJ(1,2);
		System.out.println();
		Child child=new Child(10,20); //superij�� default������ ������ ���� �߻�
		                              //��ӹ���Child�� �����ϱ� ���� SuperIJ�����ڸ� ���� �����Ѵ�.
		System.out.println();
		SuperIJ odin=new Child(100,200);
		System.out.println(sup.getI());
		System.out.println(sup.getJ());
		System.out.println(child.getI());
		System.out.println(child.getJ());
		System.out.println(odin.getI());
		System.out.println(odin.getJ());
		
		child.sum();
//		odin.sum() �Ұ��� SuperIJ odin���� sum�� ����.
		
	}
}
