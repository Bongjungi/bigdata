package singleton.step2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonClass2=SingletonClass.getInstance();
		System.out.println("SecondClass�� ��ü ����");
		System.out.println(singletonClass2.getI());
		System.out.println("SecondClass ������ ��");
	}
	
}
