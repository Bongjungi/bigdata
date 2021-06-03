package singleton.step2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonClass1=SingletonClass.getInstance();
		System.out.println("FirstClass屈 按眉 积己");
		System.out.println("贸澜篮 "+singletonClass1.getI());
		singletonClass1.setI(999);
		System.out.println("官槽 第 "+singletonClass1.getI());
		System.out.println("FirstClass 积己磊 场");
	}
}
