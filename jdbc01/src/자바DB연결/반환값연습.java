package 자바DB연결;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class 반환값연습 {
	// 기능을 처리하기 위해 만든 부품
	public void add2() {
		System.out.println("더하기 기능을 수행합니다.");
	}

	public int add(int x, int y) {
		return x + y;
	}

	public double add(double x, int y) {
		return x + y;
	}

	public String add(String x, String y) {
		return x + y;
	}

	public String add(int x, String y) {
		return x + y;
	}

	public int[] add() {
		int[] x = { 1, 2, 3 };
		return x;
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}

	public Random getRandom() {
		Random r = new Random();
		return r;
	}

	public int getRandom2() {
		Random r = new Random();
		return r.nextInt();
	}

	public int getHour() {
		Date date = new Date();
		return date.getHours();
	}

	public ArrayList getList() {
		ArrayList list = new ArrayList();
		list.add("감자");
		list.add("고구마");
		return list;
	}

	public HashSet getSet() {
		HashSet bag = new HashSet();
		bag.add("휴지");
		bag.add("펜");
		return bag;
	}
	
//	public Connection geConnection(String url, String user, String password) {
//		Connection con = 연결처리하는 커넥션;
//		return con;
//	}
}
