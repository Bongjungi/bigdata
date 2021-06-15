package dtodao;

public class StudentDto {
	private String sno, sname,mname;
	private int score, mno, expel, rank;
	
	
	public StudentDto() {
	}
	
	public StudentDto(String sno, String sname, String mname, int score, int mno, int rank) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
		this.mno = mno;
		this.rank = rank;
	}

	public StudentDto(String sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	@Override
	public String toString() {
		if(rank==0) {
			return String.format("%s\t%s\t%s\t%d",sno,sname,mname,score);
		}else {
			return String.format("%dµî\t%s(%s)\t%s(%d)\t%d",rank,sname,sno,mname,mno,score);
		}
	}
	
	public int getRank() {
		return rank;
	}

	public String getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public String getMname() {
		return mname;
	}

	public int getScore() {
		return score;
	}

	public int getMno() {
		return mno;
	}

	public int getExpel() {
		return expel;
	}

	
}
