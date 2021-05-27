package com.lect.myExample;
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
//영어, 한글 구별방법 스트링을 인트값으로 바꿀 때 아스키코드값이 다르다. 또한, byte수가 다르다.
//스트링 입력 시 인트로 바뀌면 숫자, 안 바뀌면 글자인듯.
