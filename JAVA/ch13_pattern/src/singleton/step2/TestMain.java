package singleton.step2;


public class TestMain {
	public static void main(String[] args) {
		 new FirstClass();
		 System.out.println("--------------------------");
		 new SecondClass();
		 System.out.println("--------------------------");
		 SingletonClass singletonClass = SingletonClass.getInstance();
		 System.out.println("main �ȿ����� singObj���� "+singletonClass.getI()); 
		
	}
}  //main ������ �ٽ� �ּҰ� �������???
