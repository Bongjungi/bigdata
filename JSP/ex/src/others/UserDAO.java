package others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static UserDAO INSTANCE;
	public static UserDAO getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new UserDAO();
		}
		return INSTANCE;
	}
	private UserDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int login(String userID, String userPassword) {
		String SQL= "SELECT PW FROM USER WHERE ID = ?";
		try {
			conn=DriverManager.getConnection(url);
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공	
				}else {
					return 0; //비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
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
		return -2; //데이터베이스 오류
	}
}
