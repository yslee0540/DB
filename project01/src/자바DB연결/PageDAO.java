package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;


public class PageDAO {
	
	
	public int update(PageVO bag) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE hr.MEMBER_T SET NICKNAME=?, LET=? WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getNICKNAME());
			ps.setString(2, bag.getLET());
			ps.setString(3, bag.getID());
			result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("수정 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(PageVO bag) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "delete from hr.MEMBER_T where ID =? and PW =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getID());
			ps.setString(2, bag.getPW());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result >= 1) {
				System.out.println("삭제 성공");
			}
			// System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public PageVO one(String id) {
		ResultSet rs = null; 
		PageVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2. 오라클 연결 성공.");
			
		
			String sql = "select * from hr.MEMBER_T where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery(); //select문 전송시  
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if(rs.next()) { 
				System.out.println("검색결과 있음. 성공.");
				String id2 = rs.getString(1); //id
				String NICKNAME = rs.getString(4); //pw
				String LET = rs.getString(5); //name
				//검색결과를 검색화면 UI부분을 주어야 함.
				bag = new PageVO();
				bag.setID(id2);
				bag.setNICKNAME(NICKNAME);
				bag.setLET(LET); 
				System.out.println(bag);
			}else {
				System.out.println("검색결과 없음. 성공.");
			}
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bag;
		
	}
	
	
		
	
	
}
