package memo;

public class Run {                                 
	private int i=1;               
//	i=2 �Ұ��� i=2�� ��������� ���� ����.
	

	public void function() {
		
		i=2;
		
	}
	public void function2() {
		i=3;
	//	int i=4;//�� �ȿ����� �ۿ��ϴ� ��Ʈ
	}
	public static void main(String[] args) {
		
		Run ex = new Run(); 
		System.out.println(ex.i);
		 ex.function();
		 System.out.println(ex.i);
		 ex.function2();
		 System.out.println(ex.i);
		 System.out.println(1);
		 System.out.println((char)164);
	}
}