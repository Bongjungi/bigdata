package com.lect.ex1_square;
// ��Ű����, Ŭ������, ������, �������Լ�, �޼ҵ�, settergetter
//main(); Square s =new Square()
//        Square s1 =new Square(10)
public class Square {
	private int side;
	public Square() {//�������Լ� : return type�� ���� Ŭ������� ���� �Լ�  //public Ŭ������() - �� �Լ��� �����ϸ� �ڵ����� �ԷµǾ ���±����� �۵�����. 
		//������ ���콺 > source> generate constructor using superclass //���� �Ű����� �ְ� (public Square(����))���� �Ǵ� private Square�ϸ� �������Լ� �����ȵ�.
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���");
	}
	public Square(int side) {// �Ű����� �ִ� ������ �Լ��� �뵵 : ������ �ʱ�ȭ //������ ���콺 > source > generate constructor using field
		this.side =side; // side�� �Է��ϸ� �Լ� ���� side�� ���� �ν��ϰ� �� ���� Ŭ���� ���� side�� �ν��Ѵ�. 
                         // �׷��Ƿ� Ŭ������ side�� ����Ϸ��� this�� �����ش�.
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ���. side �ʱ�ȭ��");
	}
	public int area() {
		return side*side;
	}
	public void setSide(int side) {//Square s = new Square(); s.setside(10) s.getside()
		this.side=side;        //������ ���콺 > source > generate settergetter Ŭ�� ��������������������������������������������������������������
	}							//SetA �Է��� ctrl+ space �ڵ��ϼ�, sysout ctrl +space�� ����ϴ�.			
	public int getside() {//s.getside
		return side;		//SetG ��Ʈ�ѽ����̽�
	}

}
