package 자바DB연결;

import java.util.Scanner;

public class 게시판수정하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("no/content 순으로 입력");
		String no = sc.next();
		String content = sc.next();
		
		BbsDAO dao = new BbsDAO();
		dao.update(no, content);
	}

}
