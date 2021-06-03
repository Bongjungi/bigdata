package singleton.step1;

public class ATestMain {
	public static void main(String[] args) {
		AClass aClass1 = AClass.getInstance();
		AClass aClass2 = AClass.getInstance();
		if(aClass1!=aClass2) {
			System.out.println("두 객체의 주소가 다르다.");
		}
		aClass1.setIntVar(888);
		System.out.println(aClass1.getIntVar());
		System.out.println(aClass2.getIntVar());
	}
}
