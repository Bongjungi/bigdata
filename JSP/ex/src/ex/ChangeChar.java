package ex;

import java.text.DecimalFormat;

//두개의 큰 소수 p,q.
//n=pq, fn=(p-1)(q-1), fn과 공개키 e는 서로소, find d (s.t) d*e=1modfn,

//공개키 : e, n
//비밀키 : d,p,q,fn

//ex) p=1009, q=991, e=23
public class ChangeChar {
	private static ChangeChar INSTANCE;
	public static ChangeChar getInstance() {
		if(INSTANCE==null) {
			INSTANCE= new ChangeChar();
		}
		return INSTANCE;
	}
	public String chChar(int e, int n, String str) {
		int ndegree = (int)Math.log10(n)+1;
		char[] dfformset = new char[ndegree];
		for(int i=0;i<dfformset.length;i++) {
			dfformset[i]='0';
		}
		String dfform=String.copyValueOf(dfformset);
		DecimalFormat df = new DecimalFormat(dfform);
		char[] charset = str.trim().replaceAll(" ","").toCharArray();//{I,l,o,v,e,y,o,u}
		char[] realcharset;
		if(charset.length%2==0) {
			realcharset=charset;
		}else {
			realcharset=new char[charset.length+1];
			for(int i=0;i<charset.length;i++) {
				realcharset[i]=charset[i];
			}
			realcharset[realcharset.length-1]='[';
		}
		//1~9는 숫자로 a=10,b=11 ...은 어떨지
		double[] intarr = new double[realcharset.length/2];
		for(int i=0;i<realcharset.length-1;i=i+2) {
			double tho=(int)realcharset[i];
			double one=(int)realcharset[i+1];
			intarr[i/2]=1000*tho+one;
		}
		String answer="";
		for(int i=0;i<intarr.length;i++) {
			double sum=1;
			for(int j=0;j<e;j++) {
				System.out.println(sum);
				sum*=intarr[i];
				sum%=n;
			}
			int newsum = (int)sum;
			String tempstr = df.format(newsum).toString();
			answer = answer.concat(tempstr);
		}
		return answer;
	}
	
}
