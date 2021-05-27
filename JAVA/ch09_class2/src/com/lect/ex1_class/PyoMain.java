package com.lect.ex1_class;

public class PyoMain {
	public static void main(String[] args) {
		Pyo[] pyo= {new Pyo("Á¤¿ì¼º",90,90,90), new Pyo("±èÇÏ´Ã",90,90,91), new Pyo("È²Á¤¹Î",80,80,80), new Pyo("°­µ¿¿ø",80,80,81), new Pyo("À¯¾ÆÀÎ",70,70,70)};
		Pyo pyo1= new Pyo();
		int[] tot =new int[5];
		double[] avg=new double[5];
		String[] title= {"ÀÌ¸§","±¹¾î","¿µ¾î","¼öÇÐ","ÃÑÁ¡","Æò±Õ"};
		
		pyo1.Gline("¡á");
		System.out.println("                 ¼ºÀûÇ¥");
		pyo1.line('-');
		for(String str:title) {
			System.out.print(str+"\t");
		}
		System.out.println();
		pyo1.line('-');
		for(Pyo a:pyo) {
			a.Info();
			tot[0]+=a.getKor();
			tot[1]+=a.getEng();
			tot[2]+=a.getMath();
			tot[3]+=a.getTot();
			tot[4]+=a.getAvg();
			System.out.println();
		}
		
		for(int idx=0;idx<avg.length;idx++) {
			avg[idx]=tot[idx]/5;
		}
		pyo1.line('-');
		System.out.printf("ÃÑÁ¡\t%d\t%d\t%d\t%d\t%d\n",tot[0],tot[1],tot[2],tot[3],tot[4]);
		System.out.printf("Æò±Õ\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\n",avg[0],avg[1],avg[2],avg[3],avg[4]);
//		System.out.print("ÃÑÁ¡");
		
////		for(int idx=0 ; idx<avg.length ; idx++) { // Æò±Õµé °è»ê
////			avg[idx] = tot[idx] / 5;
////			System.out.print("\t"+tot[idx]);
////		}
//		
//		System.out.print("\nÆò±Õ");
//		for(double a : avg) {
//			System.out.print("\t"+a);
//		}
//		System.out.println();
		pyo1.Gline("¡á");
		
	}
}
