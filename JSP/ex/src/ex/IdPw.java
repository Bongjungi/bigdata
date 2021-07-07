package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdPw {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static IdPw INSTANCE;
	public static IdPw getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new IdPw();
		}
		return INSTANCE;
	}
	private IdPw() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//id 중복확인
	public int idConfirm(String id) {
		int result=0;
		String sql="SELECT * FROM IdPw WHERE ID=?";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(!rs.next()) {
				result=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int login(String id, String pw) {
		int result=0;
		String sql="SELECT * FROM IdPw WHERE ID=? AND PW=?";
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(!rs.next()) {
				result=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	//id에 맞는 oracle에 저장된 pw 가져오기
	public String pwget(String id) {
		String result=null;
		String sql="SELECT PW FROM IdPw WHERE ID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getString("pw");
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
		return result;
	}
	//id pw 삽입
	public int idpwinsert(String id, String pw) {
		int result=0;
		String sql="INSERT INTO IdPw VALUES (?,?)";
		Connection conn= null;
		PreparedStatement pstmt = null;
		try {
			conn=DriverManager.getConnection(url,"scott","tiger");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		IdPw ip = IdPw.getInstance();
		System.out.println(ip.login("aaa","1542032304672323"));
	}
}
