package ex;

import java.text.DecimalFormat;

//두개의 큰 소수 p,q.
//n=pq, fn=(p-1)(q-1), fn과 공개키 e는 서로소, find d (s.t) d*e=1modfn,

//공개키 : e, n
//비밀키 : d,p,q,fn

//a00b01c02d03e04...
	//0811142104241420(iloveyou) --> 1542032304672323
public class ChangeChar {
	private static ChangeChar INSTANCE;
	public static ChangeChar getInstance() {
		if(INSTANCE==null) {
			INSTANCE= new ChangeChar();
		}
		return INSTANCE;
	}
	public String chChar(int e, int n, String str) {
		//e=13 , n=2537
		int ndegree = (int)Math.log10(n)+1;
		char[] dfformset = new char[ndegree];
		for(int i=0;i<dfformset.length;i++) {
			dfformset[i]='0';
		}
		String dfform=String.copyValueOf(dfformset);
		DecimalFormat df = new DecimalFormat(dfform);
		String upperstr=str.toUpperCase().trim().replaceAll(" ", "");//"ILOVEYOU"
		char[] charset = upperstr.toCharArray();//{I,L,O,V,E,Y,O,U}
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
		int[] intarr = new int[realcharset.length/2];
		for(int i=0;i<realcharset.length-1;i=i+2) {
			int hun=(int)realcharset[i]-65;
			int one=(int)realcharset[i+1]-65;
			intarr[i/2]=100*hun+one;
		}
		String answer="";
		for(int i=0;i<intarr.length;i++) {
			int sum=1;
			for(int j=0;j<e;j++) {
				sum*=intarr[i];
				sum%=n;
			}
			String tempstr = df.format(sum).toString();
			answer = answer.concat(tempstr);
		}
		return answer;
	}
}
