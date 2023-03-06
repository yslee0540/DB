package 자바DB연결;

import java.sql.DriverManager;

public class DB연결테스트 {

	public static void main(String[] args) {
		try {
			// 1. 오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			// 2. 오라클 11g애 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
