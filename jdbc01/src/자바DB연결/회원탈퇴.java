package 자바DB연결;

import java.util.Scanner;

public class 회원탈퇴 {

	public static void main(String[] args) {
		//Scanner로 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("탈퇴할 id 입력");
		String id = sc.next();
		
		MemberDAO2 dao = new MemberDAO2();
		dao.delete(id);

	}

}
