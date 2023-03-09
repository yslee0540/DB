package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 화면DB연결.BbsVO;

public class BbsDAO {
	
	public BbsVO one(String no) {
		ResultSet rs = null;
		BbsVO bag = null;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			
			// 3. con부품으로 sql스트링에 있는 것 sql부품으로 만들기
			String sql = "select * from hr.BBS where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (rs.next()) {
				System.out.println("검색결과 있음");
				String no2 = rs.getString(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				
				bag = new BbsVO();
				bag.setNo(no2);
				bag.setTitle(title);
				bag.setContent(content);
				bag.setWriter(writer);
				
			} else {
				System.out.println("검색결과 없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}
	
	public void delete(String no) {
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			
			// 3. con부품으로 sql스트링에 있는 것 sql부품으로 만들기
			String sql = "delete from hr.BBS where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(String no, String content) {
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			
			// 3. con부품으로 sql스트링에 있는 것 sql부품으로 만들기
			String sql = "update hr.BBS set content = ? where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String no, String title, String content, String writer) {
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			
			// 3. con부품으로 sql스트링에 있는 것 sql부품으로 만들기
			String sql = "insert into hr.BBS values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//R빼고 인덱스 0부터 시작, 유일하게 db는 인덱스가 1부터 시작
			ps.setString(1, no);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, writer);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			ps.executeUpdate(); //insert, update, delete문만(실행결과가 int)
			System.out.println("4. SQL문 오라클로 보내기 성공");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("게시물 작성 실패");
		}
		

	}

}
