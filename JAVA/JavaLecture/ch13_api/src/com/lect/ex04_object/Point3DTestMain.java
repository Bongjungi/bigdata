package com.lect.ex04_object;

public class Point3DTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1= new Point3D(1, 2, 3);
		Point3D p2;
		Point3D p3= new Point3D(1,2,3);
		Point3D p4;
		p2=(Point3D)p1.clone();
		p4=p1;
		if(p1.equals(p2)) {
			System.out.println("������ǥ.");
		}else {
			System.out.println("�ٸ���ǥ.");
		}
		System.out.println("--------------------");
		if(p1.equals(p3)) {
			System.out.println("������ǥ.");
		}else {
			System.out.println("�ٸ���ǥ.");
		}
		System.out.println("--------------------");
		if(p1==p2) {
			System.out.println("�����ּ�.");
		}else {
			System.out.println("�ٸ��ּ�.");
		}
		System.out.println("--------------------");
		if(p1==p3) {
			System.out.println("�����ּ�.");
		}else {
			System.out.println("�ٸ��ּ�.");
		}
		System.out.println("--------------------");
		System.out.println(p1);
		System.out.println(p2);
		if(p1==p4) {
			System.out.println("�����ּ�.");
		}else {
			System.out.println("�ٸ��ּ�.");
		}
	}
	
}
