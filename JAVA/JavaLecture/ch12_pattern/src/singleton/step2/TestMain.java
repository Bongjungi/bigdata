package singleton.step2;


public class TestMain {
	public static void main(String[] args) {
		 new FirstClass();
		 System.out.println("--------------------------");
		 new SecondClass();
		 System.out.println("--------------------------");
		 SingletonClass singletonClass = SingletonClass.getInstance();
		 System.out.println("main 안에서의 singObj값은 "+singletonClass.getI()); 
		
	}
}  //main 끝나면 다시 주소값 사라진다???
