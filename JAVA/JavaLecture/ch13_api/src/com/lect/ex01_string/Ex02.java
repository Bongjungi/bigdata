package com.lect.ex01_string;

public class Ex02 {
	public static void main(String[] args) {
		String str1="abcXabc";
		String str2=new String("ABCXabc");
		String str3="   ja  va   ";
		System.out.println("1. "+str1.concat(str2));//abcXabcABCXabc
		System.out.println("2. "+str1.substring(3));//3��°���� ������
		System.out.println("3. "+str1.substring(3, 6));//3��°���� 6��°�ձ���
		System.out.println("4. "+str1.length());//���ڿ�����7
		System.out.println("5. "+str1.toUpperCase());//��� �빮�ڷ�
		System.out.println("6. "+str1.toLowerCase());//��� �ҹ��ڷ�
		System.out.println("7. "+str1.charAt(2));// 2��° �ε����� ����
		System.out.println("8. "+str1.indexOf('b'));//���° �ε����� b�� ��ġ�ϴ°�
		System.out.println("9. "+str1.indexOf('d'));//������ -1 ����
		System.out.println("10. "+str1.indexOf('b', 3));//3��° �ε������� b�� ã�ƶ�
		System.out.println("11. "+str1.lastIndexOf('b'));//���������� b�� ã��
		System.out.println("12. "+str1.equals(str2));//str1�� str2�� ���� ����
		System.out.println("13. "+str1.equalsIgnoreCase(str2));//��ҹ��ڹ����ϰ� ���� ������
		System.out.println("14. "+str3.trim());//�¿� space ����     ja  va
		System.out.println("15. "+str1.replace('a', '��'));//a�� �ڷ� ����.
		System.out.println("16. "+str1.replace("abc","�ٲ�"));
		System.out.println("17. "+str1.replace("abc","�ٲ�"));
		System.out.println("���� str1= "+str1);
	}
}
