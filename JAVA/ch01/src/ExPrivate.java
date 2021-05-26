
public class ExPrivate {
	private int i1=2;
	private final int f1=1;
	private static int s1=3;
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public static int getS1() {
		return s1;
	}
	public static void setS1(int s1) {
		ExPrivate.s1 = s1;
	}
	public int getF1() {
		return f1;
	}
	
}
