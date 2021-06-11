package com.lect.ex3insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


//1. 부서번호를 받아 해당부서번호가 있는지 조회
//2-1. 해당 부서번호가 있을 경우 : 중복된 부서번호입니다.출력
//2-2. 해당 부서번호가 없으면 : 부서명과 위치를 받아 insert합니다.

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null; 
		ArrayList<Integer> deptnoarr = new ArrayList<Integer>();
		String sql1 = "SELECT DEPTNO FROM DEPT"; 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				do { 
					int deptno1 = rs.getInt("deptno");
					deptnoarr.add(deptno1);
				}while(rs.next());
			}else {
				System.out.println("조회한 결과가 없습니다.");
			}
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("새로운 부서를 입력하시겠습니까?(Y/N)");
				String insert = sc.next();
				if(insert.equalsIgnoreCase("y")) {
					System.out.print("부서 번호는? : ");
					int deptno;
					do {
						try {
							deptno = sc.nextInt();
							break;
						}catch (Exception e) {
							System.out.println("수를 입력");
						}
					}while(true);
					int uniquesensor = 0;
					for(int i=0;i<deptnoarr.size();i++) {
						if(deptnoarr.get(i)==deptno) {
							uniquesensor=1;break;
						}
					}	
					if(uniquesensor==1) {
						System.out.println("중복된 부서번호입니다.");
					}else {
						System.out.println("입력할 부서명은? : ");
						String dname = sc.next();
						byte[]d =dname.getBytes(); //dname은 바이트로 바꿔서 집어넣는다.
						int firstletterascii = (int)d[0];
						if((firstletterascii>=65 && firstletterascii<=90)||(firstletterascii>=97 && firstletterascii<=122)) {
							if(dname.length()>14) {
								System.out.println("넘 길어");
								continue;
							}else {
								if(dname.length()>4) {
									System.out.println("넘 길어");
									continue;
								}
							}
						}
						System.out.println("입력할 부서의 위치는? : ");
						String loc = sc.next();
						String sql2 = String.format("INSERT INTO DEPT VALUES ('%d', '%s', '%s')", deptno, dname, loc);
						int result =stmt.executeUpdate(sql2);
						System.out.println(result==1?"부서추가성공":"부서추가실패");
					}	
				}else if(insert.equalsIgnoreCase("n")) {
					System.out.println("종료합니다.");break;
				}else {
					System.out.println("Y 또는 N을 입력해주세요.");
				}
			}while(true);
			
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+ " 드라이버 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(stmt!=null)stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
