
public class Exex {                                 
	private int i=1;               
//	private static int j=1; 
	

	public void function() {
		
		i=2;
		
	}
	public void function2() {
		i=3;
	//	int i=4;//�� �ȿ����� �ۿ��ϴ� ��Ʈ
	}
	public static void main(String[] args) {
		Exex ex = new Exex(); 
		System.out.println(ex.i);
		 ex.function();
		 System.out.println(ex.i);
		 ex.function2();
		 System.out.println(ex.i);
	}
	
}
//private ���⼭�� ����.
//static Ŭ������ �����Ѵ�. Ŭ���������� �ϳ��� �����Ѵ�. ��� �����Ѵ�.
