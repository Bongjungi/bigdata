package com.lect.ex1person;
//ranking, nameno, jname, kor, eng, mat, allsum
public class PersonDto {
	private int ranking;
	private String nameno;
	private String jname;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int allsum;
	
	public PersonDto(String jname, String name, int kor, int eng, int mat) {
		this.jname = jname;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public PersonDto(int ranking, String nameno, String jname, int kor, int eng, int mat, int allsum) {
		this.ranking = ranking;
		this.nameno = nameno;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.allsum = allsum;
	}
	@Override
	public String toString() {
		return String.format("%d\t%s\t%s\t%d\t%d\t%d\t%d", ranking,nameno,jname,kor,eng,mat,allsum);
	}
	public int getRanking() {
		return ranking;
	}

	public String getNameno() {
		return nameno;
	}

	public String getJname() {
		return jname;
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

	public int getMat() {
		return mat;
	}

	public int getAllsum() {
		return allsum;
	}
	
	
}
