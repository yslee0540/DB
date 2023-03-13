package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StarDao {
	public int set(StarVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			String sql = "insert into hr.STAR_T values (?, null, null, 0, 0, ?)"; // no, star, comment, pick. read, id
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("셋팅 성공!");
			}
			// System.out.println(result);
		} catch (Exception e) {
			// result = 0;
			// System.out.println(result);
			e.printStackTrace();
		}
		return result;
	}
	public int update(StarVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			String sql = "UPDATE hr.STAR_T  SET STAR =?, \"COMMENT\" = ? WHERE \"NO\"  =? AND  ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getStar());
			ps.setString(2, bag.getComment());
			ps.setInt(3, bag.getNo());
			ps.setString(4, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("평가 수정 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateStar(StarVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			String sql = "UPDATE hr.STAR_T  SET pick =1 WHERE \"NO\"  =? AND  ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("평가 수정 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateRead(StarVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			String sql = "UPDATE hr.STAR_T  SET READ =1 WHERE \"NO\"  =? AND  ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("평가 수정 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteRead(StarVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			String sql = "UPDATE hr.STAR_T  SET READ =0 WHERE \"NO\"  =? AND  ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("평가 수정 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int one(StarVO bag) {
		ResultSet rs = null; // 항목명이랑 결과를 담고 있는 테이블이다.
		int read = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			String sql = "select READ from hr.STAR_T WHERE ID = ? AND \"NO\"  =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setInt(2, bag.getNo());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) { // 검색결과가 있으면 TRUE 없으면 false
				System.out.println("검색결과 있음 성공!");
				read = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}
	
	public int check(StarVO bag) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		int check = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			String sql = "select * from hr.STAR_T where \"NO\" =? and id =?";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");
			// result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				System.out.println("검색결과 있음. 이미테이블 존재.");
				// 검색결과가 있으면 check를 1로 변환!
				check = 1;
			} else {
				System.out.println("검색결과 없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public int star(StarVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "update hr.STAR_T set pick=0 where \"NO\" =? and id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			
			if (result == 1) {
				System.out.println("찜 삭제 성공!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<StarVO> list(String id) {

		ResultSet rs = null; // 항목명이랑 결과를 담고 있는 테이블이다.
		StarVO bag = new StarVO();

		ArrayList<StarVO> list = new ArrayList<>();

		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "select * from hr.STAR_T where pick = 1 and id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			rs = ps.executeQuery();

			System.out.println("4. SQL문 오라클로 보내기 성공.");

			while (rs.next()) { // 검색결과가 있으면 TRUE 없으면 false
				//System.out.println("검색결과 있음 성공!");
				int no = rs.getInt(1);
				String id2 = rs.getString("ID");

				bag = new StarVO();
				bag.setNo(no);
				bag.setId(id2);

				list.add(bag);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int delete(StarVO bag) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "delete from hr.STAR_T where ID =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			
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

	
}
