package ex;

public class Hcf {
	public static void main(String[] args) {
		System.out.println(hcf(16,12));
	}
	public static int hcf(int a, int b) {
	    while (b != 0) {
	      int temp = a % b;
	      a = b;
	      b = temp;
	    }
	    return Math.abs(a);
	}
	
}
