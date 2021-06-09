package ex;

public class Triangle {
	public static void main(String[] args) {
		int num = 15;
		for(int i=1;i<=num;i++) {
			for(int j=num-1;j>=i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
/*   *
    * *
   * * *
  * * * *  */ 
