package singleton.step2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonClass1=SingletonClass.getInstance();
		System.out.println("FirstClass�� ��ü ����");
		System.out.println("ó���� "+singletonClass1.getI());
		singletonClass1.setI(999);
		System.out.println("�ٲ� �� "+singletonClass1.getI());
		System.out.println("FirstClass ������ ��");
	}
}
