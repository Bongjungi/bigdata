//f=1,i=2,s=3
public class ExClass {
	public static void main(String[] args) {
		ExPublic pub=new ExPublic();
		ExPrivate priv = new ExPrivate();
		System.out.println(pub.f2);//final int
		System.out.println(pub.i2);//int
		System.out.println(ExPublic.s2);//static int
		System.out.println(priv.getF1());
		System.out.println(priv.getI1());
		System.out.println(ExPrivate.getS1());
		pub.i2+=1;
		ExPublic.s2+=1;
		System.out.println();
		System.out.println(pub.i2);
		System.out.println(ExPublic.s2);
		
		
		
	}
}
