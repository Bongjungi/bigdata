package singleton.step2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonClass2=SingletonClass.getInstance();
		System.out.println("SecondClass屈 按眉 积己");
		System.out.println(singletonClass2.getI());
		System.out.println("SecondClass 积己磊 场");
	}
	
}
