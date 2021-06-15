package com.lect.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao INSTANCE;
	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static StudentDao getinstance() {
		if(INSTANCE==null) {
			INSTANCE=new StudentDao();
		}
		return INSTANCE;
	}
	//학생입력
	public int insertstud(StudentDto dto) {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "INSERT INTO STUDENT (SNO, SNAME, SCORE, MNO) VALUES (CONCAT(SUBSTR(TO_CHAR(SYSDATE,'YYYY'),1,4),SUBSTR(TO_CHAR(STUDENT_SQ.NEXTVAL,'000'),2,3)),?,?,(SELECT MNO FROM MAJOR WHERE MNAME=?))";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getMname());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//학생수정
	public int updatestud(StudentDto dto) {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "UPDATE STUDENT SET SNAME=?,SCORE=?,MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?) WHERE SNO=?";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setInt(2, dto.getScore());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getSno());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//학생출력
	public ArrayList<StudentDto> printstud(){
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= "SELECT ROWNUM AS RANK, SNO, SNAME, MNAME, SCORE, MNO FROM (SELECT SNO, SNAME, MNAME, SCORE, S.MNO FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND S.EXPEL=0 ORDER BY SCORE DESC) S";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sno= rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				int mno = rs.getInt("mno");
				students.add(new StudentDto(sno, sname, mname, score, mno, rank));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
	//제적자출력
	public ArrayList<StudentDto> printdelstud(){
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= "SELECT ROWNUM AS RANK, SNO, SNAME, MNAME, SCORE, MNO FROM (SELECT SNO, SNAME, MNAME, SCORE, S.MNO FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND S.EXPEL=1 ORDER BY SCORE DESC) S";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sno= rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				int mno = rs.getInt("mno");
				students.add(new StudentDto(sno, sname, mname, score, mno, rank));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
	//제적처리
	public int deletestud(String sno1) {
		int result = 0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql = "UPDATE STUDENT SET EXPEL=1 WHERE SNO=?";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sno1);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//전공리스트
	public Vector<String> majorlist(){
		Vector<String> majors = new Vector<String>();
		majors.add("");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= "SELECT MNAME FROM MAJOR";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String mname = rs.getString("mname");
				majors.add(mname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return majors;
	}
	//학번검색
	public StudentDto searchsno(String sno1){
		StudentDto dto1 = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND SNO=?";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sno1);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dto1 = new StudentDto(sno, sname, mname, score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto1;
	}
	//이름검색
	public ArrayList<StudentDto> searchsname(String sname1){
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND SNAME=?";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sname1);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				students.add(new StudentDto(sno, sname, mname, score));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
	//전공검색
	public ArrayList<StudentDto> searchmaj(String mname1){
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND MNAME=? ORDER BY SCORE DESC";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mname1);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				students.add(new StudentDto(sno, sname, mname, score));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
}
