package ex;

import java.util.ArrayList;


public class ReturnChar {
	private static ReturnChar INSTANCE;
	public static ReturnChar getInstance() {
		if(INSTANCE==null) {
			INSTANCE= new ReturnChar();
		}
		return INSTANCE;
	}
	public String reChar(int p, int q, int e, String m) {
		int d = findD(e,p,q); int n=p*q;
		int degree = (int)Math.log10(n)+1;
		ArrayList<String> divm = new ArrayList<String>();
		for(int i=0;i<m.length();i=i+degree) {
			divm.add(m.substring(i,i+degree));
		}
		ArrayList<Integer> intdivm = new ArrayList<Integer>();
		for(int i=0;i<divm.size();i++) {
			intdivm.add(Integer.parseInt((divm.get(i))));
		}
		
		ArrayList<Integer> Cintdivm = new ArrayList<Integer>();
		for(int i=0;i<intdivm.size();i++) {
			int temp=1;int temp2=intdivm.get(i);
			for(int j=0;j<d;j++) {
				temp=(temp*temp2)%n;
			}
			int hun=temp/100;
			int one=temp%100;
			Cintdivm.add(hun);
			Cintdivm.add(one);
		}
		char[] charset = new char[Cintdivm.size()];
		for(int i=0;i<charset.length;i++) {
			charset[i]=(char)(Cintdivm.get(i)+65);
		}
		return String.valueOf(charset);
	}
	public static int findD(int e, int p, int q) {
		int d=0;int L=(p-1)*(q-1);
		ArrayList<Integer> pset = new ArrayList<Integer>();//[p1,p2,p3...,pn]
		ArrayList<Integer> qset = new ArrayList<Integer>();//[L,e,q1,q2,q3...qn]
		ArrayList<Integer> vset = new ArrayList<Integer>();//[0,1,..vn=pn*vn+1-vn+2..]
		qset.add(L);qset.add(e);vset.add(0);vset.add(1);
		int tempp=0, tempq=0;
		for(int i=0;i<qset.size();i++) {
			tempp=qset.get(i)/qset.get(i+1)+1;
			tempq=qset.get(i+1)-qset.get(i)%qset.get(i+1);
			pset.add(tempp);qset.add(tempq);
			if(tempq==1)break;
		}
		for(int i=pset.size()-1;i>=0;i--) {
			int tempv=pset.get(i)*vset.get(pset.size()-i)-vset.get(pset.size()-i-1);
			vset.add(tempv);
		}
		d=vset.get(vset.size()-1);
		return d;
	}
}
