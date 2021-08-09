package ex;

import java.text.DecimalFormat;

//�ΰ��� ū �Ҽ� p,q.
//n=pq, fn=(p-1)(q-1), fn�� ����Ű e�� ���μ�, find d (s.t) d*e=1modfn,

//����Ű : e, n
//���Ű : d,p,q,fn

//a00b01c02d03e04...
	//0811142104241420(iloveyou) --> 1542032304672323
public class RSAChangeChar {
	public static void main(String[] args) {
		String str="for1to10!@";
		int n=999919; //1009,991
		int e=23;
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
		//1~9�� ���ڷ� a=10,b=11 ...�� ���
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
		System.out.println(answer);
		
	}
}
