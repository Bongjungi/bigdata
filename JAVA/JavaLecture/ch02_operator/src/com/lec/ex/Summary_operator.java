package com.lec.ex;

public class Summary_operator {
	public static void main(String[] args) {
		int n1=33, n2=10, m,n,s1=10,s2,s3; double k; boolean re1,re2;
		//int a1,a2,a3; a1=a2=a3=10; - ����
		//int a1=a2=a3;              - �Ұ���
		
		
		m=n1/n2; //33 ������ 10�� 3�̴�. 4����Ʈ ��Ʈ�� 4����Ʈ ��Ʈ�� ������ 4����Ʈ ��Ʈ�� ��µȴ�.
					// �׷��� ���� ���Ҷ� ����.
		k=(double)n1/n2; //33 ������ 10�� 3.3�̴�. 8����Ʈ ������ ���ڿ��� 8����Ʈ �Ǽ� ǥ���� �����ϴ�.
		n=n1%n2; // %�� �������� ���� �� ����.
		s2=s1++; //s3�� s1�� �ְ� s1�� �ϳ� ���� ��Ų��.
		s3=--s1; //s4�� s1�� �ְ� s1�� �ϳ� ���� ��Ų��.
		re1=n1!=n2; // n1�� n2�� �ٸ���.
		re2=n1==n2; // n1�� n2�� ����.
		String res=(n1==n2)?"����.":"�ٸ���."; //���׿�����
		// ��Ʈ������ &(And) |(Or) ^(Xor)
		
		System.out.printf("%d,%.2f,%d,%d,%d,%b,%b,%s",m,k,n,s2,s3,re1,re2,res);
		
		
		
		}
}
