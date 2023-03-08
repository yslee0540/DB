package 자바DB연결;

import java.util.Scanner;

public class 게시판삭제하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 no 입력");
		String no = sc.next();
		
		BbsDAO dao = new BbsDAO();
		dao.delete(no);
		
	}

}
