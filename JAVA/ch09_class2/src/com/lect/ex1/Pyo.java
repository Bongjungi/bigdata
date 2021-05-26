package com.lect.ex1;

public class Pyo {
	private String name;
	private int kor,eng,math,tot;
	private double avg;
	
	public Pyo(String name, int kor, int eng, int math) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		tot=kor+eng+math;
		avg=tot/3.0;
	}
	public Pyo() {}
	public void Info() {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f", name,kor,eng,math,tot,avg);
	}
	public String infoString() {
		return String.format("%s\t%d\t%d\t%d\t%d\t%.1f", name,kor,eng,math,tot,avg);
	}
	public void Gline(String c) {
		for(int i=1;i<=30;i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	public void line(char c) {
		for(int i=1;i<=30;i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
}
