package memo;
public class Var {
	int i=2; //private, public 붙여도 void활용 결과는 똑같음.//만약 int i=2가 아니라 static i=2라면 void함수에 영향을 주는 i가 됌.
//	private int j=1; //변경하려면 settergetter이용. 고정은 맞는데 이용하고자 하는 클래스에서는 그 클래스에서만 값 변경 가능, final쓰면 이용하고자 하는 곳에서도 변경 불가능.
	
	public static void main(String[] args) {
//		i=4 함수밖에 i와 다름.
		int i=4; //새로운 i
		Var var = new Var();
		System.out.println(var.i);
		System.out.println(i);
	}
	
	
}
