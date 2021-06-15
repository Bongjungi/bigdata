package com.lect.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

//입력, 직업별 검색, 전체검색, 콤보박스에 들어갈 직업명리스트
//싱글톤클래스
public class PersonDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static PersonDao INSTANCE;
	private PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static PersonDao getinstance() {
		if(INSTANCE==null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	//1.입력
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		//로직 수행
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql="INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(conn!=null)pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "SELECT ROWNUM RANKING, S.* FROM (SELECT NAME||'('||P.JNO||')' NAMENO, JNAME, KOR, ENG, MAT, KOR+ENG+MAT ALLSUM FROM JOB J, PERSON P WHERE J.JNO=P.JNO AND JNAME=? ORDER BY KOR+ENG+MAT DESC) S";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int ranking = rs.getInt("ranking");
				String nameno = rs.getString("nameno");
//				jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int allsum = rs.getInt("allsum");
				dtos.add(new PersonDto(ranking,nameno,jname,kor,eng,mat,allsum));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
	}
	//3.전체 출력
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "SELECT ROWNUM RANKING, S.* FROM (SELECT NAME||'('||P.JNO||')' NAMENO, JNAME, KOR, ENG, MAT, KOR+ENG+MAT ALLSUM FROM JOB J, PERSON P WHERE J.JNO=P.JNO ORDER BY KOR+ENG+MAT DESC) S";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int ranking = rs.getInt("ranking");
				String nameno = rs.getString("nameno");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int allsum = rs.getInt("allsum");
				dtos.add(new PersonDto(ranking,nameno,jname,kor,eng,mat,allsum));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
	}
	//4.직업명들 리스트
	public Vector<String> jnamelist(){
		Vector<String> jnames = new Vector<String>();
		jnames.add("");
		Connection conn =null;
//		Statement stmt = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB ORDER BY JNO";
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jnames;
	}
}
