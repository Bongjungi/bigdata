package memo;
public class Var {
	int i=2; //private, public �ٿ��� voidȰ�� ����� �Ȱ���.//���� int i=2�� �ƴ϶� static i=2��� void�Լ��� ������ �ִ� i�� ��.
//	private int j=1; //�����Ϸ��� settergetter�̿�. ������ �´µ� �̿��ϰ��� �ϴ� Ŭ���������� �� Ŭ���������� �� ���� ����, final���� �̿��ϰ��� �ϴ� �������� ���� �Ұ���.
	
	public static void main(String[] args) {
//		i=4 �Լ��ۿ� i�� �ٸ�.
		int i=4; //���ο� i
		Var var = new Var();
		System.out.println(var.i);
		System.out.println(i);
	}
	
	
}
