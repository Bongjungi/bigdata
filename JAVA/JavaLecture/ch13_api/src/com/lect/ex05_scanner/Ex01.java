package com.lect.ex05_scanner;
//next()//���ۿ� ó�� ������  whitespace�� �����ϰ� whitespace(����, \n, \t ��)���� whitespace���� ����Ѵ�.
//nextline() //���ۿ� \n�� ������ �ձ��� ���ϰ� ��ó�� �����ִ� \n�� ����
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ���? ");
		int age = scanner.nextInt();//"60"�Է�                                                                                       "60\n"����
		System.out.println("�Է��Ͻ� ���̴� "+age); //                        "60"���                             "\n"����
		System.out.println("�̸��� �Է��ϼ���: ");//                                                  "\n"����
		String name = scanner.next();//"ȫ  �浿"�Է�                                                                      "\nȫ  �浿\n"����
		System.out.println("�Է��Ͻ� �̸��� "+name);//                         "ȫ"���               "\n  �浿\n"����
		//scanner.nextLine();//�̰��Է��ϸ� �����۵�. �ֳ��ϸ� \n�浿�Է��ϰ� ���� \n�� ��� �����༭ �ʱ�ȭ�ȴٰ� ���� ��.
		                                                                
		System.out.println("�Է��Ͻ� �ּҴ�?");
		String address = scanner.nextLine();//�Է� ����.�̹� \n �浿�� ����.     "�浿"���              ����(���� \n���� ����)      
		System.out.println("�Է��Ͻ� �ּҴ� "+address);          
		System.out.println("�ϰ� ���� ����?");
		String kkk = scanner.nextLine(); //"kkk"�Է�                  								"kkk\n"����
		System.out.println(kkk);	//									"kkk"���                  ����
		scanner.close();
	}
}
