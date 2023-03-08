package 자바DB연결;

import java.util.Scanner;

public class 회원정보 {

	public static void main(String[] args) {
		//Scanner로 입력
		Scanner sc = new Scanner(System.in);
		MemberDAO2 dao = new MemberDAO2();
		System.out.println("1)회원가입 2)회원탈퇴 3)회원정보수정");
		int num = sc.nextInt();
		
		if (num == 1) {
			System.out.println("id/pw/name/tel 순으로 입력");
			String id = sc.next();
			String pw = sc.next();
			String name = sc.next();
			String tel = sc.next();
			dao.insert(id, pw, name, tel);
		} else if (num == 2) {
			System.out.println("탈퇴할 id 입력");
			String id = sc.next();
			dao.delete(id);
		} else if (num == 3) {
			System.out.println("id/tel 순으로 입력");
			String id = sc.next();
			String tel = sc.next();
			dao.update(id, tel);
		}

	}

}
