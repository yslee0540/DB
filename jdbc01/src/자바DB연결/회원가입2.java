package 자바DB연결;

import java.util.Scanner;

public class 회원가입2 {

	public static void main(String[] args) {
		//Scanner로 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("id/pw/name/tel 순으로 입력");
		String id = sc.next();
		String pw = sc.next();
		String name = sc.next();
		String tel = sc.next();
		
		//MemberDAO2 연결
		MemberDAO2 dao = new MemberDAO2();
		//insert 메서드 사용
		dao.insert(id, pw, name, tel);

	}

}
