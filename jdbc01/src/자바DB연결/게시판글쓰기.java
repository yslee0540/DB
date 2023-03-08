package 자바DB연결;

import java.util.Scanner;

public class 게시판글쓰기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("no/title/content/writer 순으로 입력");
		String no = sc.next();
		String title = sc.next();
		String content = sc.next();
		String writer = sc.next();
		
		BbsDAO dao = new BbsDAO();
		dao.insert(no, title, content, writer);

	}

}
